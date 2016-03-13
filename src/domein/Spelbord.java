/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.EnumSet;
import utils.EnumKleur;

/**
 *
 * @author anjana
 */
public class Spelbord 
{
    
    
    private Gangkaart[][] spelbord = new Gangkaart[6][6];
    
    /**
     * 
     */
    public Spelbord()
    {
        EnumKleur kl;
        spelbord[0][0] = new HoekKaart(null, "Geel", null);
        spelbord[0][6] = new HoekKaart(null, "Blauw", null);
        spelbord[6][0] = new HoekKaart(null, "rood", null);
        spelbord[6][6] = new HoekKaart(null, "groen", null);
        
        spelbord[2][0] = new Tkaart(null, "o");//onder
        spelbord[4][0] = new Tkaart(null, "o");
        spelbord[0][2] = new Tkaart(null, "r");//rechts
        spelbord[2][2] = new Tkaart(null, "r");
        spelbord[4][2] = new Tkaart(null, "o");
        spelbord[6][2] = new Tkaart(null, "l");//links
        spelbord[0][4] = new Tkaart(null, "r");
        spelbord[2][4] = new Tkaart(null, "b");//boven
        spelbord[4][4] = new Tkaart(null, "l");
        spelbord[6][4] = new Tkaart(null, "l");
        spelbord[2][6] = new Tkaart(null, "b");
        spelbord[4][6] = new Tkaart(null, "b");
        
    }
    
    /**
     *
     * @return
     */
    public Gangkaart[][] geefSpelbord()
    {
        return spelbord;
    }
    
    public void zetSpelerOpHoekKaart(String kleur, Speler speler)
    {
        if (spelbord[0][0].getKleur().toUpperCase().equals(kleur.toUpperCase()))
        {
            spelbord[0][0].addSpeler(speler);
        } 
        else 
        {
            if(spelbord[0][6].getKleur().toUpperCase().equals(kleur.toUpperCase()))
            {
                spelbord[0][6].addSpeler(speler);
            } 
            else 
            {
                if(spelbord[6][0].getKleur().toUpperCase().equals(kleur.toUpperCase()))
                {
                    spelbord[6][0].addSpeler(speler);
                }
                else
                {
                    if (spelbord[6][6].getKleur().toUpperCase().equals(kleur.toUpperCase()))
                    {
                        spelbord[6][6].addSpeler(speler);
                    }
                    else
                    {
                        throw new IllegalArgumentException("D speler moet geel, groen, blauw of rood als kleur hebben");
                    }
                }
            }
        }
        
    }
    
    public void voegGangKaartToe (int xPositie, int yPositie, Gangkaart gk)
    {
        spelbord[xPositie][yPositie] = gk;
    }
}
