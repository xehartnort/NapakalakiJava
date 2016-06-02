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
public class CultistPlayer extends Player
{
    private static int totalCultistPlayers=0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c)
    {
        super(p);
        myCultistCard=c;
        totalCultistPlayers++;
    }
    
    public static int getTotalCultistPlayers()
    {
        return totalCultistPlayers;
    }
    
    @Override
    public int getCombatLevel()
    {
        return (int) (1.5 * super.getCombatLevel() + 
                this.myCultistCard.getGainedLevels() * totalCultistPlayers);
    }
    
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    protected boolean shouldConvert()
    {
        return false;
    }
}