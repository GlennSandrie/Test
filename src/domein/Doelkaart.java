/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import utils.Schat;

/**
 *
 * @author anjana
 */
public class Doelkaart
{

    private Schat schat;

    /**
     * constructor, initialiseert de schat op de doelkaarten
     * 
     * @param schat 
     */
    public Doelkaart(Schat schat)
    {
        this.schat = schat;
    }

    /**
     * methode schat geven
     * @return schat
     */
    public Schat getSchat()
    {
        return schat;
    }

    /**
     * initialiseert de schat
     * 
     * @param schat 
     */
    public void setSchat(Schat schat)
    {
        this.schat = schat;
    }
    
    public String geefCodeDoelkaart()
    {
        return String.format("%d_",schat.getSchatId());
        
    }
}
