/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private static Gangkaart[] draaiKaart;
    private static Gangkaart[] keuzeKaart;

    public static void geefPlaatsVrijeGangkaartIn(DomeinController dc, Scanner input)
    {
        String coord;
        boolean verder = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("inschuivenKaart"));
                coord = input.nextLine();

                if (!(coord.equalsIgnoreCase("B1") || coord.equalsIgnoreCase("D1") || coord.equalsIgnoreCase("F1")
                        || coord.equalsIgnoreCase("A2") || coord.equalsIgnoreCase("A4") || coord.equalsIgnoreCase("A6")
                        || coord.equalsIgnoreCase("G2") || coord.equalsIgnoreCase("G4") || coord.equalsIgnoreCase("G6")
                        || coord.equalsIgnoreCase("B7") || coord.equalsIgnoreCase("D7") || coord.equalsIgnoreCase("F7")
                        || coord.equalsIgnoreCase("1B") || coord.equalsIgnoreCase("1D") || coord.equalsIgnoreCase("1F")
                        || coord.equalsIgnoreCase("2A") || coord.equalsIgnoreCase("4A") || coord.equalsIgnoreCase("6A")
                        || coord.equalsIgnoreCase("2G") || coord.equalsIgnoreCase("4G") || coord.equalsIgnoreCase("6G")
                        || coord.equalsIgnoreCase("7B") || coord.equalsIgnoreCase("7D") || coord.equalsIgnoreCase("7F")))
                {
                    throw new InvalidCoordinateException("fouteCoordinaat");
                } else
                {
                    verder = false;
                }

            } catch (InvalidCoordinateException e)
            {
                System.out.println(dc.getTaal().getText("fouteCoordinaat"));

            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("fouteCoordinaat"));

            }
        } while (verder != false);
    }

    public static void draaiVrijeGangkaart(DomeinController dc, Scanner input)
    {

        draaienKaart(dc, input);
    }

    public static void draaienKaart(DomeinController dc, Scanner input)
    {
        geefPlaatsVrijeGangkaartIn(dc, input);
        System.out.println(dc.getTaal().getText("draaiKaart"));
        int keuze = 0;
        if (dc.bepaalTypeLosseKaart() instanceof HoekKaart)
        {
            System.out.printf("%s%20s%20s%20s%n", "1.", "2.", "3.", "4.");

            draaiKaart = new Gangkaart[4];

            draaiKaart[0] = new HoekKaart(null, "or");
            draaiKaart[1] = new HoekKaart(null, "ol");
            draaiKaart[2] = new HoekKaart(null, "br");
            draaiKaart[3] = new HoekKaart(null, "bl");

            printKaart();

            while (keuze == 0)
            {
                try
                {
                    keuzeKaart = new Gangkaart[1];
                    keuze = input.nextInt();
                    if (!(keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4))
                    {
                        throw new WrongInputException("verkeerdeKeuze");
                    } else
                    {
                        if (keuze == 1)
                        {
                            keuzeKaart[0] = new HoekKaart(null, "or");
                            printKeuzeKaart();
                        } else
                        {
                            if (keuze == 2)
                            {
                                keuzeKaart[0] = new HoekKaart(null, "ol");
                                printKeuzeKaart();
                            } else
                            {
                                if (keuze == 3)
                                {
                                    keuzeKaart[0] = new HoekKaart(null, "br");
                                    printKeuzeKaart();
                                } else if (keuze == 4)
                                {
                                    keuzeKaart[0] = new HoekKaart(null, "bl");
                                    printKeuzeKaart();
                                }
                            }
                        }
                    }
                    bevestigKeuzeRichting(dc, input, null);
                } catch (WrongInputException e)
                {
                    System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
                    input.nextLine();
                    keuze = 0;
                } catch (InputMismatchException e)
                {
                    System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
                    input.nextLine();
                    keuze = 0;
                }
            }

        } else
        {
            if (dc.bepaalTypeLosseKaart() instanceof Tkaart)
            {
                System.out.printf("%s%20s%20s%20s%n", "1.", "2.", "3.", "4.");
                draaiKaart = new Gangkaart[4];

                draaiKaart[0] = new Tkaart(null, "l");
                draaiKaart[1] = new Tkaart(null, "r");
                draaiKaart[2] = new Tkaart(null, "b");
                draaiKaart[3] = new Tkaart(null, "o");

                printKaart();
                while (keuze == 0)
                {
                    try
                    {
                        keuzeKaart = new Gangkaart[1];
                        keuze = input.nextInt();
                        if (!(keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4))
                        {
                            throw new WrongInputException("verkeerdeKeuze");
                        } else
                        {
                            if (keuze == 1)
                            {
                                keuzeKaart[0] = new Tkaart(null, "l");
                                printKeuzeKaart();
                            } else
                            {
                                if (keuze == 2)
                                {
                                    keuzeKaart[0] = new Tkaart(null, "r");
                                    printKeuzeKaart();
                                } else
                                {
                                    if (keuze == 3)
                                    {
                                        draaiKaart[0] = new Tkaart(null, "b");
                                        printKeuzeKaart();
                                    } else if (keuze == 4)
                                    {
                                        draaiKaart[0] = new Tkaart(null, "o");
                                        printKeuzeKaart();
                                    }
                                }
                            }
                        }
                        bevestigKeuzeRichting(dc, input, null);
                    } catch (WrongInputException e)
                    {
                        System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
                        input.nextLine();
                        keuze = 0;
                    } catch (InputMismatchException e)
                    {
                        System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
                        input.nextLine();
                        keuze = 0;
                    }
                }

            } else
            {
                //if (dc.bepaalTypeLosseKaart() instanceof RechteWegKaart)
                //{
                System.out.printf("%s%20s%n", "1.", "2.");
                draaiKaart = new Gangkaart[2];

                draaiKaart[0] = new RechteWegKaart("h");
                draaiKaart[1] = new RechteWegKaart("v");

                printKaart();
                while (keuze == 0)
                {
                    keuzeKaart = new Gangkaart[1];
                    try
                    {
                        keuze = input.nextInt();
                        if (!(keuze == 1 || keuze == 2))
                        {
                            throw new WrongInputException("verkeerdeKeuze");
                        } else
                        {
                            if (keuze == 1)
                            {
                                keuzeKaart[0] = new RechteWegKaart("h");
                                printKeuzeKaart();
                            } else
                            {
                                if (keuze == 2)
                                {
                                    keuzeKaart[0] = new RechteWegKaart("v");
                                    printKeuzeKaart();
                                }

                            }
                        }
                        bevestigKeuzeRichting(dc, input, null);
                    } catch (WrongInputException | InputMismatchException e)
                    {
                        System.out.println(dc.getTaal().getText("verkeerdeKeuze"));
                        input.nextLine();
                        keuze = 0;
                    }
                }

            }

        }
        input.nextLine();
    }

    public static void printKaart()
    {
        int begin = 0;
        int einde = 11;
        while (begin < 72)
        {
            for (int j = 0; j < draaiKaart.length; j++)
            {
                System.out.printf(draaiKaart[j].toString().substring(begin, einde + 1));
                System.out.printf("        ");
            }
            begin += 12;
            einde += 12;
            System.out.println();
        }
    }

    public static void printKeuzeKaart()
    {
        int begin = 0;
        int einde = 11;
        while (begin < 72)
        {
            for (int i = 0; i < keuzeKaart.length; i++)
            {
                System.out.printf(keuzeKaart[i].toString().substring(begin, einde + 1));
            }
            begin += 12;
            einde += 12;
            System.out.println("");
        }
    }

    public static void bevestigKeuzeRichting(DomeinController dc, Scanner input, Gangkaart gk)
    {
        String keuze;
        boolean verder = true;
        do
        {
            try
            {
                input.nextLine();
                System.out.println(dc.getTaal().getText("bevestigDraaiing"));
                keuze = input.nextLine();

                if (keuze.equalsIgnoreCase(dc.getTaal().getText("ja")))
                {
                    UC5.verplaatsSpeler(gk);
                    verder = false;
                } else

                {
                    if (keuze.equalsIgnoreCase(dc.getTaal().getText("nee")))
                    {
                        draaiVrijeGangkaart(dc, input);
                    } else
                    {
                        throw new WrongInputException("fouteInvoer");
                    }

                }
            } catch (WrongInputException e)
            {
                System.out.println(dc.getTaal().getText("fouteInvoer"));
                input.nextLine();
            }
        } while (verder != false);
    }

}
