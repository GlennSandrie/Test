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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class SpelregelsController extends VBox {

    @FXML
    private Label lblSpelregels;
    @FXML
    private TextArea txaSpelregels;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;

    private DomeinController dc;

    public SpelregelsController(DomeinController dc) 
    {
        this.dc = dc;
        String uitkomst = "";
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("intro"), dc.getTaal().getText("introSpelregels"));
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("begin"), dc.getTaal().getText("beginSpelregels"));
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("verloop"), dc.getTaal().getText("verloopSpelregels"));
        uitkomst += String.format("%s%n%s%n%n", dc.getTaal().getText("eind"), dc.getTaal().getText("eindSpelregels"));
        txaSpelregels.setText(uitkomst);

        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Spelregels.fxml"));
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
    private void btnTerugOnAction(ActionEvent event) {
        
    }

    @FXML
    private void btnVerderOnAction(ActionEvent event) {
        SpelbordController sb = new SpelbordController(dc);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(sb);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
