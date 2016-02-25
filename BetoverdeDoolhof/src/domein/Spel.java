/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;

/**
 *
 * @author Aïssa
 */
public class Spel
{
    private String naam;
    private List<Speler> spelers;

    public String getNaam()
    {
        return naam;
    }
    
    public String[] geefNamenSpelers()
    {
        String[] namen = new String[spelers.size()];
        for (int index=0;index<spelers.size();index++)
            namen[index]=spelers.get(index).getNaam();
        return namen;
    }
}
