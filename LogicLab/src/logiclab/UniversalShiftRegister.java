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
public class UniversalShiftRegister implements component {

    private Pin[][] registerPins;

    public UniversalShiftRegister() {
        registerPins = new Pin[2][8];
    }

    @Override
    public void pinchanged(int x, int y) {
        if (registerPins[0][0].getValue() > 0 && registerPins[1][7].getValue() < 0) {
            if (registerPins[0][5].getValue() > 0) {
                boolean s0 = registerPins[0][7].getValue() > 0, s1 = registerPins[0][6].getValue() > 0;
                if (registerPins[1][0].getValue() > 0) {
                    setZeros();
                } else if (s0 && !s1) {
                    SiftToRight(registerPins[1][1].getValue(), 1);
                } else if (!s0 && s1) {
                    SiftToLeft(registerPins[1][6].getValue(), 4);
                } else if (s0 && s1) {
                    ParallelMode();
                }
            }
        }
    }

    private void SiftToRight(int val, int pos) {
        if (pos > 4) {
            return;
        }
        int value = registerPins[0][pos].getValue();
        registerPins[0][pos].Upadate(val);
        SiftToRight(value, pos++);

    }

    private void SiftToLeft(int val, int pos) {
        if (pos < 1) {
            return;
        }
        int value = registerPins[0][pos].getValue();
        registerPins[0][pos].Upadate(val);
        SiftToLeft(value, pos--);

    }

    private void ParallelMode() {
        int x = 1;
        for (int i = 2; i < 6; i++) {
            registerPins[0][x].Upadate(registerPins[1][i].getValue());
            x++;
        }
    }

    protected void setZeros() {
        for (int i = 1; i < 5; i++) {
            registerPins[0][i].Upadate(0);
        }
    }

}
