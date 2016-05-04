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
public enum Schat
{

    GELDBEUGEL(1, "Geldbeugel"), VLEERMUIS(2, "Vleermuis"), BOEK(3, "Boek"), DRAAK(4, "Draak"), GEESTFLES(5, "Geest in een fles"),
    GEESTZWAAI(6, "Geest"), KROON(7, "Kroon"), KANDELAAR(8, "Kandelaar"), RING(9, "Ring"), HELM(10, "Helm"), JUWEEL(11, "Juweel"),
    LEEUW(12, "Leeuw"), HAGEDIS(13, "Hagedis"), MOT(14, "Mot"), UIL(15, "Uil"), RAT(16, "Rat"), SCARABEE(17, "Scarabee"),
    SLEUTELS(18, "Sleutels"), SCHEDEL(19, "Schedel"), TOVENARES(20, "Tovenares"), SPIN(21, "Spin"), ZWAARD(22, "Zwaard"),
    SCHATKIST(23, "Schatkist"), SCHATKAART(24, "Shatkaart");

    private final int schatId;
    private final String naam;

    /**
     * methode om het schatId en de naam van de schat te initialiseren
     *
     * @param schatId kan 1 tot en met 24 zijn
     * @param naam kan 1 van de 24 schatten zijn
     */
    Schat(int schatId, String naam)
    {
        this.schatId = schatId;
        this.naam = naam;
    }

    /**
     * methode om het schatId te geven
     *
     * @return schatId kan 1 tot en met 24 zijn
     */
    public int getSchatId()
    {
        return schatId;
    }

    /**
     * methode om de schatNaam te geven
     *
     * @return naam kan 1 van de 24 schatten zijn
     */
    public String getNaam()
    {
        return naam;
    }
    
    public static Schat geefSchat(int nummer)
    {
        for(Schat s : values())
        {
            if(s.getSchatId()==nummer)
                return s;
        }
        return null;
    }
}
