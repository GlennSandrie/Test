/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import utils.Kleur;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Spelbord 
{
    
    
    private Gangkaart[][] spelbord = new Gangkaart[7][7];
    
    /**
     * 
     */
    public Spelbord()
    {
        Kleur kl;
        spelbord[0][0] = new HoekKaart(null, Kleur.GE, null);
        spelbord[0][6] = new HoekKaart(null, Kleur.B, null);
        spelbord[6][0] = new HoekKaart(null, Kleur.GR, null);
        spelbord[6][6] = new HoekKaart(null, Kleur.R, null);
        
        spelbord[2][0] = new Tkaart(Schat.HAGEDIS, "o");//onder
        spelbord[4][0] = new Tkaart(Schat.MOT, "o");
        spelbord[0][2] = new Tkaart(Schat.UIL, "r");//rechts
        spelbord[2][2] = new Tkaart(Schat.RAT, "r");
        spelbord[4][2] = new Tkaart(Schat.SCARABEE, "o");
        spelbord[6][2] = new Tkaart(Schat.SLEUTELS, "l");//links
        spelbord[0][4] = new Tkaart(Schat.SCHEDEL, "r");
        spelbord[2][4] = new Tkaart(Schat.TOVENARES, "b");//boven
        spelbord[4][4] = new Tkaart(Schat.SPIN, "l");
        spelbord[6][4] = new Tkaart(Schat.ZWAARD, "l");
        spelbord[2][6] = new Tkaart(Schat.SCHATKIST, "b");
        spelbord[4][6] = new Tkaart(Schat.SCHATKAART, "b");
        
    }
    
    /**
     *
     * @return
     */
    public Gangkaart[][] geefSpelbord()
    {
        return spelbord;
    }
    
    public void zetSpelerOpHoekKaart(Kleur kleur, Speler speler)
    {
        if (spelbord[0][0].getKleur().equals(kleur))
        {
            spelbord[0][0].addSpeler(speler);
        } 
        else 
        {
            if(spelbord[0][6].getKleur().equals(kleur))
            {
                spelbord[0][6].addSpeler(speler);
            } 
            else 
            {
                if(spelbord[6][0].getKleur().equals(kleur))
                {
                    spelbord[6][0].addSpeler(speler);
                }
                else
                {
                    if (spelbord[6][6].getKleur().equals(kleur))
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
