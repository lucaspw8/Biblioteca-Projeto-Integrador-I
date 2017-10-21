package Controller;

import DAO.BibliografiaDAO;
import DAO.DisciplinaDAO;
import Model.Bibliografia;
import Model.Curso;
import Model.Disciplina;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class BibliografiaControlador {

    private Bibliografia bibliografia = new Bibliografia();
    BibliografiaDAO bibliografiaDAO = new BibliografiaDAO();
    private List<Bibliografia> bibliografias;
    DisciplinaDAO DisciplinaDao = new DisciplinaDAO();
    Curso cursoObj = new Curso();
    Disciplina discObj = new Disciplina();

    public Bibliografia getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(Bibliografia bibliografia) {
        this.bibliografia = bibliografia;
    }

    public List<Bibliografia> getBibliografias() {
        return bibliografias;
    }

    public void setBibliografias(List<Bibliografia> bibliografias) {
        this.bibliografias = bibliografias;
    }

    /**
     * Chama a função de listar do DAO
     * @param id_curso
     */
    public void Listar(int id_curso) {
        try {
            setBibliografias(bibliografiaDAO.Listar(id_curso));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public void Listar(int id_curso,String pesquisa) {
        try {
            setBibliografias(bibliografiaDAO.Pesquisar(id_curso,pesquisa));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Lista a bibliografia pelo curso
     * @param tabela
     * @param bibliografiaCurso 
     */
    public void atualizarTabela(JTable tabela, JComboBox bibliografiaCurso) {
        
        try {
            if (bibliografiaCurso.getItemCount() > 0) {

                if (bibliografiaCurso.getSelectedIndex() != -1) {
                    this.cursoObj = (Curso) bibliografiaCurso.getSelectedItem();
                     Listar(this.cursoObj.getIdCurso());
                    
                    List<Bibliografia> bibliEncontradas = getBibliografias();
                    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

                    modelo.setNumRows(0);

                    for (int x = 0; x < bibliEncontradas.size(); x++) {
                        modelo.insertRow(
                                x, new String[]{
                                    bibliEncontradas.get(x).getDisciplina(),
                                    bibliEncontradas.get(x).getLivro(),
                                    String.valueOf(bibliEncontradas.get(x).getQtd()),   
                                });
                    }
                   
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione um curso para vê sua bibliografia!!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Não há cursos cadastrados!!");
            }
        }
        catch (HeadlessException e) {
            throw new RuntimeException(e);
        }
  
    }
  /**
   * Filtra a bibliografia pelo noma da Disciplina
   * @param tabela
   * @param bibliografiaCurso
   * @param pesquisa 
   */
   public void atualizarTabela(JTable tabela, JComboBox bibliografiaCurso,String pesquisa) {
        
        try {
            if (bibliografiaCurso.getItemCount() > 0) {

                if (bibliografiaCurso.getSelectedIndex() != -1) {
                    this.cursoObj = (Curso) bibliografiaCurso.getSelectedItem();
                     Listar(this.cursoObj.getIdCurso(),pesquisa);
                    
                    List<Bibliografia> bibliEncontradas = getBibliografias();
                    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

                    modelo.setNumRows(0);

                    for (int x = 0; x < bibliEncontradas.size(); x++) {
                        modelo.insertRow(
                                x, new String[]{
                                    bibliEncontradas.get(x).getDisciplina(),
                                    bibliEncontradas.get(x).getLivro(),
                                    String.valueOf(bibliEncontradas.get(x).getQtd()),   
                                });
                    }
                   
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione um curso para vê sua bibliografia!!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Não há cursos cadastrados!!");
            }
        }
        catch (HeadlessException e) {
            throw new RuntimeException(e);
        }

    }

    public void Remover(JComboBox curso, JComboBox disciplina) {
        try {
            
            if (curso.getItemCount() > 0 && disciplina.getItemCount() > 0) {

                if (curso.getSelectedIndex() != -1 && disciplina.getSelectedIndex() != -1 ) {
                    this.cursoObj = (Curso) curso.getSelectedItem();
                    this.discObj = (Disciplina) disciplina.getSelectedItem();
                    
                    bibliografiaDAO.Excluir(this.cursoObj.getIdCurso(), this.discObj.getIdDisciplina());
                   
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione um curso e uma disciplina para remover!!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Não há cursos ou disciplinas cadastradas!!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
