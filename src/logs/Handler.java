package logs;

//import static interfaces.Gui.fileTxt;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.File;

public class Handler {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;
    static private Handler myInstance; 
    private static final boolean append = true;
    
    
    private Handler(){
        try {
            File f = new File("log.txt");
            f.delete();
            fileTxt = new FileHandler("log.txt",
                    append);
            formatterTxt = new SimpleFormatter();
            fileTxt.setFormatter(formatterTxt); // formatterTxt
        }
        catch (IOException e){
            
        }
    }
    
    static public FileHandler getHandler(){
        if (myInstance == null ) myInstance = new Handler();
        return fileTxt;
    }
}
