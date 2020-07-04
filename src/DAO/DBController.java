package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBController {
    protected final String caminhoDB = "jdbc:mysql://localhost:3306/condominio?serverTimezone=UTC";
    
    protected final String usarname = "root";
    
    protected final String password = "root";
    
    protected Connection connection;
    
    protected void abrirConexao(){
        try {
            connection = DriverManager.getConnection(caminhoDB, usarname, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecharConexao(){
        if(connection != null){
            try {
                if(!connection.getAutoCommit()){
                    connection.setAutoCommit(true);
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
