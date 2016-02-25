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
public class Spel 
{
    //attributen
    private List<Speler> spelers;
    private String naam;

    //constructor
    public Spel(String naam) 
    {
        this.naam = naam;
    }

    //controles + getters + setters
    public String getNaam() 
    {
        return naam;
    }
  
    //methodes
    public String[] geefNamenSpelers()
    {
        String[] res = new String[spelers.size()];
        for (int index = 0; index < spelers.size(); index++)
            res[index] = spelers.get(index).getNaam();
        return res;
    }
    
}
