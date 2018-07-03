/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.List;

public class Java8 {

    final static String saludation = "Hello! ";
    
    public static void main(String[] args) {
        List namesList = new ArrayList();
        
        namesList.add("Enero");
        namesList.add("Febrero");
        namesList.add("Marzo");
        namesList.add("Abril");
        namesList.add("Mayo");
        namesList.add("Junio");
        
        namesList.forEach(System.out::println);
        
        
    }
       
}
