/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.util.ArrayList;
import model.Model;

/**
 *
 * @author maciex
 */
public interface RecordManagerInterface < T extends Model > {
    
    public void add( T c );
    
    public boolean contains( T c );
    
    public void delete( int id );
    
    public int size();
    
    public ArrayList <T> printAll();
    
    public T get(int id);
    
}
