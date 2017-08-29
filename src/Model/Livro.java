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
import javax.persistence.Id;

/**
 *
 * @author Lucas
 */
@Entity
public class Livro implements Serializable{
    @Id
    @GeneratedValue
    private int id;
         @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
         @Column(name = "autor", nullable = false, length = 50)
    private String autor;
         @Column(name = "quantidade", nullable = true, length = 5)
    private int quantidade;
         @Column(name = "disponivel", nullable = false, length = 30)
    private String disponivel;
         @Column(name = "editora", nullable = false, length = 50)
    private String editora;
         @Column(name = "ano", nullable = false, length = 4)
    private int ano;
           @Column(name = "edicao", nullable = false, length = 10)
    private String edicao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    
    
}
