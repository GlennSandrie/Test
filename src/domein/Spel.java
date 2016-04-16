/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

//import exceptions.InvalidCoordinateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ui.UC4;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Spel
{

    //attributen
    private final List<Speler> spelers = new ArrayList<>();
    private String naam;
    private final Spelbord sb;
    private final List<Gangkaart> losseKaarten = new ArrayList<>();
    private Gangkaart gk;
    private final List<Doelkaart> doelkaarten = new ArrayList<>();
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
        Richting[] richtingen;
        for (int i = 0; i < 10; i++)
        {
            int random = r.nextInt(4);
            HoekKaart hk;
            richtingen = new Richting[2];
            switch(random) {
                case 0: richtingen[0] = Richting.O;
                    richtingen[1] = Richting.L;
                    break;
                case 1: richtingen[0] = Richting.O;
                    richtingen[1] = Richting.R;
                    break;
                case 2: richtingen[0] = Richting.B;
                    richtingen[1] = Richting.L;
                    break;
                default: richtingen[0] = Richting.B;
                    richtingen[1] = Richting.R;
            }
            hk = new HoekKaart(richtingen);
            losseKaarten.add(hk);
        }
        for (int i = 0; i < 12; i++)
        {
            int random = r.nextInt(2);
            RechteWegKaart rwk;
            richtingen = new Richting[2];
            switch(random) {
                case 0: richtingen[0] = Richting.R;
                    richtingen[1] = Richting.L;
                    break;
                default: richtingen[0] = Richting.B;
                    richtingen[1] = Richting.O;
            }
            rwk = new RechteWegKaart(richtingen);
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
                    richtingen = new Richting[2];
                    switch(random) {
                        case 0: richtingen[0] = Richting.O;
                            richtingen[1] = Richting.L;
                            break;
                        case 1: richtingen[0] = Richting.O;
                            richtingen[1] = Richting.R;
                            break;
                        case 2: richtingen[0] = Richting.B;
                            richtingen[1] = Richting.L;
                            break;
                        default: richtingen[0] = Richting.B;
                            richtingen[1] = Richting.R;
                    }
                    hk = new HoekKaart(schat,richtingen);
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
                    richtingen = new Richting[3];
                    switch(random) {
                        case 0: richtingen[0] = Richting.O;
                            richtingen[1] = Richting.L;
                            richtingen[2] = Richting.R;
                            break;
                        case 1: richtingen[0] = Richting.R;
                            richtingen[1] = Richting.O;
                            richtingen[2] = Richting.B;
                            break;
                        case 2: richtingen[0] = Richting.B;
                            richtingen[1] = Richting.R;
                            richtingen[2] = Richting.L;
                            break;
                        default: richtingen[0] = Richting.L;
                            richtingen[1] = Richting.B;
                            richtingen[2] = Richting.O;
                    }
                tk = new Tkaart(schat,richtingen);
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
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (i % 2!= 0 || j % 2 != 0)
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
        String[][] spel = new String[7][7];
        Gangkaart[][] spelbord = sb.geefSpelbord();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
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

    public String geefPlaatsVrijeGangkaartIn()
    {
        return null;
        
    }
    
    public String[] geefVerplaatsRichtingen()
    {
        return sb.geefVerplaatsRichtingen(huidigeSpeler);
    }

}
