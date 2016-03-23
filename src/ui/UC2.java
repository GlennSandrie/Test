/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import java.util.Scanner;
import utils.Kleur;

/**
 *
 * @author Aïssa
 */
public class UC2
{
    public static void maakNieuwSpel(DomeinController dc,Scanner input)
    {
        String naam;
        System.out.println(dc.getTaal().getText("nieuwSpel"));
        naam = input.nextLine();
        dc.maakSpel(naam);
        
        
    }
    
    public static void registreerSpeler(DomeinController dc,Scanner input)
    {
        String naam;
        int geboortejaar, nrKleur;
        Kleur kleur = null;
        System.out.println(dc.getTaal().getText("spelerNaam"));
        naam = input.nextLine();
        System.out.println(naam);
        System.out.println(dc.getTaal().getText("spelerGebdatum"));
        geboortejaar = input.nextInt();
        input.nextLine();
        try {
            while (kleur == null)
            {
                System.out.println(dc.getTaal().getText("spelerKleur"));
                System.out.println("1. "+dc.getTaal().getText("geel"));
                System.out.println("2. "+dc.getTaal().getText("blauw"));
                System.out.println("3. "+dc.getTaal().getText("rood"));
                System.out.println("4. "+dc.getTaal().getText("groen"));

                nrKleur = input.nextInt();
                for (Kleur k : Kleur.values())
                {
                    if (k.getKleurNr()==nrKleur)
                        kleur=k;
                }
                input.nextLine();
                dc.registreer(naam, geboortejaar,kleur);
            }
        }
        catch (NullPointerException e)
        {
            System.out.println(dc.getTaal().getText("fouteNummerKleur"));
        }
    }
}