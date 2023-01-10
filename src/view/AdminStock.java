/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Snow
 */
public class AdminStock extends javax.swing.JFrame implements ActionListener, MouseListener {
 Connection connex;
 Statement etat; 
 StringBuffer sql;
 ResultSet res;
 
   // stock s = new stock();
    int xMouse,yMouse;
//    Database d= new Database();
    AdminStock2 s2 = new AdminStock2();
    AdminStock3 s3 = new AdminStock3();
    MessErreur m= new MessErreur();
    MessVrai m2= new MessVrai();
    TestAdmin t=new TestAdmin();
    AdminStock4 s4=new AdminStock4();

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

  
    public AdminStock() {
        initComponents();
        Tquantite.setText("0");
        s2.Tquantite2.setText("0");
        s3.Tquantite3.setText("0");
        s4.Tquantite4.setText("0");
        //  crud = new Database();
        d = getConnection(hoteDist);
        Afficher();
        choixpers();
        AfficherBilan();
        ChoixAnnee();
    //    connexionBase();         
    }
  /*  
      public void connexionBase (){
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
 public void Actualiser(){
     Afficher();
     Afficher2();
     AfficherCorbeille();
     AfficherBilan();
//     connexionBase();
 }     
 
 public void ActualiserAdmin1(){
     Tnom.setText("");
     Tdate.setText("");
     Templacement.setText("");
     Ttype.setText("");
     Afficher();
     Afficher2();
     AfficherCorbeille();
     AfficherBilan();
 }
 
 public void ActualiserAdmin2(){
     s2.Tnom2.setText("");
     s2.Tdate2.setText("");
     s2.Tcommentaire2.setText("");
     Afficher();
     Afficher2();
     AfficherCorbeille();
     AfficherBilan();
 }
 
 public void ActualiserAdmin3(){
     s3.Tnom3.setText("");
     s3.Tdate3.setText("");
     Afficher();
     Afficher2();
     AfficherCorbeille();
     AfficherBilan();
 }
 
 public void ActualiserAdmin4(){
     s4.Tnom4.setText("");
     s4.TAnnee4.setText("");
     s4.Ttype4.setText("");
     Afficher();
     Afficher2();
     AfficherCorbeille();
     AfficherBilan();
 }
 // -------------------------------  DEBUT AFFICHAGE    -------------------------------------- // 
 
  public void Afficher(){                       //  passe par Database
      try{
          JTable.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Etat","Emplacement","Type","Personnel"},d.AfficherMateriel().size()));           
            for(int i=0;i<=d.AfficherMateriel().size();i++){
                JTable.setValueAt (d.AfficherMateriel().get(i).getId_mat(),i,0);  
                JTable.setValueAt (d.AfficherMateriel().get(i).getNom(),i,1);
                JTable.setValueAt (d.AfficherMateriel().get(i).getDate(),i,2);
                JTable.setValueAt (d.AfficherMateriel().get(i).getSquantite(),i,3);
                JTable.setValueAt (d.AfficherMateriel().get(i).getEtat(),i,4);
                JTable.setValueAt (d.AfficherMateriel().get(i).getEmplacement(),i,5);
                JTable.setValueAt (d.AfficherMateriel().get(i).getType(),i,6);
                JTable.setValueAt (d.AfficherMateriel().get(i).getId_pers(),i,7);
           //   JOptionPane.showMessageDialog(null, d.AfficherMateriel().get(i).getId_pers());
            }
        }
        catch (Exception e){
   //         JOptionPane.showMessageDialog(null, e.getMessage());
  }

}
  
public void Afficher2(){                // passe par Database
//    connexionBase();
    try{
          s2.JTable2.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Commentaire","Personnel"},d.AfficherUtiliser().size()));
            for(int i=0;i<=d.AfficherUtiliser().size();i++){
                s2.JTable2.setValueAt (d.AfficherUtiliser().get(i).getId_mat(),i,0);  
                s2.JTable2.setValueAt (d.AfficherUtiliser().get(i).getNom(),i,1);
                s2.JTable2.setValueAt (d.AfficherUtiliser().get(i).getDate(),i,2);
                s2.JTable2.setValueAt (d.AfficherUtiliser().get(i).getSquantite(),i,3);
                s2.JTable2.setValueAt (d.AfficherUtiliser().get(i).getCommentaire(),i,4);
                s2.JTable2.setValueAt (d.AfficherUtiliser().get(i).getId_pers(),i,5);   
                }
        }
            catch (Exception e){
     //           JOptionPane.showMessageDialog(null, e.getMessage());
}
}

 public void AfficherCorbeille(){
//   connexionBase();
     try{
         s3.JTable3.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Date","Quantité","Personnel"},d.AfficherCorbeille().size()));
            for(int i=0;i<=d.AfficherCorbeille().size();i++){
                s3.JTable3.setValueAt (d.AfficherCorbeille().get(i).getId_mat(),i,0);  
                s3.JTable3.setValueAt (d.AfficherCorbeille().get(i).getNom(),i,1);
                s3.JTable3.setValueAt (d.AfficherCorbeille().get(i).getDate(),i,2);
                s3.JTable3.setValueAt (d.AfficherCorbeille().get(i).getSquantite(),i,3);
                s3.JTable3.setValueAt (d.AfficherCorbeille().get(i).getId_pers(),i,4);
    }
    }
    catch (Exception e){
       // JOptionPane.showMessageDialog(null, e.getMessage());
}
    }
 
 public void AfficherBilan(){                // passe par Database
//    connexionBase();
    try{
          s4.JTable4.setModel(new DefaultTableModel(new String []{"Identifiant","Nom","Année","Quantité","Type"},d.AfficherBilanAdmin().size()));
            for(int i=0;i<=d.AfficherBilanAdmin().size();i++){
                s4.JTable4.setValueAt (d.AfficherBilanAdmin().get(i).getId_mat(),i,0);  
                s4.JTable4.setValueAt (d.AfficherBilanAdmin().get(i).getNom(),i,1);
                s4.JTable4.setValueAt (d.AfficherBilanAdmin().get(i).getNombre(),i,2);
                s4.JTable4.setValueAt (d.AfficherBilanAdmin().get(i).getSquantite(),i,3);
                s4.JTable4.setValueAt (d.AfficherBilanAdmin().get(i).getType(),i,4);   
                }
        }
            catch (Exception e){
         //       JOptionPane.showMessageDialog(null, e.getMessage());
            }
 }
 
public void choixpers(){
//    connexionBase();
     try{
            for(int i=0;i<=d.ChoixPers().size();i++){
                Tpersonnel.addItem(d.ChoixPers().get(i).getNom());
                s2.Tpersonnel2.addItem(d.ChoixPers().get(i).getNom());
                s3.Tpersonnel3.addItem(d.ChoixPers().get(i).getNom());
            }   
            }catch(Exception e){
//        JOptionPane.showMessageDialog(null, e.getMessage());            
            }
}  

 public void ChoixAnnee(){
       try{
            for(int i=0;i<=d.ChoixAnnee().size();i++){
                s4.CcomboAnnee4.addItem(d.ChoixAnnee().get(i).getNom());
            }   
            }catch(Exception e){
//        JOptionPane.showMessageDialog(null, e.getMessage());            
            } 
    }
    //  ***********************************     FIN AFFICHAGE ************************************ ///


    //  ------------------------------------    DEBUT MODIFICATION ET SUPPRESSION ------------------------ //

 public void Modifier (){                           /// Passe par Database
    int a = Integer.valueOf(Tquantite.getText().toString());
  try{
//     connexionBase();
    if (Tnom.getText().equals("") ||
            Tdate.getText().equals("") ||
            Tquantite.getText().equals("") ||
            Templacement.getText().equals("") ||
            Ttype.getText().equals("") ){
        m.setVisible(true);
        m.ErreurTexte.setVisible(true);
        m.ErreurTexte.setText(" Remplissez les zones de saisie ");
    }else{
        if (a < 0){
      m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
    }else{
        //JOptionPane.showMessageDialog(this, Tident.getText());
        Materiel m = new Materiel(Tnom.getText(),Tdate.getText(),Tquantite.getText(),Templacement.getText(),Ttype.getText(),(String)Tpersonnel.getSelectedItem());
        d.ModifierMateriel(m.getNom(), m.getDate(), m.getSquantite(), m.getEmplacement(), m.getType(), m.getId_pers(), Tident.getText());
     m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel modifier ");
      }
    }
    }  catch(Exception e){
             JOptionPane.showMessageDialog(this,e.getMessage());//+);//e.getMessage());
 }

 }    

 
 public void Modifier2 (){                                           // Passe par Database
//    connexionBase();
    int a = Integer.valueOf(s2.Tquantite2.getText().toString());
  
    try{
        
        if (s2.Tnom2.getText().equals("") ||
                 s2.Tdate2.getText().equals("") ||
                 s2.Tquantite2.getText().equals("") ||
                 s2.Tcommentaire2.getText().equals("") ){
        m.setVisible(true);
        m.ErreurTexte.setVisible(true);
        m.ErreurTexte.setText(" Remplissez les zones de saisie ");
            
            //     JOptionPane.showMessageDialog(this, " Remplissez les zones de saisie ");
             }else{
            
      if (a < 0){
      m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
    }else{
        Materiel m = new Materiel(s2.Tnom2.getText(), s2.Tdate2.getText(), s2.Tquantite2.getText(), s2.Tcommentaire2.getText(), (String)s2.Tpersonnel2.getSelectedItem());
        d.ModifierUtiliser(m.getNom(), m.getDate(), m.getSquantite(), m.getCommentaire(), m.getId_pers(), s2.Tident2.getText());
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel modifier ");
      }
    }
        }  catch(Exception e){
             JOptionPane.showMessageDialog(this,e.getMessage());//+);//e.getMessage());
     }
    
 }
public void Modifier3(){                                // Passe par Database
    int a = Integer.valueOf(s3.Tquantite3.getText().toString());  
//    connexionBase();
    try{
        if (s3.Tnom3.getText().equals("") ||
            s3.Tdate3.getText().equals("") ||
            s3.Tquantite3.getText().equals("") ){
        m.setVisible(true);
        m.ErreurTexte.setVisible(true);
        m.ErreurTexte.setText(" Remplissez les zones de saisie ");
        }else{
      if (a < 0){
      m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
    }else{
            Materiel m = new Materiel(s3.Tnom3.getText(), s3.Tdate3.getText(), s3.Tquantite3.getText(),(String) s3.Tpersonnel3.getSelectedItem());
            d.ModifierCorbeille(m.getNom(), m.getDate(), m.getSquantite(), m.getId_pers(), s3.Tident3.getText());
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel modifier ");
        }
    }
    }catch(Exception e){
             JOptionPane.showMessageDialog(this,e.getMessage());//+);//e.getMessage());
     }
     
}
  
public void Modifier4Bilan(){                                // Passe par Database
//    connexionBase();
    int a = Integer.valueOf(s4.Tquantite4.getText().toString());
  
//   JOptionPane.showMessageDialog(this, a);
    try{
        if (s4.Tnom4.getText().equals("") ||
            s4.TAnnee4.getText().equals("") ||
            s4.Ttype4.getText().equals("")){
        m.setVisible(true);
        m.ErreurTexte.setVisible(true);
        m.ErreurTexte.setText(" Remplissez les zones de saisie ");
        }else{
     
   if (a < 0){
      m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
    }else{   
          Materiel m = new Materiel(s4.Tnom4.getText(), s4.TAnnee4.getText(), s4.Tquantite4.getText(),s4.Ttype4.getText());
          d.ModifierBilanAdmin(m.getNom(), m.getDate(), m.getSquantite(), m.getId_pers(), s4.Tid_bilan.getText());
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Bilan modifier ");
   }
    }
    }    catch(Exception e){
//             JOptionPane.showMessageDialog(this,e.getMessage());//+);//e.getMessage());
     }
     
}
 
public void Supprimer(){
        d.SuppMateriel(Tident.getText());
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel supprimer ");
//      d.SupprimerMateriel(Tident.getText());
///  connexionBase();
        
} 

public void Supprimer2(){
//  connexionBase();
 /* m2.setVisible(true);
  m2.ErreurTexte.setVisible(true);
  m2.ErreurTexte.setText(" Matériel supprimer ");
  
  d.SupprimerUtiliser(s2.Tident2.getText());
  *//*
 try {
    // JOptionPane.showMessageDialog(this,s2.Tident2.getText());
   String req="delete  from utiliser where Id_utiliser ='"+s2.Tident2.getText()+"' ";
   sql.append(req);
   etat.executeUpdate(sql.toString());   
   JOptionPane.showMessageDialog(this,"materiel supprimer");
   }
   catch (SQLException e){
   JOptionPane.showMessageDialog(this,"materiel non supprimer");   

}*/
} 

