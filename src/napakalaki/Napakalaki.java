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
public class Napakalaki {
    final private static Napakalaki instance = new Napakalaki(); 
    private int currentPlayerIndex;
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer = CardDealer.getInstance();
    
    private Napakalaki(){}
    private void initPlayers(String names){}
    private Player nextPlayer(){ return null; }
    private boolean nextTurnAllowed(){ return true; }
    
    public static Napakalaki getInstance(){ return instance; }
    public CombatResult developCombat(){ return null; }
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){}
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){}
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){}
    public void initGame(ArrayList<String> names){ }
    public Player getCurrentPlayer(){ return null; }
    public Monster getCurrentMonster(){ return null; }
    public boolean nextTurn(){ return true; }
    public boolean endOfGame(CombatResult result){ return true; }
    
}
