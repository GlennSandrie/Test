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
 * @author Lisa
 */
public class UC5
{
    public static void verplaatsSpeler(DomeinController dc, Scanner input)
   {
       System.out.println("In welke richting wilt u zich verplaatsen?");
       System.out.println("Mogelijke richtingen:");
       String[] richtingen = dc.geefVerplaatsRichtingen();
       int teller = 1;
       int keuze;
       for(String r : richtingen)
       {
           System.out.printf("%d. %s%n", teller,r);
           teller++;
       }
       keuze = input.nextInt();
       if(keuze > 0 && keuze <= richtingen.length)
       {
           
       }
   }
}
