/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
 
/**
 *
 * @author Snow
 */
public class Btab2 extends javax.swing.JFrame {
    

    /**
     * Creates new form Btab2
     */
    public Btab2() {
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

        ferm2 = new javax.swing.JLabel();
        ferm1 = new javax.swing.JLabel();
        barre = new javax.swing.JLabel();
        texte3 = new javax.swing.JLabel();
        Tscroll2 = new javax.swing.JScrollPane();
        Ttable2 = new javax.swing.JTable();
        Crecherche2 = new javax.swing.JComboBox();
        Trecherche2 = new javax.swing.JTextField();
        Brecherche2 = new javax.swing.JButton();
        Fond_Stock = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        labell = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);
        getContentPane().add(ferm2);
        ferm2.setBounds(961, 7, 19, 19);

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

        texte3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        texte3.setForeground(new java.awt.Color(67, 68, 70));
        texte3.setText("Listes des materiels disponibles");
        texte3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(texte3);
        texte3.setBounds(380, 120, 280, 30);

        Ttable2.setFont(new java.awt.Font("Microsoft Tai Le", 0, 12)); // NOI18N
        Ttable2.setForeground(new java.awt.Color(67, 68, 70));
        Ttable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nom", "Date", "Nombre", "Commentaire", "Personnel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tscroll2.setViewportView(Ttable2);

        getContentPane().add(Tscroll2);
        Tscroll2.setBounds(70, 160, 910, 290);

        Crecherche2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id_utiliser", "Nom", "Date", "Nombre", "Commentaire", "Id_pers" }));
        getContentPane().add(Crecherche2);
        Crecherche2.setBounds(650, 480, 90, 30);

        Trecherche2.setBorder(null);
        getContentPane().add(Trecherche2);
        Trecherche2.setBounds(400, 520, 230, 30);

        Brecherche2.setBackground(new java.awt.Color(12, 46, 76));
        Brecherche2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Brecherche2.setForeground(new java.awt.Color(255, 255, 255));
        Brecherche2.setText("Rechercher");
        Brecherche2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Brecherche2ActionPerformed(evt);
            }
        });
        getContentPane().add(Brecherche2);
        Brecherche2.setBounds(650, 520, 100, 30);

        Fond_Stock.setBackground(new java.awt.Color(12, 46, 76));
        Fond_Stock.setFont(new java.awt.Font("Microsoft Tai Le", 0, 16)); // NOI18N
        Fond_Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fond-Stock.jpg"))); // NOI18N
        Fond_Stock.setText("Nom");
        getContentPane().add(Fond_Stock);
        Fond_Stock.setBounds(0, 0, 1000, 600);

        jLabel.setBackground(new java.awt.Color(0, 153, 153));
        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Like-netbeansV2.jpg"))); // NOI18N
        jLabel.setText("jLabel1");
        getContentPane().add(jLabel);
        jLabel.setBounds(70, 160, 910, 300);

        labell.setText("texte");
        getContentPane().add(labell);
        labell.setBounds(310, 500, 210, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ferm1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ferm1MouseEntered

    private void ferm1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MouseExited
        // TODO add your handling code here:
        ferm2.setVisible(false);
    }//GEN-LAST:event_ferm1MouseExited

    private void ferm1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ferm1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ferm1MousePressed

    private void barreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barreMouseDragged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_barreMouseDragged

    private void barreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barreMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_barreMousePressed

    private void Brecherche2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Brecherche2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Brecherche2ActionPerformed

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
            java.util.logging.Logger.getLogger(Btab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Btab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Btab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Btab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Btab2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Brecherche2;
    public javax.swing.JComboBox Crecherche2;
    private javax.swing.JLabel Fond_Stock;
    public javax.swing.JTextField Trecherche2;
    public javax.swing.JScrollPane Tscroll2;
    public javax.swing.JTable Ttable2;
    private javax.swing.JLabel barre;
    private javax.swing.JLabel ferm1;
    private javax.swing.JLabel ferm2;
    public javax.swing.JLabel jLabel;
    public javax.swing.JLabel labell;
    public javax.swing.JLabel texte3;
    // End of variables declaration//GEN-END:variables
}
