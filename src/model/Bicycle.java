package model;
import logs.Handler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bicycle extends Model implements Comparable<Bicycle>{

    static final Logger logger = Logger.getLogger( Client.class.getName() );
    
    private ArrayList <Integer> ridList;
    private int wheelSize_cm;
    private int lifeTillService_km;
    private int pricePerDay_zl;
    private int riddenDistance_km;
    private boolean isLended = false;
    private boolean isReserved = false;
    
    public Bicycle(){
        logger.log(Level.INFO, "Creating bicycle");
        ridList = new ArrayList<>();
        setRid(-1);
        setWheelSize( 100 );
        setLifeTillService( 5000 );
        setPrice( 20 );
        setRiddenDistance( 0 );
    }
    
    public Bicycle( int wheelSize_cm ){
        this();
        if ( wheelSize_cm != 0 ) setWheelSize( wheelSize_cm );
    }
    
    @Override
    public int compareTo(Bicycle b){
        if ( lifeTillService_km > b.getLifeTillService() ){
            return 1;
            }
        else {
            if ( lifeTillService_km < b.getLifeTillService() ) return -1;
            else return 0;
           }
    }
    
    
    
    public int getWheelSize(){
        return wheelSize_cm;
    }
    
    public int getLifeTillService(){
        return lifeTillService_km;
    }
    
    public int getPrice(){
        return pricePerDay_zl;
    }
    
    public boolean checkIfLended(){
        return isLended;
    }
    
    public boolean checkIfReserved(){
        return isReserved;
    }
    
    public int getRiddenDistance(){
        return riddenDistance_km;
    }
    
    public String[] getAllInfo(){
        String[] info = new String[7];
        info[0] = Integer.toString(getId());
        info[1] = Integer.toString(getWheelSize());
        info[2] = Integer.toString(getLifeTillService());
        info[3] = Integer.toString(getPrice());
        info[4] = Integer.toString(getRiddenDistance());
        if ( checkIfLended() == true ) info[5] = "tak";
        else info[5] = "nie";
        if ( checkIfReserved() == true ) info[6] = "tak";
        else info[6] = "nie";
        
        return info;
    }

    final public void setRiddenDistance( int riddenDistance_km ){
        this.riddenDistance_km = riddenDistance_km;
        this.lifeTillService_km = this.lifeTillService_km - riddenDistance_km;
    }
    
    final public void setWheelSize( int wheelSize_cm ){
        this.wheelSize_cm = wheelSize_cm;
    }
   
    final protected void setLifeTillService( int lifeTillService_km ){
        this.lifeTillService_km = lifeTillService_km;
    }
    
    final public void setPrice( int pricePerDay_zl){
        this.pricePerDay_zl = pricePerDay_zl;
    }
    
    final public void isLended(boolean lended){
        isLended = lended;
    }
    
    final public void isReserved(boolean reseved){
        isReserved = reseved;
    }
    
    final public void setRid( int rid ){
        this.ridList.add(rid);
    }
    
    final public ArrayList getRid(){
        return ridList;
    }
}
