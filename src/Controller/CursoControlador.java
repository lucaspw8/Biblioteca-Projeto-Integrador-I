/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.com.comercio.dao.CursoDAO;
import br.com.comercio.modelos.Curso;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jefferson
 */
public class CursoControlador {
    
    private Curso curso = new Curso();
    private List<Curso> cursos;

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public boolean verificar(){
        if(curso!=null){
            return curso.getNome().length()>3
                    && curso.getCoordenador().length()>4;    
        }
        return false;
    }
    
    public Curso cadastrar(){
        curso.setIdCurso(curso.getIdCurso());
        curso.setNome(curso.getNome());
        curso.setCoordenador(curso.getCoordenador());
        return curso;
    }
    
    public void pesquisar(){
        CursoDAO cursoDAO = new CursoDAO();
        cursos = cursoDAO.pesquisar(curso);
    }
    
    public void atualizarTabela(JTable tabela) {
        
        if (getCurso().getNome() == null) {
            JOptionPane.showMessageDialog(null, "É necessário informar um nome.");
        } else {
            pesquisar();

            List<Curso> cursosEncontrados = getCursos();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            
            modelo.setNumRows(0);

            for (int x = 0; x < cursosEncontrados.size(); x++) {
                modelo.insertRow(
                        x,new String[]{
                            String.valueOf(cursosEncontrados.get(x).getIdCurso()),
                            cursosEncontrados.get(x).getNome(),
                            cursosEncontrados.get(x).getCoordenador()
                        });
            }

            tabela.setModel(modelo);
        }
    }
    
    public void limpar(JTextField[] campos){
        for (JTextField cp : campos){
            cp.setText("");
        }
    }
    
}
