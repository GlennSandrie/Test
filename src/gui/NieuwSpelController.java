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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class NieuwSpelController extends VBox{

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

    private DomeinController dc;
    
    @FXML
    private TextField txfAantal;
    
    public NieuwSpelController(DomeinController dc) 
    {
        this.dc = dc;
        lblNieuwSpelTitel.setText(dc.getTaal().getText("nieuwSpelTitel"));
        lblNieuwSpel.setText(dc.getTaal().getText("nieuwSpel"));
        lblAantalSpelers.setText(dc.getTaal().getText("aantalSpelers"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NieuwSpel.fxml"));
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
        
        dc.maakSpel(txfNaamNieuwSpel.getText());
        
    }

    private void btnTerugOnAction(ActionEvent event) {
        WelkomSchermController ws = new WelkomSchermController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(ws);
        
        stage.setScene(scene);
        stage.show();
    }

    private void btnVerderOnAction(ActionEvent event) {
        IngevenGegevensSpelerController is = new IngevenGegevensSpelerController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(is);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
