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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name=name;
        this.combatLevel=level;
        this.bc=bc;
        this.prize=prize;
    }
    public String getName(){ return name; }
    public int getCombatLevel(){ return combatLevel; }
    public BadConsequence getBadConsequence(){ return bc; }
    public Prize getPrize(){ return prize; }
    public int getLevelsGained(){
        return prize.getLevels();
    }
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    @Override
    public String toString(){
        return "Nombre: "+name+"\n"+
                "Nivel de combate: "+Integer.toString(combatLevel)+"\n"+
                "Buen rollo: " + prize.toString()+"\n"+
                "Mal rollo: " + bc.toString()+"\n";
    }

    
}
