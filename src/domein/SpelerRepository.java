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
    
    public SpelerRepository()
    {
        sm = new SpelerMapper();
    }
    
    public List<String> geefSpelersVanSpel(String spelId)
    {
        return sm.geefSpelersVanSpel(spelId);
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
    
    
}
