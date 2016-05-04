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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.UCTaal;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class BeginSchermController extends GridPane {

    @FXML
    private Button btnNL;
    @FXML
    private Button btnFR;
    @FXML
    private Button btnEN;
    @FXML
    private Button btnVerder;

    private DomeinController dc;
    
    public BeginSchermController(DomeinController dc) 
    {
        this.dc = dc;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BeginScherm.fxml"));
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
    private void btnNLOnAction(ActionEvent event) {
        
        dc.setTaal("nl");
    }

    @FXML
    private void btnFROnAction(ActionEvent event) {
        dc.setTaal("fr");
    }

    @FXML
    private void btnENOnAction(ActionEvent event) {
        dc.setTaal("en");
    }

    @FXML
    private void btnVerderOnAction(ActionEvent event) {
        WelkomSchermController ws = new WelkomSchermController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(ws);
        
        stage.setScene(scene);
        stage.show();
    }

    
}