/*public void Supprimer3(){
//  connexionBase();
  m2.setVisible(true);
  m2.ErreurTexte.setVisible(true);
  m2.ErreurTexte.setText(" Matériel supprimer ");
      
  d.SupprimerStock(s3.Tident3.getText());
} 

public void Supprimer4(){
//  connexionBase();
  m2.setVisible(true);
  m2.ErreurTexte.setVisible(true);
  m2.ErreurTexte.setText(" Matériel supprimer ");
      
  d.SupprimerbilanAdmin(s4.Tid_bilan.getText());
}

public void Supprimer4Tous(){
  String anne=s4.CcomboAnnee4.getSelectedItem().toString();
//  connexionBase();
  
  d.Supprimer_Tous_bilanAdmin(anne);
  m2.setVisible(true);
  m2.ErreurTexte.setVisible(true);
  m2.ErreurTexte.setText(" Matériel supprimer ");
}
*/

public void TestQM(){
  int a = Integer.valueOf(Tquantite.getText().toString());
  if (a < 0){
      m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
        
      //JOptionPane.showMessageDialog(this, "Entree un nombre positif ");
  }else {
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel modifier ");
      
        Modifier();                                                         // Interagie avec Database
        
  }  
}   
public void TestQM2(){
  int a = Integer.valueOf(s2.Tquantite2.getText().toString());
  if (a < 0){
    m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
        
      //JOptionPane.showMessageDialog(this, "Entree un nombre positif ");
  }else {
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel modifier ");
      
        Modifier2();                                                        // Interagie avec Database
  }  
}   

