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
     * Função que Exclui os dados do banco
     *
     * @param id_curso
     * @param id_disc
     * @exception SQLException
     */
    public void Excluir(int id_curso, int id_disc) throws SQLException{

        // 1º passo Criar a SQL
        String comando = "delete from rel_curso_disci where idCurso = ? and idDisciplina = ?";
        try ( //2º passo organizar o comando e executa-lo
                PreparedStatement stmt = conecta.prepareStatement(comando)) {
            stmt.setInt(1, id_curso);
            stmt.setInt(2, id_disc);
            //3º Executa comando
            stmt.execute();
            //4º Fecha conexao
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

        String comando2 = "delete from rel_livro_disci where idLivro = ? and idDisciplina = ?";
        try ( //2º passo organizar o comando e executa-lo
                PreparedStatement stmt1 = conecta.prepareStatement(comando2)) {

            //3º Executa comando
            stmt1.execute();
            //4º Fecha conexao
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    /**
     * 
     * @param id_curso
     * @return List
     * @throws SQLException 
     */
    public List<Bibliografia> Listar(int id_curso) throws SQLException{

        try {
            List<Bibliografia> bibliografia = new ArrayList<>();
            String sql = "SELECT * FROM bibliografia WHERE idCurso = ? ";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, id_curso);
            //3º Passo guardar o resultado dentro de um obj ResultSet
            ResultSet rs = stmt.executeQuery();
            //4º Enqualto tiver resultado guardar no registro da lista
            while (rs.next()) {
                Bibliografia b = new Bibliografia();
                b.setDisciplina(rs.getString(1));
                b.setLivro(rs.getString(2));
                b.setQtd(rs.getInt(3));
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
            String sql = "SELECT * FROM bibliografia WHERE like %?%";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            //3º Passo guardar o resultado dentro de um obj ResultSet
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            //4º Enqualto tiver resultado guardar no registro da lista
            while (rs.next()) {
                Bibliografia b = new Bibliografia();
                b.setDisciplina(rs.getString(0));
                b.setLivro(rs.getString(1));
                b.setQtd(rs.getInt(2));
                bibliografia.add(b);
            }
           return bibliografia;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        }
    

}
