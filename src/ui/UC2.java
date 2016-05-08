/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import exceptions.EmptyListException;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import exceptions.WrongInputException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import utils.Kleur;

/**
 *
 * @author Aïssa
 */
public class UC2
{

    /**
     * methode om een nieuw spel te maken, controleert de naam van het nieuwe
     * spel, het aantal spelers, roept de domeincontroller aan om het volledig
     * spel te initialiseren
     *
     * @param dc
     * @param input
     */
    public static void maakNieuwSpel(DomeinController dc, Scanner input)
    {
        String naam = "";
        boolean vlag2 = true;
        do
        {
            try
            {

                System.out.println(dc.getTaal().getText("nieuwSpel"));
                naam = input.nextLine();
                if (!(naam.matches("(?=.*\\d.*\\d)[a-zA-Z0-9]{8,}")))
                {
                    throw new InvalidNameException(dc.getTaal().getText("fouteSpelnaam"));

                } else
                {
                    dc.maakSpel(naam);
                    vlag2 = false;
                }
            } catch (InvalidNameException e)
            {
                System.out.println(dc.getTaal().getText("fouteSpelnaam"));
            }
        } while (vlag2);

        int aantal = 0;
        boolean vlag = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("aantalSpelers"));
                aantal = input.nextInt();
                if (!(aantal == 2 || aantal == 3 || aantal == 4))
                {
                    throw new WrongInputException("aantalSpelersFout");
                } else
                {
                    vlag = false;
                }

            } catch (WrongInputException | InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("aantalSpelersFout"));
                input.nextLine();
            }
        } while (vlag);
        input.nextLine();

        boolean fout = true;
        while (fout == true)
        {
            for (int i = 0; i < aantal; i++)
            {
                registreerSpeler(dc, input);
                fout = false;
            }
        }
        dc.initialiseerVolledigSpel();
    }

    /**
     * methode om een nieuwe speler te initialiseren, controleert de spelernaam,
     * het geboortejaar, en de kleur
     *
     * @param dc
     * @param input
     */
    public static void registreerSpeler(DomeinController dc, Scanner input)
    {
        List<String> spelnamen = dc.geefSpelnamen();
        String naam = "";
        int geboortejaar = 0, nrKleur;
        Kleur kleur = null;
        boolean verder = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("spelerNaam"));
                naam = input.nextLine();
                for (String spelnaam : spelnamen)
                {
                    for (String s : dc.geefSpelersVanSpel(spelnaam))
                    {
                        if (!(naam.matches("^[a-zA-Z]{2,}$")))
                        {
                            throw new InvalidNameException("fouteNaam");
                        } else
                        {
                            break;
                        }
                    }
                }
                for (String s : dc.geefSpelers())
                {
                    if (s.equals(naam))
                    {
                        throw new InvalidNameException("naamBestaat");
                    } else
                    {
                        break;
                    }
                }
                verder = false;

            } catch (InvalidNameException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));

            }
        } while (verder != false);
        boolean fout = true;
        do
        {
            try
            {

                System.out.println(dc.getTaal().getText("spelerGebdatum"));
                geboortejaar = input.nextInt();
                int huidigJaar = GregorianCalendar.getInstance().get(Calendar.YEAR);
                if (geboortejaar < huidigJaar - 90 || geboortejaar > huidigJaar - 7)
                {
                    throw new InvalidBirthdateException("foutGeboortejaar");
                } else
                {
                    fout = false;
                }
            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("foutGeboortejaar"));
                input.nextLine();
            } catch (InvalidBirthdateException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));
                input.nextLine();
            }
        } while (fout);

        boolean fout2 = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("spelerKleur"));
                System.out.println("1. " + dc.getTaal().getText("geel"));
                System.out.println("2. " + dc.getTaal().getText("blauw"));
                System.out.println("3. " + dc.getTaal().getText("rood"));
                System.out.println("4. " + dc.getTaal().getText("groen"));

                nrKleur = input.nextInt();
                if (!(nrKleur == 1 || nrKleur == 2 || nrKleur == 3 || nrKleur == 4))
                {
                    throw new InputMismatchException(dc.getTaal().getText("fouteNummerKleur"));
                }
                else{
                    fout2 = false;
                }
                    for (Kleur k : Kleur.values())
                    {
                        if (k.getKleurNr() == nrKleur)
                        {
                            kleur = k;
                            break;
                        }
                    }
            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("fouteNummerKleur"));
                kleur = null;
                input.nextLine();
            } catch (WrongInputException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));
                kleur = null;
                input.nextLine();
            } catch (NullPointerException e)
            {
                System.out.println(dc.getTaal().getText("kleurBestaat"));
                kleur = null;
                input.nextLine();
            }
        } while (fout2);
        dc.registreer(naam, geboortejaar, kleur);
        input.nextLine();
    }

    /**
     * methode om het spelbord uit te printen
     *
     * @param dc
     */
    public static void geefSpelbord(DomeinController dc)
    {
        for (int i = 0; i < dc.geefSpel().length; i++)
        {
            int begin = 0;
            int einde = 11;

            while (begin < 72)
            {
                for (int j = 0; j < dc.geefSpel()[i].length; j++)
                {
                    System.out.printf(dc.geefSpel()[i][j].substring(begin, einde + 1));
                }
                begin += 12;
                einde += 12;
                System.out.println();
            }
        }

        System.out.println();
    }

    /**
     * methode om het volledige spel weer te geven, geeft het spelbord, de
     * huidige speler, de doelkaar van de huidige speler en de vrije gangkaart
     *
     * @param dc
     */
    public static void geefVolledigSpel(DomeinController dc)
    {
        geefSpelbord(dc);
        System.out.println(dc.geefHuidigeSpeler());
        try
        {
            System.out.println(dc.geefDoelkaartVanHuidigeSpeler());
        } catch (EmptyListException ex)
        {
            System.out.println(dc.getTaal().getText(ex.getMessage()));
        }
        System.out.println();
        int begin = 0;
        int einde = 11;
        while (begin < 72)
        {
            System.out.printf(dc.geefVrijeGangkaart().substring(begin, einde + 1));
            begin += 12;
            einde += 12;
            System.out.println();
        }
    }
}
