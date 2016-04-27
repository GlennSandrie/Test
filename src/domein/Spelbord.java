/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.InvalidCoordinateException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import utils.Coördinaat;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Spelbord {

    private Gangkaart[][] spelbord = new Gangkaart[7][7];

    /**
     *
     */
    public Spelbord() {
        spelbord[0][0] = new HoekKaart(null, Kleur.GE, Richting.R);
        spelbord[0][6] = new HoekKaart(null, Kleur.B, Richting.O);
        spelbord[6][0] = new HoekKaart(null, Kleur.GR, Richting.B);
        spelbord[6][6] = new HoekKaart(null, Kleur.R, Richting.L);

        spelbord[0][2] = new Tkaart(Schat.UIL, Richting.O);
        spelbord[0][4] = new Tkaart(Schat.SCHEDEL, Richting.O);
        spelbord[2][0] = new Tkaart(Schat.HAGEDIS, Richting.R);
        spelbord[2][2] = new Tkaart(Schat.RAT, Richting.R);
        spelbord[2][4] = new Tkaart(Schat.TOVENARES, Richting.O);
        spelbord[2][6] = new Tkaart(Schat.SCHATKIST, Richting.L);
        spelbord[4][0] = new Tkaart(Schat.MOT, Richting.R);
        spelbord[4][2] = new Tkaart(Schat.SCARABEE, Richting.B);
        spelbord[4][4] = new Tkaart(Schat.SPIN, Richting.L);
        spelbord[4][6] = new Tkaart(Schat.SCHATKAART, Richting.L);
        spelbord[6][2] = new Tkaart(Schat.SLEUTELS, Richting.B);
        spelbord[6][4] = new Tkaart(Schat.ZWAARD, Richting.B);
        
       
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
    public Gangkaart[][] geefSpelbord() {
        return spelbord;
    }

    public void zetSpelerOpHoekKaart(Kleur kleur, Speler speler) {

        if (spelbord[0][0].getKleur().equals(kleur)) {
            spelbord[0][0].voegSpelerToe(speler);
        } else if (spelbord[0][6].getKleur().equals(kleur)) {
            spelbord[0][6].voegSpelerToe(speler);
        } else if (spelbord[6][0].getKleur().equals(kleur)) {
            spelbord[6][0].voegSpelerToe(speler);
        } else if (spelbord[6][6].getKleur().equals(kleur)) {
            spelbord[6][6].voegSpelerToe(speler);
        } else {
            throw new IllegalArgumentException("foutKleur");
        }

    }

    public void voegGangKaartToe(int xPositie, int yPositie, Gangkaart gk) {
        spelbord[xPositie][yPositie] = gk;
    }

    public void geefPlaatsVrijeGangkaart(int xPositie, int yPositie) {
        if (!(xPositie == 1 && yPositie == 0)
                || (xPositie == 3 && yPositie == 0)
                || (xPositie == 5 && yPositie == 0)
                || (xPositie == 0 && yPositie == 1)
                || (xPositie == 0 && yPositie == 3)
                || (xPositie == 0 && yPositie == 5)
                || (xPositie == 1 && yPositie == 6)
                || (xPositie == 3 && yPositie == 6)
                || (xPositie == 5 && yPositie == 6)
                || (xPositie == 6 && yPositie == 1)
                || (xPositie == 6 && yPositie == 3)
                || (xPositie == 6 && yPositie == 5)) {
            throw new IllegalArgumentException("fouteCoordinaat");
        } else {
            voegVrijeGangkaartToeAanSpelbord();
        }
    }

    public void voegVrijeGangkaartToeAanSpelbord() {

    }

    public int[] geefIndexenHuidigeGangkaart(Speler speler) {
        int[] indexen = new int[2];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (Speler s : spelbord[i][j].getSpelers()) {
                    if (s == speler) {
                        indexen[0] = i;
                        indexen[1] = j;
                    }
                }
            }
        }
        return indexen;
    }

    public List<String> geefMogelijkeVerplaatsRichtingen(Speler speler) {
        int x = geefIndexenHuidigeGangkaart(speler)[0];
        int y = geefIndexenHuidigeGangkaart(speler)[1];

        List<Richting> richtingen = spelbord[x][y].geefVerplaatsRichtingen();
        if (x == 0) {
            richtingen.remove(Richting.B);
        } else if (x == 6) {
            richtingen.remove(Richting.O);
        }
        if (y == 0) {
            richtingen.remove(Richting.L);
        } else if (y == 6) {
            richtingen.remove(Richting.R);
        }

        ListIterator<Richting> iter = richtingen.listIterator();
        while (iter.hasNext()) {
            Richting r = iter.next();
            if (r == Richting.B){
                if (!spelbord[x - 1][y].geefVerplaatsRichtingen().contains(Richting.O)){
                    iter.remove();
                }
            }
            else if (r == Richting.O) {
                if (!spelbord[x + 1][y].geefVerplaatsRichtingen().contains(Richting.B)){
                    iter.remove();
                }
            }
            else if (r == Richting.L) {
                if (!spelbord[x][y - 1].geefVerplaatsRichtingen().contains(Richting.R)){
                    iter.remove();
                }                
            }
            else if (r == Richting.R) {
                 if (!spelbord[x][y + 1].geefVerplaatsRichtingen().contains(Richting.L)){
                    iter.remove();
                }               
            }            
        }

        List<String> resultaat = new ArrayList<String>();
        for (Richting r : richtingen){
            resultaat.add(r.toString());
        }
        return resultaat;
    }

    public void verplaatsSpeler(int xPositie, int yPositie, Speler speler) {
        Gangkaart huidigeGangkaart = spelbord[geefIndexenHuidigeGangkaart(speler)[0]][geefIndexenHuidigeGangkaart(speler)[1]];
        huidigeGangkaart.verwijderSpeler(speler);
        spelbord[xPositie][yPositie].voegSpelerToe(speler);
    }

    public Schat geefSchatHuidigeGangkaart(Speler speler)
    {
        int[] plaatsHG = geefIndexenHuidigeGangkaart(speler);
        return spelbord[plaatsHG[0]][plaatsHG[1]].schat;
    }

}
