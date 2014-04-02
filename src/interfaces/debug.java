/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import logic.*;
import model.*;
/**
 *
 * @author maciex
 */
public class debug {
    public static void main(String[] args){
        Bicycle b = new Bicycle();
        Client c = new Client();
        String s1 = "20.11.14 20:12";
        String s2 = "21.11.14 21:39";
        Date d1 = stringToDate(s1);
        Date d2 = stringToDate(s2);
        Reservation r = new Reservation(b,c,d1,d2);
        //System.out.println(r.getState());
        
        
        Client c2 = new Client("a","b","c","d");
        System.out.println(c2.equals(c));
        Client c3 = new Client("a","b","c","d");
        System.out.println(c2.equals(c3));
        Client c4 = new Client("a","d","d","d");
        
        RecordManager<Client> clients = new RecordManager<>();
        clients.add(c);
        clients.add(c2);
        clients.add(c3);
        System.out.println(clients);
        
        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(clients.contains(c2));
    }
    
    private static Date stringToDate( String date ){
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm");  

            Date d = null;

            try {
                d = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return d;
        }
}

