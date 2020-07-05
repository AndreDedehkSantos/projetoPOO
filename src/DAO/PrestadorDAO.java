
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Prestador;

public class PrestadorDAO extends DBController {
    public void salvar(Prestador prestador){
        abrirConexao();
        String inserirDados = "INSERT INTO prestador (nome, cpf, empresa, categoria, ultimoAcesso, morador_cpf)VALUES(?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            PreparedStatement pStatement = connection.prepareStatement(inserirDados);
            pStatement.setString(1, prestador.getNome());
            pStatement.setString(2, prestador.getCpf());
            pStatement.setString(3, prestador.getEmpresa());
            pStatement.setString(4, prestador.getCategoria());
            pStatement.setString(5, prestador.getUltimoAcesso());
            pStatement.setString(6, prestador.getCpfMorador());
            
            if(pStatement.execute()){
                connection.commit();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(PrestadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
    }
    
    public Prestador pesquisar(String pCpf){
        abrirConexao();
        String pesquisa = "SELECT cpf, nome, empresa, categoria, ultimoAcesso, morador_cpf FROM prestador WHERE cpf = " + "'" + pCpf + "'";
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
                    String empresa = rs.getString("empresa");
                    String categoria = rs.getString("categoria");
                    String ultimoAcesso = rs.getString("ultimoAcesso");
                    String cpfMorador = rs.getString("morador_cpf");
                    Prestador prestador = new Prestador(categoria, empresa, cpfMorador, nome, cpf, ultimoAcesso);
                    return prestador;       
                }            
            }        
        } catch (SQLException ex) {
            Logger.getLogger(PrestadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
     public void alterar(Prestador prestador){
        abrirConexao();
         
        String alterarDados = "UPDATE prestador SET nome = '" + prestador.getNome()
                                + "', empresa = '" + prestador.getEmpresa()
                                + "', categoria = '" + prestador.getCategoria()
                                + "', ultimoAcesso = '" + prestador.getUltimoAcesso()
                                + "', morador_cpf = '" + prestador.getCpfMorador()
                                + "' WHERE prestador.cpf = '"+ prestador.getCpf() + "'";
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
        String excluirUsuario = "DELETE FROM prestador WHERE (cpf = '" + cpf + "')";
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
