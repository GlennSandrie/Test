/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

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

    public DomeinController() {
        this.bestaandeSpellen = new SpelRepository();
        this.geregistreerdeSpelers = new SpelerRepository();
    }

    public void setTaal(String l) {
        taal = new Taal(l);
    }

    public Taal getTaal() {
        return taal;
    }

    public List<String> geefSpelnamen() {
        return bestaandeSpellen.geefSpelnamen();
    }

    public void kiesSpel(String naam) {
        bestaandeSpellen.kiesSpel(naam);
    }

    public List<String> geefSpelersVanSpel(String spelId) {
        return geregistreerdeSpelers.geefSpelernamen(spelId);
    }

}
