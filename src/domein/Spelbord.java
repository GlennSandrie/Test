/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;


import utils.Coördinaat;
import utils.Kleur;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Spelbord 
{
    
    
    private Gangkaart[][] spelbord = new Gangkaart[8][8];
    
    /**
     * 
     */
    public Spelbord()
    {
        Kleur kl;
      
        spelbord[1][1] = new HoekKaart(null, Kleur.GE, "or");
        spelbord[1][7] = new HoekKaart(null, Kleur.B, "ol");
        spelbord[7][1] = new HoekKaart(null, Kleur.GR, "br");
        spelbord[7][7] = new HoekKaart(null, Kleur.R, "bl");
        
        spelbord[3][1] = new Tkaart(Schat.HAGEDIS, "r");
        spelbord[5][1] = new Tkaart(Schat.MOT, "r");
        spelbord[1][3] = new Tkaart(Schat.UIL, "o");
        spelbord[3][3] = new Tkaart(Schat.RAT, "r");
        spelbord[5][3] = new Tkaart(Schat.SCARABEE, "b");
        spelbord[7][3] = new Tkaart(Schat.SLEUTELS, "b");
        spelbord[1][5] = new Tkaart(Schat.SCHEDEL, "o");
        spelbord[3][5] = new Tkaart(Schat.TOVENARES, "o");
        spelbord[5][5] = new Tkaart(Schat.SPIN, "l");
        spelbord[7][5] = new Tkaart(Schat.ZWAARD, "b");
        spelbord[3][7] = new Tkaart(Schat.SCHATKIST, "l");
        spelbord[5][7] = new Tkaart(Schat.SCHATKAART, "l");
        
        spelbord[1][0] = new Gangkaart (Coördinaat.XCOORDINAAT1);
        spelbord[2][0] = new Gangkaart (Coördinaat.XCOORDINAAT2);
        spelbord[3][0] = new Gangkaart (Coördinaat.XCOORDINAAT3);
        spelbord[4][0] = new Gangkaart (Coördinaat.XCOORDINAAT4);
        spelbord[5][0] = new Gangkaart (Coördinaat.XCOORDINAAT5);
        spelbord[6][0] = new Gangkaart (Coördinaat.XCOORDINAAT6);
        spelbord[7][0] = new Gangkaart (Coördinaat.XCOORDINAAT7);
        
        spelbord[0][0]= new Gangkaart(Coördinaat.BEGINCOORDINAAT);
        
        spelbord[0][1] = new Gangkaart(Coördinaat.YCOORDINAAT1);
        spelbord[0][2] = new Gangkaart(Coördinaat.YCOORDINAAT2);
        spelbord[0][3] = new Gangkaart(Coördinaat.YCOORDINAAT3);
        spelbord[0][4] = new Gangkaart(Coördinaat.YCOORDINAAT4);
        spelbord[0][5] = new Gangkaart(Coördinaat.YCOORDINAAT5);
        spelbord[0][6] = new Gangkaart(Coördinaat.YCOORDINAAT6);
        spelbord[0][7] = new Gangkaart(Coördinaat.YCOORDINAAT7);
        
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
        
        if (spelbord[1][1].getKleur().equals(kleur))
        {
            spelbord[1][1].addSpeler(speler);
        } 
        else if(spelbord[1][7].getKleur().equals(kleur))
        {
            spelbord[1][7].addSpeler(speler);
        } 
        else if(spelbord[7][1].getKleur().equals(kleur))
        {
            spelbord[7][1].addSpeler(speler);
        }
        else if (spelbord[7][7].getKleur().equals(kleur))
        {
            spelbord[7][7].addSpeler(speler);
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
