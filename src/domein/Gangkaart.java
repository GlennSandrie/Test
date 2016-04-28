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
import utils.Richting;
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
    protected Schat schat;
    protected Kleur kleur;
    protected Richting richting;
    protected List<Speler> spelers;


   //private Coördinaat coördinaat;
    /**
     *
     * @param coördinaat
     */
    /*  public Gangkaart( Coördinaat coördinaat)
     {
       
     this.coördinaat = coördinaat;
     }*/
    /**
     *
     * @param schat
     * @param kleur
     * @param richting
     */
    public Gangkaart(Schat schat, Kleur kleur, Richting richting)
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
    public Gangkaart(Schat schat, Richting richting)
    {
        this(schat, null, richting);
    }

    /**
     *
     * @param richting
     */
    public Gangkaart(Richting richting)
    {
        this(null, null, richting);
    }

    public Kleur getKleur()
    {
        return kleur;
    }

    public List<Speler> getSpelers()
    {
        return spelers;
    }

    public Richting getRichting()
    {
        return richting;
    }

    public void voegSpelerToe(Speler speler)
    {
        this.spelers.add(speler);
    }

    public void verwijderSpeler(Speler speler)
    {
        this.spelers.remove(speler);
    }
    
    public Richting draaiVrijeGangkaart(int keuze)
    {
        if(keuze==1)
        {
            richting= Richting.B;
        }
        else if(keuze==2)
                {
                    richting= Richting.R;
                }
        else if(keuze==3)
                {
                    richting= Richting.O;
                }
        else if(keuze==4)
                {
                    richting= Richting.L;
                }
        return richting;
    }
    
    public List<Richting> geefVerplaatsRichtingen(){
        ArrayList<Richting> al = new ArrayList();
        for (Richting r : Richting.values()){
            al.add(r);
        }
        return al;
    }
    /*
     *
     *Tijdelijke methode om spel af te printen op het scherm
     */


}
