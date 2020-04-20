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
public class Zero extends InputComponent{
     public Zero() throws FileNotFoundException, IOException{
         this.img = ImageIO.read(new FileInputStream(this.basePath+"/src/InputComponentImage/NegtivePin (1).png"));
        this.setImage(img);
        this.setValue(false);
        this.setMpin(null);
    }

    @Override
    public void updatePinValue(Pin pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
