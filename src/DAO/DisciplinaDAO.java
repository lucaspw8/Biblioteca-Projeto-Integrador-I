/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Disciplina;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Jefferson
 */
public class DisciplinaDAO {
    
    private Session sessao;
    private Transaction transacao;
    
    private void OpenConnection(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
   
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
    
    public void cadastrar(Disciplina disciplina){
        try {
        OpenConnection();
        //Pedindo para salvar Disicplina
        sessao.save(disciplina);
        CloseConnection();
        
        
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void atualizar(Disciplina disciplina){
        OpenConnection();
        sessao.update(disciplina);
        CloseConnection();
    }
    
    public List<Disciplina> pesquisar(Disciplina disciplina){
        OpenConnection();
        //like trabalha com case sensitive
      
       return sessao.createCriteria(Disciplina.class).add(Restrictions.ilike("nome",disciplina.getNome()+"%")).list();
    }
    
      public List<Disciplina> ListarDisciplina(Disciplina disciplina){
          OpenConnection();
        //like trabalha com case sensitive
        
        return sessao.createCriteria(Disciplina.class).list();
    }
      
      public List<Disciplina> Pesquisar(String texto){
          OpenConnection();
          //Ilike não diferencia maiusculo de minusculo
          List lista =sessao.createCriteria(Disciplina.class).add(Restrictions.ilike("nome",texto+"%")).list();
          CloseConnection();
          return lista;
      }
    
    public void Remover (Disciplina disciplina){
       OpenConnection();
       sessao.delete(disciplina);
       CloseConnection();
    }
    
}
