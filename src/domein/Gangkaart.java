/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

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
    private Speler speler;
    private int xPositie, yPositie;

    /**
     * 
     * @param schat
     * @param speler
     * @param kleur
     * @param richting
     * @param xPositie
     * @param yPositie 
     */
    public Gangkaart(String schat, Speler speler, String kleur, String richting, int xPositie, int yPositie) 
    {
        this.schat = schat;
        this.speler = speler;
        this.kleur = kleur;
        this.richting = richting;
        this.xPositie = xPositie;
        this.yPositie = yPositie;
    }
    
    /**
     * 
     * @param schat
     * @param kleur
     * @param richting 
     */
    public Gangkaart(String schat, String kleur, String richting) 
    {
        this(schat, null, kleur, richting, 0, 0);
    }
    
    /**
     * 
     * @param schat
     * @param richting 
     */
    public Gangkaart(String schat, String richting) 
    {
        this(schat, null, null, richting, 0, 0);
    }
    
    /**
     * 
     * @param richting 
     */
    public Gangkaart(String richting)
    {
        this(null, null, null, richting, 0, 0);
    }
    
     public String getKleur()
    {
        return kleur;
    }
     
     public void setSpeler (Speler speler) //add
     {
         this.speler = speler;
     }
    
    /**
     * 
     */
    public void schudLosseKaarten(List<Gangkaart> gk)
    {
        Collections.shuffle(gk);
    }
}
