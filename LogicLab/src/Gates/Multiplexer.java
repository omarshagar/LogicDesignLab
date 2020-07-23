/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gates;

import loiclab.Pin;
import loiclab.component;

/**
 *
 * @author el-feky
 */
public class Multiplexer implements component {

    Pin[][] gatePins;

    public Multiplexer() {
        gatePins = new Pin[8][2];
    }

    @Override
    public void pinchanged(int x, int y) {
        if (gatePins[0][7].getValue() < 0 && gatePins[1][0].getValue() > 0) {
            if (gatePins[0][6].getValue() < 0) {
                boolean A = ConverterToB(gatePins[1][5].getValue()),
                        B = ConverterToB(gatePins[1][6].getValue()), C = ConverterToB(gatePins[1][7].getValue());
                ///
                //// C is the most significant
                if (!A && !B && !C) {
                    setY(gatePins[0][3].getValue());
                }
                else if (A && !B && !C) {
                    setY(gatePins[0][2].getValue());
                }
                else if (!A && B && !C) {
                    setY(gatePins[0][1].getValue());
                }
                else if (A && B && !C) {
                    setY(gatePins[0][0].getValue());
                }
                else if (!A && !B && C) {
                    setY(gatePins[1][1].getValue());
                }
                else if (A && !B && C) {
                    setY(gatePins[1][2].getValue());
                }
                else if (!A && B && C) {
                    setY(gatePins[1][3].getValue());
                }
                else if (A && B && C) {
                    setY(gatePins[1][4].getValue());
                }
            }
        }

    }
    protected void setY(int x){
        boolean Y;
        Y = ConverterToB(x);
        gatePins[0][4].Upadate(ConvertToI(Y));
        gatePins[0][5].Upadate(ConvertToI(!Y));
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
