/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import utils.Coördinaat;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Gangkaart
{

    /**
     *
     */
    private Schat schat;
    private Kleur kleur;
    private Richting[] richtingen;
    private List<Speler> spelers;
    private Gangkaart keuzeKaart;
    private Gangkaart[] draaiKaart;

   //private Coördinaat coördinaat;
    /**
     *
     * @param coördinaat
     */
    /*  public Gangkaart( Coördinaat coördinaat)
     {
       
     this.coördinaat = coördinaat;
     }*/
    /**
     *
     * @param schat
     * @param kleur
     * @param richting
     */
    public Gangkaart(Schat schat, Kleur kleur, Richting[] richting)
    {
        this.schat = schat;
        this.kleur = kleur;
        this.richtingen = richting;
        spelers = new ArrayList<>();
    }

    /**
     *
     * @param schat
     * @param richting
     */
    public Gangkaart(Schat schat, Richting[] richting)
    {
        this(schat, null, richting);
    }

    /**
     *
     * @param richting
     */
    public Gangkaart(Richting[] richting)
    {
        this(null, null, richting);
    }

    public Kleur getKleur()
    {
        return kleur;
    }

    public List<Speler> getSpelers()
    {
        return spelers;
    }

    public Richting[] getRichtingen()
    {
        return richtingen;
    }

    public void voegSpelerToe(Speler speler)
    {
        this.spelers.add(speler);
    }

    public void verwijderSpeler(Speler speler)
    {
        this.spelers.remove(speler);
    }
    /*
     *
     *Tijdelijke methode om spel af te printen op het scherm
     */

    // UC4
    public Gangkaart[] draaienKaart(int keuze)
    {
        return draaiKaart;

    }

    public Gangkaart geefGekozenKaart(int keuze)
    {
        return keuzeKaart;
    }

    public Gangkaart getKeuzeKaart()
    {
        return keuzeKaart;
    }

    public void setKeuzeKaart(Gangkaart keuzeKaart)
    {
        this.keuzeKaart = keuzeKaart;
    }

    public void printKaart()
    {
        int begin = 0;
        int einde = 11;
        while (begin < 72)
        {
            for (int j = 0; j < draaiKaart.length; j++)
            {
                System.out.printf(draaiKaart[j].toString().substring(begin, einde + 1));
                System.out.printf("        ");
            }
            begin += 12;
            einde += 12;
            System.out.println();
        }
    }

    public void printKeuzeKaart()
    {
        int begin = 0;
        int einde = 11;
        while (begin < 72)
        {
            System.out.printf(keuzeKaart.toString().substring(begin, einde + 1));
            begin += 12;
            einde += 12;
            System.out.println("");
        }
    }

    @Override
    public String toString()
    {
        String kaart = "";
        /* if (richtingen == null)
         {
         kaart = coördinaat.getCoördinaat();
         }
         else {
         */
        if (schat == null)
        {
            if (richtingen.length == 2)
            {
                switch (richtingen[0])
                {
                    case R:
                        kaart = String.format("xxxxxxxxxxxx"
                                + "xxxxxxxxxxxx"
                                + "            "
                                + "            "
                                + "xxxxxxxxxxxx"
                                + "xxxxxxxxxxxx");
                        break;
                    case O:
                        switch (richtingen[1])
                        {
                            case L:
                                kaart = String.format("xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx"
                                        + "         xxx"
                                        + "         xxx"
                                        + "xxx      xxx"
                                        + "xxx      xxx");
                                break;
                            case R:
                                kaart = String.format("xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx"
                                        + "xxx         "
                                        + "xxx         "
                                        + "xxx      xxx"
                                        + "xxx      xxx");
                                break;
                        }
                    case B:
                        switch (richtingen[1])
                        {
                            case L:
                                kaart = String.format("xxx      xxx"
                                        + "xxx      xxx"
                                        + "         xxx"
                                        + "         xxx"
                                        + "xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx");
                                break;
                            case R:
                                kaart = String.format("xxx      xxx"
                                        + "xxx      xxx"
                                        + "xxx         "
                                        + "xxx         "
                                        + "xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx");
                                break;
                            case O:
                                kaart = String.format("xxx      xxx"
                                        + "xxx      xxx"
                                        + "xxx      xxx"
                                        + "xxx      xxx"
                                        + "xxx      xxx"
                                        + "xxx      xxx");
                                break;
                        }
                }
            } else
            {
                switch (richtingen[0])
                {
                    case O:
                        kaart = String.format("xxxxxxxxxxxx"
                                + "xxxxxxxxxxxx"
                                + "            "
                                + "            "
                                + "xxx      xxx"
                                + "xxx      xxx");
                        break;
                    case B:
                        kaart = String.format("xxx      xxx"
                                + "xxx      xxx"
                                + "            "
                                + "            "
                                + "xxxxxxxxxxxx"
                                + "xxxxxxxxxxxx");
                        break;
                    case L:
                        kaart = String.format("xxx      xxx"
                                + "xxx      xxx"
                                + "         xxx"
                                + "         xxx"
                                + "xxx      xxx"
                                + "xxx      xxx");
                        break;
                    case R:
                        kaart = String.format("xxx      xxx"
                                + "xxx      xxx"
                                + "xxx         "
                                + "xxx         "
                                + "xxx      xxx"
                                + "xxx      xxx");
                        break;
                }
            }
        } else
        {
            if (richtingen.length == 2)
            {
                switch (richtingen[0])
                {
                    case O:
                        switch (richtingen[1])
                        {
                            case L:
                                kaart = String.format("xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx"
                                        + "         xxx"
                                        + "     S   xxx"
                                        + "xxx      xxx"
                                        + "xxx      xxx");
                                break;
                            case R:
                                kaart = String.format("xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx"
                                        + "xxx         "
                                        + "xxx   S     "
                                        + "xxx      xxx"
                                        + "xxx      xxx");
                                break;
                        }
                    case B:
                        switch (richtingen[1])
                        {
                            case L:
                                kaart = String.format("xxx      xxx"
                                        + "xxx      xxx"
                                        + "     S   xxx"
                                        + "         xxx"
                                        + "xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx");
                                break;
                            case R:
                                kaart = String.format("xxx      xxx"
                                        + "xxx      xxx"
                                        + "xxx   S     "
                                        + "xxx         "
                                        + "xxxxxxxxxxxx"
                                        + "xxxxxxxxxxxx");
                                break;
                        }
                }
            } else
            {
                switch (richtingen[0])
                {
                    case O:
                        kaart = String.format("xxxxxxxxxxxx"
                                + "xxxxxxxxxxxx"
                                + "            "
                                + "      S     "
                                + "xxx      xxx"
                                + "xxx      xxx");
                        break;
                    case B:
                        kaart = String.format("xxx      xxx"
                                + "xxx      xxx"
                                + "      S     "
                                + "            "
                                + "xxxxxxxxxxxx"
                                + "xxxxxxxxxxxx");
                        break;
                    case L:
                        kaart = String.format("xxx      xxx"
                                + "xxx      xxx"
                                + "         xxx"
                                + "     S   xxx"
                                + "xxx      xxx"
                                + "xxx      xxx");
                        break;
                    case R:
                        kaart = String.format("xxx      xxx"
                                + "xxx      xxx"
                                + "xxx         "
                                + "xxx   S     "
                                + "xxx      xxx"
                                + "xxx      xxx");
                        break;
                }
            }
        }
        //}
        return kaart;
    }
}
