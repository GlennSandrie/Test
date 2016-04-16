/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;


import java.util.ArrayList;
import java.util.List;
import utils.Coördinaat;
import utils.Kleur;
import utils.Richting;
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
        Richting[] richtingen = {Richting.O,Richting.R};      
        spelbord[0][0] = new HoekKaart(null, Kleur.GE, richtingen);
        Richting[] richtingen2 = {Richting.O,Richting.L};
        spelbord[0][6] = new HoekKaart(null, Kleur.B, richtingen2);
        Richting[] richtingen3 = {Richting.B,Richting.R};
        spelbord[6][0] = new HoekKaart(null, Kleur.GR, richtingen3);
        Richting[] richtingen4 = {Richting.B,Richting.L};
        spelbord[6][6] = new HoekKaart(null, Kleur.R, richtingen4);
        
        Richting[] richtingen5 = {Richting.O,Richting.L,Richting.R};
        Richting[] richtingen6 = {Richting.R,Richting.O,Richting.B};
        Richting[] richtingen7 = {Richting.B,Richting.R,Richting.L};
        Richting[] richtingen8 = {Richting.L,Richting.B,Richting.O};
        spelbord[2][0] = new Tkaart(Schat.HAGEDIS, richtingen6);
        spelbord[4][0] = new Tkaart(Schat.MOT, richtingen6);
        spelbord[0][2] = new Tkaart(Schat.UIL, richtingen5);
        spelbord[2][2] = new Tkaart(Schat.RAT, richtingen6);
        spelbord[4][2] = new Tkaart(Schat.SCARABEE, richtingen7);
        spelbord[6][2] = new Tkaart(Schat.SLEUTELS, richtingen7);
        spelbord[0][4] = new Tkaart(Schat.SCHEDEL, richtingen5);
        spelbord[2][4] = new Tkaart(Schat.TOVENARES, richtingen5);
        spelbord[4][4] = new Tkaart(Schat.SPIN, richtingen8);
        spelbord[6][4] = new Tkaart(Schat.ZWAARD, richtingen7);
        spelbord[2][6] = new Tkaart(Schat.SCHATKIST, richtingen8);
        spelbord[4][6] = new Tkaart(Schat.SCHATKAART, richtingen8);
        /* Coördinaten Doolhof*/
        /*spelbord[1][0] = new Gangkaart (Coördinaat.XCOORDINAAT1);
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
        spelbord[0][7] = new Gangkaart(Coördinaat.YCOORDINAAT7);*/
        
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
            spelbord[0][0].voegSpelerToe(speler);
        } 
        else if(spelbord[0][6].getKleur().equals(kleur))
        {
            spelbord[0][6].voegSpelerToe(speler);
        } 
        else if(spelbord[6][0].getKleur().equals(kleur))
        {
            spelbord[6][0].voegSpelerToe(speler);
        }
        else if (spelbord[6][6].getKleur().equals(kleur))
        {
            spelbord[6][6].voegSpelerToe(speler);
        }
        else
        {
            throw new IllegalArgumentException("foutKleur");
        }
        
    }
    
    public void voegGangKaartToe (int xPositie, int yPositie, Gangkaart gk)
    {
        spelbord[xPositie][yPositie] = gk;
    }
    
    private int[] geefIndexenHuidigeGangkaart(Speler speler)
    {
        int[] indexen = new int[2];
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                for(Speler s : spelbord[i][j].getSpelers())
                {
                    if(s == speler)
                    {
                        indexen[0]=i;
                        indexen[1]=j;
                    }
                }
            }
        }
        return indexen;
    }   
    
    public String[] geefVerplaatsRichtingen(Speler speler)
    {
        int x = geefIndexenHuidigeGangkaart(speler)[0];
        int y = geefIndexenHuidigeGangkaart(speler)[1];
        Richting[] richtingHuidigeKaart = spelbord[x][y].getRichtingen();
        List<String> richtingen = new ArrayList<>();
        switch(x)
        {
            case 1: switch(y)
            {
                case 1: 
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y+1].getRichtingen(),"rechts"))
                        richtingen.add("rechts");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x+1][y].getRichtingen(),"onder"))
                        richtingen.add("onder");
                    break;
                }
                case 7: 
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x+1][y].getRichtingen(),"onder"))
                        richtingen.add("onder"); 
                    break;
                }
                default:
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y+1].getRichtingen(),"rechts"))
                        richtingen.add("rechts");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x+1][y].getRichtingen(),"onder"))
                        richtingen.add("onder"); 
                    break;
                }
            }
            case 7: switch(y)
            {
                case 1: 
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y+1].getRichtingen(),"rechts"))
                        richtingen.add("rechts");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x-1][y].getRichtingen(),"boven"))
                        richtingen.add("boven");
                    break;
                }
                case 7: 
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x-1][y].getRichtingen(),"boven"))
                        richtingen.add("boven"); 
                    break;
                }
                default:
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y+1].getRichtingen(),"rechts"))
                        richtingen.add("rechts");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x-1][y].getRichtingen(),"boven"))
                        richtingen.add("boven");
                    break;
                }
            }
            default: switch(y)
            {
                case 1: 
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y+1].getRichtingen(),"rechts"))
                        richtingen.add("rechts");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x+1][y].getRichtingen(),"onder"))
                        richtingen.add("onder"); 
                    break;
                }
                case 7: 
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x+1][y].getRichtingen(),"onder"))
                        richtingen.add("onder");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x-1][y].getRichtingen(),"boven"))
                        richtingen.add("boven"); 
                    break;
                }
                default:
                {
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y+1].getRichtingen(),"rechts"))
                        richtingen.add("rechts");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x][y-1].getRichtingen(),"links"))
                        richtingen.add("links");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x-1][y].getRichtingen(),"boven"))
                        richtingen.add("boven");
                    if(controleerMogelijkeVerplaatsRichting(richtingHuidigeKaart, spelbord[x+1][y].getRichtingen(),"onder"))
                        richtingen.add("onder"); 
                    break;
                }
            }
        }
        String[] res = new String[richtingen.size()];
        return richtingen.toArray(res);
    }
    
    private boolean controleerMogelijkeVerplaatsRichting(Richting[] richtingenKaart1, Richting[] richtingenKaart2, String plaatsing)
    {
        for(Richting r : richtingenKaart1)
        {
            for(Richting r2 : richtingenKaart2)
            {
                if(plaatsing.equals("rechts") && r == Richting.L && r2 == Richting.R)
                    return true;
                if(plaatsing.equals("links") && r == Richting.R && r2 == Richting.L)
                    return true;
                if(plaatsing.equals("onder") && r == Richting.O && r2 == Richting.B)
                    return true;
                if(plaatsing.equals("boven") && r == Richting.B && r2 == Richting.O)
                    return true;
            }
        }
        return false;
    }
    
    public void verplaatsSpeler(int xPositie, int yPositie, Speler speler)
    {
        Gangkaart huidigeGangkaart = spelbord[geefIndexenHuidigeGangkaart(speler)[0]][geefIndexenHuidigeGangkaart(speler)[1]];
        huidigeGangkaart.verwijderSpeler(speler);
        spelbord[xPositie][yPositie].voegSpelerToe(speler);
    }
}
