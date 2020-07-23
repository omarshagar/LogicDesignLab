/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pretest;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author omerh
 */
public class BitVisualizer extends JFrame  {
   private int value;
    JPanel panel=new JPanel();
    JButton b;
    Image im;
    public BitVisualizer(int val,int x,int y,JPanel p) throws IOException
    {
        this.value=val;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 1000);
        setLocationRelativeTo(null);
        setTitle("Logic");
        setVisible(true);
        setResizable(false);
       //im=new ImageIcon(this.getClass().getResource("omar/images/dark.png")).getImage();       
       if(val>0)
       {
      one_vis(x,y,panel);
       }
       else
       {
       zero_vis(x,y,panel);
       }
    }
    
    public void one_vis(int x,int y,JPanel panel)
    {
    panel=new JPanel();
    panel.setLayout(null);
    ImageIcon ii = new ImageIcon("C:\\Users\\omerh\\Desktop\\One.png");
    b=new JButton(ii);
    b.setSize(47, 47);
    b.setLocation(x, y);
    b.setIcon(ii);
    panel.add(b);
    this.add(panel);
    }
    public void zero_vis(int x,int y,JPanel panel)
    {
    panel=new JPanel();
    panel.setLayout(null);
    ImageIcon ii = new ImageIcon("C:\\Users\\omerh\\Desktop\\Zero (2).png");
    b=new JButton(ii);
    b.setSize(47, 47);
    b.setLocation(x, y);
    b.setIcon(ii);
    panel.add(b);
    this.add(panel);
    }  
}
