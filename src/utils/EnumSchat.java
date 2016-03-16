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

 
    GELDBEUGEL(1, "Geldbeugel"),  VLEERMUIS(2,"Vleermuis"), BOEK(3,"Boek"), DRAAK(4,"Draak"), GEESTFLES(5,"Geest in een fles"), 
    GEESTZWAAI(6,"Geest"), KROON(7,"Kroon"), KANDELAAR(8,"Kandelaar"), RING(9,"Ring"), HELM(10,"Helm"), JUWEEL(11,"Juweel"),
    VARKEN(12,"Varken"), HAGEDIS(13,"Hagedis"), MOT(14,"Mot"), UIL(15,"Uil"), RAT(16,"Rat"), SCARABEE(17,"Scarabee"), 
    SLEUTELS(18,"Sleutels"), SCHEDEL(19,"Schedel"), TOVENARES(20,"Tovenares"), SPIN(21,"Spin"), ZWAARD(22,"Zwaard"),
    SCHATKIST(23,"Schatkist"), SCHATKAART(24,"Shatkaart");
    
    private final int schatId;
    private final String naam;
    
    EnumSchat(int schatId, String naam)
    {
        this.schatId=schatId;
        this.naam = naam;
    }

    public int getSchatId()
    {
        return schatId;
    }
    
    public String getNaam()
    {
        return naam;
    }
}
