/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdesignlap;

import java.util.ArrayList;

/**
 *
 * @author el-feky
 */
public class LogicDesignLAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Bread Board
        Fpin[][] BB = new Fpin[7][10];
        //wire
        Wire firstOne = new Wire();
        //wire
        Wire secondWire = new Wire();
        //source
        Mpin VCC = new Mpin();
        //intialize BB
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                BB[i][j] = new Fpin();
            }
        }
        //give  source  value
        VCC.setValue(1);                               ///////////////////////////////////////////////////////////////////////////////

        VCC.addConsumer(BB[1][0]);                     //   //                                                                        //
                                                       //    VCC--------
        BB[1][0].addConsumer(BB[1][1]);                //              |                                                               // 
                                                       //   |-----------
                                                       //   |
        firstOne.addPin(BB[1][1], true);               //   node---
                                                       //         |
                                                       //     ----|
                                                       //     |
        firstOne.addPin(BB[3][0], false);              //    node----------------------------------node                                                                       //
        
        //System.out.println(BB[3][0].getValue());     //                                                                           //
        BB[3][0].addConsumer(BB[4][0]);                //                                                                           //
        
        secondWire.addPin(BB[4][0], true);             ///////////////////////////////////////////////////////////////////////////////
        
        
        secondWire.addPin(BB[5][3], false);
        System.out.println("BIn [1] [1] "+BB[1][1].getValue());
        System.out.println("BIn [3] [0] "+BB[3][0].getValue());
        System.out.println("BIn [4] [0] "+BB[4][0].getValue());
        System.out.println("SecondWire "+secondWire.getValue());
        ///////////////////////////////////////////////////////////
        
        //System.out.println(BB[5][5].getValue());
        firstOne.deletePin(BB[1][1]);
        
        ////////////////////////////////////////////////////////////
        System.out.println("BIn [1] [1] "+BB[1][1].getValue());
        System.out.println("BIn [3] [0] "+BB[3][0].getValue());
        System.out.println("BIn [4] [0] "+BB[4][0].getValue());
        System.out.println("SecondWire "+secondWire.getValue());
       // System.out.println("con s " +firstOne.getcon());
        System.out.println("BIn [5] [3] "+BB[5][3].getValue());

    }

}
