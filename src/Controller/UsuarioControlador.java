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

    private Usuario usuario = new Usuario();
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

    public void Cadastrar() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrar(usuario);
    }

    public void Editar() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.atualizar(usuario);
    }

    /**
     * Remove um usuario
     */
    public void Excluir() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.Remover(usuario);
    }

    /**
     * Chama o dao de Listar usuario
     */
    public void listaUsuario() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            listaUsu = dao.ListarUsuario(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    
    public void PesquisarUsuario(String texto){
      UsuarioDAO dao = new UsuarioDAO();
      listaUsu = dao.Pesquisar(texto);
    }

    /**
     * Coloca todos os dados buscados na tabela
     *
     * @param tabela
     * @exception RuntimeException
     */
    public void atualizarTabela(JTable tabela) {
        try {
            listaUsuario();

            List<Usuario> UsuariosEncontrados = getListaUsu();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

            modelo.setNumRows(0);

            for (int x = 0; x < UsuariosEncontrados.size(); x++) {
                modelo.insertRow(x, new String[]{
                    String.valueOf(UsuariosEncontrados.get(x).getId()),
                    UsuariosEncontrados.get(x).getNome(),
                    UsuariosEncontrados.get(x).getLogin(),
                    UsuariosEncontrados.get(x).getSenha(),
                    UsuariosEncontrados.get(x).getEmail(),
                    UsuariosEncontrados.get(x).getCargo()

                });
            }

            tabela.setModel(modelo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public void atualizarTabela(JTable tabela, String pesquisa) {
        try {
            PesquisarUsuario(pesquisa);

            List<Usuario> UsuariosEncontrados = getListaUsu();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

            modelo.setNumRows(0);

            for (int x = 0; x < UsuariosEncontrados.size(); x++) {
                modelo.insertRow(x, new String[]{
                    String.valueOf(UsuariosEncontrados.get(x).getId()),
                    UsuariosEncontrados.get(x).getNome(),
                    UsuariosEncontrados.get(x).getLogin(),
                    UsuariosEncontrados.get(x).getSenha(),
                    UsuariosEncontrados.get(x).getEmail(),
                    UsuariosEncontrados.get(x).getCargo()

                });
            }

            tabela.setModel(modelo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Verifica se foi encontrado o usuario buscado
     * @return boolean
     */
    public Usuario Login() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> loginList = dao.LoginUsu(usuario);
            
            if(!loginList.isEmpty() ){
                return loginList.get(0);    
            }
            
        } catch (Exception e) {
            return null;
        }

        return null;
    }
    
    public boolean verificar(){
        
       return usuario.getLogin() == null || usuario.getNome() == null || usuario.getSenha() == null;
    
    }
    
}
