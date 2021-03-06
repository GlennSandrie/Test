/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

import domein.DomeinController;
import gui.BeginSchermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Start-methode, wordt gebruikt om het juiste beginscherm in te stellen
 *
 * @author anjana
 */
public class StartUpGui extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        BeginSchermController bs = new BeginSchermController(new DomeinController());
        Scene scene = new Scene(bs);
        
        primaryStage.setTitle("Betoverd doolhof");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * methode om het scherm te tonen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
