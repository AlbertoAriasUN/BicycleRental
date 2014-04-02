/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;

import logs.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import logs.FinalFilter;

/**
 *
 * @author maciex
 */
public class ReservationDateError extends Exception{
    String information;
    Logger logger = Logger.getLogger( ReservationDateError.class.getName() );
    
    public ReservationDateError( int i ){
        logger.setFilter(FinalFilter.getInstance());
        logger.addHandler(Handler.getHandler());
        switch(i){
            case 1:
                information = "Błąd składni.";
                logger.log(Level.SEVERE, "DateSyntaxException occured: " + information);
                break;
            case 2:
                information = "Początek przed końcem.";
                logger.log(Level.SEVERE, "DateOrderException occured: " + information);
                break;
            case 3:
                information = "Rower zajęty w tym terminie.";
                logger.log(Level.SEVERE, "BikeNotAvailableException occured: " + information);
                break;
        }
        
    }
    @Override
    public String getMessage(){
        return information;
    }
}
