/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;

/**
 *
 * @author Snow
 */
public class MessConfirmation extends javax.swing.JFrame {
int xMouse,yMouse;
    /**
     * Creates new form MessErreur
     */
    public MessConfirmation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ErreurTexte = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        Boui = new javax.swing.JButton();
        Bnon = new javax.swing.JButton();
        barre = new javax.swing.JLabel();
        ferm2 = new javax.swing.JLabel();
        FMessErreur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(315, 125));
        setUndecorated(true);
        getContentPane().setLayout(null);

        ErreurTexte.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        ErreurTexte.setText("voulez vous vraiment vous deconecter?");
        getContentPane().add(ErreurTexte);
        ErreurTexte.setBounds(70, 50, 250, 20);

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
        ferm1.setBounds(288, 3, 20, 19);

        Boui.setBackground(new java.awt.Color(12, 46, 76));
        Boui.setForeground(new java.awt.Color(255, 255, 255));
        Boui.setText("OUI");
        Boui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BouiActionPerformed(evt);
            }
        });
        getContentPane().add(Boui);
        Boui.setBounds(60, 90, 70, 20);

        Bnon.setBackground(new java.awt.Color(12, 46, 76));
        Bnon.setForeground(new java.awt.Color(255, 255, 255));
        Bnon.setText("NON");
        Bnon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnonActionPerformed(evt);
            }
        });
        getContentPane().add(Bnon);
        Bnon.setBounds(200, 90, 70, 20);

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
        barre.setBounds(0, 0, 25, 120);
        getContentPane().add(ferm2);
        ferm2.setBounds(0, 0, 19, 19);

        FMessErreur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/MessErreur2.jpg"))); // NOI18N
        getContentPane().add(FMessErreur);
        FMessErreur.setBounds(0, 0, 315, 125);

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
        FMessErreur.add(ferm2);
        ferm2.setIcon(new ImageIcon(getClass().getResource("/image/fermee.png")));
        ferm2.setBounds(284,-1,26, 25);
    }//GEN-LAST:event_ferm1MouseEntered

    private void ferm1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseExited
        // TODO add your handling code here:
        ferm2.setVisible(false);
    }//GEN-LAST:event_ferm1MouseExited

    private void ferm1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MousePressed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_ferm1MousePressed

    private void BouiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BouiActionPerformed
        this.setVisible(false);
        Menu m = new Menu();
        m.setVisible(true);
        AdminStock add1=new AdminStock();
        AdminStock2 add2= new AdminStock2();
        AdminStock3 add3= new AdminStock3();
        AdminStock4 add4 = new AdminStock4();
        Accueil_Admin accadd=new Accueil_Admin();
        AdminPers addpers=new AdminPers();
        
        add1.setVisible(false);
        add2.setVisible(false);
        add3.setVisible(false);
        add4.setVisible(false);
        accadd.setVisible(false);
        addpers.setVisible(false);
        //  Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_BouiActionPerformed

    private void BnonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnonActionPerformed
      this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_BnonActionPerformed

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
            java.util.logging.Logger.getLogger(MessConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessConfirmation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bnon;
    public javax.swing.JButton Boui;
    public javax.swing.JLabel ErreurTexte;
    private javax.swing.JLabel FMessErreur;
    private javax.swing.JLabel barre;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    // End of variables declaration//GEN-END:variables
}