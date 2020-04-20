/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlab;

/**
 *
 * @author omarshagar
 */
public class Wire implements Component {
    private MPin pin1;
    private MPin pin2;

    public Wire(FPin fpin1, FPin fpin2) {
        
        
        /// still Mpin dont know Fpin
      pin1=new MPin();
       pin2=new MPin();
    }

    public MPin getPin1() {
        return pin1;
    }

    public void setPin1(MPin pin1) {
        this.pin1 = pin1;
    }

    public MPin getPin2() {
        return pin2;
    }

    public void setPin2(MPin pin2) {
        this.pin2 = pin2;
    }

    @Override
    public void updatePinValue(Pin pin) {
       if(pin.getValue()==-1)
       {
           if(pin1!=pin&&pin1.getValue()!=-1)
           {
               pin1.changeValue(-1);
           }
           if(pin2!=pin&&pin1.getValue()!=-1)
           {
               pin2.changeValue(-1);
           }
       }
       else if(pin.getValue()==1)
       {
           if(pin1!=pin&&pin1.getValue()==0)
           {
               pin1.changeValue(1);
           }
           if(pin2!=pin&&pin2.getValue()==0)
           {
               pin2.changeValue(1);
           }
       }
    }
    
   
}
