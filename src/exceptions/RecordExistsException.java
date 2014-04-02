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
public class RecordExistsException extends Exception{
    Logger logger = Logger.getLogger( RecordExistsException.class.getName() );
    String information;
    public RecordExistsException(){
        logger.setFilter(FinalFilter.getInstance());
        logger.addHandler(Handler.getHandler());
        logger.log(Level.SEVERE, "RecordExistsException occured: " + information);
        information = "Już istnieje ta pozycja.";
    }
    @Override
    public String getMessage(){
        return information;
    }
}
