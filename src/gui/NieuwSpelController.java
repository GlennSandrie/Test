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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class NieuwSpelController implements Initializable {

    DomeinController dc = new DomeinController();
    
    @FXML
    private Label lblNieuwSpelTitel;
    @FXML
    private Label lblNieuwSpel;
    @FXML
    private TextField txfNaamNieuwSpel;
    @FXML
    private Label lblAantalSpelers;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    @FXML
    private ComboBox<?> cmbAantal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblNieuwSpelTitel.setText(dc.getTaal().getText("nieuwSpelTitel"));
        lblNieuwSpel.setText(dc.getTaal().getText("nieuwSpel"));
        lblAantalSpelers.setText(dc.getTaal().getText("aantalSpelers"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
    }    
    
}
