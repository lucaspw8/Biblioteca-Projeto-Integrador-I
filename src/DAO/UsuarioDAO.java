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
    
     private Session sessão;
     private Transaction transacao;
    
    public UsuarioDAO(){
        //Aberta a sessão
        sessão = HibernateUtil.getSessionFactory().openSession();
        //Inicio da transação
        transacao = sessão.beginTransaction();
    }

    public Session getSessão() {
        return sessão;
    }

    public void setSessão(Session sessão) {
        this.sessão = sessão;
    }

    public Transaction getTransacao() {
        return transacao;
    }

    public void setTransacao(Transaction transacao) {
        this.transacao = transacao;
    }
 
    public void cadastrar(Usuario usuario){
        try {
        //Pedindo para salvar Disicplina
        sessão.save(usuario);
        
        //Solicitando o envio dos dados ao banco
        transacao.commit();
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
            sessão.update(usuario);
            transacao.commit();
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
            sessão.delete(usuario);
            transacao.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
       
    }
    
    public List<Usuario> ListarDisciplina(Usuario usuario){
        //like trabalha com case sensitive
       return sessão.createCriteria(Usuario.class).list();
    }
}
