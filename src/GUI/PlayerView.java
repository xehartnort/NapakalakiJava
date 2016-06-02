/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author xehartnort
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;

    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        // Se recorren los tesoros que contiene el panel,
        //almacenando en un vector aquellos que están seleccionados.
        
        // Finalmente se devuelve dicho vector
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
            output.add ( tv.getTreasure() );
        }
        return output;
    }
    
    public PlayerView() {
        initComponents();
    }
    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
    }
    public void setPlayer(Player p){
        playerModel=p;
        this.name.setText("Nombre:"+playerModel.getName());
        this.level.setText("Nivel:"+Integer.toString(playerModel.getLevels()) );
        this.combatLevel.setText("Nivel de combate:"+Integer.toString(playerModel.getCombatLevel()));
        this.dead.setText("Muerto:"+Boolean.toString(playerModel.isDead()));
        if(playerModel instanceof CultistPlayer){
            this.cultist.setText("Cultist: Sí");
        }else
            this.cultist.setText("Cultist: No");
        this.fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        this.bc.setBadConsequence(playerModel.getPendingBadConsequence());
        repaint();
        revalidate();
    }
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua, si la hubiera
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        //al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cultist = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        makeVisible = new javax.swing.JButton();
        discardTreasures = new javax.swing.JButton();
        discardAllTreasures = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        dead = new javax.swing.JLabel();
        bc = new GUI.BadConsequenceView();

        cultist.setText("cultist");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Visible Treasures"));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Hidden Treasures"));

        makeVisible.setText("Make Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasures.setText("Discard Treasures");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        discardAllTreasures.setText("Discard All Treasures");
        discardAllTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasuresActionPerformed(evt);
            }
        });

        name.setText("Nombre:");

        level.setText("Nivel:");

        combatLevel.setText("Nivel de combate:");

        dead.setText("Muerto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(discardAllTreasures))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cultist)
                            .addComponent(name)
                            .addComponent(level)
                            .addComponent(combatLevel)
                            .addComponent(dead)
                            .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bc, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addGap(24, 24, 24)
                        .addComponent(level)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combatLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cultist))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeVisible)
                    .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discardAllTreasures)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        napakalakiModel.makeTreasuresVisible (selHidden);
        this.setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void discardAllTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasuresActionPerformed
        playerModel.discardAllTreasures ();
        this.setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardAllTreasuresActionPerformed

    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures (visibleTreasures);
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        this.setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardTreasuresActionPerformed

    public void setBotones(boolean makeVisible, boolean discard, boolean discardAll){
        this.makeVisible.setEnabled(makeVisible);
        this.discardTreasures.setEnabled(discard);
        this.discardAllTreasures.setEnabled(discardAll);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BadConsequenceView bc;
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel cultist;
    private javax.swing.JLabel dead;
    private javax.swing.JButton discardAllTreasures;
    private javax.swing.JButton discardTreasures;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
