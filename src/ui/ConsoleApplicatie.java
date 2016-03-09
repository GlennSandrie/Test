package ui;

import domein.DomeinController;

/**
 *
 * @author anjana
 */
public class ConsoleApplicatie {

    private DomeinController dc;

    /**
     *
     * @param dc
     */
    public ConsoleApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    /**
     *
     */
    public void start() {
        UCTaal.stelTaalIn(dc);
        UC1.laadSpel(dc);
    }
}