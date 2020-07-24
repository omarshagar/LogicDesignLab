package logiclab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author omarshagar
 */
public class DragSystem {
    public boolean haveComponent;
    public component currentComponent;
    public int numOfLocations;
    public int x1,x2,y1,y2;
    public DragSystem()
    {
        clean();
    }
    public void clean()
    {
        this.currentComponent=null;
        this.haveComponent=false;
        this.x1=-1;
        this.x2=-1;
        this.y1=-1;
        this.y2=-1;
    }
}
