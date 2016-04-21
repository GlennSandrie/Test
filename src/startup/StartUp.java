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
     *
     * @param args
     */
    public static void main(String[] args)
    {
        DomeinController dc = new DomeinController();
        ConsoleApplicatie ca = new ConsoleApplicatie(dc);
        ca.start();
    }
}
