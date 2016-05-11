/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class BestaandSpel2Controller extends VBox {
    
    @FXML
    private Label lblSpelers;
    private Label lblAantalSpelers;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    @FXML
    private Label lblAantalSpelersTitel;
    @FXML
    private TextArea txaSpelers;

    private DomeinController dc;

    public BestaandSpel2Controller(DomeinController dc) {
        this.dc = dc;
        lblAantalSpelersTitel.setText(dc.getTaal().getText("Speler"));
        lblSpelers.setText(dc.getTaal().getText("spelers"));
        lblAantalSpelers.setText(dc.getTaal().getText("aantalSpelers"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BestaandSpel2.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
        }
        catch (IOException e)
        {
            System.out.println(dc.getTaal().getText("IOException"));
            System.out.println(e.getMessage());
            Platform.exit();
        }
        
        String uitvoer = "";
        List<String> spelers = dc.geefSpelersVanSpel(dc.getSpelnaam());
        for (String speler : spelers) 
        {
            uitvoer += String.format("%s%n", speler);
        }
    }
    
    @FXML
    private void btnTerugOnAction(ActionEvent event) 
    {
        BestaandSpel1Controller bs = new BestaandSpel1Controller(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(bs);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnVerderOnAction(ActionEvent event) 
    {
        SpelregelsController sr = new SpelregelsController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(sr);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
