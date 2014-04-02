package exceptions;

import logs.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import logs.FinalFilter;

public class MustHaveTypeException extends Exception{
    String information;
    Logger logger = Logger.getLogger( MustHaveTypeException.class.getName() );
    
    public MustHaveTypeException(){
        logger.setFilter(FinalFilter.getInstance());
        logger.addHandler(Handler.getHandler());
        logger.log(Level.SEVERE, "MustHaveTypeException occured: " + information);
        information = "Musisz zdefiniować typ roweru wyczynowego.";
    }
    @Override
    public String getMessage(){
        return information;
    }
}
