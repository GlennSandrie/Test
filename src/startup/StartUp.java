package StartUp;

import ui.ConsoleApplicatie;
import domein.DomeinController;

/**
 *
 * @author anjana
 */
public class StartUp
{

    /**
     * main methode om de applicatie uit te voeren in de console, ken t de
     * DomeinController en de ConsoleApplicatie
     *
     * @param args ongebruikt
     */
    public static void main(String[] args)
    {
        DomeinController dc = new DomeinController();
        ConsoleApplicatie ca = new ConsoleApplicatie(dc);
        ca.start();
    }
}
