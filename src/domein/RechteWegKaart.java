/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import utils.Richting;

/**
 *
 * @author anjana
 */
public class RechteWegKaart extends Gangkaart {

    /**
     * constructor, initialiseert de richting van de rechtewegkaart a.d.h.v.
     * de superklasse Gangkaart
     *
     * @param richting kan boven, links, onder of rechts zijn
     */
    public RechteWegKaart(Richting richting) {
        super(richting);
    }
 
    /**
     * maakt van een rechtewegkaart, een String
     * 
     * @return String van een rechtewegkaart
     */
    @Override
    public String toString() {
        String kaart = "";
        switch (getRichting()) {
            case B:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
            case L:
                kaart = String.format(
                        "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx"
                        + "            "
                        + "            "
                        + "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx");
                break;
            case O:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
            case R:
                kaart = String.format(
                        "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx"
                        + "            "
                        + "            "
                        + "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx");
                break;
        }

        if (schat != null) {
            kaart = kaart.substring(0, 41) + schat.toString().charAt(0) + kaart.substring(42);
        }
        return kaart;
    }
    
    /**
     * 
     * @return lijst van richtingen waarin je je kan verplaatsen
     */
    @Override
    public List<Richting> geefVerplaatsRichtingen() {
        ArrayList<Richting> al = new ArrayList();
        switch (richting) {
            case B:
                al.add(Richting.B);
                al.add(Richting.O);
                break;
            case L:
                al.add(Richting.L);
                al.add(Richting.R);
                break;
            case O:
                al.add(Richting.B);
                al.add(Richting.O);
                break;
            case R:
                al.add(Richting.L);
                al.add(Richting.R);
                break;
        }
        return al;
    }    
}
