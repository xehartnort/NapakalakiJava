/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author xehartnort
 */
public class Dice {
    final private static Dice instance = null;
   
    private Dice(){}
    
    public static Dice getInstance(){ return instance; }
    public int nextNumber()
    { 
        Random ran = new Random();
        return ran.nextInt(6)+1;
    }
    
}
