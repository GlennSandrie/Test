/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import utils.Kleur;
import utils.Richting;
import utils.Schat;

/**
 *
 * @author anjana
 */
public class Spelbord
{

    private Gangkaart[][] spelbord = new Gangkaart[7][7];

    /**
     * constructor, zet de vaste gangkaarten op het spelbord, kleur, richting en
     * schat ingesteld
     */
    public Spelbord()
    {
        spelbord[0][0] = new HoekKaart(null, Kleur.GE, Richting.R);
        spelbord[0][6] = new HoekKaart(null, Kleur.B, Richting.O);
        spelbord[6][0] = new HoekKaart(null, Kleur.GR, Richting.B);
        spelbord[6][6] = new HoekKaart(null, Kleur.R, Richting.L);

        spelbord[0][2] = new Tkaart(Schat.UIL, Richting.O);
        spelbord[0][4] = new Tkaart(Schat.SCHEDEL, Richting.O);
        spelbord[2][0] = new Tkaart(Schat.HAGEDIS, Richting.R);
        spelbord[2][2] = new Tkaart(Schat.RAT, Richting.R);
        spelbord[2][4] = new Tkaart(Schat.TOVENARES, Richting.O);
        spelbord[2][6] = new Tkaart(Schat.SCHATKIST, Richting.L);
        spelbord[4][0] = new Tkaart(Schat.MOT, Richting.R);
        spelbord[4][2] = new Tkaart(Schat.SCARABEE, Richting.B);
        spelbord[4][4] = new Tkaart(Schat.SPIN, Richting.L);
        spelbord[4][6] = new Tkaart(Schat.SCHATKAART, Richting.L);
        spelbord[6][2] = new Tkaart(Schat.SLEUTELS, Richting.B);
        spelbord[6][4] = new Tkaart(Schat.ZWAARD, Richting.B);
    }
    
    public Spelbord(String spelbordCode)
    {
        int codeIndex = 0;
        for(int x = 0; x < 7; x++)
        {
            for(int y = 0; y < 7; y++)
            {
                switch(spelbordCode.charAt(codeIndex))
                {
                    case 'H': spelbord[x][y] = new HoekKaart(Schat.geefSchat(spelbordCode.charAt(codeIndex+2)), Richting.geefRichting(spelbordCode.charAt(codeIndex+1)));
                        break;
                    case 'R': spelbord[x][y] = new RechteWegKaart(Richting.geefRichting(spelbordCode.charAt(codeIndex+1)));
                        break;
                    case 'T': spelbord[x][y] = new Tkaart(Schat.geefSchat(spelbordCode.charAt(codeIndex+2)), Richting.geefRichting(spelbordCode.charAt(codeIndex+1)));
                        break;
                } 
                codeIndex = codeIndex+3;
            }
        }
        spelbord[0][0].setKleur(Kleur.GE);
        spelbord[0][6].setKleur(Kleur.B);
        spelbord[6][0].setKleur(Kleur.GR);
        spelbord[6][6].setKleur(Kleur.R);
    }
    /**
     * methode die het spelbord retourneert
     *
     * @return spelbord
     */
    public Gangkaart[][] geefSpelbord()
    {
        return spelbord;
    }

    /**
     * zet de speler op een hoekkaart die overeenkomt met zijn kleur
     *
     * @param kleur kan rood, geel, groen of blauw zijn
     * @param speler
     */
    public void zetSpelerOpHoekKaart(Kleur kleur, Speler speler)
    {

        if (spelbord[0][0].getKleur().equals(kleur))
        {
            spelbord[0][0].voegSpelerToe(speler);
        } else if (spelbord[0][6].getKleur().equals(kleur))
        {
            spelbord[0][6].voegSpelerToe(speler);
        } else if (spelbord[6][0].getKleur().equals(kleur))
        {
            spelbord[6][0].voegSpelerToe(speler);
        } else if (spelbord[6][6].getKleur().equals(kleur))
        {
            spelbord[6][6].voegSpelerToe(speler);
        } else
        {
            throw new IllegalArgumentException("foutKleur");
        }
    }

    /**
     * voegt een gangkaart toe op een bepaalde plaats op het spelbord
     *
     * @param xPositie x coordinaat van de gangkaart op het spelbord (0-6)
     * @param yPositie y coordinaat van de gangkaart op het spelbord (0-6)
     * @param gk gangkaart
     */
    public void voegGangKaartToe(int xPositie, int yPositie, Gangkaart gk)
    {
        spelbord[xPositie][yPositie] = gk;
    }

    /**
     * controleert of je op die positie mag inschuiven
     *
     * @param xPositie x coordinaat van de gangkaart op het spelbord (0-6)
     * @param yPositie y coordinaat van de gangkaart op het spelbord (0-6)
     * @param vrijeGangkaart
     */
    public void geefPlaatsVrijeGangkaart(int xPositie, int yPositie, Gangkaart vrijeGangkaart)
    {

        if (!(xPositie % 2 == 0 && yPositie % 2 == 0) && (xPositie == 0 || xPositie == 6 || yPositie == 0 || yPositie == 6))
        {
            setVrijeGangkaart(xPositie, yPositie, vrijeGangkaart);
        } else
        {
            throw new IllegalArgumentException("fouteCoordinaat");
        }

    }

