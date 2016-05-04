/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;
import persistentie.SpelMapper;

/**
 *
 * @author anjana
 */
public class SpelRepository
{

    private final SpelMapper sm;

    /**
     * constructor, ken de SpelMapper
     */
    public SpelRepository()
    {
        sm = new SpelMapper();
    }

    /**
     * methode die aan de SpelMapper de lijst van de spelnamen vraagt
     *
     * @return lijst van spelnamen
     */
    public List<String> geefSpelnamen()
    {
        return sm.geefSpelnamen();
    }

    /**
     * methode die aan de SpelMapper vraagt om het gekozen spel te geven
     *
     * @param naam
     * @return spel
     */
    public Spel kiesSpel(String naam)
    {
        return sm.kiesSpel(naam);
    }
    /**
     * methode die het spelbord en de vrije gangkaart doorgeeft aan de spelmapper om weg te schrijven naar de databank
     * @param spelbord 
     */
    public void opslaanSpelbord(String spelnaam, String spelbord)
    {
        sm.opslaanSpelbord(spelnaam, spelbord);
    }
    
    public void updateSpelbord(String spelnaam, String spelbord)
    {
        sm.updateSpelbord(spelnaam, spelbord);
    }
}
