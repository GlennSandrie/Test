/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

//import exceptions.InvalidCoordinateException;
import exceptions.EmptyListException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
    private Gangkaart vrijeGangkaart;
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

    public Gangkaart getVrijeGangkaart()
    {
        return vrijeGangkaart;
    }

    //UC2
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
            int random = r.nextInt(4) + 1;
            HoekKaart hk = new HoekKaart(Richting.geefRichting(random));
            losseKaarten.add(hk);
        }
        for (int i = 0; i < 12; i++)
        {
            int random = r.nextInt(4) + 1;
            RechteWegKaart rwk = new RechteWegKaart(Richting.geefRichting(random));
            losseKaarten.add(rwk);
        }

        for (int i = 0; i < 6; i++)
        {
            int random = r.nextInt(4) + 1;
            HoekKaart hk;
            for (Schat schat : Schat.values())
            {
                if (schat.getSchatId() == i + 1)
                {
                    hk = new HoekKaart(schat, Richting.geefRichting(random));
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
                    tk = new Tkaart(schat, Richting.geefRichting(random));
                    losseKaarten.add(tk);
                }
            }
        }

        schudLosseKaarten();
        plaatsLosseKaartenOpSpelbord();
        vrijeGangkaart = losseKaarten.get(losseKaarten.size() - 1);
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
        String naamSpeler = spelers.get(0).getNaam();
        int index = 0;
        for (int i = 0; i < spelers.size(); i++)
        {
            if (spelers.get(i).getGeboortejaar() > hoogsteGeboortejaar)
            {
                hoogsteGeboortejaar = spelers.get(i).getGeboortejaar();
                naamSpeler = spelers.get(i).getNaam();
                index = i;
            }
            if (spelers.get(i).getGeboortejaar() == hoogsteGeboortejaar && spelers.get(i).getNaam().toLowerCase().compareTo(naamSpeler.toLowerCase()) < 0)
            {
                hoogsteGeboortejaar = spelers.get(i).getGeboortejaar();
                naamSpeler = spelers.get(i).getNaam();
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
                if (!(i % 2 == 0 && j % 2 == 0))
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

    public String geefDoelkaartVanSpeler() throws EmptyListException
    {
        return huidigeSpeler.geefSchatHuidigeDoelkaart().getNaam();
    }

    public String geefVrijeGangkaart()
    {
        return vrijeGangkaart.toString();
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
            for (Speler speler : spelers)
            {
                if (speler.getKleur() == kleur)
                {
                    throw new IllegalArgumentException("kleurBestaat");
                }
            }
        }
    }
    //UC4

    public void voegVrijeGangkaartToeAanSpelbord(int xPositie, int yPositie)
    {
        sb.setVrijeGangkaart(xPositie, yPositie,vrijeGangkaart);
    }
    
    public void geefPlaatsVrijeGangkaartIn(int xPositie, int yPositie)
    {
       sb.geefPlaatsVrijeGangkaart(xPositie, yPositie, vrijeGangkaart);
       
    }

    public Richting draaiVrijeGangkaart(int keuze)
    {
        vrijeGangkaart.draaiVrijeGangkaart(keuze);
        return vrijeGangkaart.richting;

    }
   
    //UC3 --> roept UC4 aan

   
    public void bepaalVolgendeSpelerAanDeBeurt() {

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
    }

    public List<String> geefMogelijkeVerplaatsRichtingen()
    {
        return sb.geefMogelijkeVerplaatsRichtingen(huidigeSpeler);
    }

    public void verplaatsSpeler(int xPositie, int yPositie)
    {
        sb.verplaatsSpeler(xPositie, yPositie, huidigeSpeler);
    }

    public int[] geefIndexenHuidigeGangkaart()
    {
        return sb.geefIndexenHuidigeGangkaart(huidigeSpeler);
    }

    public boolean controleerOvereenkomendeSchat() throws EmptyListException
    {
        return sb.geefSchatHuidigeGangkaart(huidigeSpeler) == huidigeSpeler.geefSchatHuidigeDoelkaart();
    }

    public void verwijderHuidigeDoelkaart()
    {
        huidigeSpeler.verwijderHuidigeDoelkaart();
    }
}