    /**
     * stelt de nieuwe posities van de gangkaarten in na inschuiven van de losse
     * gangkaart, stelt een nieuwe vrije gangkaart in
     *
     * @param xPositie
     * @param yPositie
     * @param vrijeGangkaart
     * @return
     */
    public Gangkaart setVrijeGangkaart(int xPositie, int yPositie, Gangkaart vrijeGangkaart)
    {
        Gangkaart nieuweVrijeGangkaart = vrijeGangkaart;
        System.out.println(xPositie);
        System.out.println(yPositie);
        if (xPositie == 0)
        {
            nieuweVrijeGangkaart = spelbord[spelbord.length - 1][yPositie];
            for (int i = 6; i > 0; i--)
            {
                spelbord[i][yPositie] = spelbord[i - 1][yPositie];
            }
            spelbord[0][yPositie] = vrijeGangkaart;

        }
        if (xPositie == spelbord.length - 1)
        {
            nieuweVrijeGangkaart = spelbord[0][yPositie];
            for (int i = 1; i <= 6; i++)
            {
                spelbord[i][yPositie] = spelbord[i - 1][yPositie];
            }
            spelbord[spelbord.length - 1][yPositie] = vrijeGangkaart;

        }
        if (yPositie == 0)
        {
            nieuweVrijeGangkaart = spelbord[xPositie][spelbord.length - 1];
            for (int i = 6; i > 0; i--)
            {
                spelbord[xPositie][i - 1] = spelbord[xPositie][i];
            }
            spelbord[xPositie][0] = vrijeGangkaart;
        }
        if (yPositie == spelbord.length - 1)
        {
            nieuweVrijeGangkaart = spelbord[xPositie][0];
            for (int i = 1; i <= 6; i++)
            {
                spelbord[xPositie][i] = spelbord[xPositie][i - 1];
            }
            spelbord[xPositie][spelbord.length - 1] = vrijeGangkaart;
        }
        return nieuweVrijeGangkaart;
    }

    /**
     * methode die de indexen van de gangkaart waarop de speler zich bevindt
     * teruggeeft
     *
     * @param speler
     * @return indexen van de huidige gangkaart, waar de speler op staat
     */
    public int[] geefIndexenHuidigeGangkaart(Speler speler)
    {
        int[] indexen = new int[2];
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                for (Speler s : spelbord[i][j].getSpelers())
                {
                    if (s == speler)
                    {
                        indexen[0] = i;
                        indexen[1] = j;
                    }
                }
            }
        }
        return indexen;
    }

    /**
     * methode die de mogelijke richtingen waarin de speler zich kan verplaatsen
     * weergeeft
     *
     * @param speler
     * @return lijst van de mogelijke richtingen waarin de speler zich kan
     * verplaatsen
     */
    public List<String> geefMogelijkeVerplaatsRichtingen(Speler speler)
    {
        int x = geefIndexenHuidigeGangkaart(speler)[0];
        int y = geefIndexenHuidigeGangkaart(speler)[1];

        List<Richting> richtingen = spelbord[x][y].geefVerplaatsRichtingen();
        if (x == 0)
        {
            richtingen.remove(Richting.B);
        } else if (x == 6)
        {
            richtingen.remove(Richting.O);
        }
        if (y == 0)
        {
            richtingen.remove(Richting.L);
        } else if (y == 6)
        {
            richtingen.remove(Richting.R);
        }

        ListIterator<Richting> iter = richtingen.listIterator();
        while (iter.hasNext())
        {
            Richting r = iter.next();
            if (r == Richting.B)
            {
                if (!spelbord[x - 1][y].geefVerplaatsRichtingen().contains(Richting.O))
                {
                    iter.remove();
                }
            } else if (r == Richting.O)
            {
                if (!spelbord[x + 1][y].geefVerplaatsRichtingen().contains(Richting.B))
                {
                    iter.remove();
                }
            } else if (r == Richting.L)
            {
                if (!spelbord[x][y - 1].geefVerplaatsRichtingen().contains(Richting.R))
                {
                    iter.remove();
                }
            } else if (r == Richting.R)
            {
                if (!spelbord[x][y + 1].geefVerplaatsRichtingen().contains(Richting.L))
                {
                    iter.remove();
                }
            }
        }

        List<String> resultaat = new ArrayList<String>();
        for (Richting r : richtingen)
        {
            resultaat.add(r.toString());
        }
        return resultaat;
    }

    /**
     * verplaatst de speler naar de opgegeven coordinaten indien mogelijk
     *
     * @param xPositie x coordinaat van de gangkaart op het spelbord (0-6)
     * @param yPositie y coordinaat van de gangkaart op het spelbord (0-6)
     * @param speler
     */
    public void verplaatsSpeler(int xPositie, int yPositie, Speler speler)
    {
        Gangkaart huidigeGangkaart = spelbord[geefIndexenHuidigeGangkaart(speler)[0]][geefIndexenHuidigeGangkaart(speler)[1]];
        huidigeGangkaart.verwijderSpeler(speler);
        spelbord[xPositie][yPositie].voegSpelerToe(speler);
    }

    /**
     * geeft de schat van de kaart waar de speler op staat
     *
     * @param speler
     * @return schat van de huidige kaart
     */
    public Schat geefSchatHuidigeGangkaart(Speler speler)
    {
        int[] plaatsHG = geefIndexenHuidigeGangkaart(speler);
        return spelbord[plaatsHG[0]][plaatsHG[1]].schat;
    }
    
    /**
     * geeft de code terug om alle kaarten op het spelbord voor te stellenww
     * @return spebord in code
     */
    public String geefCodeSpelbord()
    {
        String sb = "";
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                sb += spelbord[i][j].geefCodeGangkaart();
            }
        }
        return sb;
    }
}
