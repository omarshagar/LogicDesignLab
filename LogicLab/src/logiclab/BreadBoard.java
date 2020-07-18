/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author omarshagar
 */
public class BreadBoard {
    private int numOfCols;
    private int numOfRows;
    public FPin pins[][];
    private  final int  distanceBetweenRows=10;
    private  final int distanceBetweenCols=10;
    private int frameWieght;
    private int frameLength;
    JPanel frame;

    public BreadBoard(int numOfCols,int numOfRows) {
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
        pins=new FPin[(int)(numOfRows/5.0)+4][numOfCols];
        calcWL();
        frame=new BreadFrame(100, 100, frameWieght, frameLength,numOfRows,numOfCols,pins,this);
     
    }
    
    private void calcWL()
    {
        frameWieght=2*(numOfCols*10)+10;
        frameLength=10*2+numOfRows*9*2+ 3*(numOfRows-5)*2;
    }
    public JPanel draw()
    {
        FPin f=new FPin(0, 0, 5, 5, this);
        
        //frame.add(f.draw());
        return frame;
    }

    public int getNumOfCols() {
        return numOfCols;
    }

    public void setNumOfCols(int numOfCols) {
        this.numOfCols = numOfCols;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public FPin[][] getPins() {
        return pins;
    }

    public void setPins(FPin[][] pins) {
        this.pins = pins;
    }

    public int getFrameWieght() {
        return frameWieght;
    }

    public void setFrameWieght(int frameWieght) {
        this.frameWieght = frameWieght;
    }

    public int getFrameLength() {
        return frameLength;
    }

    public void setFrameLength(int frameLength) {
        this.frameLength = frameLength;
    }

    public JPanel getFrame() {
        return frame;
    }

    public void setFrame(JPanel frame) {
        this.frame = frame;
    }
    
    
}
// this class is to draw the outer frame of breadboard
class BreadFrame extends JPanel {
  Rectangle RECT ;
  Dimension INNER_PANEL_SIZE = new Dimension(9000, JFrame.MAXIMIZED_VERT);
  Dimension SCROLLPANE_SIZE = new Dimension(900, 900);
  
  InnerPanel innerPanel = new InnerPanel(this.Rows,this.Cols,this.pins,this.parent);
  JViewport viewport = new JViewport();
  private int Rows;
  private int Cols;
  BreadBoard parent;
  FPin pins[][];
  BreadFrame(int x,int y,int w,int h,int rows,int cols,FPin pins[][],BreadBoard parent) {
       RECT = new Rectangle(x, y, w, h);
       this.Cols=cols;
       this.Rows=rows;
       this.parent=parent;
       this.pins=pins;
    JScrollPane scrollpane = new JScrollPane();
    scrollpane.setViewport(viewport);
    viewport.add(innerPanel);
    scrollpane.setPreferredSize(SCROLLPANE_SIZE);
    setLayout(new BorderLayout());
    add(scrollpane, BorderLayout.CENTER);
    this.setOpaque(true);
   
  }
  class InnerPanel extends JPanel {
  private int Rows;
  private int Cols;
  FPin pins[][];
  BreadBoard parent;
    InnerPanel(int rows,int cols,FPin pins[][],BreadBoard parent) {
        this.Cols=cols;
       this.Rows=rows;
       this.pins=pins;
       this.parent=parent;
      setPreferredSize(INNER_PANEL_SIZE);
    }
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(4));
      g2.draw(RECT);
      int curx=1200,cury=200;
        for(int i=0;i<Rows;i++)
        {
            
            pins[0][i]=new FPin(0, i,curx , cury,parent );
           g2.draw(pins[0][i].getRec());
           curx+=10;
        }
    }
    
    
  }
}