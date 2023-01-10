/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controler.Database;
import controler.IDatabase;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
    import javax.swing.*;
    import java.util.Date;
    //import ja
    import java.sql.*;
    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import javax.swing.table.DefaultTableModel;
    //import doryan.windowsnotificationapi.fr.Notification;

/**
 *
 * @author Rafaly Antoni
 */
public class AfficheHeb implements MouseListener{
    String val,jour,L,M,M1,J,V,S,D,m1,m2,m3,m4,m5,m6;
    String colonneL []={"Lundi"},colonneM []={"Mardi"},colonneM1 []={"Mercredi"},colonneJ []={"Jeudi"},colonneV []={"Vendredi"},taf []={"Procedure de travail"};
    JScrollPane paneL,paneM,paneM1,paneJ,paneV,paneTaf,panes1,panes2,panes3,panes4,panes5,paneMois,PhebdoT,PmensT,PtriT;
    JTable Tlundi,Tmardi,Tmercredi,Tjeudi,Tvendredi,TAF,sem1,sem2,sem3,sem4,sem5,Tmois,HebdoT,MensT,TriT;
    String strMois;
    Connection connex;
    StringBuffer sql;
    ResultSet res;
    Statement etat; 
    pageT pa=new pageT();
    IDatabase crud = new Database();
    //************************************
     public final void TafJour(JTable table2,String table, String nomC, String condition, String id){
     table2.setModel(new DefaultTableModel(new String []{"Procedure de travail "},crud.compter2(table, nomC, condition, id).size()));
     try{
     for(int i=0;i<=crud.compter2(table, nomC, condition, id).size();i++){
                 table2.setValueAt(crud.compter2(table, nomC, condition, id).get(i).getNomJour(), i, 0);
                 
             }}
     catch(Exception e){System.out.println(e.getMessage());}
    
     
     }
public AfficheHeb(){
            Date date=new Date();
            DateFormat dateFormat=new SimpleDateFormat("MM");
            strMois = dateFormat.format(date);
            Tmois=new JTable();
            paneMois=new JScrollPane(Tmois);
            //paneMois.setBounds(114, 135, 485, 40);
            Tmois.setFont(new java.awt.Font("Tahoma", 1, 11));
            paneMois.setBorder(null);
            Tlundi=new JTable();
            Tmardi=new JTable();
            
            Tmercredi=new JTable();
            Tjeudi=new JTable();
            Tvendredi=new JTable();
            TAF=new JTable();
            HebdoT=new JTable();
            MensT=new JTable();
            TriT=new JTable();
            //**********
            sem1=new JTable();
            sem2=new JTable();
            sem3=new JTable();
            sem4=new JTable();
            sem5=new JTable();
            panes1=new JScrollPane(sem1);
            panes2=new JScrollPane(sem2);
            panes3=new JScrollPane(sem3);
            panes4=new JScrollPane(sem4);
            panes5=new JScrollPane(sem5);
             sem1.setForeground(new java.awt.Color(0, 102, 255));
             sem2.setForeground(new java.awt.Color(0, 102, 255));
             sem3.setForeground(new java.awt.Color(0, 102, 255));
             sem4.setForeground(new java.awt.Color(0, 102, 255));
             sem5.setForeground(new java.awt.Color(0, 102, 255));
            paneTaf=new JScrollPane(TAF);
            paneTaf.setBounds(677, 140, 290, 110);
            TAF.setModel(new DefaultTableModel(taf,3));
            paneL=new JScrollPane(Tlundi);
            TAF.setForeground(new java.awt.Color(0, 102, 255));
            Tlundi.setModel(new DefaultTableModel(colonneL,3));
            paneM=new JScrollPane(Tmardi);
            Tmardi.setModel(new DefaultTableModel(colonneM,3));
            Tmercredi.setModel(new DefaultTableModel(colonneM1,3));
            Tjeudi.setModel(new DefaultTableModel(colonneJ,3));
            Tvendredi.setModel(new DefaultTableModel(colonneV,3));
            sem5.setModel(new DefaultTableModel(new String []{"Semaine 5"},3));
            paneM1=new JScrollPane(Tmercredi);
            paneJ=new JScrollPane(Tjeudi);
            paneV=new JScrollPane(Tvendredi);
            PhebdoT=new JScrollPane(HebdoT);
            PmensT=new JScrollPane(MensT);
            PtriT=new JScrollPane(TriT);
            //*-*
            paneL.setBounds(65, 143, 115, 110);
            paneL.setBorder(null);
            //*****
            PhebdoT.setBounds(70, 140, 640, 110);
            PmensT.setBounds(70, 140, 640, 110);
            PtriT.setBounds(70, 140, 640, 110);
            //***********
            paneM.setBounds(182, 143, 115, 110);
            paneM.setBorder(null);
            paneTaf.setBorder(null);
        //****
            paneM1.setBounds(299, 143, 115, 110);
            paneM1.setBorder(null);
        //****
            paneJ.setBounds(416, 143, 115, 110);
            paneJ.setBorder(null);
            //****
            paneV.setBounds(533, 143, 115, 110);
            paneV.setBorder(null);
            //*-*
            panes1.setBounds(75, 170, 110, 78);
            panes1.setBorder(null);
            //*-*
            panes2.setBounds(187, 170, 110, 78);
            panes2.setBorder(null);
            //*-*
            panes3.setBounds(299, 170, 110, 78);
            panes3.setBorder(null);
            //*-*
            panes4.setBounds(411, 170, 110, 78);
            panes4.setBorder(null);
            //*-*
            panes5.setBounds(523, 170, 110, 78);
            panes5.setBorder(null);

            MoisJour();
            Action();
}

            
            //****************
            private void MoisJour() {
        m1="Mois 1";
        m2="Mois 2";
        m3="Mois 3";
        m4="Mois 4";
        m5="Mois 5";
        m6="Mois 6";
         Tlundi.setForeground(new java.awt.Color(0, 102, 255));
          Tmardi.setForeground(new java.awt.Color(0, 102, 255));
           Tmercredi.setForeground(new java.awt.Color(0, 102, 255));
            Tjeudi.setForeground(new java.awt.Color(0, 102, 255));
             Tvendredi.setForeground(new java.awt.Color(0, 102, 255));
    }
            //************TAF***************
           
            
          
