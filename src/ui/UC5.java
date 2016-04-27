/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.WrongInputException;
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
            List<String> richtingen = dc.geefMogelijkeVerplaatsRichtingen();
            String doorgaan = dc.getTaal().getText("nee");
            do {
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
                String[] doelkaarten = dc.geefDoelkaartenVanHuidigeSpeler();
                if(doelkaarten.length==0)
                {
                    System.out.println(dc.getTaal().getText("geenDoelkaarten"));
                    UC2.geefVolledigSpel(dc);
                }
                else {

                    System.out.println(dc.getTaal().getText("kiezenRichting"));
                    keuze = input.nextInt();
                    if(keuze<=0 || keuze > richtingen.size())
                        throw new WrongInputException("verkeerdeKeuze");
                    int[] plaatsHG = dc.geefIndexenHuidigeGangkaart();
                    switch(richtingen.get(keuze))
                    {
                        case "RECHTS": dc.verplaatsSpeler(plaatsHG[0]+1, plaatsHG[1]);
                            break;
                        case "LINKS": dc.verplaatsSpeler(plaatsHG[0]-1, plaatsHG[1]);
                            break;
                        case "BOVEN": dc.verplaatsSpeler(plaatsHG[0], plaatsHG[1]+1);
                            break;
                        case "ONDER": dc.verplaatsSpeler(plaatsHG[0], plaatsHG[1]-1);
                            break;
                    }
                    
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

