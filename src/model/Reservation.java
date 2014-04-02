package model;
import logs.Handler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logs.FinalFilter;

public class Reservation extends Model{
    static final Logger logger = Logger.getLogger( Client.class.getName() );
    private Date reservationBeginsDate;
    private Date reservationTerminatesDate;
    private int bid; // Bicycle identificator
    private int cid; // Client identyficator
    private int cost_zl;
    private Bicycle b;
    private Client c;
    private State currentState;
    
    enum State{ ZAREZERWOWANO, ANULOWANO, NIEPOTWIERDZONO, POTWIERDZONO, WREALIZACJI, ZAKONCZONA };

    public String getState() {
        switch(currentState){
            case ZAREZERWOWANO:
                return "Zarezerwowano";
            case ANULOWANO:
                return "Anulowano";
            case NIEPOTWIERDZONO:
                return "Nieodebrano";
            case POTWIERDZONO:
                return "Potwierdzono";
            case WREALIZACJI:
                return "W realizacji";
            case ZAKONCZONA:
                return "Zakończono";
            default:
                return null;
        }
    }
    
    @Override
    public String toString(){
        return "Bicycle ID: " + bid + " -> Client ID: " + cid;
    }
    
    private void setState(State state){
        currentState = state;
    }
    
    public void annualReservation(){
        setState(State.ANULOWANO);
        b.setRid(-1);
    }
    
    public void confirmReservation(){
        setState(State.POTWIERDZONO);
    }
    
    private void realizeReservation(){
        setState(State.WREALIZACJI);
    }
    
    public void updateStatus(){
        Date date = new Date();
        long dateLong = date.getTime();
        if ( getState() != "Anulowano" && getState() != "Zakończono"){
            if ( dateLong > getReservationBeginsDate().getTime() && getState() != "W realizacji"){
                if ( dateLong < getReservationTerminatesDate().getTime() ){
                    if (getState() == "Potwierdzono") setState(State.WREALIZACJI);
                    else setState(State.NIEPOTWIERDZONO);
                }
                else {
                    if (getState() == "W realizacji") setState(State.ZAKONCZONA);
                    else setState(State.ANULOWANO);
                    b.setRid(-1);
                }
            }
        }
    }
    
    public Reservation( Bicycle b , Client c , Date reservationBeginsDate , Date reservationTerminatesDate ){
        //logger.setFilter(FinalFilter.getInstance());
        //logger.addHandler(Handler.getHandler());
        setState(State.ZAREZERWOWANO);
        this.b = b;
        this.c = c;
        this.bid = b.getId();
        this.cid = c.getId();
        this.reservationBeginsDate = reservationBeginsDate;
        this.reservationTerminatesDate = reservationTerminatesDate;
        this.cost_zl = calculateCost(b.getPrice());
        b.isReserved(true);
        b.setRid(getId());
        logger.log(Level.INFO, "Creating reservation: {0}", " Bicycle ID: " + bid + " -> Client ID: " + cid);
    }
    
    public String[] getAllInfo(){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String[] info = new String[7];
        info[0] = Integer.toString(getId());
        info[1] = format.format(reservationBeginsDate).toString();
        info[2] = format.format(reservationTerminatesDate).toString();
        info[3] = Integer.toString(bid);
        info[4] = Integer.toString(cid);
        info[5] = Integer.toString(cost_zl);
        info[6] = getState();
        return info;
    }
    
    public void deleteReservation(int distance){
        b.isReserved(false);
        b.setRiddenDistance(distance);
        
    }
    
    private int calculateCost( int pricePerDay_zl ){
        long diff = reservationTerminatesDate.getTime() - reservationBeginsDate.getTime();
        int diffDays = (int)(diff / (60 * 60 * 1000 * 24));
        return pricePerDay_zl * diffDays;
    }
    
    private int getBid(){
        return bid;
    }
    
    private Bicycle getB(){
        return b;
    }
    
    private int getCid(){
        return cid;
    }
    
    public void bindWithBicycle(int rid){
        b.setRid(rid);
    }
    
    public Date getReservationBeginsDate(){
        return reservationBeginsDate;
    }
    
    public Date getReservationTerminatesDate(){
        return reservationTerminatesDate;
    }
}
