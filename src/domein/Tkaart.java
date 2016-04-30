/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Tkaart extends Gangkaart
{

    /**
     * initialiseert de schat en richting van de tkaart a.d.h.v. 
     * superklasse Gangkaart
     *
     * @param schat kan 1 van de 24 schatten zijn
     * @param richting kan boven, links, onder of rechts zijn
     */
    public Tkaart(Schat schat, Richting richting)
    {
        super(schat, richting);
    }

   
    /**
     * maakt van een tkaart, een String
     * 
     * @return String van een tkaart
     */
    @Override
    public String toString()
    {
        String kaart = "";
        switch (getRichting())
        {
            case B:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "            "
                        + "            "
                        + "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx");
                break;
            case L:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
                        + "         xxx"
                        + "         xxx"
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
            case O:
                kaart = String.format(
                        "xxxxxxxxxxxx"
                        + "xxxxxxxxxxxx"
                        + "            "
                        + "            "
                        + "xxx      xxx"
                        + "xxx      xxx");
                break;
            case R:
                kaart = String.format(
                        "xxx      xxx"
                        + "xxx      xxx"
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
                al.add(Richting.L);
                al.add(Richting.R);
                break;
            case L:
                al.add(Richting.L);
                al.add(Richting.O);
                al.add(Richting.B);
                break;
            case O:
                al.add(Richting.O);
                al.add(Richting.R);
                al.add(Richting.L);
                break;
            case R:
                al.add(Richting.R);
                al.add(Richting.O);
                al.add(Richting.B);
                break;
        }
        return al;
    }
}
