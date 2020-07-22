/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gates;

/**
 *
 * @author el-feky
 */
public class NOT extends Gate{
    @Override
    public void pinchanged(int currow,int curcol){
        if(gatePins[0][1].getValue()>0&&gatePins[6][0].getValue()<0){
            //first gate
            gatePins[0][1].Upadate(gateLogic(gatePins[0][0].getValue(), 0));
            //second gate
            gatePins[0][3].Upadate(gateLogic(gatePins[0][2].getValue(), 0));
            //third gate
            gatePins[0][5].Upadate(gateLogic(gatePins[0][4].getValue(), 0));
            //fourth gate
            gatePins[1][6].Upadate(gateLogic(gatePins[1][5].getValue(), 0));
            gatePins[1][4].Upadate(gateLogic(gatePins[1][3].getValue(), 0));
            gatePins[1][2].Upadate(gateLogic(gatePins[1][1].getValue(), 0));
            
            
        }
    }
    
    @Override
    public int gateLogic(int val1, int val2) {
        if(val1>0){
            return 0;
        }
        else{
            return 1;
        }
    }
    
}
