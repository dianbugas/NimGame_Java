package com.nimgame;
import java.util.Scanner;

public class Player
{
    public int promptPlayer(int numMarbles)
    {
        Scanner in = new Scanner(System.in);
        Boolean success = false;
        int takeAmount = 0;
        System.out.println("Ada " + numMarbles + " kelereng yang di hapus.");

        while (!success) {
            System.out.print("> ");
            takeAmount = in.nextInt();
            if (takeAmount <= 0) {
                System.out.println("Usaha yang bagus. Silakan masukkan jumlah di atas nol.");
            } else if ((takeAmount > (numMarbles / 2)) && (numMarbles != 1)) {
                System.out.println("Hannya ada " + numMarbles + " kelereng yang tersisa.");
                System.out.println("Anda hanya dapat mengambil setengah tumpukan.");
            } else {
                System.out.println("Okay, " + takeAmount + " kelereng diambil dari tumpukan.");
                success = true;
            }
        }
        return takeAmount;
    }
}