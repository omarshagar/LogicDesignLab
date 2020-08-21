/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab.Gates;

import logiclab.Core.FPin;
import logiclab.Core.MPin;
import logiclab.Core.BreadBoard;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logiclab.Core.Pin;
import logiclab.Core.component;

/**
 *
 * @author el-feky
 */
public class Decoder implements component {

    MPin[][] gatePins;
    private JPanel jp;
    private JPanel mainframe;
    private BreadBoard mainBreadBoard;
    JLabel lab;

    public Decoder(BreadBoard mainBoard, JPanel MainFrame) {
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

       lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/decoder.png")));
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
        if (gatePins[1][7].getValue() < 0 && gatePins[0][0].getValue() > 0/*&&x==1&&(y==0||y==1||y==2)*/) {
            if (gatePins[1][5].getValue() > 0 && gatePins[1][4].getValue() <0 && gatePins[1][3].getValue() < 0) {
                ///////////////////////////
                int A = gatePins[1][0].getValue(), B = gatePins[1][1].getValue(), C = gatePins[1][2].getValue();
                
                gatePins[0][1].changeForGate(ConvertToI((!ConverterToB(A)) && (!ConverterToB(B)) && (!ConverterToB(C)))*2);
                gatePins[0][2].changeForGate(ConvertToI(((ConverterToB(A)) && (!ConverterToB(B)) && (!ConverterToB(C))))*2);
                gatePins[0][3].changeForGate(ConvertToI(((!ConverterToB(A)) && (ConverterToB(B)) && (!ConverterToB(C))))*2);
                gatePins[0][4].changeForGate(ConvertToI(((ConverterToB(A)) && (ConverterToB(B)) && (!ConverterToB(C))))*2);
                gatePins[0][5].changeForGate(ConvertToI(((!ConverterToB(A)) && (!ConverterToB(B)) && (ConverterToB(C))))*2);
                gatePins[0][6].changeForGate(ConvertToI(((ConverterToB(A)) && (!ConverterToB(B)) && (ConverterToB(C))))*2);
                gatePins[0][7].changeForGate(ConvertToI(((!ConverterToB(A)) && (ConverterToB(B)) && (ConverterToB(C))))*2);
                gatePins[1][6].changeForGate(ConvertToI(((ConverterToB(A)) && (ConverterToB(B)) && (ConverterToB(C))))*2);
                //System.out.println(ConvertToI(((ConverterToB(A)) && (ConverterToB(B)) && (ConverterToB(C))))+"7a7a");
            }
        }
    }

    // function overloading
    

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
