/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlab;


import java.awt.Image;
import java.io.File;

/**
 *
 * @author el-feky
 */
public  abstract class InputComponent implements Component {
    private boolean value;
    private Image image;
    private Pin Mpin;
    protected java.awt.image.BufferedImage img ;
    String basePath ;
        
    public InputComponent(){
        this.basePath  = new File("").getAbsolutePath();
    }
    /**
     * @return the value
     */
    public boolean isValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the Mpin
     */
    public Pin getMpin() {
        return Mpin;
    }

    /**
     * @param Mpin the Mpin to set
     */
    public void setMpin(Pin Mpin) {
        this.Mpin = Mpin;
    }
    
}
