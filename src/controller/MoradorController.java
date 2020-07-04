package controller;

import DAO.MoradorDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Morador;


public class MoradorController {
    
    public static Morador validarMorador(String nome, String cpf, int apartamento, int torre, String telefone){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Nome'");
            return null;
        }
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]") || cpf.matches("[a - z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        if(apartamento == 0){
            JOptionPane.showMessageDialog(null, "Rever 'Apartamento'");
            return null;
        }
        if(torre == 0){
            JOptionPane.showMessageDialog(null, "Rever 'Torre'");
            return null;
        }
        if(telefone.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Telefone'");
            return null;
        }
        MoradorDAO mDAO = new MoradorDAO();
        Morador existe = mDAO.pesquisar(cpf);
        if(existe != null){
            JOptionPane.showMessageDialog(null, "Morador já cadstrado");
            return null;
        }
        Date agora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = formato.format(agora);
        return new Morador(torre, apartamento, telefone, nome, cpf, data);
    }
    public static Morador validarMorador(String cpf, String nome, int apartamento, int torre, String telefone, String ultimoAcesso){
         if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Nome'");
            return null;
        }
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]") || cpf.matches("[a - z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        
        if(apartamento == 0){
            JOptionPane.showMessageDialog(null, "Rever 'Apartamento'");
            return null;
        }
        if(torre == 0){
            JOptionPane.showMessageDialog(null, "Rever 'Torre'");
            return null;
        }
        if(telefone.equals("")){
            JOptionPane.showMessageDialog(null, "Rever 'Telefone'");
            return null;
        }    
        MoradorDAO mDAO = new MoradorDAO();
        Morador existe = mDAO.pesquisar(cpf);
        if(existe == null){
            JOptionPane.showMessageDialog(null, "Morador não encontrado");
            return null;
        }      
        return new Morador(torre, apartamento, telefone, nome, cpf, ultimoAcesso);
    }   
    
    
    public static boolean definirMorador(String nome, String cpf, int apartamento, int torre, String telefone){
        
        Morador morador = validarMorador(nome, cpf, apartamento, torre, telefone);
        if (morador != null) {
            MoradorDAO mDAO = new MoradorDAO();
            mDAO.salvar(morador);
            JOptionPane.showMessageDialog(null, "Morador cadastrado");
            return true;
        }
        return false;
    }
    
    public static Morador pesquisarMorador(String cpf){
        if (cpf.equals("") || cpf.length() != 11) {
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        MoradorDAO mDAO = new MoradorDAO();
        Morador morador = mDAO.pesquisar(cpf);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "Morador não encontrado");
            return null;
          }
        return morador;
    }
    
    public static void alterarMorador(String cpf, String nome, int apartamento, int torre, String telefone, String ultimoAcesso){ 
        Morador morador = validarMorador(cpf, nome, apartamento, torre, telefone, ultimoAcesso);
        if (morador != null){
            MoradorDAO mDAO = new MoradorDAO();
            mDAO.alterar(morador);
            JOptionPane.showMessageDialog(null, "Morador alterado");
        }else{
            JOptionPane.showMessageDialog(null, "Morador não encontrado");
        }
    }
    
    public static void excluirMorador(String cpf){
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]") || cpf.matches("[a - z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
        }
        Morador morador = pesquisarMorador(cpf);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "Morador não encontrado");
        }else{
            MoradorDAO mDAO =new MoradorDAO();
            mDAO.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Morador Excluido!");
        }
    }
}
