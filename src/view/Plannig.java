/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Database;
import controler.IDatabase;
import classe.Classe;
import com.caucho.hessian.client.HessianProxyFactory;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafaly Antoni
 */
public class Plannig extends javax.swing.JFrame {
String val,jour,L,M,M1,J,V,S,D,m1,m2,m3,m4,m5,m6;
String touV []={"Equipement","Type","Jour","Semaine 1","Mois"};
String colonneTab []={"Journalier"},colonneTabheb []={"Hebdo"},colonneTabMen []={"Travail Mensuel"},colonneTabTri []={"Travail Trimestriel et Semestriel","Type"};
String colonneTab1 []={"Maintenance du Jour"};
String moisTri []={"Janvier","Fevrier","Mars","Avril","Mai","Juin"},MoisTri2 []={"Juillet","Août","Septembre","Octobre","Novembre","Decembre"};
int xMouse,yMouse;
String strMois;
String strDate;
Connection connex;
StringBuffer sql;
ResultSet res;
Statement etat;
AfficheHeb af=new AfficheHeb();
pageT trimes=new pageT();
Tableaux ta = new Tableaux();
Livre livre = new Livre();
Tableau tout = new Tableau();
//IDataBase crud = new DataBase();
private IDatabase crud = null;
static private String hoteDist = "http://DESKTOP-VLD2HGD:8080/appView/rpc";
	static private IDatabase getConnection(String url)
	{
		try 
		{
			HessianProxyFactory factory = new com.caucho.hessian.client.HessianProxyFactory();
			return (IDatabase)factory.create(IDatabase.class,url);
                        
		}
		catch(Exception e)
		{
                    JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
        }



    /**
     * Creates new form page
     * @param jourss
     */

//********************** connexion methode***********
     public void  textHeb(String jourss){
          int n=crud.compterHebdo(jour);
          Thebdo.setModel(new DefaultTableModel(new String []{"Maintenance hebdomadaire "+jourss},n));
      }
      //****
     public final void JourAfficher(){
     table1.setModel(new DefaultTableModel(colonneTab,crud.afficheContact("journalier").size()));
     try{
     for(int i=0;i<=crud.afficheContact("journalier").size();i++){
                 table1.setValueAt(crud.afficheContact("journalier").get(i).getNomJour(), i, 0);
                 
             }}
     catch(Exception e){System.out.println(e.getMessage());}
     try{
        Thebdo.setModel(new DefaultTableModel(new String[]{"Travail Hedbomadaire"},crud.afficheHebdo(jour).size())); 
     for(int i=0;i<=crud.afficheHebdo(jour).size();i++){
                 Thebdo.setValueAt(crud.afficheHebdo(jour).get(i).getNomHeb(), i, 0);
                 System.out.println(crud.afficheHebdo(jour).get(i).getNomHeb());
                 
             }}
     catch(Exception e){//System.out.println(e.getMessage());
     }
     
     }

    public final void TafJour(JTable table2,String table, String nomC, String condition, String id){
     table2.setModel(new DefaultTableModel(colonneTab,crud.compter2(table, nomC, condition, id).size()));
     try{
     for(int i=0;i<=crud.compter2(table, nomC, condition, id).size();i++){
                 table2.setValueAt(crud.compter2(table, nomC, condition, id).get(i).getNomJour(), i, 0);
                 
             }}
     catch(Exception e){System.out.println(e.getMessage());}
     try{
        Thebdo.setModel(new DefaultTableModel(new String[]{"Travail Hedbomadaire"},crud.compterHebdo(jour))); 
     for(int i=0;i<=crud.afficheHebdo(jour).size();i++){
                 Thebdo.setValueAt(crud.afficheHebdo(jour).get(i).getNomHeb(), i, 0);
                 System.out.println(crud.afficheHebdo(jour).get(i).getNomHeb());
                 
             }}
     catch(Exception e){//System.out.println(e.getMessage());
     }
     
     }
      
   
     
     
     
     //************************constructeur
     public Plannig() {
        initComponents();
        //new NoticeWindow("",NPosition.TOP_LEFT);
        setIconImage(new ImageIcon(getClass().getResource("/Sary/index.png")).getImage());
        Date date=new Date(); 
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateFormat2=new SimpleDateFormat("MM");
        strMois = dateFormat2.format(date);
        crud = getConnection(hoteDist);
        crud = new Database();
        notesAffiche();
        System.out.println("Hote : "+hoteDist+"  SCE = "+crud);
        //JOptionPane.showMessageDialog(null, strMois);
        strDate=dateFormat.format(date);
        jour=date.toString().substring(0, 3);
        Bexp.setVisible(false);
        Date1.setText(strDate);  
        Line.setVisible(false);
       SousM.setVisible(false); 
       textAll.setVisible(false); 
        Bjour1.setVisible(false);
        heb2.setVisible(false);
        mens1.setVisible(false);
        tri1.setVisible(false);
        sem1.setVisible(false);
        annuel1.setVisible(false);
        // SousM.add(text1);
     // text1.setVisible(false); 
     miala.setVisible(false);
     adm.setVisible(false);
     adm1.setVisible(false);
     propo.setVisible(false);
     propo1.setVisible(false);
     reduire.setVisible(false);
     reduire1.setVisible(false);
     note.setVisible(false);
     note1.setVisible(false);
     aide.setVisible(false);
     aide1.setVisible(false);
     fer.setVisible(false);
     fer1.setVisible(false);
        //****************************************************************
         try
         {
             table3.setModel(new DefaultTableModel(new String[]{"Travail du mois"},AfficheNotif().size())); 
             for(int i=0;i<=AfficheNotif().size();i++)
             {
                 table3.setValueAt(AfficheNotif().get(i).getNomJour(), i, 0);
             }
         }
         catch(Exception e){}
        JourAfficher();
        //afficheHebdo();
       
    }
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NextAdmin = new javax.swing.JLabel();
        Badmin = new javax.swing.JLabel();
        retour = new javax.swing.JLabel();
        Date1 = new javax.swing.JLabel();
        textAll = new javax.swing.JLabel();
        Bexp = new javax.swing.JButton();
        Line = new javax.swing.JLabel();
        pane6 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        pane5 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        pane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        pane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        barre = new javax.swing.JLabel();
        titre = new javax.swing.JLabel();
        pane3 = new javax.swing.JScrollPane();
        Thebdo = new javax.swing.JTable();
        pane4 = new javax.swing.JScrollPane();
        Thebdo2 = new javax.swing.JTable();
        heb1 = new javax.swing.JLabel();
        heb2 = new javax.swing.JLabel();
        Bjour = new javax.swing.JLabel();
        Bjour1 = new javax.swing.JLabel();
        Bpv = new javax.swing.JButton();
        mens = new javax.swing.JLabel();
        mens1 = new javax.swing.JLabel();
        tri = new javax.swing.JLabel();
        tri1 = new javax.swing.JLabel();
        annuel = new javax.swing.JLabel();
        annuel1 = new javax.swing.JLabel();
        sem = new javax.swing.JLabel();
        sem1 = new javax.swing.JLabel();
        fond = new javax.swing.JLabel();
        adm = new javax.swing.JLabel();
        adm1 = new javax.swing.JLabel();
        note = new javax.swing.JLabel();
        note1 = new javax.swing.JLabel();
        fer1 = new javax.swing.JLabel();
        fer = new javax.swing.JLabel();
        propo = new javax.swing.JLabel();
        propo1 = new javax.swing.JLabel();
        aide = new javax.swing.JLabel();
        aide1 = new javax.swing.JLabel();
        reduire = new javax.swing.JLabel();
        reduire1 = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        ferm2 = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        miala = new javax.swing.JLabel();
        SousM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        getContentPane().setLayout(null);

        NextAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NextAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NextAdminMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextAdminMousePressed(evt);
            }
        });
        getContentPane().add(NextAdmin);
        NextAdmin.setBounds(360, 0, 140, 35);

        Badmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Badmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BadminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BadminMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BadminMousePressed(evt);
            }
        });
        getContentPane().add(Badmin);
        Badmin.setBounds(730, 10, 130, 20);

        retour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                retourMousePressed(evt);
            }
        });
        getContentPane().add(retour);
        retour.setBounds(10, 10, 30, 20);

        Date1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        Date1.setForeground(new java.awt.Color(2, 115, 197));
        Date1.setText("Date");
        getContentPane().add(Date1);
        Date1.setBounds(400, 100, 210, 30);

        textAll.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        textAll.setForeground(new java.awt.Color(255, 255, 255));
        textAll.setText("Maintenance Préventive ");
        getContentPane().add(textAll);
        textAll.setBounds(120, 320, 240, 30);

        Bexp.setBackground(new java.awt.Color(12, 46, 73));
        Bexp.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bexp.setForeground(new java.awt.Color(255, 255, 255));
        Bexp.setText("Expoter PDF");
        Bexp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexpActionPerformed(evt);
            }
        });
        getContentPane().add(Bexp);
        Bexp.setBounds(700, 140, 260, 30);

        Line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/Line.jpg"))); // NOI18N
        Line.setText("jLabel1");
        getContentPane().add(Line);
        Line.setBounds(90, 310, 844, 44);

        pane6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table4.setForeground(new java.awt.Color(0, 102, 255));
        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table4MouseReleased(evt);
            }
        });
        pane6.setViewportView(table4);

        getContentPane().add(pane6);
        pane6.setBounds(670, 420, 290, 140);

        pane5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table3.setForeground(new java.awt.Color(0, 102, 255));
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table3MouseReleased(evt);
            }
        });
        pane5.setViewportView(table3);

        getContentPane().add(pane5);
        pane5.setBounds(70, 420, 580, 140);

        table2.setForeground(new java.awt.Color(0, 102, 255));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Procedure de travail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pane2.setViewportView(table2);

        getContentPane().add(pane2);
        pane2.setBounds(670, 140, 290, 110);

        pane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table1.setForeground(new java.awt.Color(0, 102, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table1MouseReleased(evt);
            }
        });
        pane1.setViewportView(table1);

        getContentPane().add(pane1);
        pane1.setBounds(70, 140, 580, 110);

        barre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barreMouseDragged(evt);
            }
        });
        barre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barreMousePressed(evt);
            }
        });
        getContentPane().add(barre);
        barre.setBounds(0, 0, 50, 600);

        titre.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        titre.setForeground(new java.awt.Color(2, 115, 197));
        titre.setText("Maintenance Préventive ");
        getContentPane().add(titre);
        titre.setBounds(70, 94, 360, 40);

        Thebdo.setForeground(new java.awt.Color(0, 102, 255));
        Thebdo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Thebdo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Thebdo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ThebdoMouseReleased(evt);
            }
        });
        pane3.setViewportView(Thebdo);

        getContentPane().add(pane3);
        pane3.setBounds(70, 260, 580, 110);

        Thebdo2.setForeground(new java.awt.Color(0, 102, 255));
        Thebdo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Maintenace Hebdo"
            }
        ));
        pane4.setViewportView(Thebdo2);

        getContentPane().add(pane4);
        pane4.setBounds(670, 260, 290, 110);

        heb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                heb1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                heb1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                heb1MousePressed(evt);
            }
        });
        getContentPane().add(heb1);
        heb1.setBounds(473, 35, 103, 50);

        heb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/hebdo.jpg"))); // NOI18N
        getContentPane().add(heb2);
        heb2.setBounds(473, 35, 103, 50);

        Bjour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BjourMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BjourMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BjourMousePressed(evt);
            }
        });
        getContentPane().add(Bjour);
        Bjour.setBounds(371, 35, 103, 50);

        Bjour1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/journalier.jpg"))); // NOI18N
        Bjour1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bjour1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bjour1MousePressed(evt);
            }
        });
        getContentPane().add(Bjour1);
        Bjour1.setBounds(371, 35, 103, 50);

        Bpv.setBackground(new java.awt.Color(12, 46, 73));
        Bpv.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bpv.setForeground(new java.awt.Color(255, 255, 255));
        Bpv.setText("P.V");
        Bpv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpvActionPerformed(evt);
            }
        });
        getContentPane().add(Bpv);
        Bpv.setBounds(670, 100, 180, 30);

        mens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mensMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mensMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mensMousePressed(evt);
            }
        });
        getContentPane().add(mens);
        mens.setBounds(575, 35, 103, 50);

        mens1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/mensuel.jpg"))); // NOI18N
        mens1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mens1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mens1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mens1MousePressed(evt);
            }
        });
        getContentPane().add(mens1);
        mens1.setBounds(575, 35, 103, 50);

        tri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                triMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                triMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                triMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                triMouseReleased(evt);
            }
        });
        getContentPane().add(tri);
        tri.setBounds(677, 35, 103, 50);

        tri1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/trimestre.jpg"))); // NOI18N
        tri1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tri1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tri1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tri1MousePressed(evt);
            }
        });
        getContentPane().add(tri1);
        tri1.setBounds(677, 35, 103, 50);

        annuel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                annuelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                annuelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                annuelMousePressed(evt);
            }
        });
        getContentPane().add(annuel);
        annuel.setBounds(883, 35, 103, 50);

        annuel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/annuel.jpg"))); // NOI18N
        annuel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                annuel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                annuel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                annuel1MousePressed(evt);
            }
        });
        getContentPane().add(annuel1);
        annuel1.setBounds(883, 35, 103, 50);

        sem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                semMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                semMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                semMousePressed(evt);
            }
        });
        getContentPane().add(sem);
        sem.setBounds(780, 35, 103, 50);

        sem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/semestre.jpg"))); // NOI18N
        sem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sem1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sem1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sem1MousePressed(evt);
            }
        });
        getContentPane().add(sem1);
        sem1.setBounds(780, 35, 103, 50);

        fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/Calendrier.jpg"))); // NOI18N
        fond.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondMousePressed(evt);
            }
        });
        getContentPane().add(fond);
        fond.setBounds(0, 0, 1000, 600);

        adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                admMousePressed(evt);
            }
        });
        getContentPane().add(adm);
        adm.setBounds(50, 43, 140, 17);

        adm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/backline.png"))); // NOI18N
        adm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adm1MousePressed(evt);
            }
        });
        getContentPane().add(adm1);
        adm1.setBounds(50, 43, 140, 17);

        note.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noteMouseExited(evt);
            }
        });
        getContentPane().add(note);
        note.setBounds(50, 68, 140, 17);

        note1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/backline.png"))); // NOI18N
        getContentPane().add(note1);
        note1.setBounds(50, 68, 140, 17);

        fer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/backline.png"))); // NOI18N
        getContentPane().add(fer1);
        fer1.setBounds(50, 173, 140, 17);

        fer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ferMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ferMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ferMousePressed(evt);
            }
        });
        getContentPane().add(fer);
        fer.setBounds(50, 173, 140, 17);

        propo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                propoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                propoMouseExited(evt);
            }
        });
        getContentPane().add(propo);
        propo.setBounds(50, 95, 140, 17);

        propo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/backline.png"))); // NOI18N
        getContentPane().add(propo1);
        propo1.setBounds(50, 95, 140, 17);

        aide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aideMouseExited(evt);
            }
        });
        getContentPane().add(aide);
        aide.setBounds(50, 121, 140, 17);

        aide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/backline.png"))); // NOI18N
        getContentPane().add(aide1);
        aide1.setBounds(50, 121, 140, 17);

        reduire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reduireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reduireMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reduireMousePressed(evt);
            }
        });
        getContentPane().add(reduire);
        reduire.setBounds(50, 147, 140, 17);

        reduire1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/backline.png"))); // NOI18N
        getContentPane().add(reduire1);
        reduire1.setBounds(50, 147, 140, 17);

        ferm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ferm1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ferm1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ferm1MousePressed(evt);
            }
        });
        getContentPane().add(ferm1);
        ferm1.setBounds(965, 8, 19, 19);
        getContentPane().add(ferm2);
        ferm2.setBounds(961, 7, 19, 19);

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/tirer.png"))); // NOI18N
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuMouseReleased(evt);
            }
        });
        getContentPane().add(menu);
        menu.setBounds(10, 40, 30, 20);

        miala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/retour.png"))); // NOI18N
        miala.setText("jLabel1");
        miala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mialaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mialaMousePressed(evt);
            }
        });
        getContentPane().add(miala);
        miala.setBounds(10, 40, 30, 20);

        SousM.setBackground(new java.awt.Color(204, 0, 0));
        SousM.setForeground(new java.awt.Color(204, 0, 0));
        SousM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/sousM.jpg"))); // NOI18N
        SousM.setText("jLabel1");
        getContentPane().add(SousM);
        SousM.setBounds(49, 35, 140, 199);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void barreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barreMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barreMouseDragged

    private void barreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barreMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_barreMousePressed

    private void table1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseReleased
        // TODO add your handling code here:
        
       if(evt.getSource()==table1){
          // afficheContact();
           val = String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
          // affiche2();
           TafJour(table2,"journalier","NomJour",val,"idJour");
          JourAfficher();
           
       } 
    }//GEN-LAST:event_table1MouseReleased

    private void fondMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fondMousePressed

    private void BjourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BjourMousePressed
        // TODO add your handling code here:
        
      //******************
    }//GEN-LAST:event_BjourMousePressed

    private void Bjour1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bjour1MousePressed
        // TODO add your handling code here:
        Bexp.setVisible(false);
        Bpv.setBounds(670, 100, 140, 30);
         titre.setText("Maintenance Préventive");
        Date1.setBounds(400, 100, 210, 30);
        Date1.setForeground(new java.awt.Color(0, 51, 102));
        textAll.setVisible(false);
        pane1.setVisible(true);
        pane2.setVisible(true);
        pane3.setVisible(true);
        pane4.setVisible(true);
        Line.setVisible(false);
        
        //** HEB//
        tout.PTtable.setVisible(false);
        JourAfficher();
        HebFalse();
        MenFalse();
        //******
         //**************
        SemFalse();
        TrimFalse();
    }//GEN-LAST:event_Bjour1MousePressed

    private void BjourMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BjourMouseEntered
        // TODO add your handling code here:
        Bjour1.setVisible(true);
         //fond.add(Bjour1);
        //Bjour1.setIcon(new ImageIcon(getClass().getResource("/sary/journalier.jpg")));
         //ferm2.setBounds(961,3,30, 30);
    }//GEN-LAST:event_BjourMouseEntered

    private void BjourMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BjourMouseExited
        // TODO add your handling code here:
        Bjour1.setVisible(false);
    }//GEN-LAST:event_BjourMouseExited

    private void heb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heb1MouseEntered
        // TODO add your handling code here:
       heb2.setVisible(true);
