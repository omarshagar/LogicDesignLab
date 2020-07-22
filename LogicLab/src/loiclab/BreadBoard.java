package loiclab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.sun.prism.image.ViewPort;
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
public class BreadBoard implements component{

    private int numOfCols;
    private int numOfRows;
    public FPin pins[][];
    private final int distanceBetweenRows = 10;
    private final int distanceBetweenCols = 10;
    private int frameWieght;
    private int frameLength;
    private final int squarelen = 10;
    JPanel frame;
    private Yard yard;

    public BreadBoard(int numOfCols, int numOfRows, JPanel mainFrame,Yard yard) {
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
        pins = new FPin[numOfRows+4 ][numOfCols];
        calcWL();
        this.frame = mainFrame;
        this.yard=yard;

    }

    //this function to calculate the wieght and length of outer frame
    private void calcWL() {
        frameWieght = 2 * distanceBetweenRows + numOfCols * squarelen + (numOfCols - 1) * squarelen;
        frameLength = 2 * (3 * distanceBetweenRows + 2 * squarelen) + 15 * distanceBetweenRows + 6 * (5 * squarelen + 4 * distanceBetweenRows);
    }

    //this function is to inital all fpins and draw it
    public void drawPins(Yard d) {
        int x = distanceBetweenCols, y = distanceBetweenRows;
        int row = 0;
        for (row = 0; row < 2; row++) {
            x = distanceBetweenCols;
            for (int j = 0; j < numOfCols; j++) {

                pins[row][j] = new FPin(row, j, x, y, this,this.yard);
                if (row == 1) {
                    pins[row][j].color = Color.BLACK;
                }
                d.getMainFrame().add(pins[row][j].getSquare());
                x += 2*distanceBetweenCols;
            }
            y += 2*distanceBetweenRows;
        }
        for (int ii = 0; ii < 6; ii++) {
            y += distanceBetweenRows;
            int rr=row+5;
            for (; row <rr; row++) {
                x = distanceBetweenCols;
                for (int j = 0; j < numOfCols; j++) {
                    pins[row][j] = new FPin(row, j, x, y, this,this.yard);
                    pins[row][j].color = Color.BLUE;
                    d.getMainFrame().add(pins[row][j].getSquare());
                    x += 2*distanceBetweenCols;
                }
                y += 2*distanceBetweenRows;
            }
        }
        y+=distanceBetweenRows;
        int rr=row+2;
        for (; row < rr; row++) {
            x = distanceBetweenCols;
            for (int j = 0; j < numOfCols; j++) {

                pins[row][j] = new FPin(row, j, x, y, this,this.yard);
                if (row == 32) {
                    pins[row][j].color = Color.BLACK;
                }
                d.getMainFrame().add(pins[row][j].getSquare());
                x += 2*distanceBetweenCols;
            }
            y += 2*distanceBetweenRows;
        }
           pins[0][0].Upadate(2);
           pins[1][0].Upadate(-2);
    }
   //this function is to connect fpins together
    @Override
     public void pinchanged(int row,int col)
    {
        if(row==0||row==1||row==33||row==32)
        {
            int pre[]=new int[numOfCols];
            int suf[]=new int[numOfCols];
            int val=0;
            for(int i=0;i<numOfCols;i++)
            {
                if(pins[row][i].getValue()==2)
                {
                    val=1;
                    pre[i]=2;
                }
                else if(pins[row][i].getValue()==-2)
                {
                    val=-1;
                    pre[i]=-2;
                }
                else 
                {
                    pre[i]=val;
                }
            }
            val=0;
            for(int i=numOfCols-1;i>=0;i--)
            {
                if(pins[row][i].getValue()==2)
                {
                    val=1;
                    suf[i]=2;
                }
                else if(pins[row][i].getValue()==-2)
                {
                    val=-1;
                    suf[i]=-2;
                }
                else 
                {
                    suf[i]=val;
                }
            }
            for(int i=0;i<numOfCols;i++)
            {
                int tmp=0;
                if(pre[i]==2||pre[i]==-2)
                {
                    tmp=pre[i];
                }
                else if(pre[i]==1||suf[i]==1)tmp=1;
                else if (pre[i]==-1||suf[i]==-1)tmp=-1;
                pins[row][i].Upadate(tmp);
            }
        }     
        else
        {
           // System.out.println("7a7a");
            int pre[]=new int[5];
            int suf[]=new int[5];
            int val=0;
            int start,end;            
            int x=(int)((row-2)/5.0);
            x*=5;
            start=x+2;
            end=start+5;
            if(start>33||end>33)
            System.out.println(start+" "+end);
            for(int i=0;i<5;i++)
            {
                if(pins[i+start][col].getValue()==2)
                {
                    val=1;
                    pre[i]=2;
                }
                else if(pins[i+start][col].getValue()==-2)
                {
                    val=-1;
                    pre[i]=-2;
                }
                else 
                {
                    pre[i]=val;
                }
            }
            val=0;
            for(int i=4;i>=0;i--)
            {
                if(pins[i+start][col].getValue()==2)
                {
                    val=1;
                    suf[i]=2;
                }
                else if(pins[i+start][col].getValue()==-2)
                {
                    val=-1;
                    suf[i]=-2;
                }
                else 
                {
                    suf[i]=val;
                }
            }
            
            for(int i=0;i<5;i++)
            {
                int tmp=0;
                if(suf[i]==2||pre[i]==-2)
                {
                    tmp=pre[i];
                }
                else if(pre[i]==1||suf[i]==1)tmp=1;
                else if (pre[i]==-1||suf[i]==-1)tmp=-1;
                pins[i+start][col].Upadate(tmp);
            }
        }
    }
    public int getNumOfCols() {
        return numOfCols;
    }

    public void setNumOfCols(int numOfCols) {
        this.numOfCols = numOfCols;
    }

    public int getNumOfRows() {
        return numOfRows+4;
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
