/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

import domein.DomeinController;
import gui.BeginSchermController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import gui.IngevenGegevensSpelerController;

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
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>()
//        {
//
//            @Override
//            public void handle(ActionEvent event)
//            {
//                System.out.println("Hello World!");
//            }
//        });
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        Scene scene = new Scene(root, 300, 250);
//        primaryStage.setTitle("Hello World!");
IngevenGegevensSpelerController root = new IngevenGegevensSpelerController(new DomeinController());
        Scene scene = new Scene(root);
//         BeginSchermController root = new BeginSchermController(null);
//        Scene scene = new Scene(root,500,300);
         primaryStage.setTitle("Combobox test");
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
