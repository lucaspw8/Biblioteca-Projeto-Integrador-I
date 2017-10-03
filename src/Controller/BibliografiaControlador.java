package Controller;

import DAO.BibliografiaDAO;
import Model.Bibliografia;
import java.sql.SQLException;
import java.util.List;
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

    public void cadastrar() {

        bibliografiaDAO.cadastrar(bibliografia);

    }

    /**
     * Chama a função de listar do DAO
     */
    public void Listar() {
        try {
            bibliografias = bibliografiaDAO.Listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizarTabela(JTable tabela) {
        Listar();

        List<Bibliografia> bibliEncontradas = getBibliografias();
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        modelo.setNumRows(0);

        for (int x = 0; x < bibliEncontradas.size(); x++) {
            modelo.insertRow(
                    x, new String[]{
                        String.valueOf(bibliEncontradas.get(x).getIdCurso()),
                        bibliEncontradas.get(x).getCurso(),
                        String.valueOf(bibliEncontradas.get(x).getIdDisciplina()),
                        bibliEncontradas.get(x).getDisciplina(),
                        String.valueOf(bibliEncontradas.get(x).getIdLivro()),
                        bibliEncontradas.get(x).getLivro()
                    });
        }
    }

    public void atualizarTabela(JTable tabela, String nome) {
        
        try {
            bibliografias = bibliografiaDAO.Pesquisar(nome);
            List<Bibliografia> bibliEncontradas = getBibliografias();
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

            modelo.setNumRows(0);

            for (int x = 0; x < bibliEncontradas.size(); x++) {
                modelo.insertRow(
                        x, new String[]{
                            String.valueOf(bibliEncontradas.get(x).getIdCurso()),
                            bibliEncontradas.get(x).getCurso(),
                            String.valueOf(bibliEncontradas.get(x).getIdDisciplina()),
                            bibliEncontradas.get(x).getDisciplina(),
                            String.valueOf(bibliEncontradas.get(x).getIdLivro()),
                            bibliEncontradas.get(x).getLivro()
                        });
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Remover() {
        try {
            bibliografiaDAO.Excluir(bibliografia);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
