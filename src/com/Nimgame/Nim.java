package com.Nimgame;
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
        Boolean kompintar = true;

        System.out.println("Selamat Datang di Permainan Game of Nim");
        System.out.println("---");
        System.out.println("Silahkan Pilih lawan yang ada inginkan a atau b:");
        System.out.println("a). Bermain melawan Komputer susah!!!");
        System.out.println("b). Bermain melawan Komputer mudah!!!");
        System.out.print("Pilih lawan: ");
        String pilihan = in.nextLine();

        if (pilihan.toLowerCase().equals("a")) {
            System.out.println("\n" + "Bermain dengan Komputer susah.");
            kompintar = false;
        } else if (pilihan.toLowerCase().equals("b")) {
            System.out.println("Bermain melawan Komputer mudah.");
            kompintar = true;
        } else {
            System.out.println("\n" + "Kesalahan - silakan masukkan a atau b");
            Nim.startGame();
        }
        
        //int numMarbles = generator.nextInt(100);
        System.out.print("Masukkan jumlah kelereng: ");
        int jmlkelereng = in.nextInt();
        System.out.println("Bermain dengan " + jmlkelereng + " kelereng.");

        aiGame(kompintar, jmlkelereng);  
    }
        
    public static void aiGame(Boolean kompinter, int marbles)
    {
        Random generator = new Random();
        Scanner in = new Scanner(System.in);
        Boolean playerGoesFirst;
        Boolean youWin = true;
        Player playerOne = new Player();
        Pile thePile = new Pile(marbles);
        AI theComputer = new AI(kompinter);
        
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
                    thePile.removeMarbles(theComputer.Giliran(thePile.getMarbles()));
                } else {
                    youWin = true;
                }
            } else {
                youWin = true;
                thePile.removeMarbles(theComputer.Giliran(thePile.getMarbles()));
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
        String pilihan = in.nextLine();

        if (pilihan.toLowerCase().equals("y")) {
            System.out.println("Mulai bermain lagi...");
            startGame();
        } else if (pilihan.toLowerCase().equals("n")) {
            System.out.println("Bye!");
        } else {
            System.out.println("Pilihan tidak valid, silakan coba lagi.");
            gameOverPrompt();
        }
    }
}