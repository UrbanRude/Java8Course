/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

public class Java8 {

    final static String saludation = "Hello! ";
    
    public static void main(String[] args) {
        
        
        Java8 java = new Java8();
        
        MathOperation addition = ( int a, int b ) -> a + b;
        
        MathOperation subtraction = ( a, b ) -> a - b;
        
        MathOperation multiplication = ( int a, int b ) -> { return a*b; };
        
        MathOperation division = ( int a, int b ) -> a/b ;
        
        System.out.println("10 + 5 = " + java.operate( 5, 10, addition ));
        System.out.println("10 - 5 = " + java.operate( 10, 5, subtraction ));
        System.out.println("10 * 5 = " + java.operate( 5, 10, multiplication ));
        System.out.println("10 / 5 = " + java.operate( 10, 5, division ));
        
        GreetingService greetingService = message -> System.out.println("Hello" + message);
        
        greetingService.sayMessage("Urbano");
        greetingService.sayMessage("Ceron");
        
        
        GreetingService greetingService1 = message -> { 
            System.out.println("Mensaje pasado >> "+message);
            System.out.println( saludation + message);
        };
        
        greetingService1.sayMessage("Urban");
         
    }
    
    interface MathOperation{
        int operation( int a, int b );
    }
    
    interface GreetingService{
        void sayMessage(String message);
    }
    
    private int operate( int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    
}
