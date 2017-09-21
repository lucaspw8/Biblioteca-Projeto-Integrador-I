/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Home extends javax.swing.JFrame {
    Usuario usuario;
    /**
     * Creates new form Home
     */
    public Home(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        if ("Funcionario".equals(usuario.getCargo())){
            jm_Usuarios.setVisible(false);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_Usuarios = new javax.swing.JMenu();
        jm_Cursos = new javax.swing.JMenu();
        jm_Disciplinas = new javax.swing.JMenu();
        jm_Bibliografia = new javax.swing.JMenu();
        jm_Livros = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Acesso rápido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bem vindo ao SGB");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jm_Usuarios.setText("Usuarios");
        jm_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_UsuariosMouseClicked(evt);
            }
        });
        jm_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_UsuariosActionPerformed(evt);
            }
        });
        jMenuBar1.add(jm_Usuarios);

        jm_Cursos.setText("Cursos");
        jm_Cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_CursosMouseClicked(evt);
            }
        });
        jm_Cursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_CursosActionPerformed(evt);
            }
        });
        jMenuBar1.add(jm_Cursos);

        jm_Disciplinas.setText("Disciplinas");
        jm_Disciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jm_DisciplinasMouseClicked(evt);
            }
        });
        jMenuBar1.add(jm_Disciplinas);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jm_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_UsuariosActionPerformed

    }//GEN-LAST:event_jm_UsuariosActionPerformed

    private void jm_CursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_CursosActionPerformed
        
    }//GEN-LAST:event_jm_CursosActionPerformed

    private void jm_UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_UsuariosMouseClicked
        Usuarios usu = new Usuarios(usuario);
        usu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_UsuariosMouseClicked

    private void jm_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_CursosMouseClicked
        Curso curso = new Curso(usuario);
        curso.setVisible(true);
        dispose();
    }//GEN-LAST:event_jm_CursosMouseClicked

    private void jm_DisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jm_DisciplinasMouseClicked
       Disciplinas disciplina = new Disciplinas(usuario);
       disciplina.setVisible(true);
       dispose();
    }//GEN-LAST:event_jm_DisciplinasMouseClicked

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
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jm_Bibliografia;
    private javax.swing.JMenu jm_Cursos;
    private javax.swing.JMenu jm_Disciplinas;
    private javax.swing.JMenu jm_Livros;
    private javax.swing.JMenu jm_Usuarios;
    // End of variables declaration//GEN-END:variables
}
