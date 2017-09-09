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
    
    private Session sessão;
    private Transaction transacao;
    
    public DisciplinaDAO(){
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
    
    public void cadastrar(Disciplina disciplina){
        try {
        //Pedindo para salvar Disicplina
        sessão.save(disciplina);
        
        //Solicitando o envio dos dados ao banco
        transacao.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void atualizar(Disciplina disciplina){
        sessão.update(disciplina);
        transacao.commit();
    }
    
    public List<Disciplina> pesquisar(Disciplina disciplina){
        //like trabalha com case sensitive
       return sessão.createCriteria(Disciplina.class).add(Restrictions.ilike("nome",disciplina.getNome()+"%")).list();
    }
    
      public List<Disciplina> ListarDisciplina(Disciplina disciplina){
        //like trabalha com case sensitive
       return sessão.createCriteria(Disciplina.class).list();
    }
    
    public void Remover (Disciplina disciplina){
       sessão.delete(disciplina);
       transacao.commit();
    }
    
}
