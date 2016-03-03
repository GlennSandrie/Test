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

    public static void laadSpel(DomeinController dc) {
        // lijst van spelnamen ophalen
        List<String> spelnamen = dc.geefSpelnamen();
        Scanner input = new Scanner(System.in);
        String keuze = "";
        while (!spelnamen.contains(keuze)) {
            System.out.println("Kies een spel uit de onderstaande lijst");
            for (String spelnaam : spelnamen) {
                System.out.println(spelnaam);
            }
            keuze = input.nextLine();
        }

        // lijst van spelers ophalen
//        List<String> spelersnamen = dc.geefSpelersnamen(keuze);
//        System.out.println("De spelers van dit spel");
//        for (String spelersnaam : spelersnamen) {
//            System.out.println(spelersnaam);
//        }
    }
}
