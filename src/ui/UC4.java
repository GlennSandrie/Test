package ui;

import domein.DomeinController;
import exceptions.InvalidCoordinateException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class UC4
{

    /**
     * methode om de coordinaten waar de speler de vrije gangkaart wil
     * inschuiven, in te voeren. Als de speler een coordinaat van een vaste
     * gangkaart wilt invoeren wordt er een exception gethrowd
     *
     * @param dc
     * @param input
     */
    public static void geefPlaatsVrijeGangkaartIn(DomeinController dc, Scanner input)
    {
        int xPositie, yPositie;
        int keuze = 0;
        boolean verder = true;
        do
        {
            try
            {
                draaiVrijeGangkaart(dc, input);

                System.out.println(dc.getTaal().getText("inschuivenKaartX"));
                xPositie = input.nextInt();
                System.out.println(dc.getTaal().getText("inschuivenKaartY"));
                yPositie = input.nextInt();
                dc.geefPlaatsVrijeGangkaart(xPositie, yPositie);
                UC2.geefSpelbord(dc);
                verder = false;
                //            throw new InputMismatchException();
            } catch (IllegalArgumentException | InputMismatchException e)
            {
                System.out.println(dc.getTaal().getText("fouteCoordinaat"));
            }catch(InvalidCoordinateException e)
            {
                System.out.println(dc.getTaal().getText("ongeldigeBeurt"));
            }
        } while (verder != false);

    }

    /**
     * methode om de vrije gangkaart in een richting naar keuze te draaien
     *
     * @param dc
     * @param input
     */
    public static void draaiVrijeGangkaart(DomeinController dc, Scanner input)
    {
        int keuze = 0;
        try
        {
            System.out.println(dc.getTaal().getText("draaiKaart"));
            System.out.println("1." + dc.getTaal().getText("B"));
            System.out.println("2." + dc.getTaal().getText("R"));
            System.out.println("3." + dc.getTaal().getText("O"));
            System.out.println("4." + dc.getTaal().getText("L"));
            keuze = input.nextInt();
            dc.draaiVrijeGangkaart(keuze);
        } catch (InputMismatchException e)
        {
            System.out.println(dc.getTaal().getText(null));
        }
    }
}
