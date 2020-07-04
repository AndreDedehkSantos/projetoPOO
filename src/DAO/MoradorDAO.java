package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Morador;

public class MoradorDAO extends DBController{
    
    public void salvar(Morador morador){
        abrirConexao();
        String inserirDados = "INSERT INTO morador (nome, cpf, torre, apartamento, telefone, ultimoAcesso)VALUES(?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            PreparedStatement pStatement = connection.prepareStatement(inserirDados);
            pStatement.setString(1, morador.getNome());
            pStatement.setString(2, morador.getCpf());
            pStatement.setInt(3, morador.getTorre());
            pStatement.setInt(4, morador.getApartamento());
            pStatement.setString(5, morador.getTelefone());
            pStatement.setString(6, morador.getUltimoAcesso());
            
            if(pStatement.execute()){
                connection.commit();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
    }
    
    public Morador pesquisar(String mCpf){
        abrirConexao();
        String pesquisa = "SELECT cpf, nome, torre, apartamento, telefone, ultimoAcesso FROM morador WHERE cpf = " + "'" + mCpf + "'";
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
                    int torre = rs.getInt("torre");
                    int apartamento = rs.getInt("apartamento");
                    String telefone = rs.getString("telefone");
                    String ultimoAcesso = rs.getString("ultimoAcesso");
                    Morador morador = new Morador(torre, apartamento, telefone, nome, cpf, ultimoAcesso);
                    return morador;       
                }            
            }        
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
     public void alterar(Morador morador){
        abrirConexao();
         
        String alterarDados = "UPDATE morador SET nome = '" + morador.getNome() + "', torre = " + morador.getTorre()
                                + ", apartamento = " + morador.getApartamento() + " , telefone = '" + morador.getTelefone()
                                + "', ultimoAcesso = '" + morador.getUltimoAcesso() + "'"
                                + " WHERE morador.cpf = '"+ morador.getCpf() + "'";
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(alterarDados);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
     }
     
     public void excluir(String cpf){
        abrirConexao();
        String excluirUsuario = "DELETE FROM morador WHERE (cpf = '" + cpf + "')";
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(excluirUsuario);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
     }
}
