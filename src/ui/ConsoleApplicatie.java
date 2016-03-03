package ui;

import domein.DomeinController;

public class ConsoleApplicatie {

    private DomeinController dc;

    public ConsoleApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        UCTaal.stelTaalIn(dc);
        UC1.laadSpel(dc);
    }
}