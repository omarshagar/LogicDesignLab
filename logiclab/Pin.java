package logiclab;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author el-feky
 */
public class Pin implements PinObservee, PinObserver {
   private boolean hasObserver;
   private Pin observer;
    private int value;
    private component parent;
    private int currow;
    private int curcol;
    
    public Pin(boolean hasObserver, Pin observer, int value, component parent, int currow, int curcol) {
        this.hasObserver = hasObserver;
        this.observer = observer;
        this.value = value;
        this.parent = parent;
        this.currow = currow;
        this.curcol = curcol;
    } 
    
    @Override
    public void addObserver(Pin o) {
       if(o!=null)
       {
           hasObserver=true;
           observer =o;
           int val;
           if(this.value==2||o.value==2)
           {
              val=2; 
           }
           else if(this.value==-2||o.value==-2)
           {
               val=-2;
           }
           else val=Math.max(this.value, o.value);
           this.Upadate(val);
           o.Upadate(val);   
       }
    }
    @Override
    public void delete() {    
      hasObserver=false;
      observer =null;
      this.value=0;
      if(parent!=null)
          parent.pinchanged(currow, curcol);
    }
    @Override
    public void notifyObserver() {
       if(observer!=null)
       observer.Upadate(value);
    }
    @Override
    public void Upadate(int value) {
       
        if(Math.abs(this.value)==2||this.value==value)
        {
            return ;
        }
         if(this.value!=value)
         {   
            this.value=value;
             if(parent!=null)
             parent.pinchanged(currow, curcol);
             this.notifyObserver();
          }
    }

    public boolean isHasObserver() {
        return hasObserver;
    }
    public Pin getObserver() {
        return observer;
    }
    public int getValue() {
        return value;
    }
    public component getParent() {
        return parent;
    }
    public int getCurrow() {
        return currow;
    }
    public int getCurcol() {
        return curcol;
    }
    public void setvalue(int val)
    {
        this.value=val;
        notifyObserver();
    }
    
}
