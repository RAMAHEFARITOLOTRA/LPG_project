/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;


/**
 *
 * @author Rafaly Antoni
 */
public class Asecna extends JFrame{
     JLabel fond,icon,barre,ferm,fermC,red,redC,anim;//21 16
    JLabel etud,amp,clas,droit,note,admin,fil;
    JLabel etudC,ampC,clasC,droitC,noteC,adminC;//color
    
    public static void main(String[] args) {
        // TODO code application logic here
     Asecna as=new Asecna();
        as.setVisible(true);
    }
    public Asecna(){
        declaration();
        ilaina();
    
    //********************************************
    /*fond.add(etud);
    etud.setBounds(225, 227, 155, 130);
    fond.add(amp);
    amp.setBounds(424, 227, 155, 130);
    fond.add(clas);
    clas.setBounds(621, 227, 155, 130);
    //********************************
    fond.add(droit);
    droit.setBounds(225, 393, 155, 130);
    fond.add(note);
    note.setBounds(424, 393, 155, 130);
    fond.add(admin);
    admin.setBounds(621, 393, 155, 130);*/
    //*****************************
    
    //*******Action Mouse******************************************

    //*****************************************
    }
    public void declaration(){
        setBounds(200,75,1280,720);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Sary/fond.jpg")).getImage());
        setUndecorated(true);
         
        fil=new JLabel();
        ferm=new JLabel();
        red=new JLabel();
        fermC=new JLabel("x");
        //fermC.setFont(new Font("Arial",Font.BOLD,6));
        //fermC.setForeground(new Color(255,7,7));
        redC=new JLabel();
        barre=new JLabel();
        fond=new JLabel();
        anim=new JLabel();
        etud=new JLabel();
        clas=new JLabel();
        admin=new JLabel();
        amp=new JLabel();
        droit=new JLabel();
        note=new JLabel();
        etudC=new JLabel();
        clasC=new JLabel();
        adminC=new JLabel();
        ampC=new JLabel();
        droitC=new JLabel();
        noteC=new JLabel();
    }
    public void ilaina(){
    add(fond);
    fond.setIcon(new ImageIcon(getClass().getResource("/Sary/fond.jpg")));
    /*fond.add(barre);
    barre.setBounds(0, 0, 1000, 23);
    barre.add(red);
    red.setBounds(916, 04, 21, 16);
    barre.add(ferm);
    ferm.setBounds(972, 04, 21, 16);
    
    fond.setLayout(null);
    fond.setBounds(0, 0, 1000, 600);
    fond.add(fil);
    fil.setIcon(new ImageIcon(getClass().getResource("/sary/fil.png")));
    fil.setBounds(0, 226, 10, 302);*/
    }
 

   
//........................................................................................................................
    
    
    
    // CODE NUMERO 2
    
    
    
    //......................................................................................................................
   
    
}
