/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.WrongInputException;
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
     *
     * @param schat
     * @param kleur
     * @param richting
     */
    public HoekKaart(Schat schat, Kleur kleur, Richting[] richting)
    {
        super(null, kleur, richting);
    }

    /**
     *
     * @param schat
     * @param richting
     */
    public HoekKaart(Schat schat, Richting[] richting)
    {
        super(schat, richting);
    }

    /**
     *
     * @param richting
     */
    public HoekKaart(Richting[] richting)
    {
        super(richting);
    }

    Richting[] richtingen =
    {
        Richting.O, Richting.R
    };
    Richting[] richtingen2 =
    {
        Richting.O, Richting.L
    };
    Richting[] richtingen3 =
    {
        Richting.B, Richting.R
    };
    Richting[] richtingen4 =
    {
        Richting.B, Richting.L
    };

    public Gangkaart[] draaienKaart(int keuze)
    {
        Gangkaart[] draaiKaart = new Gangkaart[4];
        System.out.printf("%s%20s%20s%20s%n", "1.", "2.", "3.", "4.");
//
        draaiKaart = new Gangkaart[4];

        draaiKaart[0] = new HoekKaart(null, richtingen);

        draaiKaart[1] = new HoekKaart(null, richtingen2);

        draaiKaart[2] = new HoekKaart(null, richtingen3);

        draaiKaart[3] = new HoekKaart(null, richtingen4);
        super.printKaart();
        return draaiKaart;

    }
    @Override
    public Gangkaart geefGekozenKaart(int keuze)
    {
        Gangkaart gk = super.getKeuzeKaart();
        if (keuze == 1)
        {
            gk = new HoekKaart(null, richtingen);
        } else
        {
            if (keuze == 2)
            {
                gk = new HoekKaart(null, richtingen2);

            } else
            {
                if (keuze == 3)
                {
                    gk = new HoekKaart(null, richtingen3);

                } else if (keuze == 4)
                {
                    gk = new HoekKaart(null, richtingen4);

                }
            }
        }
        super.setKeuzeKaart(gk);
        return gk;
    }

}
