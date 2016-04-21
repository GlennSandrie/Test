/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.DomeinController;
import java.util.Scanner;

/**
 *
 * @author anjana
 */
public class UC3
{

    public static void bepaalVolgendeSpeler(DomeinController dc, Scanner sc)
    {
        dc.bepaalVolgendeSpelerAanDeBeurt();
        System.out.println(dc.getTaal().getText("volgendeSpeler") + dc.bepaalVolgendeSpelerAanDeBeurt());

    }
}
