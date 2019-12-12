package com.Nimgame;
import java.util.Random;
import java.util.Scanner;

public class AI
{

    private Boolean kompinter;

    public AI(Boolean smartComputer)
    {
        if (smartComputer) {
            kompinter = true;
        } else {
            kompinter = false;
        }
    }

    public int Giliran(int inputangka)
    {
        int ambiljml = 1;
        Random generator = new Random();
        //Scanner result = new Scanner(System.in);
        //int result;
        
        if (kompinter) {
            for (int i = 1; i <= (inputangka / 2); i++) {
                int t = inputangka - i;
                if (t == 3 || t == 7 || t == 15 || t == 31 || t == 63) {
                    ambiljml = i;
                }
            }
            if (ambiljml == 0) {
                ambiljml = generator.nextInt((inputangka / 2) - 1) + 1;
            }
        } else {
            ambiljml = generator.nextInt((inputangka / 2) - 1) + 1;
        }

        System.out.println("Komputer Mengambil " + ambiljml + " kelereng.");
        return ambiljml;
    }
}
