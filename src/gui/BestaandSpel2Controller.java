/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class BestaandSpel2Controller implements Initializable {

    DomeinController dc = new DomeinController();
    
    @FXML
    private Label lblSpelers;
    @FXML
    private Label lblAantalBestaandeSpelers;
    @FXML
    private Label lblAantalSpelers;
    @FXML
    private ComboBox<?> cmbAantalSpelers;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    @FXML
    private ListView<?> lvSpelers;
    @FXML
    private Label lblAantalSpelersTitel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblAantalSpelersTitel.setText(dc.getTaal().getText("Speler"));
        lblSpelers.setText(dc.getTaal().getText("spelers"));
        lblAantalBestaandeSpelers.setText(dc.getTaal().getText("aantalBestaandeSpelers"));
        lblAantalSpelers.setText(dc.getTaal().getText("aantalSpelers"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
    }    
    
}
