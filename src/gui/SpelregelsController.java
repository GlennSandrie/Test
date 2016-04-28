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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class SpelregelsController implements Initializable {

    DomeinController dc = new DomeinController();
    
    @FXML
    private Label lblSpelregels;
    @FXML
    private TextArea txaSpelregels;
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
        String uitkomst = "";
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("intro"), dc.getTaal().getText("introSpelregels"));
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("begin"), dc.getTaal().getText("beginSpelregels"));
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("verloop"), dc.getTaal().getText("verloopSpelregels"));
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("eind"), dc.getTaal().getText("eindSpelregels"));

        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
    }    
    
}
