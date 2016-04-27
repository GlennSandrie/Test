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
import java.util.Scanner;
import utils.Kleur;

/**
 *
 * @author Aïssa
 */
public class UC2
{

    public static void maakNieuwSpel(DomeinController dc, Scanner input)
    {
        String naam;
        System.out.println(dc.getTaal().getText("nieuwSpel"));
        naam = input.nextLine();
        dc.maakSpel(naam);
        int aantal = 0;
        boolean vlag = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("aantalSpelers"));
                aantal = input.nextInt();
                //input.nextLine();
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

    public static void registreerSpeler(DomeinController dc, Scanner input)
    {

        String naam = null;
        int geboortejaar = 0, nrKleur;
        Kleur kleur = null;
        boolean verder = true;
        do
        {
            try
            {
                System.out.println(dc.getTaal().getText("spelerNaam"));
                naam = input.nextLine();
                if (!naam.matches("^[a-zA-Z].{1,50}$"))
                {
                    throw new InvalidNameException("fouteNaam");
                } else
                {
                    verder = false;
                }
            } catch (InvalidNameException e)
            {
                System.out.println(dc.getTaal().getText("fouteNaam"));
            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("fouteNaam"));
            }
        } while (verder != false);

        int huidigJaar = GregorianCalendar.getInstance().get(Calendar.YEAR);

        while (geboortejaar < huidigJaar - 90 || geboortejaar > huidigJaar - 7)
        {
            try
            {
                System.out.println(dc.getTaal().getText("spelerGebdatum"));
                geboortejaar = input.nextInt();

                if (geboortejaar < huidigJaar - 90 || geboortejaar > huidigJaar - 7)
                {
                    throw new InvalidBirthdateException("foutGeboortejaar");
                }
            } catch (InvalidBirthdateException e)
            {
                System.out.println(dc.getTaal().getText(e.getMessage()));
                input.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("foutGeboortejaar"));
                input.nextLine();
            }
        }
        input.nextLine();

        while (kleur == null)
        {
            try
            {

                System.out.println(dc.getTaal().getText("spelerKleur"));
                System.out.println("1. " + dc.getTaal().getText("geel"));
                System.out.println("2. " + dc.getTaal().getText("blauw"));
                System.out.println("3. " + dc.getTaal().getText("rood"));
                System.out.println("4. " + dc.getTaal().getText("groen"));

                nrKleur = input.nextInt();
                for (Kleur k : Kleur.values())
                {
                    if (k.getKleurNr() == nrKleur)
                    {
                        kleur = k;
                    }
                }
                dc.registreer(naam, geboortejaar, kleur);
            } catch (IllegalArgumentException e)
            {
                System.out.println(dc.getTaal().getText("kleurBestaat"));
                kleur = null;
                input.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("fouteNummerKleur"));
                kleur = null;
                input.nextLine();
            } catch (NullPointerException e)
            {
                System.out.println(dc.getTaal().getText("fouteNummerKleur"));
                input.nextLine();
            }
        }
        input.nextLine();
    }

    public static void geefVolledigSpel(DomeinController dc)
    {

        for (int i = 0; i < dc.geefSpel().length; i++)
        {
            int begin = 0;
            int einde = 11;
            /*if (i == 0)
             {
             System.out.printf("%s", dc.geefSpel()[0][0]);
             for (int k = 1; k < dc.geefSpel()[i].length; k++)
             {
             System.out.printf("%s%12s", dc.geefSpel()[0][k], "");
             }
             System.out.println();
             } else
             {
             boolean coord = false;*/
            while (begin < 72)
            {
                for (int j = 0; j < dc.geefSpel()[i].length; j++)
                {
                    /*if (j == 0)
                     {
                     if (begin % 72 == 0)
                     {
                     System.out.printf(dc.geefSpel()[i][j]);
                     } else
                     {
                     System.out.printf(" ");
                     }
                     coord = true;
                     } else
                     {*/
                    System.out.printf(dc.geefSpel()[i][j].substring(begin, einde + 1));
                    //coord = false;
                }
                //}
                // if (coord == false)
                // {
                begin += 12;
                einde += 12;
                // }
                System.out.println();
            }
            //  }
        }

        System.out.println();
        System.out.println(dc.geefHuidigeSpeler());
        try {
            System.out.println(dc.geefDoelkaartVanHuidigeSpeler());
        } catch (EmptyListException ex) {
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
