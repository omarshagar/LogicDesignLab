/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

/**
 *
 * @author omerh
 */
public class Four_Bit_Adder implements component{
  private int carry=0;
 public Pin out[][];
    Four_Bit_Adder()
    {
    out=new Pin[9][2];
    }
    public void cin(Pin A0,Pin A1,Pin A2,Pin A3,Pin B0,Pin B1,Pin B2,Pin B3,Pin C_O)
    {
    out[0][0]=A0;out[1][0]=A1;out[2][0]=A2;out[3][0]=A3;
    out[4][0]=B0;out[5][0]=B1;out[6][0]=B2;out[7][0]=B3;
    out[8][0]=C_O;
    int num=C_O.getValue();
    if(num==1) carry=1;
    else carry=0;   
    }  
int x=0;
int m=0;
    @Override
    public void pinchanged(int x, int y) {
     while(x<=4)
     {
     int c=0;
     int che=(out[m][0].getValue()^out[m+4][0].getValue())^carry;
     out[x][1].Upadate(che);
     if(out[m][0].getValue()==1) c++;
     if(out[m+4][0].getValue()==1) c++;
     if(carry==1) c++;   
     if(c>=2) carry=1;
     else carry=0;
      x++;m++;
     if(x==4) out[4][1].Upadate(carry);
    }
    }
}
