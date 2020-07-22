package logiclab;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author omarshagar
 */
public class FPin extends Pin {
    //cur loc in bread board 
    private int curRowInBB;
    private int curColInBB;
    //cur loc in panel
    private int rowLocInPanel;
    private int colLocInPanel;
  public JPanel square;
  public Color color=Color.RED;
    private  BreadBoard parentBreadBoard;
  private Yard yard;
    

    public FPin(int curRowInBB, int curColInBB, int rowLocInPanel, int colLocInPanel,BreadBoard parentBreadBoard,Yard yard) {
      super(false,null,0,parentBreadBoard,curRowInBB,curColInBB);
        this.curRowInBB = curRowInBB;
        this.curColInBB = curColInBB;
        this.rowLocInPanel = rowLocInPanel;
        this.colLocInPanel = colLocInPanel;
        this.parentBreadBoard=parentBreadBoard;
        this.yard=yard;
        square =new JPanel();
        square.setSize(10,10);
        square.setBounds(rowLocInPanel, colLocInPanel, 10, 10);
        // a test to react with pins 
        square.addMouseListener(new fpinMouse(this) {});
    }

    public JPanel getSquare() {
          square.setBorder(new LineBorder(color, 3));
        return square;
    }
    public void clicked() 
    {
        
        if(this.yard.dragSystem.haveComponent)
        {
            component c=this.yard.dragSystem.currentComponent;
            if(c instanceof Wire)
            {
                if(this.yard.dragSystem.x1==-1)
                {
                    //feqy please do connectevity staff between this FPin and c wire pins
                    ((Wire) c).drawFirstPin(this.rowLocInPanel, this.colLocInPanel, this.curRowInBB, this.curColInBB);
                    this.yard.dragSystem.x1=this.colLocInPanel;
                   
                    this.yard.dragSystem.y1=this.rowLocInPanel;
                }
                else 
                {
                     //feqy please do connectevity staff between this FPin and c wire pins
                    ((Wire) c).drawSecPin(this.rowLocInPanel, this.colLocInPanel, this.curRowInBB, this.curColInBB);
                    this.yard.dragSystem.x2=this.colLocInPanel;
                    this.yard.dragSystem.y2=this.rowLocInPanel;
                   
                    this.yard.dragSystem.clean();
                     this.yard.itemselected.setText(" ");
          
                }  
            }
            else if(c instanceof Ground)
            {
                try{
                ((Ground) c).add(this.curRowInBB, this.curColInBB);
                }
                catch(IOException e)
                {
                    System.out.println("wrong has happend in opining pic");
                }
                this.yard.dragSystem.clean();
                this.yard.itemselected.setText(" ");
            }
            else if(c instanceof One)
            {
                try{
                ((One) c).add(this.curRowInBB, this.curColInBB);
                }
                catch(IOException e)
                {
                    System.out.println("wrong has happend in opining pic");
                }
                this.yard.dragSystem.clean();
                this.yard.itemselected.setText(" ");
            }
        }
        else 
        {
            this.yard.dragSystem.clean();
            this.yard.itemselected.setText(" ");
            
        }
    }
    

    public int getCurRowInBB() {
        return curRowInBB;
    }

    public void setCurRowInBB(int curRowInBB) {
        this.curRowInBB = curRowInBB;
    }

    public int getCurColInBB() {
        return curColInBB;
    }

    public void setCurColInBB(int curColInBB) {
        this.curColInBB = curColInBB;
    }

    public int getRowLocInPanel() {
        return rowLocInPanel;
    }

    public void setRowLocInPanel(int rowLocInPanel) {
        this.rowLocInPanel = rowLocInPanel;
    }

    public int getColLocInPanel() {
        return colLocInPanel;
    }

    public void setColLocInPanel(int colLocInPanel) {
        this.colLocInPanel = colLocInPanel;
    }

   

    public BreadBoard getParentBreadBoard() {
        return parentBreadBoard;
    }
     
}
//this class found to react with class
class fpinMouse extends MouseAdapter
{
   FPin parent ;
    public fpinMouse(FPin parent )
    {
        this.parent=parent;
    }
     @Override
           public void mouseReleased(MouseEvent e) {
               this.parent.clicked();
        // do something
         }
}