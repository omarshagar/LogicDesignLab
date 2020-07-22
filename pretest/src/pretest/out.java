/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pretest;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author omerh
 */
public class out extends JFrame {
   private int value;
    JPanel panel;
    JButton b;
    public out(int val,int x,int y,JPanel p)
    {
        this.value=val;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 1000);
        setLocationRelativeTo(null);
        setTitle("Logic");
        setVisible(true);
        setResizable(false);
       if(val>0)
       {
      light_led(x,y,panel);
       }
       else
       {
       dark_led(x,y,panel);
       } 
    }
    
    public void dark_led(int x,int y,JPanel panel)
    {
    panel=new JPanel();
    panel.setLayout(null);
    ImageIcon ii = new ImageIcon("C:\\Users\\omerh\\Desktop\\dark.png");
    b=new JButton(ii);
    b.setSize(60, 60);
    b.setLocation(x, y);
    b.setIcon(ii);
    panel.add(b);
    this.add(panel);
    }
    public void light_led(int x,int y,JPanel panel)
    {
    panel=new JPanel();
    panel.setLayout(null);
    ImageIcon ii = new ImageIcon("C:\\Users\\omerh\\Desktop\\ligthled.png");
    b=new JButton(ii);
    b.setSize(60, 60);
    b.setLocation(x, y);
    b.setIcon(ii);
    panel.add(b);
    this.add(panel);
    }
}
