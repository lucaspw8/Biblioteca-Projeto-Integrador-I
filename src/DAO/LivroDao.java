/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Livro;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;


/**
 *
 * @author Lucas
 */
public class LivroDao {
     
    private Session sessão;
    private Transaction transacao;
    
      public LivroDao(){
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
      
      
}
