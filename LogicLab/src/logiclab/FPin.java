/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

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
  public Rectangle rec;
    private BreadBoard parentBreadBoard;

    public FPin(int curRowInBB, int curColInBB, int rowLocInPanel, int colLocInPanel,BreadBoard parentBreadBoard) {
        this.curRowInBB = curRowInBB;
        this.curColInBB = curColInBB;
        this.rowLocInPanel = rowLocInPanel;
        this.colLocInPanel = colLocInPanel;
        this.parentBreadBoard=parentBreadBoard;
        rec=new Rectangle(this.rowLocInPanel,this.colLocInPanel,10,10);
        
    }

    public Rectangle getRec() {
        return rec;
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
