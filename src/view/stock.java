/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


import classe.Materiel;
import com.caucho.hessian.client.HessianProxyFactory;
import controler.Database;
import controler.IDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
/**
 *
 * @author Snow
 */

public class stock  extends JFrame implements ActionListener,MouseListener{
 Connection connex;
 Statement etat; 
 StringBuffer sql;
 ResultSet res;
 
 int xMouse, yMouse;
 
// Database d= new Database();
 TestPersonnel tstpers= new TestPersonnel();
 
 String valnompers;
 String Dannee;
  // appel de tous les instances
  retirer r = new retirer();      
  stock2 u= new stock2();
  stock3 s3= new stock3();
  Bilan b = new Bilan();
  Btab2 b2 = new Btab2();
  Btab3 b3 = new Btab3();
  MessErreur m= new MessErreur();
  MessVrai m2= new MessVrai();
  private IDatabase d = null;
  static private String hoteDist = "http://DESKTOP-VLD2HGD:8080/appView/rpc";  //DESKTOP-VLD2HGD
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

  
    public stock(){
        initComponents();
        //  crud = new Database() ;
        d = getConnection(hoteDist);
        Tquantite.setText("0");
        u.Tquantite2.setText("0");
        r.Tquantite3.setText("0");
        Afficher();
        ChoixPers();
        ChoixRetirer();
        Choix();
        ChoixAnnee();
        
        LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-nouveau.jpg"))); 
       LFpasse1.setBounds(370,35,151,50);
        
        FbuttonT.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        FbuttonT.setBounds(850,410,16, 16);
        FbuttonT.setVisible(true);
        
        // Prendre annee corant
        Date date=new Date();
        DateFormat Danne = new SimpleDateFormat("YYYY");
        Dannee = Danne.format(date);
        
        
       r.Butiliser3.addActionListener(this);  
       r.Bnouveau3.addActionListener(this);   
    }
    
 /*    public void connexionBase (){
        sql=new StringBuffer();
        connex=null;    etat=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           connex=DriverManager.getConnection("jdbc:mysql://localhost/asecna","root","");
           etat=connex.createStatement();
        }
          catch (ClassNotFoundException e){
              JOptionPane.showMessageDialog(this,"Pilote non configure");
          }
              catch(SQLException e){
                 JOptionPane.showMessageDialog(this,"Base de donne introuvables"); 
              }
        }
   */ 
public void enregistrer (){          /// ********************* passe par  Database
    //     connexionBase();
         int v = Integer.valueOf(Tquantite.getText().toString());
         if (Tnom.getText().equals("") ||
                 Tdate.getText().equals("") ||
                 Tquantite.getText().equals("") ||
                 Templacement.getText().equals("") ||
                 Ttype.getText().equals("") )
         {
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText("Remplissez les zones de saisie");
         }
         else 
         if (v <= 0 ){
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Entrée un nombre positif ");
         }
         
         else
         {
             ///  **************************      ici  ici
             m2.setVisible(true);
             m2.ErreurTexte.setVisible(true);
              
             m2.ErreurTexte.setText(" Matériels inserer ");
             Materiel m =new Materiel(Tnom.getText(),Tdate.getText(), Tquantite.getText(),Templacement.getText(),Ttype.getText(), valnompers);            
             d.EnregistrerMateriel(m.getNom(), m.getDate(), m.getSquantite(), m.getEmplacement(), m.getType(), m.getId_pers());
             
             Materiel mm =new Materiel(Tnom.getText(), Dannee, Tquantite.getText());       
             d.EnregistrerTotalEntrer(mm.getNom(), mm.getDate(), mm.getSquantite());
           //  System.out.println("mande le izy");
        }
     }

    
public void enregistrer2 (){            /// ********************* passe par Database
        m2.setVisible(true);
        m2.ErreurTexte.setVisible(true);
        m2.ErreurTexte.setText(" Matériels mis en service ");
//         connexionBase();
        Materiel m =new Materiel((String) u.Tnom2.getSelectedItem(),u.Tdatedebut2.getText(), u.Tquantite2.getText(),u.Tcommentaire2.getText(), valnompers);
        d.Enregistrerutiliser(m.getNom(), m.getDate(), m.getSquantite(), m.getCommentaire(), m.getId_pers());
        
        Materiel mm =new Materiel(Tnom.getText(), Dannee, Tquantite.getText());      // 
        d.EnregistrerTotalUtiliser(mm.getNom(), mm.getDate(), mm.getSquantite());
         
     }

public void TestQ()             /// ************************   passe par Database
{
//    connexionBase();
    int v = Integer.valueOf(u.Tquantite2.getText());
/*    JOptionPane.showMessageDialog(this, v);
    
    for(int i=0;i<=d.TestQuestion1().size();i++){  
     int a = Integer.valueOf(u.Tquantite2.getText().toString());
     
         JOptionPane.showMessageDialog(this, d.TestQuestion1().get(i).getId_pers());
         JOptionPane.showMessageDialog(this,d.TestQuestion1().get(i).getNom());    
         JOptionPane.showMessageDialog(this,d.TestQuestion1().get(i).getDate());
         JOptionPane.showMessageDialog(this,d.TestQuestion1().get(i).getSquantite()); 
    }
 */   
  //  int k= d.TestQuestion1().get(i).getSquantite();
try{
   if (
                 u.Tdatedebut2.getText().equals("") ||
                 u.Tquantite2.getText().equals("") ||
                 u.Tdateenregistrement2.getText().equals("") ||
                 u.Tcommentaire2.getText().equals("") ){
       
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Remplissez les zones de saisie ");
             }else 
         if (v <= 0 ){
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Entrée un nombre positif ");
         }
         
   else{
   
    for(int i=0;i<=d.TestQuestion1().size();i++){
        
     int a = Integer.valueOf(u.Tquantite2.getText().toString());
     if (d.TestQuestion1().get(i).getId_pers().equals(u.Tident.getText())){
     if (d.TestQuestion1().get(i).getNom().equals(u.Tnom2.getSelectedItem())){
         if ( d.TestQuestion1().get(i).getDate().equals(u.Tdateenregistrement2.getText())) {
             if ( a > Integer.valueOf(d.TestQuestion1().get(i).getSquantite())||  0 >= a )
         {
           //  System.out.println(d.TestQuestion1().get(i).getSquantite());
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Saisez un nombre entre 0 et " + d.TestQuestion1().get(i).getSquantite());
             break;
                
        }else 
         { 
             int q2 =  Integer.valueOf(d.TestQuestion1().get(i).getSquantite());
             int q = q2 - a;
             String name = u.Tnom2.getSelectedItem().toString();
             
             enregistrer2();                                                        //   methode interaction avec Database
             Materiel m=new Materiel(q,name,u.Tdateenregistrement2.getText());      
             d.Effacer1(m.getNombre(), m.getNom(), m.getDate());                    // ******* ici   ici                       //effacer (q,name,u.Tdateenregistrement2.getText() );
       
      //    JOptionPane.showMessageDialog(this, "traitement "+ i);
          break;
         }
     
     }else{
     m.setVisible(true);
     m.ErreurTexte.setVisible(true);
     m.ErreurTexte.setText(" Date ne correspond pas enrégistrement ");    
     break;   
     }
     }      
   // erreur valeur si n'existe pas
}
}
   }
   
}

catch (Exception e){
   System.out.println(e);
    JOptionPane.showMessageDialog(this,"eto io erreur io "+ e); 
}
    
}

public void enregistrercorbeille (){                   // ********** passe par Database
//         connexionBase();
        m2.setVisible(true);
        m2.ErreurTexte.setVisible(true);
        m2.ErreurTexte.setText(" Matériels mis en corbeille ");
        
         Materiel m = new Materiel((String) r.Tnom3.getSelectedItem(), r.Tdatefin3.getText(), r.Tquantite3.getText(),valnompers);
         d.Enregistrercorbeille(m.getNom(), m.getDate(), m.getSquantite(), m.getId_pers());
     
   //      Materiel m1 =new Materiel((String)r.Tnom3.getSelectedItem(), Dannee, r.Tquantite3.getValue());      // Passe par database
   //      d.EnregistrerTotalStock(m1.getNom(), m1.getDate(), m1.getQuantite());                            // Bilan donne inutilisable
      
}

public void enregistrerreutilisable (){         //*******  passe  par  Database
//    connexionBase();
    m2.setVisible(true);
    m2.ErreurTexte.setVisible(true);
    m2.ErreurTexte.setText(" Matériels reincérer dans stock ");
         
    Materiel m = new Materiel((String)r.Tnom3.getSelectedItem(),r.Tdatefin3.getText(),r.Tquantite3.getText(), (String) r.Tetat3.getSelectedItem(),r.Templacement3.getText(), r.Ttype3.getText(),valnompers);//((String)r.Tnom3.getSelectedItem(),r.Tdatefin3.getText(),r.Tquantite3.getValue(), (String) r.Tetat3.getSelectedItem(),r.Templacement3.getText(),(String)r.Tpersonnel3.getSelectedItem());
    d.Enregisterreutilisable(m.getNom(), m.getDate(), m.getSquantite(), m.getEtat(), m.getEmplacement(), m.getType(), m.getId_pers());

//    Materiel m2 =new Materiel((String)r.Tnom3.getSelectedItem(), Dannee, r.Tquantite3.getValue());      // Passe par database
//    d.EnregistrerTotalStockReutilisable(m2.getNom(), m2.getDate(), m2.getQuantite());                 // Bilan donne reurilisable
      
}
 
public void testevide2(){
    int v=Integer.valueOf(r.Tquantite3.getText().toString());
if (r.Tdatedebut3.getText().equals("") ||
                 r.Tdatefin3.getText().equals("") ||
                 r.Tquantite3.getText().equals("") ||
                 r.Templacement3.getText().equals("") ||
                 r.Ttype3.getText().equals("") ){
                 
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Remplissez les zones de saisie ");
             
         }else 
         if (v <= 0 ){
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Entrée un nombre positif ");
         }
             
}
public void TestQ2()        /// ************************** passe par Database
{
//    connexionBase();
    testevide2();
    
 /*   for(int i=0;i<=d.TestQuestion1().size();i++){  
     int a = Integer.valueOf(u.Tquantite2.getText().toString());
     
         JOptionPane.showMessageDialog(this, d.TestQuestion2().get(i).getId_pers());
         JOptionPane.showMessageDialog(this,d.TestQuestion2().get(i).getNom());    
         JOptionPane.showMessageDialog(this,d.TestQuestion2().get(i).getDate());
         JOptionPane.showMessageDialog(this,d.TestQuestion2().get(i).getSquantite()); 
    }
*/
    try{
    for(int i=0;i<=d.TestQuestion2().size();i++){
     int a = Integer.valueOf(r.Tquantite3.getText().toString());
     if (d.TestQuestion2().get(i).getId_pers().equals(r.Tident3.getText())){
     if (d.TestQuestion2().get(i).getNom().equals(r.Tnom3.getSelectedItem())){
         if (d.TestQuestion2().get(i).getDate().equals(r.Tdatedebut3.getText())) {
             if ( a > Integer.valueOf(d.TestQuestion2().get(i).getSquantite()) ||  0 >= a )
         {
             m.setVisible(true);
             m.ErreurTexte.setVisible(true);
             m.ErreurTexte.setText(" Saisez un nombre entre 0 et " + d.TestQuestion2().get(i).getSquantite());
             break;
        }else 
         {
             int q2 = Integer.valueOf(d.TestQuestion2().get(i).getSquantite());
             int q = q2 - a;
             String name = r.Tnom3.getSelectedItem().toString();
             if(r.Tetat3.getSelectedItem()== "Reutilisable")
             {
                 
             enregistrerreutilisable();                                          //******** methode interagie avec Database
             Materiel m=new Materiel(q,name,r.Tdatedebut3.getText());      //**** passe par Database   
             d.Effacer2(m.getNombre(), m.getNom(), m.getDate());
                 
             }else if (r.Tetat3.getSelectedItem()== "Inutilisable")
             {
             enregistrercorbeille();                                                 //******* methode interagie avec Database
             Materiel m=new Materiel(q,name,r.Tdatedebut3.getText());      //***** passe par Database
             d.Effacer2(m.getNombre(), m.getNom(), m.getDate());  
   
         }
      }       
         }
     m.setVisible(true);
     m.ErreurTexte.setVisible(true);
     m.ErreurTexte.setText(" Date ne correspond pas enregistrement ");    
     break;
     }
     }
}
}
catch (Exception e){
    
}
    
}


/// *************************************           AFFICHAGE ALL               ******************************************* ///

