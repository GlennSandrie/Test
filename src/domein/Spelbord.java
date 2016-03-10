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
        
        spelbord[0][0] = new HoekKaart(null, null);
        spelbord[0][6] = new HoekKaart(null, null);
        spelbord[6][0] = new HoekKaart(null, null);
        spelbord[6][6] = new HoekKaart(null, null);
        
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
     * @param xPositie
     * @param yPositie 
     */
    public void plaatsLosseKaartenOpSpelbord(int xPositie, int yPositie)
    {
        
    }
    
    /**
     *
     * @return
     */
    public Gangkaart[][] geefSpelbord()
    {
        Gangkaart[][] spelbord = new Gangkaart[7][7];
        return spelbord;
    }
}
