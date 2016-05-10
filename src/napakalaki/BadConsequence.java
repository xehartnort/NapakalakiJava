/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author xehartnort
 */
public abstract class BadConsequence 
{
    protected int levels; // Todos tienen niveles
    protected final String text;// Todos tienen nombre
    protected final String textoIntroduccion;// Todos tienen nombre
    final static int MAXTREASURES=10;
    
    final static int getMAXtreasures(){ return MAXTREASURES; }
            
    public BadConsequence(String text, int levels){
        this.textoIntroduccion =  "\n\tEsto es un mal rollo con el siguiente contenido: ";
        this.levels=levels;
        this.text=text;
    }

    public String getText()
        { return text; }
    
    public int getLevels()
        { return levels; }
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, 
                                                            ArrayList<Treasure> h);
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract boolean isEmpty();

    @Override
    public abstract String toString();
    
}
