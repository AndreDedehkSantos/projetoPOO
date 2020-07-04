package controller;

import java.sql.Date;
import javax.swing.JOptionPane;
import model.Corretor;

public class CorretorController {
    public static Corretor validarCorretor(String creci, String corretora, String nome, String cpf, boolean cadastrar, String ultimoAcesso){
        if(creci.equals("") || creci.length() != 6 || creci.matches("[A-Z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CRECI'");
            return null;
        }
        if(corretora.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'corretora'");
            return null;
        }
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Nome'");
            return null;
        }
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CFP'");
            return null;
        }
        if(cadastrar){
            /*ultimoAcesso = new Date.toString;
            Corretor existe = CorretorDAO.pesquisar(cpf);
            if(existe != null){
                JOptionPane.showMessageDialog(null, "Corretor já cadstrado");
                return null;
            }*/
        }
        return new Corretor(creci, corretora, nome, cpf, ultimoAcesso);
    }
    
    public static boolean definirCorretor(String creci, String corretora, String nome, String cpf){      
        Corretor corretor = validarCorretor(creci, corretora, nome, cpf, true, null);
        if(corretor != null){
            /*CorretorDAO.cadastrar(Corretor);
             JOptionPane.showMessageDialog(null, "Corretor cadastrado")*/
            return true;
        }
        return false; 
    }
    
    public static Corretor pesquisarCorretor(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CFP'");
            return null;
        }
        /*Corretor corretor = PrestadorDAO.consultar(cpf);
        if(corretor == null){
             JOptionPane.showMessageDialog(null, "Corretor não encontrado'");
             return null;
        }
        return corretor;*/
        return null;
    }
    
    public static boolean alterarCorretor(String creci, String corretora, String nome, String cpf, String ultimoAcesso){
        Corretor corretor = validarCorretor(creci, corretora, nome, cpf, false, ultimoAcesso);
        if(corretor != null){
            /*boolean alterado = CorretorDAO.alterar(corretor);
            if(alterado){
                JOptionPane.showMessageDialog(null, "Corretor alterado");
                return true;
            }*/
        }
        JOptionPane.showMessageDialog(null, "Corretor não encontrado");
        return false;      
    }
    
    public static boolean excluirCorretor(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CFP'");
            return false;
        }
        /*boolean excluido = Corretor corretor = CorretorDAO.excluir(cpf);
        if(excluido){
            JOptionPane.showMessageDialog(null, "Corretor excluido");
            return true;
        }*/
        JOptionPane.showMessageDialog(null, "Corretor não encontrado");
        return false;
    }
}
