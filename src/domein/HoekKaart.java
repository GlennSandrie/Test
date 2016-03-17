/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import utils.Kleur;
import utils.Schat;

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
    public HoekKaart(Schat schat, Kleur kleur, String richting)
    {
        super(null, kleur, richting);
    }
    
    /**
     * 
     * @param schat
     * @param richting 
     */
    public HoekKaart(Schat schat, String richting)
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
}
