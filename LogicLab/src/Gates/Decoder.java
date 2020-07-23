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
public class Decoder implements component {

    Pin[][] gatePins;

    public Decoder() {
        gatePins = new Pin[2][8];
    }
    
   
    @Override
    public void pinchanged(int x, int y) {
        if (gatePins[1][7].getValue() < 0 && gatePins[0][0].getValue() > 0) {
            if (gatePins[1][3].getValue() > 0 && gatePins[1][4].getValue() > 0 && gatePins[1][5].getValue() < 0) {
                ///////////////////////////
                int A = gatePins[1][0].getValue(), B = gatePins[1][1].getValue(), C = gatePins[1][2].getValue();
                
                gatePins[0][1].Upadate(ConvertToI((!ConverterToB(A)) && (!ConverterToB(B)) && (!ConverterToB(C))));
                gatePins[0][2].Upadate(ConvertToI(((ConverterToB(A)) && (!ConverterToB(B)) && (!ConverterToB(C)))));
                gatePins[0][3].Upadate(ConvertToI(((!ConverterToB(A)) && (ConverterToB(B)) && (!ConverterToB(C)))));
                gatePins[0][4].Upadate(ConvertToI(((ConverterToB(A)) && (ConverterToB(B)) && (!ConverterToB(C)))));
                gatePins[0][5].Upadate(ConvertToI(((!ConverterToB(A)) && (!ConverterToB(B)) && (ConverterToB(C)))));
                gatePins[0][6].Upadate(ConvertToI(((ConverterToB(A)) && (!ConverterToB(B)) && (ConverterToB(C)))));
                gatePins[0][7].Upadate(ConvertToI(((!ConverterToB(A)) && (ConverterToB(B)) && (ConverterToB(C)))));
                gatePins[1][6].Upadate(ConvertToI(((ConverterToB(A)) && (ConverterToB(B)) && (ConverterToB(C)))));
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
