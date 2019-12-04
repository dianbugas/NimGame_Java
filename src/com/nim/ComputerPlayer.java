package com.nim;

/*
 * Human and computer has different move()-methods - so they're defined in respective subclass.
 *namely NaiveComputerPlayer and SmartComputerPlayer classes
 *This is an abstract class which cannot be instantiated. Therefore the NaiveComputerPlayer and SmartComputerPlayer class formed
 *a generalization/inhertitance which are both concret classes
 */

abstract class ComputerPlayer {

    private int playerNum;
    private String player_Race;

    public ComputerPlayer(int playerN, String playerRace) {
        setPlayerNum(playerN);
        setPlayerRace(playerRace);
    }

    /*
     * Human and computer has different move-methods - so they're defined in respective subclass.
     */
    public abstract int move(int stonesLeft);

    public int getPlayerNum() {
        return playerNum;
    }

    public String getPlayerRace() {
        return player_Race;
    }

    public void setPlayerRace(String playerRace) {
        player_Race = playerRace;
    }

    public void setPlayerNum(int playerN) {
        playerNum = playerN;
    }

    public String toString() {
        return "Player " + playerNum;
    }
}
