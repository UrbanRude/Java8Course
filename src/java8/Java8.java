/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Optional;

public class Java8{
 
    public static void main(String[] args) {      
        
    	Java8 java8 = new Java8();
    	
    	Integer val1 = null;
    	Integer val2 = new Integer(10);
    	
    	Optional<Integer> a = Optional.ofNullable(val1);
    	Optional<Integer> b = Optional.of(val2);
    	    	
    	System.out.println(java8.sum(a, b));
        
    }
    
    public Integer sum( Optional<Integer> a, Optional<Integer> b ) {
    	
    	System.out.println("Frist parameter is present >> " + a.isPresent());
    	System.out.println("Second parameter is present >> " + b.isPresent());
    	
    	Integer value1 = a.orElse(new Integer(0));
    	
    	Integer value2 = b.get();
    	
    	return value1 + value2;
    	
    } 
    
    
}


