package logs;
import java.util.logging.*;

public class FinalFilter implements Filter{
    private static boolean loggable;
    private static Filter myInstance;
    
    private FinalFilter(){
        FinalFilter.loggable = false;
    }
    
    @Override
    public boolean isLoggable(LogRecord record) {
        return loggable;
    }

    static public void setLoggable( boolean loggable ){
        FinalFilter.loggable = loggable;
    }
    
    static public Filter getInstance(){
        if (myInstance == null) myInstance = new FinalFilter();
        return myInstance;
    }
}
