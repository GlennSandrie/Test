/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author anjana
 */
public class HoekKaart extends Gangkaart
{
    
    /**
     * 
     * @param schat
     * @param kleur
     * @param richting 
     */
    public HoekKaart(String schat, String kleur, String richting)
    {
        super(schat, kleur, richting);
    }
    
    /**
     * 
     * @param schat
     * @param richting 
     */
    public HoekKaart(String schat, String richting)
    {
        super(schat, richting);
    }
    
    /**
     * 
     * @param richting 
     */
    public HoekKaart(String richting)
    {
        super(richting);
    }
    
     public String getKleur()
    {
        return super.getKleur();
    }
    
     public void setSpeler(Speler speler)
     {
         super.setSpeler(speler);
     }
     
    /**
     * 
     * @param xPositie
     * @param yPositie 
     */
    public void plaatsOpSpelbord(int xPositie,int yPositie)
    {
        
    }
}
