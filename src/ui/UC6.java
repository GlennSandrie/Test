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
                    System.out.println(dc.getTaal().getText("nieuweNaam"));
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
    }

    private static void updateSpelers(DomeinController dc)
    {
        
    }

    private static void opslaanSpelers(DomeinController dc)
    {
        
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
                if(spelernamenDB.size()==spelernamen.size())
                {
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
                        throw new InvalidNameException("spelBestaat");
                }
            }
        }
        return false;
    }
}