//         fond.add( heb2);
  //       heb2.setIcon(new ImageIcon(getClass().getResource("/sary/hebdo.jpg")));
    }//GEN-LAST:event_heb1MouseEntered

    private void heb1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heb1MouseExited
        // TODO add your handling code here:
        heb2.setVisible(false);
    }//GEN-LAST:event_heb1MouseExited

    private void heb1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heb1MousePressed
        // TODO add your handling code here:
        Bpv.setBounds(670, 100, 140, 30);
        titre.setText("Hebdomadaire");
        Date1.setBounds(400, 320, 210, 30);
        Date1.setForeground(new java.awt.Color(255, 255, 255));
        fond.add(af.paneTaf);
        Line.setVisible(true);
        pane2.setVisible(true);
         tout.PTtable.setVisible(false);
         textAll.setVisible(true);
         af.paneTaf.setVisible(true);
         af.TAF.setVisible(true);
         JourFalse();
         pane2.setVisible(false);
         //**************
         MenFalse();
         SemFalse();
         TrimFalse();
        
      //******************
        //******
        af.paneL.setVisible(true);
        af.paneM.setVisible(true);
        af.paneM1.setVisible(true);
        af.paneJ.setVisible(true);
        af.paneV.setVisible(true);
        //***
        fond.add(af.paneL);
        //*****
        fond.add(af.paneM);
        //****
        fond.add(af.paneM1);
        //****
        fond.add(af.paneJ);
        //****
        fond.add(af.paneV);
        pageHebdo();
    }//GEN-LAST:event_heb1MousePressed

    private void ThebdoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThebdoMouseReleased
        // TODO add your handling code here:
        if(evt.getSource()==Thebdo){
        val = String.valueOf(Thebdo.getValueAt(Thebdo.getSelectedRow(), 0));
          // teste.setText(String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0)));
           //afficheTafHebdo();
            TafJour(Thebdo2, "hebdomadaire", "NomHebdo", val, "IdHebdo");
        }
          
    }//GEN-LAST:event_ThebdoMouseReleased

    private void mensMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mensMouseEntered
        // TODO add your handling code here:
        mens1.setVisible(true);
    //     fond.add( mens1);
    //     mens1.setIcon(new ImageIcon(getClass().getResource("/sary/mensuel.jpg")));
    }//GEN-LAST:event_mensMouseEntered

    private void mensMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mensMouseExited
        // TODO add your handling code here:
        mens1.setVisible(false);
    }//GEN-LAST:event_mensMouseExited

    private void mensMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mensMousePressed
        // TODO add your handling code here:
        Bpv.setBounds(670, 100, 140, 30);
        titre.setText("Mensuel");
        Date1.setBounds(400, 320, 210, 30);
        Date1.setForeground(new java.awt.Color(255, 255, 255));
        HebFalse();
        JourFalse();
        pane2.setVisible(false);
        //pane2.setVisible(true);
        textAll.setVisible(true);
        Line.setVisible(true);
        fond.add(af.paneTaf);
        af.paneTaf.setVisible(true);
         tout.PTtable.setVisible(false);
        //*********affichage*******
        fond.add(af.panes1);
        fond.add(af.panes2);
        fond.add(af.panes3);
        fond.add(af.panes4);
        fond.add(af.panes5);
        af.panes1.setVisible(true);
        af.panes2.setVisible(true);
        af.panes3.setVisible(true);
        af.panes4.setVisible(true);
       
        //**************
        TrimFalse();
        SemFalse();
      //******************
        fond.add(af.paneMois); 
        af.paneMois.setVisible(true);
        pageMensuel();
        conditionMois();
        afficheMois();
    }//GEN-LAST:event_mensMousePressed

    private void mens1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mens1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mens1MouseEntered

    private void mens1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mens1MouseExited
        // TODO add your handling code here:
      
    }//GEN-LAST:event_mens1MouseExited

    private void mens1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mens1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mens1MousePressed

    private void triMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_triMouseEntered
        // TODO add your handling code here:
         tri1.setVisible(true);
