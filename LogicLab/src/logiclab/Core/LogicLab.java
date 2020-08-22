package logiclab.Core;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author omarshagar
 */
public class LogicLab {

    public static JLabel j1=new JLabel();
    public static JLabel j2=new JLabel();
   

    public LogicLab() {
        j1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/ain.png")));
        j2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/ain2.jpg"))); 
        
    }
    
    public static void main(String[] args) {
       start();
    }
    
    public static  void start()
    {
        //declaring the main frame of the main window
        JFrame mainframe=new JFrame("LogicSimulator");
 
        //declaring all buttons that appear on the main window  
        JButton yardBtn=new JButton("Yard");
        
        
        JButton addLevelBtn=new JButton("AddLevel");
        
        JButton playLevelBtn=new JButton("PlayLevel");
        
         JButton credits=new JButton("Credits");
        JPanel univPanil=new JPanel(new GridLayout());
         JPanel univPanil2=new JPanel(new GridLayout());
         LogicLab h=new LogicLab();
         univPanil.add(LogicLab.j1);
          univPanil2.add(LogicLab.j2);
         
         
         
       
      
        
        
        //set settings of buttons 
        yardBtn.setBounds(360,200, 120,50);
       // playLevelBtn.setBounds(360, 180, 120, 50);
        //addLevelBtn.setBounds(360, 280, 120, 50);
        credits.setBounds(360, 300, 120, 50);
        univPanil.setBounds(20,20,150,150);
        univPanil2.setBounds(670,20,150,150);
        
        //set functions of buttons 
        yardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              mainframe.dispose();
                new ColBradBoard().setVisible(true);
            }
        });
        playLevelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        addLevelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              mainframe.dispose();
                new Credits().setVisible(true);
            }
        });
     
        
        //start the window 
      //mainframe.setLocationRelativeTo(null);
      
       mainframe.setSize(840,680);
       mainframe.setLayout(null);
         mainframe.setResizable(false);
         mainframe.add(credits);
         mainframe.add(yardBtn);
        // mainframe.add(playLevelBtn);
         //mainframe.add(addLevelBtn);
         mainframe.add(univPanil);
         mainframe.add(univPanil2);
         univPanil.setVisible(true);
          mainframe.setVisible(true);
    }
    
}


