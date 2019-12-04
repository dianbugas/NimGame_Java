package com.nim;

import javax.swing.JOptionPane;
/**
 * Write a description of class GetPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GetPlayer
{
    public  int GetPlayerInput(){
        Object[] options = {"Human",
                "Computer"};
        int n = JOptionPane.showOptionDialog(null,
                "Select human or computer player",
                "Player selection",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        return n;
    }
}