//         fond.add( tri1);
//         tri1.setIcon(new ImageIcon(getClass().getResource("/sary/trimestre.jpg")));
    }//GEN-LAST:event_triMouseEntered

    private void triMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_triMouseExited
        // TODO add your handling code here:
          tri1.setVisible(false);
    }//GEN-LAST:event_triMouseExited

    private void triMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_triMousePressed
        // TODO add your handling code here:
        Bpv.setBounds(670, 100, 140, 30);
         titre.setText("Trimestriel");
        Date1.setBounds(400, 320, 210, 30);
        Date1.setForeground(new java.awt.Color(255, 255, 255));
         HebFalse();
         MenFalse();
          tout.PTtable.setVisible(false);
          textAll.setVisible(true);
        
        //*********affichage*******
        JourFalse();
        //*****************
        AfficheTmois();
        Line.setVisible(true);
        fond.add(trimes.Pmois);
        trimes.Pmois.setVisible(true);
        fond.add(trimes.Pmois1);
        trimes.Pmois1.setVisible(true);
        fond.add(trimes.Pmois2);
        trimes.Pmois2.setVisible(true);
        pane2.setVisible(false);
        //*************
        fond.add(trimes.jScrollPane1);
        fond.add(trimes.jScrollPane3);
        trimes.jScrollPane3.setVisible(true);
        trimes.jScrollPane1.setVisible(true);
        fond.add(trimes.jScrollPane2);
        trimes.jScrollPane2.setVisible(true);
        fond.add(trimes.jScrollPane4);
        trimes.jScrollPane4.setVisible(true);
        fond.add(trimes.jScrollPane5);
        trimes.jScrollPane5.setVisible(true);
        fond.add(trimes.jScrollPane6);
        trimes.jScrollPane6.setVisible(true);
        fond.add(trimes.Pmois1);
        trimes.Pmois1.setVisible(true);
        fond.add(trimes.Pmois2);
        trimes.Pmois2.setVisible(true);
        fond.add(trimes.pmois2);
        trimes.pmois2.setVisible(true);
        fond.add(trimes.pmois22);
        trimes.pmois22.setVisible(true);
        fond.add(trimes.pmois3);
        trimes.pmois3.setVisible(true);
        fond.add(trimes.jScrollPane7);
        trimes.jScrollPane7.setVisible(true);
        fond.add(trimes.pmois6);
        trimes.pmois6.setVisible(true);
        fond.add(trimes.PanMois2);
        trimes.PanMois2.setVisible(true);
         fond.add(trimes.pmois23);
        trimes.pmois23.setVisible(true);
        affichePageTrim();
        SemFalse();
       
        
    }//GEN-LAST:event_triMousePressed

    private void tri1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tri1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tri1MouseEntered

    private void tri1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tri1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tri1MouseExited

    private void tri1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tri1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tri1MousePressed

    private void semMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semMouseEntered
        // TODO add your handling code here:
       sem1.setVisible(true);
