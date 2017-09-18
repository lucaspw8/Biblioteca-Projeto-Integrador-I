/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class UsuarioControlador {
    private Usuario usuario =  new Usuario();
    private List<Usuario> listaUsu;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsu() {
        return listaUsu;
    }

    public void setListaUsu(List<Usuario> listaUsu) {
        this.listaUsu = listaUsu;
    }
    
    
    public void Cadastrar(){
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrar(usuario);
    }
    
    public  void Editar(){
        UsuarioDAO dao =  new UsuarioDAO();
        dao.atualizar(usuario);
    }
    
    
    /**
     * Remove um usuario
     */
    public void Excluir(){
        UsuarioDAO dao = new UsuarioDAO();
        dao.Remover(usuario);
    }
    
    
    public void listaUsuario(){
      UsuarioDAO dao = new UsuarioDAO();
     listaUsu = dao.ListarDisciplina(usuario);
    }
    
    public void atualizarTabela(JTable tabela) {
        
        
            listaUsuario();

            List<Usuario> DisciplinasEncontrados = getListaUsu();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            
            modelo.setNumRows(0);

            for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
                modelo.insertRow(x,new String[]{
                            String.valueOf(DisciplinasEncontrados.get(x).getId()),
                            DisciplinasEncontrados.get(x).getNome(),
                            DisciplinasEncontrados.get(x).getLogin(),
                            DisciplinasEncontrados.get(x).getSenha(),
                            DisciplinasEncontrados.get(x).getEmail(),
                            DisciplinasEncontrados.get(x).getCargo()
                            
                         });
            }

            tabela.setModel(modelo);
        }
}
