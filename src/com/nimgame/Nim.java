package com.nimgame;
import java.util.Scanner;
import java.util.Random;

public class Nim
{
    public static void main(String[] args)
    {
        startGame();
    }

    public static void startGame()
    {
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
        int numPlayers = 1;
        Boolean smartComputer = true;
        Boolean twoPlayer = false;

        System.out.println("Selamat Datang di Permainan Game of Nim");
        System.out.println("---");
        System.out.println("Silahkan Pilih lawan yang ada inginkan a atau b:");
        System.out.println("a). Bermain melawan Komputer Pintar!!!");
        System.out.println("b). Bermain melawan Komputer Bodoh!!!");
        String choice = in.nextLine();

        if (choice.toLowerCase().equals("a")) {
            System.out.println("\n" + "Bermain dengan Komputer Pintar.");
            smartComputer = true;
        } else if (choice.toLowerCase().equals("b")) {
            System.out.println("Bermain melawan Komputer Bodoh.");
            smartComputer = false;
        } else {
            System.out.println("\n" +
                    "Kesalahan - silakan masukkan a atau b");
            Nim.startGame();
        }
        
        int numMarbles = generator.nextInt(90) + 10;
        System.out.println("Bermain dengan " + numMarbles + " kelereng.");

        if (twoPlayer) {
            twoPlayerGame(numMarbles);
        } else {
            aiGame(smartComputer, numMarbles);
        }
    }

    public static void twoPlayerGame(int marbles)
    {
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        Boolean playerOneGoesFirst;
        Boolean playerOneWins = true;
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Pile thePile = new Pile(marbles);
        if (generator.nextInt(2) == 1) {
            System.out.println("\n" + "Pemain satu lebih dulu.");
            playerOneGoesFirst = true;
        } else {
            System.out.println("Pemain dua masuk duluan.");
            playerOneGoesFirst = false;
        }
        while (thePile.getMarbles() != 0) {
            if (playerOneGoesFirst) {
                playerOneWins = false;
                System.out.println("Giliran Pemain Satu:");
                thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
                if (thePile.getMarbles() != 0) {
                    System.out.println("Giliran Pemain Dua:");
                    thePile.removeMarbles(playerTwo.promptPlayer(thePile.getMarbles()));
                } else {
                    playerOneWins = true;
                }
            } else {
                playerOneWins = true;
                System.out.println("Giliran Pemain Dua:");
                thePile.removeMarbles(playerTwo.promptPlayer(thePile.getMarbles()));
                if (thePile.getMarbles() != 0) {
                    System.out.println("Giliran Pemain Satu:");
                    thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
                } else {
                    playerOneWins = false;
                }
            }
        }

        if (playerOneWins) {
            System.out.println("Pemain Satu Menang!");
        } else {
            System.out.println("Pemain Dua Menang!");
        }

        gameOverPrompt();
    }
        
    public static void aiGame(Boolean smartComputer, int marbles)
    {
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        Boolean playerGoesFirst;
        Boolean youWin = true;
        Player playerOne = new Player();
        Pile thePile = new Pile(marbles);
        AI theComputer = new AI(smartComputer);
        
        if (generator.nextInt(2) == 1) {
            System.out.println("Komputer lebih dulu.");
            playerGoesFirst = false;
        } else {
            System.out.println("Anda duluan.");
            playerGoesFirst = true;
        }

        while (thePile.getMarbles() != 0) {
            if (playerGoesFirst) {
                youWin = false;
                thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
                if (thePile.getMarbles() != 0) {
                    thePile.removeMarbles(theComputer.takeTurn(thePile.getMarbles()));
                } else {
                    youWin = true;
                }
            } else {
                youWin = true;
                thePile.removeMarbles(theComputer.takeTurn(thePile.getMarbles()));
                if (thePile.getMarbles() != 0) {
                    thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
                } else {
                    youWin = false;
                }
            }
        }

        if (youWin) {
            System.out.println("\n" +
                    "Kamu menang!");
        } else {
            System.out.println("\n" +
                    "Kamu kalah.");
        }

        gameOverPrompt();
    }
    
    public static void gameOverPrompt()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Main lagi? [Y/N]");
        String choice = in.nextLine();

        if (choice.toLowerCase().equals("y")) {
            System.out.println("Mulai bermain lagi...");
            startGame();
        } else if (choice.toLowerCase().equals("n")) {
            System.out.println("Bye!");
        } else {
            System.out.println("Pilihan tidak valid, silakan coba lagi.");
            gameOverPrompt();
        }
    }
}