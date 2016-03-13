/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.EnumKleur;

/**
 *
 * @author anjana
 */
public class Spel 
{
    //attributen
    private List<Speler> spelers;
    private String naam;
    private Spelbord sb;
    private String[] kleur;
    private List<Gangkaart> losseKaarten;
    private Gangkaart gk;
    
    /**
     * constructor
     * @param naam
     */
    public Spel(String naam) 
    {
        kleur = new String[]{"geel", "blauw", "rood", "groen"};
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
  
    //methodes

//    /**
//     *
//     * @return
//     */
//    public String[] geefNamenSpelers()
//    {
//        String[] res = new String[spelers.size()];
//        for (int index = 0; index < spelers.size(); index++)
//            res[index] = spelers.get(index).getNaam();
//        return res;
//    }
    
    /**
     * 
     */
    public void initialiseerVolledigSpel()
    {
        maakGangkaartenEnPlaatsOpSpelbord();
        plaatsSpelersOpStartPositie();
        
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
        for (int i = 0; i < 10; i++)
        {
            HoekKaart hk = new HoekKaart(null);
            losseKaarten.add(hk);
        }
        
         for (int i = 0; i < 6; i++)
        {
           HoekKaart hk = new HoekKaart(null, null);
           losseKaarten.add(hk);
        }
        
         for (int i = 0; i < 12; i++)
        {
            RechteWegKaart rwk = new RechteWegKaart(null);
            losseKaarten.add(rwk);
        }
         
          for (int i = 0; i < 6; i++)
        {
            Tkaart tk = new Tkaart(null, null);
            losseKaarten.add(tk);
        }
          
        schudLosseKaarten();
//        sb.plaatsLosseKaartenOpSpelbord(0, 0);
    }
    
    public void plaatsSpelersOpStartPositie()
    {
        String kleurSpeler;
        for (int i = 0; i < spelers.size(); i++)
        {
            kleurSpeler = spelers.get(i).getKleur().toUpperCase();
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
        return spelers.get(i).getNaam();
    }
    
    public void schudLosseKaarten()
    {
        Collections.shuffle(losseKaarten);
    }
    
    public void plaatsLosseKaartenOpSpelbord(int xPositie, int yPositie, Gangkaart gk)
    {
        sb.voegGangKaartToe(xPositie, yPositie, gk);
    }
}
