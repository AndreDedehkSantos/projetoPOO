package controller;

import DAO.VisitanteDAO;
import entidades.enums.TipoVisitante;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Morador;
import model.Visitante;


public class VisitanteController {
    
     static VisitanteDAO vDAO = new VisitanteDAO();
     public static Visitante validarVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf){
        Morador morador = MoradorController.pesquisarMorador(cpfMorador);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "Rever 'CPF do Morador'");
            return null;
        }
        if(tipo == null){
            JOptionPane.showMessageDialog(null, "Rever 'Tipo'");
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
           
        Visitante existe = vDAO.pesquisar(cpf);
        if (existe != null) {
            JOptionPane.showMessageDialog(null, "Visitante já cadstrado");
            return null;
        }
     
        Date agora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = formato.format(agora);
        
        return new Visitante(cpfMorador, tipo, nome, cpf, data);
    }
     
      public static Visitante validarVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf, String ultimoAcesso){
        Morador morador = MoradorController.pesquisarMorador(cpfMorador);
        if(morador == null){
            JOptionPane.showMessageDialog(null, "Rever 'CPF do Morador'");
            return null;
        }
        if(tipo == null){
            JOptionPane.showMessageDialog(null, "Rever 'Tipo'");
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
      
        return new Visitante(cpfMorador, tipo, nome, cpf, ultimoAcesso);
    }   
     
    public static void definirVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf){
        Visitante visitante = validarVisitante(cpfMorador, tipo, nome, cpf);
        if(visitante != null){
            vDAO.salvar(visitante);
            JOptionPane.showMessageDialog(null, "Visitante cadastrado");
        }
    }
    
    public static Visitante pesquisarVisitante(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        Visitante visitante = vDAO.pesquisar(cpf);
        if(visitante == null){
            JOptionPane.showMessageDialog(null, "Visitante não encontrado");
            return null;
        }else{
            return visitante;
        }  
    }
    
    public static void alterarVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf, String ultimoAcesso){ 
        Visitante visitante = validarVisitante(cpfMorador, tipo, nome, cpf, ultimoAcesso);
        if(visitante != null){
            vDAO.alterar(visitante);
            vDAO.alterar(visitante);
            JOptionPane.showMessageDialog(null, "Visitante alterado");
        }
    }
    
    public static void excluir(String cpf){
        if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]") || cpf.matches("[a - z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
        }
        Visitante visitante = pesquisarVisitante(cpf);
        if(visitante == null){
            JOptionPane.showMessageDialog(null, "Visitante não encontrado");
        }else{
            vDAO.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Visitante Excluido!");
        }
    }
}
