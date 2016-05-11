/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import exceptions.InvalidBirthdateException;
import exceptions.InvalidNameException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.Kleur;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class IngevenGegevenSpelerController extends GridPane {

    @FXML
    private Label lblGegevens;
    @FXML
    private Label lblGeboortejaar;
    @FXML
    private Label lblKleur;
    @FXML
    private Label lblNaam;
    @FXML
    private Label lblNaamExtra;
    @FXML
    private TextField txfNaam;
    @FXML
    private TextField txfGeboortejaar;
    @FXML
    private ComboBox<String> cmbKleur;
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    
    private DomeinController dc;
    private int aantal;
    private int huidig;
    
    public IngevenGegevenSpelerController(DomeinController dc, int aantal, int huidig) 
    {
        this.dc = dc;
        this.aantal = aantal;
        this.huidig = huidig;
        lblGegevens.setText(String.format(dc.getTaal().getText("gegevens"), aantal));
        lblNaam.setText(dc.getTaal().getText("naam"));
        lblNaamExtra.setText(dc.getTaal().getText("spelerNaam"));
        lblGeboortejaar.setText(dc.getTaal().getText("geboortejaar"));
        lblKleur.setText(dc.getTaal().getText("kleur"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IngevenGegevenSpeler.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
            int gd = Integer.parseInt(txfGeboortejaar.getText());
            dc.registreer(txfNaam.getText(), gd, Kleur.GE);
        } 
        catch (IOException e)
        {
            System.out.println(dc.getTaal().getText("IOException"));
            System.out.println(e.getMessage());
            Platform.exit();
        }
        catch (InvalidNameException e)
        {
            geefPopup(dc.getTaal().getText(e.getMessage()));
        } 
        catch (InvalidBirthdateException e)
        {
            geefPopup(dc.getTaal().getText((e.getMessage())));
        }
        
    }   

    @FXML
    private void btnVerderOnAction(ActionEvent event) 
    {
        if (huidig == aantal)
        {
            IngevenGegevenSpelerController is = new IngevenGegevenSpelerController(dc, aantal, 1);
            Stage stage = (Stage) (this.getScene().getWindow());
            Scene scene = new Scene(is);

            stage.setScene(scene);
            stage.show(); 
        }
        else
        {
            SpelregelsController sr = new SpelregelsController(dc);
            Stage stage = (Stage) (this.getScene().getWindow());
            Scene scene = new Scene(sr);

            stage.setScene(scene);
            stage.show();
        }
    }
    
    ObservableList<String> list = FXCollections.observableArrayList
    (
        dc.getTaal().getText("geel"),
        dc.getTaal().getText("blauw"),
        dc.getTaal().getText("rood"),
        dc.getTaal().getText("rood")
    );
    
     /**
    * Initializes the controller class.
    * @param url
    * @param rb
    */
    public void initialize(URL url, ResourceBundle rb)
    {
        cmbKleur.setItems(list);
    }
    
    private void geefPopup(String foutBoodschap)
    {
        Alert popup = new Alert(Alert.AlertType.ERROR);
        popup.setContentText(foutBoodschap);
        popup.setTitle("Invoerfout!");
        popup.showAndWait();
        txfNaam.requestFocus();
    }
}
