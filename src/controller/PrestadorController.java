package controller;

import DAO.PrestadorDAO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Morador;
import model.Prestador;

public class PrestadorController {
    static PrestadorDAO pDao = new PrestadorDAO();
     public static Prestador validarPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf){
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
        Prestador existe = pDao.pesquisar(cpf);
        if(existe != null){
            JOptionPane.showMessageDialog(null, "Prestador já cadstrado");
            return null;
        }
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = formato.format(agora);
       
        return new Prestador(categoria, empresa, cpfMorador, nome, cpf, data);
    }
     
    public static Prestador validarPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf, String ultimoAcesso){
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
        return new Prestador(categoria, empresa, cpfMorador, nome, cpf, ultimoAcesso);
    }
     
    public static void definirPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf){     
        Prestador prestador = validarPrestador(categoria, empresa, cpfMorador, nome, cpf);
        if(prestador != null){
            pDao.salvar(prestador);
            JOptionPane.showMessageDialog(null, "Prestador cadastrado");
        }
    }
   
    public static Prestador pesquisarPrestador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        Prestador prestador = pDao.pesquisar(cpf);
        if(prestador == null){
            JOptionPane.showMessageDialog(null, "Prestador não encontrado'");
            return null;
        }else{
            return prestador;
        }
    }
   
    public static void alterarPrestador(String categoria, String empresa, String cpfMorador, String nome, String cpf, String ultimoAcesso){    
        Prestador prestador = validarPrestador(categoria, empresa, cpfMorador, nome, cpf, ultimoAcesso);
        if(prestador != null){
            pDao.alterar(prestador);
            JOptionPane.showMessageDialog(null, "Prestador alterado");
        }
    }
   
    public static void excluirPrestador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
        }else{
             pDao.excluir(cpf);
             JOptionPane.showMessageDialog(null, "Prestador excluido");
        }
    }
}
