/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author omarshagar
 */
public class FPin {
    //cur loc in bread board 
    private int curRowInBB;
    private int curColInBB;
    //cur loc in panel
    private int rowLocInPanel;
    private int colLocInPanel;
  public JPanel square;
  public Color color=Color.RED;
    private BreadBoard parentBreadBoard;

    public FPin(int curRowInBB, int curColInBB, int rowLocInPanel, int colLocInPanel,BreadBoard parentBreadBoard) {
        this.curRowInBB = curRowInBB;
        this.curColInBB = curColInBB;
        this.rowLocInPanel = rowLocInPanel;
        this.colLocInPanel = colLocInPanel;
        this.parentBreadBoard=parentBreadBoard;
        
        
        square =new JPanel();
        square.setSize(10,10);
        square.setBounds(rowLocInPanel, colLocInPanel, 10, 10);
        // a test to react with pins 
        square.addMouseListener(new fpinMouse(this.curRowInBB,this.curColInBB) {});
    }

    public JPanel getSquare() {
          square.setBorder(new LineBorder(color, 3));
        return square;
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
    int curr;
    int curc;
    public fpinMouse(int r,int c)
    {
        this.curr=r;
        this.curc=c;
    }
     @Override
           public void mouseReleased(MouseEvent e) {
               System.out.println(this.curr+" "+this.curc);
        // do something
         }
}