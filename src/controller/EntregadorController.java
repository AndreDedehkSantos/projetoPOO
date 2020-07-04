package controller;

import java.sql.Date;
import javax.swing.JOptionPane;
import model.Entregador;
import model.Morador;

public class EntregadorController {
     public static Entregador validarEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf, boolean cadastrar, String ultimoAcesso){
        Morador morador = MoradorController.pesquisarMorador(cpfMorador);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "Rever 'CPF do Morador'");
            return null;
        }
        if(empresa.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Empresa'");
            return null;
        }
        if(conteudo.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Conteúdo'");
            return null;
        }
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Nome'");
            return null;
        }
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[a-z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        if(cadastrar){
            /*Entregador existe = entregadorDAO.pesquisar(cpf);
            if(existe != null){
                JOptionPane.showMessageDialog(null, "Entregador já cadstrado");
                return null;
            }*/
        }
        return new Entregador(empresa, conteudo, nome, cpf, cpfMorador, ultimoAcesso);
    }
     
      
    public static boolean definirEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf){     
        Entregador entregador = validarEntregador(cpfMorador, empresa, conteudo, nome, cpf, true, null);
        if(entregador != null){
            /*EntregadorDAO.cadastrar(Entregador);
            JOptionPane.showMessageDialog(null, "Entregador cadastrado")*/
            return true;
        }
        return false;
    }
    
    public static Entregador pesquisarEntregador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        /*Entregador entregador = EntregadorDAO.consultar(cpf);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "'Entregador não encontrado'");
            return null;
        }
        return entregador;*/
        return null;
    }
    
    public static boolean alterarEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf, String ultimoAcesso){ 
        Entregador entregador = validarEntregador(cpfMorador, empresa, conteudo, nome, cpf, false, ultimoAcesso);
        if(entregador != null){
             /*boolean alterado = EntregadorDAO.alterar(entregador);
            if(alterado){
                JOptionPane.showMessageDialog(null, "Entregador alterado");
                return true;
            }*/
            JOptionPane.showMessageDialog(null, "Entregador não encontrado");
            return false;     
        }
        return true;
    }
 
    public static boolean excluirEntregador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return false;
        }
        /*boolean excluido = EntregadorDAO.excluir(cpf);
        if(excluido){
            JOptionPane.showMessageDialog(null, "Entregador excluido");
            return true;
        }*/
        JOptionPane.showMessageDialog(null, "Entregador não encontrado");
        return false;
    }
}