   public void Afficher(){
       try{
           JTable.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Etat","Emplacement","Type","Personnel"},d.AfficherMateriel().size()));
           b.Ttable.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Etat","Emplacement","Type","Personnel"},d.AfficherMateriel().size()));
           u.JTable2.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Etat","Emplacement","Type","Personnel"},d.AfficherMateriel().size()));
           for(int i=0;i<=d.AfficherMateriel().size();i++){
                JTable.setValueAt (d.AfficherMateriel().get(i).getId_mat(),i,0);  
                JTable.setValueAt (d.AfficherMateriel().get(i).getNom(),i,1);
                JTable.setValueAt (d.AfficherMateriel().get(i).getDate(),i,2);
                JTable.setValueAt (d.AfficherMateriel().get(i).getSquantite(),i,3);
                JTable.setValueAt (d.AfficherMateriel().get(i).getEtat(),i,4);
                JTable.setValueAt (d.AfficherMateriel().get(i).getEmplacement(),i,5);
                JTable.setValueAt (d.AfficherMateriel().get(i).getType(),i,6);
                JTable.setValueAt (d.AfficherMateriel().get(i).getId_pers(),i,7);
                
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getId_mat(),i,0);  
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getNom(),i,1);
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getDate(),i,2);
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getSquantite(),i,3);
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getEtat(),i,4);
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getEmplacement(),i,5);
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getType(),i,6);
                u.JTable2.setValueAt (d.AfficherMateriel().get(i).getId_pers(),i,7);

                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getId_mat(),i,0);  
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getNom(),i,1);
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getDate(),i,2);
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getSquantite(),i,3);
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getEtat(),i,4);
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getEmplacement(),i,5);
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getType(),i,6);
                b.Ttable.setValueAt (d.AfficherMateriel().get(i).getId_pers(),i,7);
            } 
            }catch(Exception e){
           //         JOptionPane.showMessageDialog(null,"afficher matériel " + e.getMessage());
            }
}
   
   public void AfficherCorbeille(){
    try{
         s3.JTable4.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Personnel"},d.AfficherCorbeille().size()));
         b3.Ttable3.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Personnel"},d.AfficherCorbeille().size()));
            for(int i=0;i<=d.AfficherCorbeille().size();i++){
                s3.JTable4.setValueAt (d.AfficherCorbeille().get(i).getId_mat(),i,0);  
                s3.JTable4.setValueAt (d.AfficherCorbeille().get(i).getNom(),i,1);
                s3.JTable4.setValueAt (d.AfficherCorbeille().get(i).getDate(),i,2);
                s3.JTable4.setValueAt (d.AfficherCorbeille().get(i).getSquantite(),i,3);
                s3.JTable4.setValueAt (d.AfficherCorbeille().get(i).getId_pers(),i,4);
                
                b3.Ttable3.setValueAt (d.AfficherCorbeille().get(i).getId_mat(),i,0);  
                b3.Ttable3.setValueAt (d.AfficherCorbeille().get(i).getNom(),i,1);
                b3.Ttable3.setValueAt (d.AfficherCorbeille().get(i).getDate(),i,2);
                b3.Ttable3.setValueAt (d.AfficherCorbeille().get(i).getSquantite(),i,3);
                b3.Ttable3.setValueAt (d.AfficherCorbeille().get(i).getId_pers(),i,4);
            }   
            }catch(Exception e){
             //  JOptionPane.showMessageDialog(null,"Afficher corbeille"+  e.getMessage());     
            }
  }


   public void AfficherUtiliser(){
   try{
       
            r.JTable3.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Commentaire","Personnel"},d.AfficherUtiliser().size()));
            b2.Ttable2.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Commentaire","Personnel"},d.AfficherUtiliser().size()));
            for(int i=0;i<=d.AfficherUtiliser().size();i++){
                r.JTable3.setValueAt (d.AfficherUtiliser().get(i).getId_mat(),i,0);  
                r.JTable3.setValueAt (d.AfficherUtiliser().get(i).getNom(),i,1);
                r.JTable3.setValueAt (d.AfficherUtiliser().get(i).getDate(),i,2);
                r.JTable3.setValueAt (d.AfficherUtiliser().get(i).getSquantite(),i,3);
                r.JTable3.setValueAt (d.AfficherUtiliser().get(i).getCommentaire(),i,4);
                r.JTable3.setValueAt (d.AfficherUtiliser().get(i).getId_pers(),i,5);   
                
                b2.Ttable2.setValueAt (d.AfficherUtiliser().get(i).getId_mat(),i,0);
                b2.Ttable2.setValueAt (d.AfficherUtiliser().get(i).getNom(),i,1);  
                b2.Ttable2.setValueAt (d.AfficherUtiliser().get(i).getDate(),i,2);
                b2.Ttable2.setValueAt (d.AfficherUtiliser().get(i).getSquantite(),i,3);
                b2.Ttable2.setValueAt (d.AfficherUtiliser().get(i).getCommentaire(),i,4);
                b2.Ttable2.setValueAt (d.AfficherUtiliser().get(i).getId_pers(),i,5);
            }   
            }catch(Exception e){
           //   JOptionPane.showMessageDialog(null,"Afficher utiliser"+  e.getMessage());      
            }
   }
   
   public void AfficherGroupeMateriel(){
          try{
           b.Ttable.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Etat","Emplacement","Type","Personnel"},d.AfficherMaterielGroupe().size()));
            for(int i=0;i<=d.AfficherMaterielGroupe().size();i++){
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getId_mat(),i,0);  
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getNom(),i,1);
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getDate(),i,2);
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getSquantite(),i,3);
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getEtat(),i,4);
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getEmplacement(),i,5);
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getType(),i,6);
                b.Ttable.setValueAt (d.AfficherMaterielGroupe().get(i).getId_pers(),i,7);
            }
            
   }catch(Exception e){
 //   JOptionPane.showMessageDialog(null,"Afficher materiel groupe"+  e.getMessage());                        
   }
   }
   
   public void AfficherGroupeUtiliser(){
   try{
           b2.Ttable2.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Commentaire","Personnel"},d.AfficherUtiliserGroupe().size()));
            for(int i=0;i<=d.AfficherUtiliserGroupe().size();i++){
                b2.Ttable2.setValueAt (d.AfficherUtiliserGroupe().get(i).getId_mat(),i,0);
                b2.Ttable2.setValueAt (d.AfficherUtiliserGroupe().get(i).getNom(),i,1);  
                b2.Ttable2.setValueAt (d.AfficherUtiliserGroupe().get(i).getDate(),i,2);
                b2.Ttable2.setValueAt (d.AfficherUtiliserGroupe().get(i).getSquantite(),i,3);
                b2.Ttable2.setValueAt (d.AfficherUtiliserGroupe().get(i).getCommentaire(),i,4);
                b2.Ttable2.setValueAt (d.AfficherUtiliserGroupe().get(i).getId_pers(),i,5);
            }
   }catch(Exception e){
 //   JOptionPane.showMessageDialog(null,"Afficher materiel groupe utiliser"+  e.getMessage());                        
   }
   }
 
     public void AfficherGroupeCorbeille(){
   try{
           b3.Ttable3.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Personnel"},d.AfficherCorbeilleGroupe().size()));
            for(int i=0;i<=d.AfficherCorbeilleGroupe().size();i++){
                b3.Ttable3.setValueAt (d.AfficherCorbeilleGroupe().get(i).getId_mat(),i,0);  
                b3.Ttable3.setValueAt (d.AfficherCorbeilleGroupe().get(i).getNom(),i,1);
                b3.Ttable3.setValueAt (d.AfficherCorbeilleGroupe().get(i).getDate(),i,2);
                b3.Ttable3.setValueAt (d.AfficherCorbeilleGroupe().get(i).getSquantite(),i,3);
                b3.Ttable3.setValueAt (d.AfficherCorbeilleGroupe().get(i).getId_pers(),i,4);
            }
   }catch(Exception e){
   //        JOptionPane.showMessageDialog(null,"Afficher groupe corbeille "+  e.getMessage());
   }
   }

    public void Choix(){
       try{
           u.Tnom2.removeAllItems();
            for(int i=0;i<=d.Choix().size();i++){
                u.Tnom2.addItem(d.Choix().get(i).getNom());  
            }   
            }catch(Exception e){
     //   JOptionPane.showMessageDialog(null," Choix "+  e.getMessage());            
            }
 }   
    public void ChoixRetirer(){
        r.Tnom3.removeAllItems();
         try{
            for(int i=0;i<=d.ChoixRetirer().size();i++){
                r.Tnom3.addItem(d.ChoixRetirer().get(i).getNom());  
            }   
            }catch(Exception e){
   //     JOptionPane.showMessageDialog(null," Choix retirer "+  e.getMessage());            
            }
 }
    
    public void ChoixPers(){
         try{
            for(int i=0;i<=d.ChoixPers().size();i++){
                Tpersonnel.addItem(valnompers);          // d.ChoixPers().get(i).getNom()
                r.Tpersonnel3.addItem(valnompers);
                u.Tpersonnel2.addItem(valnompers);
            }   
            }catch(Exception e){
//      JOptionPane.showMessageDialog(null," Choix pers "+  e.getMessage());              
            }
}

    public void ChoixAnnee(){
       try{
            for(int i=0;i<=d.ChoixAnnee().size();i++){
                b.Tannee.addItem(d.ChoixAnnee().get(i).getNom());
            }   
            }catch(Exception e){
  //      JOptionPane.showMessageDialog(null," Choix annee"+  e.getMessage());            
            } 
    }
    
 public void Vide(){
    Tnom.setText("");
    Templacement.setText("");
    Tquantite.setText("");
    Ttype.setText("");
   
    u.Tquantite2.setText("");
    u.Tcommentaire2.setText("");
    
    r.Templacement3.setText("");
    r.Tquantite3.setText("");
    r.Ttype3.setText("");  
 }
 
public void Resultrecherche () 
{
//    connexionBase();
        String req=" SELECT * from materiel where xxxxxxxxxxxxxx like'%"+ Trecherche.getText()+ "%' " ;
        try{
        sql.append(req);
        res=etat.executeQuery(sql.toString()); 
        int i=0;
        while(res.next()){
            JTable.setValueAt (res.getString(1),i,0);
            JTable.setValueAt (res.getString(2),i,1);  
            JTable.setValueAt (res.getString(3),i,2);
            JTable.setValueAt (res.getString(4),i,3);
            JTable.setValueAt (res.getString(5),i,4);
            JTable.setValueAt (res.getString(6),i,5);
            JTable.setValueAt (res.getString(7),i,6);          
        }
        }catch (Exception e){
    //      JOptionPane.showMessageDialog (null,e.getMessage());
          
      }  
        
}    
    
public void Actualiser()
{
//    connexionBase();
    Afficher();
    AfficherUtiliser();
    AfficherCorbeille();
}     
 
public void ActualiserStock1(){
    Tnom.setText("");
    Tdate.setText("");
    Templacement.setText("");
//    Tquantite.setValue("");
    Ttype.setText("");
    Afficher();
    AfficherUtiliser();
    AfficherCorbeille();
}

public void ActualiserStock2(){
    u.Tdatedebut2.setText("");
    u.Tcommentaire2.setText("");
    u.Tdateenregistrement2.setText("");
    Afficher();
    AfficherUtiliser();
    AfficherCorbeille();
}

public void ActualiserStock3(){
    r.Tdatedebut3.setText("");
    r.Tdatefin3.setText("");
    r.Ttype3.setText("");
    r.Templacement3.setText("");
    Afficher();
    AfficherUtiliser();
    AfficherCorbeille();
}

