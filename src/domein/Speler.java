/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;



/**
 *
 * @author anjana
 */
public class Speler 
{
    //attributen
    private final String naam;
    private final String kleur;
    private final int geboortejaar;

    //constructor

    /**
     *
     * @param naam
     * @param geboortejaar
     * @param kleur
     */
    public Speler(String naam, int geboortejaar, String kleur) 
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
    public String getKleur()
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
    
}
