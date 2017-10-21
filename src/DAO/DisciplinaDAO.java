/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Disciplina;
import java.sql.Connection;
import Conexao.Conectar;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private final Connection conecta;
    private Session sessao;
    private Transaction transacao;

    public DisciplinaDAO() {
        this.conecta = new Conectar().conecta();
    }

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

    public void cadastrar(Disciplina disciplina) {
        try {
            OpenConnection();
            //Pedindo para salvar Disicplina
            sessao.save(disciplina);
            CloseConnection();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizar(Disciplina disciplina) {
        OpenConnection();
        sessao.update(disciplina);
        CloseConnection();
    }

    public List<Disciplina> pesquisar(Disciplina disciplina) {
        OpenConnection();
        //like trabalha com case sensitive

        return sessao.createCriteria(Disciplina.class).add(Restrictions.ilike("nome", disciplina.getNome() + "%")).list();
    }

    public List<Disciplina> ListarDisciplina(Disciplina disciplina) {
        OpenConnection();
        //like trabalha com case sensitive

        return sessao.createCriteria(Disciplina.class).list();
    }

    public List<Disciplina> RelCurso(int idCurso) {
        try {
            List<Disciplina> disciplinas = new ArrayList<>();
            String sql = "select d.*  from disciplina d, curso c, rel_curso_disci rel\n"
                    + "WHERE rel.idDisciplina = d.idDisciplina and rel.idCurso =?\n"
                    + "GROUP by d.idDisciplina ORDER by d.idDisciplina";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            //3º Passo guardar o resultado dentro de um obj ResultSet
            stmt.setInt(1, idCurso);
            ResultSet rs = stmt.executeQuery();
            
            //4º Enqualto tiver resultado guardar no registro da lista
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setIdDisciplina(rs.getInt("idDisciplina"));
                d.setNome(rs.getString("nome"));

                disciplinas.add(d);
            }
            stmt.close();
            return disciplinas;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Disciplina> Pesquisar(String texto) {
        OpenConnection();
        //Ilike não diferencia maiusculo de minusculo
        List lista = sessao.createCriteria(Disciplina.class).add(Restrictions.ilike("nome", "%" + texto + "%")).list();
        CloseConnection();
        return lista;
    }
    
    /**
     * Função que filtra as disciplinas pertencentes a um curso especifico
     * @param texto
     * @param idCurso
     * @return 
     */
    public List<Disciplina> Pesquisar(String texto, int idCurso) {
        try {
            List<Disciplina> disciplinas = new ArrayList<>();
            String sql = "select d.*  from disciplina d, curso c, rel_curso_disci rel\n"
                    + "WHERE rel.idDisciplina = d.idDisciplina and rel.idCurso =? and d.nome like ?\n"
                    + "GROUP by d.idDisciplina ORDER by d.idDisciplina";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            //3º Passo guardar o resultado dentro de um obj ResultSet
            stmt.setInt(1, idCurso);
            stmt.setString(2, "%"+ texto +"%");
            ResultSet rs = stmt.executeQuery();
            
            //4º Enqualto tiver resultado guardar no registro da lista
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setIdDisciplina(rs.getInt("idDisciplina"));
                d.setNome(rs.getString("nome"));

                disciplinas.add(d);
            }
            stmt.close();
            return disciplinas;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    
    /**
     * Associa uma disciplina a um curso expecifico
     * @param idCurso
     * @param idDisc 
     */
      public void CursoDiscAss(int idCurso,int idDisc){
      try {
           // 1º passo Criar a SQL
            String comando = "insert into rel_curso_disci (idCurso,idDisciplina) values(?,?)";
            //2º passo organizar o comando e executa-lo
            PreparedStatement stmt = conecta.prepareStatement(comando);

            stmt.setInt(1, idCurso);
            stmt.setInt(2, idDisc);

            //3º Executa comando 
            stmt.execute();
            //4º Fecha conexao
            stmt.close();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }

    public void Remover(Disciplina disciplina) {
        OpenConnection();
        sessao.delete(disciplina);
        CloseConnection();
    }

}
