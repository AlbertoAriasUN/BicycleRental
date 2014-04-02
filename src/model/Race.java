package model;
import exceptions.*;
import logs.Handler;

public class Race extends Moutain{
    private String type;
    
    private Race(){
        setWheelSize( 100 );
        setLifeTillService( 1000 );
        setPrice( 50 );
        setNumberOfGears( 5 );
        setRiddenDistance( 0 );
    }
    
    public Race( String type , int numberOfGears , int wheelSize_cm ) throws MustHaveTypeException{
        this();
        if ( wheelSize_cm != 0 )setWheelSize( wheelSize_cm );
        if ( numberOfGears != 0 )setNumberOfGears( numberOfGears );
        if ( type != null )setType( type );
        else throw new MustHaveTypeException();
    }
    
    @Override
    public String[] getAllInfo(){
        String[] info = new String[9];
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
        info[8] = getType();
        return info;
    }
    
    final public void setType( String type ){
        this.type = type;
    }
    
    public String getType(){
        return type;
    }
}
