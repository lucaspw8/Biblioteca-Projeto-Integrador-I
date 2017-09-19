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
    
    /**
     * Responsavel pelo envio dos dados ao Banco
     * @
     * @param livro
     * @exception HibernateException
     */
      public void CadastrarLivro(Livro livro){
        try {
            OpenConnection();
             sessao.save(livro);
             CloseConnection();
          
            
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
       OpenConnection();
        List lista = sessao.createCriteria(Livro.class).list();
        CloseConnection();
        return lista;
     }
      /**
       * 
       * @param texto
       * @return 
       */
      public List<Livro> Pesquisar(String texto){
          OpenConnection();
          //Ilike não diferencia maiusculo de minusculo
          List lista =sessao.createCriteria(Livro.class).add(Restrictions.ilike("titulo",texto+"%")).list();
          CloseConnection();
          return lista;
      }
      
      /**
       * Faz a edição dos dados do livro no banco de dados
       * @param livro
       * @exception HibernateException
       */
       public void atualizar(Livro livro){
           try {
               OpenConnection();
               sessao.update(livro);
               CloseConnection();
               
               
           } catch (HibernateException e) {
               throw new RuntimeException(e);
           }
        
    }
       
       
    public void Excluir(Livro livro){
        try{
           OpenConnection();
           sessao.delete("deletar", livro);
           CloseConnection();
            
        } catch (HibernateException e){
            
            throw new RuntimeException(e);
        }
    }
}
