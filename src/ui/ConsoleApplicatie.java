package ui;

import domein.DomeinController;
import exceptions.EmptyListException;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import exceptions.WrongInputException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        while(!(keuze.equalsIgnoreCase("ja")||keuze.equalsIgnoreCase("yes")||keuze.equalsIgnoreCase("oui"))&&!(keuze.equalsIgnoreCase("nee")||keuze.equalsIgnoreCase("no")||keuze.equalsIgnoreCase("non"))) 
        {
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
            }
        
            catch (WrongInputException | InputMismatchException we)
            {
                System.out.println(dc.getTaal().getText(we.getMessage()));
            }
        }
        speelSpel(dc,input);
    }
    
    public static void speelSpel(DomeinController dc, Scanner input)
    {
        UC2.geefVolledigSpel(dc);
        UC4.geefPlaatsVrijeGangkaartIn(dc, input);
        try {
            UC5.verplaatsSpeler(dc, input);
            UC3.bepaalVolgendeSpeler(dc, input, false);
        } catch (EmptyListException ex) {
            System.out.println(dc.getTaal().getText(ex.getMessage()));
            UC3.bepaalVolgendeSpeler(dc, input, true);
        }
    }
    
    
}
