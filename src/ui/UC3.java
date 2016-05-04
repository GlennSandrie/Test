/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.WrongInputException;
import java.util.Scanner;

/**
 *
 * @author anjana
 */
public class UC3
{
    
    public static boolean spelOpgeslaan;

    /**
     * methode om de volgende speler aan de beurt te bepalen, als het spel ten
     * einde is wordt er geen volgende speler bepaald
     *
     * @param dc
     * @param sc
     * @param eindeSpel
     */            
    public static void bepaalVolgendeSpeler(DomeinController dc, Scanner sc, boolean eindeSpel)
    {
        String opslaan = "";
        if (eindeSpel)
        {
            eindeVanSpel(dc);
        } else
        {
            try {
                while(!opslaan.equalsIgnoreCase(dc.getTaal().getText("ja"))&&!opslaan.equalsIgnoreCase(dc.getTaal().getText("nee"))) {
                    System.out.println("Opslaan?");
                    opslaan = sc.nextLine();
                    if(opslaan.equals(dc.getTaal().getText("nee")))
                    {
                        dc.bepaalVolgendeSpelerAanDeBeurt();
                        System.out.println(dc.getTaal().getText("volgendeSpeler") + dc.geefHuidigeSpeler());
                        spelOpgeslaan = false;
                    }
                    else if (opslaan.equals(dc.getTaal().getText("ja")))
                    {
                        UC6.bewaarSpel(dc, sc);
                        spelOpgeslaan = true;
                    }
                    else
                        throw new WrongInputException("fouteInvoer");
                }
            }
            catch (WrongInputException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));
            }
        }
    }

    /**
     * methode om de winnaar weer te geven
     *
     * @param dc
     */
    public static void eindeVanSpel(DomeinController dc)
    {
        System.out.println("De winnaar is " + dc.geefHuidigeSpeler());
    }
}
