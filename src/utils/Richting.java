/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Aïssa
 */
public enum Richting
{
    B(1, "BOVEN"), O(2, "ONDER"), L(3, "LINKS"), R(4, "RECHTS");
    
    private final int richtingId;
    private final String naam;

    Richting(int id, String naam) 
    {
        this.richtingId = id;
        this.naam = naam;
    }
    
    public int getKleurNr()
    {
        return richtingId;
    }
    
    public String getKleurNaam()
    {
        return naam;
    }
}
