/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pretest;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author omerh
 */
public class Pretest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        JPanel p=new JPanel();
        BitVisualizer o=new BitVisualizer(-2,50,100,p);
     //   o.loadImage();
    }
    
}
