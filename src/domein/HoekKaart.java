/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.WrongInputException;
import java.util.ArrayList;
import java.util.List;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class HoekKaart extends Gangkaart {

    /**
     *
     * @param schat
     * @param kleur
     * @param richting
     */
    public HoekKaart(Schat schat, Kleur kleur, Richting richting) {
        super(null, kleur, richting);
    }

    /**
     *
     * @param schat
     * @param richting
     */
    public HoekKaart(Schat schat, Richting richting) {
        super(schat, richting);
    }

    /**
     *
     * @param richting
     */
    public HoekKaart(Richting richting) {
        super(richting);
    }

    public String toString() {
        String kaart = "";
        switch (richting) {
            case B:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "xxx         "
                        + "xxx         "
                        + "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx");
                break;
            case L:
                kaart = String.format(
                        "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx"
                        + "xxx         "
                        + "xxx         "
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
            case O:
                kaart = String.format(
                        "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx"
                        + "         xxx"
                        + "         xxx"
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
            case R:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "         xxx"
                        + "         xxx"
                        + "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx");
                break;
        }

        if (schat != null) {
            kaart = kaart.substring(0, 41) + "S" + kaart.substring(42);
        }
        return kaart;
    }

    public List<Richting> geefVerplaatsRichtingen() {
        ArrayList<Richting> al = new ArrayList();
        switch (richting) {
            case B:
                al.add(Richting.B);
                al.add(Richting.L);
                break;
            case L:
                al.add(Richting.L);
                al.add(Richting.O);
                break;
            case O:
                al.add(Richting.O);
                al.add(Richting.R);
                break;
            case R:
                al.add(Richting.R);
                al.add(Richting.O);
                break;
        }
        return al;
    }

}
