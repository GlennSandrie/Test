/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.EmptyListException;
import exceptions.WrongInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class UC5
{
    public static void verplaatsSpeler(DomeinController dc, Scanner input)
   {
       
        try {
            int keuze=0;
            List<String> richtingen;
            String doorgaan = "";
            do {
                richtingen = dc.geefMogelijkeVerplaatsRichtingen();
                if(richtingen.isEmpty())
                {
                    throw new IllegalArgumentException("geenGeldigeRichting");
                }
                System.out.println(dc.getTaal().getText("mogelijkeRichting"));
                int teller = 1;

                for(String r : richtingen)
                {
                    System.out.printf("%d. %s%n", teller,dc.getTaal().getText(r));
                    teller++;
                }
                try {
                    System.out.println(dc.getTaal().getText("kiezenRichting"));
                    keuze = input.nextInt();
                    if(keuze<=0 || keuze > richtingen.size())
                        throw new WrongInputException("verkeerdeKeuze");
                    int[] plaatsHG = dc.geefIndexenHuidigeGangkaart();
                    switch(richtingen.get(keuze-1))
                    {
                        case "R": dc.verplaatsSpeler(plaatsHG[0], plaatsHG[1]+1);
                            break;
                        case "L": dc.verplaatsSpeler(plaatsHG[0], plaatsHG[1]-1);
                            break;
                        case "B": dc.verplaatsSpeler(plaatsHG[0]-1, plaatsHG[1]);
                            break;
                        case "O": dc.verplaatsSpeler(plaatsHG[0]+1, plaatsHG[1]);
                            break;
                    }
                    if(dc.controleerOvereenkomendeSchat())
                    {
                        System.out.println("overeenkomendeSchat");
                        dc.verwijderHuidigeDoelkaart();
                        System.out.println(dc.geefDoelkaartVanHuidigeSpeler());
                        ConsoleApplicatie.speelSpel(dc, input);
                    }
                    input.nextLine();
                    try {
                        while(!doorgaan.equals(dc.getTaal().getText("ja"))&&!doorgaan.equals(dc.getTaal().getText("nee"))) {
                            System.out.println("doorgaan");
                            doorgaan = input.nextLine();
                            if(!doorgaan.equals(dc.getTaal().getText("ja"))&&!doorgaan.equals(dc.getTaal().getText("nee")))
                                throw new WrongInputException("fouteInvoer");
                        }
                    }
                    catch (WrongInputException e)
                    {
                        System.out.println(dc.getTaal().getText(e.getMessage()));
                    }
                    
                } catch (EmptyListException e)
                {
                    System.out.println(dc.getTaal().getText(e.getMessage()));
                    ConsoleApplicatie.speelSpel(dc, input);
                }
            }while (keuze<=0 || keuze > richtingen.size() || doorgaan.equals(dc.getTaal().getText("ja")));
        }
        catch (WrongInputException e)
        {
            System.out.println(dc.getTaal().getText(e.getMessage()));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(dc.getTaal().getText(e.getMessage()));
        }
   }
   
    
}

