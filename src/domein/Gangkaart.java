/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author anjana
 */
public class Gangkaart 
{
    /**
     * 
     */
    private String schat, kleur, richting;
    private List<Speler> speler;

    /**
     * 
     * @param schat
     * @param speler
     * @param kleur
     * @param richting

     */
    public Gangkaart(String schat, String kleur, String richting) 
    {
        this.schat = schat;
        this.kleur = kleur;
        this.richting = richting;
        speler = new ArrayList<>();
    }
    
    /**
     * 
     * @param schat
     * @param richting 
     */
    public Gangkaart(String schat, String richting) 
    {
        this(schat, null, richting);
    }
    
    
    /**
     * 
     * @param richting 
     */
    public Gangkaart(String richting)
    {
        this(null, null, richting);
    }
    
     public String getKleur()
    {
        return kleur;
    }
    
     public void addSpeler (Speler speler) 
     {
        this.speler.add(speler);
     }
    
     /*
     *
     *Tijdelijke methode om spel af te printen op het scherm
     */
     @Override
     public String toString()
     {
         return String.format(this.getClass().getSimpleName()+ " met als schat "+this.schat);
     }
    
}
