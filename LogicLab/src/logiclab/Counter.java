/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

/**
 *
 * @author el-feky
 */
public class Counter implements component {

    Pin[][] CounterPins;
    //boolean val1, val2;

    public Counter() {
        CounterPins = new Pin[2][4];
        //val1 = false;
        //val2 = false;
    }

    @Override
    public void pinchanged(int x, int y) {
        if (CounterPins[1][2].getValue() > 0 && CounterPins[1][3].getValue() < 0) {
            if (CounterPins[1][0].getCurrow() == x && CounterPins[1][0].getCurcol() == y) {
                if (CounterPins[1][0].getValue() > 0) {
                    
                    changeOutPut(true, 0);
                }
            } else if (CounterPins[1][1].getCurrow() == x && CounterPins[1][1].getCurcol() == y) {
                if (CounterPins[1][1].getValue() > 0) {
                    
                    changeOutPut(true, 1);
                }

            }
        }

    }

    private void changeOutPut(boolean output, int outNum) {
        if (outNum > 3) {
            return;
        }
        if (output) {
            int val = CounterPins[0][outNum].getValue();
            CounterPins[0][outNum].Upadate(Convert(!(val > 0)));
            changeOutPut(val > 0, outNum++);
        }
    }

    protected int Convert(boolean x) {
        if (x) {
            return 1;
        }
        return 0;
    }

}
