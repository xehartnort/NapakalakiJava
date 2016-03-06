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
public class BadConsequence {
    private int levels; /*niveles que quita*/
    private String text;/*representa lo que dice el mal rollo*/
    private int nVisibleTreasures;/*tesoros visibles que se pierden*/
    private int nHiddenTreasures;/*tesoros ocultos que se pierden*/
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    /*Malos rollos que descartan un número de tesoros, indistintamente del tipo*/
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.levels=levels;
        this.text=text;
        this.nHiddenTreasures=nHidden;
        this.nVisibleTreasures=nVisible;
    }
    /* Para malos rollos que implican la muerte*/
    public BadConsequence(String text){
        this.levels=10;
        this.text=text;
        this.nHiddenTreasures=10;
        this.nVisibleTreasures=10;     
    }
    /*Malos rollos que quitan tesoros específicos*/
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
                                                ArrayList<TreasureKind> tHidden){
        this.levels=levels;
        this.text=text;
        this.nHiddenTreasures=0;
        this.nVisibleTreasures=0;
        this.specificHiddenTreasures=tHidden;
        this.specificVisibleTreasures=tVisible;
    }
    public String getText(){ return text; }
    public int getLevels(){ return levels; }
    public int getNHiddenTreasures(){ return nHiddenTreasures; }
    public int getNVisibleTreasures(){ return nVisibleTreasures; }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }

    @Override
    public String toString(){
        String bigText;
        if( levels==10 && nHiddenTreasures==10 && nVisibleTreasures==10){
            bigText="Nivel: "+Integer.toString(levels)+"\n"+
                    "Descripcion: "+text+"\n"+
                    "Mal rollo muerte\n";

        }else{
            if(specificHiddenTreasures.isEmpty() && 
                specificVisibleTreasures.isEmpty() ){
                bigText="Nivel: "+Integer.toString(levels)+"\n"+
                    "Descripcion: "+text+"\n"+
                    "Mal rollo quita número tesoros\n"+
                    "Ocultos: "+Integer.toString(nHiddenTreasures)+"\n"+
                    "Visibles: "+Integer.toString(nVisibleTreasures)+"\n";           
            }else{
                bigText="Nivel: "+Integer.toString(levels)+"\n"+
                    "Descripcion: "+text+"\n"+
                    "Mal rollo quita tesoros especificos\n Ocultos: ";
                for(TreasureKind i : specificHiddenTreasures){
                    bigText+=i+", ";
                }
                bigText+="\n Visibles: ";
                for(TreasureKind i : specificVisibleTreasures){
                    bigText+=i+", ";
                }
            }
            
        }
        return bigText;
    }
}
