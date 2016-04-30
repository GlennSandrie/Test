/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.EmptyListException;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import utils.Kleur;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Speler
{

    private final String naam;
    private final Kleur kleur;
    private final int geboortejaar;
    private List<Doelkaart> doelkaarten = new ArrayList<>();

    /**
     * constructor, initialiseert kleur, initialiseert en controleert
     * geboortejaar en naam
     *
     * @param naam
     * @param geboortejaar
     * @param kleur
     */
    public Speler(String naam, int geboortejaar, Kleur kleur)
    {
        this.naam = naam;
        this.geboortejaar = geboortejaar;
        this.kleur = kleur;
        controleerNaam(naam);
        controleerGeboortejaar(geboortejaar);
    }

    /**
     *
     * @return naam
     */
    public String getNaam()
    {
        return naam;
    }

    /**
     *
     * @return kleur
     */
    public Kleur getKleur()
    {
        return kleur;
    }

    /**
     *
     * @return geboortejaar
     */
    public int getGeboortejaar()
    {
        return geboortejaar;
    }

    /**
     *
     * @return lijst van de doelkaarten
     */
    public List<Doelkaart> geefDoelkaarten()
    {
        return doelkaarten;
    }

    /**
     * controleert of de gebruikersnaam enkel letters bevat
     *
     * @param gebruikersnaam
     * @return true of false, hangt ervan af of de reguliere expressie matcht
     */
    private boolean controleerNaam(String gebruikersnaam)
    {
        if (!gebruikersnaam.matches("^[a-zA-Z].{1,}$"))
        {
            throw new InvalidNameException("fouteNaam");
        }
        return true;
    }

    /**
     * controleert of de speler tussen de 7 en 90 jaar oud is
     * 
     * @param jaar
     */
    private void controleerGeboortejaar(int jaar)
    {
        int huidigJaar = GregorianCalendar.getInstance().get(Calendar.YEAR);
        if (jaar < huidigJaar - 90 || jaar > huidigJaar - 7)
        {
            throw new InvalidBirthdateException("foutGeboortejaar");
        }
    }

    /**
     * voegt doelkaarten toe
     * @param doelkaart bevat 1 van de 24 schatten
     */
    public void voegDoelkaartToe(Doelkaart doelkaart)
    {
        doelkaarten.add(doelkaart);
    }

    /**
     * 
     * @return schact van de huidige doelkaart
     * @throws EmptyListException als de lijst van doelkaarten leeg is
     */
    public Schat geefSchatHuidigeDoelkaart() throws EmptyListException
    {
        if (doelkaarten.isEmpty())
        {
            throw new EmptyListException("geenDoelkaarten");
        }
        return doelkaarten.get(0).getSchat();
    }

    /**
     * verwijdert de huidige doelkaart indien de schat gevonden is
     */
    public void verwijderHuidigeDoelkaart()
    {
        doelkaarten.remove(0);
    }
}
