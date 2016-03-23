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
        spel.initialiseerVolledigSpel();
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
        spel.initialiseerVolledigSpel();
    }
    
    public String[][] geefSpel()
    {
        return spel.geefSpel();
    }
    
    
    
    public String bepaalVolgendeSpelerAanDeBeurt()
    {
        return spel.bepaalSpelerAanDeBeurt();
    }
}
