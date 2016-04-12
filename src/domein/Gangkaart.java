/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import utils.Coördinaat;
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
    private Coördinaat coördinaat;
    
    
    /**
     * 
     * @param schat
     * @param speler
     * @param kleur
     * @param richting
     * @param coördinaat

     */

    public Gangkaart( Coördinaat coördinaat)
    {
       
        this.coördinaat = coördinaat;
    }
       

    
    
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
        String kaart="";
        if (richting == null)
            {
                kaart = coördinaat.getCoördinaat();
            }
        else {
            if (schat==null)
            {
                switch (richting) {
                    case "or":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "xxx         "+
                                              "xxx         "+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "ol":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "         xxx"+
                                              "         xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "bl":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "         xxx"+
                                              "         xxx"+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                    case "br":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx         "+
                                              "xxx         "+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                    case "o":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "            "+
                                              "            "+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "b":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "            "+
                                              "            "+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                    case "l":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "         xxx"+
                                              "         xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "r":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx         "+
                                              "xxx         "+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "v":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "h":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "            "+
                                              "            "+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                }
            }
            else {
                switch (richting) {
                    case "or":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "xxx         "+
                                              "xxx  S      "+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "ol":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "         xxx"+
                                              "       S xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "bl":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "     S   xxx"+
                                              "         xxx"+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                    case "br":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx  S      "+
                                              "xxx         "+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                    case "o":
                        kaart = String.format("xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx"+
                                              "            "+
                                              "     S      "+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "b":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "     S      "+
                                              "            "+
                                              "xxxxxxxxxxxx"+
                                              "xxxxxxxxxxxx");
                        break;
                    case "l":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "     S   xxx"+
                                              "         xxx"+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                    case "r":
                        kaart = String.format("xxx      xxx"+
                                              "xxx      xxx"+
                                              "xxx  S      "+
                                              "xxx         "+
                                              "xxx      xxx"+
                                              "xxx      xxx");
                        break;
                }
            }
        }
        return kaart;
    }
}
     
