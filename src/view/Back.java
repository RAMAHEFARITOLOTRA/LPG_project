/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Database;
import controler.IDatabase;
import com.caucho.hessian.client.HessianProxyFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafaly Antoni
 */
public class Back extends javax.swing.JFrame {
       // IDataBase crud = new DataBase();
        int xMouse,yMouse;
        int n = 0;
        Date date=new Date(); 
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public String mois1[]={"Mois 1","Mois 2","Mois 3"};
        public String mois2[]={"Mois 1","Mois 2","Mois 3","Mois 4","Mois 5","Mois 6"};
        Tableau tout = new Tableau();
        Plannig p = new Plannig();
         private IDatabase crud = null;

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
     
    /**
     * Creates new form Back
     */
    public Back() {
        initComponents();
        crud = getConnection(hoteDist);
        Cjour.setVisible(false);
        Tjour.setVisible(false);
        sem.setVisible(false);
        Csem.setVisible(false);
        mois.setVisible(false);
        Cmois.setVisible(false);
        journalier.setSelectedItem("Trimestriel");
        //p.setBounds(90, 390, 770, 160);
        //fond.add(p);
        //int size = crud.afficheContact("journalier").size() + crud.afficheToutMen("hebdomadaire").size() + crud.afficheToutMen("mensuel").size() + crud.afficheToutTri("Trimestre").size() + crud.afficheToutTri("Semestre").size();
       // tout.Ttable.setModel(new DefaultTableModel(new String[]{"Equipement","Type","Jour","Semaine 1","Mois"},size));
        tout.PTtable.setBounds(90, 390, 770, 160);
        //tout.Ttable.setBounds(90, 390, 770, 160);
        //fond.add(tout.Ttable);
        fond.add(tout.PTtable);
        tout.PTtable.setVisible(true);
        //tout.Ttable.setVisible(true);
        p.afficheAnnuel(tout.Ttable);
        
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
        ligne11 = new javax.swing.JLabel();
        ligne12 = new javax.swing.JLabel();
        retour1 = new javax.swing.JLabel();
        barre = new javax.swing.JLabel();
        Tjour = new javax.swing.JLabel();
        Cmois = new javax.swing.JComboBox();
        mois = new javax.swing.JLabel();
        Cjour = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Csem = new javax.swing.JComboBox();
        Bajout = new javax.swing.JButton();
        journalier = new javax.swing.JComboBox();
        list = new java.awt.List();
        jLabel2 = new javax.swing.JLabel();
        sem = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        equip = new javax.swing.JTextField();
        Bsave = new javax.swing.JButton();
        Ltexte12 = new javax.swing.JLabel();
        deconecter = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        ferm2 = new javax.swing.JLabel();
        fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));
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

        ligne11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne11.setText("jLabel2");
        getContentPane().add(ligne11);
        ligne11.setBounds(230, 150, 230, 2);

        ligne12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        ligne12.setText("jLabel2");
        getContentPane().add(ligne12);
        ligne12.setBounds(230, 220, 230, 2);

        retour1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retour1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                retour1MousePressed(evt);
            }
        });
        getContentPane().add(retour1);
        retour1.setBounds(10, 10, 30, 20);

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

        Tjour.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        Tjour.setForeground(new java.awt.Color(67, 68, 70));
        Tjour.setText("Jour");
        getContentPane().add(Tjour);
        Tjour.setBounds(540, 190, 70, 30);

        Cmois.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 13)); // NOI18N
        Cmois.setForeground(new java.awt.Color(2, 115, 197));
        getContentPane().add(Cmois);
        Cmois.setBounds(700, 260, 230, 30);

        mois.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        mois.setForeground(new java.awt.Color(67, 68, 70));
        mois.setText("Mois");
        getContentPane().add(mois);
        mois.setBounds(540, 260, 70, 30);

        Cjour.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 13)); // NOI18N
        Cjour.setForeground(new java.awt.Color(2, 115, 197));
        Cjour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi" }));
        Cjour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CjourActionPerformed(evt);
            }
        });
        getContentPane().add(Cjour);
        Cjour.setBounds(700, 190, 230, 30);

        jLabel4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(67, 68, 70));
        jLabel4.setText("Types");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 190, 70, 30);

        jButton1.setBackground(new java.awt.Color(12, 46, 73));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 360, 80, 30);

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(67, 68, 70));
        jLabel3.setText("Périodicité");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 130, 90, 30);

        Csem.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 13)); // NOI18N
        Csem.setForeground(new java.awt.Color(2, 115, 197));
        Csem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semaine 1", "Semaine 2", "Semaine 3", "Semaine 4", "Semaine 5" }));
        getContentPane().add(Csem);
        Csem.setBounds(700, 190, 230, 30);

        Bajout.setBackground(new java.awt.Color(12, 46, 73));
        Bajout.setForeground(new java.awt.Color(255, 255, 255));
        Bajout.setText("Ajouter");
        Bajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajoutActionPerformed(evt);
            }
        });
        getContentPane().add(Bajout);
        Bajout.setBounds(379, 240, 80, 30);

        journalier.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 13)); // NOI18N
        journalier.setForeground(new java.awt.Color(2, 115, 197));
        journalier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Journalier", "Hebdomadaire", "Mensuel", "Trimestriel", "Semestriel" }));
        journalier.setToolTipText("");
        journalier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journalierActionPerformed(evt);
            }
        });
        getContentPane().add(journalier);
        journalier.setBounds(700, 130, 230, 30);
        getContentPane().add(list);
        list.setBounds(220, 300, 240, 50);

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(67, 68, 70));
        jLabel2.setText("Equipement");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 120, 80, 30);

        sem.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        sem.setForeground(new java.awt.Color(67, 68, 70));
        sem.setText("Semaines");
        getContentPane().add(sem);
        sem.setBounds(540, 190, 70, 30);

        type.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        type.setForeground(new java.awt.Color(2, 115, 197));
        type.setBorder(null);
        getContentPane().add(type);
        type.setBounds(230, 190, 230, 30);

        equip.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        equip.setForeground(new java.awt.Color(2, 115, 197));
        equip.setBorder(null);
        getContentPane().add(equip);
        equip.setBounds(230, 120, 230, 30);

        Bsave.setBackground(new java.awt.Color(12, 46, 73));
        Bsave.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bsave.setForeground(new java.awt.Color(255, 255, 255));
        Bsave.setText("Enregistrer");
        Bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsaveActionPerformed(evt);
            }
        });
        getContentPane().add(Bsave);
        Bsave.setBounds(830, 360, 100, 30);

        Ltexte12.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        Ltexte12.setForeground(new java.awt.Color(2, 115, 197));
        Ltexte12.setText("Tâche à faire");
        getContentPane().add(Ltexte12);
        Ltexte12.setBounds(220, 270, 280, 30);

        deconecter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deconecterMousePressed(evt);
            }
        });
        getContentPane().add(deconecter);
        deconecter.setBounds(770, 20, 70, 20);

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

        fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sary/Admin_Calendrier_Back.jpg"))); // NOI18N
        getContentPane().add(fond);
        fond.setBounds(0, 0, 1020, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void journalierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journalierActionPerformed
        // TODO add your handling code here:
        if(journalier.getSelectedItem().equals("Journalier")){
            Cjour.setVisible(false);
            Tjour.setVisible(false);
            sem.setVisible(false);
            Csem.setVisible(false);
            mois.setVisible(false);
            Cmois.setVisible(false);
        }
        if(journalier.getSelectedItem().equals("Hebdomadaire")){
            Tjour.setVisible(true);
            Cjour.setVisible(true);
            sem.setVisible(false);
            Csem.setVisible(false);
            mois.setVisible(false);
            Cmois.setVisible(false);
            
        }
        if(journalier.getSelectedItem().equals("Mensuel")){
            Tjour.setVisible(false);
            Cjour.setVisible(false);
            sem.setVisible(true);
            Csem.setVisible(true);
            mois.setVisible(false);
            Cmois.setVisible(false);
        }
        if(journalier.getSelectedItem().equals("Trimestriel")){
            Cmois.removeAll();
            Cmois.setModel(new javax.swing.DefaultComboBoxModel(mois1));
            Tjour.setVisible(false);
            Cjour.setVisible(false);
            sem.setVisible(true);
            Csem.setVisible(true);
            mois.setVisible(true);
            Cmois.setVisible(true);
        }
        if(journalier.getSelectedItem().equals("Semestriel")){
            Cmois.removeAll();
            Cmois.setModel(new javax.swing.DefaultComboBoxModel(mois2));
            Tjour.setVisible(false);
            Cjour.setVisible(false);
            sem.setVisible(true);
            Csem.setVisible(true);
            mois.setVisible(true);
            Cmois.setVisible(true);
        }
    }//GEN-LAST:event_journalierActionPerformed

    private void BajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajoutActionPerformed
        // TODO add your handling code here:
        list.select(0);
        if(type.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Vide");
        else
            list.add(type.getText());
            n++;
    }//GEN-LAST:event_BajoutActionPerformed

    private void BsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsaveActionPerformed
        // TODO add your handling code here:
        list.select(0);
        if(list.getSelectedItem()== null)
        {
            JOptionPane.showMessageDialog(this, "list du TAF vide");
        }
        else
            {
               if(journalier.getSelectedItem().equals("Journalier"))
               {
                     crud.AddTravailJour(equip.getText());
            
                     for(int i=0; i<n;i++)
                     {
                         list.select(i);
                         JOptionPane.showMessageDialog(null, list.getSelectedItem());
                        //crud.AddMax("journalier", "idJour");
                         crud.AddTaf(list.getSelectedItem(), crud.AddMax("journalier", "idJour"), 0, 0, 0);
                     }
                     list.select(0);
                }
               if(journalier.getSelectedItem().equals("Hebdomadaire"))
               {
                     crud.AddTravailHeb(equip.getText(),Cjour.getSelectedItem().toString());
            
                     for(int i=0; i<n;i++)
                     {
                         list.select(i);
                         JOptionPane.showMessageDialog(null, list.getSelectedItem());
                        //crud.AddMax("journalier", "idJour");
                         crud.AddTaf(list.getSelectedItem(), 0, crud.AddMax("hebdomadaire", "IdHebdo"), 0, 0);
                     }
                     list.select(0);
                }
               if(journalier.getSelectedItem().equals("Mensuel"))
               {
                     crud.AddTravailMen(equip.getText(),Csem.getSelectedItem().toString());
            
                     for(int i=0; i<n;i++)
                     {
                         list.select(i);
                         JOptionPane.showMessageDialog(null, list.getSelectedItem());
                        //crud.AddMax("journalier", "idJour");
                         crud.AddTaf(list.getSelectedItem(), 0, 0, crud.AddMax("mensuel", "IdMen"), 0);
                     }
                     list.select(0);
                }
               if(journalier.getSelectedItem().equals("Trimestriel")||journalier.getSelectedItem().equals("Semestriel"))
               {
                     if((Cmois.getSelectedItem().equals("Mois 2")||Cmois.getSelectedItem().equals("Mois 3")||Cmois.getSelectedItem().equals("Mois 5")||Cmois.getSelectedItem().equals("Mois 6")) && (Csem.getSelectedItem().equals("Semaine 5"))){
                         JOptionPane.showMessageDialog(null, "Impossible D ajouter Semaine 5");
                     }
                     else{
                     crud.AddTravailTri(equip.getText(),Csem.getSelectedItem().toString(), Cmois.getSelectedItem().toString(),journalier.getSelectedItem().toString());
            
                     for(int i=0; i<n;i++)
                     {
                         list.select(i);
                         JOptionPane.showMessageDialog(null, list.getSelectedItem());
                        //crud.AddMax("journalier", "idJour");
                         crud.AddTaf(list.getSelectedItem(), 0, 0, 0, crud.AddMax("trisem", "IdTri"));
                     }
               }
                     list.select(0);
                }
            }
    }//GEN-LAST:event_BsaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        n--;
        list.remove(list.getSelectedIndex());
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void retour1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retour1MousePressed
        // TODO add your handling code here:
        Accueil_Admin acad = new Accueil_Admin();
        acad.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retour1MousePressed

    private void deconecterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconecterMousePressed
        MessConfirmation mc=new MessConfirmation();
        mc.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_deconecterMousePressed

    private void CjourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CjourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CjourActionPerformed

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
        BackMod m = new BackMod();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retourMousePressed

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
            java.util.logging.Logger.getLogger(Back.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Back.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Back.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Back.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Back().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Badmin;
    private javax.swing.JButton Bajout;
    private javax.swing.JButton Bsave;
    private javax.swing.JComboBox Cjour;
    private javax.swing.JComboBox Cmois;
    private javax.swing.JComboBox Csem;
    public javax.swing.JLabel Ltexte12;
    private javax.swing.JLabel NextAdmin;
    private javax.swing.JLabel Tjour;
    private javax.swing.JLabel barre;
    public javax.swing.JLabel deconecter;
    private javax.swing.JTextField equip;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    private javax.swing.JLabel fond;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox journalier;
    public javax.swing.JLabel ligne11;
    public javax.swing.JLabel ligne12;
    private java.awt.List list;
    private javax.swing.JLabel mois;
    public javax.swing.JLabel retour;
    public javax.swing.JLabel retour1;
    private javax.swing.JLabel sem;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}