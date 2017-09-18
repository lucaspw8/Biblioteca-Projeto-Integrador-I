/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import DAO.CursoDAO;
import DAO.DisciplinaDAO;
import Model.Curso;
import Model.Disciplina;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class SalvaCurso {
    public static void main(String[] args) {
        CursoDAO Cdao = new CursoDAO();
        DisciplinaDAO Ddao= new DisciplinaDAO();
        Curso curso = new Curso();
        curso.setCoordenador("Renato");
        curso.setNome("Sistemas de Informação");
        
        Disciplina disc = new Disciplina();
        disc.setNome("Programação2");
        disc.setSemestre("3º");
        Ddao.cadastrar(disc);
        curso.getDisciplinas().add(disc);
        Cdao.cadastrar(curso);
        
        
        
        List<Disciplina> cursos = new ArrayList<>();
              cursos =  curso.getDisciplinas().subList(0, 0);
              
              System.out.println("Nome "+cursos.toString());
    }
}
