/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class WelkomSchermController extends GridPane {
    
    @FXML
    private Label lblWelkom;
    @FXML
    private Label lblBestaandSpel;
    @FXML
    private Button btnNieuw;
    @FXML
    private Button btnBestaand;
    @FXML
    private Button btnTerug;
    
    private DomeinController dc;

    public WelkomSchermController(DomeinController dc) 
    {
        this.dc = dc;
        lblWelkom.setText(dc.getTaal().getText("welkom"));
        lblBestaandSpel.setText(dc.getTaal().getText("bestaandSpel"));
        btnBestaand.setText(dc.getTaal().getText("BestaandSpel"));
        btnNieuw.setText(dc.getTaal().getText("nieuwSpelTitel"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelkomScherm.fxml"));
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
    }
 
    @FXML
    private void btnNieuwOnAction(ActionEvent event) 
    {
        NieuweSpelController ns = new NieuweSpelController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(ns);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnBestaandOnAction(ActionEvent event) {
        BestaandSpel1Controller bs = new BestaandSpel1Controller(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(bs);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnTerugOnAction(ActionEvent event) {
        BeginSchermController bsc = new BeginSchermController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(bsc);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
