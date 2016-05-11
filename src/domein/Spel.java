/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.EmptyListException;
import exceptions.InvalidCoordinateException;
import exceptions.InvalidNameException;
import exceptions.WrongInputException;
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

    private final List<Speler> spelers = new ArrayList<>();
    private String naam;
    private final Spelbord sb;
    private final List<Gangkaart> losseKaarten = new ArrayList<>();
    private Gangkaart vrijeGangkaart;
    private final List<Doelkaart> doelkaarten = new ArrayList<>();
    private Speler huidigeSpeler;
    
    public Spel()
    {
        sb = new Spelbord();
    }
    /**
     * constructor, initialiseert de naam van het spel en maakt een nieuw
     * spelbord en een nieuwe spelrepository aan
     *
     * @param naam naam moet minstens 8 alfanummerieke tekens zijn, met exact 2
     * cijfers
     */
    public Spel(String naam)
    {
        controleerSpelNaam(naam);
        this.naam = naam;
        sb = new Spelbord();
    }

    public Spel(String naam, String spelbordCode)
    {
        this.naam = naam;
        controleerSpelNaam(naam);
        sb = new Spelbord(spelbordCode);
        if(spelbordCode.charAt(spelbordCode.length()-3)=='H'||spelbordCode.charAt(spelbordCode.length()-3)=='R'||spelbordCode.charAt(spelbordCode.length()-3)=='T')
            vrijeGangkaart = zetCodeOmNaarKaart(spelbordCode.substring(spelbordCode.length()-3,spelbordCode.length()));
        else
            vrijeGangkaart = zetCodeOmNaarKaart(spelbordCode.substring(spelbordCode.length()-4,spelbordCode.length()));
    }

    /**
     * methode die de naam geeft
     *
     * @return naam van het spel, moet minstens 8 alfanummerieke tekens zijn,
     * met exact 2 cijfers
     */
    public String getNaam()
    {
        return naam;
    }

    /**
     * stelt de naam van het spel in
     *
     * @param naam naam is minstens 8 alfanummerieke tekens, met exact 2 cijfers
     */
    public void setNaam(String naam)
    {
        controleerSpelNaam(naam);
        this.naam = naam;
    }

    /**
     * methode die de vrijegangkaart geeft
     *
     * @return vrijeGangkaart
     */
    public Gangkaart getVrijeGangkaart()
    {
        return vrijeGangkaart;
    }

    /**
     * methode om de vrijeGangkaart in te stellen
     *
     * @param vrijeGangkaart
     */
    public void setVrijeGangkaart(Gangkaart vrijeGangkaart)
    {
        this.vrijeGangkaart = vrijeGangkaart;
    }
    
    //UC2
    /**
     * methode die de spelnaam controleert (minimum 8 karakters waarvan exact 2
     * cijfers
     *
     * @param naam
     * @return true of false, afhankelijk of de reguliere expressie klopt
     */
    private boolean controleerSpelNaam(String naam)
    {
        if (!(naam.matches("(?=.*\\d.*\\d)[a-zA-Z0-9]{6,}")))
        {
            throw new InvalidNameException("fouteSpelnaam");
        }
        return true;
    }

    /**
     * initialiseert het volledig spel door de gangkaarten te maken en op het
     * spelbord te plaatesn, de spelers op de startpositie te plaatsen, de
     * doelkaarten te maken en te verdelen, de speler aan de beurt te bepalen
     */
    public void initialiseerVolledigSpel()
    {
        maakGangkaartenEnPlaatsOpSpelbord();
        plaatsSpelersOpStartPositie();
        maakDoelkaartenEnVerdeelOnderSpelers();
        bepaalSpelerAanDeBeurt();
    }

    /**
     * gangkaarten die niet vastliggen op het spelbord, worden geschud en op het
     * spelbord geplaatst
     */
    public void maakGangkaartenEnPlaatsOpSpelbord()
    {
        //kaarten die niet vast staan op het spelbord

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
                if (schat.getSchatId() == i + 7)
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

    /**
     * plaatst de spelers a.d.h.v. hun kleur op hun startpositie
     */
    public void plaatsSpelersOpStartPositie()
    {
        Kleur kleurSpeler;
        for (int i = 0; i < spelers.size(); i++)
        {
            kleurSpeler = spelers.get(i).getKleur();
            sb.zetSpelerOpHoekKaart(kleurSpeler, spelers.get(i));
        }
    }

    /**
     * bepaal de eerste speler aan de beurt
     */
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

    /**
     * schud de losse gangkaarten
     */
    public void schudLosseKaarten()
    {
        Collections.shuffle(losseKaarten);
    }

    /**
     * plaatst de losse gangkaarten op het spelbord (wordt aangeroepen door
     * maakGangkaartenEnPlaatsOpSpelbord)
     */
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

    /**
     * maakt doelkaarten met een schat en verdeelt die onder de spelers
     */
    public void maakDoelkaartenEnVerdeelOnderSpelers()
    {
        for (int i = 0; i < 24; i++)
        {
            doelkaarten.add(new Doelkaart(Schat.values()[i]));
        }
        schudDoelkaarten();
        for (Speler speler : spelers)
        {
            for (int i = 0; i < (24 / spelers.size()); i++)
            {
                speler.voegDoelkaartToe(doelkaarten.get(doelkaarten.size()-1));
                doelkaarten.remove(doelkaarten.size()-1);
            }
        }
    }

    /**
     * schud de 24 doelkaarten
     */
    public void schudDoelkaarten()
    {
        Collections.shuffle(doelkaarten);
    }

    /**
     * overloopt het spel en maakt er een String van
     *
     * @return spel
     */
    public String[][] geefSpelbord()
    {
        String[][] spel = new String[7][7];
        Gangkaart[][] spelbord = sb.getSpelbord();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                spel[i][j] = spelbord[i][j].toString();
            }
        }
        return spel;
    }

    /**
     * methode die de huidige speler teruggeeft
     *
     * @return huidige speler
     */
    public Speler geefHuidigeSpeler()
    {
        return huidigeSpeler;
    }

    /**
     * geeft de huidige doelkaart (te zoeken schat) van de speler aan de beurt
     *
     * @return huidige doelkaart van de huidige speler
     * @throws EmptyListException als de doelkaarten op zijn
     */
    public String geefDoelkaartVanSpeler() throws EmptyListException
    {
        return huidigeSpeler.geefSchatHuidigeDoelkaart().getNaam();
    }

    /**
     * methode die de vrije gangkaart als een String teruggeeft
     *
     * @return vrijeGangkaart
     */
    public String geefVrijeGangkaart()
    {
        return vrijeGangkaart.toString();
    }

    /**
     * controleert of de kleur al toegekend is aan een andere speler, ander
     * krijgt de nieuweSpeler de kleur
     *
     * @param nieuweSpeler
     */
    public void voegSpelerToe(Speler nieuweSpeler)
    {
        controleerKleur(nieuweSpeler.getKleur());
        spelers.add(nieuweSpeler);
    }
    
    /**
     * controleert of de kleur al ingenomen is door een speler
     *
     * @param kleur
     */
    private void controleerKleur(Kleur kleur)
    {
        if (!spelers.isEmpty())
        {
            for (Speler speler : spelers)
            {
                if (speler.getKleur() == kleur)
                {
                    throw new WrongInputException("kleurBestaat");
                }
            }
        }
    }
    
    //UC4

    /**
     * kies de plaats waar je de gangkaart wilt inschuiven
     *
     * @param xPositie x coordinaat van de gangkaart (0-6)
     * @param yPositie y coordinaat van de gangkaart (0-6)
     * @throws exceptions.InvalidCoordinateException
     */
    public void geefPlaatsVrijeGangkaartIn(int xPositie, int yPositie) throws InvalidCoordinateException
    {
        vrijeGangkaart = sb.geefPlaatsVrijeGangkaartIn(xPositie, yPositie, vrijeGangkaart);

    }

    /**
     * methode die de richting van de vrije gangkaart bepaalt
     *
     * @param keuze
     * @return gekozen richting van de vrijeGangkaart
     */
    public Richting draaiVrijeGangkaart(int keuze)
    {
        vrijeGangkaart.draaiVrijeGangkaart(keuze);
        return vrijeGangkaart.richting;

    }

    //UC3 --> roept UC4 aan
    /**
     * bepaalt de volgende speler aan de beurt aan de hand van de huidige speler
     */
    public void bepaalVolgendeSpelerAanDeBeurt()
    {

        int volgende = 0, i = 0;
        for (Speler s : spelers)
        {
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

    /**
     * methode die een lijst van mogelijke richtingen waarin je je kan
     * verplaatsen vraagt aan Spelbord
     *
     * @return lijst van de mogelijke richtingen waarin de speler zich kan
     * verplaatsen
     */
    public List<String> geefMogelijkeVerplaatsRichtingen()
    {
        return sb.geefMogelijkeVerplaatsRichtingen(huidigeSpeler);
    }

    /**
     * methode die aan Spelbord vraagt om de speler te verplaatsen op een
     * bepaalde x en y coordinaat
     *
     * @param xPositie x coordinaat op het spelbord (0-6)
     * @param yPositie y coordinaat op het spelbord (0-6)
     */
    public void verplaatsSpeler(int xPositie, int yPositie)
    {
        sb.verplaatsSpeler(xPositie, yPositie, huidigeSpeler);
    }

    /**
     *
     * @return coordinaten van de huidige gangkaart waar de speler zich op
     * bevindt
     */
    public int[] geefIndexenHuidigeGangkaart()
    {
        return sb.geefIndexenHuidigeGangkaart(huidigeSpeler);
    }

    /**
     * methode die de Schat op de gangkaart vergelijkt met de te zoeken schat
     * van de huidige speler
     *
     * @return true of false, naargelang de schat van de huidige gangkaart
     * overeen komt met de te zoeken schat van de huidige speler
     * @throws EmptyListException als alle schatten gevonden zijn
     */
    public boolean controleerOvereenkomendeSchat() throws EmptyListException
    {
        return sb.geefSchatHuidigeGangkaart(huidigeSpeler) == huidigeSpeler.geefSchatHuidigeDoelkaart();
    }

    /**
     * verwijdert de huidige doelkaart als de schat gevonden is
     */
    public void verwijderHuidigeDoelkaart()
    {
        huidigeSpeler.verwijderHuidigeDoelkaart();
    }

    /**
     * methode die het spelbord en de vrije gangkaart doorgeeft aan de
     * spelrepository
     *
     * @return
     */
    public String geefCodeSpelbord()
    {
        return sb.geefCodeSpelbord() + vrijeGangkaart.geefCodeGangkaart();
    }

    
    public List<String> getSpelernamen()
    {
        List<String> spelernamen = new ArrayList<>();
        for(Speler s : spelers)
        {
            spelernamen.add(s.getNaam());
        }
        return spelernamen;
    }
    //UC7
    
    private Gangkaart zetCodeOmNaarKaart(String substring)
    {
        System.out.println(substring);
        Gangkaart gk = null;
        if(substring.length()==3)
        {
            switch(substring.charAt(0))
            {
                case 'H': gk = new HoekKaart(Schat.geefSchat(substring.charAt(2)), Richting.geefRichting(substring.charAt(1)));
                    break;
                case 'R': gk = new RechteWegKaart(Richting.geefRichting(substring.charAt(1)));
                    break;
                case 'T': gk = new Tkaart(Schat.geefSchat(substring.charAt(2)), Richting.geefRichting(substring.charAt(1)));
                    break;
            } 
        }
        else
        {
            switch(substring.charAt(0))
            {
                case 'H': gk = new HoekKaart(Schat.geefSchat(Integer.parseInt(substring.substring(2,3))), Richting.geefRichting(substring.charAt(1)));
                    break;
                case 'R': gk = new RechteWegKaart(Richting.geefRichting(substring.charAt(1)));
                    break;
                case 'T': gk = new Tkaart(Schat.geefSchat(Integer.parseInt(substring.substring(2,3))), Richting.geefRichting(substring.charAt(1)));
                    break;
            }
        }
        return gk;
    }

    public void initialiseerVolledigBestaandSpel(String[][] gegSpelers)
    {
        for(String[] speler : gegSpelers)
        {
            for(Speler s : spelers)
            {
                if(s.getNaam().equals(speler[0]))
                {
                    sb.zetSpelerOpPositie(Integer.parseInt(speler[1]), Integer.parseInt(speler[2]), s);
                    if(speler[3].equals("0"))
                    {
                        huidigeSpeler = s;
                    }
                    s.zetCodeOmNaarDoelkaarten(speler[4]);
                }
            }
        }
    }
    
}
