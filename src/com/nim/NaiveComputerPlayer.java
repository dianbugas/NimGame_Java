package com.nim;

import javax.swing.JOptionPane;
import java.util.Random;
class NaiveComputerPlayer extends ComputerPlayer {

    // use superclass constructor
    public NaiveComputerPlayer(int player, String playerRace) {
        super(player, playerRace);
    }

    /*
     * Computer player randomly takes a legal amount of stones.
     */
    public int move(int firstPileDeduction) {
        Random myRandom = new Random();
        int nPile = myRandom.nextInt(firstPileDeduction / 2) + 1;
        try {
            Thread.sleep(2000L); // pause so player can see what computer does
        }
        catch (Exception e) {}
        JOptionPane.showMessageDialog(null,this + " takes " + nPile + " stone(s).");
        return nPile;
    }
}