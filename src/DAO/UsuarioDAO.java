/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
/**
 *
 * @author Lucas
 */
public class UsuarioDAO {
    
     private Session sessao;
     private Transaction transacao;
    
     /**
     * Abre a coneção e inicia a transação
     */
    private void OpenConnection(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
   /**
     * Realiza o commit e depois encerra a sessao
     */
    private void CloseConnection(){
        transacao.commit();
        sessao.close();
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Transaction getTransacao() {
        return transacao;
    }

    public void setTransacao(Transaction transacao) {
        this.transacao = transacao;
    }
 
    public void cadastrar(Usuario usuario){
        try {
         OpenConnection();
        //Pedindo para salvar Disicplina
        sessao.save(usuario);
        CloseConnection();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    /**
     * Edita um Usuario passado como parametro
     * @param usuario 
     * @exception HibernateException
     */
    public void atualizar(Usuario usuario){
        try {
            OpenConnection();
            sessao.update(usuario);
           CloseConnection();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        
    }
    /**
     * Remove um usuario
     * @param usuario 
     * @exception HibernateException
     */
    public void Remover (Usuario usuario){
        try {
            OpenConnection();
            sessao.delete(usuario);
           CloseConnection();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
       
    }
    
    public List<Usuario> ListarDisciplina(Usuario usuario){
       OpenConnection();
       List lista = sessao.createCriteria(Usuario.class).list();
       return lista;
    }
}
