/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author xehartnort
 */
public class DeathBadConsequence extends NumericBadConsequence
{
    public DeathBadConsequence(String text){
        super(text, 0, BadConsequence.getMAXtreasures(), 
        BadConsequence.getMAXtreasures());
    }
            
    @Override
    public String toString()
    {
        return  textoIntroduccion + "\n\tText = " + text;
    }
    
}
