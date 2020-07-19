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
        
        
        
        
       
      
        
        
        //set settings of buttons 
        yardBtn.setBounds(360,80, 100,50);
        
       
        
        //set functions of buttons 
        yardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              mainframe.dispose();
                new ColBradBoard().setVisible(true);
               
                
             
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


