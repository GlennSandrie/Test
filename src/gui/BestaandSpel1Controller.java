/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class BestaandSpel1Controller extends VBox implements Initializable {

    @FXML
    private Label lblBestaandSpel;
    @FXML
    private Label lblLaadSpel;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
     @FXML
    private ComboBox<String> cmbSpel;
    
    
    private DomeinController dc;

    public BestaandSpel1Controller(DomeinController dc) 
    {
        this.dc = dc;
        lblBestaandSpel.setText(dc.getTaal().getText("BestaandSpel"));
        lblLaadSpel.setText(dc.getTaal().getText("laadSpel"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BestaandSpel1.fxml"));
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
        
    ObservableList<String> list = FXCollections.observableArrayList(dc.geefSpelnamen());
    
     /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        cmbSpel.setItems(list);
    }
    
    @FXML
    private void btnTerugOnAction(ActionEvent event) 
    {
        WelkomSchermController ws = new WelkomSchermController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(ws);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnVerderOnAction(ActionEvent event) 
    {
        String spel = "";
        spel += cmbSpel.getSelectionModel().selectedIndexProperty();
        dc.kiesSpel(spel);
        
        BestaandSpel2Controller bs = new BestaandSpel2Controller(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(bs);
        
        stage.setScene(scene);
        stage.show();
    }

}
