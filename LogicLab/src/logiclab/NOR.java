/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import javax.swing.JPanel;



/**
 *
 * @author el-feky
 */
public class NOR extends Gate{

    public NOR(BreadBoard mainBoard, JPanel MainFrame) {
        super(mainBoard, MainFrame);
    }
    
    //check values here
    @Override
    public int gateLogic(int val1,int val2){
        if(!(val1>0||val2>0)){
            return 2;
        }
        else{
            return 0;
        }
    }

    @Override
    public void setPic() {
        lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("nor.png")));
    }
}
