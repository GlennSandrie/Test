package domein;

import exceptions.EmptyListException;
import exceptions.InvalidCoordinateException;
import java.util.List;
import utils.Kleur;
import utils.Richting;

/**
 *
 * @author anjana
 */
public class DomeinController
{

    private final SpelRepository spelRepository;
    private final SpelerRepository spelerRepository;
    private Taal taal;
    private Spel spel;

    /**
     * constructor van de Domeincontroller. Er word een object van de
     * SpelRepository en SpelerRepository geinitialiseerd
     */
    public DomeinController()
    {
        this.spelRepository = new SpelRepository();
        this.spelerRepository = new SpelerRepository();
    }

    /**
     * stelt de taal in
     *
     * @param l
     */
    public void setTaal(String l)
    {
        this.taal = new Taal(l);
    }

    /**
     * methode voor taal opvragen
     *
     * @return de gekozen taal
     */
    public Taal getTaal()
    {
        return taal;
    }

    /**
     * methode voor lijst van spellen te geven
     *
     * @return lijst van de namen van alle bestaande spellen
     */
    public List<String> geefSpelnamen()
    {
        return spelRepository.geefSpelnamen();
    }

    /**
     * kies een spel uit de bestaande spellen
     *
     * @param naam
     */
    public void kiesSpel(String naam)
    {
        this.spel = spelRepository.kiesSpel(naam);
        
    }

    /**
     * methode om spelnaam te krijgen
     *
     * @return naam van het spel
     */
    public String getSpelnaam()
    {
        return spel.getNaam();
    }

    /**
     * methode om lijst van de spelers van een spel te geven
     *
     * @param spelId
     * @return lijst van spelernamen die deelnemen aan het gekozen spel
     */
    public List<String> geefSpelersVanSpel(String spelId)
    {
        return spelerRepository.geefSpelersVanSpel(spelId);
    }

    /**
     *
     * @param speler
     * @return geboortejaar van de reeds geregistreerde spelers
     */
    public int geefGeboortejaar(String speler)
    {
        return spelerRepository.geefGeboortejaar(speler);
    }

    /**
     * methode om de kleur van een geregistreerde speler te geven
     *
     * @param speler
     * @return kleur van de geregistreerde spelers
     */
    public String geefKleur(String speler)
    {
        return spelerRepository.geefKleur(speler);
    }

    // UC2
    /**
     * registreert een nieuwe speler met een naam, geboortejaar en een kleur
     *
     * @param naam de naam mag enkel letters bevatten, minimum 2 karakters
     * @param geboortejaar speler mag tussen de 7 en 90 jaar zijn
     * @param kleur kleur is blauw, geel, rood of groen
     */
    public void registreer(String naam, int geboortejaar, Kleur kleur)
    {
        Speler nieuweSpeler = new Speler(naam, geboortejaar, kleur);
        spel.voegSpelerToe(nieuweSpeler);
        
    }
    

    /**
     * maakt een nieuw spel aan met een naam
     *
     * @param naam moet minimum 8 tekens lang zijn, alleen alfanumetieke
     * karakters, exact 2 cijfers
     */
    public void maakSpel(String naam)
    {
        this.spel = new Spel(naam);
    }

    /**
     * vraagt aan spel om het spel volledig te initialiseren
     */
    public void initialiseerVolledigSpel()
    {
        spel.initialiseerVolledigSpel();
    }

    /**
     * vraagt aan Spel om het spel te geven
     *
     * @return spelbord
     */
    public String[][] geefSpelbord()
    {
        return spel.geefSpelbord();
    }

    /**
     * geeft de overblijvende doelkaarten van de speler
     *
     * @return @throws EmptyListException als de speler geen doelkaarten meer
     * heeft
     */
    public String geefDoelkaartVanHuidigeSpeler() throws EmptyListException
    {
        return spel.geefDoelkaartVanSpeler();
    }

    /**
     * vraagt aan spel om de vrije gangkaart te geven
     *
     * @return vrijeGangkaart
     */
    public String geefVrijeGangkaart()
    {
        return spel.geefVrijeGangkaart();
    }

    /**
     * vraagt aan spel om het type van de vrije gangkaart te bepalen
     *
     * @return hoekkaart, rechtewegkaart of tkaart
     */
    public Gangkaart geefTypeVrijeGangkaart()
    {
        return spel.getVrijeGangkaart();
    }

