/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    private Disciplina disciplina;
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
    
    
    
}