public void TestQM3(){
  int a = Integer.valueOf(s3.Tquantite3.getText().toString());
  if (a < 0){
      m.setVisible(true);
      m.ErreurTexte.setVisible(true);
      m.ErreurTexte.setText(" Entrée un nombre positif ");
      
      //JOptionPane.showMessageDialog(this, "Entree un nombre positif ");
  }else {
      m2.setVisible(true);
      m2.ErreurTexte.setVisible(true);
      m2.ErreurTexte.setText(" Matériel modifier ");
      
        Modifier3();                                                        // Interagie avec Database
  }  
}   

public void TestQM4(){
   
 
}   


public void TestQS()
{
        Supprimer();  
}    

/*public void TestQS2()
{
        Supprimer2();  
}    

public void TestQS3()
{
        Supprimer3();  
}    
    
public void TestQS4()
{
        Supprimer4();  
}    
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stockligne15 = new javax.swing.JLabel();
        stockligne14 = new javax.swing.JLabel();
        ligne15 = new javax.swing.JLabel();
        stockligne11 = new javax.swing.JLabel();
        stockligne12 = new javax.swing.JLabel();
        stockligne13 = new javax.swing.JLabel();
        Bbilan = new javax.swing.JLabel();
        LFpassePressed = new javax.swing.JLabel();
        LFpasse1 = new javax.swing.JLabel();
        retour = new javax.swing.JLabel();
        barre = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        ferm2 = new javax.swing.JLabel();
        Lnom = new javax.swing.JLabel();
        Ldate = new javax.swing.JLabel();
        Lquantite = new javax.swing.JLabel();
        Tnom = new javax.swing.JTextField();
        Lemplacement = new javax.swing.JLabel();
        Ltype = new javax.swing.JLabel();
        Templacement = new javax.swing.JTextField();
        Ttype = new javax.swing.JTextField();
        Ltexte12 = new javax.swing.JLabel();
        Lpersonnel = new javax.swing.JLabel();
        Tpersonnel = new javax.swing.JComboBox();
        Tquantite = new javax.swing.JTextField();
        Table = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        LdispoStock = new javax.swing.JLabel();
        Lutilisation = new javax.swing.JLabel();
        Linutilisable = new javax.swing.JLabel();
        Bmodifier = new javax.swing.JButton();
        Bsupprimer = new javax.swing.JButton();
        Bactualiser = new javax.swing.JButton();
        deconecter = new javax.swing.JLabel();
        Tdate = new javax.swing.JTextField();
        Fond_Stock = new javax.swing.JLabel();
        Lemplacement1 = new javax.swing.JLabel();
        Tetat = new javax.swing.JTextField();
        Tident = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        getContentPane().setLayout(null);

        stockligne15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne15.setText("jLabel2");
        getContentPane().add(stockligne15);
        stockligne15.setBounds(250, 270, 230, 2);

        stockligne14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne14.setText("jLabel2");
        getContentPane().add(stockligne14);
        stockligne14.setBounds(700, 210, 230, 2);

        ligne15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne15.setText("jLabel2");
        getContentPane().add(ligne15);
        ligne15.setBounds(250, 150, 230, 2);

        stockligne11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne11.setText("jLabel2");
        getContentPane().add(stockligne11);
        stockligne11.setBounds(250, 150, 230, 2);

        stockligne12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne12.setText("jLabel2");
        getContentPane().add(stockligne12);
        stockligne12.setBounds(250, 210, 230, 2);

        stockligne13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne13.setText("jLabel2");
        getContentPane().add(stockligne13);
        stockligne13.setBounds(700, 150, 230, 2);

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

        LFpassePressed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(LFpassePressed);
        LFpassePressed.setBounds(50, 30, 151, 50);

        LFpasse1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(LFpasse1);
        LFpasse1.setBounds(190, 40, 151, 50);

        retour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                retourMousePressed(evt);
            }
        });
        getContentPane().add(retour);
        retour.setBounds(10, 10, 30, 20);

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

        Lnom.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Lnom.setForeground(new java.awt.Color(67, 68, 70));
        Lnom.setText("Nom matériel");
        getContentPane().add(Lnom);
        Lnom.setBounds(90, 120, 100, 30);

        Ldate.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Ldate.setForeground(new java.awt.Color(67, 68, 70));
        Ldate.setText("Date enregistrement");
        getContentPane().add(Ldate);
        Ldate.setBounds(90, 180, 140, 30);

        Lquantite.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Lquantite.setForeground(new java.awt.Color(67, 68, 70));
        Lquantite.setText("Quantité");
        getContentPane().add(Lquantite);
        Lquantite.setBounds(90, 240, 70, 30);

        Tnom.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tnom.setForeground(new java.awt.Color(2, 115, 197));
        Tnom.setBorder(null);
        Tnom.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Tnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnomActionPerformed(evt);
            }
        });
        getContentPane().add(Tnom);
        Tnom.setBounds(250, 120, 230, 30);

        Lemplacement.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Lemplacement.setForeground(new java.awt.Color(67, 68, 70));
        Lemplacement.setText("Emplacement");
        getContentPane().add(Lemplacement);
        Lemplacement.setBounds(540, 120, 120, 30);

        Ltype.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Ltype.setForeground(new java.awt.Color(67, 68, 70));
        Ltype.setText("Type");
        getContentPane().add(Ltype);
        Ltype.setBounds(540, 180, 120, 30);

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

        Ltexte12.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        Ltexte12.setForeground(new java.awt.Color(2, 115, 197));
        Ltexte12.setText("Listes des matériels disponibles");
        getContentPane().add(Ltexte12);
        Ltexte12.setBounds(90, 360, 280, 30);

        Lpersonnel.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Lpersonnel.setForeground(new java.awt.Color(67, 68, 70));
        Lpersonnel.setText("Personnel ");
        getContentPane().add(Lpersonnel);
        Lpersonnel.setBounds(540, 240, 100, 30);

        Tpersonnel.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 13)); // NOI18N
        Tpersonnel.setForeground(new java.awt.Color(2, 115, 197));
        Tpersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpersonnelActionPerformed(evt);
            }
        });
        getContentPane().add(Tpersonnel);
        Tpersonnel.setBounds(700, 240, 230, 30);

        Tquantite.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tquantite.setForeground(new java.awt.Color(2, 115, 197));
        Tquantite.setBorder(null);
        Tquantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TquantiteActionPerformed(evt);
            }
        });
        getContentPane().add(Tquantite);
        Tquantite.setBounds(250, 240, 230, 30);

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
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTableMouseReleased(evt);
            }
        });
        Table.setViewportView(JTable);

        getContentPane().add(Table);
        Table.setBounds(90, 402, 880, 150);

        LdispoStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LdispoStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LdispoStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LdispoStockMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LdispoStockMousePressed(evt);
            }
        });
        getContentPane().add(LdispoStock);
        LdispoStock.setBounds(370, 35, 150, 50);

        Lutilisation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Lutilisation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LutilisationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LutilisationMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LutilisationMousePressed(evt);
            }
        });
        getContentPane().add(Lutilisation);
        Lutilisation.setBounds(520, 35, 150, 50);

        Linutilisable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Linutilisable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LinutilisableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LinutilisableMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LinutilisableMousePressed(evt);
            }
        });
        getContentPane().add(Linutilisable);
        Linutilisable.setBounds(670, 35, 150, 50);

        Bmodifier.setBackground(new java.awt.Color(12, 46, 76));
        Bmodifier.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bmodifier.setForeground(new java.awt.Color(255, 255, 255));
        Bmodifier.setText("Modifier");
        Bmodifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BmodifierMousePressed(evt);
            }
        });
        getContentPane().add(Bmodifier);
        Bmodifier.setBounds(590, 320, 100, 30);

        Bsupprimer.setBackground(new java.awt.Color(12, 46, 76));
        Bsupprimer.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bsupprimer.setForeground(new java.awt.Color(255, 255, 255));
        Bsupprimer.setText("Supprimer");
        Bsupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BsupprimerMousePressed(evt);
            }
        });
        Bsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsupprimerActionPerformed(evt);
            }
        });
        getContentPane().add(Bsupprimer);
        Bsupprimer.setBounds(710, 320, 100, 30);

        Bactualiser.setBackground(new java.awt.Color(12, 46, 76));
        Bactualiser.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bactualiser.setForeground(new java.awt.Color(255, 255, 255));
        Bactualiser.setText("Actualiser");
        Bactualiser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BactualiserMousePressed(evt);
            }
        });
        Bactualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BactualiserActionPerformed(evt);
            }
        });
        getContentPane().add(Bactualiser);
        Bactualiser.setBounds(830, 320, 100, 30);

        deconecter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deconecterMousePressed(evt);
            }
        });
        getContentPane().add(deconecter);
        deconecter.setBounds(770, 10, 70, 20);

        Tdate.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tdate.setForeground(new java.awt.Color(2, 115, 197));
        Tdate.setBorder(null);
        Tdate.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Tdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdateActionPerformed(evt);
            }
        });
        getContentPane().add(Tdate);
        Tdate.setBounds(250, 180, 230, 30);

        Fond_Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Admin_StockV1.jpg"))); // NOI18N
        Fond_Stock.setText("jLabel1");
        Fond_Stock.setMaximumSize(new java.awt.Dimension(1000, 600));
        getContentPane().add(Fond_Stock);
        Fond_Stock.setBounds(0, 0, 1000, 600);

        Lemplacement1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lemplacement1.setText("Etat");
        getContentPane().add(Lemplacement1);
        Lemplacement1.setBounds(90, 300, 100, 30);

        Tetat.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Tetat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TetatActionPerformed(evt);
            }
        });
        getContentPane().add(Tetat);
        Tetat.setBounds(250, 300, 160, 30);

        Tident.setText("jTextField1");
        getContentPane().add(Tident);
        Tident.setBounds(490, 280, 59, 20);

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

    private void TnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnomActionPerformed

    private void TemplacementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemplacementActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TemplacementActionPerformed

    private void TtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtypeActionPerformed

    private void TpersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpersonnelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TpersonnelActionPerformed

    private void JTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseReleased
         Tnom.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),1)));
         Tdate.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),2)));
       //  Tquantite.set(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),3)));
         Tetat.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),4)));
         Templacement.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),5)));
         Ttype.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),6)));
         Tpersonnel.setSelectedItem(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),7)));
         Tident.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),0)));
    }//GEN-LAST:event_JTableMouseReleased

    private void TetatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TetatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TetatActionPerformed
 
    private void LdispoStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LdispoStockMousePressed
LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-nouveau.jpg")));
      LFpassePressed.setBounds(370,35,151,50);
      LFpassePressed.setVisible(true);        // TODO add your handling code here:
        Afficher();
      //  choixpers();
     
     Lnom.setVisible(true);                 Tnom.setVisible(true);             Bactualiser.setVisible(true);     Bsupprimer.setVisible(true);     
     Lquantite.setVisible(true);            Tdate.setVisible(true);            JTable.setVisible(true);          Lpersonnel.setVisible(true);
     Ltype.setVisible(true);                Templacement.setVisible(true);     Ltexte12.setVisible(true);        Tpersonnel.setVisible(true);
     Ldate.setVisible(true);                Tquantite.setVisible(true);        Bmodifier.setVisible(true);        stockligne13.setVisible(true);
     Lemplacement.setVisible(true);         Ttype.setVisible(true);            Table.setVisible(true);             stockligne14.setVisible(true);
     stockligne15.setVisible(true);   
    s2.Bactualiser2.setVisible(false);       s2.Lcommentaire2.setVisible(false);      s2.Tcommentaire2.setVisible(false);
    s2.Bmodifier2.setVisible(false);         s2.Ldate2.setVisible(false);             s2.Tcommentaire22.setVisible(false);
    s2.Bsupprimer2.setVisible(false);        s2.Lnom2.setVisible(false);              s2.Tdate2.setVisible(false);
    s2.Ltexte12.setVisible(false);           s2.Lpersonnel2.setVisible(false);        s2.Tnom2.setVisible(false);
    s2.JTable2.setVisible(false);            s2.Lquantite2.setVisible(false);         s2.Tpersonnel2.setVisible(false);
    s2.Table2.setVisible(false);                                                     s2.Tquantite2.setVisible(false);
    s2.stockligne23.setVisible(false);
     s3.Bactualiser3.setVisible(false);          s3.Ldate3.setVisible(false);             s3.Tdate3.setVisible(false);
     s3.Bmodifier3.setVisible(false);            s3.Lnom3.setVisible(false);              s3.Tnom3.setVisible(false);
     s3.Bsupprimer3.setVisible(false);           s3.Lpersonnel3.setVisible(false);        s3.Tpersonnel3.setVisible(false);
     s3.JTable3.setVisible(false);               s3.Lquantite3.setVisible(false);         s3.Tquantite3.setVisible(false);
     s3.Table3.setVisible(false);                s3.Ltexte22.setVisible(false);           s3.stockligne33.setVisible(false);
     
             s4.Lnom4.setVisible(false);                      s4.Tnom4.setVisible(false);              s4.Bactualiser4.setVisible(false);
        s4.LAnnee4.setVisible(false);                    s4.TAnnee4.setVisible(false);            s4.Bmodifier4.setVisible(false);
        s4.Ltype.setVisible(false);                      s4.Tquantite4.setVisible(false);         s4.Bsupprimer4.setVisible(false);
        s4.Lquantite4.setVisible(false);                 s4.Ttype4.setVisible(false);             s4.BsupprimerTous4.setVisible(false);
        s4.Lquantite4.setVisible(false);                 s4.Table4.setVisible(false);             s4.CcomboAnnee4.setVisible(false);
        s4.LtexteTousAnne4.setVisible(false);            s4.JTable4.setVisible(false);
s4.LtexteAffichertous4.setVisible(false);       s4.stockligne44.setVisible(false);     s4.stockligne43.setVisible(false);

    }//GEN-LAST:event_LdispoStockMousePressed

    private void LutilisationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LutilisationMousePressed
 LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-utiliser.jpg")));
      LFpassePressed.setBounds(520,35,151,50);
      LFpassePressed.setVisible(true);        // TODO add your handling code here:
        Afficher2();
     //   choixpers();
        
    s2.Bactualiser2.setVisible(true);       s2.Lcommentaire2.setVisible(true);      s2.Tcommentaire2.setVisible(true);
    s2.Bmodifier2.setVisible(true);         s2.Ldate2.setVisible(true);             s2.Tcommentaire22.setVisible(true);
    s2.Bsupprimer2.setVisible(true);        s2.Lnom2.setVisible(true);              s2.Tdate2.setVisible(true);
    s2.Ltexte12.setVisible(true);           s2.Lpersonnel2.setVisible(true);        s2.Tnom2.setVisible(true);
    s2.JTable2.setVisible(true);            s2.Lquantite2.setVisible(true);         s2.Tpersonnel2.setVisible(true);
    s2.Table2.setVisible(true);                                                     s2.Tquantite2.setVisible(true);
    s2.stockligne23.setVisible(true); 
   
     Lnom.setVisible(false);                 Tnom.setVisible(false);             Bactualiser.setVisible(false);   Lpersonnel.setVisible(false);                  
     Lquantite.setVisible(false);            Tdate.setVisible(false);            Bsupprimer.setVisible(false);    Tpersonnel.setVisible(false);       
     Ltype.setVisible(false);                Templacement.setVisible(false);     Ltexte12.setVisible(false);
     Ldate.setVisible(false);                Tquantite.setVisible(false);        Bmodifier.setVisible(false);
     Lemplacement.setVisible(false);         Ttype.setVisible(false);            JTable.setVisible(false);        Table.setVisible(false);
    stockligne13.setVisible(false);    
    stockligne14.setVisible(false); 
    stockligne15.setVisible(false);
     s3.Bactualiser3.setVisible(false);          s3.Ldate3.setVisible(false);             s3.Tdate3.setVisible(false);
     s3.Bmodifier3.setVisible(false);            s3.Lnom3.setVisible(false);              s3.Tnom3.setVisible(false);
     s3.Bsupprimer3.setVisible(false);           s3.Lpersonnel3.setVisible(false);        s3.Tpersonnel3.setVisible(false);
     s3.JTable3.setVisible(false);               s3.Lquantite3.setVisible(false);         s3.Tquantite3.setVisible(false);
     s3.Table3.setVisible(false);                s3.Ltexte22.setVisible(false);
     s3.stockligne33.setVisible(false);
     
     s2.Table2.setViewportView(s2.JTable2);
     Fond_Stock.add(s2.Table2);
    
       s4.Lnom4.setVisible(false);                      s4.Tnom4.setVisible(false);              s4.Bactualiser4.setVisible(false);
        s4.LAnnee4.setVisible(false);                    s4.TAnnee4.setVisible(false);            s4.Bmodifier4.setVisible(false);
        s4.Ltype.setVisible(false);                      s4.Tquantite4.setVisible(false);         s4.Bsupprimer4.setVisible(false);
        s4.Lquantite4.setVisible(false);                 s4.Ttype4.setVisible(false);             s4.BsupprimerTous4.setVisible(false);
        s4.Lquantite4.setVisible(false);                 s4.Table4.setVisible(false);             s4.CcomboAnnee4.setVisible(false);
        s4.LtexteTousAnne4.setVisible(false);            s4.JTable4.setVisible(false);
        s4.LtexteAffichertous4.setVisible(false);        s4.stockligne44.setVisible(false);
        s4.stockligne43.setVisible(false);
        
     Fond_Stock.add(s2.Bactualiser2);
     Fond_Stock.add(s2.Bmodifier2);
     Fond_Stock.add(s2.Bsupprimer2);
     Fond_Stock.add(s2.Ltexte12);
     Fond_Stock.add(s2.Lnom2);
     Fond_Stock.add(s2.Ldate2);
     Fond_Stock.add(s2.Lquantite2);
     Fond_Stock.add(s2.Lcommentaire2);
     Fond_Stock.add(s2.Lpersonnel2);
     Fond_Stock.add(s2.Tnom2);
     Fond_Stock.add(s2.Tdate2);
     Fond_Stock.add(s2.Tquantite2);
     Fond_Stock.add(s2.Tcommentaire22);
     Fond_Stock.add(s2.Tpersonnel2);
     Fond_Stock.add(s2.stockligne23);
     
     s2.JTable2.addMouseListener(this);
     s2.Bmodifier2.addActionListener(this);
     s2.Bactualiser2.addActionListener(this);
     s2.Bsupprimer2.addActionListener(this);
    }//GEN-LAST:event_LutilisationMousePressed

    private void BsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsupprimerActionPerformed
Supprimer();        //   enregistrer();
        //  Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_BsupprimerActionPerformed
 
    private void BactualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BactualiserActionPerformed
    ActualiserAdmin1();        // TODO add your handling code here:
    }//GEN-LAST:event_BactualiserActionPerformed

    private void BmodifierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BmodifierMousePressed
        // TODO add your handling code here:
        Modifier();
       
    }//GEN-LAST:event_BmodifierMousePressed

    private void BsupprimerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsupprimerMousePressed
   //   d.SupprimerMateriel(Tident.getText());
              // TODO add your handling code here:
      
    }//GEN-LAST:event_BsupprimerMousePressed

    private void BactualiserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BactualiserMousePressed
        ActualiserAdmin1();
    }//GEN-LAST:event_BactualiserMousePressed

    private void LinutilisableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LinutilisableMousePressed
      LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-retirer.jpg")));
      LFpassePressed.setBounds(671,35,151,50);
      LFpassePressed.setVisible(true);  
        // TODO add your handling code here
     s3.Bactualiser3.setVisible(true);          s3.Ldate3.setVisible(true);             s3.Tdate3.setVisible(true);
     s3.Bmodifier3.setVisible(true);            s3.Lnom3.setVisible(true);              s3.Tnom3.setVisible(true);
     s3.Bsupprimer3.setVisible(true);           s3.Lpersonnel3.setVisible(true);        s3.Tpersonnel3.setVisible(true);
     s3.JTable3.setVisible(true);               s3.Lquantite3.setVisible(true);         s3.Tquantite3.setVisible(true);
     s3.Table3.setVisible(true);                s3.Ltexte22.setVisible(true);           s3.stockligne33.setVisible(true);
  
     s2.Bactualiser2.setVisible(false);       s2.Lcommentaire2.setVisible(false);      s2.Tcommentaire2.setVisible(false);
    s2.Bmodifier2.setVisible(false);         s2.Ldate2.setVisible(false);             s2.Tcommentaire22.setVisible(false);
    s2.Bsupprimer2.setVisible(false);        s2.Lnom2.setVisible(false);              s2.Tdate2.setVisible(false);
    s2.Ltexte12.setVisible(false);           s2.Lpersonnel2.setVisible(false);        s2.Tnom2.setVisible(false);
    s2.JTable2.setVisible(false);            s2.Lquantite2.setVisible(false);         s2.Tpersonnel2.setVisible(false);
    s2.Table2.setVisible(false);                                                     s2.Tquantite2.setVisible(false);
    s2.stockligne23.setVisible(false);
    
      Lnom.setVisible(false);                 Tnom.setVisible(false);             Bactualiser.setVisible(false);   Lpersonnel.setVisible(false);                  
     Lquantite.setVisible(false);            Tdate.setVisible(false);            Bsupprimer.setVisible(false);    Tpersonnel.setVisible(false);       
     Ltype.setVisible(false);                Templacement.setVisible(false);     Ltexte12.setVisible(false);
     Ldate.setVisible(false);                Tquantite.setVisible(false);        Bmodifier.setVisible(false);
     Lemplacement.setVisible(false);         Ttype.setVisible(false);            JTable.setVisible(false);        Table.setVisible(false);
    stockligne13.setVisible(false);    
    stockligne14.setVisible(false); 
     stockligne15.setVisible(false);
     s3.Table3.setViewportView(s3.JTable3);
     Fond_Stock.add(s3.Table3);
     
      s4.Lnom4.setVisible(false);                      s4.Tnom4.setVisible(false);              s4.Bactualiser4.setVisible(false);
        s4.LAnnee4.setVisible(false);                    s4.TAnnee4.setVisible(false);            s4.Bmodifier4.setVisible(false);
        s4.Ltype.setVisible(false);                      s4.Tquantite4.setVisible(false);         s4.Bsupprimer4.setVisible(false);
        s4.Lquantite4.setVisible(false);                 s4.Ttype4.setVisible(false);             s4.BsupprimerTous4.setVisible(false);
        s4.Lquantite4.setVisible(false);                 s4.Table4.setVisible(false);             s4.CcomboAnnee4.setVisible(false);
        s4.LtexteTousAnne4.setVisible(false);            s4.JTable4.setVisible(false);
        s4.LtexteAffichertous4.setVisible(false);        s4.stockligne44.setVisible(false);
        s4.stockligne43.setVisible(false);
     AfficherCorbeille();
//     choixpers();
     
     Fond_Stock.add(s3.Bactualiser3);
     Fond_Stock.add(s3.Bmodifier3);
     Fond_Stock.add(s3.Bsupprimer3);
     Fond_Stock.add(s3.Lnom3);
     Fond_Stock.add(s3.Ldate3);
     Fond_Stock.add(s3.Lquantite3);
     Fond_Stock.add(s3.Lpersonnel3);
     Fond_Stock.add(s3.Tnom3);
     Fond_Stock.add(s3.Tdate3);
     Fond_Stock.add(s3.Tquantite3);
     Fond_Stock.add(s3.Tpersonnel3);
     Fond_Stock.add(s3.Ltexte22);
     Fond_Stock.add(s3.stockligne33);
     
     s3.JTable3.addMouseListener(this);
     s3.Bmodifier3.addActionListener(this);
     s3.Bactualiser3.addActionListener(this);
     s3.Bsupprimer3.addActionListener(this);
    
     
    
    
     
    
    }//GEN-LAST:event_LinutilisableMousePressed

    private void retourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retourMousePressed
        // TODO add your handling code here:
        Accueil_Admin ac_ad = new Accueil_Admin();
        ac_ad.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_retourMousePressed

    private void BbilanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbilanMouseEntered
        LFpasse1.setVisible(true);
        LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-bilan.jpg")));
        LFpasse1.setBounds(821,35,151,50);        // TODO add your handling code here:
    }//GEN-LAST:event_BbilanMouseEntered

    private void BbilanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbilanMouseExited
        LFpasse1.setVisible(false);
    }//GEN-LAST:event_BbilanMouseExited

    private void BbilanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbilanMousePressed
        LFpassePressed.setIcon(new ImageIcon(getClass().getResource("/image/Fond-bilan.jpg")));
        LFpassePressed.setBounds(821,35,151,50);
        LFpassePressed.setVisible(true);

        s4.Lnom4.setVisible(true);                      s4.Tnom4.setVisible(true);              s4.Bactualiser4.setVisible(true);
        s4.LAnnee4.setVisible(true);                    s4.TAnnee4.setVisible(true);            s4.Bmodifier4.setVisible(true);
        s4.Ltype.setVisible(true);                      s4.Tquantite4.setVisible(true);         s4.Bsupprimer4.setVisible(true);
        s4.Lquantite4.setVisible(true);                 s4.Ttype4.setVisible(true);           //  s4.BsupprimerTous4.setVisible(true);
        s4.Lquantite4.setVisible(true);                 s4.Table4.setVisible(true);           //  s4.CcomboAnnee4.setVisible(true);
                    s4.JTable4.setVisible(true);            s4.stockligne44.setVisible(true);
       s4.LtexteAffichertous4.setVisible(true);
        s4.stockligne43.setVisible(true);
        
        Fond_Stock.add(s4.Lnom4);
        Fond_Stock.add(s4.Lnom4);
        Fond_Stock.add(s4.Lquantite4);
        Fond_Stock.add(s4.LtexteAffichertous4);
      //  Fond_Stock.add(s4.LtexteTousAnne4);
        Fond_Stock.add(s4.Ltype);
        Fond_Stock.add(s4.TAnnee4);
        Fond_Stock.add(s4.LAnnee4);
        Fond_Stock.add(s4.Tnom4);
        Fond_Stock.add(s4.Tquantite4);
        Fond_Stock.add(s4.Ttype4);
        Fond_Stock.add(s4.Bactualiser4);
        Fond_Stock.add(s4.Bsupprimer4);
        Fond_Stock.add(s4.Bmodifier4);
     //   Fond_Stock.add(s4.BsupprimerTous4);
     //   Fond_Stock.add(s4.CcomboAnnee4);
        Fond_Stock.add(s4.stockligne44);
        Fond_Stock.add(s4.stockligne43);
     s4.Table4.setViewportView(s4.JTable4);
     Fond_Stock.add(s4.Table4);
        
     s3.Bactualiser3.setVisible(false);          s3.Ldate3.setVisible(false);             s3.Tdate3.setVisible(false);
     s3.Bmodifier3.setVisible(false);            s3.Lnom3.setVisible(false);              s3.Tnom3.setVisible(false);
     s3.Bsupprimer3.setVisible(false);           s3.Lpersonnel3.setVisible(false);        s3.Tpersonnel3.setVisible(false);
     s3.JTable3.setVisible(false);               s3.Lquantite3.setVisible(false);         s3.Tquantite3.setVisible(false);
     s3.Table3.setVisible(false);                s3.Ltexte22.setVisible(false);
     s3.stockligne33.setVisible(false);
     
     s2.Bactualiser2.setVisible(false);       s2.Lcommentaire2.setVisible(false);      s2.Tcommentaire2.setVisible(false);
    s2.Bmodifier2.setVisible(false);         s2.Ldate2.setVisible(false);             s2.Tcommentaire22.setVisible(false);
    s2.Bsupprimer2.setVisible(false);        s2.Lnom2.setVisible(false);              s2.Tdate2.setVisible(false);
    s2.Ltexte12.setVisible(false);           s2.Lpersonnel2.setVisible(false);        s2.Tnom2.setVisible(false);
    s2.JTable2.setVisible(false);            s2.Lquantite2.setVisible(false);         s2.Tpersonnel2.setVisible(false);
    s2.Table2.setVisible(false);                                                     s2.Tquantite2.setVisible(false);
    s2.stockligne23.setVisible(false);
    
      Lnom.setVisible(false);                 Tnom.setVisible(false);             Bactualiser.setVisible(false);   Lpersonnel.setVisible(false);                  
     Lquantite.setVisible(false);            Tdate.setVisible(false);            Bsupprimer.setVisible(false);    Tpersonnel.setVisible(false);       
     Ltype.setVisible(false);                Templacement.setVisible(false);     Ltexte12.setVisible(false);
     Ldate.setVisible(false);                Tquantite.setVisible(false);        Bmodifier.setVisible(false);
     Lemplacement.setVisible(false);         Ttype.setVisible(false);            JTable.setVisible(false);        Table.setVisible(false);
     stockligne13.setVisible(false);    
     stockligne14.setVisible(false); 
    stockligne15.setVisible(false);
     
     s4.Bactualiser4.addActionListener(this);
     s4.Bmodifier4.addActionListener(this);
     s4.Bsupprimer4.addActionListener(this);
     s4.BsupprimerTous4.addActionListener(this);
     s4.JTable4.addMouseListener(this);
    }//GEN-LAST:event_BbilanMousePressed

    private void LdispoStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LdispoStockMouseEntered
LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-nouveau.jpg"))); 
       LFpasse1.setBounds(370,35,151,50);        // TODO add your handling code here:
    }//GEN-LAST:event_LdispoStockMouseEntered

    private void LdispoStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LdispoStockMouseExited
LFpasse1.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_LdispoStockMouseExited

    private void LutilisationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LutilisationMouseEntered
LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-utiliser.jpg"))); 
       LFpasse1.setBounds(521,35,151,50);        // TODO add your handling code here:
    }//GEN-LAST:event_LutilisationMouseEntered

    private void LutilisationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LutilisationMouseExited
        LFpasse1.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_LutilisationMouseExited

    private void LinutilisableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LinutilisableMouseEntered
 LFpasse1.setVisible(true);
       LFpasse1.setIcon(new ImageIcon(getClass().getResource("/image/Fond-retirer.jpg"))); 
       LFpasse1.setBounds(671,35,151,50);           // TODO add your handling code here:
    }//GEN-LAST:event_LinutilisableMouseEntered

    private void LinutilisableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LinutilisableMouseExited
       LFpasse1.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_LinutilisableMouseExited

    private void deconecterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconecterMousePressed
        MessConfirmation mc=new MessConfirmation();
        mc.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_deconecterMousePressed

    private void TquantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TquantiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TquantiteActionPerformed

    private void TdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TdateActionPerformed

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
            java.util.logging.Logger.getLogger(AdminStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bactualiser;
    private javax.swing.JLabel Bbilan;
    public javax.swing.JButton Bmodifier;
    public javax.swing.JButton Bsupprimer;
    public javax.swing.JLabel Fond_Stock;
    public javax.swing.JTable JTable;
    public javax.swing.JLabel LFpasse1;
    public javax.swing.JLabel LFpassePressed;
    public javax.swing.JLabel Ldate;
    private javax.swing.JLabel LdispoStock;
    public javax.swing.JLabel Lemplacement;
    public javax.swing.JLabel Lemplacement1;
    private javax.swing.JLabel Linutilisable;
    public javax.swing.JLabel Lnom;
    public javax.swing.JLabel Lpersonnel;
    public javax.swing.JLabel Lquantite;
    public javax.swing.JLabel Ltexte12;
    public javax.swing.JLabel Ltype;
    private javax.swing.JLabel Lutilisation;
    public javax.swing.JScrollPane Table;
    public javax.swing.JTextField Tdate;
    public javax.swing.JTextField Templacement;
    public javax.swing.JTextField Tetat;
    private javax.swing.JTextField Tident;
    public javax.swing.JTextField Tnom;
    public javax.swing.JComboBox Tpersonnel;
    public javax.swing.JTextField Tquantite;
    public javax.swing.JTextField Ttype;
    private javax.swing.JLabel barre;
    public javax.swing.JLabel deconecter;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    public javax.swing.JLabel ligne15;
    public javax.swing.JLabel retour;
    public javax.swing.JLabel stockligne11;
    public javax.swing.JLabel stockligne12;
    public javax.swing.JLabel stockligne13;
    public javax.swing.JLabel stockligne14;
    public javax.swing.JLabel stockligne15;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== s2.Bactualiser2){
            ActualiserAdmin2();
        }
        if (e.getSource()== s4.Bactualiser4){
            ActualiserAdmin4();
        }
        if (e.getSource()== s2.Bmodifier2){
           Modifier2();
        }
        if (e.getSource()== s2.Bsupprimer2){
           
            m2.setVisible(true);
            m2.ErreurTexte.setVisible(true);
            m2.ErreurTexte.setText(" Matériel en service supprimer ");
            d.SupprimerUtiliser(s2.Tident2.getText());
            JOptionPane.showMessageDialog(this,s2.Tident2.getText());
           // d.SupprimerUtiliser(s2.Tident2.getText());
            
          //  JOptionPane.showMessageDialog(this, "supprimer 2");
        }
        if (e.getSource()== s3.Bactualiser3){
            ActualiserAdmin3();
        }
        if (e.getSource()== s3.Bmodifier3){
            Modifier3();
        }
        if (e.getSource()== s3.Bsupprimer3){
           
            m2.setVisible(true);
            m2.ErreurTexte.setVisible(true);
            m2.ErreurTexte.setText(" Matériel dans corbeille supprimer ");
            JOptionPane.showMessageDialog(this,s3.Tident3.getText());
            d.SupprimerStock(s3.Tident3.getText());
        //    JOptionPane.showMessageDialog(this, "supprimer 3");
        }
        if (e.getSource()== s4.Bmodifier4){
            
            Modifier4Bilan();
        }
        if (e.getSource()== s4.Bsupprimer4){
        
            m2.setVisible(true);
            m2.ErreurTexte.setVisible(true);
            m2.ErreurTexte.setText(" Matériel dans bilan supprimer ");
            JOptionPane.showMessageDialog(this,s4.Tid_bilan.getText());
            d.SupprimerbilanAdmin(s4.Tid_bilan.getText());
       
       //     JOptionPane.showMessageDialog(this, "supprimer 4");
         }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == s2.JTable2){
         s2.Tnom2.setText(String.valueOf(s2.JTable2.getValueAt(s2.JTable2.getSelectedRow(),1)));
         s2.Tdate2.setText(String.valueOf(s2.JTable2.getValueAt(s2.JTable2.getSelectedRow(),2)));
         s2.Tcommentaire2.setText(String.valueOf(s2.JTable2.getValueAt(s2.JTable2.getSelectedRow(),4)));
         s2.Tpersonnel2.setSelectedItem(String.valueOf(s2.JTable2.getValueAt(s2.JTable2.getSelectedRow(),5)));
         s2.Tident2.setText(String.valueOf(s2.JTable2.getValueAt(s2.JTable2.getSelectedRow(),0)));
        
        }
        
        if (e.getSource()== s3.JTable3){
         s3.Tnom3.setText(String.valueOf(s3.JTable3.getValueAt(s3.JTable3.getSelectedRow(),1)));
         s3.Tdate3.setText(String.valueOf(s3.JTable3.getValueAt(s3.JTable3.getSelectedRow(),2)));
         s3.Tpersonnel3.setSelectedItem(String.valueOf(s3.JTable3.getValueAt(s3.JTable3.getSelectedRow(),4)));
         s3.Tident3.setText(String.valueOf(s3.JTable3.getValueAt(s3.JTable3.getSelectedRow(),0)));
        
        }
        
        if (e.getSource()== s4.JTable4){
         s4.Tnom4.setText(String.valueOf(s4.JTable4.getValueAt(s4.JTable4.getSelectedRow(),1)));
         s4.TAnnee4.setText(String.valueOf(s4.JTable4.getValueAt(s4.JTable4.getSelectedRow(),2)));
         s4.Ttype4.setText(String.valueOf(s4.JTable4.getValueAt(s4.JTable4.getSelectedRow(),4)));
         s4.Tid_bilan.setText(String.valueOf(s4.JTable4.getValueAt(s4.JTable4.getSelectedRow(),0)));
      }
    } 

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
