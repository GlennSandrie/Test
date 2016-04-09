/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import domein.Gangkaart;
import domein.HoekKaart;
import domein.RechteWegKaart;
import domein.Tkaart;

/**
 *
 * @author Lisa
 */
public class UC4
{

    /**
     *
     * @param dc
     */
    private static Gangkaart[] draaiKaart;

    public static void draaiVrijeGangkaart(DomeinController dc)
    {
        System.out.println(dc.getTaal().getText("inschuivenKaart"));
        System.out.println(dc.getTaal().getText("draaiKaart"));
        draaienKaart(dc);
    }

    public static void draaienKaart(DomeinController dc)
    {
        if (dc.bepaalTypeLosseKaart() instanceof HoekKaart)
        {
            System.out.printf("%s%20s%20s%20s%n","1.","2.","3.","4.");
            //System.out.printf("2. ");"
            draaiKaart = new Gangkaart[4];
            
            
            draaiKaart[0] = new HoekKaart(null, "or");            
            draaiKaart[1] = new HoekKaart(null, "ol");            
            draaiKaart[2] = new HoekKaart(null, "br");            
            draaiKaart[3] = new HoekKaart(null, "bl");

            printKaart();

        } else if (dc.bepaalTypeLosseKaart() instanceof Tkaart)
        {
            System.out.printf("%s%20s%20s%20s%n","1.","2.","3.","4.");
            draaiKaart = new Gangkaart[4];
          
            draaiKaart[0] = new Tkaart(null, "l");            
            draaiKaart[1] = new Tkaart(null, "r");            
            draaiKaart[2] = new Tkaart(null, "b");            
            draaiKaart[3] = new Tkaart(null, "o");

            printKaart();

        } else
        {
           System.out.printf("%s%20s%n","1.","2.");
            draaiKaart = new Gangkaart[2];
            draaiKaart[0] = new RechteWegKaart("h");
            draaiKaart[1] = new RechteWegKaart("v");
            
            printKaart();

        }
         
    }
    public static void printKaart()
    {
        int begin = 0;
        int einde = 11;
        while (begin < 72)
            {
                for (int j = 0; j < draaiKaart.length; j++)
                {
                    System.out.printf(draaiKaart[j].toString().substring(begin, einde + 1));
                    System.out.printf("        ");
                }
                begin += 12;
                einde += 12;
                System.out.println();
            }
    }
}
