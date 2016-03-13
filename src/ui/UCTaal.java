/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import java.util.Scanner;

/**
 *
 * @author svre257
 */
public class UCTaal {

    /**
     *
     * @param dc
     */
    public static void stelTaalIn(DomeinController dc,Scanner input) {
        String keuze = "";
        while (!keuze.equals("nl") && !keuze.equals("fr") && !keuze.equals("en")) {
            System.out.println("Voor Nederlands: typ nl");
            System.out.println("Pour Français: choisissez fr");
            System.out.println("For English: choose en");
            keuze = input.nextLine();
        }
        dc.setTaal(keuze);
        System.out.println(dc.getTaal().getText("welkom"));
    }
    
}
