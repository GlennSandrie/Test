/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;

/**
 *
 * @author anjana
 */
public class DomeinController 
{
    private SpelRepository bestaandeSpellen;
    private Spel gekozenSpel;
    
    public List<String> geefSpelnamen() 
    {
        return bestaandeSpellen.geefSpelnamen();
    }
    
    public void kiesSpel(String naam)
    {
        bestaandeSpellen.kiesSpel(naam);
    }
    
    public String[] toonNamenSpelers()
    {
        return gekozenSpel.geefNamenSpelers();
    }
    
}
