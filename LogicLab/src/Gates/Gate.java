/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gates;

import logiclab.Pin;
import logiclab.component;
/**
 *
 * @author el-feky
 */
public abstract class Gate implements component{
    Pin[][] gatePins ;
    public Gate(){
        gatePins = new Pin[7][2];
        
    }
    @Override
    public void pinchanged(int currow,int curcol){
        if(gatePins[0][1].getValue()>0&&gatePins[6][0].getValue()<0){
            //first gate
            gatePins[0][2].Upadate(gateLogic(gatePins[0][0].getValue(), gatePins[0][1].getValue()));
            //second gate
            gatePins[0][5].Upadate(gateLogic(gatePins[0][3].getValue(), gatePins[0][4].getValue()));
            //third gate
            gatePins[1][6].Upadate(gateLogic(gatePins[1][5].getValue(), gatePins[1][4].getValue()));
            //fourth gate
            gatePins[1][3].Upadate(gateLogic(gatePins[1][2].getValue(), gatePins[1][1].getValue()));
            
            
        }
    }
    //check values here
    public abstract int gateLogic(int val1,int val2);
}
