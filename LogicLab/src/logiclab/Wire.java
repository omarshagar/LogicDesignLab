/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author el-feky
 */
public class Wire implements Component{

    Pin pin;
    
    JPanel firstpan,secondpan;
    JPanel mainframe;
    BreadBoard mainBreadBoard;
public static int numOfCreatedWires=0;
    public Wire(JPanel mainframe,BreadBoard BB) {
        pin = new Mpin();
        numOfCreatedWires++;
        this.mainframe=mainframe;
        this.mainBreadBoard=BB;
    }
    // it's add any pin or point to the wire and make the relation
    // shager you can remove the relation and make yours
    // you should give it if the pin is provider or consumers
    void addPin(FPin FemalePin,boolean isProvider) {
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
    void deletePin(FPin FemalePin){
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
    public void drawFirstPin(int x,int y,int row,int col)
    {
        firstpan = new JPanel();
        firstpan.setBounds(x,y,25,25);
        firstpan.setBorder(new LineBorder(Color.CYAN, 2));
        firstpan.add(new JLabel(""+Wire.numOfCreatedWires));
        firstpan.setOpaque(true);
        this.mainBreadBoard.pins[row][col].square.setVisible(false);
        this.mainframe.add(firstpan);
    }
    public void drawSecPin(int x,int y,int row,int col)
    {
        secondpan = new JPanel();
        secondpan.setBounds(x,y,25,25);  
        secondpan.setOpaque(false);
        JLabel jl=new JLabel(""+Wire.numOfCreatedWires);
        jl.setSize(10, 10);
        secondpan.add(jl);
         secondpan.setBorder(new LineBorder(Color.CYAN, 2));
        this.mainBreadBoard.pins[row][col].square.setVisible(false);
        this.mainframe.add(secondpan);
    }
    
    
    
}
