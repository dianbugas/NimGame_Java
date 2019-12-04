package com.nimgame;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class nimgame extends JFrame {
    //deklarasi komponen
    JLabel ket=new JLabel();
    JLabel ket1=new JLabel();
    JLabel linput=new JLabel("Input");
    JTextField tinput=new JTextField();

    public static void main(String[]args){
        nimgame batas=new nimgame();
        batas.setSize(500, 500);
        Dimension layar=Toolkit.getDefaultToolkit().getScreenSize();
        int l=(layar.width- batas.getSize().width)/2;
        int t=(layar.height- batas.getSize().height)/2;
        batas.setLocation(l, t);
        batas.setResizable(false);
        batas.setVisible(true);
    }
    /**
     * method konstruktor batasPanjangInput
     * berisi pembuatan komponen dan penambahan actionListener
     */
    public nimgame(){
        //fungsi pop up
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("Selamat Datang di Permainan Game of Nim");
        ket.setFont(new Font("Arial",1,12));
        ket.setText("input angka yang ingin di mainkan 10-100");
        ket.setBounds(new Rectangle(100,20,400,20));
        linput.setRequestFocusEnabled(true);
        linput.setBounds(new Rectangle(20,60,50,20));
        tinput.setBounds(new Rectangle(80,60,180,20));
        //penutup pop up

        //mengatur batas maksimal input 100 karakter
        tinput.setDocument(new bacaInput((byte) 100).getFilter());
        tinput.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent ke)
            {

                int kode=ke.getKeyCode();
                if(kode>=100)
                {
                    JOptionPane.showConfirmDialog(null, "Anda tidak bisa "
                            + "memasukkan lebih dari 5 karakter"+"\nbatasPanjangInput sukses...");
                }else if(kode<=10){
                    JOptionPane.showConfirmDialog(null, "Anda tidak bisa "
                            + "memasukkan lebih dari 20 karakter"+"\nbatasPanjangInput sukses...");
                }else{
                    JOptionPane.showConfirmDialog(null, "Anda tidak bisa "
                            + "memasukkan lebih dari 230 karakter"+"\nbatasPanjangInput sukses...");
                }
            }
        });
        this.getContentPane().add(ket,null);
        this.getContentPane().add(ket1,null);
        this.getContentPane().add(linput,null);
        this.getContentPane().add(tinput,null);
    }
    /**
     * class bacaInput
     * digunakan untuk membuat class membatasi input pada field terdiri dari 2 method : bacaPanjangInput()
     * dan getFilter()
     */
    class bacaInput
    {
        byte length;
        PlainDocument filter;
        /**
         * method bacaInput()
         * membuat instance dari bacaInput
         */
        public bacaInput(byte length)
        {
            this.length=length;
        }
        /**
         * method getFilter()
         * dipakai untuk mengeset dan mendapatkan filter
         * @return mengembalikan filter bertipe PlainDocument
         */
        public PlainDocument getFilter()
        {
            filter=new PlainDocument()
            {
                public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
                {
                    int x=tinput.getText().length();
                    if(x<length)
                    {
                        super.insertString(offs,str,a);
                    }
                }
            };
            return filter;
        }
    }
}