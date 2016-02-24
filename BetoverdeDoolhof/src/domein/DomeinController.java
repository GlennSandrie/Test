/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author Aïssa
 */
public class DomeinController
{
    private SpelRepository bestaandeSpellen;
    private Spel gekozenSpel;
    
    public String[] geefSpelnamen()
    {
        return bestaandeSpellen.geefSpelnamen();
    }
    
    public void kiesSpel(String naam)
    {
        this.gekozenSpel = bestaandeSpellen.zoekSpel(naam);
    }
    
    public String[] toonNamenSpelers()
    {
        return gekozenSpel.geefNamenSpelers();
    }
}
