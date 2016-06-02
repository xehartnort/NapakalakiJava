/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author xehartnort
 */
public class Treasure 
{
    final private String name;
    final private int bonus;
    final private TreasureKind type;
    public Treasure(String n, int bonus, TreasureKind t)
    {
        this.name=n;
        this.bonus=bonus;
        this.type=t;
    }
    
    public String getName()
        { return name; }
    
    public int getBonus()
        { return bonus; }
    
    public TreasureKind getType()
        { return type; }
    
    @Override
    public String toString()
    {
        return "Tesoro: " + name + 
               "\nBonus: " + Integer.toString(bonus) + 
               "\nTreasureKind: " + type;
    }
}
