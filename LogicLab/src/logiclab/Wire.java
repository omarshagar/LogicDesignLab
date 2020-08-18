package logiclab;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author el-feky
 */
public class Wire implements component{

    MPin pin[];
    
    JPanel firstpan,secondpan;
    JPanel mainframe;
    BreadBoard mainBreadBoard;
public static int numOfCreatedWires=0;
    public Wire(JPanel mainframe,BreadBoard BB) {
       pin=new MPin[2];
        numOfCreatedWires++;
        this.mainframe=mainframe;
        this.mainBreadBoard=BB;
        firstpan=new JPanel();
        secondpan=new JPanel();
  
    }
    
    
    public void drawFirstPin(int x,int y,int row,int col)
    {
        
        pin[0]=new MPin(true, mainBreadBoard.pins[row][col], 0, this, 0, -1);
        mainBreadBoard.pins[row][col].addObserver(pin[0]);
        firstpan = new JPanel();
        firstpan.setBounds(x-5,y-5,25,25);
        firstpan.setBorder(new LineBorder(Color.CYAN, 2));
        firstpan.add(new JLabel(""+Wire.numOfCreatedWires));
        firstpan.setOpaque(true);
        this.mainBreadBoard.pins[row][col].square.setVisible(false);
        this.mainframe.add(firstpan);
        
        
        
         
    }
    public void drawSecPin(int x,int y,int row,int col)
    {
        pin[1]=new MPin(true, mainBreadBoard.pins[row][col],0, this, 1, -1);
        mainBreadBoard.pins[row][col].addObserver(pin[1]);
        connect();
        secondpan = new JPanel();
        secondpan.setBounds(x-5,y-5,25,25);  
        secondpan.setOpaque(false);
        JLabel jl=new JLabel(""+Wire.numOfCreatedWires);
        jl.setSize(10, 10);
        secondpan.add(jl);
         secondpan.setBorder(new LineBorder(Color.CYAN, 2));
        this.mainBreadBoard.pins[row][col].square.setVisible(false);
        this.mainframe.add(secondpan);
        
        firstpan.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) { 
        if (arg0.getButton() == MouseEvent.BUTTON3){  
            if(firstpan==null||secondpan==null)return ;
            //get the mouse button
            firstpan.setVisible(false);
            secondpan.setVisible(false);
            mainBreadBoard.pins[pin[0].getObserver().getCurrow()][pin[0].getObserver().getCurcol()].square.setVisible(true);
            mainBreadBoard.pins[pin[1].getObserver().getCurrow()][pin[1].getObserver().getCurcol()].square.setVisible(true);
            pin[0].getObserver().delete();
            pin[1].getObserver().delete();
            pin[0].delete();
            pin[1].delete();
        }
    }
});
        
        secondpan.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) { 
        if (arg0.getButton() == MouseEvent.BUTTON3){  
            if(firstpan==null||secondpan==null)return ;
            //get the mouse button
            firstpan.setVisible(false);
            secondpan.setVisible(false);
            mainBreadBoard.pins[pin[0].getObserver().getCurrow()][pin[0].getObserver().getCurcol()].square.setVisible(true);
            mainBreadBoard.pins[pin[1].getObserver().getCurrow()][pin[1].getObserver().getCurcol()].square.setVisible(true);
            pin[0].getObserver().delete();
            pin[1].getObserver().delete();
            pin[0].delete();
            pin[1].delete();
        }
    }
});
        
          
        for(int i=0;i<mainBreadBoard.getNumOfRows();i++)
        {
            for(int ii=0;ii<mainBreadBoard.getNumOfCols();ii++)
            {
                System.out.print(mainBreadBoard.pins[i][ii].getValue()+" ");
            }
            System.out.println("");
        }
                
    }
       private void connect()
       {
           if(pin[0]==null||pin[1]==null)return ;
           if(pin[0].getValue()==0&&pin[1].getValue()==0)
           {
               return ;
           }
            if((pin[0].getValue()==-1&&pin[1].getValue()==2)||(pin[0].getValue()==1&&pin[1].getValue()==-2))
           {
             
               pin[1].setvalue(2*pin[0].getValue());
               return;
           }
            if((pin[1].getValue()==-1&&pin[0].getValue()==2)||(pin[1].getValue()==1&&pin[0].getValue()==-2))
           {
               pin[0].setvalue(2*pin[1].getValue());
              
           }
           else if(pin[1].getValue()>0&&pin[0].getValue()<=0)
           {
               pin[0].Upadate(2);
               //pin[0].setvalue(2);
              // pin[0].changeForGate(2);
           }
           else if(pin[0].getValue()>0&&pin[1].getValue()<=0)
           {
               pin[1].Upadate(2);
                //pin[1].setvalue(2);
                //pin[0].changeForGate(2);
           }
           else if(pin[1].getValue()<0&&pin[0].getValue()==0)
           {
               pin[0].Upadate(-2);
                //pin[0].setvalue(-2);
               // pin[0].changeForGate(-2);
           }   
           else if(pin[0].getValue()<0&&pin[1].getValue()==0)
           {
                // pin[1].setvalue(-2);
               pin[1].Upadate(-2);
               // pin[1].changeForGate(-2);
           } 
           
           
          
       }
    @Override
    public void pinchanged(int x, int y) {
        connect();
    }
    
    
    
    
    
  
}
