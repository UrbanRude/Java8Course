/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;


/**
 *
 * @author JAVA1
 */
public class Car implements Vehicle,FourWheeler{
 
   public void print(){
       Vehicle.super.print();
       FourWheeler.super.print();
       Vehicle.blowHorn();
       System.out.println("I am a car!");
   }
       
}

