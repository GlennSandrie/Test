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
    private final SpelMapper mapper;

    public SpelRepository() 
    {
        mapper = new SpelMapper();
    }
    
    public List<String> geefSpelnamen()
    {
        return mapper.geefSpelnamen();
    }
    
    public Spel kiesSpel(String naam)
    {
        return mapper.kiesSpel(naam);
    }
}
