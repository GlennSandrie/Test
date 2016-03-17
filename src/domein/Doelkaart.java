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

    public Doelkaart(Schat schat)
    {
        this.schat = schat;
    }

    public Schat getSchat()
    {
        return schat;
    }

    public void setSchat(Schat schat)
    {
        this.schat = schat;
    }

}
