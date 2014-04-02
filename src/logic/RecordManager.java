/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;
import logs.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import logs.FinalFilter;
import model.*;

public class RecordManager <T extends Model> implements RecordManagerInterface<T>{
    
    Logger logger = Logger.getLogger( RecordManager.class.getName() );
    ArrayList <T> clients = new ArrayList();
    private ArrayList freeId = new ArrayList();
    
    public RecordManager(){
        logger.setFilter(FinalFilter.getInstance());
        logger.addHandler(Handler.getHandler());
    }
    
    @Override
    public void add( T c ){
        if ( freeId.isEmpty() ) {
            c.setId(clients.size()+1);
        }
        else {
            c.setId((int) freeId.get(0));
            freeId.remove(0);
        } 
        clients.add(c);
        logger.log(Level.INFO, "Adding: {0}", c + "\n" + "Table after addition: " + this );
    }
    
    @Override
    public String toString(){
        String allRecords = "\n";
        for ( Iterator i = clients.iterator() ; i.hasNext() ;){
            allRecords = allRecords + i.next() + "\n";
        }
        return allRecords;
    }
    
    @Override
    public boolean contains( T c ){
        System.out.println(clients.contains(c));
        return clients.contains(c);
    }
    
    @Override
    public void delete( int id ){
        for ( int i = 0 ; i < clients.size() ; i ++ ){
            T b = clients.get(i);
            if(b.getId() == id) {
                clients.remove(b);
                freeId.add(id);
                logger.log(Level.INFO, "Removing: {0}", b + "\n" + "Table after removing: " + this );
            }
        }
    }
    
    @Override
    public int size(){
        return clients.size();
    }
    
    @Override
    public ArrayList <T> printAll(){
        logger.log(Level.INFO, "Returning all records" );
        return clients;
    }
    
    @Override
    public T get(int id){
        for ( int i = 0 ; i < clients.size() ; i ++ ){
            T c = clients.get(i);
            if (c.getId() == id)
                return c;
        }
        return null;
    }
}