public void AfficherBilan(int a){
         
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tquantite = new javax.swing.JTextField();
        NextAdmin = new javax.swing.JLabel();
        Badmin = new javax.swing.JLabel();
        ligne16 = new javax.swing.JLabel();
        ligne14 = new javax.swing.JLabel();
        ligne15 = new javax.swing.JLabel();
        ligne11 = new javax.swing.JLabel();
        ligne12 = new javax.swing.JLabel();
        ligne13 = new javax.swing.JLabel();
        retour = new javax.swing.JLabel();
        Tdate = new javax.swing.JFormattedTextField();
        Tnom = new javax.swing.JTextField();
        Bbilan = new javax.swing.JLabel();
        Bretirer = new javax.swing.JLabel();
        Buse = new javax.swing.JLabel();
        Bnew = new javax.swing.JLabel();
        Lnom = new javax.swing.JLabel();
        Ldate = new javax.swing.JLabel();
        Lquantite = new javax.swing.JLabel();
        Bajouter = new javax.swing.JButton();
        Bacualiser = new javax.swing.JButton();
        Lemplacement = new javax.swing.JLabel();
        Ltype = new javax.swing.JLabel();
        Templacement = new javax.swing.JTextField();
        Ttype = new javax.swing.JTextField();
        Table = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        Ltexte12 = new javax.swing.JLabel();
        FbuttonT1 = new javax.swing.JLabel();
        FbuttonT = new javax.swing.JLabel();
        barre = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        ferm2 = new javax.swing.JLabel();
        Bstock1 = new javax.swing.JLabel();
        Bnew1 = new javax.swing.JLabel();
        Buse1 = new javax.swing.JLabel();
        LFpasse1 = new javax.swing.JLabel();
        LFpassePressed = new javax.swing.JLabel();
        Fond_Stock = new javax.swing.JLabel();
        Bmodifier = new javax.swing.JButton();
        Lpersonnel = new javax.swing.JLabel();
        Tpersonnel = new javax.swing.JComboBox();
        Lchoisie = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Trecherche = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Crecherche = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        Tquantite.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tquantite.setForeground(new java.awt.Color(2, 115, 197));
        Tquantite.setBorder(null);
        getContentPane().add(Tquantite);
        Tquantite.setBounds(250, 240, 230, 30);

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

        ligne16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne16.setText("jLabel2");
        getContentPane().add(ligne16);
        ligne16.setBounds(250, 270, 230, 2);

        ligne14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne14.setText("jLabel2");
        getContentPane().add(ligne14);
        ligne14.setBounds(700, 210, 230, 2);

        ligne15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne15.setText("jLabel2");
        getContentPane().add(ligne15);
        ligne15.setBounds(250, 150, 230, 2);

        ligne11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne11.setText("jLabel2");
        getContentPane().add(ligne11);
        ligne11.setBounds(250, 150, 230, 2);

        ligne12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne12.setText("jLabel2");
        getContentPane().add(ligne12);
        ligne12.setBounds(250, 210, 230, 2);

        ligne13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne13.setText("jLabel2");
        getContentPane().add(ligne13);
        ligne13.setBounds(700, 150, 230, 2);

        retour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                retourMousePressed(evt);
            }
        });
        getContentPane().add(retour);
        retour.setBounds(10, 10, 30, 20);

        Tdate.setBorder(null);
        Tdate.setForeground(new java.awt.Color(2, 115, 197));
        try {
            Tdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Tdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Tdate.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        getContentPane().add(Tdate);
        Tdate.setBounds(250, 180, 230, 30);

        Tnom.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tnom.setForeground(new java.awt.Color(2, 115, 197));
        Tnom.setAlignmentY(20.0F);
        Tnom.setAutoscrolls(false);
        Tnom.setBorder(null);
        Tnom.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Tnom.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Tnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnomActionPerformed(evt);
            }
        });
        getContentPane().add(Tnom);
        Tnom.setBounds(250, 120, 230, 30);

        Bbilan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bbilan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BbilanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BbilanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BbilanMousePressed(evt);
            }
        });
        getContentPane().add(Bbilan);
        Bbilan.setBounds(822, 35, 150, 50);

        Bretirer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bretirer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BretirerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BretirerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BretirerMousePressed(evt);
            }
        });
        getContentPane().add(Bretirer);
        Bretirer.setBounds(671, 35, 150, 50);

        Buse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BuseMousePressed(evt);
            }
        });
        getContentPane().add(Buse);
        Buse.setBounds(520, 35, 150, 50);

        Bnew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bnew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BnewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BnewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BnewMousePressed(evt);
            }
        });
        getContentPane().add(Bnew);
        Bnew.setBounds(372, 35, 150, 50);

        Lnom.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Lnom.setForeground(new java.awt.Color(67, 68, 70));
        Lnom.setText("Nom matériel");
        Lnom.setToolTipText("");
        getContentPane().add(Lnom);
        Lnom.setBounds(90, 120, 110, 30);

        Ldate.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Ldate.setForeground(new java.awt.Color(67, 68, 70));
        Ldate.setText("Date enregistrement");
        getContentPane().add(Ldate);
        Ldate.setBounds(90, 180, 150, 30);

        Lquantite.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Lquantite.setForeground(new java.awt.Color(67, 68, 70));
        Lquantite.setText("Quantité");
        getContentPane().add(Lquantite);
        Lquantite.setBounds(90, 240, 70, 30);

        Bajouter.setBackground(new java.awt.Color(12, 46, 76));
        Bajouter.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bajouter.setForeground(new java.awt.Color(255, 255, 255));
        Bajouter.setText("Ajouter");
        Bajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajouterActionPerformed(evt);
            }
        });
        getContentPane().add(Bajouter);
        Bajouter.setBounds(720, 290, 90, 30);

        Bacualiser.setBackground(new java.awt.Color(12, 46, 76));
        Bacualiser.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bacualiser.setForeground(new java.awt.Color(255, 255, 255));
        Bacualiser.setText("Actualiser");
        Bacualiser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Bacualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacualiserActionPerformed(evt);
            }
        });
        getContentPane().add(Bacualiser);
        Bacualiser.setBounds(840, 290, 90, 30);

        Lemplacement.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Lemplacement.setForeground(new java.awt.Color(67, 68, 70));
        Lemplacement.setText("Emplacement");
        getContentPane().add(Lemplacement);
        Lemplacement.setBounds(540, 120, 100, 30);

        Ltype.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Ltype.setForeground(new java.awt.Color(67, 68, 70));
        Ltype.setText("Type");
        getContentPane().add(Ltype);
        Ltype.setBounds(540, 180, 100, 30);

        Templacement.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Templacement.setForeground(new java.awt.Color(2, 115, 197));
        Templacement.setBorder(null);
        Templacement.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Templacement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemplacementActionPerformed(evt);
            }
        });
        getContentPane().add(Templacement);
        Templacement.setBounds(700, 120, 230, 30);

        Ttype.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Ttype.setForeground(new java.awt.Color(2, 115, 197));
        Ttype.setBorder(null);
        Ttype.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Ttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtypeActionPerformed(evt);
            }
        });
        getContentPane().add(Ttype);
        Ttype.setBounds(700, 180, 230, 30);

        JTable.setFont(new java.awt.Font("Microsoft Tai Le", 0, 12)); // NOI18N
        JTable.setForeground(new java.awt.Color(67, 68, 70));
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nom", "Date", "Quantité", "Etat", "Emplacement", "Type", "Personnel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.setSelectionBackground(new java.awt.Color(2, 115, 197));
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTableMouseReleased(evt);
            }
        });
        Table.setViewportView(JTable);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(50);
            JTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(Table);
        Table.setBounds(90, 402, 880, 150);

        Ltexte12.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        Ltexte12.setForeground(new java.awt.Color(2, 115, 197));
        Ltexte12.setText("Listes des matériels disponibles");
        getContentPane().add(Ltexte12);
        Ltexte12.setBounds(90, 360, 280, 30);
        getContentPane().add(FbuttonT1);
        FbuttonT1.setBounds(830, 410, 16, 16);

        FbuttonT.setText("jLabel2");
        getContentPane().add(FbuttonT);
        FbuttonT.setBounds(830, 410, 16, 16);

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

        Bstock1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btab1.png"))); // NOI18N
        Bstock1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bstock1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bstock1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bstock1MousePressed(evt);
            }
        });
        getContentPane().add(Bstock1);
        Bstock1.setBounds(930, 370, 16, 16);

        Bnew1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btab1.png"))); // NOI18N
        Bnew1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bnew1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bnew1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bnew1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Bnew1MouseReleased(evt);
            }
        });
        getContentPane().add(Bnew1);
        Bnew1.setBounds(850, 370, 16, 16);

        Buse1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btab1.png"))); // NOI18N
        Buse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Buse1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Buse1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Buse1MousePressed(evt);
            }
        });
        getContentPane().add(Buse1);
        Buse1.setBounds(890, 370, 16, 16);
        getContentPane().add(LFpasse1);
        LFpasse1.setBounds(190, 40, 151, 50);
        getContentPane().add(LFpassePressed);
        LFpassePressed.setBounds(50, 30, 151, 50);

        Fond_Stock.setBackground(new java.awt.Color(12, 46, 76));
        Fond_Stock.setFont(new java.awt.Font("Microsoft Tai Le", 0, 16)); // NOI18N
        Fond_Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fond-Stock.jpg"))); // NOI18N
        Fond_Stock.setText("Nom");
        getContentPane().add(Fond_Stock);
        Fond_Stock.setBounds(0, 0, 1000, 600);

        Bmodifier.setBackground(new java.awt.Color(12, 46, 76));
        Bmodifier.setForeground(new java.awt.Color(255, 255, 255));
        Bmodifier.setText("Modifier");
        Bmodifier.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                BmodifierComponentHidden(evt);
            }
        });
        Bmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmodifierActionPerformed(evt);
            }
        });
        getContentPane().add(Bmodifier);
        Bmodifier.setBounds(220, 350, 90, 30);

        Lpersonnel.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Lpersonnel.setForeground(new java.awt.Color(67, 68, 70));
        Lpersonnel.setText("Personnel ");
        getContentPane().add(Lpersonnel);
        Lpersonnel.setBounds(490, 240, 80, 30);

        Tpersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpersonnelActionPerformed(evt);
            }
        });
        getContentPane().add(Tpersonnel);
        Tpersonnel.setBounds(670, 240, 160, 30);

        Lchoisie.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        Lchoisie.setForeground(new java.awt.Color(51, 51, 51));
        Lchoisie.setText("( choisissez )");
        getContentPane().add(Lchoisie);
        Lchoisie.setBounds(450, 400, 120, 30);

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(870, 350, 90, 30);

        jLabel1.setText("Recherche :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 350, 90, 30);

        Trecherche.setBorder(null);
        Trecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrechercheActionPerformed(evt);
            }
        });
        getContentPane().add(Trecherche);
        Trecherche.setBounds(540, 350, 190, 30);

        jButton2.setText("jButton2");
        getContentPane().add(jButton2);
        jButton2.setBounds(440, 350, 73, 23);

        Crecherche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom_mat", "Date", "Quantite", "Etat", "Emplacement", "Type" }));
        Crecherche.setBorder(null);
        getContentPane().add(Crecherche);
        Crecherche.setBounds(750, 350, 100, 30);

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void BuseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuseMousePressed
Choix();
      LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-utiliser.jpg")));
      LFpassePressed.setBounds(520,35,151,50);
      LFpassePressed.setVisible(true);
        VariableButiliser();
        Afficher();
        AfficherUtiliser();
        u.Table2.setViewportView(u.JTable2);

        Fond_Stock.add(u.ligne21);
        Fond_Stock.add(u.ligne22);
        Fond_Stock.add(u.ligne23);
        Fond_Stock.add(u.Table2);
        Fond_Stock.add(u.Lcommentaire2); 
        Fond_Stock.add(u.Ldatedebut2); 
        Fond_Stock.add(u.Lnom2);   
        Fond_Stock.add(u.Lquantite2);
        Fond_Stock.add(u.Tnom2);
        Fond_Stock.add(u.Tquantite2);
        Fond_Stock.add(u.Tdateenregistrement2);
        Fond_Stock.add(u.Bmodifier2);
        Fond_Stock.add(u.Bactualiser2);
    //    Fond_Stock.add(u.Tpersonnel2);
//        Fond_Stock.add(u.Bajouter2);
        Fond_Stock.add(u.Tcommentaire22);
        Fond_Stock.add(u.Ldateenregistrement2);
        Fond_Stock.add(u.Tdatedebut2);
    //    Fond_Stock.add(u.Lpersonnel2);
      // Fond_Stock.add(u.Table2);
       Fond_Stock.add(u.Ltexte12);
       Fond_Stock.add(u.Bnew2);
       Fond_Stock.add(u.Buse2);
       Fond_Stock.add(u.Bstock2);

       u.JTable2.addMouseListener(this);
       u.Bactualiser2.addActionListener(this);
