/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Java8{
 
    public static void main(String[] args) {
    	
    	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    	ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
    	
    	String name = "Urbano";
       	Integer result = null;
       	
       	try {
			nashorn.eval("print('"+name+"')");
			result = (Integer) nashorn.eval("10 + 2");
		} catch (ScriptException e) {
			System.out.println("Error executing script: "+e.getMessage());
		}
       	
       	System.out.println( result.toString() );
    	
    	
        
    }
        
    
    
    
}


