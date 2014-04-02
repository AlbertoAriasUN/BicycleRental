/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import logs.Handler;

/**
 *
 * @author maciex
 */
public class Moutain extends Bicycle{
    int numberOfGears;
    
    public Moutain(){
        setWheelSize( 100 );
        setLifeTillService( 2000 );
        setPrice( 30 );
        setNumberOfGears( 5 );
        setRiddenDistance( 0 );
    }
    
    public Moutain( int numberOfGears , int wheelSize_cm  ){
        this();
        if ( wheelSize_cm != 0 )setWheelSize( wheelSize_cm );
        if ( numberOfGears != 0 )setNumberOfGears( numberOfGears );
    }
    
    @Override
    public String[] getAllInfo(){
        String[] info = new String[8];
        info[0] = Integer.toString(getId());
        info[1] = Integer.toString(getWheelSize());
        info[2] = Integer.toString(getLifeTillService());
        info[3] = Integer.toString(getPrice());
        info[4] = Integer.toString(getRiddenDistance());
        if ( checkIfLended() == true ) info[5] = "tak";
        else info[5] = "nie";
        if ( checkIfReserved() == true ) info[6] = "tak";
        else info[6] = "nie";
        info[7] = Integer.toString(getNumberOfGears());
        
        return info;
    }
    
    final protected void setNumberOfGears( int numberOfGears ){
        this.numberOfGears = numberOfGears;
    }
    
    public int getNumberOfGears(){
        return numberOfGears;
    }
    
}
