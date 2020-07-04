package controller;

import java.sql.Date;
import javax.swing.JOptionPane;
import model.Morador;
import model.Prestador;

public class PrestadorController {
     public static Prestador validarPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf, boolean cadastrar, String ultimoAcesso){
        Morador morador = MoradorController.pesquisarMorador(cpfMorador);
        if(morador == null){
           JOptionPane.showMessageDialog(null, "Rever 'CPF do morador'");
           return null;
        }
        if(categoria.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Categoria'");
            return null;
        }
        if(empresa.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Empresa'");
            return null;
        }
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Nome'");
            return null;
        }
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        if(cadastrar){
            /*Prestador existe = prestadorDAO.pesquisar(cpf);
            if(existe != null){
                JOptionPane.showMessageDialog(null, "Prestador já cadstrado");
                return null;
            }*/
        }
       
        return new Prestador(categoria, empresa, cpfMorador, nome, cpf, ultimoAcesso);
    }
     
    public static boolean definirPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf){     
        Prestador prestador = validarPrestador(categoria, empresa, cpfMorador, nome, cpf, true, null);
        if(prestador != null){
            /*PrestadorDAO.cadastrar(Prestador);
            JOptionPane.showMessageDialog(null, "Prestador cadastrado")*/
            return true;
        }
        return false;
    }
   
    public static Prestador pesquisarPrestador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        /*Prestador prestador = PrestadorDAO.consultar(cpf);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "Prestador não encontrado'");
            return null;
        }
        return prestador;*/
        return null;
    }
   
    public static boolean alterarPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf, String ultimoAcesso){    
        Prestador prestador = validarPrestador(categoria, empresa, cpfMorador, nome, cpf, false, ultimoAcesso);
        if(prestador != null){
            /*boolean alterado = PrestadorDAO.alterar(prestador);
            if(alterado){
                JOptionPane.showMessageDialog(null, "Prestador alterado");
                return true;
            }*/
        }
        JOptionPane.showMessageDialog(null, "Prestador não encontrado");
        return false;  
    }
   
    public static boolean excluirPrestador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return false;
        }
        /*boolean excluido = Prestador prestador = PrestadorDAO.excluir(cpf);
        if(excluido){
            JOptionPane.showMessageDialog(null, "Prestador excluido");
            return true;
        }*/
        return false;
    }
}
