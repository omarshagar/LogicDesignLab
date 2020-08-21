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
import javax.swing.JPanel;

/**
 *
 * @author omarshagar
 */
public class LogicLab {

    
    public static void main(String[] args) {
       /*Pin pin1,pin2 = null;
       pin1=new Pin(true,null, 0, null, 0, 0);
       pin2=new Pin(true,null,0,null,0,0);
       pin1.addObserver(pin2);
       pin2.addObserver(pin1);
       int n;
       Scanner scn=new Scanner(System.in);
       n=scn.nextInt();
       while(n-->0)
       {
           int a,b;
           a=scn.nextInt();
           b=scn.nextInt();
           if(a==1)
           {
               pin1.Upadate(b);
           }
           else pin2.Upadate(b);
           System.out.println(pin1.value+" "+pin2.value);
  */
       
        
        start();
    }
    
    public static void start()
    {
        //declaring the main frame of the main window
        JFrame mainframe=new JFrame("LogicSimulator");
 
        //declaring all buttons that appear on the main window  
        JButton yardBtn=new JButton("Yard");
        
        
         JButton credits=new JButton("Credits");
        
       
      
        
        
        //set settings of buttons 
        yardBtn.setBounds(360,80, 100,50);
        credits.setBounds(360, 180, 100, 50);
       
        
        //set functions of buttons 
        yardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              mainframe.dispose();
                new ColBradBoard().setVisible(true);
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
          mainframe.setVisible(true);
    }
    
}


