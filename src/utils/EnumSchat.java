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
public enum EnumSchat 
{

 
    GOUDENMUNTEN(1),  VLEERMUIS(2), BOEK(3), DRAAK(4), GEESTFLES(5), 
    GEESTZWAAI(6), KROON(7), KANDELAAR(8), RING(9), HELM(10), JUWEEL(11),
    VARKEN(12), HAGEDIS(13), MOT(14), UIL(15), RAT(16), SCARABEE(17), 
    SLEUTELS(18), SCHEDEL(19), TOVENARES(20), SPIN(21), ZWAARD(22),
    SCHATKIST(23), SCHATKAART(24);
    
    private final int schatId;
    
    EnumSchat(int schatId)
    {
        this.schatId=schatId;
    }

    public int getSchatId()
    {
        return schatId;
    }
}
