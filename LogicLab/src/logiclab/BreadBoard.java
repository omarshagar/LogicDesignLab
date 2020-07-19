/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import com.sun.prism.image.ViewPort;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.OverlayLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 *
 * @author omarshagar
 */
public class BreadBoard {

    private int numOfCols;
    private int numOfRows;
    public FPin pins[][];
    private final int distanceBetweenRows = 10;
    private final int distanceBetweenCols = 10;
    private int frameWieght;
    private int frameLength;
    private final int squarelen = 10;
    JPanel frame;

    public BreadBoard(int numOfCols, int numOfRows, JPanel mainFrame) {
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
        pins = new FPin[numOfRows + 4][numOfCols];
        calcWL();
        this.frame = mainFrame;

    }

    //this function to calculate the wieght and length of outer frame
    private void calcWL() {
        frameWieght = 2 * distanceBetweenRows + numOfCols * squarelen + (numOfCols - 1) * squarelen;
        frameLength = 2 * (3 * distanceBetweenRows + 2 * squarelen) + 15 * distanceBetweenRows + 6 * (5 * squarelen + 4 * distanceBetweenRows);
    }

    //this function is to inital all fpins and draw it
    public void drawPins(Yard d) {
        int x = 10, y = 10;
        int row = 0;
        for (row = 0; row < 2; row++) {
            x = 10;
            for (int j = 0; j < numOfCols; j++) {

                pins[row][j] = new FPin(row, j, x, y, this);
                if (row == 1) {
                    pins[row][j].color = Color.BLACK;
                }
                d.getMainFrame().add(pins[row][j].getSquare());
                x += 20;
            }
            y += 20;
        }
        for (int ii = 0; ii < 6; ii++) {
            y += 10;
            int rr=row+5;
            for (; row <rr; row++) {
                x = 10;
                for (int j = 0; j < numOfCols; j++) {
                    pins[row][j] = new FPin(row, j, x, y, this);
                    pins[row][j].color = Color.BLUE;
                    d.getMainFrame().add(pins[row][j].getSquare());
                    x += 20;
                }
                y += 20;
            }
        }
        y+=10;
        int rr=row+2;
        for (; row < rr; row++) {
            x = 10;
            for (int j = 0; j < numOfCols; j++) {

                pins[row][j] = new FPin(row, j, x, y, this);
                if (row == 32) {
                    pins[row][j].color = Color.BLACK;
                }
                d.getMainFrame().add(pins[row][j].getSquare());
                x += 20;
            }
            y += 20;
        }

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
/*class BreadFrame extends JPanel {
  Rectangle RECT ;
  Dimension INNER_PANEL_SIZE = new Dimension(9000, JFrame.MAXIMIZED_VERT);
  Dimension SCROLLPANE_SIZE = new Dimension(900, 900);
  
  InnerPanel innerPanel = new InnerPanel();
  JViewport viewport = new JViewport();
  
  BreadFrame(int x,int y,int w,int h) {
    RECT = new Rectangle(x, y, w, h);
    JScrollPane scrollpane = new JScrollPane();
    scrollpane.setViewport(viewport);
    viewport.add(innerPanel);
    scrollpane.setPreferredSize(SCROLLPANE_SIZE);
    setLayout(new BorderLayout());
    add(scrollpane, BorderLayout.CENTER);
    this.setOpaque(true);
   
  }
  class InnerPanel extends JPanel {
    InnerPanel(){
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
    }
  }
}*/
