/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author beheerder
 */
public class UC1 {
    
    /**
     *
     * @param dc
     * @param input
     */
    public static void laadSpel(DomeinController dc,Scanner input) {
        // lijst van spelnamen ophalen
        List<String> spelnamen = dc.geefSpelnamen();
        String keuze = "";
        // zolang de lijst je keuze niet bevat moet hij blijven vragen welk spel je wilt kiezen
        while (!spelnamen.contains(keuze)) {
            // Dit print bvb af "Welk spel wil je spelen?"
            System.out.println(dc.getTaal().getText("laadSpel"));
            for (String spelnaam : spelnamen) {
                System.out.println(spelnaam);
            }
            keuze = input.nextLine();
        }
        
        // lijst van spelers ophalen
        List<String> spelersnamen = dc.geefSpelersVanSpel(keuze);
        // Wij zeggen hier "Dit zijn de spelers van het spel"
        System.out.println(dc.getTaal().getText("spelers"));
        // Een voor een de naam afbeelden op het scherm
        for (String spelersnaam : spelersnamen) {
            System.out.println(spelersnaam);
        }
    }
}
