/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.Curso;
import Controller.DisciplinaControlador;

/**
 *
 * @author Lucas
 */
public class CursoDisciplina extends javax.swing.JFrame {
    Curso curso;
    private DisciplinaControlador controlador;

    public DisciplinaControlador getControlador() {
        return controlador;
    }

    public void setControlador(DisciplinaControlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Creates new form CursoDisciplina
     * @param curso
     */
    public CursoDisciplina(Curso curso) {
        controlador = new DisciplinaControlador();
        initComponents();
        this.curso = curso;
        controlador.atualizarTabela(tbDisciplina, curso.getIdCurso());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        lblPesquisar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDisciplina = new javax.swing.JTable();
        btNvDisciplina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Disciplina do Curso");
        setName("DisciplinaCurso"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Filtrar por Nome:");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        lblPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisa.png"))); // NOI18N
        lblPesquisar.setText("Pesquisar");
        lblPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesquisarMouseClicked(evt);
            }
        });

        tbDisciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDisciplina.setRowHeight(20);
        tbDisciplina.getTableHeader().setReorderingAllowed(false);
        tbDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDisciplinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDisciplina);
        if (tbDisciplina.getColumnModel().getColumnCount() > 0) {
            tbDisciplina.getColumnModel().getColumn(0).setMinWidth(60);
            tbDisciplina.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        btNvDisciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btNvDisciplina.setText("Nova Disciplina");
        btNvDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNvDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPesquisar)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btNvDisciplina)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btNvDisciplina)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        if (txtFiltro.getText().trim().equals("")) {
            controlador.atualizarTabela(tbDisciplina,this.curso.getIdCurso());
        } else {
            controlador.atualizarTabela(tbDisciplina,this.curso.getIdCurso(),txtFiltro.getText());

        }
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void lblPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesquisarMouseClicked
        if (txtFiltro.getText().trim().equals("")) {
            controlador.atualizarTabela(tbDisciplina,this.curso.getIdCurso());
        } else {
            controlador.atualizarTabela(tbDisciplina,this.curso.getIdCurso() ,txtFiltro.getText());

        }
    }//GEN-LAST:event_lblPesquisarMouseClicked

    private void tbDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDisciplinaMouseClicked
        //Atribuindo os valores da tabela aos campos
        //txtIdDisciplina.setText(tbDisciplina.getValueAt(tbDisciplina.getSelectedRow(), 0).toString());
        //txtNome.setText(tbDisciplina.getValueAt(tbDisciplina.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tbDisciplinaMouseClicked

    private void btNvDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNvDisciplinaActionPerformed
        CursoAssDisciplina novaTela = new CursoAssDisciplina(this.curso);
         novaTela.setLocationRelativeTo(null);
        novaTela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btNvDisciplinaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CursoDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CursoDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CursoDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CursoDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CursoDisciplina().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNvDisciplina;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JTable tbDisciplina;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