            //****************

             private void Action() {
        
Tlundi.addMouseListener(this);
Tmardi.addMouseListener(this);
Tmercredi.addMouseListener(this);
Tjeudi.addMouseListener(this);
Tvendredi.addMouseListener(this);
HebdoT.addMouseListener(this);
sem1.addMouseListener(this);
sem2.addMouseListener(this);
sem3.addMouseListener(this);
sem4.addMouseListener(this);
sem5.addMouseListener(this);
        
       
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        if(e.getSource()==Tlundi){
          // afficheContact();
           val = String.valueOf(Tlundi.getValueAt(Tlundi.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"hebdomadaire","NomHebdo",val,"IdHebdo");
    }
         if(e.getSource()==Tmardi){
          // afficheContact();
           val = String.valueOf(Tmardi.getValueAt(Tmardi.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
          // JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"hebdomadaire","NomHebdo",val,"IdHebdo");
    }
         if(e.getSource()==Tmercredi){
          // afficheContact();
           val = String.valueOf(Tmercredi.getValueAt(Tmercredi.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
           
            TafJour(TAF,"hebdomadaire","NomHebdo",val,"IdHebdo");
    }
         if(e.getSource()==Tjeudi){
          // afficheContact();
           val = String.valueOf(Tjeudi.getValueAt(Tjeudi.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           
         
            TafJour(TAF,"hebdomadaire","NomHebdo",val,"IdHebdo");
    }
         if(e.getSource()==Tvendredi){
          // afficheContact();
           val = String.valueOf(Tvendredi.getValueAt(Tvendredi.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
          // paneTaf.setVisible(true);
           TafJour(TAF,"hebdomadaire","NomHebdo",val,"IdHebdo");
    }
         if(e.getSource()==sem1){
          // afficheContact();
           val = String.valueOf(sem1.getValueAt(sem1.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"mensuel","NomMen",val,"IdMen");
    }
         if(e.getSource()==sem2){
          // afficheContact();
           val = String.valueOf(sem2.getValueAt(sem2.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"mensuel","NomMen",val,"IdMen");
         }
    
            if(e.getSource()==sem3){
          // afficheContact();
           val = String.valueOf(sem3.getValueAt(sem3.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"mensuel","NomMen",val,"IdMen");
    }
      if(e.getSource()==sem4){
          // afficheContact();
           val = String.valueOf(sem4.getValueAt(sem4.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"mensuel","NomMen",val,"IdMen");
    }  
      if(e.getSource()==sem5){
          // afficheContact();
           val = String.valueOf(sem5.getValueAt(sem5.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //JOptionPane.showMessageDialog(null, val);
          
            TafJour(TAF,"mensuel","NomMen",val,"IdMen");
    }  
    }
    
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

   
     
}