//         fond.add( sem1);
//         sem1.setIcon(new ImageIcon(getClass().getResource("/sary/semestre.jpg")));
    }//GEN-LAST:event_semMouseEntered

    private void semMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semMouseExited
        // TODO add your handling code here:
        sem1.setVisible(false);
    }//GEN-LAST:event_semMouseExited

    private void semMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semMousePressed
        // TODO add your handling code here:
        JourFalse();
        titre.setText("Semestriel");
       Bpv.setBounds(670, 100, 140, 30);
        //*********affichage*******
         tout.PTtable.setVisible(false);
         textAll.setVisible(false);
        AfficheTmois();
        MenFalse();
        HebFalse();
         TrimFalse();
         AfficheTmoisSem();
        Line.setVisible(false);
        pane2.setVisible(false);
        //*****************
      fond.add(ta.Pmois);
      ta.Pmois.setVisible(true);
      fond.add(ta.Pmois1);
      ta.Pmois1.setVisible(true);
      fond.add(ta.Pmois2);
      ta.Pmois2.setVisible(true);
      //*
      fond.add(ta.Pmois3);
      ta.Pmois3.setVisible(true);
      fond.add(ta.Pmois4);
      ta.Pmois4.setVisible(true);
      fond.add(ta.Pmois5);
      ta.Pmois5.setVisible(true);
      //*************
      fond.add(ta.P1);
      ta.P1.setVisible(true);
      fond.add(ta.P2);
      ta.P2.setVisible(true);
      fond.add(ta.P3);
      ta.P3.setVisible(true);
      fond.add(ta.P4);
      ta.P4.setVisible(true);
      fond.add(ta.P5);
      ta.P5.setVisible(true);
      fond.add(ta.P6);
      ta.P6.setVisible(true);
      fond.add(ta.P7);
      ta.P7.setVisible(true);
      fond.add(ta.P8);
      ta.P8.setVisible(true);
      fond.add(ta.P9);
      ta.P9.setVisible(true);
      fond.add(ta.P10);
      ta.P10.setVisible(true);
      fond.add(ta.P11);
      ta.P11.setVisible(true);
      fond.add(ta.P12);
      ta.P12.setVisible(true);
      fond.add(ta.P13);
      ta.P13.setVisible(true);
      fond.add(ta.P14);
      ta.P14.setVisible(true);
      fond.add(ta.P15);
      ta.P15.setVisible(true);
      fond.add(ta.P16);
      ta.P16.setVisible(true);
      fond.add(ta.P17);
      ta.P17.setVisible(true);
      fond.add(ta.P18);
      ta.P18.setVisible(true);
      fond.add(ta.P19);
      ta.P19.setVisible(true);
      fond.add(ta.P20);
      ta.P20.setVisible(true);
      fond.add(ta.P21);
      ta.P21.setVisible(true);
      fond.add(ta.P22);
      ta.P22.setVisible(true);
      fond.add(ta.P23);
      ta.P23.setVisible(true);
      fond.add(ta.P24);
      ta.P24.setVisible(true);
      fond.add(ta.P25);
      ta.P25.setVisible(true);
      fond.add(ta.P26);
      ta.P26.setVisible(true);
      affichePageSem();    
    }//GEN-LAST:event_semMousePressed

    private void sem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sem1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sem1MouseEntered

    private void sem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sem1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_sem1MouseExited

    private void sem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sem1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sem1MousePressed

    private void triMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_triMouseReleased
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_triMouseReleased

    private void BpvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpvActionPerformed
        // TODO add your handling code here:
        Pv pv = new Pv();
        setVisible(false);
        pv.setVisible(true);
    }//GEN-LAST:event_BpvActionPerformed

    private void table3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_table3MouseReleased

    private void table4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_table4MouseReleased

    private void admMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admMouseEntered
        // TODO add your handling code here:
        adm1.setVisible(true);
        //adm1.setVisible(true);
    }//GEN-LAST:event_admMouseEntered

    private void admMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admMouseExited
        // TODO add your handling code here:
        adm1.setVisible(false);
    }//GEN-LAST:event_admMouseExited

    private void admMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admMousePressed
        // TODO add your handling code here:
        Accueil ac = new Accueil();
       ac.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_admMousePressed

    private void noteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteMouseEntered
        // TODO add your handling code here:
        note1.setVisible(true);
    }//GEN-LAST:event_noteMouseEntered

    private void noteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteMouseExited
        // TODO add your handling code here:
        note1.setVisible(false);
    }//GEN-LAST:event_noteMouseExited

    private void ferMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferMouseEntered
        // TODO add your handling code here:
        fer1.setVisible(true);
    }//GEN-LAST:event_ferMouseEntered

    private void ferMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferMouseExited
        // TODO add your handling code here:
        fer1.setVisible(false);
    }//GEN-LAST:event_ferMouseExited

    private void ferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ferMousePressed

    private void propoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propoMouseEntered
        // TODO add your handling code here:
        propo1.setVisible(true);
    }//GEN-LAST:event_propoMouseEntered

    private void propoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propoMouseExited
        // TODO add your handling code here:
        propo1.setVisible(false);
    }//GEN-LAST:event_propoMouseExited

    private void aideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aideMouseEntered
        // TODO add your handling code here:
        aide1.setVisible(true);
    }//GEN-LAST:event_aideMouseEntered

    private void aideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aideMouseExited
        // TODO add your handling code here:
        aide1.setVisible(false);
    }//GEN-LAST:event_aideMouseExited

    private void reduireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMouseEntered
        // TODO add your handling code here:
        reduire1.setVisible(true);
    }//GEN-LAST:event_reduireMouseEntered

    private void reduireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMouseExited
        // TODO add your handling code here:
        reduire1.setVisible(false);
        reduire.setVisible(true);
    }//GEN-LAST:event_reduireMouseExited

    private void reduireMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMousePressed
        // TODO add your handling code here:
        setState(Accueil.ICONIFIED);
    }//GEN-LAST:event_reduireMousePressed

    private void menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menuMouseEntered

    private void menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_menuMouseExited

    private void menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMousePressed
        // TODO add your handling code here:
        SousM.setVisible(true);
        menu.setVisible(false);
        miala.setVisible(true);
        //****
        adm.setVisible(true);
        propo.setVisible(true);
        reduire.setVisible(true);
        note.setVisible(true);
        aide.setVisible(true);
        fer.setVisible(true);

    }//GEN-LAST:event_menuMousePressed

    private void menuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_menuMouseReleased

    private void mialaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mialaMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_mialaMouseExited

    private void mialaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mialaMousePressed
        // TODO add your handling code here:
            SousM.setVisible(false);
            menu.setVisible(true);
            miala.setVisible(false);
            adm.setVisible(false);
            adm1.setVisible(false);
            propo.setVisible(false);
            propo1.setVisible(false);
            reduire.setVisible(false);
            reduire1.setVisible(false);
            note.setVisible(false);
            note1.setVisible(false);
            aide.setVisible(false);
            aide1.setVisible(false);
            fer.setVisible(false);
            fer1.setVisible(false);
    }//GEN-LAST:event_mialaMousePressed

    private void adm1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adm1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_adm1MousePressed

    private void BexpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexpActionPerformed
        // TODO add your handling code here:
        livre.PDFExporter(tout.Ttable,"Travail pendant l'année");
    }//GEN-LAST:event_BexpActionPerformed

    private void annuelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annuelMouseEntered
    annuel1.setVisible(true);
