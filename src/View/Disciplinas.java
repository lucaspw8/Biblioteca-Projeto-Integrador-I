/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CursoControlador;
import Controller.DisciplinaControlador;
import Model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Disciplinas extends javax.swing.JFrame {

    private DisciplinaControlador controlador;
    private CursoControlador controladorCurso;
    Usuario usuario;

    public CursoControlador getControladorCurso() {
        return controladorCurso;
    }

    public void setControladorCurso(CursoControlador controladorCurso) {
        this.controladorCurso = controladorCurso;
    }

    public DisciplinaControlador getControlador() {
        return controlador;
    }

    public void setControlador(DisciplinaControlador controlador) {
        this.controlador = controlador;
    }

    public Disciplinas(Usuario usuario) {
        controlador = new DisciplinaControlador();
        controladorCurso = new CursoControlador();
        initComponents();
        controlador.atualizarTabela(tbDisciplina);
        txtIdDisciplina.setVisible(false);
        txtIdCurso.setVisible(false);
        this.usuario = usuario;
        if ("Funcionario".equals(usuario.getCargo())) {
            jm_Usuarios.setVisible(false);
            btnEditar.setVisible(false);
            btnCadastrar.setVisible(false);
            btnExcluir.setVisible(false);
        }
        this.setExtendedState(MAXIMIZED_BOTH);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdDisciplina = new javax.swing.JTextField();
        txtIdCurso = new javax.swing.JTextField();
        lblAsterisco = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDisciplina = new javax.swing.JTable();
        lblPesquisar = new javax.swing.JLabel();
        lblSar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_Inicio = new javax.swing.JMenu();
        jm_Usuarios = new javax.swing.JMenu();
        jm_Cursos = new javax.swing.JMenu();
        jm_Bibliografia = new javax.swing.JMenu();
        jm_Livros = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disciplinas");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("*Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${controlador.disciplina.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Cadastro");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${controlador.disciplina.idDisciplina}"), txtIdDisciplina, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${controladorCurso.curso.idCurso}"), txtIdCurso, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblAsterisco.setText("Os campos com (*) são obrigatórios");

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(txtNome)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAsterisco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(36, 36, 36)
                        .addComponent(btnEditar)
                        .addGap(32, 32, 32)
                        .addComponent(btnCadastrar)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(147, 147, 147))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAsterisco)
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar))
                .addGap(143, 143, 143)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Disciplinas");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Filtrar por Nome:");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
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
            tbDisciplina.getColumnModel().getColumn(0).setMinWidth(100);
            tbDisciplina.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        lblPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisa.png"))); // NOI18N
        lblPesquisar.setText("Pesquisar");
        lblPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPesquisar)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblSar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblSar.setText("Sair");
        lblSar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSarMouseClicked(evt);
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSar)
                        .addGap(24, 24, 24)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jm_Inicio.setText("Inico");
        jm_Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_InicioMouseClicked(evt);
            }
        });
        jMenuBar1.add(jm_Inicio);

        jm_Usuarios.setText("Usuarios");
        jm_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_UsuariosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jm_Usuarios);

        jm_Cursos.setText("Cursos");
        jm_Cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_CursosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jm_Cursos);

        jm_Bibliografia.setText("Bibliografia");
        jm_Bibliografia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_BibliografiaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jm_Bibliografia);

        jm_Livros.setText("Livros");
        jm_Livros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_LivrosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jm_Livros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (controlador.verificar()) {
            JOptionPane.showMessageDialog(null, "Os campos com (*) não podem estar vazios");
        } else {
            try {
                controlador.cadastrar();
                controlador.atualizarTabela(tbDisciplina);
                JOptionPane.showMessageDialog(null,"Disciplina Cadastrada !");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao Cadastrar ! "+e.getMessage());
            }
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jm_UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_UsuariosMouseClicked
        Usuarios usuarios = new Usuarios(usuario);
        usuarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_UsuariosMouseClicked

    private void jm_InicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_InicioMouseClicked
        Home home = new Home(usuario);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_InicioMouseClicked

    private void jm_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_CursosMouseClicked
        Curso curso = new Curso(usuario);
        curso.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_CursosMouseClicked

    private void jm_BibliografiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_BibliografiaMouseClicked
        Bibliografia bibliografia = new Bibliografia(usuario);
        bibliografia.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_BibliografiaMouseClicked

    private void jm_LivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_LivrosMouseClicked
        Livros livros = new Livros(usuario);
        livros.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_LivrosMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtNome.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void lblPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPesquisarMouseClicked
        if (txtFiltro.getText().trim().equals("")) {
            controlador.atualizarTabela(tbDisciplina);
        } else {
            controlador.atualizarTabela(tbDisciplina, txtFiltro.getText());

        }
    }//GEN-LAST:event_lblPesquisarMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            if (!"".equals(txtNome.getText())) {
                controlador.EditarDisciplina();
                controlador.atualizarTabela(tbDisciplina);
              
                JOptionPane.showMessageDialog(null, "Disciplina Editada !");
                btnLimparActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar o campo não pode estar vazio! ");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao editar ! ");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tbDisciplina.getSelectedRow() >= 0) {
            int resposta = JOptionPane.showConfirmDialog(null, "Você realmente quer excluir a Disciplina" + controlador.getDisciplina().getNome() + "?");
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    controlador.ExcluirLivro();
                    controlador.atualizarTabela(tbDisciplina);
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir!");

                }
            }
        } else {

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tbDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDisciplinaMouseClicked
        //Atribuindo os valores da tabela aos campos
        txtIdDisciplina.setText(tbDisciplina.getValueAt(tbDisciplina.getSelectedRow(), 0).toString());
        txtNome.setText(tbDisciplina.getValueAt(tbDisciplina.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_tbDisciplinaMouseClicked

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        if (txtFiltro.getText().trim().equals("")) {
            controlador.atualizarTabela(tbDisciplina);
        } else {
            controlador.atualizarTabela(tbDisciplina, txtFiltro.getText());

        }
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void lblSarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSarMouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblSarMouseClicked

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
//            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Disciplinas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jm_Bibliografia;
    private javax.swing.JMenu jm_Cursos;
    private javax.swing.JMenu jm_Inicio;
    private javax.swing.JMenu jm_Livros;
    private javax.swing.JMenu jm_Usuarios;
    private javax.swing.JLabel lblAsterisco;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblSar;
    private javax.swing.JTable tbDisciplina;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtIdCurso;
    private javax.swing.JTextField txtIdDisciplina;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
