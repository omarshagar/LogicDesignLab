/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
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
public class Ground implements component{
   
    private JPanel jp;
    private JPanel mainframe;
    private BreadBoard mainBreadBoard;
    
    MPin pin;

    Ground(BreadBoard mainBoard, JPanel MainFrame) {
       this.mainBreadBoard=mainBoard;
        this.mainframe=MainFrame;
        pin=new MPin(false,null,0,this,0,0);
        this.pin.Upadate(-2);
    }
  public void  add(int row,int col) throws IOException
  {
      FPin fp=mainBreadBoard.pins[row][col];
      jp=new JPanel();
     JLabel jl=new JLabel();
    jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("Ground.png")));
    jp.add(jl);    
    jp.setLayout(new GridLayout());
    jp.setBounds(fp.getRowLocInPanel()-5, fp.getColLocInPanel()-5,20, 20);
    jp.setVisible(true);
    this.mainframe.add(jp);
    this.pin.addObserver(fp);
    fp.addObserver(this.pin);
    fp.square.setVisible(false);
    
    jp.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) { 
        if (arg0.getButton() == MouseEvent.BUTTON3){  
            if(pin==null)return ;
            //get the mouse button
            jp.setVisible(false);
            mainBreadBoard.pins[pin.getObserver().getCurrow()][pin.getObserver().getCurcol()].square.setVisible(true);
            pin.getObserver().delete();
            pin.delete();
        }
    }
});
  } 
    @Override
    public void pinchanged(int x, int y) {
        
    }
    
    
}
