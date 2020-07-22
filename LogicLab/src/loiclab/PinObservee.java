package loiclab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author el-feky
 */
public interface PinObservee {
    
    
    
    
  public void addObserver(Pin o);
  public   void delete();
  public   void notifyObserver();
}
