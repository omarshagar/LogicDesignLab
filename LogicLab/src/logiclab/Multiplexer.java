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
 * @author el-feky
 */
public class Multiplexer implements component {
    MPin[][] gatePins;
    private JPanel jp;
    private JPanel mainframe;
    private BreadBoard mainBreadBoard;
    JLabel lab;
    public Multiplexer(BreadBoard mainBoard, JPanel MainFrame) {
        this.mainBreadBoard = mainBoard;
        this.mainframe = MainFrame;
        gatePins = new MPin[2][8];
        for (int i = 0; i < 2; i++) {
            for (int ii = 0; ii < 8; ii++) {
                //boolean hasObserver, Pin observer, int value, component parent, int currow, int curcol)
                gatePins[i][ii] = new MPin(false, null, 0, this, i, ii);
            }
        }
        jp = new JPanel(new GridLayout());
        lab = new JLabel();

       lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("mul.png")));
        jp.add(lab);

    }
         public void add(int row, int col) throws IOException {
        if (row >= 33 || mainBreadBoard.getNumOfCols() - (col + 8) < 0) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int ii = 0; ii < 8; ii++) {
                mainBreadBoard.pins[row + i][col + ii].square.setVisible(false);
                gatePins[i][ii].addObserver(mainBreadBoard.pins[i + row][ii + col]);
                mainBreadBoard.pins[i + row][ii + col].addObserver(gatePins[i][ii]);
            }
        }
        FPin fp = mainBreadBoard.pins[row][col];
        jp.setBounds(fp.getRowLocInPanel() , fp.getColLocInPanel()-5, 150, 50);
        jp.setVisible(true);
        this.mainframe.add(jp);

        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON3) {
                    //get the mouse button
                    jp.setVisible(false);

                    for (int i = 0; i < 2; i++) {
                        for (int ii = 0; ii < 8; ii++) {
                           mainBreadBoard.pins[gatePins[i][ii].getObserver().getCurrow()][gatePins[i][ii].getObserver().getCurcol()].square.setVisible(true);
                    gatePins[i][ii].getObserver().delete();
                    gatePins[i][ii].delete();
                        }
                    }
                }
            }
        });
    }
    @Override
    public void pinchanged(int x, int y) {
        if((x==1&&y==4)||(x==1||y==5))return ;
        if (gatePins[1][7].getValue() < 0 && gatePins[0][0].getValue() > 0) {
            if (gatePins[1][6].getValue() < 0) {
                boolean A = ConverterToB(gatePins[0][5].getValue()),
                        B = ConverterToB(gatePins[0][6].getValue()), C = ConverterToB(gatePins[0][7].getValue());
                ///
                //// C is the most significant
                if (!A && !B && !C) {
                    setY(gatePins[1][3].getValue());
                }
                else if (A && !B && !C) {
                    setY(gatePins[1][2].getValue());
                }
                else if (!A && B && !C) {
                    setY(gatePins[1][1].getValue());
                }
                else if (A && B && !C) {
                    setY(gatePins[1][0].getValue());
                }
                else if (!A && !B && C) {
                    setY(gatePins[0][1].getValue());
                }
                else if (A && !B && C) {
                    setY(gatePins[0][2].getValue());
                }
                else if (!A && B && C) {
                    setY(gatePins[0][3].getValue());
                }
                else if (A && B && C) {
                    setY(gatePins[0][4].getValue());
                }
            }
        }

    }
    protected void setY(int x){
        boolean Y;
        Y = ConverterToB(x);
        gatePins[1][4].changeForGate(ConvertToI(Y)*2);
        gatePins[1][5].changeForGate(ConvertToI(!Y)*2);   
       // System.out.println(ConvertToI(Y));
    }
    public int ConvertToI(boolean x) {
        if (x) {
            return 1;
        }
        return 0;
    }

    public boolean ConverterToB(int x) {
        return x > 0;

    }

}
