/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;


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
        spelbord[0][0] = new HoekKaart(null, Kleur.GE, "or");
        spelbord[0][6] = new HoekKaart(null, Kleur.B, "ol");
        spelbord[6][0] = new HoekKaart(null, Kleur.GR, "br");
        spelbord[6][6] = new HoekKaart(null, Kleur.R, "bl");
        
        spelbord[2][0] = new Tkaart(Schat.HAGEDIS, "r");
        spelbord[4][0] = new Tkaart(Schat.MOT, "r");
        spelbord[0][2] = new Tkaart(Schat.UIL, "o");
        spelbord[2][2] = new Tkaart(Schat.RAT, "r");
        spelbord[4][2] = new Tkaart(Schat.SCARABEE, "b");
        spelbord[6][2] = new Tkaart(Schat.SLEUTELS, "b");
        spelbord[0][4] = new Tkaart(Schat.SCHEDEL, "o");
        spelbord[2][4] = new Tkaart(Schat.TOVENARES, "o");
        spelbord[4][4] = new Tkaart(Schat.SPIN, "l");
        spelbord[6][4] = new Tkaart(Schat.ZWAARD, "b");
        spelbord[2][6] = new Tkaart(Schat.SCHATKIST, "l");
        spelbord[4][6] = new Tkaart(Schat.SCHATKAART, "l");
        
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
        else if(spelbord[0][6].getKleur().equals(kleur))
        {
            spelbord[0][6].addSpeler(speler);
        } 
        else if(spelbord[6][0].getKleur().equals(kleur))
        {
            spelbord[6][0].addSpeler(speler);
        }
        else if (spelbord[6][6].getKleur().equals(kleur))
        {
            spelbord[6][6].addSpeler(speler);
        }
        else
        {
            throw new IllegalArgumentException("De speler moet geel, groen, blauw of rood als kleur hebben");
        }
        
    }
    
    public void voegGangKaartToe (int xPositie, int yPositie, Gangkaart gk)
    {
        spelbord[xPositie][yPositie] = gk;
    }
}
