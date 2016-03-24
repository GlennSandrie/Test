/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
        voegSpelerToe(new Speler("Aïssa",1997,Kleur.B));
        voegSpelerToe(new Speler("Anjana",1997,Kleur.GE));
        voegSpelerToe(new Speler("Lisa",1997,Kleur.GR));
        voegSpelerToe(new Speler("Glenn",1995,Kleur.R));
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
            switch(random) {
                case 0: hk = new HoekKaart("ol");
                    break;
                case 1: hk = new HoekKaart("or");
                    break;
                case 2: hk = new HoekKaart("bl");
                    break;
                default: hk = new HoekKaart("br");
            }
            losseKaarten.add(hk);
        }
        for (int i = 0; i < 12; i++)
        {
            int random = r.nextInt(2);
            RechteWegKaart rwk;
            switch(random) {
                case 0: rwk = new RechteWegKaart("h");
                    break;
                default: rwk = new RechteWegKaart("v");
            }
             
            losseKaarten.add(rwk);
        }
        
        for (int i = 0; i < 6; i++)
        {
            int random = r.nextInt(4);
            HoekKaart hk;
            for(Schat schat : Schat.values())
            {
                if(schat.getSchatId()==i+1)
                {
                    switch(random) {
                    case 0: hk = new HoekKaart(schat,"ol");
                        break;
                    case 1: hk = new HoekKaart(schat,"or");
                        break;
                    case 2: hk = new HoekKaart(schat,"bl");
                        break;
                    default: hk = new HoekKaart(schat,"br");
                }
                losseKaarten.add(hk);
                }
            }
        }
        
        for (int i = 0; i < 6; i++)
        {
            int random = r.nextInt(4);
            Tkaart tk;
            for(Schat schat : Schat.values())
            {
                if(schat.getSchatId()==i+1)
                {
                    switch(random) {
                    case 0: tk = new Tkaart(schat,"o");
                        break;
                    case 1: tk = new Tkaart(schat,"b");
                        break;
                    case 2: tk = new Tkaart(schat,"l");
                        break;
                    default: tk = new Tkaart(schat,"r");
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
        int jongste = spelers.get(0).getGeboortejaar();
        int i = 0;
        List<String> str = new ArrayList<> ();
        String naam;
        int[] res = new int[spelers.size()];
        for (int index = 0; index < spelers.size(); index++)
        {
            res[index] = spelers.get(index).getGeboortejaar();
            if (res[index] > jongste)
            {
                jongste = res[index];
                i = index;
            }
            else if(res[index] == jongste)
            {
                str.add(spelers.get(index).getNaam());
                str.add(spelers.get(i).getNaam());
                Collections.shuffle(str);
                if(str.get(i).equals(spelers.get(index).getNaam()))
                {
                    i = index;
                }
            }
        }
//        if(str.size()>1)
//        {
//            naam = geefEersteNaamInAlfabet(str);
//            for (Speler s : spelers)
//                if(s.getNaam().equals(naam))
//                    this.huidigeSpeler = s;
//        }
        this.huidigeSpeler = spelers.get(i);
    }
    
//    private String geefEersteNaamInAlfabet (List<String> namen)
//    {
//        String naamEersteSpeler="";
//        System.out.println("hello");
//        if (namen.size() == 2)
//        {
//            System.out.println("2");
//            int c = 0;
//            while (naamEersteSpeler.isEmpty())
//            {
//                if(namen.get(0).charAt(c)<namen.get(1).charAt(c))
//                    naamEersteSpeler = namen.get(0);
//                else if (namen.get(0).charAt(c)>namen.get(1).charAt(c))
//                    naamEersteSpeler = namen.get(1);
//                else
//                    c++;
//                
//            }
//        }
//        else if (namen.size() == 3)
//        {
//            System.out.println("3");
//            String eersteNaam="";
//            while (naamEersteSpeler.isEmpty())
//            {
//                while (eersteNaam.isEmpty()) {
//                    int c = 0;
//                    if(namen.get(0).charAt(c)<namen.get(1).charAt(c))
//                        eersteNaam = namen.get(0);
//                    else if (namen.get(0).charAt(c)>namen.get(1).charAt(c))
//                        eersteNaam = namen.get(1);
//                    else
//                        c++;
//                    
//                }
//                int c = 0;
//                if(eersteNaam.charAt(c)<namen.get(2).charAt(c))
//                    naamEersteSpeler = eersteNaam;
//                else if (eersteNaam.charAt(c)>namen.get(2).charAt(c))
//                    naamEersteSpeler = namen.get(2);
//                else
//                    c++;
//                
//            }
//        }
//        else
//        {
//            System.out.println("4");
//            String eersteNaam="";
//            String tweedeNaam="";
//            while (naamEersteSpeler.isEmpty())
//            {
//                while (eersteNaam.isEmpty()) {
//                    int c = 0;
//                    if(namen.get(0).charAt(c)<namen.get(1).charAt(c))
//                        eersteNaam = namen.get(0);
//                    else if (namen.get(0).charAt(c)>namen.get(1).charAt(c))
//                        eersteNaam = namen.get(1);
//                    System.out.println("eerste while");
//                }
//                while (tweedeNaam.isEmpty()) {
//                    int c=0;
//                    if(eersteNaam.charAt(c)<namen.get(2).charAt(c))
//                        tweedeNaam = eersteNaam;
//                    else if (eersteNaam.charAt(c)>namen.get(2).charAt(c))
//                        tweedeNaam = namen.get(2);
//                    System.out.println("tweede while");
//                }
//                int c = 0;
//                if(tweedeNaam.charAt(c)<namen.get(3).charAt(c))
//                    naamEersteSpeler = tweedeNaam;
//                else if (tweedeNaam.charAt(c)>namen.get(3).charAt(c))
//                    naamEersteSpeler = namen.get(3);
//                System.out.println("derde while");
//            }
//        }
//        return naamEersteSpeler;
//    }
    
    public void schudLosseKaarten()
    {
        Collections.shuffle(losseKaarten);
    }
    
    public void plaatsLosseKaartenOpSpelbord()
    {
        int index = 0;
        for(int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (i%2 != 0 || j%2 != 0)
                {
                    sb.voegGangKaartToe(i, j, losseKaarten.get(index));
                    index++;
                }
            }
        }
    }
    
    public void maakDoelkaartenEnVerdeelOnderSpelers()
    {
        for(int i = 0; i < 24; i++)
        {
            doelkaarten.add(new Doelkaart(Schat.values()[i]));
        }
        schudDoelkaarten();
        for (Speler speler : spelers)
        {
            for(int i = 0; i < (doelkaarten.size()/spelers.size()); i++)
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
                spel[i][j]=spelbord[i][j].toString();
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
                return s.geefDoelkaartenVanSpeler();    
        }
        String[] leeg = {"",""};
        return leeg;
    }
    
    public void voegSpelerToe(Speler nieuweSpeler)
    {
        controleerKleur(nieuweSpeler.getKleur());
        spelers.add(nieuweSpeler);
    }
    
    private void controleerKleur(Kleur kleur)
    {
        if(!spelers.isEmpty())
        {
            for (int i = 0; i < spelers.size(); i++)
            {
                if(spelers.get(i).getKleur()==kleur)
                    throw new IllegalArgumentException("kleurBestaat");
            }
        }
    }
    
    public Speler bepaalVolgendeSpelerAanDeBeurt()
    {
        int volgende = 0;
        for (int i = 0; i < spelers.size() - 1; i++)
        {
            if (spelers.get(i).getNaam().equals(huidigeSpeler))
            {
                volgende = i+1;
            }
        }
        huidigeSpeler = spelers.get(volgende);
        return huidigeSpeler;
    }
}
