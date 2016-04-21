/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Tkaart extends Gangkaart
{

    /**
     *
     * @param schat
     * @param richting
     */
    public Tkaart(Schat schat, Richting[] richting)
    {
        super(schat, richting);
    }
    Richting[] richtingen =
    {
        Richting.O, Richting.L, Richting.R
    };
    Richting[] richtingen2 =
    {
        Richting.R, Richting.O, Richting.B
    };
    Richting[] richtingen3 =
    {
        Richting.B, Richting.R, Richting.L
    };
    Richting[] richtingen4 =
    {
        Richting.L, Richting.B, Richting.O
    };

    public Gangkaart[] draaienKaart(int keuze)
    {
        Gangkaart[] draaiKaart = new Gangkaart[4];
        System.out.printf("%s%20s%20s%20s%n", "1.", "2.", "3.", "4.");
        draaiKaart = new Gangkaart[4];

        draaiKaart[0] = new Tkaart(null, richtingen4);
        draaiKaart[1] = new Tkaart(null, richtingen2);
        draaiKaart[2] = new Tkaart(null, richtingen3);
        draaiKaart[3] = new Tkaart(null, richtingen);

        printKaart();
        return draaiKaart;
    }

    public Gangkaart geefGekozenKaart(int keuze)
    {
        Gangkaart gk = super.getKeuzeKaart();
        if (keuze == 1)
        {
            gk = new Tkaart(null, richtingen4);

        } else
        {
            if (keuze == 2)
            {
                gk = new Tkaart(null, richtingen2);

            } else
            {
                if (keuze == 3)
                {
                    gk = new Tkaart(null, richtingen3);

                } else if (keuze == 4)
                {
                    gk = new Tkaart(null, richtingen);

                }
            }
        }
        super.setKeuzeKaart(gk);
        return gk;
    }

}
