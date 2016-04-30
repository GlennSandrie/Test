/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class HoekKaart extends Gangkaart
{

    /**
     * constructor, initialiseert de schat, kleur en richting van de hoekkaart a.d.h.v.
     * de superklasse Gangkaart
     * 
     * @param schat kan 1 van de 24 schatten zijn
     * @param kleur kan rood, geel, groen of blauw zijn
     * @param richting kan boven, links, onder of rechts zijn
     */
    public HoekKaart(Schat schat, Kleur kleur, Richting richting)
    {
        super(null, kleur, richting);
    }

    /**
     * initialiseert de schat en richting van de hoekkaart a.d.h.v de 
     * superklasse Gangkaart
     *
     * @param schat kan 1 van de 24 schatten zijn
     * @param richting kan boven, links, onder of rechts zijn
     */
    public HoekKaart(Schat schat, Richting richting)
    {
        super(schat, richting);
    }

    /**
     * initialiseert de richting van de hoekkaart a.d.h.v. de superklasse Gangkaart
     * 
     * @param richting kan boven, links, onder of rechts zijn
     */
    public HoekKaart(Richting richting)
    {
        super(richting);
    }

    /**
     * maakt van een hoekkaart, een String
     * 
     * @return String van een hoekkaart
     */
    @Override
    public String toString()
    {
        String kaart = "";
        switch (richting)
        {
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
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "         xxx"
                        + "         xxx"
                        + "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx");
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
                        "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx"
                        + "xxx         "
                        + "xxx         "
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
        }

        if (schat != null)
        {
            kaart = kaart.substring(0, 41) + schat.toString().charAt(0) + kaart.substring(42);
        }
        return kaart;
    }

    /**
     * 
     * @return lijst van richtingen waarin je je kan verplaatsen
     */
    @Override
    public List<Richting> geefVerplaatsRichtingen()
    {
        ArrayList<Richting> al = new ArrayList();
        switch (richting)
        {
            case B:
                al.add(Richting.B);
                al.add(Richting.R);
                break;
            case L:
                al.add(Richting.L);
                al.add(Richting.B);
                break;
            case O:
                al.add(Richting.O);
                al.add(Richting.L);
                break;
            case R:
                al.add(Richting.R);
                al.add(Richting.O);
                break;
        }
        return al;
    }

}
