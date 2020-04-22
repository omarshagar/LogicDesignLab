/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author omarshagar
 */
public class YardScreenController implements Initializable {

    @FXML
    ScrollPane gatesPane;
     @FXML
    ScrollPane inputPane;
      @FXML
    ScrollPane outputPane;
      @FXML
      FlowPane flowpan;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeGui();
    }    
    public void initializeGui()
    {
        inputPane =new ScrollPane();
         outputPane =new ScrollPane();
          gatesPane =new ScrollPane();
          flowpan=new FlowPane();
          flowpan.setId("flowpan");
          try{
              
              
          Image input1=new Image(new FileInputStream(new File("").getAbsoluteFile()+"/src/InputComponentImage/"+"PositivePin (1).png"));
          ImageView iv1=new ImageView(input1);
          iv1.setX(50);
          iv1.setY(50);
          iv1.setFitHeight(600);
          iv1.setFitWidth(800);
          //iv1.setPreserveRatio(true);
          Group root =new Group();
          root.getChildren().add(iv1);
          
          
          
         
      
      
         inputPane.setContent(root);
         System.out.println("7a7a");
            
          }
          catch(IOException io)
          {
              System.out.println(io.getMessage());
          }
          
            
        
    }
    
}
