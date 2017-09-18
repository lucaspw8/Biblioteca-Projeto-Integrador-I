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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jefferson
 */
@Entity
public class Curso implements Serializable{
    
    //Irá identificar a tabela para o hibernate
    @Id
    //GeneratedValue diz que o campo Id, será auto_increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCurso;
   
    private String nome;
    @Column(name = "coordenador", nullable = false, length = 50)
    private String coordenador;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "rel_disc_cursos",
            joinColumns = {@JoinColumn(name = "idCurso")},
            inverseJoinColumns ={@JoinColumn(name = "idDisciplina")})
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idCurso;
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
        final Curso other = (Curso) obj;
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }
    
    
    
    
}
