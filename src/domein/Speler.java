/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Kleur;



/**
 *
 * @author anjana
 */
public class Speler 
{
    //attributen
    private final String naam;
    private final Kleur kleur;
    private final int geboortejaar;
    private List<Doelkaart> doelkaarten = new ArrayList<>();

    //constructor

    /**
     *
     * @param naam
     * @param geboortejaar
     * @param kleur
     */
    public Speler(String naam, int geboortejaar, Kleur kleur) 
    {
//        controleerNaam(naam);
        controleerGeboortejaar(geboortejaar);
        this.naam=naam;
        this.geboortejaar = geboortejaar;
        this.kleur = kleur;
    }

    //controles + getters + setters

    /**
     *
     * @return
     */
    public String getNaam()
    {
        return naam;
    }
    
    /**
     *
     * @return
     */
    public Kleur getKleur()
    {
        return kleur;
    }

    /**
     *
     * @return
     */
    public int getGeboortejaar()
    {
        return geboortejaar;
    }
    
    public List<Doelkaart> geefDoelkaarten()
    {
        return doelkaarten;
    }
    
    
    //methodes
    // oproepen binnen de constructor
    // controle voor geboortejaar ook toevoegen
    
//    private void controleerNaam(String naam)
//    {
//        Pattern p = Pattern.compile("[a-zA-Z]");
//        Matcher m = p.matcher(naam);
//        boolean b = m.matches();
//        if (naam.length()>2 && b==true) {
//        } 
//        else {
//            throw new InvalidNameException("fouteNaam");
//        }
//    }
    
    private void controleerGeboortejaar(int jaar)
    {
        int huidigJaar = GregorianCalendar.getInstance().get(Calendar.YEAR);
        if (jaar < huidigJaar-90 || jaar > huidigJaar-7 )
            throw new InvalidBirthdateException("foutGeboortejaar");
    }
    
    
    
    public void voegDoelkaartToe(Doelkaart doelkaart)
    {
        doelkaarten.add(doelkaart);
    }
    
    public String[] geefDoelkaartenVanSpeler()
    {
        String[] doelkaartenSpeler = new String[doelkaarten.size()];
        for(int i = 0; i < doelkaarten.size(); i++)
        {
            doelkaartenSpeler[i] = doelkaarten.get(i).getSchat().getNaam();
        }
        return doelkaartenSpeler;
    }
}
