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
public class AdminStock4 extends javax.swing.JFrame {

    /**
     * Creates new form AdminStock4
     */
    public AdminStock4() {
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

        stockligne43 = new javax.swing.JLabel();
        stockligne44 = new javax.swing.JLabel();
        stockligne41 = new javax.swing.JLabel();
        stockligne42 = new javax.swing.JLabel();
        Lnom4 = new javax.swing.JLabel();
        LAnnee4 = new javax.swing.JLabel();
        Tnom4 = new javax.swing.JTextField();
        TAnnee4 = new javax.swing.JTextField();
        Lquantite4 = new javax.swing.JLabel();
        Ltype = new javax.swing.JLabel();
        Ttype4 = new javax.swing.JTextField();
        Tquantite4 = new javax.swing.JTextField();
        LtexteAffichertous4 = new javax.swing.JLabel();
        Table4 = new javax.swing.JScrollPane();
        JTable4 = new javax.swing.JTable();
        Bmodifier4 = new javax.swing.JButton();
        Bsupprimer4 = new javax.swing.JButton();
        Bactualiser4 = new javax.swing.JButton();
        Fond_Stock = new javax.swing.JLabel();
        LtexteTousAnne4 = new javax.swing.JLabel();
        BsupprimerTous4 = new javax.swing.JButton();
        CcomboAnnee4 = new javax.swing.JComboBox();
        Tid_bilan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        getContentPane().setLayout(null);

        stockligne43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne43.setText("jLabel2");
        getContentPane().add(stockligne43);
        stockligne43.setBounds(700, 150, 230, 2);

        stockligne44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne44.setText("jLabel2");
        getContentPane().add(stockligne44);
        stockligne44.setBounds(700, 210, 230, 2);

        stockligne41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne41.setText("jLabel2");
        getContentPane().add(stockligne41);
        stockligne41.setBounds(250, 150, 230, 2);

        stockligne42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ligne.jpg"))); // NOI18N
        stockligne42.setText("jLabel2");
        getContentPane().add(stockligne42);
        stockligne42.setBounds(250, 210, 230, 2);

        Lnom4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Lnom4.setForeground(new java.awt.Color(67, 68, 70));
        Lnom4.setText("Nom matériel");
        getContentPane().add(Lnom4);
        Lnom4.setBounds(90, 120, 100, 30);

        LAnnee4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        LAnnee4.setForeground(new java.awt.Color(67, 68, 70));
        LAnnee4.setText("Année");
        getContentPane().add(LAnnee4);
        LAnnee4.setBounds(90, 180, 140, 30);

        Tnom4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tnom4.setForeground(new java.awt.Color(2, 115, 197));
        Tnom4.setBorder(null);
        Tnom4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Tnom4.setDisabledTextColor(new java.awt.Color(2, 115, 197));
        Tnom4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Tnom4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tnom4ActionPerformed(evt);
            }
        });
        getContentPane().add(Tnom4);
        Tnom4.setBounds(250, 120, 230, 30);

        TAnnee4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        TAnnee4.setForeground(new java.awt.Color(2, 115, 197));
        TAnnee4.setBorder(null);
        TAnnee4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        TAnnee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAnnee4ActionPerformed(evt);
            }
        });
        getContentPane().add(TAnnee4);
        TAnnee4.setBounds(250, 180, 230, 30);

        Lquantite4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Lquantite4.setForeground(new java.awt.Color(67, 68, 70));
        Lquantite4.setText("Quantité");
        getContentPane().add(Lquantite4);
        Lquantite4.setBounds(550, 120, 120, 30);

        Ltype.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Ltype.setForeground(new java.awt.Color(67, 68, 70));
        Ltype.setText("Type");
        getContentPane().add(Ltype);
        Ltype.setBounds(550, 180, 120, 30);

        Ttype4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Ttype4.setForeground(new java.awt.Color(2, 115, 197));
        Ttype4.setBorder(null);
        Ttype4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Ttype4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ttype4ActionPerformed(evt);
            }
        });
        getContentPane().add(Ttype4);
        Ttype4.setBounds(700, 180, 230, 30);

        Tquantite4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 13)); // NOI18N
        Tquantite4.setForeground(new java.awt.Color(2, 115, 197));
        Tquantite4.setBorder(null);
        getContentPane().add(Tquantite4);
        Tquantite4.setBounds(700, 120, 240, 30);

        LtexteAffichertous4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        LtexteAffichertous4.setForeground(new java.awt.Color(2, 115, 197));
        LtexteAffichertous4.setText("Listes des matériels en entrée et sortie");
        getContentPane().add(LtexteAffichertous4);
        LtexteAffichertous4.setBounds(90, 360, 350, 30);

        JTable4.setFont(new java.awt.Font("Microsoft Tai Le", 0, 12)); // NOI18N
        JTable4.setForeground(new java.awt.Color(67, 68, 70));
        JTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nom", "Année", "Quantité", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTable4MouseReleased(evt);
            }
        });
        Table4.setViewportView(JTable4);

        getContentPane().add(Table4);
        Table4.setBounds(90, 402, 880, 150);

        Bmodifier4.setBackground(new java.awt.Color(12, 46, 76));
        Bmodifier4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bmodifier4.setForeground(new java.awt.Color(255, 255, 255));
        Bmodifier4.setText("Modifier");
        Bmodifier4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bmodifier4MousePressed(evt);
            }
        });
        getContentPane().add(Bmodifier4);
        Bmodifier4.setBounds(590, 320, 100, 30);

        Bsupprimer4.setBackground(new java.awt.Color(12, 46, 76));
        Bsupprimer4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bsupprimer4.setForeground(new java.awt.Color(255, 255, 255));
        Bsupprimer4.setText("Supprimer");
        Bsupprimer4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bsupprimer4MousePressed(evt);
            }
        });
        Bsupprimer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bsupprimer4ActionPerformed(evt);
            }
        });
        getContentPane().add(Bsupprimer4);
        Bsupprimer4.setBounds(710, 320, 100, 30);

        Bactualiser4.setBackground(new java.awt.Color(12, 46, 76));
        Bactualiser4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        Bactualiser4.setForeground(new java.awt.Color(255, 255, 255));
        Bactualiser4.setText("Actualiser");
        Bactualiser4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bactualiser4MousePressed(evt);
            }
        });
        Bactualiser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bactualiser4ActionPerformed(evt);
            }
        });
        getContentPane().add(Bactualiser4);
        Bactualiser4.setBounds(830, 320, 100, 30);

        Fond_Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Admin_StockV1.jpg"))); // NOI18N
        Fond_Stock.setText("jLabel1");
        Fond_Stock.setMaximumSize(new java.awt.Dimension(1000, 600));
        getContentPane().add(Fond_Stock);
        Fond_Stock.setBounds(0, 0, 1000, 600);

        LtexteTousAnne4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        LtexteTousAnne4.setForeground(new java.awt.Color(2, 115, 197));
        LtexteTousAnne4.setText("Tous les années de :");
        getContentPane().add(LtexteTousAnne4);
        LtexteTousAnne4.setBounds(190, 280, 170, 30);

        BsupprimerTous4.setBackground(new java.awt.Color(12, 46, 76));
        BsupprimerTous4.setForeground(new java.awt.Color(255, 255, 255));
        BsupprimerTous4.setText("Supprimer");
        BsupprimerTous4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BsupprimerTous4MousePressed(evt);
            }
        });
        BsupprimerTous4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsupprimerTous4ActionPerformed(evt);
            }
        });
        getContentPane().add(BsupprimerTous4);
        BsupprimerTous4.setBounds(90, 280, 90, 30);

        CcomboAnnee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcomboAnnee4ActionPerformed(evt);
            }
        });
        getContentPane().add(CcomboAnnee4);
        CcomboAnnee4.setBounds(380, 280, 70, 30);

        Tid_bilan.setText("jTextField1");
        getContentPane().add(Tid_bilan);
        Tid_bilan.setBounds(490, 290, 59, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tnom4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tnom4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tnom4ActionPerformed

    private void TAnnee4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAnnee4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TAnnee4ActionPerformed

    private void Ttype4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ttype4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ttype4ActionPerformed

    private void JTable4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable4MouseReleased
    //    Tnom4.setText(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),1)));
    //    TAnnee4.setText(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),2)));
        //  Tquantite.set(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(),3)));
//        Tetat.setText(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),4)));
//        Templacement.setText(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),5)));
     //   Ttype4.setText(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),6)));
     //   CcomboAnnee4.setSelectedItem(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),7)));
 //       Tident.setText(String.valueOf(JTable4.getValueAt(JTable4.getSelectedRow(),0)));
    }//GEN-LAST:event_JTable4MouseReleased

    private void Bmodifier4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bmodifier4MousePressed
        // TODO add your handling code here:
//        TestQM();
    }//GEN-LAST:event_Bmodifier4MousePressed

    private void Bsupprimer4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bsupprimer4MousePressed
        // TODO add your handling code here:
//        TestQS();
    }//GEN-LAST:event_Bsupprimer4MousePressed

    private void Bsupprimer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bsupprimer4ActionPerformed
        //   enregistrer();
        //  Afficher();// TODO add your handling code here:
    }//GEN-LAST:event_Bsupprimer4ActionPerformed

    private void Bactualiser4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bactualiser4MousePressed
        // TODO add your handling code here:
//        Actualiser();
    }//GEN-LAST:event_Bactualiser4MousePressed

    private void Bactualiser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bactualiser4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bactualiser4ActionPerformed

    private void BsupprimerTous4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsupprimerTous4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BsupprimerTous4MousePressed

    private void BsupprimerTous4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsupprimerTous4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BsupprimerTous4ActionPerformed

    private void CcomboAnnee4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcomboAnnee4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CcomboAnnee4ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminStock4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminStock4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminStock4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminStock4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminStock4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bactualiser4;
    public javax.swing.JButton Bmodifier4;
    public javax.swing.JButton Bsupprimer4;
    public javax.swing.JButton BsupprimerTous4;
    public javax.swing.JComboBox CcomboAnnee4;
    public javax.swing.JLabel Fond_Stock;
    public javax.swing.JTable JTable4;
    public javax.swing.JLabel LAnnee4;
    public javax.swing.JLabel Lnom4;
    public javax.swing.JLabel Lquantite4;
    public javax.swing.JLabel LtexteAffichertous4;
    public javax.swing.JLabel LtexteTousAnne4;
    public javax.swing.JLabel Ltype;
    public javax.swing.JTextField TAnnee4;
    public javax.swing.JScrollPane Table4;
    public javax.swing.JTextField Tid_bilan;
    public javax.swing.JTextField Tnom4;
    public javax.swing.JTextField Tquantite4;
    public javax.swing.JTextField Ttype4;
    public javax.swing.JLabel stockligne41;
    public javax.swing.JLabel stockligne42;
    public javax.swing.JLabel stockligne43;
    public javax.swing.JLabel stockligne44;
    // End of variables declaration//GEN-END:variables
}
