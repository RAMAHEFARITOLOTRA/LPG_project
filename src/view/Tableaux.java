/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Rafaly Antoni
 */
public class Tableaux extends javax.swing.JFrame {

    /**
     * Creates new form Tableaux
     */
    public Tableaux() {
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

        Pmois = new javax.swing.JScrollPane();
        mois1 = new javax.swing.JTable();
        P1 = new javax.swing.JScrollPane();
        S1 = new javax.swing.JTable();
        P2 = new javax.swing.JScrollPane();
        S2 = new javax.swing.JTable();
        P3 = new javax.swing.JScrollPane();
        S3 = new javax.swing.JTable();
        P4 = new javax.swing.JScrollPane();
        S4 = new javax.swing.JTable();
        P5 = new javax.swing.JScrollPane();
        S5 = new javax.swing.JTable();
        Pmois1 = new javax.swing.JScrollPane();
        mois2 = new javax.swing.JTable();
        P6 = new javax.swing.JScrollPane();
        S6 = new javax.swing.JTable();
        P7 = new javax.swing.JScrollPane();
        S7 = new javax.swing.JTable();
        P8 = new javax.swing.JScrollPane();
        S8 = new javax.swing.JTable();
        P9 = new javax.swing.JScrollPane();
        S9 = new javax.swing.JTable();
        Pmois2 = new javax.swing.JScrollPane();
        mois3 = new javax.swing.JTable();
        P10 = new javax.swing.JScrollPane();
        S10 = new javax.swing.JTable();
        P11 = new javax.swing.JScrollPane();
        S11 = new javax.swing.JTable();
        P12 = new javax.swing.JScrollPane();
        S12 = new javax.swing.JTable();
        P13 = new javax.swing.JScrollPane();
        S13 = new javax.swing.JTable();
        Pmois3 = new javax.swing.JScrollPane();
        mois4 = new javax.swing.JTable();
        P14 = new javax.swing.JScrollPane();
        S14 = new javax.swing.JTable();
        P15 = new javax.swing.JScrollPane();
        S15 = new javax.swing.JTable();
        P16 = new javax.swing.JScrollPane();
        S16 = new javax.swing.JTable();
        P17 = new javax.swing.JScrollPane();
        S17 = new javax.swing.JTable();
        P18 = new javax.swing.JScrollPane();
        S18 = new javax.swing.JTable();
        Pmois4 = new javax.swing.JScrollPane();
        mois5 = new javax.swing.JTable();
        P19 = new javax.swing.JScrollPane();
        S19 = new javax.swing.JTable();
        P20 = new javax.swing.JScrollPane();
        S20 = new javax.swing.JTable();
        P21 = new javax.swing.JScrollPane();
        S21 = new javax.swing.JTable();
        P22 = new javax.swing.JScrollPane();
        S22 = new javax.swing.JTable();
        Pmois5 = new javax.swing.JScrollPane();
        mois6 = new javax.swing.JTable();
        P23 = new javax.swing.JScrollPane();
        S23 = new javax.swing.JTable();
        P24 = new javax.swing.JScrollPane();
        S24 = new javax.swing.JTable();
        P25 = new javax.swing.JScrollPane();
        S25 = new javax.swing.JTable();
        P26 = new javax.swing.JScrollPane();
        S26 = new javax.swing.JTable();
        fond = new javax.swing.JLabel();
        Pmois6 = new javax.swing.JScrollPane();
        mois7 = new javax.swing.JTable();
        Pmois7 = new javax.swing.JScrollPane();
        mois8 = new javax.swing.JTable();
        Pmois8 = new javax.swing.JScrollPane();
        mois9 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        Pmois.setBackground(new java.awt.Color(255, 51, 102));
        Pmois.setBorder(null);
        Pmois.setForeground(new java.awt.Color(255, 51, 51));

        mois1.setBackground(new java.awt.Color(255, 0, 0));
        mois1.setForeground(new java.awt.Color(255, 0, 0));
        mois1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "teste"
            }
        ));
        Pmois.setViewportView(mois1);

        getContentPane().add(Pmois);
        Pmois.setBounds(60, 140, 350, 22);

        P1.setBorder(null);

        S1.setForeground(new java.awt.Color(0, 102, 255));
        S1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P1.setViewportView(S1);

        getContentPane().add(P1);
        P1.setBounds(60, 163, 70, 110);

        P2.setBorder(null);

        S2.setForeground(new java.awt.Color(0, 102, 255));
        S2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 2"
            }
        ));
        P2.setViewportView(S2);

        getContentPane().add(P2);
        P2.setBounds(130, 163, 70, 110);

        P3.setBorder(null);

        S3.setForeground(new java.awt.Color(0, 102, 255));
        S3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P3.setViewportView(S3);

        getContentPane().add(P3);
        P3.setBounds(200, 163, 70, 110);

        P4.setBorder(null);

        S4.setForeground(new java.awt.Color(0, 102, 255));
        S4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 4"
            }
        ));
        P4.setViewportView(S4);

        getContentPane().add(P4);
        P4.setBounds(270, 163, 70, 110);

        P5.setBorder(null);

        S5.setForeground(new java.awt.Color(0, 102, 255));
        S5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 5"
            }
        ));
        P5.setViewportView(S5);

        getContentPane().add(P5);
        P5.setBounds(340, 163, 70, 110);

        Pmois1.setBorder(null);

        mois2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TESTE2"
            }
        ));
        Pmois1.setViewportView(mois2);

        getContentPane().add(Pmois1);
        Pmois1.setBounds(410, 140, 280, 22);

        P6.setBorder(null);

        S6.setForeground(new java.awt.Color(0, 102, 255));
        S6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ));
        P6.setViewportView(S6);

        getContentPane().add(P6);
        P6.setBounds(410, 163, 70, 110);

        P7.setBorder(null);

        S7.setForeground(new java.awt.Color(0, 102, 255));
        S7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P7.setViewportView(S7);

        getContentPane().add(P7);
        P7.setBounds(480, 163, 70, 110);

        P8.setBorder(null);

        S8.setForeground(new java.awt.Color(0, 102, 255));
        S8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P8.setViewportView(S8);

        getContentPane().add(P8);
        P8.setBounds(550, 163, 70, 110);

        P9.setBorder(null);

        S9.setForeground(new java.awt.Color(0, 102, 255));
        S9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P9.setViewportView(S9);

        getContentPane().add(P9);
        P9.setBounds(620, 163, 70, 110);

        Pmois2.setBorder(null);

        mois3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "test3"
            }
        ));
        Pmois2.setViewportView(mois3);

        getContentPane().add(Pmois2);
        Pmois2.setBounds(690, 140, 280, 22);

        P10.setBorder(null);

        S10.setForeground(new java.awt.Color(0, 102, 255));
        S10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P10.setViewportView(S10);

        getContentPane().add(P10);
        P10.setBounds(690, 163, 70, 110);

        P11.setBorder(null);

        S11.setForeground(new java.awt.Color(0, 102, 255));
        S11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P11.setViewportView(S11);

        getContentPane().add(P11);
        P11.setBounds(760, 163, 70, 110);

        P12.setBorder(null);

        S12.setForeground(new java.awt.Color(0, 102, 255));
        S12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P12.setViewportView(S12);

        getContentPane().add(P12);
        P12.setBounds(830, 163, 70, 110);

        P13.setBorder(null);

        S13.setForeground(new java.awt.Color(0, 102, 255));
        S13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        P13.setViewportView(S13);

        getContentPane().add(P13);
        P13.setBounds(900, 163, 70, 110);

        Pmois3.setBorder(null);

        mois4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "teste 4"
            }
        ));
        Pmois3.setViewportView(mois4);

        getContentPane().add(Pmois3);
        Pmois3.setBounds(60, 276, 350, 22);
        Pmois3.getAccessibleContext().setAccessibleName("");

        P14.setBorder(null);

        S14.setForeground(new java.awt.Color(0, 102, 255));
        S14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P14.setViewportView(S14);

        getContentPane().add(P14);
        P14.setBounds(60, 300, 70, 110);

        P15.setBorder(null);

        S15.setForeground(new java.awt.Color(0, 102, 255));
        S15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P15.setViewportView(S15);

        getContentPane().add(P15);
        P15.setBounds(130, 300, 70, 110);

        P16.setBorder(null);

        S16.setForeground(new java.awt.Color(0, 102, 255));
        S16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P16.setViewportView(S16);

        getContentPane().add(P16);
        P16.setBounds(200, 300, 70, 110);

        P17.setBorder(null);

        S17.setForeground(new java.awt.Color(0, 102, 255));
        S17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P17.setViewportView(S17);

        getContentPane().add(P17);
        P17.setBounds(270, 300, 70, 110);

        P18.setBorder(null);

        S18.setForeground(new java.awt.Color(0, 102, 255));
        S18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P18.setViewportView(S18);

        getContentPane().add(P18);
        P18.setBounds(340, 300, 70, 110);

        Pmois4.setBorder(null);

        mois5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "test 5"
            }
        ));
        Pmois4.setViewportView(mois5);

        getContentPane().add(Pmois4);
        Pmois4.setBounds(410, 276, 280, 22);
        Pmois4.getAccessibleContext().setAccessibleName("");

        P19.setBorder(null);

        S19.setForeground(new java.awt.Color(0, 102, 255));
        S19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P19.setViewportView(S19);

        getContentPane().add(P19);
        P19.setBounds(410, 300, 70, 110);

        P20.setBorder(null);

        S20.setForeground(new java.awt.Color(0, 102, 255));
        S20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P20.setViewportView(S20);

        getContentPane().add(P20);
        P20.setBounds(480, 300, 70, 110);

        P21.setBorder(null);

        S21.setForeground(new java.awt.Color(0, 102, 255));
        S21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P21.setViewportView(S21);

        getContentPane().add(P21);
        P21.setBounds(550, 300, 70, 110);

        P22.setBorder(null);

        S22.setForeground(new java.awt.Color(0, 102, 255));
        S22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P22.setViewportView(S22);

        getContentPane().add(P22);
        P22.setBounds(620, 300, 70, 110);

        Pmois5.setBorder(null);

        mois6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "teste 61"
            }
        ));
        Pmois5.setViewportView(mois6);

        getContentPane().add(Pmois5);
        Pmois5.setBounds(690, 276, 280, 22);
        Pmois5.getAccessibleContext().setAccessibleName("");

        P23.setBorder(null);

        S23.setForeground(new java.awt.Color(0, 102, 255));
        S23.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P23.setViewportView(S23);

        getContentPane().add(P23);
        P23.setBounds(690, 300, 70, 110);

        P24.setBorder(null);

        S24.setForeground(new java.awt.Color(0, 102, 255));
        S24.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P24.setViewportView(S24);

        getContentPane().add(P24);
        P24.setBounds(760, 300, 70, 110);

        P25.setBorder(null);

        S25.setForeground(new java.awt.Color(0, 102, 255));
        S25.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P25.setViewportView(S25);

        getContentPane().add(P25);
        P25.setBounds(830, 300, 70, 110);

        P26.setBorder(null);

        S26.setForeground(new java.awt.Color(0, 102, 255));
        S26.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semaine 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        P26.setViewportView(S26);

        getContentPane().add(P26);
        P26.setBounds(900, 300, 70, 110);
        getContentPane().add(fond);
        fond.setBounds(0, 0, 1000, 600);

        Pmois6.setBorder(null);

        mois7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "teste 4"
            }
        ));
        Pmois6.setViewportView(mois7);

        getContentPane().add(Pmois6);
        Pmois6.setBounds(60, 280, 350, 22);

        Pmois7.setBorder(null);

        mois8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "teste 61"
            }
        ));
        Pmois7.setViewportView(mois8);

        getContentPane().add(Pmois7);
        Pmois7.setBounds(690, 280, 280, 22);

        Pmois8.setBorder(null);

        mois9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "test 5"
            }
        ));
        Pmois8.setViewportView(mois9);

        getContentPane().add(Pmois8);
        Pmois8.setBounds(410, 280, 280, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tableaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tableaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tableaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tableaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tableaux().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane P1;
    public javax.swing.JScrollPane P10;
    public javax.swing.JScrollPane P11;
    public javax.swing.JScrollPane P12;
    public javax.swing.JScrollPane P13;
    public javax.swing.JScrollPane P14;
    public javax.swing.JScrollPane P15;
    public javax.swing.JScrollPane P16;
    public javax.swing.JScrollPane P17;
    public javax.swing.JScrollPane P18;
    public javax.swing.JScrollPane P19;
    public javax.swing.JScrollPane P2;
    public javax.swing.JScrollPane P20;
    public javax.swing.JScrollPane P21;
    public javax.swing.JScrollPane P22;
    public javax.swing.JScrollPane P23;
    public javax.swing.JScrollPane P24;
    public javax.swing.JScrollPane P25;
    public javax.swing.JScrollPane P26;
    public javax.swing.JScrollPane P3;
    public javax.swing.JScrollPane P4;
    public javax.swing.JScrollPane P5;
    public javax.swing.JScrollPane P6;
    public javax.swing.JScrollPane P7;
    public javax.swing.JScrollPane P8;
    public javax.swing.JScrollPane P9;
    public javax.swing.JScrollPane Pmois;
    public javax.swing.JScrollPane Pmois1;
    public javax.swing.JScrollPane Pmois2;
    public javax.swing.JScrollPane Pmois3;
    public javax.swing.JScrollPane Pmois4;
    public javax.swing.JScrollPane Pmois5;
    public javax.swing.JScrollPane Pmois6;
    public javax.swing.JScrollPane Pmois7;
    public javax.swing.JScrollPane Pmois8;
    public javax.swing.JTable S1;
    public javax.swing.JTable S10;
    public javax.swing.JTable S11;
    public javax.swing.JTable S12;
    public javax.swing.JTable S13;
    public javax.swing.JTable S14;
    public javax.swing.JTable S15;
    public javax.swing.JTable S16;
    public javax.swing.JTable S17;
    public javax.swing.JTable S18;
    public javax.swing.JTable S19;
    public javax.swing.JTable S2;
    public javax.swing.JTable S20;
    public javax.swing.JTable S21;
    public javax.swing.JTable S22;
    public javax.swing.JTable S23;
    public javax.swing.JTable S24;
    public javax.swing.JTable S25;
    public javax.swing.JTable S26;
    public javax.swing.JTable S3;
    public javax.swing.JTable S4;
    public javax.swing.JTable S5;
    public javax.swing.JTable S6;
    public javax.swing.JTable S7;
    public javax.swing.JTable S8;
    public javax.swing.JTable S9;
    private javax.swing.JLabel fond;
    public javax.swing.JTable mois1;
    public javax.swing.JTable mois2;
    public javax.swing.JTable mois3;
    public javax.swing.JTable mois4;
    public javax.swing.JTable mois5;
    public javax.swing.JTable mois6;
    public javax.swing.JTable mois7;
    public javax.swing.JTable mois8;
    public javax.swing.JTable mois9;
    // End of variables declaration//GEN-END:variables
}