//         fond.add(annuel1);
  //       annuel1.setIcon(new ImageIcon(getClass().getResource("/sary/annuel.jpg")));        // TODO add your handling code here:
    }//GEN-LAST:event_annuelMouseEntered

    private void annuelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annuelMouseExited
        annuel1.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_annuelMouseExited

    private void annuelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annuelMousePressed
        // TODO add your handling code here:
        titre.setText("Annuel");
       textAll.setVisible(false);
        Bpv.setBounds(700, 180, 260, 30);
        fond.add(tout.PTtable);
        tout.PTtable.setVisible(true);
        pane2.setVisible(false);
        afficheAnnuel(tout.Ttable);  
        JourFalse();
        MenFalse();
        HebFalse();
        SemFalse();
        TrimFalse();
         Bexp.setVisible(true);
        
    }//GEN-LAST:event_annuelMousePressed

    private void Bjour1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bjour1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Bjour1MouseEntered

    private void NextAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextAdminMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_NextAdminMouseEntered

    private void NextAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextAdminMouseExited
        //    NextAdmin.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_NextAdminMouseExited

    private void NextAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextAdminMousePressed

    }//GEN-LAST:event_NextAdminMousePressed

    private void BadminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BadminMouseEntered
        NextAdmin.setIcon(new ImageIcon(getClass().getResource("/image/admin2.jpg")));
        NextAdmin.setBounds(727,0,140,35);
        fond.add(NextAdmin);
        NextAdmin.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BadminMouseEntered

    private void BadminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BadminMouseExited
        NextAdmin.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_BadminMouseExited

    private void BadminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BadminMousePressed
        TestAdmin testadmin= new TestAdmin();
        testadmin.setVisible(true);
        this.setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_BadminMousePressed

    private void retourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retourMousePressed
        // TODO add your handling code here:
        Menu men = new Menu();
        men.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retourMousePressed

    private void annuel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annuel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_annuel1MouseEntered

    private void annuel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annuel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_annuel1MouseExited

    private void annuel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annuel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_annuel1MousePressed

    private void ferm1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseEntered
        // TODO add your handling code here:
        ferm2.setVisible(true);
        fond.add(ferm2);
        ferm2.setIcon(new ImageIcon(getClass().getResource("/image/ferme.jpg")));
        ferm2.setBounds(961,3,30, 30);
    }//GEN-LAST:event_ferm1MouseEntered

    private void ferm1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseExited
        // TODO add your handling code here:
        ferm2.setVisible(false);
    }//GEN-LAST:event_ferm1MouseExited

    private void ferm1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ferm1MousePressed
   
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Plannig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plannig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plannig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plannig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Plannig().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Badmin;
    private javax.swing.JButton Bexp;
    private javax.swing.JLabel Bjour;
    private javax.swing.JLabel Bjour1;
    private javax.swing.JButton Bpv;
    private javax.swing.JLabel Date1;
    private javax.swing.JLabel Line;
    private javax.swing.JLabel NextAdmin;
    private javax.swing.JLabel SousM;
    private javax.swing.JTable Thebdo;
    private javax.swing.JTable Thebdo2;
    private javax.swing.JLabel adm;
    private javax.swing.JLabel adm1;
    private javax.swing.JLabel aide;
    private javax.swing.JLabel aide1;
    private javax.swing.JLabel annuel;
    private javax.swing.JLabel annuel1;
    private javax.swing.JLabel barre;
    private javax.swing.JLabel fer;
    private javax.swing.JLabel fer1;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    public javax.swing.JLabel fond;
    private javax.swing.JLabel heb1;
    private javax.swing.JLabel heb2;
    private javax.swing.JLabel mens;
    private javax.swing.JLabel mens1;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel miala;
    private javax.swing.JLabel note;
    private javax.swing.JLabel note1;
    private javax.swing.JScrollPane pane1;
    private javax.swing.JScrollPane pane2;
    private javax.swing.JScrollPane pane3;
    private javax.swing.JScrollPane pane4;
    private javax.swing.JScrollPane pane5;
    private javax.swing.JScrollPane pane6;
    private javax.swing.JLabel propo;
    private javax.swing.JLabel propo1;
    private javax.swing.JLabel reduire;
    private javax.swing.JLabel reduire1;
    public javax.swing.JLabel retour;
    private javax.swing.JLabel sem;
    private javax.swing.JLabel sem1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private javax.swing.JLabel textAll;
    private javax.swing.JLabel titre;
    private javax.swing.JLabel tri;
    private javax.swing.JLabel tri1;
    // End of variables declaration//GEN-END:variables

  

    private void afficheMois() {
        if(strMois.equals("01")){
           af.Tmois.setModel(new DefaultTableModel(new String []{"Janvier"},1));
        }
        if(strMois.equals("02"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Février"},1));
        if(strMois.equals("03"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Mars"},1));
        if(strMois.equals("04"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Avril"},1));
        if(strMois.equals("05"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Mai"},1));
        if(strMois.equals("06"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Juin"},1));
        if(strMois.equals("07"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Juillet"},1));
        if(strMois.equals("08"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Août"},1));
        if(strMois.equals("09"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Septembre"},1));
        if(strMois.equals("10"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Octobre"},1));
        if(strMois.equals("11"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Novembre"},1));
        if(strMois.equals("12"))
           af.Tmois.setModel(new DefaultTableModel(new String []{"Decembre"},1));
    }
    // condition pour semaine 5 et semaine 4 du mensuel
    private void conditionMois(){
       
    if(strMois.equals("01") || strMois.equals("04")|| strMois.equals("07")|| strMois.equals("10")){
         af.paneMois.setBounds(75, 145, 560, 20);
         fond.add(af.panes5);
         af.panes5.setVisible(true);
         //eto ni mois
         try{
        af.sem5.setModel(new DefaultTableModel(new String[]{"Semaine 5"},crud.afficheMensuel("Semaine 5").size())); 
        
             for(int i=0;i<=crud.afficheMensuel("Semaine 5").size();i++){
                 af.sem5.setValueAt(crud.afficheMensuel("Semaine 5").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
          
        }
    else{
        af.panes1.setBounds(75, 170, 139, 78);
            //*-*
            af.panes2.setBounds(219, 170, 142, 78);
            af.panes2.setBorder(null);
            //*-*
            af.panes3.setBounds(363, 170, 142, 78);
            af.panes3.setBorder(null);
            //*-*
            af.panes4.setBounds(507, 170, 140, 78);
            af.panes4.setBorder(null);
        af.paneMois.setBounds(75, 145, 570, 20);
        af.panes5.setVisible(false);
        try{
        af.sem4.setModel(new DefaultTableModel(new String[]{"Semaine 4"},crud.afficheMensuelCond().size())); 
        
             for(int i=0;i<=crud.afficheMensuelCond().size();i++){
                 af.sem4.setValueAt(crud.afficheMensuelCond().get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    }
    }
    private void TrimFalse(){
        //**************
        Bexp.setVisible(false);
        trimes.Pmois.setVisible(false);
        trimes.Pmois1.setVisible(false);
        trimes.Pmois2.setVisible(false);
      
        trimes.jScrollPane3.setVisible(false);
        trimes.jScrollPane1.setVisible(false);
        trimes.jScrollPane2.setVisible(false);
        trimes.jScrollPane4.setVisible(false);
        trimes.jScrollPane5.setVisible(false);
        trimes.jScrollPane6.setVisible(false);
        trimes.Pmois1.setVisible(false);
        trimes.Pmois2.setVisible(false);
        trimes.pmois2.setVisible(false);
        trimes.pmois22.setVisible(false);
        trimes.pmois3.setVisible(false);
        trimes.jScrollPane7.setVisible(false);
        trimes.pmois6.setVisible(false);
        trimes.PanMois2.setVisible(false);
        trimes.pmois23.setVisible(false);
       
       // trimes.pmois23.setVisible(false);
      //******************

       
    
    }
    private void SemFalse(){
      Bexp.setVisible(false);
      ta.Pmois.setVisible(false);
      ta.Pmois1.setVisible(false);
      ta.Pmois2.setVisible(false);
      ta.Pmois3.setVisible(false);
      ta.Pmois4.setVisible(false);
      ta.Pmois5.setVisible(false);
      ta.P1.setVisible(false);
      ta.P2.setVisible(false);
      ta.P3.setVisible(false);
      ta.P4.setVisible(false);
      ta.P5.setVisible(false);
      ta.P6.setVisible(false);
      ta.P7.setVisible(false);
      ta.P8.setVisible(false);
      ta.P9.setVisible(false);
      ta.P10.setVisible(false);
      ta.P11.setVisible(false);
      ta.P12.setVisible(false);
      ta.P13.setVisible(false);
      ta.P14.setVisible(false);
      ta.P15.setVisible(false);
      ta.P16.setVisible(false);
      ta.P17.setVisible(false);
      ta.P18.setVisible(false);
      ta.P19.setVisible(false);
      ta.P20.setVisible(false);
      ta.P21.setVisible(false);
      ta.P22.setVisible(false);
      ta.P23.setVisible(false);
      ta.P24.setVisible(false);
      ta.P25.setVisible(false);
      ta.P26.setVisible(false);
    }
    private void HebFalse(){
      
        af.paneL.setVisible(false);
        af.paneM.setVisible(false);
        af.paneM1.setVisible(false);
        af.paneJ.setVisible(false);
        af.paneV.setVisible(false);
        af.paneTaf.setVisible(false);
         af.panes5.setVisible(false);
          trimes.Ptmois15.setVisible(false);
        //******
       
    }
    private void JourFalse(){
     
        pane1.setVisible(false);
       // pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(false);
         af.panes5.setVisible(false);
         af.panes5.setVisible(false);
        af.paneL.setVisible(false);
        af.paneM.setVisible(false);
        af.paneM1.setVisible(false);
        af.paneJ.setVisible(false);
        af.paneV.setVisible(false);
        trimes.Ptmois15.setVisible(false);
        //af.paneTaf.setVisible(false);
    }
    private void MenFalse(){
       
        af.panes1.setVisible(false);
        af.panes2.setVisible(false);
        af.panes3.setVisible(false);
        af.panes4.setVisible(false);
        af.panes5.setVisible(false);
        af.paneMois.setVisible(false);
    }
    public void AfficheTmois() {
        if(strMois.equals("01") || strMois.equals("02") || strMois.equals("03") ){
        trimes.mois1.setModel(new DefaultTableModel(new String[]{"Janvier"},0));
        trimes.mois2.setModel(new DefaultTableModel(new String[]{"Fevrier"},0));
        trimes.mois3.setModel(new DefaultTableModel(new String[]{"Mars"},0));
        }
        if(strMois.equals("04") || strMois.equals("05") || strMois.equals("06") ){
        trimes.mois1.setModel(new DefaultTableModel(new String[]{"Avril"},0));
        trimes.mois2.setModel(new DefaultTableModel(new String[]{"Mai"},0));
        trimes.mois3.setModel(new DefaultTableModel(new String[]{"Juin"},0));
        }
        if(strMois.equals("07") || strMois.equals("08") || strMois.equals("09") ){
        trimes.mois1.setModel(new DefaultTableModel(new String[]{"Juillet"},0));
        trimes.mois2.setModel(new DefaultTableModel(new String[]{"Août"},0));
        trimes.mois3.setModel(new DefaultTableModel(new String[]{"Septembre"},0));
        }
        if(strMois.equals("10") || strMois.equals("11") || strMois.equals("12") ){
        trimes.mois1.setModel(new DefaultTableModel(new String[]{"Octobre"},0));
        trimes.mois2.setModel(new DefaultTableModel(new String[]{"Novembre"},0));
        trimes.mois3.setModel(new DefaultTableModel(new String[]{"Décembre"},0));
        }
        
        //***************
        if(strMois.equals("01")){
         trimes.Pmois.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
         ta.Pmois.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("02")){
            trimes.Pmois1.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
            ta.Pmois1.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
           }
        if(strMois.equals("03")){
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
          ta.Pmois2.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("04")){
          trimes.Pmois.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
          ta.Pmois3.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("05")){
          trimes.Pmois1.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
         ta.Pmois4.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("06")){
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
          ta.Pmois5.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
       if(strMois.equals("07")){
         trimes.Pmois.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
         ta.Pmois.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("08")){
            trimes.Pmois1.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
            ta.Pmois1.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
           }
        if(strMois.equals("09")){
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
          ta.Pmois2.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("10")){
          trimes.Pmois.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
          ta.Pmois3.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("11")){
          trimes.Pmois1.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
         ta.Pmois4.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
        if(strMois.equals("12")){
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
          ta.Pmois5.setBorder(javax.swing.BorderFactory.createLineBorder( new java.awt.Color(255, 0, 0), 2));
        }
    }


    private void pageHebdo() {
        try{
        af.Tlundi.setModel(new DefaultTableModel(new String[]{"Lundi"},5)); 
             for(int i=0;i<=crud.afficheJour("Lundi").size();i++){
                 af.Tlundi.setValueAt(crud.afficheJour("Lundi").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        
        try{
        af.Tmardi.setModel(new DefaultTableModel(new String[]{"Mardi"},5)); 
             for(int i=0;i<=crud.afficheJour("Mardi").size();i++){
                 af.Tmardi.setValueAt(crud.afficheJour("Mardi").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*************
        try{
        af.Tmercredi.setModel(new DefaultTableModel(new String[]{"Mercredi"},5)); 
             for(int i=0;i<=crud.afficheJour("Mercredi").size();i++){
                 af.Tmercredi.setValueAt(crud.afficheJour("Mercredi").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //**************
        try{
        af.Tjeudi.setModel(new DefaultTableModel(new String[]{"Jeudi"},5)); 
             for(int i=0;i<=crud.afficheJour("Jeudi").size();i++){
                 af.Tjeudi.setValueAt(crud.afficheJour("Jeudi").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //********
         try{
        af.Tvendredi.setModel(new DefaultTableModel(new String[]{"Vendredi"},5)); 
             for(int i=0;i<=crud.afficheJour("Vendredi").size();i++){
                 af.Tvendredi.setValueAt(crud.afficheJour("Vendredi").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
         table2.setValueAt("teeeeeeeee", 1, 0);
    }
    private void pageMensuel(){
    try{
        af.sem1.setModel(new DefaultTableModel(new String[]{"Semaine 1"},crud.afficheMensuel("Semaine 1").size())); 
        
             for(int i=0;i<=crud.afficheMensuel("Semaine 1").size();i++){
                 af.sem1.setValueAt(crud.afficheMensuel("Semaine 1").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    //****************
    try{
        af.sem2.setModel(new DefaultTableModel(new String[]{"Semaine 2"},crud.afficheMensuel("Semaine 2").size())); 
             for(int i=0;i<=crud.afficheMensuel("Semaine 2").size();i++){
                 af.sem2.setValueAt(crud.afficheMensuel("Semaine 2").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    //****************
    try{
        af.sem3.setModel(new DefaultTableModel(new String[]{"Semaine 3"},crud.afficheMensuel("Semaine 3").size())); 
             for(int i=0;i<=crud.afficheMensuel("Semaine 3").size();i++){
                 af.sem3.setValueAt(crud.afficheMensuel("Semaine 3").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    //**************** misy condition semaine 4 et 5
    try{
        af.sem4.setModel(new DefaultTableModel(new String[]{"Semaine 4"},crud.afficheMensuel("Semaine 4").size())); 
             for(int i=0;i<=crud.afficheMensuel("Semaine 4").size();i++){
                 af.sem4.setValueAt(crud.afficheMensuel("Semaine 4").get(i).getNomHeb(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    }

    private void affichePageTrim() {
        String type="Trimestre";
        //*******S1
        try{
        trimes.sem1.setModel(new DefaultTableModel(new String[]{"Semaine 1"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 1", type).size();i++){
                  trimes.sem1.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S2
        try{
        trimes.sem2.setModel(new DefaultTableModel(new String[]{"Semaine 2"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 1", type).size();i++){
                  trimes.sem2.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S3
        try{
        trimes.sem3.setModel(new DefaultTableModel(new String[]{"Semaine 3"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 1", type).size();i++){
                  trimes.sem3.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
       //*******S4
        try{
        trimes.sem4.setModel(new DefaultTableModel(new String[]{"Semaine 4"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 1", type).size();i++){
                  trimes.sem4.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S5
        try{
        trimes.sem4.setModel(new DefaultTableModel(new String[]{"Semaine 4"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 1", type).size();i++){
                  trimes.sem4.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******FIn mois 1
        //*******debut mois 2 S1
        try{
        trimes.sem12.setModel(new DefaultTableModel(new String[]{"Semaine 5"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 5", "Mois 1", type).size();i++){
                  trimes.sem12.setValueAt(crud.afficheS1M1("Semaine 5", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //**********S2
         try{
        trimes.sem5.setModel(new DefaultTableModel(new String[]{"Semaine 1"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 2", type).size();i++){
                  trimes.sem5.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        try{
        trimes.sem6.setModel(new DefaultTableModel(new String[]{"Semaine 2"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 2", type).size();i++){
                  trimes.sem6.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S3
        try{
        trimes.sem7.setModel(new DefaultTableModel(new String[]{"Semaine 3"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 2", type).size();i++){
                  trimes.sem7.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S4
        try{
        trimes.sem8.setModel(new DefaultTableModel(new String[]{"Semaine 4"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 2", type).size();i++){
                  trimes.sem8.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******Fin mois 2 
        //*******debut mois 3 S1
        try{
        trimes.sem9.setModel(new DefaultTableModel(new String[]{"Semaine 1"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 3", type).size();i++){
                  trimes.sem9.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //***********S2
        try{
        trimes.sem10.setModel(new DefaultTableModel(new String[]{"Semaine 2"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 3", type).size();i++){
                  trimes.sem10.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //******S3
         try{
        trimes.sem13.setModel(new DefaultTableModel(new String[]{"Semaine 3"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 3", type).size();i++){
                  trimes.sem13.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //******S4
          try{
        trimes.sem11.setModel(new DefaultTableModel(new String[]{"Semaine 4"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 3", type).size();i++){
                  trimes.sem11.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    }
    private ArrayList<Classe> AfficheNotif(){
        ArrayList<Classe> list = new ArrayList<Classe>();
        Classe data;
        if(strMois.equals("01")||strMois.equals("07")){
            for(int i=0;i<crud.afficheNotif("Mois 1").size();i++){
                data = new Classe(crud.afficheNotif("Mois 1").get(i).getNomTri());
                list.add(data);
            }
        }
        //******
        if(strMois.equals("02")||strMois.equals("08")){
            for(int i=0;i<crud.afficheNotif("Mois 2").size();i++){
                data = new Classe(crud.afficheNotif("Mois 2").get(i).getNomTri());
                list.add(data);
            }
        }
        //******
        if(strMois.equals("03")||strMois.equals("09")){
            for(int i=0;i<crud.afficheNotif("Mois 3").size();i++){
                data = new Classe(crud.afficheNotif("Mois 3").get(i).getNomTri());
                list.add(data);
            }
        }
        //******
        if(strMois.equals("04")||strMois.equals("10")){
            for(int i=0;i<crud.afficheNotif("Mois 4").size();i++){
                data = new Classe(crud.afficheNotif("Mois 4").get(i).getNomTri());
                list.add(data);}
             for(int i=0;i<crud.afficheNotif("Mois 1").size();i++){
                data = new Classe(crud.afficheNotif("Mois 1").get(i).getNomTri());
                list.add(data);
            }
        }
        //******
        if(strMois.equals("05")||strMois.equals("11")){
            for(int i=0;i<crud.afficheNotif("Mois 5").size();i++){
                data = new Classe(crud.afficheNotif("Mois 5").get(i).getNomTri());
                list.add(data);}
             for(int i=0;i<crud.afficheNotif("Mois 2").size();i++){
                data = new Classe(crud.afficheNotif("Mois 2").get(i).getNomTri());
                list.add(data);
            }
        }
        if(strMois.equals("06")||strMois.equals("12")){
            for(int i=0;i<crud.afficheNotif("Mois 6").size();i++){
                data = new Classe(crud.afficheNotif("Mois 6").get(i).getNomTri());
                list.add(data);}
             for(int i=0;i<crud.afficheNotif("Mois 3").size();i++){
                data = new Classe(crud.afficheNotif("Mois 3").get(i).getNomTri());
                list.add(data);
            }
        }
        for(int i=0;i<crud.afficheMensuel().size();i++){
                data = new Classe(crud.afficheMensuel().get(i).getNomHeb());
                list.add(data);
        }
        return list;
    }
    private void affichePageSem() {
        String type="Semestre";
        int n;
        
        //*******S1
        try{
            if(crud.afficheS1M1("Semaine 1", "Mois 1", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 1", "Mois 1", type).size();
        ta.S1.setModel(new DefaultTableModel(new String[]{"Semaine 1"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 1", type).size();i++){
                  ta.S1.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S2
        try{
            if(crud.afficheS1M1("Semaine 2", "Mois 1", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 2", "Mois 1", type).size();
        ta.S2.setModel(new DefaultTableModel(new String[]{"Semaine 2"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 1", type).size();i++){
                  ta.S2.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S3
        try{
            if(crud.afficheS1M1("Semaine 3", "Mois 1", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 3", "Mois 1", type).size();
        ta.S3.setModel(new DefaultTableModel(new String[]{"Semaine 3"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 1", type).size();i++){
                  ta.S3.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
       //*******S4
        try{
            if(crud.afficheS1M1("Semaine 4", "Mois 1", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 4", "Mois 1", type).size();
        ta.S4.setModel(new DefaultTableModel(new String[]{"Semaine 4"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 1", type).size();i++){
                  ta.S4.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S5
        try{
            if(crud.afficheS1M1("Semaine 5", "Mois 1", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 5", "Mois 1", type).size();
        ta.S5.setModel(new DefaultTableModel(new String[]{"Semaine 5"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 5", "Mois 1", type).size();i++){
                  ta.S5.setValueAt(crud.afficheS1M1("Semaine 5", "Mois 1", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******FIn mois 1
        //*******debut mois 2 S1
        try{
            if(crud.afficheS1M1("Semaine 1", "Mois 2", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 1", "Mois 2", type).size();
        ta.S6.setModel(new DefaultTableModel(new String[]{"Semaine 1"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 2", type).size();i++){
                  ta.S6.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //**********S2
         try{
             if(crud.afficheS1M1("Semaine 2", "Mois 2", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 2", "Mois 2", type).size();
        ta.S7.setModel(new DefaultTableModel(new String[]{"Semaine 2"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 2", type).size();i++){
                  ta.S7.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        try{
            if(crud.afficheS1M1("Semaine 3", "Mois 3", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 3", "Mois 3", type).size();
        ta.S8.setModel(new DefaultTableModel(new String[]{"Semaine 3"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 2", type).size();i++){
                  ta.S8.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S3
        try{
            if(crud.afficheS1M1("Semaine 4", "Mois 2", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 4", "Mois 2", type).size();
       ta.S9.setModel(new DefaultTableModel(new String[]{"Semaine 4"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 2", type).size();i++){
                  ta.S9.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 2", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******Fin mois 2 
        //*******debut mois 3 S1
        try{
            if(crud.afficheS1M1("Semaine 1", "Mois 3", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 1", "Mois 3", type).size();
       ta.S10.setModel(new DefaultTableModel(new String[]{"Semaine 1"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 3", type).size();i++){
                  ta.S10.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //***********S2
        try{
            if(crud.afficheS1M1("Semaine 2", "Mois 3", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 2", "Mois 3", type).size();
        ta.S11.setModel(new DefaultTableModel(new String[]{"Semaine 2"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 3", type).size();i++){
                  ta.S11.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //******S3
         try{
             if(crud.afficheS1M1("Semaine 3", "Mois 3", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 3", "Mois 3", type).size();
         ta.S12.setModel(new DefaultTableModel(new String[]{"Semaine 3"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 3", type).size();i++){
                  ta.S12.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //******S4
          try{
              if(crud.afficheS1M1("Semaine 4", "Mois 3", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 4", "Mois 3", type).size();
         ta.S13.setModel(new DefaultTableModel(new String[]{"Semaine 4"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 3", type).size();i++){
                  ta.S13.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 3", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    
    //****************
    
    
     try{
        if(crud.afficheS1M1("Semaine 1", "Mois 4", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 1", "Mois 4", type).size();
        ta.S14.setModel(new DefaultTableModel(new String[]{"Semaine 1"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 4", type).size();i++){
                  ta.S14.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 4", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S2
        try{
            if(crud.afficheS1M1("Semaine 2", "Mois 4", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 2", "Mois 4", type).size();
        ta.S15.setModel(new DefaultTableModel(new String[]{"Semaine 2"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 4", type).size();i++){
                  ta.S15.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 4", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S3
        try{
            if(crud.afficheS1M1("Semaine 3", "Mois 4", type).size()<4)
            n=4;
             else
            n=crud.afficheS1M1("Semaine 3", "Mois 4", type).size();
        ta.S16.setModel(new DefaultTableModel(new String[]{"Semaine 3"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 4", type).size();i++){
                  ta.S16.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 4", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
       //*******S4
        try{
            if(crud.afficheS1M1("Semaine 4", "Mois 4", type).size()<4)
            n=4;
            else
            n=crud.afficheS1M1("Semaine 4", "Mois 4", type).size();
        ta.S17.setModel(new DefaultTableModel(new String[]{"Semaine 4"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 4", type).size();i++){
                  ta.S17.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 4", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S5
        try{
            if(crud.afficheS1M1("Semaine 5", "Mois 4", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 5", "Mois 4", type).size();
        ta.S18.setModel(new DefaultTableModel(new String[]{"Semaine 5"},4)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 5", "Mois 4", type).size();i++){
                  ta.S18.setValueAt(crud.afficheS1M1("Semaine 5", "Mois 4", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******FIn mois 4
        //*******debut mois 52 S1
        try{
            if(crud.afficheS1M1("Semaine 1", "Mois 5", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 1", "Mois 5", type).size();
        ta.S19.setModel(new DefaultTableModel(new String[]{"Semaine 1"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 5", type).size();i++){
                  ta.S19.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 5", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //**********S2
         try{
             if(crud.afficheS1M1("Semaine 2", "Mois 5", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 2", "Mois 5", type).size();
        ta.S20.setModel(new DefaultTableModel(new String[]{"Semaine 2"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 5", type).size();i++){
                  ta.S20.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 5", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        try{
            if(crud.afficheS1M1("Semaine 3", "Mois 5", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 3", "Mois 5", type).size();
        ta.S21.setModel(new DefaultTableModel(new String[]{"Semaine 3"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 5", type).size();i++){
                  ta.S21.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 5", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******S3
        try{
            if(crud.afficheS1M1("Semaine 4", "Mois 5", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 4", "Mois 5", type).size();
       ta.S22.setModel(new DefaultTableModel(new String[]{"Semaine 4"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 5", type).size();i++){
                  ta.S22.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 5", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //*******Fin mois 5 
        //*******debut mois 6 S1
        try{
            if(crud.afficheS1M1("Semaine 1", "Mois 6", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 1", "Mois 6", type).size();
       ta.S23.setModel(new DefaultTableModel(new String[]{"Semaine 1"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 1", "Mois 6", type).size();i++){
                  ta.S23.setValueAt(crud.afficheS1M1("Semaine 1", "Mois 6", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //***********S2
        try{
            if(crud.afficheS1M1("Semaine 2", "Mois 6", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 2", "Mois 6", type).size();
        ta.S24.setModel(new DefaultTableModel(new String[]{"Semaine 2"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 2", "Mois 6", type).size();i++){
                  ta.S24.setValueAt(crud.afficheS1M1("Semaine 2", "Mois 6", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //******S3
         try{
             if(crud.afficheS1M1("Semaine 3", "Mois 6", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 3", "Mois 6", type).size();
         ta.S25.setModel(new DefaultTableModel(new String[]{"Semaine 3"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 3", "Mois 6", type).size();i++){
                  ta.S25.setValueAt(crud.afficheS1M1("Semaine 3", "Mois 6", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
        //******S4
          try{
              if(crud.afficheS1M1("Semaine 4", "Mois 6", type).size()<4)
            n=4;
        else
            n=crud.afficheS1M1("Semaine 4", "Mois 6", type).size();
         ta.S26.setModel(new DefaultTableModel(new String[]{"Semaine 4"},n)); 
        
             for(int i=0;i<=crud.afficheS1M1("Semaine 4", "Mois 6", type).size();i++){
                  ta.S26.setValueAt(crud.afficheS1M1("Semaine 4", "Mois 6", type).get(i).getNomTri(), i, 0);}}
     catch(Exception e){System.out.println(e.getMessage());}
    

}
     public void AfficheTmoisSem() {
        if(strMois.equals("01") || strMois.equals("02") || strMois.equals("03")||strMois.equals("04") || strMois.equals("05") || strMois.equals("06") ){
        ta.mois1.setModel(new DefaultTableModel(new String[]{"Janvier"},0));
        ta.mois2.setModel(new DefaultTableModel(new String[]{"Fevrier"},0));
        ta.mois3.setModel(new DefaultTableModel(new String[]{"Mars"},0));
        ta.mois4.setModel(new DefaultTableModel(new String[]{"Avril"},0));
        ta.mois5.setModel(new DefaultTableModel(new String[]{"Mai"},0));
        ta.mois6.setModel(new DefaultTableModel(new String[]{"Juin"},0));
        }
       if(strMois.equals("07") || strMois.equals("08") || strMois.equals("09")||strMois.equals("10") || strMois.equals("11") || strMois.equals("12") ){
       
        ta.mois1.setModel(new DefaultTableModel(new String[]{"Juillet"},0));
        ta.mois2.setModel(new DefaultTableModel(new String[]{"Août"},0));
        ta.mois3.setModel(new DefaultTableModel(new String[]{"Septembre"},0));
        ta.mois4.setModel(new DefaultTableModel(new String[]{"Octobre"},0));
        ta.mois5.setModel(new DefaultTableModel(new String[]{"Novembre"},0));
        ta.mois6.setModel(new DefaultTableModel(new String[]{"Décembre"},0));
        }
        
        //***************
        if(strMois.equals("01")){
         trimes.Pmois.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        }
        if(strMois.equals("02")){
            trimes.Pmois1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
           }
        if(strMois.equals("03"))
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("04"))
          trimes.Pmois.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("05"))
          trimes.Pmois1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("06"))
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("07"))
           trimes.Pmois.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("08"))
          trimes.Pmois1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("09"))
          trimes.Pmois2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0))); 
        if(strMois.equals("10"))
          trimes.Pmois.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        if(strMois.equals("11"))
          trimes.Pmois1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0))); 
        if(strMois.equals("12"))
            trimes.Pmois2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
          trimes.mois1.setForeground(Color.red); 
            
    }
     public void afficheAnnuel(JTable table)
     { 
         int size = crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size() + crud.afficheToutMen("mensuel").size() + crud.afficheToutTri("Trimestre").size() + crud.afficheToutTri("Semestre").size();
         table.setModel(new DefaultTableModel(new String[]{"Equipement","Type","Jour","Semaine 1","Mois"},size));
         int j = 0;
         try{
         
         int n = crud.afficheContact("journalier").size() + crud.afficheAllHebdo("hebdomadaire").size();
         for(int i = 0; i<=crud.afficheContact("journalier").size();i++)
         {
         table.setValueAt(crud.afficheContact("journalier").get(i).getNomJour(), i, 0);
         table.setValueAt("Journalier", i, 1);
         table.setValueAt("-----", i, 2);
         table.setValueAt("-----", i, 3);
         table.setValueAt("-----", i, 4);
        
         }
         }
         catch(Exception e){}
         try{
         j = 0;
         for(int i = crud.afficheContact("journalier").size(); i<crud.afficheToutMen("hebdomadaire").size()+crud.afficheContact("journalier").size();i++)
         {
              //JOptionPane.showMessageDialog(null, crud.afficheToutMen("hebdomadaire").get(j).getNomHeb());
         table.setValueAt(crud.afficheToutMen("hebdomadaire").get(j).getNomHeb(), i, 0);
         table.setValueAt("Hebdomadaire", i, 1);
         table.setValueAt("-----", i, 3);
         table.setValueAt(crud.afficheToutMen("hebdomadaire").get(j).getJour(), i, 2);
         table.setValueAt("-----", i, 4);
         j++;
        
         }
     }
         catch(Exception e){}
         //*******
         try{
         j = 0;
         
         for(int i = crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size(); i<crud.afficheContact("journalier").size() + crud.afficheToutMen("mensuel").size()+crud.afficheToutMen("hebdomadaire").size();i++)
         {
              //JOptionPane.showMessageDialog(null, crud.afficheToutMen("hebdomadaire").get(j).getNomHeb());
         table.setValueAt(crud.afficheToutMen("mensuel").get(j).getNomHeb(), i, 0);
         table.setValueAt("mensuel", i, 1);
         table.setValueAt("-----", i, 2);
         table.setValueAt(crud.afficheToutMen("mensuel").get(j).getJour(), i, 3);
         table.setValueAt("-----", i, 4);
         j++;
        
         }
     }
         catch(Exception e){}
         try{
         j = 0;
         
         for(int i = crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size() + crud.afficheToutMen("mensuel").size() ; i<crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size() + crud.afficheToutMen("mensuel").size() +crud.afficheToutTri("Trimestre").size();i++)
         {
              //JOptionPane.showMessageDialog(null, crud.afficheToutMen("hebdomadaire").get(j).getNomHeb());
         table.setValueAt(crud.afficheToutTri("Trimestre").get(j).getNomTri(), i, 0);
         table.setValueAt("Trimestre", i, 1);
         table.setValueAt("-----", i, 2);
         table.setValueAt(crud.afficheToutTri("Trimestre").get(j).getSemaine(), i, 3);
         table.setValueAt(crud.afficheToutTri("Trimestre").get(j).getMois(), i, 4);
         j++;
        
         }
     }
         catch(Exception e){}
         //*************
         try{
         j = 0;
         
         for(int i = crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size() + crud.afficheToutMen("mensuel").size() + crud.afficheToutTri("Trimestre").size() ; i<crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size() + crud.afficheToutMen("mensuel").size() + crud.afficheToutTri("Trimestre").size() + crud.afficheToutTri("Semestre").size();i++)
         {
              //JOptionPane.showMessageDialog(null, crud.afficheToutMen("hebdomadaire").get(j).getNomHeb());
         table.setValueAt(crud.afficheToutTri("Semestre").get(j).getNomTri(), i, 0);
         table.setValueAt("Semestre", i, 1);
         table.setValueAt("-----", i, 2);
         table.setValueAt(crud.afficheToutTri("Semestre").get(j).getSemaine(), i, 3);
         table.setValueAt(crud.afficheToutTri("Semestre").get(j).getMois(), i, 4);
         j++;
        
         }
     }
         catch(Exception e){JOptionPane.showMessageDialog(this," eto le erreur "+ e.getMessage());}
      
}
    private void notesAffiche(){
     try{
            
        table4.setModel(new DefaultTableModel(new String[]{"Date","Equipement"},crud.afficheNotes().size())); 
    
             for(int i=0;i<=crud.afficheNotes().size();i++){
                 table4.setValueAt(crud.afficheNotes().get(i).getDat(), i, 0);
                 table4.setValueAt(crud.afficheNotes().get(i).getEquipemnt(), i, 1);
                 
             }
        }
     catch(Exception e){System.out.println(e.getMessage());}
        
     }
}
