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
public class RecordNotFoundException extends Exception{
    String information;
    Logger logger = Logger.getLogger( RecordNotFoundException.class.getName() );
    
    public RecordNotFoundException(){
        logger.setFilter(FinalFilter.getInstance());
        logger.addHandler(Handler.getHandler());
        logger.log(Level.SEVERE, "RecordNotFoundException occured: " + information);
        information = "Nie znaleziono pozycji.";
    }
    @Override
    public String getMessage(){
        return information;
    }
}
