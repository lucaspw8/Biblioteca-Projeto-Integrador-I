/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jefferson
 */


@Entity
public class Disciplina implements Serializable{
    
    @Id
    @GeneratedValue
    private int idDisciplina;
    @Column(name = "nome", nullable = false, length = 0)
    private String nome;
    @Column(name = "semestre", nullable = false, length = 2)
    private String semestre;
    //@ManyToMany(mappedBy = "disciplinas", cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "rel_disc_cursos",
            joinColumns = {@JoinColumn(name = "idDisciplina")},
            inverseJoinColumns ={@JoinColumn(name = "idCurso")})
    List<Curso> cursos = new ArrayList<Curso>();

    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        return true;
    }
    
    
}
