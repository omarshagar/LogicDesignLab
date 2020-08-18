/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author omerh
 */
public class Four_Bit_Adder implements component{
    private int carry=0;
    private MPin out[][];
    private JPanel jp;
    private JPanel mainframe;
    private BreadBoard mainBreadBoard;
    JLabel lab;
    public Four_Bit_Adder(BreadBoard mainBoard, JPanel MainFrame) {
        this.mainBreadBoard = mainBoard;
        this.mainframe = MainFrame;
        out = new MPin[2][9];
        for (int i = 0; i < 2; i++) {
            for (int ii = 0; ii < 9; ii++) {
                //boolean hasObserver, Pin observer, int value, component parent, int currow, int curcol)
                out[i][ii] = new MPin(false, null, 0, this, i, ii);
            }
        }
        jp = new JPanel(new GridLayout());
        lab = new JLabel();

       lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("adder.png")));
        jp.add(lab);

    }
    /*public void cin(Pin A0,Pin A1,Pin A2,Pin A3,Pin B0,Pin B1,Pin B2,Pin B3,Pin C_O)
    {
    out[0][0]=A0;out[0][1]=A1;out[0][2]=A2;out[0][3]=A3;
    out[4][0]=B0;out[5][0]=B1;out[6][0]=B2;out[7][0]=B3;
    out[8][0]=C_O;
    } */
     public void add(int row, int col) throws IOException {
        if (row >= 33 || mainBreadBoard.getNumOfCols() - (col + 9) < 0) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int ii = 0; ii < 9; ii++) {
                mainBreadBoard.pins[row + i][col + ii].square.setVisible(false);
                out[i][ii].addObserver(mainBreadBoard.pins[i + row][ii + col]);
                mainBreadBoard.pins[i + row][ii + col].addObserver(out[i][ii]);
            }
        }
      int num=out[1][8].getValue();
      if(num==1) carry=1;
      else carry=0; 
        FPin fp = mainBreadBoard.pins[row][col];
        jp.setBounds(fp.getRowLocInPanel() , fp.getColLocInPanel()-5, 170, 50);
        jp.setVisible(true);
        this.mainframe.add(jp);

        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON3) {
                    //get the mouse button
                    jp.setVisible(false);

                    for (int i = 0; i < 2; i++) {
                        for (int ii = 0; ii < 9; ii++) {
                           mainBreadBoard.pins[out[i][ii].getObserver().getCurrow()][out[i][ii].getObserver().getCurcol()].square.setVisible(true);
                   out[i][ii].getObserver().delete();
                   out[i][ii].delete();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void pinchanged(int r, int y) {
int x=0;
int m=0;
        if(out[0][5].getValue()<=0||out[0][6].getValue()>0)return ;
        if((r==0&&y==0)||(r==0&&y==1)||(r==0&&y==2)||(r==0&&y==3)||(r==0&&y==4))return ;
     while(x<=4)
     {
     int c=0;
     int che=(out[1][m].getValue()^out[1][m+4].getValue())^carry;
     out[0][x].changeForGate(che*2);
     if(out[1][m].getValue()==1) c++;
     if(out[1][m+4].getValue()==1) c++;
     if(carry==1) c++;   
     if(c>=2) carry=1;
     else carry=0;
      
     // if(x>0)out[0][m-1].changeForGate(carry*2);
      x++;m++;
      if(x==4) out[0][4].changeForGate(carry*2);
    
     
    }
    }
}
