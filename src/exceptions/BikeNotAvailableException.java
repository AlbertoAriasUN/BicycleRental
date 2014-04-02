/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;

/**
 *
 * @author maciex
 */
public class BikeNotAvailableException extends Exception{
    String information;
    public BikeNotAvailableException(){
        information = "Rower nie jest dostępny.";
    }
    @Override
    public String getMessage(){
        return information;
    }
}
