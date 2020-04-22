/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlab;

import java.util.concurrent.ExecutionException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author omarshagar
 */
public class LogicDesignLab extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane gridpane = new GridPane();
        gridpane.setMinSize(300, 300);
        gridpane.setPadding(new Insets(20, 20, 20, 20));
        gridpane.setVgap(30);
        gridpane.setHgap(0);
        gridpane.setAlignment(Pos.CENTER);

        Button btn1 = new Button("YardPlay         ");
        Button btn2 = new Button("PlayLevel        ");
        Button btn3 = new Button("AddLevel         ");
        Button btn4 = new Button("AddComponent ");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                YardPlay y = new YardPlay();
                try {
                    y.start(new Stage());
                } catch (Exception e) {

                }
            }
        });

        gridpane.add(btn1, 0, 0);
        gridpane.add(btn2, 0, 1);
        gridpane.add(btn3, 0, 2);
        gridpane.add(btn4, 0, 3);
        Scene scene = new Scene(gridpane, 860, 480);

        primaryStage.setTitle("LogicDesignLab");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
