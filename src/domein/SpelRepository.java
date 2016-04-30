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
     *
     * @return lijst van spelnamen
     */
    public List<String> geefSpelnamen()
    {
        return sm.geefSpelnamen();
    }
    
    /**
     *
     * @param naam
     * @return spel
     */
    public Spel kiesSpel(String naam)
    {
        return sm.kiesSpel(naam);
    }
}
