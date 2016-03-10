package ui;

import domein.DomeinController;
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
                        throw new WrongInputException(dc.getTaal().getText("fouteInvoer"));
                }
                UC2.registreerSpeler(dc, input);
            }
        
            catch (WrongInputException we)
            {
                System.out.println(we.getMessage());
            }
        }
    }
}