/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

/**
 *
 * @author el-feky
 */
public interface PinObservee {
    void addProvider(PinObserver o);
    void addConsumer(PinObserver o);
    void delete(PinObserver o);
    void notifyConsumers();
}
