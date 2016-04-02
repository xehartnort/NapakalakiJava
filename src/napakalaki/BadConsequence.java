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
    final static int MAXTREASURES=10;
    
    /*Malos rollos que descartan un número de tesoros, indistintamente del tipo*/
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.levels=levels;
        this.text=text;
        this.nHiddenTreasures=nHidden;
        this.nVisibleTreasures=nVisible;
    }
    /* Para malos rollos que implican la muerte*/
    public BadConsequence(String text){
        this.levels=Player.MAXLEVEL;
        this.text=text;
        this.nHiddenTreasures=MAXTREASURES;
        this.nVisibleTreasures=MAXTREASURES;     
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
    public void substractVisibleTreasure(Treasure t){}
    public void substractHiddenTreasure(Treasure t){}
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        return this;
    }
    public boolean isEmpty(){
        return  this.nHiddenTreasures+this.nVisibleTreasures == 0 &&
                this.specificHiddenTreasures.isEmpty() &&
                this.specificVisibleTreasures.isEmpty();
    }
    @Override
    public String toString(){
        String bigText;
        if( levels==Player.MAXLEVEL && nHiddenTreasures==MAXTREASURES && nVisibleTreasures==MAXTREASURES){
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
