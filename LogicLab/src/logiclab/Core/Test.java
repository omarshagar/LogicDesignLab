package logiclab.Core;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author omarshagar
 */
public class Test {
    BreadBoard BB;

    public Test(BreadBoard BB) {
        this.BB = BB;
        test();
    }
    public void test()
    {
       // System.out.println("ff");
        int n;
        Scanner scn=new Scanner(System.in);
        n=scn.nextInt();
        while(n>0)
        {
            n--;
            int v,r,c;
            r=scn.nextInt();
            c=scn.nextInt();
            v=scn.nextInt();
           
               
                try{
               BB.pins[r][c].Upadate(v);
                }
                catch(Exception e)
                {
                    System.out.println(e.getClass());
                }
            for(int i=0;i<BB.getNumOfRows();i++)
            {
                for(int ii=0;ii<BB.getNumOfCols();ii++)
                {
                    System.out.print(BB.pins[i][ii].getValue());
                    System.out.print("");
                }
                System.out.println("");
            }
            
        }
    }
    
}
