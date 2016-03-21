package ui;

import domein.DomeinController;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import exceptions.WrongInputException;
import java.util.Scanner;

/**
 *
 * @author anjana
 */
public class ConsoleApplicatie {

    private DomeinController dc;

    /**
     *
     * @param dc
     */
    public ConsoleApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    /**
     *
     */
    public void start() {
        Scanner input = new Scanner(System.in);
        String keuze="";
        int aantal;
        UCTaal.stelTaalIn(dc,input);
        while(!(keuze.equalsIgnoreCase("ja")||keuze.equalsIgnoreCase("yes")||keuze.equalsIgnoreCase("oui"))&&!(keuze.equalsIgnoreCase("nee")||keuze.equalsIgnoreCase("no")||keuze.equalsIgnoreCase("non"))) {
            try {
            
                System.out.println(dc.getTaal().getText("bestaandSpel"));
                keuze = input.nextLine();
                if (keuze.equalsIgnoreCase("ja")||keuze.equalsIgnoreCase("yes")||keuze.equalsIgnoreCase("oui"))
                    UC1.laadSpel(dc,input);
                else
                {
                    if (keuze.equalsIgnoreCase("nee")||keuze.equalsIgnoreCase("no")||keuze.equalsIgnoreCase("non"))
                       UC2.maakNieuwSpel(dc,input);
                    else
                        throw new WrongInputException("fouteInvoer");
                }
                
                System.out.println("Hoeveel spelers wilt u ingeven");
                aantal = input.nextInt();
                input.nextLine();
                try {
                    boolean fout = true;
                    while (fout==true)
                    {
                        for(int i = 0; i < aantal; i++)
                        {
                            UC2.registreerSpeler(dc, input);
                        }
                    fout=false;
                    }
                }
                catch (InvalidNameException e)
                {
                    System.out.println(dc.getTaal().getText(e.getMessage()));
                }
        
                catch (InvalidBirthdateException e)
                {
                    System.out.println(dc.getTaal().getText(e.getMessage()));
                }
                
                System.out.printf(dc.geefSpel().toString());
            }
        
            catch (WrongInputException we)
            {
                System.out.println(dc.getTaal().getText(we.getMessage()));
            }
            
        }
    }
}