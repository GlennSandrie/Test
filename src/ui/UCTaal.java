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
public class UCTaal
{

    /**
     * methode om de speler de gewenste taal te laten instellen
     *
     * @param dc
     * @param input
     */
    public static void stelTaalIn(DomeinController dc, Scanner input)
    {
        String keuze = "";
        while (!keuze.equalsIgnoreCase("nl") && !keuze.equalsIgnoreCase("fr") && !keuze.equalsIgnoreCase("en"))
        {
            System.out.println("Voor Nederlands: typ nl");
            System.out.println("Pour Français: choisissez fr");
            System.out.println("For English: choose en");
            keuze = input.nextLine();
        }
        dc.setTaal(keuze);
        System.out.println(dc.getTaal().getText("welkom"));
    }

}
