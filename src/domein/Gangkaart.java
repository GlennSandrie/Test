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
import utils.Kleur;
import utils.Schat;


/**
 *
 * @author anjana
 */
public class Gangkaart 
{
    /**
     * 
     */
    private Schat schat;
    private Kleur kleur;
    private String richting;
    private List<Speler> spelers;

    /**
     * 
     * @param schat
     * @param speler
     * @param kleur
     * @param richting

     */
    public Gangkaart(Schat schat, Kleur kleur, String richting) 
    {
        this.schat = schat;
        this.kleur = kleur;
        this.richting = richting;
        spelers = new ArrayList<>();
    }
    
    /**
     * 
     * @param schat
     * @param richting 
     */
    public Gangkaart(Schat schat, String richting) 
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
    
     public Kleur getKleur()
    {
        return kleur;
    }
    
     public void addSpeler (Speler speler) 
     {
        this.spelers.add(speler);
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
