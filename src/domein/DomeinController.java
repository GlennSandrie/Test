package domein;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author anjana
 */
public class DomeinController {

    private SpelRepository bestaandeSpellen;
    private Spel gekozenSpel;
    private SpelerRepository geregistreerdeSpelers;
    private Taal taal;
    private Spel nieuwSpel;

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
        gekozenSpel = bestaandeSpellen.kiesSpel(naam);
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
    public void registreer(String naam, int geboortejaar, String kleur) {
        Speler nieuweSpeler = new Speler(naam, geboortejaar, kleur);
        geregistreerdeSpelers.registreerSpeler(nieuweSpeler);  
        
    }
    
    public void maakSpel(String naam)
    {
        nieuwSpel = new Spel(naam);
        nieuwSpel.initialiseerVolledigSpel();
    }
    
    public String[][] geefSpel()
    {
        return nieuwSpel.geefSpel();
    }
    
}
