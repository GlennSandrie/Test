/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import exceptions.WrongInputException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import utils.Kleur;

/**
 *
 * @author beheerder
 */
public class UC1
{

    /**
     * methode om het gekozen spel te laden en de spelers van het spel te tonen
     * en de nieuwe spelers bij een bepaald spel in te voeren, roept de
     * domeincontroller aan op het volledige spel te initialiseren
     *
     * @param dc
     * @param input
     */
    public static void laadSpel(DomeinController dc, Scanner input)
    {
        // lijst van spelnamen ophalen
        List<String> spelnamen = dc.geefSpelnamen();
        String keuze = "";
        // zolang de lijst je keuze niet bevat moet hij blijven vragen welk spel je wilt kiezen
        while (!spelnamen.contains(keuze))
        {
            // Dit print bvb af "Welk spel wil je spelen?"
            System.out.println(dc.getTaal().getText("laadSpel"));
            for (String spelnaam : spelnamen)
            {
                System.out.println(spelnaam);
            }
            keuze = input.nextLine();
        }
        dc.kiesSpel(keuze);
        // lijst van spelers ophalen
        List<String> spelersnamen = dc.geefSpelersVanSpel(keuze);
        // Wij zeggen hier "Dit zijn de spelers van het spel"        
        System.out.println(dc.getTaal().getText("spelers"));
        // Een voor een de naam afbeelden op het scherm
        System.out.printf("%2s%20s%20s%n", dc.getTaal().getText("naam"), dc.getTaal().getText("geboortejaar"), dc.getTaal().getText("kleur"));

        for (String spelersnaam : spelersnamen)
        {
            System.out.printf("%2s%20s%20s%n", spelersnaam, dc.geefGeboortejaar(spelersnaam), dc.getTaal().getText(dc.geefKleur(spelersnaam).toLowerCase()));
        }
        if (!spelersnamen.isEmpty())
        {
            for (int i = 0; i < spelersnamen.size(); i++)
            {
                for (Kleur k : Kleur.values())
                {
                    if (k.getKleurNaam().equalsIgnoreCase(dc.geefKleur(spelersnamen.get(i))))
                    {
                        dc.registreer(spelersnamen.get(i), dc.geefGeboortejaar(spelersnamen.get(i)), k);
                    }
                }
            }
        }

        int aantalSpelers = spelersnamen.size();
        if (aantalSpelers == 4)
        {
            System.out.println(dc.getTaal().getText("spelVol"));
        } else
        {
            System.out.printf(dc.getTaal().getText("aantalBestaandeSpelers") + "%n", aantalSpelers, 4 - aantalSpelers);
        }
        int aantal = 0;
        boolean vlag = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("aantalSpelers"));
                aantal = input.nextInt();
                if (aantal < 1 || aantal > 4 - aantalSpelers)
                {
                    throw new WrongInputException("aantalBestaandeSpelers");
                } else
                {
                    vlag = false;
                }
            } catch (WrongInputException e)
            {
                System.out.println(String.format(dc.getTaal().getText(e.getMessage()), aantalSpelers, 4 - aantalSpelers));
                input.nextLine();

            } catch (InputMismatchException e)
            {
                System.out.println(String.format(dc.getTaal().getText("aantalBestaandeSpelers"), aantalSpelers, 4 - aantalSpelers));
                input.nextLine();
            }
        } while (vlag);
        input.nextLine();

        boolean fout = true;
        while (fout == true)
        {
            try
            {

                for (int i = 0; i < aantal; i++)
                {
                    UC2.registreerSpeler(dc, input);
                    fout = false;
                }

            } catch (InvalidNameException | InvalidBirthdateException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));
            } catch (IllegalArgumentException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));
            }
        }
        dc.initialiseerVolledigBestaandSpel();
    }
    
}
