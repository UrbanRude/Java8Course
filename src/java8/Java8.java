/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.io.Console;
import java.util.ArrayList;
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
    
     private static int getCountEmptyStringUsingJava7(List<String> strings) {
      int count = 0;

        for(String string: strings) {

           if(string.isEmpty()) {
              count++;
           }
        }
        return count;
     }

     private static int getCountLength3UsingJava7(List<String> strings) {
        int count = 0;

        for(String string: strings) {

           if(string.length() == 3) {
              count++;
           }
        }
        return count;
     }

     private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
        List<String> filteredList = new ArrayList<String>();

        for(String string: strings) {

           if(!string.isEmpty()) {
               filteredList.add(string);
           }
        }
        return filteredList;
     }

     private static String getMergedStringUsingJava7(List<String> strings, String separator) {
        StringBuilder stringBuilder = new StringBuilder();

        for(String string: strings) {

           if(!string.isEmpty()) {
              stringBuilder.append(string);
              stringBuilder.append(separator);
           }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-2);
     }

     private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squaresList = new ArrayList<Integer>();

        for(Integer number: numbers) {
           Integer square = new Integer(number.intValue() * number.intValue());

           if(!squaresList.contains(square)) {
              squaresList.add(square);
           }
        }
        return squaresList;
     }

     private static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);

        for(int i = 1;i < numbers.size();i++) {

           Integer number = numbers.get(i);

           if(number.intValue() > max) {
              max = number.intValue();
           }
        }
        return max;
     }

     private static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);

        for(int i= 1;i < numbers.size();i++) {
           Integer number = numbers.get(i);

           if(number.intValue() < min) {
              min = number.intValue();
           }
        }
        return min;
     }

     private static int getSum(List numbers) {
        int sum = (int)(numbers.get(0));

        for(int i = 1;i < numbers.size();i++) {
           sum += (int)numbers.get(i);
        }
        return sum;
     }

     private static int getAverage(List<Integer> numbers) {
        return getSum(numbers) / numbers.size();
     }
}


