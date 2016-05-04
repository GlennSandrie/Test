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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class BestaandSpel1Controller extends VBox {

    @FXML
    private Label lblBestaandSpel;
    @FXML
    private Label lblLaadSpel;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    
    @FXML
    private TextArea txaKeuzes;
    @FXML
    private TextField txfGekozenSpel;
    
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
        
        String uitvoer = "";
        List<String> spelNamen = dc.geefSpelnamen();
        for (String spel : spelNamen)
        {
            uitvoer += String.format("%s%n", spel);
        }
        
        dc.kiesSpel(txfGekozenSpel.getText());
    }
        
    @FXML
    private void btnTerugOnAction(ActionEvent event) {
        BestaandSpel2Controller bs = new BestaandSpel2Controller(dc, this);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(bs);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnVerderOnAction(ActionEvent event) {
        WelkomSchermController ws = new WelkomSchermController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(ws);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void geefPopup(String foutBoodschap)
    {
        Alert popup = new Alert(Alert.AlertType.ERROR);
        popup.setContentText(foutBoodschap);
        popup.setTitle("Invoerfout!");
        popup.showAndWait();
        txfGekozenSpel.requestFocus();
    }

}
