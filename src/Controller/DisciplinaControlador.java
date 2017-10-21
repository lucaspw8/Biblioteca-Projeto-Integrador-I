/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DisciplinaDAO;
import Model.Curso;
import Model.Disciplina;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jefferson
 */
public class DisciplinaControlador {

    private Disciplina disciplina = new Disciplina();
    private List<Disciplina> disciplinas;
    DisciplinaDAO DisciplinaDao = new DisciplinaDAO();
    Curso cursoObj = new Curso();

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void cadastrar() {
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.cadastrar(disciplina);
    }

    public void EditarDisciplina() {
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.atualizar(disciplina);
    }

    public void ExcluirLivro() {
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.Remover(disciplina);
    }

    public void listaDisciplina() {
        DisciplinaDAO dao = new DisciplinaDAO();
        disciplinas = dao.ListarDisciplina(disciplina);
    }

    public void PesquisarDisciplina(String texto) {
        DisciplinaDAO dao = new DisciplinaDAO();
        disciplinas = dao.Pesquisar(texto);
    }

    /**
     * Lista todas as disciplias cadastradas Usada pela view de Disciplinas e
     * outras
     *
     * @param tabela
     */
    public void atualizarTabela(JTable tabela) {

        listaDisciplina();

        List<Disciplina> DisciplinasEncontrados = getDisciplinas();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        modelo.setNumRows(0);

        for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
            modelo.insertRow(x, new String[]{
                String.valueOf(DisciplinasEncontrados.get(x).getIdDisciplina()),
                DisciplinasEncontrados.get(x).getNome(),});
        }

        tabela.setModel(modelo);
    }

    /**
     * Filtra os resultados pelo nome da disciplina Usada pela view de
     * Disciplinas
     *
     * @param tabela
     * @param pesquisa
     */
    public void atualizarTabela(JTable tabela, String pesquisa) {

        PesquisarDisciplina(pesquisa);

        List<Disciplina> DisciplinasEncontrados = getDisciplinas();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        modelo.setNumRows(0);

        for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
            modelo.insertRow(x, new String[]{
                String.valueOf(DisciplinasEncontrados.get(x).getIdDisciplina()),
                DisciplinasEncontrados.get(x).getNome()

            });
        }

        tabela.setModel(modelo);
    }

    /**
     * Lista as disciplinas pertencentes a um curso
     *
     * @param tabela
     * @param idCurso
     */
    public void atualizarTabela(JTable tabela, int idCurso) {

        DisciplinaDAO dao = new DisciplinaDAO();

        List<Disciplina> DisciplinasEncontrados = dao.RelCurso(idCurso);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        modelo.setNumRows(0);

        for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
            modelo.insertRow(x, new String[]{
                String.valueOf(DisciplinasEncontrados.get(x).getIdDisciplina()),
                DisciplinasEncontrados.get(x).getNome()

            });
        }

        tabela.setModel(modelo);
    }

    /**
     * Filtra as disciplinas pertencentes a um curso pelo nome Usada pela tela
     * de vizualizar Disciplina na view de Cursos
     *
     * @param tabela
     * @param idCurso
     * @param textoP
     */
    public void atualizarTabela(JTable tabela, int idCurso, String textoP) {

        DisciplinaDAO dao = new DisciplinaDAO();

        List<Disciplina> DisciplinasEncontrados = dao.Pesquisar(textoP, idCurso);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        modelo.setNumRows(0);

        for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
            modelo.insertRow(x, new String[]{
                String.valueOf(DisciplinasEncontrados.get(x).getIdDisciplina()),
                DisciplinasEncontrados.get(x).getNome()

            });
        }

        tabela.setModel(modelo);
    }

    public void DisciCombo(JComboBox curso, JComboBox disciplina) {
        try {
            if (curso.getItemCount() > 0) {

                if (curso.getSelectedIndex() != -1) {
                    this.cursoObj = (Curso) curso.getSelectedItem();

                    this.disciplinas = DisciplinaDao.RelCurso(cursoObj.getIdCurso());
                    
                    disciplina.setEnabled(true);
                    disciplina.removeAllItems();
                    this.disciplinas.forEach((b) -> {
                        disciplina.addItem(b);
                    });
                    disciplina.setSelectedIndex(-1);
                   
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void Associar(int idCurso, int idDisc) {
        try {
            DisciplinaDao.CursoDiscAss(idCurso, idDisc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void limpar(JTextField[] campos) {
        for (JTextField cp : campos) {
            cp.setText("");
        }
    }

    public boolean verificar() {

        return disciplina.getNome() == null;

    }

}
