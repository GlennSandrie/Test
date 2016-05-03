/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Gangkaart
{

    protected Schat schat;
    protected Kleur kleur;
    protected Richting richting;
    protected List<Speler> spelers;

    /**
     * constructor, initialiseer de kleur, riching en schat van de gangkaart
     *
     * @param schat kan 1 van de 24 schatten zijn
     * @param kleur kan rood, geel, groen of blauw zijn
     * @param richting kan boven, links, onder, rechts zijn
     */
    public Gangkaart(Schat schat, Kleur kleur, Richting richting)
    {
        this.schat = schat;
        this.kleur = kleur;
        this.richting = richting;
        spelers = new ArrayList<>();
    }

    /**
     * initialiseert de schat en richting aan de hand van de volledige
     * constructor
     *
     * @param schat kan 1 van de 24 schatten zijn
     * @param richting kan boven, links, onder, rechts zijn
     */
    public Gangkaart(Schat schat, Richting richting)
    {
        this(schat, null, richting);
    }

    /**
     * intitialiseerd de richting aan de hand van de volledige constructor
     *
     * @param richting kan boven, links, onder, rechts zijn
     */
    public Gangkaart(Richting richting)
    {
        this(null, null, richting);
    }

    /**
     * methode die de kleur teruggeeft
     *
     * @return mogelijke kleur van de gangkaart
     */
    public Kleur getKleur()
    {
        return kleur;
    }
    /**
     * 
     * @param kleur 
     */
    public void setKleur(Kleur kleur)
    {
        this.kleur = kleur;
    }
    
    /**
     * methode die een lijst van spelers teruggeeft
     *
     * @return lijst van spelers die op de gangkaart staat
     */
    public List<Speler> getSpelers()
    {
        return spelers;
    }

    /**
     * methode die de richting teruggeeft
     *
     * @return richting van de gangkaart
     */
    public Richting getRichting()
    {
        return richting;
    }

    /**
     * voegt een speler toe aan een gangkaart
     *
     * @param speler
     */
    public void voegSpelerToe(Speler speler)
    {
        this.spelers.add(speler);
    }

    /**
     * verwijdert een speler van een gangkaart
     *
     * @param speler
     */
    public void verwijderSpeler(Speler speler)
    {
        this.spelers.remove(speler);
    }

    /**
     * bepaalt aan de hand van een keuze welke richting je de gangkaart wilt
     * draaien
     *
     * @param keuze
     * @return richting die je gekozen hebt om de vrijeGangkaart te draaien
     */
    public Richting draaiVrijeGangkaart(int keuze)
    {
        if (keuze == 1)
        {
            richting = Richting.B;
        } else if (keuze == 2)
        {
            richting = Richting.R;
        } else if (keuze == 3)
        {
            richting = Richting.O;
        } else if (keuze == 4)
        {
            richting = Richting.L;
        }
        return richting;
    }

    /**
     * methode die een lijst van de mogelijke richtingen waarin de speler zich
     * kan verplaatsen teruggeeft
     *
     * @return lijst van richtingen waarin de speler zich kan verplaatsen
     */
    public List<Richting> geefVerplaatsRichtingen()
    {
        ArrayList<Richting> al = new ArrayList();
        for (Richting r : Richting.values())
        {
            al.add(r);
        }
        return al;
    }
    
    public String geefCodeGangkaart()
    {
        String res;
        if(schat == null)
            res = String.format("%c%d%d",getClass().getSimpleName().charAt(0), richting.getRichtingId(), 0);        
        else
            res = String.format("%c%d%d",getClass().getSimpleName().charAt(0), richting.getRichtingId(), schat.getSchatId());
        return res;
        
    }
}
