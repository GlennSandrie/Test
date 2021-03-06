package ui;

import domein.DomeinController;
import exceptions.EmptyListException;
import exceptions.WrongInputException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author anjana
 */
public class ConsoleApplicatie
{

    private DomeinController dc;

    /**
     * constructor, initialiseert de domeincontroller
     *
     * @param dc
     */
    public ConsoleApplicatie(DomeinController dc)
    {
        this.dc = dc;
    }

    /**
     * methode om het spel in de console te starten
     */
    public void start()
    {
        Scanner input = new Scanner(System.in);
        String keuze = "";

        UCTaal.stelTaalIn(dc, input);
        while (!(keuze.equalsIgnoreCase("ja") || keuze.equalsIgnoreCase("yes") || keuze.equalsIgnoreCase("oui")) && !(keuze.equalsIgnoreCase("nee") || keuze.equalsIgnoreCase("no") || keuze.equalsIgnoreCase("non")))
        {
            try
            {

                System.out.println(dc.getTaal().getText("bestaandSpel"));
                keuze = input.nextLine();
                if (keuze.equalsIgnoreCase("ja") || keuze.equalsIgnoreCase("yes") || keuze.equalsIgnoreCase("oui"))
                {
                    UC1.laadSpel(dc, input);
                    speelSpel(dc, input);
                } else
                {
                    if (keuze.equalsIgnoreCase("nee") || keuze.equalsIgnoreCase("no") || keuze.equalsIgnoreCase("non"))
                    {
                        UC2.maakNieuwSpel(dc, input);
                        speelSpel(dc, input);
                    } else
                    {
                        throw new WrongInputException("fouteInvoer");
                    }
                }
            } catch (WrongInputException | InputMismatchException we)
            {
                System.out.println(dc.getTaal().getText(we.getMessage()));
            }
            catch (RuntimeException ex)
            {
                System.out.println(dc.getTaal().getText("connectieFout"));
            }
        }
        
    }

    /**
     * methode om het spel te spelen, roept UC2, UC3, UC4 en UC5 aan
     *
     * @param dc
     * @param input
     */
    public static void speelSpel(DomeinController dc, Scanner input)
    {
        try {
            UC2.geefVolledigSpel(dc);
            UC4.geefPlaatsVrijeGangkaartIn(dc, input);
            try
            {
                UC5.verplaatsSpeler(dc, input);            
            } catch (EmptyListException ex)
            {
                System.out.println(dc.getTaal().getText(ex.getMessage()));
                UC3.eindeVanSpel(dc);
            }
        }
        catch (RuntimeException ex)
        {
            System.out.println(dc.getTaal().getText("connectieFout"));
        }
    }
    
    public static void gaDoorMetSpel(DomeinController dc, Scanner input)
    {
        UC3.bepaalVolgendeSpeler(dc, input);
        if(!UC3.spelOpgeslaan)
        {
            speelSpel(dc, input);
        }
    }
}
