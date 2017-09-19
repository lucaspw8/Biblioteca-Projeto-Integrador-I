/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DisciplinaDAO;
import Model.Disciplina;
import java.util.List;
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

    
    public void cadastrar(){
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.cadastrar(disciplina);
    }
    
      public void EditarDisciplina(){
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.atualizar(disciplina);
    }
      
     
     public void ExcluirLivro(){
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.Remover(disciplina);
    }
    
    
     public void listaDisciplina(){
      DisciplinaDAO dao = new DisciplinaDAO();
      disciplinas = dao.ListarDisciplina(disciplina);
    }
     
     public void PesquisarDisciplina(String texto){
      DisciplinaDAO dao = new DisciplinaDAO();
      disciplinas= dao.Pesquisar(texto);
    }
     
     public void atualizarTabela(JTable tabela) {
        
        
            listaDisciplina();

            List<Disciplina> DisciplinasEncontrados = getDisciplinas();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            
            modelo.setNumRows(0);

            for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
                modelo.insertRow(x,new String[]{
                            String.valueOf(DisciplinasEncontrados.get(x).getIdDisciplina()),
                            DisciplinasEncontrados.get(x).getNome(),
                            DisciplinasEncontrados.get(x).getSemestre()
                            
                         });
            }

            tabela.setModel(modelo);
        }
     
     public void atualizarTabela(JTable tabela, String pesquisa) {
        
        
            PesquisarDisciplina(pesquisa);

            List<Disciplina> DisciplinasEncontrados = getDisciplinas();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            
            modelo.setNumRows(0);

            for (int x = 0; x < DisciplinasEncontrados.size(); x++) {
                modelo.insertRow(x,new String[]{
                            String.valueOf(DisciplinasEncontrados.get(x).getIdDisciplina()),
                            DisciplinasEncontrados.get(x).getNome(),
                            DisciplinasEncontrados.get(x).getSemestre()
                            
                         });
            }

            tabela.setModel(modelo);
        }
    
    public void limpar(JTextField[] campos){
        for (JTextField cp : campos){
            cp.setText("");
        }
    }
    
}
