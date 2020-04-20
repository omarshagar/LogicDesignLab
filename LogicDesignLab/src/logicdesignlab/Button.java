/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author el-feky
 */
public class Button extends InputComponent{
    public Button() throws FileNotFoundException, IOException{
        
        this.img = ImageIO.read(new FileInputStream(this.basePath+"/src/InputComponentImage/ButtonOFF.jpg"));
        ///home/el-feky/NetBeansProjects/InputComponent/src/InputComponentImage/ButtonOFF.jpg
        this.setImage(img);
        this.setValue(false);
        this.setMpin(null);
    }
    public void ButtonOFFClicked() throws FileNotFoundException, IOException{
        this.img = ImageIO.read(new FileInputStream(this.basePath+"/src/InputComponentImage/ButtonOFF.jpg"));
        this.setImage(img);
        this.setValue(false);
    }
    public void ButtonONClicked() throws FileNotFoundException, IOException{
        this.img = ImageIO.read(new FileInputStream(this.basePath+"/src/InputComponentImage/ButtonON.png"));
        this.setImage(img);
        this.setValue(true);
    }

    @Override
    public void updatePinValue(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
