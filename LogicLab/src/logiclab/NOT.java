/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import javax.swing.JPanel;

/**
 *
 * @author el-feky
 */
public class NOT extends Gate{

    public NOT(BreadBoard mainBoard, JPanel MainFrame) {
        super(mainBoard, MainFrame);
    }
    @Override
    public void pinchanged(int currow,int curcol){
        if(gatePins[0][0].getValue()>0&&gatePins[1][6].getValue()<0){
            //first gate
            gatePins[1][1].changeForGate(gateLogic(gatePins[1][0].getValue(), 0));
            //second gate
            gatePins[1][3].changeForGate(gateLogic(gatePins[1][2].getValue(), 0));
            //third gate
            gatePins[1][5].changeForGate(gateLogic(gatePins[1][4].getValue(), 0));
            //fourth gate
            gatePins[0][6].changeForGate(gateLogic(gatePins[0][5].getValue(), 0));
            gatePins[0][4].changeForGate(gateLogic(gatePins[0][3].getValue(), 0));
            gatePins[0][2].changeForGate(gateLogic(gatePins[0][1].getValue(), 0));   
        }
    }
    
    @Override
    public int gateLogic(int val1, int val2) {
        if(val1>0){
            return 0;
        }
        else{
            return 2;
        }
    }

    @Override
    public void setPic() {
        this.lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("not.png")));
    }
    
}
