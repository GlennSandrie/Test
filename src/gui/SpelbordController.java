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
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author anjana
 */
public class SpelbordController implements Initializable {

    DomeinController dc = new DomeinController();
    
    @FXML
    private ImageView imgKaart00;
    @FXML
    private ImageView imgKaart01;
    @FXML
    private ImageView imgKaart02;
    @FXML
    private ImageView imgKaart03;
    @FXML
    private ImageView imgKaart04;
    @FXML
    private ImageView imgKaart05;
    @FXML
    private ImageView imgKaart06;
    @FXML
    private ImageView imgKaart10;
    @FXML
    private ImageView imgKaart11;
    @FXML
    private ImageView imgKaart12;
    @FXML
    private ImageView imgKaart13;
    @FXML
    private ImageView imgKaart14;
    @FXML
    private ImageView imgKaart15;
    @FXML
    private ImageView imgKaart16;
    @FXML
    private ImageView imgKaart20;
    @FXML
    private ImageView imgKaart21;
    @FXML
    private ImageView imgKaart22;
    @FXML
    private ImageView imgKaart23;
    @FXML
    private ImageView imgKaart24;
    @FXML
    private ImageView imgKaart25;
    @FXML
    private ImageView imgKaart26;
    @FXML
    private ImageView imgKaart30;
    @FXML
    private ImageView imgKaart31;
    @FXML
    private ImageView imgKaart32;
    @FXML
    private ImageView imgKaart33;
    @FXML
    private ImageView imgKaart34;
    @FXML
    private ImageView imgKaart35;
    @FXML
    private ImageView imgKaart36;
    @FXML
    private ImageView imgKaart40;
    @FXML
    private ImageView imgKaart41;
    @FXML
    private ImageView imgKaart42;
    @FXML
    private ImageView imgKaart43;
    @FXML
    private ImageView imgKaart44;
    @FXML
    private ImageView imgKaart45;
    @FXML
    private ImageView imgKaart46;
    @FXML
    private ImageView imgKaart50;
    @FXML
    private ImageView imgKaart51;
    @FXML
    private ImageView imgKaart52;
    @FXML
    private ImageView imgKaart53;
    @FXML
    private ImageView imgKaart54;
    @FXML
    private ImageView imgKaart55;
    @FXML
    private ImageView imgKaart56;
    @FXML
    private ImageView imgKaart60;
    @FXML
    private ImageView imgKaart61;
    @FXML
    private ImageView imgKaart62;
    @FXML
    private ImageView imgKaart63;
    @FXML
    private ImageView imgKaart64;
    @FXML
    private ImageView imgKaart65;
    @FXML
    private ImageView imgKaart66;
    @FXML
    private Label lblSpeler;
    @FXML
    private ImageView imgDoelkaart;
    @FXML
    private Label lblScore;
    @FXML
    private Label lblVrijGangkaart;
    @FXML
    private ImageView imgVrijeGangkaart;
    @FXML
    private Label lblSpeelSpel;
    @FXML
    private Button btnTerug;
    @FXML
    private Button btnVerder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblSpeelSpel.setText(dc.getTaal().getText("spel"));
        lblSpeler.setText(dc.getTaal().getText("speler..."));
        lblScore.setText(dc.getTaal().getText("score"));
        lblVrijGangkaart.setText(dc.getTaal().getText("vrijeGangkaart"));
        
        btnTerug.setText(dc.getTaal().getText("terug"));
        btnVerder.setText(dc.getTaal().getText("verder"));
    }    
    
}
