package controller;

import DAO.CorretorDAO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Corretor;

public class CorretorController {
    static CorretorDAO cDao = new CorretorDAO();
    public static Corretor validarCorretor(String creci, String corretora, String nome, String cpf){
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
        Corretor existe = cDao.pesquisar(cpf);
        if(existe != null){
            JOptionPane.showMessageDialog(null, "Corretor já cadstrado");
            return null;
        }
        
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = formato.format(agora);
        
        return new Corretor(creci, corretora, nome, cpf, data);
    }
    
     public static Corretor validarCorretor(String creci, String corretora, String nome, String cpf, String ultimoAcesso){
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
        return new Corretor(creci, corretora, nome, cpf, ultimoAcesso);
    }
    
    public static void definirCorretor(String creci, String corretora, String nome, String cpf){      
        Corretor corretor = validarCorretor(creci, corretora, nome, cpf);
        if(corretor != null){
            cDao.salvar(corretor);
            JOptionPane.showMessageDialog(null, "Corretor cadastrado");
        }
    }
    
    public static Corretor pesquisarCorretor(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CFP'");
            return null;
        }
        Corretor corretor = cDao.pesquisar(cpf);
        if(corretor == null){
             JOptionPane.showMessageDialog(null, "Corretor não encontrado'");
             return null;
        }else{
            return corretor;
        }
    }
    
    public static void alterarCorretor(String creci, String corretora, String nome, String cpf, String ultimoAcesso){
        Corretor corretor = validarCorretor(creci, corretora, nome, cpf, ultimoAcesso);
        if(corretor != null){
            cDao.alterar(corretor);
            JOptionPane.showMessageDialog(null, "Corretor alterado");
        }
    }
    
    public static void excluirCorretor(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CFP'");
        }else{
             cDao.excluir(cpf);
             JOptionPane.showMessageDialog(null, "Corretor excluido");
        }
    }
}
