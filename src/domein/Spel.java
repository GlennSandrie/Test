/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.InvalidCoordinateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ui.UC4;
import utils.Kleur;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Spel
{

    //attributen

    private List<Speler> spelers = new ArrayList<>();
    private String naam;
    private Spelbord sb;
    private List<Gangkaart> losseKaarten = new ArrayList<>();
    private Gangkaart gk;
    private List<Doelkaart> doelkaarten = new ArrayList<>();
    private Kleur kleuren;
    private Speler huidigeSpeler;

    /**
     * constructor
     *
     * @param naam
     */
    public Spel(String naam)
    {
        this.naam = naam;
        sb = new Spelbord();
    }

    //controles + getters + setters
    /**
     *
     * @return
     */
    public String getNaam()
    {
        return naam;
    }

    public void setNaam(String naam)
    {
        this.naam = naam;
    }

    //methodes
    /**
     *
     */
    public void initialiseerVolledigSpel()
    {
        maakGangkaartenEnPlaatsOpSpelbord();
        plaatsSpelersOpStartPositie();
        maakDoelkaartenEnVerdeelOnderSpelers();
        bepaalSpelerAanDeBeurt();
    }

    /**
     *
     */
    public void maakGangkaartenEnPlaatsOpSpelbord()
    {
        /**
         * kaarten die niet vast staan op het spelbord
         */
        Random r = new Random();
        for (int i = 0; i < 10; i++)
        {
            int random = r.nextInt(4);
            HoekKaart hk;
            switch (random)
            {
                case 0:
                    hk = new HoekKaart("ol");
                    break;
                case 1:
                    hk = new HoekKaart("or");
                    break;
                case 2:
                    hk = new HoekKaart("bl");
                    break;
                default:
                    hk = new HoekKaart("br");
            }
            losseKaarten.add(hk);
        }
        for (int i = 0; i < 12; i++)
        {
            int random = r.nextInt(2);
            RechteWegKaart rwk;
            switch (random)
            {
                case 0:
                    rwk = new RechteWegKaart("h");
                    break;
                default:
                    rwk = new RechteWegKaart("v");
            }

            losseKaarten.add(rwk);
        }

        for (int i = 0; i < 6; i++)
        {
            int random = r.nextInt(4);
            HoekKaart hk;
            for (Schat schat : Schat.values())
            {
                if (schat.getSchatId() == i + 1)
                {
                    switch (random)
                    {
                        case 0:
                            hk = new HoekKaart(schat, "ol");
                            break;
                        case 1:
                            hk = new HoekKaart(schat, "or");
                            break;
                        case 2:
                            hk = new HoekKaart(schat, "bl");
                            break;
                        default:
                            hk = new HoekKaart(schat, "br");
                    }
                    losseKaarten.add(hk);
                }
            }
        }

        for (int i = 0; i < 6; i++)
        {
            int random = r.nextInt(4);
            Tkaart tk;
            for (Schat schat : Schat.values())
            {
                if (schat.getSchatId() == i + 1)
                {
                    switch (random)
                    {
                        case 0:
                            tk = new Tkaart(schat, "o");
                            break;
                        case 1:
                            tk = new Tkaart(schat, "b");
                            break;
                        case 2:
                            tk = new Tkaart(schat, "l");
                            break;
                        default:
                            tk = new Tkaart(schat, "r");
                    }
                    losseKaarten.add(tk);
                }
            }
        }

        schudLosseKaarten();
        plaatsLosseKaartenOpSpelbord();
    }

    public void plaatsSpelersOpStartPositie()
    {
        Kleur kleurSpeler;
        for (int i = 0; i < spelers.size(); i++)
        {
            kleurSpeler = spelers.get(i).getKleur();
            sb.zetSpelerOpHoekKaart(kleurSpeler, spelers.get(i));
        }
    }

    public void bepaalSpelerAanDeBeurt()
    {
        int hoogsteGeboortejaar = spelers.get(0).getGeboortejaar();
        String naam = spelers.get(0).getNaam();
        int index = 0;
        for (int i = 0; i < spelers.size(); i++)
        {
            if (spelers.get(i).getGeboortejaar() > hoogsteGeboortejaar)
            {
                hoogsteGeboortejaar = spelers.get(i).getGeboortejaar();
                naam = spelers.get(i).getNaam();
                index = i;
            }
            if (spelers.get(i).getGeboortejaar() == hoogsteGeboortejaar && spelers.get(i).getNaam().toLowerCase().compareTo(naam.toLowerCase()) < 0)
            {
                hoogsteGeboortejaar = spelers.get(i).getGeboortejaar();
                naam = spelers.get(i).getNaam();
                index = i;
            }
        }
        this.huidigeSpeler = spelers.get(index);
    }

//    
    public void schudLosseKaarten()
    {
        Collections.shuffle(losseKaarten);
    }

    public void plaatsLosseKaartenOpSpelbord()
    {
        int index = 0;
        for (int i = 1; i < 8; i++)
        {
            for (int j = 1; j < 8; j++)
            {
                if (!(i % 2 != 0 && j % 2 != 0))
                {
                    sb.voegGangKaartToe(i, j, losseKaarten.get(index));
                    index++;
                }
            }
        }
    }

    public void maakDoelkaartenEnVerdeelOnderSpelers()
    {
        for (int i = 0; i < 24; i++)
        {
            doelkaarten.add(new Doelkaart(Schat.values()[i]));
        }
        schudDoelkaarten();
        for (Speler speler : spelers)
        {
            for (int i = 0; i < (doelkaarten.size() / spelers.size()); i++)
            {
                speler.voegDoelkaartToe(doelkaarten.get(i));
                doelkaarten.remove(i);
            }
        }
    }

    public void schudDoelkaarten()
    {
        Collections.shuffle(doelkaarten);
    }

    public String[][] geefSpel()
    {
        /* String[][] spel = new String[7][7];
         Gangkaart[][] spelbord = sb.geefSpelbord();
         for (int i = 0; i < 7; i++)
         {
         for (int j = 0; j < 7; j++)
         {
         spel[i][j]=spelbord[i][j].toString();
         }
         }
         return spel;*/
        /*aanpassingen Glenn*/
        String[][] spel = new String[8][8];
        Gangkaart[][] spelbord = sb.geefSpelbord();
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                spel[i][j] = spelbord[i][j].toString();
            }
        }
        return spel;
    }

    public Speler geefHuidigeSpeler()
    {
        return huidigeSpeler;
    }

    public String[] geefDoelkaartenVanSpeler(String naam)
    {
        for (Speler s : spelers)
        {
            if (s.getNaam().equals(naam))
            {
                return s.geefDoelkaartenVanSpeler();
            }
        }
        String[] leeg =
        {
            "", ""
        };
        return leeg;
    }

    public String geefLosseKaart()
    {
        return losseKaarten.get(losseKaarten.size() - 1).toString();
    }

    public Gangkaart bepaalTypeLosseKaart()
    {
        return losseKaarten.get(losseKaarten.size() - 1);
    }

    public void voegSpelerToe(Speler nieuweSpeler)
    {
        controleerKleur(nieuweSpeler.getKleur());
        spelers.add(nieuweSpeler);
    }

    private void controleerKleur(Kleur kleur)
    {
        if (!spelers.isEmpty())
        {
            for (int i = 0; i < spelers.size(); i++)
            {
                if (spelers.get(i).getKleur() == kleur)
                {
                    throw new IllegalArgumentException("kleurBestaat");
                }
            }
        }
    }

    public Speler bepaalVolgendeSpelerAanDeBeurt()
    {
        int volgende = 0, i = 0;
        for (Speler s : spelers)
        {
            bepaalSpelerAanDeBeurt();
            //  System.out.printf("%s\t%d\t%s%n", spelers.get(i).getNaam(), spelers.get(i).getGeboortejaar(), spelers.get(i).getKleur());
            if ((huidigeSpeler.getNaam()).equals(s.getNaam()))
            {
                if (i == spelers.size() - 1)
                {
                    volgende = 0;
                } else
                {
                    volgende = i + 1;
                }
            }
            i++;
        }
        huidigeSpeler = spelers.get(volgende);
        return huidigeSpeler;
    }

    public void geefPlaatsVrijeGangkaartIn(int xPositie, int yPositie, DomeinController dc, Scanner input)
    {
//        String coord;
//        boolean verder = true;
//        while (verder != false)
//        {
//            try
//            {
//
//                System.out.println(dc.getTaal().getText("inschuivenKaart"));
//                coord = input.nextLine();
//                if (!(coord.equalsIgnoreCase("B1") || coord.equalsIgnoreCase("D1") || coord.equalsIgnoreCase("F1")
//                        || coord.equalsIgnoreCase("A2") || coord.equalsIgnoreCase("A4") || coord.equalsIgnoreCase("A6")
//                        || coord.equalsIgnoreCase("G2") || coord.equalsIgnoreCase("G4") || coord.equalsIgnoreCase("G6")
//                        || coord.equalsIgnoreCase("B7") || coord.equalsIgnoreCase("D7") || coord.equalsIgnoreCase("F1")))
//                {
//                    throw new InvalidCoordinateException("fouteCoordinaat");
//                } else
//                {
//                    UC4.draaiVrijeGangkaart(dc, null);
//                    verder=false;
//                }
//            } catch (InvalidCoordinateException e)
//            {
//                System.out.println(dc.getTaal().getText("fouteCoordinaat"));
//            } catch (InputMismatchException e)
//            {
//                System.out.println(dc.getTaal().getText("fouteCoordinaat"));
//            }
//        }

    }
}
