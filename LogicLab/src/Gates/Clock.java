/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gates;

import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;
import logiclab.Pin;
import logiclab.component;

/**
 *
 * @author el-feky
 */
public class Clock extends Thread  implements component {

    Pin clockPin;
    double Frequency,time;
    
    public Clock(){
        clockPin = new Pin(true, clockPin, 1, this, 1, 1);
    }
    
    @Override
    public void run() {
        generateFrequency();
    }
    public void setFrequency(double Frequency){
        this.Frequency = abs(Frequency);
        this.time = 1/(this.Frequency*1.0);
    }

    public void generateFrequency(){
        while (true) {    
            clockPin.Upadate(1);
            try {
                
                Thread.sleep((long) (this.time*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            clockPin.Upadate(0);
            try {
                
                Thread.sleep((long) (this.time*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void pinchanged(int x, int y) {

    }

    

}
