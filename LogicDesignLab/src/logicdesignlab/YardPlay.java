/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlab;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author omarshagar
 */
public class YardPlay extends Preloader {

    Stage stage;
    private int breadBoardRows;
    private int breadBoardCols;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setScene(beforeStart());

        stage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

    // tmp scene asking for num of columns and num of rows 
    private Scene beforeStart() {
        Scene scn1;

        //grid that will contains all components 
        GridPane gridpane = new GridPane();
        gridpane.setMinSize(500, 200);
        gridpane.setPadding(new Insets(20, 20, 20, 20));
        gridpane.setVgap(5);
        gridpane.setHgap(5);
        gridpane.setAlignment(Pos.CENTER);

        // label and text field setting up
        Label numR = new Label("enter number of Rows");
        Label numC = new Label("enter number of Columns");
        numR.setMinWidth(200);
        TextField numRText = new TextField();
        TextField numCText = new TextField();

        gridpane.add(numR, 0, 0);
        gridpane.add(numRText, 1, 0);
        gridpane.add(numC, 0, 1);
        gridpane.add(numCText, 1, 1);

        //button operations 
        Button btn = new Button("ok");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    breadBoardRows = Integer.valueOf(numRText.getText());
                    breadBoardCols = Integer.valueOf(numCText.getText());

                   
                    StartYard();
                            
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        gridpane.add(btn, 0, 2);

        scn1 = new Scene(gridpane, 300, 200);
        return scn1;

    }

    private void StartYard() throws MalformedURLException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("YardScreen.fxml"));
        try {
            Parent root=loader.load();
            Scene sc=new Scene(root);
            this.stage.setScene(sc);
            this.stage.setMaximized(true);
            this.stage.show();
        } catch (IOException ex) {
            Logger.getLogger(YardPlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }    

}
