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
public class IngevenGegevensSpelerController implements Initializable {

    DomeinController dc = new DomeinController();
    
    @FXML
    private Label lblGeboortejaar;
    @FXML
    private Label lblKleur;
    @FXML
    private Label lblNaam;
    @FXML
    private TextField txfNaam;
    @FXML
    private ComboBox<?> cmbKleur;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    @FXML
    private Label lblNaamExtra;
    @FXML
    private TextField txfGeboortejaar;
    @FXML
    private Label lblGegevens;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblGegevens.setText(dc.getTaal().getText("gegevens"));
        lblNaam.setText(dc.getTaal().getText("naam"));
        lblNaamExtra.setText(dc.getTaal().getText("spelerNaam"));
        lblGeboortejaar.setText(dc.getTaal().getText("geboortejaar"));
        lblKleur.setText(dc.getTaal().getText("kleur"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
    }    
    
}
