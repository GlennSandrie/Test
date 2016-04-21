/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import utils.Richting;

/**
 *
 * @author anjana
 */
public class RechteWegKaart extends Gangkaart {

    /**
     *
     * @param richting
     */
    public RechteWegKaart(Richting[] richting) {
        super(richting);
    }
    Richting[] richtingen = {Richting.B, Richting.O};
    Richting[] richtingen2 = {Richting.R, Richting.L};

    public Gangkaart[] draaienKaart(int keuze) {
        Gangkaart[] draaiKaart= new Gangkaart[2];
        System.out.printf("%s%20s%n", "1.", "2.");
        draaiKaart = new Gangkaart[2];
        draaiKaart[0] = new RechteWegKaart(richtingen2);
        draaiKaart[1] = new RechteWegKaart(richtingen);

        printKaart();
        return draaiKaart;
    }

    public Gangkaart geefGekozenKaart(int keuze) 
    {
        Gangkaart gk= super.getKeuzeKaart();
        if (keuze == 1) {
           gk = new RechteWegKaart(richtingen2);
        } else {
            if (keuze == 2) {
                gk = new RechteWegKaart(richtingen);

            }

        }
        super.setKeuzeKaart(gk);
        return gk;
    }

}
