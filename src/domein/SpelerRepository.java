/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;
import persistentie.SpelerMapper;

/**
 *
 * @author Aïssa
 */
public class SpelerRepository
{

    private Speler spelers;
    private SpelerMapper sm;

    /**
     * constructor, kent de SpelerMapper
     */
    public SpelerRepository()
    {
        sm = new SpelerMapper();
    }

    /**
     * methode die een lijst van spelers van een bepaald spel toont
     *
     * @param spelId
     * @return lijst van de spelId's van de spelers van een spel
     */
    public List<String> geefSpelersVanSpel(String spelId)
    {
        return sm.geefSpelersVanSpel(spelId);
    }

    /**
     * methode die het geboortejaar van een speler aan de spelerMapper vraagt
     *
     * @param speler
     * @return geboortejaar van een speler
     */
    public int geefGeboortejaar(String speler)
    {
        return sm.geefGeboortejaar(speler);
    }

    /**
     *
     * @param speler
     * @return kleur van een speler
     */
    public String geefKleur(String speler)
    {
        return sm.geefKleur(speler);
    }

    /*public Speler geefAantalSpelers(int aantalSpelers)
     {
     return sm.geefAantalSpelers(aantalSpelers);
     }
    
     public void geefGegevensSpelerIn(String naam, LocalDateTime geboortedatum, String kleur)
     {
     return sm.geefGegevensSpelerIn(naam,geboortedatum,kleur);
     }
     */

    void opslaanSpeler(String spelNaam, Speler speler, int[] indexenPlaatsSpelbord, int beurt, String doelkaarten)
    {
        sm.opslaanSpeler(spelNaam, speler, indexenPlaatsSpelbord[0], indexenPlaatsSpelbord[1], beurt, doelkaarten);
    }
    
    public void updateSpeler(String spelNaam, String naam, int[] indexenPlaatsSpelbord, int beurt, String doelkaarten)
    {
        sm.updateSpeler(spelNaam, naam, indexenPlaatsSpelbord[0], indexenPlaatsSpelbord[1], beurt, doelkaarten);
    }
}
