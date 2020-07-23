package logiclab;


import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omerh
 */
public class four {
 private int carry=0;
 public int out[][];
    public four()
    {
    out=new int[9][2];
    }
    public void cin(int A0,int A1,int A2,int A3,int B0,int B1,int B2,int B3,int C_O)
    {
    out[0][0]=A0;out[1][0]=A1;out[2][0]=A2;out[3][0]=A3;
    out[4][0]=B0;out[5][0]=B1;out[6][0]=B2;out[7][0]=B3;
    out[8][0]=C_O;
    if(C_O==1) carry=1;
    else carry=0;   
    }
 int x=0;
 int m=0;
      public int cal_out()
     {
      int c=0;
     if(x==4) return 0;
     else 
     {      
     out[x][1]=((out[m][0]^out[m+4][0])^carry);
     if(out[m][0]==1) c++;
     if(out[m+4][0]==1) c++;
     if(carry==1) c++;   
     if(c>=2) carry=1;
     else carry=0;
      x++;m++;
     if(x==4) out[4][1]=carry;
     return cal_out();
     }
     }
}
