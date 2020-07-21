/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiclab;

import java.util.ArrayList;

/**
 *
 * @author el-feky
 */
public class Pin implements PinObservee, PinObserver {

    protected ArrayList<Pin> Consumers;
    protected ArrayList<Pin> Providers;
    protected int Value;
    public Pin(){
        Value = 0;
        Consumers = new ArrayList<>();
        Providers = new ArrayList<>();
    }
    // it will add providers 
    @Override
    public void addProvider(PinObserver PinProvider) {
        int val = ((Pin) PinProvider).getValue();
        this.checkValue(val,true);
        Providers.add(((Pin) PinProvider));
    }
    // it will check the value before he add any new value to give priority to positive value
    private void checkValue(int val,boolean addProv){
        boolean hasVlauePositive = false;
        boolean hasVlaueNigative = false;
        for (Pin provider : Providers) {
            if (provider.getValue() == 1) {
                hasVlauePositive = true;
                
            } else if (provider.getValue() == -1) {
                hasVlaueNigative = true;
                
            } else if (provider.getValue() == 0&&addProv) {
                Consumers.add(provider);
                provider.Providers.add(this);
            }
        }
        this.clearTheMess();
        
        if (!hasVlauePositive) {
            if (!hasVlaueNigative) {
                this.setValue(val);
            } else if (val > 0) {
                this.setValue(val);
            }
            
        }
        
    }
    //it just add consumers and give it the new value
    @Override
    public void addConsumer(PinObserver PinConsumer) {
        Consumers.add(((Pin) PinConsumer));
        ((Pin) PinConsumer).setValue(this.Value);
    }
    //it's delete any pin and check the type of it first and handles the cases of every type
    @Override
    public void delete(PinObserver DeletedPin) {
        int valOfconsumers = Consumers.indexOf(DeletedPin);
        int valOfProvider = Providers.indexOf(DeletedPin);
        int val = 0;
        if (valOfconsumers != -1) {
            Consumers.remove(valOfconsumers);
            
        } else if (valOfProvider != -1) {
            Providers.remove(valOfProvider);
            for(Pin provider : Providers){
                if(provider.getValue()==1){
                    val = 1;
                    break;
                }
                else if(provider.getValue()==-1){
                    val =-1;
                }
            }
            
            this.setValue(val);
        }
    }
    //call all the consumers to tell them i changed
    @Override
    public void notifyConsumers() {
        
        for (Pin consumer : Consumers) {
            consumer.Upadate(((PinObservee) this));
        }
    }
    //update the value and take in consern the positive priority
    @Override
    public void Upadate(PinObservee editedProvider) {
        int val = ((Pin)editedProvider).getValue();
        if(val!=this.Value){
            checkValue(val,false);
        }
    }
    //this will set the value and start the programe like recursion or linked list 
    public void setValue(int val) {
        
        this.Value = val;
        this.notifyConsumers();
    }
    // get the value 
    public int getValue() {
        return this.Value;
    }
    //it's make sure that no consumer was a provider and still like this
    public void clearTheMess() {
        for(Pin consumer : Consumers){
            int pos = Providers.indexOf(consumer);
            if(pos!=-1){
                PinObservee Opin = ((PinObservee)Providers.get(pos));
                Opin.delete(this);
                Providers.remove(pos);
            }
        }
    }
    //give the number of consumer to this object
    public int numOfCon(){
        return Consumers.size();
    }

}
