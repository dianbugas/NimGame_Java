package com.nim;

import javax.swing.JOptionPane;
import java.util.Random;
/*
 * This class allows Player to choose selection.
 *This is also the logic class that basically setup the engine of the game
 */
public class GameLogic {

    //defining three sets of piles
    private int pile_1,pile_2,pile_3;
    //defining and initializing Random stones generater
    private int stones = 100;

    private String playerSelection;
    GetPlayer selectPlayer = new GetPlayer();
    /*
     * Player chooses selection.
     */
    public GameLogic() {
        // GetPlayer selectPlayer = new GetPlayer();

        int selection = selectPlayer. GetPlayerInput();

        if(selection == 0 ){
            JOptionPane.showMessageDialog(null, "Human Turn");
            playerSelection = "Human";

        }
        else{
            JOptionPane.showMessageDialog(null, "Computer Turn");
            playerSelection = "Computer";

        }

    }

    public String getPlayerSelection(){
        return playerSelection;
    }

    //Method to generate the Random piles of three stones
    public int generatePiles(){
        Random randPile = new Random();
        int pile = randPile.nextInt(stones)+1;
        return pile;
    }
    //this method return the first pile to the GUI
    public int generateFirstPile(){
        pile_1 = generatePiles();
        return pile_1;
    }
    //this method return the second pile to the GUI
    public int generateSecondPile(){
        pile_2 = generatePiles();
        return pile_2;
    }
    //this method return the third pile to the GUI
    public int generateThirdPile(){
        pile_3 = generatePiles();
        return pile_3;
    }

    public int getPile1(){
        return pile_1;
    }

    public int getPile2(){
        return pile_2;
    }

    public int getPile3(){
        return pile_3;
    }

    public void move(int firstPileDeduction) {

        while (firstPileDeduction < 1
                || firstPileDeduction > (100)) {
            JOptionPane.showMessageDialog(null,"Illegal move! - please try again!");

        }
        pile_1 = pile_1 - firstPileDeduction;

    }

    public void secondPileMove(int secondPileDeduction) {

        while (secondPileDeduction < 1
                || secondPileDeduction > (100)) {
            JOptionPane.showMessageDialog(null,"Illegal move! - please try again!");

        }
        pile_2 = pile_2 - secondPileDeduction;

    }

    public void thirdPileMove(int thirdPileDeduction) {

        while (thirdPileDeduction < 1
                || thirdPileDeduction > (100)) {
            JOptionPane.showMessageDialog(null,"Illegal move! - please try again!");

        }
        pile_3 = pile_3 - thirdPileDeduction;

    }

}
