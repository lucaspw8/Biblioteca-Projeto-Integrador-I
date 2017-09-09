/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Livro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
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
    
    /**
     * Responsavel pelo envio dos dados ao Banco
     * @
     * @param livro
     * @exception HibernateException
     */
      public void CadastrarLivro(Livro livro){
        try {
             sessão.save(livro);
             transacao.commit();
          
            
        } catch (HibernateException e) {
            
            throw new RuntimeException(e);
        }
       
    }
      /**
       * 
       * @param livro
       * @return 
       */
      public List<Livro> Listarlivro(Livro livro){
        // Essa variavel foi criada para poder fechar a conecção com o banco antes do retorno
        List lista = sessão.createCriteria(Livro.class).list();
       
        return lista;
     }
      
      /**
       * Faz a edição dos dados do livro no banco de dados
       * @param livro
       * @exception HibernateException
       */
       public void atualizar(Livro livro){
           try {
              
               sessão.update(livro);
               transacao.commit();
               
               
           } catch (HibernateException e) {
               throw new RuntimeException(e);
           }
        
    }
       
       
    public void Excluir(Livro livro){
        try{
           
           sessão.delete("deletar", livro);
           transacao.commit();
            
        } catch (HibernateException e){
            
            throw new RuntimeException(e);
        }
    }
}
