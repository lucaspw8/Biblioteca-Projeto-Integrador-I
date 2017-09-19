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

    private Session sessao;
    private Transaction transacao;

    private void OpenConnection() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }

    private void CloseConnection() {
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

    public void cadastrar(Curso curso) {
        try {
            OpenConnection();
            //Pedindo para salvar Curso
            sessao.save(curso);
            CloseConnection();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizar(Curso curso) {
        try {
            OpenConnection();
            sessao.update(curso);
            CloseConnection();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Curso> ListarCurso(Curso curso) {
        OpenConnection();
        List lista = sessao.createCriteria(Curso.class).list();
        CloseConnection();
        return lista;
    }

    public List<Curso> pesquisar(Curso curso) {
        //like trabalha com case sensitive
        OpenConnection();
        return sessao.createCriteria(Curso.class).add(Restrictions.ilike("nome", curso.getNome() + "%")).list();
    }

    public void Remover(Curso curso) {
        try {
            OpenConnection();
            sessao.delete(curso);
            CloseConnection();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
    
     public List<Curso> Pesquisar(String texto){
          OpenConnection();
          //Ilike não diferencia maiusculo de minusculo
          List lista =sessao.createCriteria(Curso.class).add(Restrictions.ilike("nome",texto+"%")).list();
          CloseConnection();
          return lista;
      }

}
