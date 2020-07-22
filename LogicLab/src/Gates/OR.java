/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gates;
import loiclab.Pin;
/**
 *
 * @author el-feky
 */
public class OR extends Gate{
   
    //check values here
    @Override
    public int gateLogic(int val1,int val2){
        if(val1>0||val2>0){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
