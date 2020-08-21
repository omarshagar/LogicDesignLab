/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab.Gates;

import logiclab.Core.component;
import logiclab.Core.FPin;
import logiclab.Core.MPin;
import logiclab.Core.Pin;
import logiclab.Core.BreadBoard;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author el-feky
 */
public class Clock extends Thread  implements component ,Runnable {

    Pin clockPin;
    double Frequency,time;
     private JPanel jp;
    private JPanel mainframe;
    private BreadBoard mainBreadBoard;
    
    
        public Clock(BreadBoard mainBoard, JPanel MainFrame){
         this.mainBreadBoard=mainBoard;
        this.mainframe=MainFrame;
    
        clockPin = new MPin(true, clockPin, 1, this, 1, 1);
    }
    
  public void  add(int row,int col) throws IOException
  {
      FPin fp=mainBreadBoard.pins[row][col];
      jp=new JPanel();
     JLabel jl=new JLabel();
    jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/clk.png")));
    jp.add(jl);    
    jp.setLayout(new GridLayout());
    jp.setBounds(fp.getRowLocInPanel()-5, fp.getColLocInPanel()-5,20, 20);
    jp.setVisible(true);
    this.mainframe.add(jp);
    this.clockPin.addObserver(fp);
    fp.addObserver(this.clockPin);
    fp.square.setVisible(false);
    
    jp.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) { 
        if (arg0.getButton() == MouseEvent.BUTTON3){  
            if(clockPin==null)return ;
            //get the mouse button
            jp.setVisible(false);
            mainBreadBoard.pins[clockPin.getObserver().getCurrow()][clockPin.getObserver().getCurcol()].square.setVisible(true);
           clockPin.getObserver().delete();
            clockPin.delete();
        }
    }
});
  } 
    
    @Override
    public void run() {
        generateFrequency();
    }
    public void setFrequency(double Frequency){
        this.Frequency = abs(Frequency);
        this.time = 1/(this.Frequency*1.0);
    }

    public void generateFrequency(){
        while (true) {    
            clockPin.changeForGate(2);
            try {
                
                Thread.sleep((long) (this.time*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            clockPin.changeForGate(-2);
          
            try {
                
                Thread.sleep((long) (this.time*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void pinchanged(int x, int y) {

    }

    

}
