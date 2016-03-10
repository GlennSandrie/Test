/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


/**
 *
 * @author anjana
 */
public enum EnumKleur 
{
    GEEL(1), BLAUW(2), ROOD(3), GROEN(4);
    
    private final int kleurNr;

    EnumKleur(int kleurNr) 
    {
        this.kleurNr = kleurNr;
    }
    
    public int getKleurNr()
    {
        return kleurNr;
    }
}
