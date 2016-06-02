/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import GUI.NapakalakiView;
import GUI.Dice;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;
/**
 *
 * @author xehartnort
 */
public class Main {
    static private Napakalaki game = Napakalaki.getInstance();
    static private NapakalakiView napakalakiView = new NapakalakiView();
    
    public static void main (String[] args){
        ArrayList<String> names;
        PlayerNamesCapture namesCapture;
        Dice.createInstance(napakalakiView);
        namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        game.initGame(names);
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible (true);
    }
}
