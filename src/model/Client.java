package model;
import logs.Handler;
import java.io.IOException;
import java.util.Comparator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import logs.FinalFilter;
import logs.FinalLogger;


public class Client extends Model implements  Comparable<Client>{
    
    static final Logger logger = Logger.getLogger( Client.class.getName() );
    
    private String name;
    private String surname;
    private String phoneNumber;
    private String eMail;
    
    private boolean hasReserved = false;
    private boolean hasBorrowed = false;
    
    public Client (){
        this("name","surname","phone","email");
    }
    
    public Client( String name, String surname, String phoneNumber, String eMail ){
        logger.setFilter(FinalFilter.getInstance());
        logger.addHandler(Handler.getHandler());
        logger.log(Level.INFO, "Creating client: {0}", name);
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }
    
    @Override
    public int compareTo(Client c){
        int compare = surname.compareTo(c.surname);
        return compare;
    }
    
    public void hasReserved( boolean hasReserved ){
        this.hasReserved = hasReserved;
    }
    
    public void hasBorrowed( boolean hasBorrowed ){
        this.hasBorrowed = hasBorrowed;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Client other = (Client) obj;
        
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        
        if (this.surname != other.surname) {
            return false;
        }
        
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        
        if (this.eMail != other.eMail) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return name + " " + surname + " " + phoneNumber + " " + eMail + ";";
    }
    
    @Override
    public int hashCode(){
        int code = 0;
        for (int i = 0 ; i < name.length() ; i ++){
            code = code + (int)name.charAt(i);
        }
        for (int i = 0 ; i < surname.length() ; i ++){
            code = code + (int)surname.charAt(i);
        }
        for (int i = 0 ; i < phoneNumber.length() ; i ++){
            code = code + (int)phoneNumber.charAt(i);
        }
        for (int i = 0 ; i < eMail.length() ; i ++){
            code = code + (int)eMail.charAt(i);
        }
        System.out.println(code);
        return code;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getEMail(){
        return eMail;
    }
}
