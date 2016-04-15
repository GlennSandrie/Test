package domein;

import java.time.LocalDate;
import java.util.List;
import utils.Kleur;

/**
 *
 * @author anjana
 */
public class DomeinController {

    private SpelRepository bestaandeSpellen;
    private SpelerRepository geregistreerdeSpelers;
    private Taal taal;
    private Spel spel;
    private Speler speler;

    /**
     * constructor van de Domeincontroller
     * Er word een object van de SpelRepository en SpelerRepository geinitialiseerd
     */
    public DomeinController() {
        this.bestaandeSpellen = new SpelRepository();
        this.geregistreerdeSpelers = new SpelerRepository();
    }

    /**
     *
     * @param l
     */
    public void setTaal(String l) {
        taal = new Taal(l);
    }

    /**
     *
     * @return de gekozen taal
     */
    public Taal getTaal() {
        return taal;
    }

    /**
     *
     * @return lijst van de namen van alle bestaande spellen
     */
    public List<String> geefSpelnamen() {
        return bestaandeSpellen.geefSpelnamen();
    }

    /**
     *
     * @param naam
     */
    public void kiesSpel(String naam) {
        spel = bestaandeSpellen.kiesSpel(naam);
    }
    
    public String getSpelnaam()
    {
        return spel.getNaam();
    }

    /**
     *
     * @param spelId
     * @return lijst van spelernamen die deelnemen aan het gekozen spel
     */
    public List<String> geefSpelersVanSpel(String spelId) {
        return geregistreerdeSpelers.geefSpelersVanSpel(spelId);
    }
    
    public int geefGeboortejaar(String speler)
    {
        return geregistreerdeSpelers.geefGeboortejaar(speler);
    }
    
    public String geefKleur(String speler)
    {
        return geregistreerdeSpelers.geefKleur(speler);
    }
    
    /**
     *
     * @param naam
     * @param geboortejaar
     * @param kleur
     */
    public void registreer(String naam, int geboortejaar, Kleur kleur) {
        Speler nieuweSpeler = new Speler(naam, geboortejaar, kleur);
        spel.voegSpelerToe(nieuweSpeler);
        
    }
    
    public void maakSpel(String naam)
    {
        spel = new Spel(naam);
    }
    
    public void initialiseerVolledigSpel()
    {
        spel.initialiseerVolledigSpel();
    }
    
    public String[][] geefSpel()
    {
        return spel.geefSpel();
    }
    
    public String[] geefDoelkaartenVanSpeler(String naam)
    {
        return spel.geefDoelkaartenVanSpeler(naam);
    }
    
    public String geefLosseKaart()
    {
        return spel.geefLosseKaart();
    }
    
    public Gangkaart bepaalTypeLosseKaart()
    {
        return spel.bepaalTypeLosseKaart();
    }
    public String geefHuidigeSpeler()
    {
        return spel.geefHuidigeSpeler().getNaam();
    }
    
    public String bepaalVolgendeSpelerAanDeBeurt()
    {
         Speler huidigeSpeler = spel.bepaalVolgendeSpelerAanDeBeurt();
         return huidigeSpeler.getNaam();
    }
    
    
//    public String geefPlaatsVrijeGangkaartIn()
//    {
//        return spel.geefPlaatsVrijeGangkaartIn(this);
//    }
    
    public String[] geefVerplaatsRichtingen()
    {
        return spel.geefVerplaatsRichtingen();
    }
}
