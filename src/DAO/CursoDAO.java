/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Curso;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jefferson
 */
public class CursoDAO {
    
    private Session sessão;
    private Transaction transacao;
    
    public CursoDAO(){
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
    
    public void cadastrar(Curso curso){
        try {
              //Pedindo para salvar Curso
        sessão.save(curso);
        
        //Solicitando o envio dos dados ao banco
        transacao.commit();
        //Encerra a sessão com o banco libeando a conecção
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
      
      
    }
    
    public void atualizar(Curso curso){
        try {
              sessão.update(curso);
              transacao.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
      
    }
    
      public List<Curso> ListarCurso(Curso curso){
        
        List lista = sessão.createCriteria(Curso.class).list();
       
        return lista;
     }
    public List<Curso> pesquisar(Curso curso){
        //like trabalha com case sensitive
        return sessão.createCriteria(Curso.class).add(Restrictions.ilike("nome",curso.getNome()+"%")).list();
    }
    
    public void Remover (Curso curso){
        try {
             sessão.delete(curso);
             transacao.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
 
      
    }
    
}
