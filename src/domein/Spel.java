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
    private String huidigeSpeler;
    
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
        plaatsSpelersOpStartPositie();
        maakDoelkaartenEnVerdeelOnderSpelers();
        //bepaalSpelerAanDeBeurt();
    }
    
    /**
     * 
     */
    public void maakGangkaartenEnPlaatsOpSpelbord()
    {
        
        /**
         * kaarten die niet vast staan op het spelbord
         */
        for (int i = 0; i < 10; i++)
        {
            HoekKaart hk = new HoekKaart(null);
            losseKaarten.add(hk);
        }
        for (int i = 0; i < 12; i++)
        {
            RechteWegKaart rwk = new RechteWegKaart(null);
            losseKaarten.add(rwk);
        }
        
        for (int i = 0; i < 6; i++)
        {
            for(Schat schat : Schat.values())
            {
                if(schat.getSchatId()==i+1)
                {
                HoekKaart hk = new HoekKaart(schat, null);
                losseKaarten.add(hk);
                }
            }
        }
        
        for (int i = 0; i < 6; i++)
        {
            for(Schat schat : Schat.values())
            {
                if(schat.getSchatId()==i+7)
                {
                Tkaart tk = new Tkaart(schat, null);
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
    
    public String bepaalSpelerAanDeBeurt()
    {
        int jongste = spelers.get(1).getGeboortejaar();
        int i = 1;
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
                List<String> str = new ArrayList<> ();
                str.add(spelers.get(index).getNaam());
                str.add(spelers.get(i).getNaam());
                Collections.shuffle(str);
                if (str.get(1).equals(spelers.get(index).getNaam()))
                {
                    i = index;
                }
            }
        }
        this.huidigeSpeler = spelers.get(i).getNaam();
        return spelers.get(i).getNaam();
    }
    
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
        for (int i = 0; i < spelbord.length; i++)
        {
            for (int j = 0; j < spelbord[i].length; j++)
            {
                spel[i][j]=spelbord[i][j].toString();
            }
        }
        return spel;
    }

    public void voegSpelerToe(Speler nieuweSpeler)
    {
        spelers.add(nieuweSpeler);
    }
    
    
    public String bepaalVolgendeSpelerAanDeBeurt()
    {
        int volgende = 0;
        for (int i = 0; i < spelers.size() - 1; i++)
        {
            if (spelers.get(i).getNaam().equals(huidigeSpeler))
            {
                volgende = i+1;
            }
        }
        huidigeSpeler = spelers.get(volgende).getNaam();
        return huidigeSpeler;
    }
}
