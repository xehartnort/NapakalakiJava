/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author xehartnort
 */
public class Dice {
    final private static Dice instance = new Dice();
   
    private Dice(){}
    
    public static Dice getInstance(){ return instance; }
    public int nextNumber()
    { 
        return (int) (Math.random()*6+1);
    }
    
}
