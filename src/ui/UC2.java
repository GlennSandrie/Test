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
        String naam="";
        int geboortejaar;
        System.out.println(dc.getTaal().getText("spelerNaam"));
        naam = input.nextLine();
        System.out.println(dc.getTaal().getText("gebdatumSpeler"));
        geboortejaar = input.nextInt();
        input.nextLine();
        dc.registreer(naam, geboortejaar,Kleur.B);                
    }
}
