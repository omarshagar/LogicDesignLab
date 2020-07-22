package loiclab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
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
    }
    
    
    public void drawFirstPin(int x,int y,int row,int col)
    {
        
        pin[0]=new MPin(true, mainBreadBoard.pins[row][col], 0, this, 0, -1);
        mainBreadBoard.pins[row][col].addObserver(pin[0]);
        firstpan = new JPanel();
        firstpan.setBounds(x,y,25,25);
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
        secondpan.setBounds(x,y,25,25);  
        secondpan.setOpaque(false);
        JLabel jl=new JLabel(""+Wire.numOfCreatedWires);
        jl.setSize(10, 10);
        secondpan.add(jl);
         secondpan.setBorder(new LineBorder(Color.CYAN, 2));
        this.mainBreadBoard.pins[row][col].square.setVisible(false);
        this.mainframe.add(secondpan);
        
        
        
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
           
           else if(pin[1].getValue()>0&&pin[0].getValue()<=0)
           {
               pin[0].Upadate(2);
           }
           else if(pin[0].getValue()>0&&pin[1].getValue()<=0)
           {
               pin[1].Upadate(2);
           }
           else if(pin[1].getValue()<0&&pin[0].getValue()==0)
           {
               pin[0].Upadate(-2);
           }   
           else if(pin[0].getValue()<0&&pin[1].getValue()==0)
           {
               pin[1].Upadate(-2);
           }  
       }
    @Override
    public void pinchanged(int x, int y) {
        connect();
    }
    
    
    
    
    
  
}
