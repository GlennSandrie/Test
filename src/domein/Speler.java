/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.InvalidNameException;
import java.util.List;
import utils.Kleur;



/**
 *
 * @author anjana
 */
public class Speler 
{
    //attributen
    private final String naam;
    private final Kleur kleur;
    private final int geboortejaar;
    private List<Doelkaart> doelkaarten;

    //constructor

    /**
     *
     * @param naam
     * @param geboortejaar
     * @param kleur
     */
    public Speler(String naam, int geboortejaar, Kleur kleur) 
    {
        this.naam=naam;
        this.geboortejaar = geboortejaar;
        this.kleur = kleur;
    }

    //controles + getters + setters

    /**
     *
     * @return
     */
    public String getNaam()
    {
        return naam;
    }
    
    /**
     *
     * @return
     */
    public Kleur getKleur()
    {
        return kleur;
    }

    /**
     *
     * @return
     */
    public int getGeboortejaar()
    {
        return geboortejaar;
    }
    
    
    
    //methodes
    // oproepen binnen de constructor
    // controle voor geboortejaar ook toevoegen
    
    private void controleerNaam(String naam)
    {
        DomeinController dc = new DomeinController();
        if (naam.length()<2||naam.matches("*[a-z],*[A-Z])"))
            throw new InvalidNameException("fouteNaam");
    }
    
    public void voegDoelkaartToe(Doelkaart doelkaart)
    {
        doelkaarten.add(doelkaart);
    }
}
