
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Visitante;

public class VisitanteDAO extends DBController{
    public void salvar(Visitante visitante){
        abrirConexao();
        String inserirDados = "INSERT INTO visitante (nome, cpf, tipo, ultimoAcesso, morador_cpf)VALUES(?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            PreparedStatement pStatement = connection.prepareStatement(inserirDados);
            pStatement.setString(1, visitante.getNome());
            pStatement.setString(2, visitante.getCpf());
            pStatement.setString(3, visitante.getTipo().toString());
            pStatement.setString(4, visitante.getUltimoAcesso());
            pStatement.setString(5, visitante.getMorador());
            
            if(pStatement.execute()){
                connection.commit();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
    }
}
