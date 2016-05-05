/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.InvalidNameException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aïssa
 */
public class UC6
{

    /**
     * methode om het spel te bewaren en weg te schrijven naar de databank
     *
     * @param dc
     * @param input
     */
    public static void bewaarSpel(DomeinController dc, Scanner input)
    {
        
        try{
            boolean fout = true;
            while(fout)
            {
                System.out.printf("Het spel wordt opgeslaan onder de naam %s%n",dc.getSpelnaam());
                if(controleerBestaandSpel(dc))
                {
                    dc.updateSpelbord();
                    updateSpelers(dc);
                }
                else
                {
                    dc.opslaanSpelbord();
                    opslaanSpelers(dc);
                }
                System.out.println("Het spel is opgeslagen");
                fout = false;
            }
        }
        catch(InvalidNameException e)
        {
            System.out.println(dc.getTaal().getText(e.getMessage()));
            try {
                boolean fout = true;
                while(fout)
                {
                    String naam;
                    System.out.println(dc.getTaal().getText("nieuwSpel"));
                    naam = input.nextLine();
                    dc.setNaamSpel(naam);
                    fout = false;
                }
            }
            catch(InvalidNameException ex)
            {
                System.out.println(dc.getTaal().getText(ex.getMessage()));
            }
        }
        catch(RuntimeException e)
        {
            System.out.println("Er is een fout gebeurt bij het opslaan van het spel. Het programma werd afgesloten.");
            System.exit(1);
        }
    }

    private static void updateSpelers(DomeinController dc)
    {
        List<String> spelernamenDB = dc.geefSpelersVanSpel(dc.getSpelnaam());        
        String naam;
        
        for(int teller = 0; teller < dc.geefSpelers().size(); teller++)
        {
            naam = dc.geefHuidigeSpeler();
            boolean gevonden = false;
            for(String sDB : spelernamenDB)
            {
                if(naam.equals(sDB))
                {
                    dc.updateSpeler(teller);
                    gevonden = true;
                }
            }
            if(!gevonden)
            {
                dc.opslaanSpeler(teller);
            }
            dc.bepaalVolgendeSpelerAanDeBeurt();
        }
        dc.bepaalVolgendeSpelerAanDeBeurt();
    }

    private static void opslaanSpelers(DomeinController dc)
    {
        for(int teller = 0; teller < dc.geefSpelers().size(); teller++)
        {
            dc.opslaanSpeler(teller);
            dc.bepaalVolgendeSpelerAanDeBeurt();
        }
        dc.bepaalVolgendeSpelerAanDeBeurt();
    }

    private static boolean controleerBestaandSpel(DomeinController dc)
    {
        List<String> spelnamenDB = dc.geefSpelnamen();
        String spelnaam = dc.getSpelnaam();
        List<String> spelernamenDB;
        List<String> spelernamen;
        for(String naam : spelnamenDB)
        {
            if(naam.equals(spelnaam))
            {
                spelernamenDB = dc.geefSpelersVanSpel(naam);
                spelernamen = dc.geefSpelers();
                int aantalGelijk = 0;
                for(String sDB : spelernamenDB)
                {
                    for(String s : spelernamen)
                    {
                        if(s.equals(sDB))
                        {
                            aantalGelijk++;
                        }
                    }
                }
                if(aantalGelijk==spelernamenDB.size())
                {
                    return true;
                }
                else
                    throw new InvalidNameException("naamBestaat");
            }
        }
        return false;
    }
}
