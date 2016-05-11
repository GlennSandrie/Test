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
     */            
    public static void bepaalVolgendeSpeler(DomeinController dc, Scanner input)
    {
        String opslaan = "";
        while(!opslaan.equalsIgnoreCase(dc.getTaal().getText("ja"))&&!opslaan.equalsIgnoreCase(dc.getTaal().getText("nee"))) {
            System.out.println(dc.getTaal().getText("Opslaan")+"?");
            opslaan = input.nextLine();
            if(opslaan.equals(dc.getTaal().getText("nee")))
            {
                dc.bepaalVolgendeSpelerAanDeBeurt();
                System.out.println(dc.getTaal().getText("volgendeSpeler") + dc.geefHuidigeSpeler());
                spelOpgeslaan = false;
            }
            else if (opslaan.equals(dc.getTaal().getText("ja")))
            {
                UC6.bewaarSpel(dc, input);
                spelOpgeslaan = true;
            }
            else
                System.out.println(dc.getTaal().getText("fouteInvoer"));
        }
    }

    /**
     * methode om de winnaar weer te geven
     *
     * @param dc
     */
    public static void eindeVanSpel(DomeinController dc)
    {
        System.out.println(dc.getTaal().getText("winnaar") + dc.geefHuidigeSpeler());
    }
}
