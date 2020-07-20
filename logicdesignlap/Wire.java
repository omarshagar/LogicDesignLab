/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlap;

/**
 *
 * @author el-feky
 */
public class Wire {

    Pin pin;

    public Wire() {
        pin = new Mpin();
    }
    // it's add any pin or point to the wire and make the relation
    // shager you can remove the relation and make yours
    // you should give it if the pin is provider or consumers
    void addPin(Fpin FemalePin,boolean isProvider) {
        if(isProvider){
            pin.addProvider(FemalePin);
            FemalePin.addConsumer(pin);
        }
        else{
            pin.addConsumer(FemalePin);
            FemalePin.addProvider(pin);
        }
        
    }
    // delete the pin from the point 
    void deletePin(Fpin FemalePin){
        pin.delete(FemalePin);
    }
    
    //geting the value of the wire
    int getValue(){
        return pin.getValue();
    }
    //give you the number of consumers
    int getcon(){
        return pin.numOfCon();
    }
}
