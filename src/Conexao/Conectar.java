package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
        private final String DATABASE = "integrador";
        private final String PORT = "3306";
        private final String USER = "root";
        private final String PASSWORD = "";
        private final String DRIVER = "jdbc:mysql";
        private final String ADDRESS = "127.0.0.1";
        private final String URL =this.DRIVER+"://"+this.ADDRESS+":"+this.PORT+"/"+this.DATABASE;
        
    public Connection conecta(){

        try {
            
            
           return DriverManager.getConnection(this.URL,this.USER,this.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Conectar " +e);
        }
    }
    
}