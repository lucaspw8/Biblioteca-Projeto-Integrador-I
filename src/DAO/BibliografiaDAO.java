/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Conexao.Conectar;
import Model.Bibliografia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class BibliografiaDAO {

    private final Connection conecta;

    public BibliografiaDAO() {
        this.conecta = new Conectar().conecta();
    }

    /**
     * Cadastra auma Bibliografia
     *
     * @param bibliografia
     * @exception SQLException
     */
    public void cadastrar(Bibliografia bibliografia) {
        try {
            // 1º passo Criar a SQL
            String comando = "insert into rel_curso_disci (idCurso,idDisciplina) values(?,?)";
            //2º passo organizar o comando e executa-lo
            PreparedStatement stmt = conecta.prepareStatement(comando);

            stmt.setInt(1, bibliografia.getIdCurso());
            stmt.setInt(2, bibliografia.getIdDisciplina());

            //3º Executa comando 
            stmt.execute();
            //4º Fecha conexao
            stmt.close();

            String comando2 = "insert into rel_livro_disci (idLivro,idDisciplina) values(?,?)";
            //2º passo organizar o comando e executa-lo
            PreparedStatement stmt1 = conecta.prepareStatement(comando2);

            stmt1.setInt(1, bibliografia.getIdLivro());
            stmt1.setInt(2, bibliografia.getIdDisciplina());

            //3º Executa comando 
            stmt1.execute();
            //4º Fecha conexao
            stmt1.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    /**
     * Função que Exclui os dados do banco
     *
     * @param bibliografia
     * @exception SQLException
     */
    public void Excluir(Bibliografia bibliografia) throws SQLException{

        // 1º passo Criar a SQL
        String comando = "delete from rel_curso_disci where idCurso = ? and idDisciplina = ?";
        try ( //2º passo organizar o comando e executa-lo
                PreparedStatement stmt = conecta.prepareStatement(comando)) {
            stmt.setInt(1, bibliografia.getIdCurso());
            stmt.setInt(2, bibliografia.getIdDisciplina());
            //3º Executa comando
            stmt.execute();
            //4º Fecha conexao
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

        String comando2 = "delete from rel_livro_disci where idLivro = ? and idDisciplina = ?";
        try ( //2º passo organizar o comando e executa-lo
                PreparedStatement stmt1 = conecta.prepareStatement(comando2)) {
            stmt1.setInt(1, bibliografia.getIdLivro());
            stmt1.setInt(2, bibliografia.getIdDisciplina());
            //3º Executa comando
            stmt1.execute();
            //4º Fecha conexao
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    /**
     * 
     * @return List
     * @throws SQLException 
     */
    public List<Bibliografia> Listar() throws SQLException{

        try {
            List<Bibliografia> bibliografia = new ArrayList<>();
            String sql = "SELECT c.idCurso AS curso_id, c.nome AS Curso,d.idDisciplina As disc_id,d.nome AS Disciplina,l.id AS livro_id,l.titulo AS Livro \n"
                    + "from curso c, disciplina d, livro l, rel_curso_disci rcd, rel_livro_disci rld\n"
                    + "where c.idCurso = rcd.idCurso and d.idDisciplina = rcd.idDisciplina and d.idDisciplina = rld.idDisciplina and l.id = rld.idLivro";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            //3º Passo guardar o resultado dentro de um obj ResultSet
            ResultSet rs = stmt.executeQuery();
            //4º Enqualto tiver resultado guardar no registro da lista
            while (rs.next()) {
                Bibliografia b = new Bibliografia();
                b.setIdCurso(rs.getInt("curso_id"));
                b.setCurso(rs.getString("Curso"));
                b.setIdDisciplina(rs.getInt("disc_id"));
                b.setDisciplina(rs.getString("Disciplina"));
                b.setIdLivro(rs.getInt("livro_id"));
                b.setLivro(rs.getString("Livro"));

                bibliografia.add(b);
            }
            return bibliografia;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    
    public List<Bibliografia> Pesquisar(String nome) throws SQLException{
        try {
            List<Bibliografia> bibliografia;
            bibliografia = new ArrayList<>();
            String sql = "SELECT c.idCurso AS curso_id, c.nome AS Curso,d.idDisciplina As disc_id,d.nome AS Disciplina,l.id AS livro_id,l.titulo AS Livro \n"
                    + "from curso c, disciplina d, livro l, rel_curso_disci rcd, rel_livro_disci rld\n"
                    + "where c.idCurso = rcd.idCurso and d.idDisciplina = rcd.idDisciplina and d.idDisciplina = rld.idDisciplina and l.id = rld.idLivro"
                    + "and c.nome like %?%";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            //3º Passo guardar o resultado dentro de um obj ResultSet
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            //4º Enqualto tiver resultado guardar no registro da lista
            while (rs.next()) {
                Bibliografia b = new Bibliografia();
                b.setIdCurso(rs.getInt("curso_id"));
                b.setCurso(rs.getString("Curso"));
                b.setIdDisciplina(rs.getInt("disc_id"));
                b.setDisciplina(rs.getString("Disciplina"));
                b.setIdLivro(rs.getInt("livro_id"));
                b.setLivro(rs.getString("Livro"));

                bibliografia.add(b);
            }
           return bibliografia;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        }
    

}
