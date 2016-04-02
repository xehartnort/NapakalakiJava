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
public class Player {
    final static int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead=true;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){ this.name = name; }
    public String getName(){ return name; }
    public boolean isDead(){ return dead; } // repasar
    
    public ArrayList<Treasure> getVisibleTreasures(){ return null; }
    public ArrayList<Treasure> getHiddenTreasures(){ return null; }
    public CombatResult combat(Monster m){ return null; }
    public void makeTreasureVisible(Treasure t){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
    public boolean validState(){ 
        return this.pendingBadConsequence.isEmpty() && 
                this.hiddenTreasures.size()<=4;
    }
    public void initTreasures(){}
    public int getLevels(){ 
        int lvl = level;
        for(Treasure i : visibleTreasures){
            lvl+= i.getBonus();
        }
        return lvl; 
    }
    public void discardAllTreasures(){ }
    
    private void bringToLife(){
        dead=false;
    }
    private int getCombatLevel(){ return level; }
    private void incrementLevels(int l){ level += l; }
    private void decrementLevels(int l){ 
        if (l>level)
            level=1;
        else    
            level -= l; 
    }
    private void setPendingBadConsequence( BadConsequence b){
        this.pendingBadConsequence=b;
    }
    private void applyPrize(Monster m){}
    private void applyBadConsequence(Monster m){}
    private boolean canMakeTreasureVisible(){ return true; }
    private int howManyVisibleTreasures(TreasureKind tKind){ 
        int count=0;
        for(Treasure i: visibleTreasures){
            if( i.getType()== tKind )
                count++;
        }
        return count;
    }
    private void dieIfNoTreasures(){
        if( this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty() ){
            dead=true;
            level=1;
        }
    }
    
    
}
