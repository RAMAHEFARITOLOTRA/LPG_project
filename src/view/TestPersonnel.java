/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;

import classe.Materiel;
import com.caucho.hessian.client.HessianProxyFactory;
import controler.Database;
import controler.IDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Snow
 */
public class TestPersonnel extends javax.swing.JFrame {
    int xMouse, yMouse;
Connection connex;
Statement etat; 
StringBuffer sql;
ResultSet res;
     
Menu menu=new Menu();
//Database d=new Database();
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
        }/*
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
*/    /**
     * Creates new form TestAdmin
     */
    public TestPersonnel() {
        initComponents();
        d = getConnection(hoteDist);
         }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ferm2 = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        ligne15 = new javax.swing.JLabel();
        ligne12 = new javax.swing.JLabel();
        Ltestnom = new javax.swing.JLabel();
        Ltestpasse = new javax.swing.JLabel();
        Ttestnomadmin = new javax.swing.JTextField();
        barre = new javax.swing.JLabel();
        Ttestpasse = new javax.swing.JPasswordField();
        Btestconfirmer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Bok = new javax.swing.JButton();
        ErreurTexte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 300));
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(ferm2);
        ferm2.setBounds(440, 10, 19, 19);

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
        ferm1.setBounds(467, 6, 19, 19);

        ligne15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne15.setText("jLabel2");
        getContentPane().add(ligne15);
        ligne15.setBounds(230, 160, 230, 2);

        ligne12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne12.setText("jLabel2");
        getContentPane().add(ligne12);
        ligne12.setBounds(230, 210, 230, 2);

        Ltestnom.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Ltestnom.setForeground(new java.awt.Color(67, 68, 70));
        Ltestnom.setText("Nom personnel");
        getContentPane().add(Ltestnom);
        Ltestnom.setBounds(80, 130, 140, 30);

        Ltestpasse.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Ltestpasse.setForeground(new java.awt.Color(67, 68, 70));
        Ltestpasse.setText("mot de passe ");
        getContentPane().add(Ltestpasse);
        Ltestpasse.setBounds(80, 180, 150, 30);

        Ttestnomadmin.setBorder(null);
        Ttestnomadmin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Ttestnomadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtestnomadminActionPerformed(evt);
            }
        });
        getContentPane().add(Ttestnomadmin);
        Ttestnomadmin.setBounds(230, 130, 230, 30);

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
        barre.setBounds(0, 0, 30, 300);

        Ttestpasse.setBorder(null);
        Ttestpasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtestpasseActionPerformed(evt);
            }
        });
        getContentPane().add(Ttestpasse);
        Ttestpasse.setBounds(230, 180, 230, 30);

        Btestconfirmer.setBackground(new java.awt.Color(12, 46, 76));
        Btestconfirmer.setForeground(new java.awt.Color(255, 255, 255));
        Btestconfirmer.setText("Confirmer");
        Btestconfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtestconfirmerActionPerformed(evt);
            }
        });
        getContentPane().add(Btestconfirmer);
        Btestconfirmer.setBounds(310, 230, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Test-personnel.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 300));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 300);

        Bok.setBackground(new java.awt.Color(12, 46, 76));
        Bok.setForeground(new java.awt.Color(255, 255, 255));
        Bok.setText("OK");
        Bok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BokActionPerformed(evt);
            }
        });
        getContentPane().add(Bok);
        Bok.setBounds(200, 230, 90, 30);

        ErreurTexte.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        getContentPane().add(ErreurTexte);
        ErreurTexte.setBounds(80, 160, 390, 40);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ferm1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseEntered
        // TODO add your handling code here:
        ferm2.setVisible(true);
        jLabel1.add(ferm2);
        ferm2.setIcon(new ImageIcon(getClass().getResource("/image/ferme.jpg")));
        ferm2.setBounds(463,2,30, 30);
    }//GEN-LAST:event_ferm1MouseEntered

    private void ferm1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseExited
        // TODO add your handling code here:
        ferm2.setVisible(false);
    }//GEN-LAST:event_ferm1MouseExited

    private void ferm1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MousePressed
        // TODO add your handling code here:
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_ferm1MousePressed

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

    private void TtestnomadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtestnomadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtestnomadminActionPerformed

    private void BtestconfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtestconfirmerActionPerformed
//JOptionPane.showMessageDialog(this, " mipotra ");
        String nom=Ttestnomadmin.getText();
            String code=Ttestpasse.getText();
           try{
            if(Ttestnomadmin.getText().equals("") || Ttestpasse.getText().equals("")){
                
            }else{
            if(d.AfficherPersonneTest("personnel", nom, code)){
                this.setVisible(false);
                stock stoc=new stock();
                stoc.valnompers=d.AfficherPersonneTestNom("personnel", nom, code).get(0).getDate();
//                JOptionPane.showMessageDialog(this, stoc.valnompers);
                stoc.setVisible(true);
            }else{
                ligne12.setVisible(false);
                ligne15.setVisible(false);
                Btestconfirmer.setVisible(false);
                Ttestnomadmin.setVisible(false);
                Ttestpasse.setVisible(false);
                Ltestnom.setVisible(false);
                Ltestpasse.setVisible(false);
                ErreurTexte.setVisible(true);
                jLabel1.add(ErreurTexte);
                ErreurTexte.setText(" Erreur, verifier votre nom ou mot de passe ");
                Bok.setVisible(true);
                jLabel1.add(Bok);
                
            }                
        }
        }catch(Exception ee){
            
        }              
    }//GEN-LAST:event_BtestconfirmerActionPerformed

    private void BokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BokActionPerformed
        Ttestnomadmin.setVisible(true);
        Ttestpasse.setVisible(true);
        Btestconfirmer.setVisible(true);
        Ltestnom.setVisible(true);
        Ltestpasse.setVisible(true);
        ErreurTexte.setVisible(false);
        Bok.setVisible(false);
        ligne12.setVisible(true);
        ligne15.setVisible(true);
    }//GEN-LAST:event_BokActionPerformed

    private void TtestpasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtestpasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtestpasseActionPerformed

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
            java.util.logging.Logger.getLogger(TestPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            public void run() {
                new TestPersonnel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bok;
    public javax.swing.JButton Btestconfirmer;
    public javax.swing.JLabel ErreurTexte;
    public javax.swing.JLabel Ltestnom;
    public javax.swing.JLabel Ltestpasse;
    public javax.swing.JTextField Ttestnomadmin;
    public javax.swing.JPasswordField Ttestpasse;
    private javax.swing.JLabel barre;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel ligne12;
    public javax.swing.JLabel ligne15;
    // End of variables declaration//GEN-END:variables
}
