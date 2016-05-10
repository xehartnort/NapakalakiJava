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
    private int levelChangeAgainstCultistPlayer;
    private Prize prize;
    private BadConsequence bc;
    
    public Monster(String name, int level, 
                    BadConsequence bc, 
                    Prize prize)
    {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer=0;
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize prize, int lC)
    {
        this.name=name;
        this.combatLevel=level;
        this.bc=bc;
        this.prize=prize;
        this.levelChangeAgainstCultistPlayer = lC;
    }
    
    public String getName()
        { return name; }
    
    public int getCombatLevel()
        { return combatLevel; }
    
    public BadConsequence getBadConsequence()
        { return bc; }
    
    public Prize getPrize()
        { return prize; }
    
    public int getLevelsGained()
        { return prize.getLevels(); }
    
    public int getTreasuresGained()
        { return prize.getTreasures(); }
    
    public int getCombatLevelAgainstCultistPlayer()
    {
        return this.levelChangeAgainstCultistPlayer;
    }
    @Override
    public String toString()
    {
        return "Nombre: "+name+"\n"+
                "Nivel de combate: "+Integer.toString(combatLevel)+"\n"+
                "Nivel de combarte contra cultist: "+Integer.toString(this.levelChangeAgainstCultistPlayer)+
                "Buen rollo: " + prize.toString()+"\n"+
                "Mal rollo: " + bc.toString()+"\n";
    }

    
}
