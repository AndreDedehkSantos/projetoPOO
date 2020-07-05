
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Corretor;

public class CorretorDAO extends DBController {
    public void salvar(Corretor corretor){
        abrirConexao();
        String inserirDados = "INSERT INTO corretor (nome, cpf, creci, corretora, ultimoAcesso)VALUES(?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            PreparedStatement pStatement = connection.prepareStatement(inserirDados);
            pStatement.setString(1, corretor.getNome());
            pStatement.setString(2, corretor.getCpf());
            pStatement.setString(3, corretor.getCreci());
            pStatement.setString(4, corretor.getCorretora());
            pStatement.setString(5, corretor.getUltimoAcesso());
            
            if(pStatement.execute()){
                connection.commit();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(CorretorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
    }
    
    public Corretor pesquisar(String cCpf){
        abrirConexao();
        String pesquisa = "SELECT cpf, nome, creci, corretora, ultimoAcesso FROM corretor WHERE cpf = " + "'" + cCpf + "'";
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(pesquisa);
            ResultSet rs = statement.executeQuery();
            if(rs == null){
                return null;
            }else{
                while(rs.next()){
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    String creci = rs.getString("creci");
                    String corretora = rs.getString("corretora");
                    String ultimoAcesso = rs.getString("ultimoAcesso");
                    Corretor corretor = new Corretor(creci, corretora, nome, cpf, ultimoAcesso);
                    return corretor;      
                }            
            }        
        } catch (SQLException ex) {
            Logger.getLogger(CorretorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
     public void alterar(Corretor corretor){
        abrirConexao();
         
        String alterarDados = "UPDATE corretor SET nome = '" + corretor.getNome()
                                + "', creci = '" + corretor.getCreci()
                                + "', corretora = '" + corretor.getCorretora()
                                + "', ultimoAcesso = '" + corretor.getUltimoAcesso()
                                + "' WHERE corretor.cpf = '"+ corretor.getCpf() + "'";
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(alterarDados);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PrestadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
     }
     
     public void excluir(String cpf){
        abrirConexao();
        String excluirUsuario = "DELETE FROM corretor WHERE (cpf = '" + cpf + "')";
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(excluirUsuario);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PrestadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
     }
}
