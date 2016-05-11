/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class NieuweSpelController extends VBox   
{

    @FXML
    private Label lblNieuwSpelTitel;
    @FXML
    private Label lblNieuwSpel;
    @FXML
    private TextField txfNaamNieuwSpel;
    @FXML
    private Label lblAantalSpelers;
    @FXML
    private ComboBox<String> cmbAantal;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;
    
    private DomeinController dc;
    private int aantal = 0;

    public NieuweSpelController(DomeinController dc) 
    {
        this.dc = dc;
        
        
        
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NieuweSpel.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            
            lblNieuwSpelTitel.setText(dc.getTaal().getText("nieuwSpelTitel"));
            lblNieuwSpel.setText(dc.getTaal().getText("nieuwSpel"));
            lblAantalSpelers.setText(dc.getTaal().getText("aantalSpelers"));
            btnTerug.setText(dc.getTaal().getText("terug"));
            btnVerder.setText(dc.getTaal().getText("verder"));  
            
            dc.maakSpel(txfNaamNieuwSpel.getText());
        } catch (IOException e)
        {
            System.out.println(dc.getTaal().getText("IOException"));
            System.out.println(e.getMessage());
            Platform.exit();
        }
        catch (InvalidNameException e) {
            geefPopup(dc.getTaal().getText(("fouteSpelnaam")));
        }
        catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }  

    ObservableList<String> list = FXCollections.observableArrayList("2","3","4");
 
    /**
      * Initializes the controller class.
      * @param url
      * @param rb
      */
     public void Initialize(URL url, ResourceBundle rb)
     {
        cmbAantal.setItems(list);
        String a = "";
        a += cmbAantal.getSelectionModel().selectedItemProperty();
        aantal =  Integer.parseInt(a);
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
        IngevenGegevenSpelerController is = new IngevenGegevenSpelerController(dc, aantal, 1);
        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(is);

        stage.setScene(scene);
        stage.show();        
    }
    
    private void geefPopup(String foutBoodschap)
    {
        Alert popup = new Alert(Alert.AlertType.ERROR);
        popup.setContentText(foutBoodschap);
        popup.setTitle("Invoerfout!");
        popup.showAndWait();
        txfNaamNieuwSpel.requestFocus();
    }
}
