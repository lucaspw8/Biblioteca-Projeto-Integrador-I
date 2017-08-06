/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.com.comercio.modelos.Disciplina;
import java.util.List;
import javax.swing.JTextField;

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

   
    
    public boolean verificar(){
        if(disciplina!=null){
            return disciplina.getNome().length()>3;    
        }
        return false;
    }
    
    public Disciplina cadastrar(){
        disciplina.setNome(disciplina.getNome());
        disciplina.setSemestre(disciplina.getSemestre());
        return disciplina;
    }
    
    public void limpar(JTextField[] campos){
        for (JTextField cp : campos){
            cp.setText("");
        }
    }
    
}
