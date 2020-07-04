
package DAO;

import entidades.enums.TipoVisitante;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Morador;
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
    
    public Visitante pesquisar(String mCpf){
        abrirConexao();
        String pesquisa = "SELECT cpf, nome, tipo, ultimoAcesso, morador_cpf FROM visitante WHERE cpf = " + "'" + mCpf + "'";
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
                    String t = rs.getString("tipo");
                    String ultimoAcesso = rs.getString("ultimoAcesso");
                    String cpfMorador = rs.getString("morador_cpf");
                    TipoVisitante tipo = null;
                    switch(t){
                        case("PARENTE"):
                            tipo = TipoVisitante.PARENTE;
                            break;
                        case("AMIGO"):
                            tipo = TipoVisitante.AMIGO;
                            break;
                        case("PARCEIRO"):
                            tipo = TipoVisitante.PARCEIRO;
                            break;
                        case("OUTRO"):
                            tipo = TipoVisitante.OUTRO;
                            break;
                        default:
                            break;
                    }
                    
                    Visitante visitante = new Visitante(cpfMorador, tipo, nome, cpf, ultimoAcesso);
                    return visitante;       
                }            
            }        
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
     public void alterar(Visitante visitante){
        abrirConexao();
         
        String alterarDados = "UPDATE visitante SET nome = '" + visitante.getNome()
                                + "', tipo = '" + visitante.getTipo().toString()
                                + "', ultimoAcesso = '" + visitante.getUltimoAcesso()
                                + "', morador_cpf = '" + visitante.getMorador()
                                + "' WHERE visitante.cpf = '"+ visitante.getCpf() + "'";
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
        String excluirUsuario = "DELETE FROM visitante WHERE (cpf = '" + cpf + "')";
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
