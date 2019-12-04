package com.nim;

import javax.swing.JOptionPane;
/*
 * SmartComputerPlayer is subclass of ComputerPlayer class.
 */
class SmartComputerPlayer extends ComputerPlayer {

    // use superclass constructor
    public SmartComputerPlayer(int playerN, String playerRace) {
        super(playerN, playerRace);
    }

    /*
     * Player is forced to take a legal amount of stones.
     */
    public int move(int firstPileDeduction) {

        while (firstPileDeduction < 1
                || firstPileDeduction > (2)) {
            JOptionPane.showMessageDialog(null,"Illegal move! - please try again!");

        }

        return firstPileDeduction;
    }
}