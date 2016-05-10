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
    final CardDealer dealer = CardDealer.getInstance();
    final static int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead=true;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name)
        { this.name = name; }
    
    public Player(Player p)
    {
        this.dead = p.dead;
        this.level = p.level;
        this.hiddenTreasures = p.hiddenTreasures; //habría que ver si este nivel de copiado es suficiente
        this.visibleTreasures = p.visibleTreasures; //habría que ver si este nivel de copiado es suficiente
        this.name = p.name;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
    public String getName()
        { return name; }
    
    public int getLevels()
        { return level; }
    
    public boolean isDead()
        { return dead; }
    
    public ArrayList<Treasure> getVisibleTreasures()
        { return visibleTreasures; }
    
    public ArrayList<Treasure> getHiddenTreasures()
        { return hiddenTreasures; }
    
    public CombatResult combat(Monster m)
    {
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        CombatResult resultado;
        if( myLevel > monsterLevel)
        {
            applyPrize(m);
            if(level >= MAXLEVEL)
                resultado = CombatResult.WINGAME;
            else
                resultado = CombatResult.WIN;
        }
        else
        {
            applyBadConsequence(m);
            if(shouldConvert())
                resultado = CombatResult.LOSEANDCONVERT;
            else
                resultado = CombatResult.LOSE;
        }
        return resultado;
    }
    
    public void makeTreasureVisible(Treasure t)
    {
        boolean canI = canMakeTreasureVisible(t);
        if(canI)
        {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t)
    {
        visibleTreasures.remove(t);
        dealer.giveTreasureBack(t);
        if( this.pendingBadConsequence != null && 
                !this.pendingBadConsequence.isEmpty())
            this.pendingBadConsequence.substractVisibleTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t)
    {
        hiddenTreasures.remove(t);
        dealer.giveTreasureBack(t);
        if( this.pendingBadConsequence != null && 
                !this.pendingBadConsequence.isEmpty())
            this.pendingBadConsequence.substractHiddenTreasure(t);
        this.dieIfNoTreasures();
    }
    public boolean validState()
    { 
        return this.pendingBadConsequence.isEmpty() && 
                this.hiddenTreasures.size()<=4;
    }
    public void initTreasures()
    {
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        this.hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        if(number>1)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number==6)
        {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }

    public void discardAllTreasures()
    {
        ArrayList<Treasure> clon1 = (ArrayList<Treasure>)visibleTreasures.clone();
        ArrayList<Treasure> clon2 = (ArrayList<Treasure>)hiddenTreasures.clone();
        for(Treasure t : clon1 )
        {
            this.discardVisibleTreasure(t);
        }
        for(Treasure t : clon2 )
        {
            this.discardHiddenTreasure(t);
        }
    }
    
    @Override
    public String toString()
    {
        String textoInicial = "\n\tName = " + name + 
                " \n\tLevel = " + Integer.toString(level) + 
                " \n\tPendingBadConsequence: { " + pendingBadConsequence.toString() +
                "\n\t} \n\tDead = " + Boolean.toString(dead);
        String textoHiddenTreasures = " \n\tArray Hidden Treasures: { ";
        String textoVisibleTreasures = " \n\tArray Visible Treasures: { ";
        if(!visibleTreasures.isEmpty())
        {
            for (Treasure t : visibleTreasures)
                textoVisibleTreasures += (t.toString() + " ");
        }
        else
        {
            textoVisibleTreasures += "No tiene ningún tesoro visible. ";
        }
        
        if(!hiddenTreasures.isEmpty())
        {
            for (Treasure t : hiddenTreasures)
                textoHiddenTreasures += (t.toString() + " ");
        }
        else
        {
            textoHiddenTreasures += "No tiene ningún tesoro oculto. ";
        }
        return textoInicial + textoHiddenTreasures + "}" + textoVisibleTreasures + "}";
    }
    
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert()
    {
        return (Dice.getInstance().nextNumber()==6);
    }
    
    protected int getCombatLevel()
    {
        int lvl = level;
        for(Treasure i : visibleTreasures)
        {
            lvl+= i.getBonus();
        }
        return lvl; 
    }
    
    private void bringToLife()
    { 
        dead=false; 
    }
    
    private void incrementLevels(int l)
    { 
        level += l; 
    }
    
    private void decrementLevels(int l)
    { 
        if(l>level)
            level=1;
        else    
            level -= l; 
    }
    
    private void setPendingBadConsequence( BadConsequence b)
    { 
        this.pendingBadConsequence=b; 
    }
    
    private void applyPrize(Monster m)
    {
        Treasure treasure;
        int nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures > 0){
            for(int i=0; i<nTreasures;i++)
            {
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }   
        }
    }
    
    private void applyBadConsequence(Monster m)
    {
        BadConsequence bad = m.getBadConsequence();
        int nLevels = bad.levels;
        this.decrementLevels(nLevels);
        BadConsequence pendingbad = bad.adjustToFitTreasureLists(visibleTreasures, 
                                                hiddenTreasures);
        this.setPendingBadConsequence(pendingbad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t)
    { 
        visibleTreasures.add(t);
        boolean canI = true;// debe de ser inicialmente verdadero
        boolean [] valido = new boolean[6];
        for (int j=0;j<6;j++)
                valido[j]=false;
        
        for(Treasure i : visibleTreasures)
        {
            switch (i.getType()) {
                case ARMOR:
                    if(valido[0])
                        canI = false;
                    else
                        valido[0]=true;
                    break;
                case BOTHHANDS:
                    if(valido[3]||valido[4])
                        canI = false;
                    else
                    {
                        valido[3]=true;
                        valido[4]=true;
                    }   
                    break;
                case HELMET:
                    if(valido[1])
                        canI = false;
                    else
                        valido[1]=true;
                    break;
                case ONEHAND:
                    if(valido[3])
                        if(valido[4])
                            canI=false;
                        else
                            valido[4]=true;
                    else
                        valido[3]=true;
                    break;
                default:
                    if(valido[2])
                        canI = false;
                    else
                        valido[2]=true;
                    break;
            }
        }
        visibleTreasures.remove(t);
        return canI;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind)
    { 
        int count=0;
        for(Treasure i: visibleTreasures){
            if( i.getType()== tKind )
                count++;
        }
        return count;
    }
    private void dieIfNoTreasures()
    {
        if( this.hiddenTreasures.isEmpty() && 
                this.visibleTreasures.isEmpty() ){
            dead=true;
            level=1;
        }
    }
    
}