    /**
     * vraagt aan spel om de naam van de huidige speler te bepalen
     *
     * @return de naam van de huidige speler
     */
    public String geefHuidigeSpeler()
    {
        return spel.geefHuidigeSpeler().getNaam();
    }

    //UC3
    /**
     * vraagt aan Spel om de volgende speler te bepalen
     */
    public void bepaalVolgendeSpelerAanDeBeurt()
    {
        spel.bepaalVolgendeSpelerAanDeBeurt();
    }

    //UC4
    /**
     * vraagt aan Spel de coordinaten van de vrije gangkaart
     *
     * @param xPositie x coordinaat op het spelbord (0-6)
     * @param yPositie y coordinaat op het spelbord (0-6)
     * @throws exceptions.InvalidCoordinateException
     */
    public void geefPlaatsVrijeGangkaartIn(int xPositie, int yPositie) throws InvalidCoordinateException
    {
        spel.geefPlaatsVrijeGangkaartIn(xPositie, yPositie);
    }

    /**
     * vraagt aan spel om de vrijegangkaart te draaien
     *
     * @param keuze
     * @return gekozen richting van de vrijeGangkaart
     */
    public Richting draaiVrijeGangkaart(int keuze)
    {
        return spel.draaiVrijeGangkaart(keuze);
    }

    //UC5
    /**
     *
     * @return de mogelijke richtingen waar de speler zicht kan verplaatsen
     */
    public List<String> geefMogelijkeVerplaatsRichtingen()
    {
        return spel.geefMogelijkeVerplaatsRichtingen();
    }

    /**
     * vraagt aan spel op de speler te verplaatsen naar de gewenste x en y
     * coordinaat
     *
     * @param xPositie x coordinaat op het spelbord (0-6)
     * @param yPositie y coordinaat op het spelbord (0-6)
     */
    public void verplaatsSpeler(int xPositie, int yPositie)
    {
        spel.verplaatsSpeler(xPositie, yPositie);
    }

    /**
     * vraagt aan spel de indexen van de huidige gangkaart
     *
     * @return indexen van de gangkaart waar de speler zich op dit moment op
     * bevindt
     */
    public int[] geefIndexenHuidigeGangkaart()
    {
        return spel.geefIndexenHuidigeGangkaart();
    }

    /**
     * controleert of de schat die de speler op dat moment zoekt dezelfde is als
     * die op de gangkaart waar hij zich op bevindt
     *
     * @return true of false afhangende van of de doelkaart overeenkomt met de
     * schat op de gangkaart
     * @throws EmptyListException als de doelkaarten van de speler op zijn
     */
    public boolean controleerOvereenkomendeSchat() throws EmptyListException
    {
        return spel.controleerOvereenkomendeSchat();
    }

    /**
     * vraagt aan spel om de huidige doelkaart te verwijderen als de schat
     * gevonden is
     */
    public void verwijderHuidigeDoelkaart()
    {
        spel.verwijderHuidigeDoelkaart();
    }
    
    /**
     * 
     */
    public void opslaanSpelbord()
    {
        spelRepository.opslaanSpelbord(spel.getNaam(), spel.geefCodeSpelbord());
    }
    
    public void updateSpelbord()
    {
         spelRepository.updateSpelbord(spel.getNaam(), spel.geefCodeSpelbord());
    }
    
    public void opslaanSpeler(int beurt)
    {
        spelerRepository.opslaanSpeler(spel.getNaam(), spel.geefHuidigeSpeler(), spel.geefIndexenHuidigeGangkaart(), beurt, spel.geefHuidigeSpeler().geefCodeDoelkaarten());
    }

    public void updateSpeler(int beurt)
    {
        spelerRepository.updateSpeler(spel.getNaam(), spel.geefHuidigeSpeler().getNaam(), spel.geefIndexenHuidigeGangkaart(), beurt, spel.geefHuidigeSpeler().geefCodeDoelkaarten());
    }
    
    public List<String> geefSpelers()
    {
        return spel.getSpelernamen();
    }

    public void setNaamSpel(String naam)
    {
        spel.setNaam(naam);
    }

    public void initialiseerVolledigBestaandSpel()
    {
        String[][] gegSpelers = spelerRepository.geefGegevensSpelers(spel.getNaam());
        spel.initialiseerVolledigBestaandSpel(gegSpelers);
    }
}
