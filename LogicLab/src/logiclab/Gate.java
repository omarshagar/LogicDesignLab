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
import logiclab.Pin;
import logiclab.component;

/**
 *
 * @author el-feky
 */
public abstract class Gate implements component {

    MPin[][] gatePins;
    private JPanel jp;
    private JPanel mainframe;
    private BreadBoard mainBreadBoard;
    JLabel lab;

    public Gate(BreadBoard mainBoard, JPanel MainFrame) {
        this.mainBreadBoard = mainBoard;
        this.mainframe = MainFrame;
        gatePins = new MPin[2][7];
        for (int i = 0; i < 2; i++) {
            for (int ii = 0; ii < 7; ii++) {
                //boolean hasObserver, Pin observer, int value, component parent, int currow, int curcol)
                gatePins[i][ii] = new MPin(false, null, 0, this, i, ii);
            }
        }
        jp = new JPanel(new GridLayout());
        lab = new JLabel();

        setPic();
        jp.add(lab);

    }

    @Override
    public void pinchanged(int currow, int curcol) {
        if (gatePins[0][0].getValue() > 0 && gatePins[1][6].getValue() < 0) {
            //first gate
           // gatePins[1][2].setvalue(gateLogic(gatePins[1][0].getValue(), gatePins[1][1].getValue()));
            //gatePins[1][2].Upadate(gateLogic(gatePins[1][0].getValue(), gatePins[1][1].getValue()));
            gatePins[1][2].changeForGate(gateLogic(gatePins[1][0].getValue(), gatePins[1][1].getValue()));
            //second gate
            // gatePins[1][5].setvalue(gateLogic(gatePins[1][3].getValue(), gatePins[1][4].getValue()));
           // gatePins[1][5].Upadate(gateLogic(gatePins[1][3].getValue(), gatePins[1][4].getValue()));
            gatePins[1][5].changeForGate(gateLogic(gatePins[1][3].getValue(), gatePins[1][4].getValue()));
            
            //third gate
           // gatePins[0][6].setvalue(gateLogic(gatePins[0][5].getValue(), gatePins[0][4].getValue()));
          //  gatePins[0][6].Upadate(gateLogic(gatePins[0][5].getValue(), gatePins[0][4].getValue()));
             gatePins[0][6].changeForGate(gateLogic(gatePins[0][5].getValue(), gatePins[0][4].getValue()));
            //fourth gate
           // gatePins[0][3].setvalue(gateLogic(gatePins[0][2].getValue(), gatePins[0][1].getValue()));
          //  gatePins[0][3].Upadate(gateLogic(gatePins[0][2].getValue(), gatePins[0][1].getValue()));
             gatePins[0][3].changeForGate(gateLogic(gatePins[0][2].getValue(), gatePins[0][1].getValue()));

        }
    }

    //check values here
    public abstract int gateLogic(int val1, int val2);

    //lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("dark.png")));
    public abstract void setPic();

    public void add(int row, int col) throws IOException {
        if (row >= 33 || mainBreadBoard.getNumOfCols() - (col + 7) < 0) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int ii = 0; ii < 7; ii++) {
                mainBreadBoard.pins[row + i][col + ii].square.setVisible(false);
                gatePins[i][ii].addObserver(mainBreadBoard.pins[i + row][ii + col]);
                mainBreadBoard.pins[i + row][ii + col].addObserver(gatePins[i][ii]);
            }
        }
        FPin fp = mainBreadBoard.pins[row][col];
        jp.setBounds(fp.getRowLocInPanel() , fp.getColLocInPanel() - 5, 130, 50);
        jp.setVisible(true);
        this.mainframe.add(jp);

        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON3) {
                    //get the mouse button
                    jp.setVisible(false);

                    for (int i = 0; i < 2; i++) {
                        for (int ii = 0; ii < 7; ii++) {
                           mainBreadBoard.pins[gatePins[i][ii].getObserver().getCurrow()][gatePins[i][ii].getObserver().getCurcol()].square.setVisible(true);
                    gatePins[i][ii].getObserver().delete();
                    gatePins[i][ii].delete();
                        }
                    }
                }
            }
        });
    }
}
