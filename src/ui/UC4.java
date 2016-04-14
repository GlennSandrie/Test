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
    private static Gangkaart[] draaiKaart;
    private static Gangkaart keuzeKaart;

    public static void draaiVrijeGangkaart(DomeinController dc, Scanner input)
    {
        System.out.println(dc.getTaal().getText("inschuivenKaart"));
        System.out.println(dc.getTaal().getText("draaiKaart"));
        draaienKaart(dc, input);
    }

    public static void draaienKaart(DomeinController dc, Scanner input)
    {
        int keuze = 0;
        if (dc.bepaalTypeLosseKaart() instanceof HoekKaart)
        {
            System.out.printf("%s%20s%20s%20s%n", "1.", "2.", "3.", "4.");
            //System.out.printf("2. ");"
            draaiKaart = new Gangkaart[4];
            Richting[] richtingen = {Richting.O,Richting.R};      
            draaiKaart[0] = new HoekKaart(null, richtingen);
            Richting[] richtingen2 = {Richting.O,Richting.L};
            draaiKaart[1] = new HoekKaart(null, richtingen2);
            Richting[] richtingen3 = {Richting.B,Richting.R};
            draaiKaart[2] = new HoekKaart(null,richtingen3);
            Richting[] richtingen4 = {Richting.B,Richting.L};
            draaiKaart[3] = new HoekKaart(null,richtingen4);

            printKaart();

            while (keuze == 0)
            {
                try
                {
                    keuze = input.nextInt();
                    if (!(keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4))
                    {
                        throw new WrongInputException("verkeerdeKeuze");
                    } else
                    {
                        if (keuze == 1)
                        {
                            keuzeKaart = new HoekKaart(null, richtingen);
                            printKeuzeKaart();
                        } else
                        {
                            if (keuze == 2)
                            {
                                keuzeKaart = new HoekKaart(null, richtingen2);
                                printKeuzeKaart();
                            } else
                            {
                                if (keuze == 3)
                                {
                                    keuzeKaart = new HoekKaart(null, richtingen3);
                                    printKeuzeKaart();
                                } else if (keuze == 4)
                                {
                                    keuzeKaart = new HoekKaart(null, richtingen4);
                                    printKeuzeKaart();
                                }
                            }
                        }
                    }
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

        } else if (dc.bepaalTypeLosseKaart() instanceof Tkaart)
        {
            System.out.printf("%s%20s%20s%20s%n", "1.", "2.", "3.", "4.");
            draaiKaart = new Gangkaart[4];
            Richting[] richtingen = {Richting.O,Richting.L,Richting.R};
            Richting[] richtingen2 = {Richting.R,Richting.O,Richting.B};
            Richting[] richtingen3 = {Richting.B,Richting.R,Richting.L};
            Richting[] richtingen4 = {Richting.L,Richting.B,Richting.O};
            draaiKaart[0] = new Tkaart(null, richtingen4);
            draaiKaart[1] = new Tkaart(null, richtingen2);
            draaiKaart[2] = new Tkaart(null, richtingen3);
            draaiKaart[3] = new Tkaart(null, richtingen);

            printKaart();
            while (keuze == 0)
            {
                try
                {
                    keuze = input.nextInt();
                    if (!(keuze == 1 || keuze == 2 || keuze == 3 || keuze == 4))
                    {
                        throw new WrongInputException("verkeerdeKeuze");
                    } else
                    {
                        if (keuze == 1)
                        {
                            keuzeKaart = new Tkaart(null, richtingen4);
                            printKeuzeKaart();
                        } else
                        {
                            if (keuze == 2)
                            {
                                keuzeKaart = new Tkaart(null, richtingen2);
                                printKeuzeKaart();
                            } else
                            {
                                if (keuze == 3)
                                {
                                    draaiKaart[0] = new Tkaart(null, richtingen3);
                                    printKeuzeKaart();
                                } else if (keuze == 4)
                                {
                                    draaiKaart[0] = new Tkaart(null, richtingen);
                                    printKeuzeKaart();
                                }
                            }
                        }
                    }
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
            if (dc.bepaalTypeLosseKaart() instanceof RechteWegKaart)
            {
                System.out.printf("%s%20s%n", "1.", "2.");
                draaiKaart = new Gangkaart[2];
                Richting[] richtingen = {Richting.B,Richting.O};
                Richting[] richtingen2 = {Richting.R,Richting.L};
                draaiKaart[0] = new RechteWegKaart(richtingen2);
                draaiKaart[1] = new RechteWegKaart(richtingen);

                printKaart();
                while (keuze == 0)
                {
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
                                keuzeKaart = new RechteWegKaart(richtingen2);
                                printKeuzeKaart();
                            } else
                            {
                                if (keuze == 2)
                                {
                                    keuzeKaart = new RechteWegKaart(richtingen);
                                    printKeuzeKaart();
                                }

                            }
                        }
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

            }
        }

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
            System.out.printf(keuzeKaart.toString().substring(begin, einde + 1));
            begin += 12;
            einde += 12;
            System.out.println("");
        }
    }

}
