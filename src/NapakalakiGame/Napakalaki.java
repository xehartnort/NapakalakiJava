/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

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
    private CardDealer dealer= CardDealer.getInstance();
    
    private Napakalaki()
    {
        players = new ArrayList<>();
        currentPlayerIndex = -1;
    }
    
    private void initPlayers(ArrayList<String> names)
    {
        for(String n : names)
            players.add(new Player(n));
    }
    
    private Player nextPlayer()
    {
        if(currentPlayerIndex == -1) // Si es el primer turno
            currentPlayerIndex = Dice.getInstance().nextNumber() % players.size();
        else
        {
            currentPlayerIndex++;                   
            currentPlayerIndex %= players.size(); // De esta maneta se controla 
        }                                         // que no se salga del vector
        return players.get(currentPlayerIndex);
    }
    
    private boolean nextTurnAllowed()
    {
        boolean turno; 
        if(currentPlayer == null) // Primera jugada
            turno = true;
        else
            turno = currentPlayer.validState();
        return turno;
    }
    
    public static Napakalaki getInstance()
    { 
        return instance; 
    }
    
    public CombatResult developCombat()
    {
        CombatResult resultado = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if(resultado == CombatResult.LOSEANDCONVERT )
        {
            Player jugador = new CultistPlayer(currentPlayer, dealer.nextCultist());
            currentPlayer=jugador;
            players.set(currentPlayerIndex, jugador);
        }
        return resultado;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures)
    {
        for(Treasure t : treasures)
        {
           currentPlayer.discardVisibleTreasure(t);
        }
    }

    public void discardHiddenTreasures(ArrayList<Treasure> treasures)
    {
        for(Treasure t : treasures)
        {
           currentPlayer.discardHiddenTreasure(t);
        }
    }

    public void makeTreasuresVisible(ArrayList<Treasure> treasures)
    {
        for(Treasure t : treasures)
        {
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(ArrayList<String> names)
    { 
        initPlayers(names);
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){ return currentPlayer; }
    
    public Monster getCurrentMonster(){ return currentMonster; }
    
    public boolean nextTurn()
    {
        boolean stateOK = nextTurnAllowed();
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            if( currentPlayer.isDead() )
                currentPlayer.initTreasures();
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result)
    {
        return result == CombatResult.WINGAME;       
    }
    
}
