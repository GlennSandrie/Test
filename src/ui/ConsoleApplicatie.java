package ui;

import domein.DomeinController;
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
        while(!(keuze.equalsIgnoreCase("ja")||keuze.equalsIgnoreCase("yes")||keuze.equalsIgnoreCase("oui"))&&!(keuze.equalsIgnoreCase("nee")||keuze.equalsIgnoreCase("no")||keuze.equalsIgnoreCase("non"))) {
        UCTaal.stelTaalIn(dc);
        System.out.println(dc.getTaal().getText("bestaandSpel"));
        keuze = input.nextLine();
        if (keuze.equalsIgnoreCase("ja")||keuze.equalsIgnoreCase("yes")||keuze.equalsIgnoreCase("oui"))
            UC1.laadSpel(dc);
        }
    }
}