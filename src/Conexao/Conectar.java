/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class Conectar {
    
    public Connection conecta(){
        
        try {
            
           return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/integrador","root","");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Conectar " +e);
        }
    }
    
}