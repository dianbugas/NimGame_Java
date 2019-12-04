package com.nim;

import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Write a description of class TestFrame1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUIFrame extends JFrame implements ActionListener
{
    //creating JButton1
    private JButton quit;
    //creating JButton2
    private JButton newGame;
    //first pile lable
    private JLabel pile_1 = new JLabel("pile 1: ") ;
    //first text entry
    private JTextField firstPile = new JTextField(5);
    //second pile label
    private JLabel pile_2 = new JLabel("pile 2: ") ;
    //second pile entry
    private JTextField secondPile = new JTextField(5);
    //third pile label
    private JLabel pile_3 = new JLabel("pile 3: ");
    //third pile entry
    private JTextField thirdPile = new JTextField(5);
    //Game header
    private JLabel headerLabel = new JLabel("Game in progress!!");
    //creating text area
    private JTextArea textArea = new JTextArea(17,30);
    GameLogic gameLogic = new GameLogic();

    private String whoseMove = "Initial State";

    int pile1, pile2, pile3;
    //constructor
    public GUIFrame(){
        super("Multi - Nim Game");

        mainFrame();

    }

    private void mainFrame(){
        // setting the FlowLayout
        setLayout(new FlowLayout());

        //adding text labels
        add(pile_1);
        add(pile_2);
        add(pile_3);
        //adding text fields
        add(firstPile);
        add(secondPile);
        add(thirdPile);
        //adding the header label
        add(headerLabel);
        //adding the text area
        add(textArea);
        //setting up the size
        setSize(400,400);
        //setting the visibility to true
        setVisible(true);
        //this means you cannot resize the gui
        setResizable(false);

        textArea.setEditable(false);
        //setting line wrap
        textArea.setLineWrap(true);
        //setting wrap style
        textArea.setWrapStyleWord(true);
        //enable the frame to be closed upon clicking close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //getting the background colour
        getContentPane().setBackground(Color. green);

        firstPile.addActionListener(this);//adding the firstPile to the addActionListener method
        secondPile.addActionListener(this);//adding the secondPile to the addActionListener method
        thirdPile.addActionListener(this);//adding the thirdPile to the addActionListener method

        quit = new JButton("Quit");
        add(quit);
        quit.addActionListener(this);
        newGame = new JButton("New Game");
        add(newGame);
        newGame.addActionListener(this);

        //making a connection to the GameLogic class, by referrence

        pile1 = gameLogic.generateFirstPile();
        firstPile.setText(pile1 +"");//calling the generateFirstPile() method
        pile2 = gameLogic.generateSecondPile();
        secondPile.setText(pile2+"");//calling the generateSecondPile() method
        pile3 = gameLogic.generateThirdPile();
        thirdPile.setText(pile3+"");//calling the generateThirdPile() method
        updateStage();
    }

    public void updateStage(){
        textArea.setText(whoseMove + ":\t " + pile1+" "+pile2+" "+pile3);
        whoseMove = gameLogic.getPlayerSelection();
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getActionCommand().equals("Quit")){
            System.exit(0);
        }

        if(pile1 != Integer.parseInt(firstPile.getText())){
            pile1 = pile1 - Integer.parseInt(firstPile.getText());
        }
        if(pile2 != Integer.parseInt(firstPile.getText())){
            pile2 = pile2 - Integer.parseInt(firstPile.getText());
        }
        if(pile3 != Integer.parseInt(firstPile.getText())){
            pile3 = pile3 - Integer.parseInt(firstPile.getText());
        }
        updateStage();

    }

}