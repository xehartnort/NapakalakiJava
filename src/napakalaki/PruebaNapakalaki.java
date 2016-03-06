/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author xehartnort
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BadConsequence bc2 = new BadConsequence("Hola, soy un unicornio",1,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ARMOR))
            );
        BadConsequence bc1 = new BadConsequence("Hola, me llamo ralph",1,1,1);
        BadConsequence bc = new BadConsequence("Muere");
        Prize premior = new Prize(5,6);
        Monster monstro = new Monster("Monstro",2,bc,premior);
        System.out.println(bc.toString());
        System.out.println(bc1.toString());
        System.out.println(bc2.toString());
        System.out.println(premior.toString());
        System.out.println(monstro.toString());
        
    }
    
}
