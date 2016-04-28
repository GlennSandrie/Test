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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class BestaandSpel1Controller implements Initializable {

    DomeinController dc = new DomeinController();
    @FXML
    private Label lblBestaandSpel;
    @FXML
    private Label lblLaadSpel;
    @FXML
    private ListView<?> lvSpellen;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblBestaandSpel.setText(dc.getTaal().getText("BestaandSpel"));
        lblLaadSpel.setText(dc.getTaal().getText("laadSpel"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
    }    
    
}
