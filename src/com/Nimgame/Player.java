package com.Nimgame;
import java.util.Scanner;

public class Player
{
    public int promptPlayer(int inputangka)
    {
        Scanner in = new Scanner(System.in);
        Boolean success = false;
        int takeAmount = 0;
        System.out.println("Ada " + inputangka + " kelereng yang tersedia.");

        while (!success) {
            System.out.print("> ");
            takeAmount = in.nextInt();
            if (takeAmount <= 0) {
                System.out.println("Usaha yang bagus. Silakan masukkan jumlah di atas nol.");
            } else if ((takeAmount > (inputangka / 2)) && (inputangka != 1)) {
                System.out.println("Hannya ada " + inputangka + " kelereng yang tersisa.");
                System.out.println("Anda hanya dapat mengambil setengah tumpukan.");
            } else {
                System.out.println("Ada, " + takeAmount + " kelereng yang diambil dari tumpukan.");
                success = true;
            }
        }
        return takeAmount;
    }
}