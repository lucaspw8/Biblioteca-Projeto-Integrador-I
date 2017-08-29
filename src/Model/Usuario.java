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
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "login", unique = true, nullable = false, length = 30)
    private String login;
   
    @Column(name = "senha", nullable = false, length = 30)
    private String senha;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
     @Column(name = "email", length = 50)
    private String email;
    @Column(name = "cargo", nullable = false, length = 30)
    private String cargo;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
