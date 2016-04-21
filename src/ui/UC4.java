package ui;

import domein.DomeinController;
import domein.Gangkaart;
import domein.HoekKaart;
import domein.RechteWegKaart;
import domein.Tkaart;
import exceptions.InvalidCoordinateException;
import exceptions.WrongInputException;
import java.util.InputMismatchException;
import java.util.Scanner;
import utils.Kleur;
import utils.Richting;

/**
 *
 * @author Lisa
 */
public class UC4
{

    /**
     *
     * @param dc
     */
//    private static Gangkaart[] draaiKaart;
//    private static Gangkaart keuzeKaart;
//
//    
    public static void geefPlaatsVrijeGangkaartIn(DomeinController dc, Scanner input)
    {
        int xPositie, yPositie;
        int keuze = 0;
        boolean verder = true;
        do
        {
            try
            {
                // dc.draaienKaart(keuze);
                
                System.out.println(dc.getTaal().getText("inschuivenKaartX"));
                xPositie = input.nextInt();
                System.out.println(dc.getTaal().getText("inschuivenKaartY"));
                yPositie = input.nextInt();
                dc.geefPlaatsVrijeGangkaart(xPositie, yPositie);
                verder = false;
            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("fouteCoordinaat"));

            }
        } while (verder != false);

    }

//    public static void draaiVrijeGangkaart(DomeinController dc, Scanner input) {
//
//        draaienKaart(dc, input);
//    }
//  public static void draaienKaart(DomeinController dc, Scanner input) {
//        Gangkaart[] draaiKaart;
//        geefPlaatsVrijeGangkaartIn(dc, input);
//        System.out.println(dc.getTaal().getText("draaiKaart"));
//        int keuze = 0;
//        dc.draaienKaart(keuze);
//
//        while (keuze == 0) {
//
//            try {
//                keuze = input.nextInt();
//                if (!(keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4)) {
//                    throw new WrongInputException("verkeerdeKeuze");
//                } else {
//
//                    dc.geefGekozenKaart(keuze);
//                }
//                bevestigKeuzeRichting(dc, input, null);
//            } catch (WrongInputException e) {
//                System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
//                input.nextLine();
//                keuze = 0;
//            } catch (InputMismatchException e) {
//                System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
//                input.nextLine();
//                keuze = 0;
//            }
//        }
//    }
//
//    public static void bevestigKeuzeRichting(DomeinController dc, Scanner input, Gangkaart gk) {
//        String keuze;
//        boolean verder = true;
//        do {
//            try {
//                input.nextLine();
//                System.out.println(dc.getTaal().getText("bevestigDraaiing"));
//                keuze = input.nextLine();
//
//                if (keuze.equalsIgnoreCase(dc.getTaal().getText("ja"))) {
//                    UC5.verplaatsSpeler(dc, input);
//                    verder = false;
//                } else {
//                    if (keuze.equalsIgnoreCase(dc.getTaal().getText("nee"))) {
//                        dc.draaienKaart(keuze);
//                    } else {
//                        throw new WrongInputException("fouteInvoer");
//                    }
//
//                }
//            } catch (WrongInputException e) {
//                System.out.println(dc.getTaal().getText("fouteInvoer"));
//                input.nextLine();
//            }
//        } while (verder != false);
//    }
}
