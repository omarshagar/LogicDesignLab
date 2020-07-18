/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author omarshagar
 */
public class LogicLab {

    
    public static void main(String[] args) {
        start();
    }
    
    public static void start()
    {
        //declaring the main frame of the main window
        JFrame mainframe=new JFrame("LogicSimulator");
 
        //declaring all buttons that appear on the main window  
        JButton yardBtn=new JButton("Yard");
        
        DrawRect2 d;
        
        
       
      
        
        
        //set settings of buttons 
        yardBtn.setBounds(360,80, 100,50);
        
       
        
        //set functions of buttons 
        yardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              mainframe.dispose();
                new Yard().setVisible(true);
               
                
             
            }
        });
     
        
        //start the window 
      //mainframe.setLocationRelativeTo(null);
      
       mainframe.setSize(840,680);
       mainframe.setLayout(null);
         mainframe.setResizable(false);
      
         mainframe.add(yardBtn);
          mainframe.setVisible(true);
    }
    
}

class DrawRect2 extends JPanel {
   private  int RECT_X = 20;
   private  int RECT_Y = RECT_X;
   private  int RECT_WIDTH = 100;
   private  int  RECT_HEIGHT = RECT_WIDTH;
   
   public DrawRect2(int x,int y,int width,int hight)
   {
       this.RECT_X=x;
       this.RECT_Y=y;
       this.RECT_HEIGHT=hight;
       this.RECT_WIDTH=width;
       repaint();
   }
  /* @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
       paintframe(g);
      
   }*/
   public void paint(Graphics g)
   {
        // draw the rectangle here
        // g.setColor(Color.RED);
       // g.fillRect(RECT_X,RECT_Y,RECT_WIDTH,RECT_HEIGHT);
      //  g.setColor(Color.BLACK);
        g.drawRect(RECT_X,RECT_Y,RECT_WIDTH,RECT_HEIGHT);
        
   }
}
