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

    /**
     * methode om het richtingId en de naam van de richting te initialiseren
     *
     * @param id kan 1, 2, 3 of 4 zijn
     * @param naam kan boven, onder, links of rechts zijn
     */
    Richting(int id, String naam)
    {
        this.richtingId = id;
        this.naam = naam;
    }

    /**
     * methode om het richtingId te geven
     *
     * @return richtingId kan boven, onder, links of rechts zijn
     */
    public int getRichtingId()
    {
        return richtingId;
    }

    /**
     * methode om de richtingNaam te geven
     *
     * @return richtingNaam kan boven, onder, links of rechts zijn
     */
    public String getRichtingNaam()
    {
        return naam;
    }

    /**
     * methode om de richting te geven
     *
     * @param nummer
     * @return Richting
     */
    public static Richting geefRichting(int nummer)
    {
        switch (nummer)
        {
            case 1:
                return B;
            case 2:
                return O;
            case 3:
                return L;
            default:
                return R;
        }
    }
}