//       u.Bajouter2.addActionListener(this);
       u.Bmodifier2.addActionListener(this);
       u.Bnew2.addMouseListener(this);
       u.Buse2.addMouseListener(this);
       u.Bstock2.addMouseListener(this);

     b.Boption.setVisible(false);
     b.Lmenu.setVisible(false);
     b.BtotalEntrer.setVisible(false);
     b.BtotalSortie.setVisible(false);
     b.Tannee.setVisible(false);
     b.B4.setVisible(false);
       
    }//GEN-LAST:event_BuseMousePressed

    private void BnewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BnewMouseEntered
       LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-nouveau.jpg"))); 
       LFpasse1.setBounds(370,35,151,50);
    }//GEN-LAST:event_BnewMouseEntered

    private void BnewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BnewMouseExited
        LFpasse1.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_BnewMouseExited

    private void BnewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BnewMousePressed
      LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-nouveau.jpg")));
      LFpassePressed.setBounds(370,35,151,50);
      LFpassePressed.setVisible(true);
                
        VariableBnew();
       
     b.Boption.setVisible(false);
     b.Lmenu.setVisible(false);
     b.BtotalEntrer.setVisible(false);
     b.BtotalSortie.setVisible(false);
     b.Tannee.setVisible(false);
     b.B4.setVisible(false);  
    }//GEN-LAST:event_BnewMousePressed

    private void BretirerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BretirerMousePressed
ChoixRetirer();
      LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-retirer.jpg")));
      LFpassePressed.setBounds(671,35,151,50);
      LFpassePressed.setVisible(true);  
        
     VariableRetirer();
     Afficher();
     AfficherUtiliser();
       
           r.Lemplacement3.setVisible(true);    r.Templacement3.setVisible(true);
           r.Ltype3.setVisible(true);          r.Ttype3.setVisible(true); 
       
       
        r.Table3.setViewportView(r.JTable3);

        Fond_Stock.add(r.Table3);
    //    r.Table3.setBounds(90, 442, 880, 110);

    Fond_Stock.add(r.ligne31);
    Fond_Stock.add(r.ligne32);
    Fond_Stock.add(r.ligne33);
    Fond_Stock.add(r.ligne34);
    Fond_Stock.add(r.ligne35);
    
    Fond_Stock.add(r.Bacualiser3);
//    Fond_Stock.add(r.Bajouter3);
    Fond_Stock.add(r.Bmodifier3);
    Fond_Stock.add(r.Bnew3);
    Fond_Stock.add(r.Bstoc3);
    Fond_Stock.add(r.Buse3);
 //   Fond_Stock.add(r.Tpersonnel3)
    Fond_Stock.add(r.LDatedebut3);
    Fond_Stock.add(r.Lemplacement3);
    Fond_Stock.add(r.Ldatefin3);
    Fond_Stock.add(r.Lemplacement3);
    Fond_Stock.add(r.Lemplacement3);
    Fond_Stock.add(r.LDatedebut3);
    Fond_Stock.add(r.Ltexte12);
    Fond_Stock.add(r.Ltype3);
    Fond_Stock.add(r.LNom3);
    Fond_Stock.add(r.Lquantite3);
    Fond_Stock.add(r.Letat3);
    //Fond_Stock.add(r.Tpersonnel3);
    Fond_Stock.add(r.Tdatedebut3);
    Fond_Stock.add(r.Tdatefin3);
    Fond_Stock.add(r.Templacement3);
    Fond_Stock.add(r.Tetat3);
    Fond_Stock.add(r.Tnom3);
    Fond_Stock.add(r.Tquantite3);
    Fond_Stock.add(r.Ttype3);
 //   Fond_Stock.add(r.Lpersonnel3);
        
    r.JTable3.addMouseListener(this);
    r.Bnouveau3.addActionListener(this);
    r.Bstock3.addActionListener(this);
  //  r.JTable3.setBounds(90, 400,870, 90);
    
    r.Bacualiser3.addActionListener(this);
    r.Tetat3.addMouseListener(this);
    r.Tetat3.addActionListener(this);
//    r.Bajouter3.addActionListener(this);
    r.Bnew3.addMouseListener(this);
    r.Buse3.addMouseListener(this);
    r.Bstoc3.addMouseListener(this);
    r.Bmodifier3.addActionListener(this);
    
    b.Boption.setVisible(false);
     b.Lmenu.setVisible(false);
     b.BtotalEntrer.setVisible(false);
     b.BtotalSortie.setVisible(false);
     b.Tannee.setVisible(false);
     b.B4.setVisible(false);
    }//GEN-LAST:event_BretirerMousePressed

    private void BbilanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbilanMousePressed
b.B1.setForeground(new java.awt.Color(2, 115, 197));
        LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-bilan.jpg")));
      LFpassePressed.setBounds(821,35,151,50);
      LFpassePressed.setVisible(true);
        
        VariableBilan();  
        b.Tscroll.setViewportView(b.Ttable);
        Fond_Stock.add(b.Tscroll);
        
        b.BtotalSortie.setVisible(true);
        b.Tannee.setVisible(true);
        b.Boption.setVisible(true);
        b.ligneBilan.setVisible(true);
        
        Fond_Stock.add(b.ligneBilan);
         Fond_Stock.add(b.B4);
         Fond_Stock.add(b.B1);
         Fond_Stock.add(b.B3);
         Fond_Stock.add(b.B2);
         Fond_Stock.add(b.BtotalEntrer);
         Fond_Stock.add(b.BtotalSortie);
         Fond_Stock.add(b.Tannee);
         Fond_Stock.add(b.Boption);
         Fond_Stock.add(b.Bactualiser);
         Fond_Stock.add(b.B5);
         Fond_Stock.add(b.Brecherche);
         Fond_Stock.add(b.Trecherche);
         Fond_Stock.add(b.Crecherche);
         
         b.B1.addMouseListener(this);
         b.B2.addMouseListener(this);
         b.B3.addMouseListener(this);
         b.BtotalEntrer.addActionListener(this);
         b.BtotalSortie.addActionListener(this);
         b.Lmenu.addMouseListener(this);
         b.Boption.addActionListener(this);
         b.Bactualiser.addActionListener(this);
         b.Brecherche.addActionListener(this);
         b2.Brecherche2.addActionListener(this);
         b3.Brecherche3.addActionListener(this);
    }//GEN-LAST:event_BbilanMousePressed

    private void TnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnomActionPerformed

    private void BajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajouterActionPerformed
        enregistrer();
    }//GEN-LAST:event_BajouterActionPerformed

    private void BacualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacualiserActionPerformed
        ActualiserStock1();
//        JOptionPane.showMessageDialog(this, valnompers);
    }//GEN-LAST:event_BacualiserActionPerformed

    private void TemplacementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemplacementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemplacementActionPerformed

    private void TtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtypeActionPerformed

    private void TrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrechercheActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Trecherche.getText().equals(""))
        {
//            JOptionPane.showMessageDialog(this," entree une valeur SVP");
        }   
        else {
        if(Crecherche.getSelectedItem().equals("Nom_mat")){
//               JOptionPane.showMessageDialog(this, "Nom materiel");
               String s="Nom_mat LIKE'%"+ Trecherche.getText()+ "%' ";
//               Resultrecherche();

            }
             if(Crecherche.getSelectedItem().equals("Date")){
                                 JOptionPane.showMessageDialog(this, "Date materiel");

             //   Resultrecherche("Date LIKE'%"+ Trecherche.getText()+ "%' ");
            }
            if(Crecherche.getSelectedItem().equals("Quantite")){
                                JOptionPane.showMessageDialog(this, "Quantite materiel");

               //  Resultrecherche("Quantite LIKE'%"+ Trecherche.getText()+ "%' ");
            }
            if(Crecherche.getSelectedItem().equals("Etat")){
                 //Resultrecherche("Etat LIKE'%"+ Trecherche.getText()+ "%' ");
            }
            if(Crecherche.getSelectedItem().equals("Emplacement")){
                 //Resultrecherche("Emplacement LIKE'%"+ Trecherche.getText()+ "%' ");
            }
                 if(Crecherche.getSelectedItem().equals("Type")){
                // Resultrecherche("Type LIKE'%"+ Trecherche.getText()+ "%' ");
            }
          
            }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BmodifierComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_BmodifierComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_BmodifierComponentHidden

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

    private void ferm1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseEntered
        // TODO add your handling code here:
        ferm2.setVisible(true);
        Fond_Stock.add(ferm2);
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

    private void Bnew1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bnew1MousePressed
        // TODO add your handling code here:
        FbuttonT.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        FbuttonT.setBounds(850,370,16, 16);
        FbuttonT.setVisible(true);
        
           Actualiser();
          // FbuttonT.setVisible(true);
           Ltexte12.setVisible(true);  // nouveau
           JTable.setVisible(true);
           Table.setVisible(true);
           
          // u.Ltexte12.setVisible(false);
           r.Ltexte12.setVisible(false);  // utiliser
           r.JTable3.setVisible(false);
           r.Table3.setVisible(false);
           
           s3.Ltexte22.setVisible(false);   // stock
           s3.JTable4.setVisible(false);
           s3.Table4.setVisible(false);
        
    }//GEN-LAST:event_Bnew1MousePressed

    private void Buse1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buse1MousePressed
        // TODO add your handling code here:
        FbuttonT.setBounds(890,370,16, 16);
        FbuttonT.setVisible(true);

         Actualiser();
           r.Table3.setViewportView(r.JTable3);
           Fond_Stock.add(r.Table3);
           Fond_Stock.add(r.Ltexte12);
           r.Ltexte12.setVisible(true);  // utiliser
           r.JTable3.setVisible(true);
           r.Table3.setVisible(true);
       
           Ltexte12.setVisible(false);   //  nouveau
           JTable.setVisible(false);
           Table.setVisible(false);
           
           s3.Ltexte22.setVisible(false);   // stock
           s3.JTable4.setVisible(false);
           s3.Table4.setVisible(false);
    }//GEN-LAST:event_Buse1MousePressed

    private void Bstock1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bstock1MousePressed
        // TODO add your handling code here:
        
        FbuttonT.setBounds(930,370,16, 16);
        FbuttonT.setVisible(true);
        
         Actualiser();
          // u.Ltexte12.setVisible(false);
           r.Ltexte12.setVisible(false); 
           r.JTable3.setVisible(false);
           r.Table3.setVisible(false);
           
           Ltexte12.setVisible(false);
           JTable.setVisible(false);
           Table.setVisible(false);
           
          s3.Table4.setViewportView(s3.JTable4);
          Fond_Stock.add(s3.Table4);
          Fond_Stock.add(s3.Ltexte22);
          AfficherCorbeille();
          s3.Ltexte22.setVisible(true);
          s3.Ltexte22.setVisible(true);
          s3.JTable4.setVisible(true);
          s3.Table4.setVisible(true);  
    }//GEN-LAST:event_Bstock1MousePressed

    private void JTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseReleased
        // TODO add your handling code here:
         u.Tnom2.setSelectedItem(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),1)));
         u.Tdateenregistrement2.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),2)));
         u.Tident.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),0)));
    }//GEN-LAST:event_JTableMouseReleased

    private void Bnew1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bnew1MouseEntered
        // TODO add your handling code here:
        FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        FbuttonT1.setBounds(850,370,16, 16);
        FbuttonT1.setVisible(true);
    }//GEN-LAST:event_Bnew1MouseEntered

    private void Bnew1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bnew1MouseExited
        // TODO add your handling code here:
        FbuttonT1.setVisible(false);
    }//GEN-LAST:event_Bnew1MouseExited

    private void TpersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpersonnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TpersonnelActionPerformed

    private void Buse1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buse1MouseEntered
        // TODO add your handling code here:
        FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        FbuttonT1.setBounds(890,370,16, 16);
        FbuttonT1.setVisible(true);

    }//GEN-LAST:event_Buse1MouseEntered

    private void Buse1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buse1MouseExited
        // TODO add your handling code here:
        FbuttonT1.setVisible(false);
    }//GEN-LAST:event_Buse1MouseExited

    private void Bstock1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bstock1MouseEntered
        // TODO add your handling code here:
        FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        FbuttonT1.setBounds(930,370,16, 16);
        FbuttonT1.setVisible(true);
    }//GEN-LAST:event_Bstock1MouseEntered

    private void Bstock1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bstock1MouseExited
        // TODO add your handling code here:
        FbuttonT1.setVisible(false);
    }//GEN-LAST:event_Bstock1MouseExited

    private void retourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retourMousePressed
        // TODO add your handling code here:
        Menu men = new Menu();
        men.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retourMousePressed

    private void BuseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuseMouseExited
        LFpasse1.setVisible(false);
    }//GEN-LAST:event_BuseMouseExited

    private void BuseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuseMouseEntered
       LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-utiliser.jpg"))); 
       LFpasse1.setBounds(521,35,151,50);    // TODO add your handling code here:
    }//GEN-LAST:event_BuseMouseEntered

    private void BretirerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BretirerMouseExited
       LFpasse1.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_BretirerMouseExited

    private void BretirerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BretirerMouseEntered
       LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-retirer.jpg"))); 
       LFpasse1.setBounds(671,35,151,50);        // TODO add your handling code here:
    }//GEN-LAST:event_BretirerMouseEntered

    private void BbilanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbilanMouseEntered
       LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-bilan.jpg"))); 
       LFpasse1.setBounds(821,35,151,50);        // TODO add your handling code here:
    }//GEN-LAST:event_BbilanMouseEntered

    private void BbilanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbilanMouseExited
    LFpasse1.setVisible(false);
    }//GEN-LAST:event_BbilanMouseExited

    private void BmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmodifierActionPerformed
