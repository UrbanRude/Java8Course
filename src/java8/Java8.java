/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.io.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8{
 
    public static void main(String[] args) {      
        
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        
        List<String> filtered = strings
                                .stream()
                                .filter( string -> !string.isEmpty() )
                                .collect(Collectors.toList());
        
        for (String string : filtered) {
            System.out.println(string);
        }
        
        System.out.println("#############################################");
        
        Random ramdom = new Random();
        ramdom.ints()
              .limit(10)
              .forEach(System.out::println);
              
        System.out.println("#############################################");

        List<Integer> numbers = Arrays.asList(2,3,6,12,233,1,4,2);
        List<Integer> squaresList = numbers.stream()
                                           .map( n -> n * n )
                                           .distinct()
                                           .collect(Collectors.toList());
        for(Integer item : squaresList){
            System.out.print(" | "+item+" | ");
        }
        System.out.println("");
        
        System.out.println("#############################################");

        int count = (int) strings.stream()
                                 .filter( string -> string.isEmpty())
                                 .count();
        System.out.println("Strings emptys " + count);

        System.out.println("#############################################");

        ramdom.ints().limit(10).sorted().forEach(System.out::println);
        
        int countII = (int) strings.parallelStream().filter( string -> string.isEmpty()).count();
        System.out.println("Strings emptys "+countII);
        
        System.out.println("#############################################");
        
        System.out.println("Filtered List: "+filtered);
        String mergeString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: "+mergeString);

        System.out.println("#############################################");
        
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
        
        
    }
}


