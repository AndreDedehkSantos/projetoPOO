package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entregador;

public class EntregadorDAO extends DBController {
    public void salvar(Entregador entregador){
        abrirConexao();
        String inserirDados = "INSERT INTO entregador (nome, cpf, empresa, conteudo, ultimoAcesso, morador_cpf)VALUES(?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            PreparedStatement pStatement = connection.prepareStatement(inserirDados);
            pStatement.setString(1, entregador.getNome());
            pStatement.setString(2, entregador.getCpf());
            pStatement.setString(3, entregador.getEmpresa());
            pStatement.setString(4, entregador.getConteudo());
            pStatement.setString(5, entregador.getUltimoAcesso());
            pStatement.setString(6, entregador.getCpfMorador());
            
            if(pStatement.execute()){
                connection.commit();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EntregadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
    }
    
    public Entregador pesquisar(String eCpf){
        abrirConexao();
        String pesquisa = "SELECT cpf, nome, empresa, conteudo, ultimoAcesso, morador_cpf FROM entregador WHERE cpf = " + "'" + eCpf + "'";
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
                    String conteudo = rs.getString("conteudo");
                    String ultimoAcesso = rs.getString("ultimoAcesso");
                    String cpfMorador = rs.getString("morador_cpf");
                    Entregador entregador = new Entregador(empresa, conteudo, cpfMorador, nome, cpf, ultimoAcesso);
                    return entregador;       
                }            
            }        
        } catch (SQLException ex) {
            Logger.getLogger(EntregadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
     public void alterar(Entregador entregador){
        abrirConexao();
         
        String alterarDados = "UPDATE entregador SET nome = '" + entregador.getNome()
                                + "', empresa = '" + entregador.getEmpresa()
                                + "', conteudo = '" + entregador.getConteudo()
                                + "', ultimoAcesso = '" + entregador.getUltimoAcesso()
                                + "', morador_cpf = '" + entregador.getCpfMorador()
                                + "' WHERE entregador.cpf = '"+ entregador.getCpf() + "'";
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(alterarDados);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(EntregadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
     }
     
     public void excluir(String cpf){
        abrirConexao();
        String excluirUsuario = "DELETE FROM entregador WHERE (cpf = '" + cpf + "')";
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(excluirUsuario);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(EntregadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
     }
}
