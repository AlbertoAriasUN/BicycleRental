/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logs;

import java.util.logging.Logger;

/**
 *
 * @author maciex
 */
public class FinalLogger {
    private static Logger logger = Logger.getLogger( FinalLogger.class.getName() );
    
    public static Logger getInstance(){
        if (logger == null) new FinalLogger();
        return logger;
    }
    
}