//JOptionPane.showMessageDialog(this, valnompers);  
//Tpersonnel.addItem(valnompers);
// TODO add your handling code here:
    }//GEN-LAST:event_BmodifierActionPerformed

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
        jLabel1.add(NextAdmin);
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

    private void Bnew1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bnew1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Bnew1MouseReleased

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
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bacualiser;
    public javax.swing.JLabel Badmin;
    public javax.swing.JButton Bajouter;
    private javax.swing.JLabel Bbilan;
    public javax.swing.JButton Bmodifier;
    private javax.swing.JLabel Bnew;
    public javax.swing.JLabel Bnew1;
    private javax.swing.JLabel Bretirer;
    public javax.swing.JLabel Bstock1;
    private javax.swing.JLabel Buse;
    public javax.swing.JLabel Buse1;
    private javax.swing.JComboBox Crecherche;
    public javax.swing.JLabel FbuttonT;
    public javax.swing.JLabel FbuttonT1;
    private javax.swing.JLabel Fond_Stock;
    public javax.swing.JTable JTable;
    public javax.swing.JLabel LFpasse1;
    public javax.swing.JLabel LFpassePressed;
    public javax.swing.JLabel Lchoisie;
    public javax.swing.JLabel Ldate;
    public javax.swing.JLabel Lemplacement;
    public javax.swing.JLabel Lnom;
    public javax.swing.JLabel Lpersonnel;
    public javax.swing.JLabel Lquantite;
    public javax.swing.JLabel Ltexte12;
    public javax.swing.JLabel Ltype;
    private javax.swing.JLabel NextAdmin;
    public javax.swing.JScrollPane Table;
    private javax.swing.JFormattedTextField Tdate;
    public javax.swing.JTextField Templacement;
    public javax.swing.JTextField Tnom;
    public javax.swing.JComboBox Tpersonnel;
    private javax.swing.JTextField Tquantite;
    private javax.swing.JTextField Trecherche;
    public javax.swing.JTextField Ttype;
    private javax.swing.JLabel barre;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel ligne11;
    public javax.swing.JLabel ligne12;
    public javax.swing.JLabel ligne13;
    public javax.swing.JLabel ligne14;
    public javax.swing.JLabel ligne15;
    public javax.swing.JLabel ligne16;
    public javax.swing.JLabel retour;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
 //       if(e.getSource()== u.Bajouter2)
  //      {
  //        TestQ();
  //        JOptionPane.showMessageDialog(this, "1");
  //      } 
        if(e.getSource()==u.Bmodifier2){
            TestQ();
    //        JOptionPane.showMessageDialog(this, "2");
        }
        if(e.getSource()== u.Bactualiser2)
        {
            ActualiserStock2();
        }
   //      if(e.getSource()== r.Bajouter3)
  //      {
  //        TestQ2();
  //        JOptionPane.showMessageDialog(this, "1");
  //      } 
         if(e.getSource()==r.Bmodifier3){
           TestQ2();
         }
        if(e.getSource()== r.Bacualiser3)
        {
          ActualiserStock3();
        } 
         
        if (e.getSource()==b.Brecherche){
            if (b.Trecherche.getText().equals(""))
        {
//            JOptionPane.showMessageDialog(this," entree une valeur SVP");
        }   
        else {
 try{
           //d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText());
            b.Ttable.setModel(new DefaultTableModel(new String []{"Id","Nom","Date","Quantité","Etat","Emplacement","Type","Personne"},d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).size()));
            for(int i=0;i<=d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).size();i++){
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getId_mat(),i,0);  
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getNom(),i,1);
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getDate(),i,2);
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getQuantite2(),i,3);
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getEtat(),i,4);
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getEmplacement(),i,5);
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getType(),i,6);
                b.Ttable.setValueAt (d.AfficherRechercheMateriel(b.Crecherche.getSelectedItem().toString(), b.Trecherche.getText()).get(i).getId_pers(),i,7);
            }
 }catch(Exception ee){
     
 }           
        }
        }         
        
        if (e.getSource()==b2.Brecherche2){
            if (b2.Trecherche2.getText().equals(""))
        {
//            JOptionPane.showMessageDialog(this," entrée une valeur SVP");
        }   
        else {
try{
            b2.Ttable2.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Commentaire","Personnel"},d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).size()));
            for(int i=0;i<=d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).size();i++){
                b2.Ttable2.setValueAt (d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).get(i).getId_mat(),i,0);  
                b2.Ttable2.setValueAt (d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).get(i).getNom(),i,1);
                b2.Ttable2.setValueAt (d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).get(i).getDate(),i,2);
                b2.Ttable2.setValueAt (d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).get(i).getQuantite2(),i,3);
                b2.Ttable2.setValueAt (d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).get(i).getCommentaire(),i,4);
                b2.Ttable2.setValueAt (d.AfficherRechercheUtiliser(b2.Crecherche2.getSelectedItem().toString(), b2.Trecherche2.getText()).get(i).getId_pers(),i,5);   
            }
          }catch(Exception ee){
     
 }      
        }
        }         
        
        if (e.getSource()==b3.Brecherche3){
            if (b3.Trecherche3.getText().equals(""))
        {
          //  JOptionPane.showMessageDialog(this," entrée une valeur SVP");
        }   
        else {
       try{         
           
            b3.Ttable3.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Personnel"},d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).size()));
             for(int i=0;i<=d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).size();i++){
                b3.Ttable3.setValueAt (d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).get(i).getId_mat(),i,0);  
                b3.Ttable3.setValueAt (d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).get(i).getNom(),i,1);
                b3.Ttable3.setValueAt (d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).get(i).getDate(),i,2);
                b3.Ttable3.setValueAt (d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).get(i).getQuantite2(),i,3);
                b3.Ttable3.setValueAt (d.AfficherRechercheCorbeille(b3.Crecherche3.getSelectedItem().toString(), b3.Trecherche3.getText()).get(i).getId_pers(),i,4);
             }
             }catch(Exception ee){
     
 }
            }    
        }
         
         if (e.getSource()==r.Tetat3)
         {
             if(r.Tetat3.getSelectedItem()== "Reutilisable")
             {
                r.Lemplacement3.setVisible(true);   r.Templacement3.setVisible(true);
                r.Ltype3.setVisible(true);          r.Ttype3.setVisible(true); 
                 r.ligne33.setVisible(true);            r.ligne34.setVisible(true);
             }
           else if(r.Tetat3.getSelectedItem()== "Inutilisable")
             {
                r.Lemplacement3.setVisible(false);    r.Templacement3.setVisible(false);
                r.Ltype3.setVisible(false);          r.Ttype3.setVisible(false); 
                r.ligne33.setVisible(false);            r.ligne34.setVisible(false);
             }      
         }
          
         if (e.getSource()== b.Bactualiser){
          b.B2.setForeground(new java.awt.Color(67, 68, 70));
          b.B1.setForeground(new java.awt.Color(2, 115, 197));
          b.B3.setForeground(new java.awt.Color(67, 68, 70));
        
        b.Trecherche.setText("");
        b2.Trecherche2.setText("");
        b3.Trecherche3.setText("");
             
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
           
        Afficher();
        AfficherCorbeille();
        AfficherUtiliser();
        
        b.Tscroll.setVisible(true);
        b.Ttable.setVisible(true);
       
        b.Tscroll.setViewportView(b.Ttable);
        Fond_Stock.add(b.Tscroll);
        
        b.B1.setVisible(true);
        b.B2.setVisible(true);
        b.B3.setVisible(true);
        
        b.Brecherche.setVisible(true);
        b.Crecherche.setVisible(true);
        b.Trecherche.setVisible(true);
        
        b2.Brecherche2.setVisible(false);
        b2.Crecherche2.setVisible(false);
        b2.Trecherche2.setVisible(false);
        
        b3.Brecherche3.setVisible(false);
        b3.Crecherche3.setVisible(false);
        b3.Trecherche3.setVisible(false);
        
        b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        
        b.jLabelTotalEntree.setVisible(false);
        b.jLabelTotalSortie.setVisible(false);
       
    }
         
         if (e.getSource()== b.BtotalEntrer){                     //// &&&&&&&&&&&&&&&&&&&&&&   Statistique
      /*  b.jLabelTotalEntree.setVisible(true);
        Fond_Stock.add(b.jLabelTotalEntree);
        b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
       // b.Tscroll.setVisible(false);
       // b.Ttable.setVisible(false);
        
       // b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        b.jLabelTotalSortie.setVisible(false);
            
       // b.B1.setVisible(false);
      //  b.B2.setVisible(false);
       // b.B3.setVisible(false);
             
       */
        int a = Integer.valueOf(b.Tannee.getSelectedItem().toString());
       // JOptionPane.showMessageDialog(this, a);
   DefaultCategoryDataset datset=new DefaultCategoryDataset();
         for(int i=0;i<=d.AfficherBilan("nouveau",a).size();i++){
         try{
                datset.setValue(Integer.valueOf(d.AfficherBilan("nouveau",a).get(i).getSquantite()), "Marks", d.AfficherBilan("nouveau",a).get(i).getNom());
         }catch(Exception ej){
             
             }
        }
         
       JFreeChart chart=ChartFactory.createBarChart(" ","Evaluation","Niveau", datset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
       // p.setBackgroundPaint(Color.BLUE);
        ChartFrame frame=new ChartFrame("Statictique des elève a..", chart);
        frame.setVisible(true);
        frame.setBounds(185, 85, 1000, 600);
        frame.setTitle("tutorial");
                  
    }
         
          if (e.getSource()== b.BtotalSortie){                     //// &&&&&&&&&&&&&&&&&&&&&&   Statistique
     /*   b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        b.jLabelTotalEntree.setVisible(false);
        
        b.B1.setVisible(false);
        b.B2.setVisible(false);
        b.B3.setVisible(false);
       */ 
        int a = Integer.valueOf(b.Tannee.getSelectedItem().toString());
        DefaultCategoryDataset datset=new DefaultCategoryDataset();
         for(int i=0;i<=d.AfficherBilan("utiliser",a).size();i++){
         try{
                datset.setValue(Integer.valueOf(d.AfficherBilan("utiliser",a).get(i).getSquantite()), "Marks", d.AfficherBilan("utiliser",a).get(i).getNom());
               }catch(Exception ej){
             
              }
        }
         
        JFreeChart chart=ChartFactory.createBarChart(" ","Evaluation","Niveau", datset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
       // p.setBackgroundPaint(Color.BLUE);
        ChartFrame frame=new ChartFrame("Statictique des elève a..", chart);
        frame.setVisible(true);
        frame.setBounds(185, 85, 1000, 600);
        frame.setTitle("tutorial");
          
         } 
         
         //ChartFactory.createAreaChart("Texte1", "Texte2", "Texte3", datset, PlotOrientation.HORIZONTAL, false, true, false);    mande fa  non 
         //ChartFactory.createLineChart(Dannee, Dannee, Dannee, null, PlotOrientation.HORIZONTAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled)
         //ChartFactory.createLineChart("Economie de Madagasikara","Evaluation par an","Taux de croissances", datset, PlotOrientation.VERTICAL, false, true, false);    mande fa non
         //ChartFactory.createPolarChart(Dannee, null, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled)
    }    //ChartFactory.createBarChart (Dannee, Dannee, Dannee, null, PlotOrientation.HORIZONTAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled)    mande fa non

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
      if (e.getSource()== u.Bnew2){
         Actualiser();
         u.FbuttonT.setBounds(850,370,16, 16);
         u.FbuttonT.setVisible(true);
           
           u.Ltexte12.setVisible(true);  // nouveau
           u.JTable2.setVisible(true);
           u.Table2.setVisible(true);
            
           r.Ltexte12.setVisible(false);  // utiliser
           r.JTable3.setVisible(false);
           r.Table3.setVisible(false);
           
           s3.Ltexte22.setVisible(false);
           s3.Ltexte22.setVisible(false);   // stock
           s3.JTable4.setVisible(false);
           s3.Table4.setVisible(false);
      }
        
       if(e.getSource()== u.Buse2)
        {  
            Actualiser();
            u.FbuttonT.setBounds(890,370,16, 16);
            u.FbuttonT.setVisible(true);
        
           r.Table3.setViewportView(r.JTable3);
           Fond_Stock.add(r.Table3);
           r.Ltexte12.setVisible(true); // utiliser
           Fond_Stock.add(r.Ltexte12);
           r.JTable3.setVisible(true);
           r.Table3.setVisible(true);
       
           u.Ltexte12.setVisible(false);  // nouveau
           u.JTable2.setVisible(false);
           u.Table2.setVisible(false);
           
           s3.Ltexte22.setVisible(false);   // stock
           s3.Ltexte22.setVisible(false);
           s3.JTable4.setVisible(false);
           s3.Table4.setVisible(false);
                
        }  
         if(e.getSource()== u.Bstock2)
        { 
            Actualiser();
            u.FbuttonT.setBounds(930,370,16, 16);
            u.FbuttonT.setVisible(true);
           r.Ltexte12.setVisible(false); 
           r.JTable3.setVisible(false);
           r.Table3.setVisible(false);
           
           u.Ltexte12.setVisible(false);  // nouveau
           u.JTable2.setVisible(false);
           u.Table2.setVisible(false);
           
          s3.Table4.setViewportView(s3.JTable4);
          Fond_Stock.add(s3.Table4);
          Fond_Stock.add(s3.Ltexte22);
          AfficherCorbeille();
          s3.Ltexte22.setVisible(true);
          s3.Ltexte22.setVisible(true);
          s3.JTable4.setVisible(true);
          s3.Table4.setVisible(true);           
        }  
         
         
          if (e.getSource()== r.Bnew3){
         r.FbuttonT.setBounds(850,370,16, 16);
         r.FbuttonT.setVisible(true);
            Actualiser();
           Ltexte12.setVisible(true);  // nouveau
           JTable.setVisible(true);
           Table.setVisible(true);
          
           
           r.Ltexte12.setVisible(false);  // utiliser
           r.JTable3.setVisible(false);
           r.Table3.setVisible(false);
           
           s3.Ltexte22.setVisible(false);
           s3.Ltexte22.setVisible(false);   // stock
           s3.JTable4.setVisible(false);
           s3.Table4.setVisible(false);
      }
        
       if(e.getSource()== r.Buse3)
        {  
         r.FbuttonT.setBounds(890,370,16, 16);
         r.FbuttonT.setVisible(true);
            Actualiser();
           r.Ltexte12.setVisible(true);  // utiliser
           r.JTable3.setVisible(true);
           r.Table3.setVisible(true);
       
           Ltexte12.setVisible(false);  // nouveau
           JTable.setVisible(false);
           Table.setVisible(false);
           
           s3.Ltexte22.setVisible(false);   // stock
           s3.Ltexte22.setVisible(false);
           s3.JTable4.setVisible(false);
           s3.Table4.setVisible(false);
       
        }  
         if(e.getSource()== r.Bstoc3)
        { 
         r.FbuttonT.setBounds(930,370,16, 16);
         r.FbuttonT.setVisible(true);
             Actualiser();
           Ltexte12.setVisible(false);  // nouveau
           JTable.setVisible(false);
           Table.setVisible(false);
           
           r.Ltexte12.setVisible(false);  // utiliser
           r.JTable3.setVisible(false);
           r.Table3.setVisible(false);
           
          s3.Table4.setViewportView(s3.JTable4);
          Fond_Stock.add(s3.Table4);
          Fond_Stock.add(s3.Ltexte22);
          AfficherCorbeille();
          s3.Ltexte22.setVisible(true);
          s3.Ltexte22.setVisible(true);
          s3.JTable4.setVisible(true);
          s3.Table4.setVisible(true);           
        }  
         
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         if (e.getSource()== u.JTable2)
        {
           u.Tnom2.setSelectedItem(String.valueOf(u.JTable2.getValueAt(u.JTable2.getSelectedRow(),1)));
           u.Tdateenregistrement2.setText(String.valueOf(u.JTable2.getValueAt(u.JTable2.getSelectedRow(),2)));
            u.Tident.setText(String.valueOf(u.JTable2.getValueAt(u.JTable2.getSelectedRow(),0)));
         }
           if (e.getSource()== r.JTable3)
        {
           r.Tnom3.setSelectedItem(String.valueOf(r.JTable3.getValueAt(r.JTable3.getSelectedRow(),1)));
           r.Tdatedebut3.setText(String.valueOf(r.JTable3.getValueAt(r.JTable3.getSelectedRow(),2)));
           r.Tident3.setText(String.valueOf(r.JTable3.getValueAt(r.JTable3.getSelectedRow(),0)));
        }
           
          if (e.getSource()== b.B2){
          b.B2.setForeground(new java.awt.Color(2, 115, 197));
          b.B1.setForeground(new java.awt.Color(67, 68, 70));
          b.B3.setForeground(new java.awt.Color(67, 68, 70));
          
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
        
          b.Brecherche.setVisible(false);
          b.Crecherche.setVisible(false);
          b.Trecherche.setVisible(false);
          
          b3.Brecherche3.setVisible(false);
          b3.Crecherche3.setVisible(false);
          b3.Trecherche3.setVisible(false);
          
          b2.Brecherche2.setVisible(true);
          b2.Crecherche2.setVisible(true);
          b2.Trecherche2.setVisible(true);
          b2.Tscroll2.setViewportView(b2.Ttable2);
          Fond_Stock.add(b2.Tscroll2);
          b2.Tscroll2.setVisible(true);
          b2.Ttable2.setVisible(true);
          
          AfficherUtiliser();   
          
          
          Fond_Stock.add(b2.Brecherche2);
          Fond_Stock.add(b2.Crecherche2);
          Fond_Stock.add(b2.Trecherche2);
          
          if(b.Boption.getSelectedItem()=="Eparpillé"){
            
        AfficherUtiliser();
        b2.Tscroll2.setVisible(true);
        b2.Ttable2.setVisible(true);
        
        b2.Tscroll2.setViewportView(b2.Ttable2);
        Fond_Stock.add(b2.Tscroll2);

        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        }
        else if(b.Boption.getSelectedItem()=="Regroupé"){
        AfficherGroupeUtiliser();
        b2.Tscroll2.setVisible(true);
        b2.Ttable2.setVisible(true);
        
        b2.Tscroll2.setViewportView(b2.Ttable2);
        Fond_Stock.add(b2.Tscroll2);

        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        }
            
        else if(b.Boption.getSelectedItem()=="Graphe"){
           b2.Tscroll2.setVisible(false);
           b2.Ttable2.setVisible(false);
           
           b.Tscroll.setVisible(false);
           b.Ttable.setVisible(false);
        
           b3.Tscroll3.setVisible(false);
           b3.Ttable3.setVisible(false);
           
           b.jLabel.setVisible(false);
           b3.jLabel.setVisible(false);
        
           DefaultCategoryDataset datset=new DefaultCategoryDataset();
        for(int i=0;i<=d.AfficherUtiliserGroupe().size();i++){
         try{
                datset.setValue(Integer.valueOf(d.AfficherUtiliserGroupe().get(i).getSquantite()), "Marks", d.AfficherUtiliserGroupe().get(i).getNom());
              }catch(Exception ee){
             
              }
        }
       JFreeChart chart=ChartFactory.createBarChart("","","", datset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartPanel frame=new ChartPanel(chart);
        frame.setVisible(true);
        frame.setBounds(0, 0, 900, 300);
        b2.jLabel.add(frame);
        b2.jLabel.setVisible(true);
        b2.jLabel.setBounds(70,155,900,300);
        Fond_Stock.add(b2.jLabel);}
     }  
          
            if (e.getSource()== b.B3)
        {
          b.B2.setForeground(new java.awt.Color(67, 68, 70));
          b.B1.setForeground(new java.awt.Color(67, 68, 70));
          b.B3.setForeground(new java.awt.Color(2, 115, 197));
        
          b2.Tscroll2.setVisible(false);
          b2.Ttable2.setVisible(false);
        
          b.Tscroll.setVisible(false);
          b.Ttable.setVisible(false);
        
          b.Brecherche.setVisible(false);
          b.Crecherche.setVisible(false);
          b.Trecherche.setVisible(false);
          
          b2.Brecherche2.setVisible(false);
          b2.Crecherche2.setVisible(false);
          b2.Trecherche2.setVisible(false);
          b3.Tscroll3.setViewportView(b3.Ttable3);
          Fond_Stock.add(b3.Tscroll3);
         
          b3.Tscroll3.setVisible(true);
          b3.Ttable3.setVisible(true);
          AfficherCorbeille();  
          
          b3.Brecherche3.setVisible(true);
          b3.Crecherche3.setVisible(true);
          b3.Trecherche3.setVisible(true);
          
          
          Fond_Stock.add(b3.Brecherche3);
          Fond_Stock.add(b3.Crecherche3);
          Fond_Stock.add(b3.Trecherche3);
         
          if(b.Boption.getSelectedItem()=="Eparpillé"){
            AfficherCorbeille();
        b3.Tscroll3.setVisible(true);
        b3.Ttable3.setVisible(true);
        
        b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
        
        b3.Tscroll3.setViewportView(b3.Ttable3);
        Fond_Stock.add(b3.Tscroll3);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        
         }else if(b.Boption.getSelectedItem()=="Regroupé"){
        AfficherGroupeCorbeille();
        b3.Tscroll3.setVisible(true);
        b3.Ttable3.setVisible(true);
        
        b3.Tscroll3.setViewportView(b3.Ttable3);
        Fond_Stock.add(b3.Tscroll3);

        b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b.Tscroll.setVisible(false);
        b.Ttable.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);   
        }
            
        else if(b.Boption.getSelectedItem()=="Graphe"){
           b3.Tscroll3.setVisible(false);
           b3.Ttable3.setVisible(false);
        
           b2.Tscroll2.setVisible(false);
           b2.Ttable2.setVisible(false);
        
           b.Tscroll.setVisible(false);
           b.Ttable.setVisible(false);
           
           b.jLabel.setVisible(false);
           b2.jLabel.setVisible(false);
        
           DefaultCategoryDataset datset=new DefaultCategoryDataset();
        for(int i=0;i<=d.AfficherCorbeilleGroupe().size();i++){
         try{
                datset.setValue(Integer.valueOf(d.AfficherCorbeilleGroupe().get(i).getSquantite()), "Marks", d.AfficherCorbeilleGroupe().get(i).getNom());
              }catch(Exception ee){
             
              }
        }
       JFreeChart chart=ChartFactory.createBarChart("","","", datset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartPanel frame=new ChartPanel(chart);
        frame.setVisible(true);
        frame.setBounds(0, 0, 900, 300);
        b3.jLabel.add(frame);
        b3.jLabel.setVisible(true);
        b3.jLabel.setBounds(70,155,900,300);
        Fond_Stock.add(b3.jLabel);
        }
        }  
            
           if (e.getSource()== b.B1)
        {
          b.B2.setForeground(new java.awt.Color(67, 68, 70));
          b.B1.setForeground(new java.awt.Color(2, 115, 197));
          b.B3.setForeground(new java.awt.Color(67, 68, 70));
          
          b2.Tscroll2.setVisible(false);
          b2.Ttable2.setVisible(false);
        
          b3.Tscroll3.setVisible(false);
          b3.Ttable3.setVisible(false);
        
          b.Brecherche.setVisible(true);
          b.Crecherche.setVisible(true);
          b.Trecherche.setVisible(true);
          b.Tscroll.setViewportView(b.Ttable);
          Fond_Stock.add(b.Tscroll);
          b.Tscroll.setVisible(true);
          b.Ttable.setVisible(true);
          Afficher();   
          
          b2.Brecherche2.setVisible(false);
          b2.Crecherche2.setVisible(false);
          b2.Trecherche2.setVisible(false);
          
          b3.Brecherche3.setVisible(false);
          b3.Crecherche3.setVisible(false);
          b3.Trecherche3.setVisible(false);
          
          
          Fond_Stock.add(b.Brecherche);
          Fond_Stock.add(b.Crecherche);
          Fond_Stock.add(b.Trecherche);
            
        if(b.Boption.getSelectedItem()=="Eparpillé"){
        Afficher();
        b.Tscroll.setVisible(true);
        b.Ttable.setVisible(true);
        
        b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        
        }else if(b.Boption.getSelectedItem()=="Regroupé"){
        AfficherGroupeMateriel();
        b.Tscroll.setVisible(true);
        b.Ttable.setVisible(true);
        
        b.Tscroll.setViewportView(b.Ttable);
        Fond_Stock.add(b.Tscroll);

        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        
        b2.Tscroll2.setVisible(false);
        b2.Ttable2.setVisible(false);
        
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        
        //AfficherGroupeMateriel();    
        }
            
        else if(b.Boption.getSelectedItem()=="Graphe"){
            
           b.Tscroll.setVisible(false);
           b.Ttable.setVisible(false);
          
           b3.Tscroll3.setVisible(false);
           b3.Ttable3.setVisible(false);
        
           b2.Tscroll2.setVisible(false);
           b2.Ttable2.setVisible(false);
           
           b2.jLabel.setVisible(false);
           b3.jLabel.setVisible(false);
        
        DefaultCategoryDataset datset=new DefaultCategoryDataset();
        for(int i=0;i<=d.AfficherMaterielGroupe().size();i++){
         try{
                datset.setValue(Integer.valueOf(d.AfficherMaterielGroupe().get(i).getSquantite()), "Marks", d.AfficherMaterielGroupe().get(i).getNom());
           }catch(Exception ee){
             
           }
        }
        JFreeChart chart=ChartFactory.createBarChart("","","", datset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartPanel frame=new ChartPanel(chart);
        frame.setVisible(true);
        frame.setBounds(0, 0, 900, 300);
        b.jLabel.add(frame);
        b.jLabel.setVisible(true);
        b.jLabel.setBounds(70,155,900,300);
        Fond_Stock.add(b.jLabel);
        }      
    }
    }          

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==u.Bnew2){
        u.FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        u.FbuttonT1.setBounds(850,370,16, 16);
        u.FbuttonT1.setVisible(true);
        }
        if (e.getSource()==u.Buse2){
        u.FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        u.FbuttonT1.setBounds(890,370,16, 16);
        u.FbuttonT1.setVisible(true);
        }
        if (e.getSource()==u.Bstock2){
        u.FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        u.FbuttonT1.setBounds(930,370,16, 16);
        u.FbuttonT1.setVisible(true);
        }
        if (e.getSource()==r.Bnew3){
        r.FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        r.FbuttonT1.setBounds(850,370,16, 16);
        r.FbuttonT1.setVisible(true);
        }
        if (e.getSource()==r.Buse3){
        r.FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        r.FbuttonT1.setBounds(890,370,16, 16);
        r.FbuttonT1.setVisible(true);
        }
        if (e.getSource()==r.Bstoc3){
        r.FbuttonT1.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        r.FbuttonT1.setBounds(930,370,16, 16);
        r.FbuttonT1.setVisible(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==u.Bnew2){
        u.FbuttonT1.setVisible(false);
        }
        if(e.getSource()==u.Buse2){
        u.FbuttonT1.setVisible(false);
        }
        if(e.getSource()==u.Bstock2){
        u.FbuttonT1.setVisible(false);
        }
         if(e.getSource()==r.Bnew3){
        r.FbuttonT1.setVisible(false);
        }
        if(e.getSource()==r.Buse3){
        r.FbuttonT1.setVisible(false);
        }
        if(e.getSource()==r.Bstoc3){
        r.FbuttonT1.setVisible(false);
        }
    }
    
    public void VariableButiliser(){
     // differents methode et fonctions
        u.FbuttonT1.setVisible(true);  Fond_Stock.add(u.FbuttonT1);
        r.FbuttonT.setVisible(false);
       r.FbuttonT1.setVisible(false);
        
        u.FbuttonT.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
        u.FbuttonT.setBounds(850,370,16, 16);
        u.FbuttonT.setVisible(true);
        Fond_Stock.add(u.FbuttonT);
        
         FbuttonT.setVisible(false);
         FbuttonT1.setVisible(false);
        
        // effacement de tous les autres variables dans nouveau
        Lnom.setVisible(false);                 Tnom.setVisible(false);             Bacualiser.setVisible(false);          JTable.setVisible(false);     Bnew1.setVisible(false);
        Lquantite.setVisible(false);            Tdate.setVisible(false);            Bajouter.setVisible(false);            Table.setVisible(false);      Buse1.setVisible(false);
        Ltype.setVisible(false);                Templacement.setVisible(false);     Lpersonnel.setVisible(false);          Tpersonnel.setVisible(false); Bstock1.setVisible(false);
        Ldate.setVisible(false);                Tquantite.setVisible(false);        Bmodifier.setVisible(false);           Ltexte12.setVisible(false);
        Lemplacement.setVisible(false);         Ttype.setVisible(false);                  
        // Afficher les variables de utiliser 
        u.Lcommentaire2.setVisible(true);        u.Tnom2.setVisible(true);                       u.Lpersonnel2.setVisible(true);u.Tpersonnel2.setVisible(true);
        u.Ldatedebut2.setVisible(true);          u.Tquantite2.setVisible(true);             u.Tident.setVisible(true);          
        u.Lnom2.setVisible(true);                u.Tdateenregistrement2.setVisible(true);   u.Bactualiser2.setVisible(true);    u.Ltexte12.setVisible(true);    u.Bnew2.setVisible(true);
        u.Lquantite2.setVisible(true);           u.Tcommentaire2.setVisible(true);          u.Bmodifier2.setVisible(true);     // u.Ltexte13.setVisible(true);    u.Buse2.setVisible (true);
        u.Ldateenregistrement2.setVisible(true); u.Tdatedebut2.setVisible(true);            u.JTable2.setVisible(true);         u.JTable22.setVisible(true);    u.Bstock2.setVisible(true);
                                                 u.Tcommentaire22.setVisible(true);         u.Table2.setVisible(true);          u.Table22.setVisible(true);
        u.Bnew2.setVisible(true);   u.Buse2.setVisible(true);   u.Bstock2.setVisible(true);
                                                 
         // effacement des variables retitrer
          r.Bacualiser3.setVisible(false);       r.LDatedebut3.setVisible(false);         
                  r.Ldatefin3.setVisible(false);           r.JTable3.setVisible(false);
          r.Bmodifier3.setVisible(false);        r.Lemplacement3.setVisible(false);       r.Tdatedebut3.setVisible(false);
          r.Bnouveau3.setVisible(false);         r.Letat3.setVisible(false);              r.Tdatefin3.setVisible(false);    r.Lpersonnel3.setVisible(false); r.Tpersonnel3.setVisible(false);
          r.Bstock3.setVisible(false);           r.LDatedebut3.setVisible(false);         r.Templacement3.setVisible(false);    r.Buse3.setVisible(false);      r.Bstoc3.setVisible(false);
          r.Butiliser3.setVisible(false);        r.Ltype3.setVisible(false);              r.Tnom3.setVisible(false);            r.Table3.setVisible(false);
          r.LNom3.setVisible(false);            r.Lquantite3.setVisible(false);           r.Tquantite3.setVisible(false);       r.Bnew3.setVisible(false);
                                                 r.Ltexte12.setVisible(false);            r.Tetat3.setVisible(false);           r.Ttype3.setVisible(false);
                                                 
                                                 s3.Ltexte22.setVisible(false);     s3.JTable4.setVisible(false);   s3.Table4.setVisible(false);
         u.ligne21.setVisible(true);
         u.ligne22.setVisible(true);
         u.ligne23.setVisible(true);
         
         ligne11.setVisible(false);
         ligne12.setVisible(false);
         ligne13.setVisible(false);
         ligne14.setVisible(false);
         ligne15.setVisible(false);
         ligne16.setVisible(false);
         
         r.ligne31.setVisible(false);
         r.ligne32.setVisible(false);
         r.ligne33.setVisible(false);
         r.ligne34.setVisible(false);
         r.ligne35.setVisible(false);
                                                                                      
         b.B1.setVisible(false);     b.Tscroll.setVisible(false);       b.Bactualiser.setVisible(false);
         b.B3.setVisible(false);     b.Ttable.setVisible(false);
         b.B2.setVisible(false);    b2.Tscroll2.setVisible(false);
         b2.Ttable2.setVisible(false);
         b.jLabelTotalEntree.setVisible(false);
        b.BtotalSortie.setVisible(false);
        
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
        b.B5.setVisible(false);
        b.Brecherche.setVisible(false);
        b.Trecherche.setVisible(false);
        b.Crecherche.setVisible(false);
        b2.Brecherche2.setVisible(false);
          b2.Crecherche2.setVisible(false);
          b2.Trecherche2.setVisible(false);
          
          b3.Brecherche3.setVisible(false);
          b3.Crecherche3.setVisible(false);
          b3.Trecherche3.setVisible(false);
          
        b.ligneBilan.setVisible(false); 
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        
    }
    
    public void VariableBnew(){
        Lquantite.setBorder(null);
     FbuttonT.setVisible(true);
        FbuttonT1.setVisible(true);
        
        u.FbuttonT.setVisible(false);
        u.FbuttonT1.setVisible(false);
        
        r.FbuttonT.setVisible(false);
        r.FbuttonT1.setVisible(false);
        // Affichage de tous ses variables dans nouveau
        Lnom.setVisible(true);                 Tnom.setVisible(true);             Bacualiser.setVisible(true);          Table.setVisible(true);         Lpersonnel.setVisible(true);
        Lquantite.setVisible(true);            Tdate.setVisible(true);            Bajouter.setVisible(true);            JTable.setVisible(true);
        Ltype.setVisible(true);                Templacement.setVisible(true);     Ltexte12.setVisible(true);            Tpersonnel.setVisible(true);    Bstock1.setVisible(true);
        Ldate.setVisible(true);                Tquantite.setVisible(true);        Bmodifier.setVisible(true);           Bnew1.setVisible(true);         Buse1.setVisible(true);
        Lemplacement.setVisible(true);         Ttype.setVisible(true);           // Brecherche.setVisible(true);    
        
        Afficher();
        // Afficher les variables de utiliser 
        u.Lcommentaire2.setVisible(false);        u.Tnom2.setVisible(false);                      u.Ltexte12.setVisible(false);          u.Bnew2.setVisible(false);
        u.Ldatedebut2.setVisible(false);          u.Tquantite2.setVisible(false);             u.Lpersonnel2.setVisible(false);    u.Tpersonnel2.setVisible(false);      u.Buse2.setVisible(false);
        u.Lnom2.setVisible(false);                u.Tdateenregistrement2.setVisible(false);   u.Bactualiser2.setVisible(false);   u.Ltexte13.setVisible(false);         u.Bstock2.setVisible(false);
        u.Lquantite2.setVisible(false);           u.Tcommentaire2.setVisible(false);          u.Bmodifier2.setVisible(false);      u.Bnew2.setVisible(false);   u.Buse2.setVisible(false);    u.Bstock2.setVisible(false);
        u.Tdateenregistrement2.setVisible(false); u.Tdatedebut2.setVisible(false);            u.Tcommentaire22.setVisible(false);   u.Tdateenregistrement2.setVisible(false);u.Ldateenregistrement2.setVisible(false);
                                                  u.JTable22.setVisible(false);u.Table22.setVisible(false);      u.JTable2.setVisible(false); u.Table2.setVisible(false);
        
        // effacement des variables retitrer
          r.Bacualiser3.setVisible(false);       r.LDatedebut3.setVisible(false);         r.JTable3.setVisible(false);
                 r.Ldatefin3.setVisible(false);           r.Bmodifier3.setVisible(false);        r.Lemplacement3.setVisible(false);       r.Tdatedebut3.setVisible(false);
          r.Bnouveau3.setVisible(false);         r.Letat3.setVisible(false);              r.Tdatefin3.setVisible(false);        r.Table3.setVisible(false);
          r.Bstock3.setVisible(false);           r.LDatedebut3.setVisible(false);         r.Templacement3.setVisible(false);   r.Lpersonnel3.setVisible(false); r.Tpersonnel3.setVisible(false); 
          r.Butiliser3.setVisible(false);        r.Ltype3.setVisible(false);              r.Tnom3.setVisible(false);            r.Bnew3.setVisible(false);
                                                 r.Lquantite3.setVisible(false);          r.Tquantite3.setVisible(false);       r.Buse3.setVisible(false);
                                                 r.Tetat3.setVisible(false);              r.Ltexte12.setVisible(false);         r.Bstoc3.setVisible(false);
                                                 r.Ttype3.setVisible(false);              r.LNom3.setVisible(false);
          
         u.ligne21.setVisible(false);
        u.ligne23.setVisible(false);
         u.ligne22.setVisible(false);
          
         ligne11.setVisible(true);
         ligne12.setVisible(true);
         ligne13.setVisible(true);
         ligne14.setVisible(true);
         ligne15.setVisible(true);
         ligne16.setVisible(true);
         
         u.ligne21.setVisible(false);
         u.ligne22.setVisible(false);
         r.ligne31.setVisible(false);
         r.ligne32.setVisible(false);
         r.ligne33.setVisible(false);
         r.ligne34.setVisible(false);
         r.ligne35.setVisible(false);
         
         s3.Ltexte22.setVisible(false);     s3.JTable4.setVisible(false);   s3.Table4.setVisible(false);           
                                
         b.B1.setVisible(false);     b.Tscroll.setVisible(false);
         b.B3.setVisible(false);     b.Ttable.setVisible(false);
         b.B2.setVisible(false);     
         b2.Tscroll2.setVisible(false);     b.Bactualiser.setVisible(false);
         b2.Ttable2.setVisible(false);
        b.jLabelTotalEntree.setVisible(false);
        b.BtotalSortie.setVisible(false);
        
         
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);
         
         b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        b.B5.setVisible(false);
        b.Brecherche.setVisible(false);
        b.Trecherche.setVisible(false);
        b.Crecherche.setVisible(false);
        b2.Brecherche2.setVisible(false);
        b2.Crecherche2.setVisible(false);
        b2.Trecherche2.setVisible(false);
        b.ligneBilan.setVisible(false);  
          b3.Brecherche3.setVisible(false);
          b3.Crecherche3.setVisible(false);
          b3.Trecherche3.setVisible(false);
          
    }
    
    public void VariableRetirer(){
         // effacer les variables de utiliser 
       r.FbuttonT.setIcon(new ImageIcon(getClass().getResource("/image/Btab2.jpg")));
       r.FbuttonT.setBounds(890,370,16, 16);
       r.FbuttonT.setVisible(true);
       
       r.FbuttonT.setVisible(true);
       r.FbuttonT1.setVisible(true);
       
       Fond_Stock.add(r.FbuttonT);
       Fond_Stock.add(r.FbuttonT1);
       
       u.FbuttonT.setVisible(false);
       u.FbuttonT1.setVisible(false);
       
       FbuttonT.setVisible(false);
       FbuttonT1.setVisible(false);
       
         // Afficher les variables de utiliser 
        u.Lcommentaire2.setVisible(false);        u.Tnom2.setVisible(false);                        u.Ltexte12.setVisible(false);
        u.Ldatedebut2.setVisible(false);          u.Tquantite2.setVisible(false);             u.Lpersonnel2.setVisible(false);        u.Tpersonnel2.setVisible(false);  
        u.Lnom2.setVisible(false);                u.Tdateenregistrement2.setVisible(false);   u.Bactualiser2.setVisible(false);      u.Ltexte13.setVisible(false);
        u.Lquantite2.setVisible(false);           u.Tcommentaire2.setVisible(false);          u.Bmodifier2.setVisible(false);       u.Tdateenregistrement2.setVisible(false);
        u.Ldateenregistrement2.setVisible(false); u.Tdatedebut2.setVisible(false);            u.Bnew2.setVisible(false);            u.Buse2.setVisible(false);    
        u.Tdateenregistrement2.setVisible(false); u.Tcommentaire22.setVisible(false);         u.Bstock2.setVisible(false);
                                                  u.JTable22.setVisible(false);u.Table22.setVisible(false);      u.JTable2.setVisible(false);u.Table2.setVisible(false);
        
        // affichage de ses variables
          r.Bacualiser3.setVisible(true);       r.LDatedebut3.setVisible(true);      
                r.Ldatefin3.setVisible(true);         
          r.Bmodifier3.setVisible(true);        r.Tdatedebut3.setVisible(true);         r.Tpersonnel3.setVisible(true); r.Lpersonnel3.setVisible(true); r.Tpersonnel3.setVisible(true);
          r.Bnouveau3.setVisible(true);         r.Letat3.setVisible(true);              r.Tdatefin3.setVisible(true);
          r.Bstock3.setVisible(true);           r.LDatedebut3.setVisible(true);         r.JTable3.setVisible(true);     r.Bnew3.setVisible(true);
          r.Butiliser3.setVisible(true);        r.Tnom3.setVisible(true);               r.Table3.setVisible(true);      r.Buse3.setVisible(true);
          r.Lquantite3.setVisible(true);        r.LNom3.setVisible(true);               r.Tquantite3.setVisible(true);  r.Bstoc3.setVisible(true);
                                                r.Tetat3.setVisible(true);              r.Ltexte12.setVisible(true);                            
        // effacement des variables nouveau dans retiter
        Lnom.setVisible(false);                 Tnom.setVisible(false);             Bacualiser.setVisible(false);   Lpersonnel.setVisible(false);                  
        Lquantite.setVisible(false);            Tdate.setVisible(false);            Bajouter.setVisible(false);     Tpersonnel.setVisible(false);       
        Ltype.setVisible(false);                Templacement.setVisible(false);     Ltexte12.setVisible(false);     Bnew1.setVisible(false);
        Ldate.setVisible(false);                Tquantite.setVisible(false);        Bmodifier.setVisible(false);    Buse1.setVisible(false);
        Lemplacement.setVisible(false);         Ttype.setVisible(false);            JTable.setVisible(false);       Table.setVisible(false);
        Bstock1.setVisible(false);
    
        u.ligne21.setVisible(false);
         u.ligne22.setVisible(false);
         u.ligne23.setVisible(false);
         
          ligne11.setVisible(false);
         ligne12.setVisible(false);
         ligne13.setVisible(false);
         ligne14.setVisible(false);
         ligne15.setVisible(false);
        ligne16.setVisible(false);
         
         r.ligne31.setVisible(true);
         r.ligne32.setVisible(true);
         r.ligne33.setVisible(true);
         r.ligne34.setVisible(true);
         r.ligne35.setVisible(true);
         
        s3.Ltexte22.setVisible(false);     s3.JTable4.setVisible(false);   s3.Table4.setVisible(false);
        
         b.B1.setVisible(false);     b.Tscroll.setVisible(false);
         b.B3.setVisible(false);     b.Ttable.setVisible(false);
         b.B2.setVisible(false);    b2.Tscroll2.setVisible(false);
         b2.Ttable2.setVisible(false);
         b.jLabelTotalEntree.setVisible(false);
        b.BtotalSortie.setVisible(false);
        
         
        b3.Tscroll3.setVisible(false);      b.Bactualiser.setVisible(false);
        b3.Ttable3.setVisible(false);
        b.B5.setVisible(false);
        b.Brecherche.setVisible(false);
        b.Trecherche.setVisible(false);
        b.Crecherche.setVisible(false);
        b2.Brecherche2.setVisible(false);
          b2.Crecherche2.setVisible(false);
          b2.Trecherche2.setVisible(false);
          
          b3.Brecherche3.setVisible(false);
          b3.Crecherche3.setVisible(false);
          b3.Trecherche3.setVisible(false);
          
        b.ligneBilan.setVisible(false);
        b.jLabel.setVisible(false);
        b2.jLabel.setVisible(false);
        b3.jLabel.setVisible(false);
        
    }
    
    public void VariableBilan(){
        
        FbuttonT.setVisible(false);
       u.FbuttonT.setVisible(false);
       r.FbuttonT.setVisible(false);
       FbuttonT1.setVisible(false);
       u.FbuttonT1.setVisible(false);
       r.FbuttonT1.setVisible(false);
       
        
        Lnom.setVisible(false);                 Tnom.setVisible(false);             Bacualiser.setVisible(false);          JTable.setVisible(false);     Bnew1.setVisible(false);
        Lquantite.setVisible(false);            Tdate.setVisible(false);            Bajouter.setVisible(false);            Table.setVisible(false);      Buse1.setVisible(false);
        Ltype.setVisible(false);                Templacement.setVisible(false);     Lpersonnel.setVisible(false);          Tpersonnel.setVisible(false); Bstock1.setVisible(false);
        Ldate.setVisible(false);                Tquantite.setVisible(false);        Bmodifier.setVisible(false);           Ltexte12.setVisible(false);
        Lemplacement.setVisible(false);         Ttype.setVisible(false);                  
        // Afficher les variables de utiliser 
        u.Lcommentaire2.setVisible(false);        u.Tnom2.setVisible(false);                  u.Lpersonnel2.setVisible(false);u.Tpersonnel2.setVisible(false);
        u.Ldatedebut2.setVisible(false);          u.Tquantite2.setVisible(false);             u.Tident.setVisible(false);
        u.Lnom2.setVisible(false);                u.Tdateenregistrement2.setVisible(false);   u.Bactualiser2.setVisible(false);    u.Ltexte12.setVisible(false);    u.Bnew2.setVisible(false);
        u.Lquantite2.setVisible(false);           u.Tcommentaire2.setVisible(false);          u.Bmodifier2.setVisible(false);      u.Ltexte13.setVisible(false);    u.Buse2.setVisible (false);
        u.Ldateenregistrement2.setVisible(false); u.Tdatedebut2.setVisible(false);            u.JTable2.setVisible(false);         u.JTable22.setVisible(false);    u.Bstock2.setVisible(false);
                                                 u.Tcommentaire22.setVisible(false);         u.Table2.setVisible(false);          u.Table22.setVisible(false);
                                                                                                
         // effacement des variables retitrer
          r.Bacualiser3.setVisible(false);       r.LDatedebut3.setVisible(false);         
          r.Ldatefin3.setVisible(false);           r.JTable3.setVisible(false);
          r.Bmodifier3.setVisible(false);        r.Lemplacement3.setVisible(false);       r.Tdatedebut3.setVisible(false);
          r.Bnouveau3.setVisible(false);         r.Letat3.setVisible(false);              r.Tdatefin3.setVisible(false);    r.Lpersonnel3.setVisible(false); r.Tpersonnel3.setVisible(false);
          r.Bstock3.setVisible(false);           r.LDatedebut3.setVisible(false);         r.Templacement3.setVisible(false);    r.Buse3.setVisible(false);      r.Bstoc3.setVisible(false);
          r.Butiliser3.setVisible(false);        r.Ltype3.setVisible(false);              r.Tnom3.setVisible(false);            r.Table3.setVisible(false);
          r.LNom3.setVisible(false);            r.Lquantite3.setVisible(false);           r.Tquantite3.setVisible(false);       r.Bnew3.setVisible(false);
                                                 r.Ltexte12.setVisible(false);            r.Tetat3.setVisible(false);           r.Ttype3.setVisible(false);
                                                 
                                                 s3.Ltexte22.setVisible(false);     s3.JTable4.setVisible(false);   s3.Table4.setVisible(false);
         u.ligne21.setVisible(false);
         u.ligne22.setVisible(false);
         u.ligne23.setVisible(false);
         
          ligne11.setVisible(false);
         ligne12.setVisible(false);
         ligne13.setVisible(false);
         ligne14.setVisible(false);
         ligne15.setVisible(false);
         ligne16.setVisible(false);
         
         r.ligne31.setVisible(false);
         r.ligne32.setVisible(false);
         r.ligne33.setVisible(false);
         r.ligne34.setVisible(false);
         r.ligne35.setVisible(false);
                  
         b.B1.setVisible(true);     b.Tscroll.setVisible(true);
         b.B3.setVisible(true);         b.Ttable.setVisible(true);
         b.B2.setVisible(true);     b.BtotalEntrer.setVisible(true);          b.B4.setVisible(true);
         
         b2.Tscroll2.setVisible(false);             
         b2.Ttable2.setVisible(false);
        
        b3.Tscroll3.setVisible(false);
        b3.Ttable3.setVisible(false);       
        
        b.B5.setVisible(true);
        b.Brecherche.setVisible(true);
        b.Trecherche.setVisible(true);
        b.Crecherche.setVisible(true);
        
        b2.Brecherche2.setVisible(false);
          b2.Crecherche2.setVisible(false);
          b2.Trecherche2.setVisible(false);
          
          b3.Brecherche3.setVisible(false);
          b3.Crecherche3.setVisible(false);
          b3.Trecherche3.setVisible(false);
          
        b.Bactualiser.setVisible(true);
       
    }
}