package com.Nimgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class nimgame {
    public static void main(String[] args){
       mulai();
       //coba();
    }
    
    // function mulai
    public static void mulai(){
        Scanner in = new Scanner(System.in);
//        Boolean playerStupid = false;
//        Boolean playerSmart = true;
        
        System.out.println("\n-- Game Of NIM --");
        System.out.print("\nPlayer name: ");
        String name = in.nextLine();
        System.out.println("\na.) Player smart");
        System.out.println("b.) Player stupid");
        System.out.print("\nPilih lawan terlebih dahulu (input a atau b): ");
        String pilih = in.nextLine();
        if (pilih.toLowerCase().equals("a")) {
            System.out.println("Sip, player " + name +" akan bermain dengan komputer smart");
        }
        else if(pilih.toLowerCase().equals("b")) {
            System.out.println("Wow,  player "  + name +" akan bermain dengan komputer stupid");
        }
        System.out.print("Jumlah kelereng yang akan digunakan (10 - 100): ");
        
        try {
            int kelereng = in.nextInt();
            if (kelereng < 10) {
            System.out.println("\nJumlah kelereng terlalu sedikit");
                coba();
        }
            else if(kelereng > 100) {
                System.out.println("\nJumlah kelereng terlalu banyak");
                coba();
            }
            else {
                System.out.println("\n"+name + " lebih dahulu");
                System.out.print("Ke");
            }
        } catch (InputMismatchException e) {
            System.out.println("Inputan harus berupa angka");
            System.out.println("");
            coba();
        }
                
    }
    
    // function kelereng
//    public static void kelereng(){
//        System.out.println("Playe");
//    }
    
    // function coba
    public static void coba() {
        Scanner in = new Scanner (System.in);
        System.out.print("Coba lagi [y/n] ? ");
        String pilih = in.nextLine();
        
        if (pilih.toLowerCase().equals("y")) {
            mulai();
        }
        else if(pilih.toLowerCase().equals("Y")){
            mulai();
        }
        else if(pilih.toLowerCase().equals("n")) {
            System.out.println("\nTerima kasih sudah bermain");
        }
        else if( pilih.toLowerCase().equals("N")) {
            System.out.println("\nTerima kasih sudah bermain");
        }
        else {
            System.out.println("Jawaban kurang tepat, coba lagi");
            coba();
        }
    }
}