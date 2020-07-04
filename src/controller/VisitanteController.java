package controller;

import entidades.enums.TipoVisitante;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Morador;
import model.Visitante;


public class VisitanteController {
    
     public static Visitante validarVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf, boolean cadastrar, String ultimoAcesso){
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
        if(cadastrar){
            /*Visitante existe = visitanteDAO.pesquisar(cpf);
            if(existe != null){
                JOptionPane.showMessageDialog(null, "Visitante já cadstrado");
                return null;
            }*/
        }
  
        return new Visitante(cpfMorador, tipo, nome, cpf, ultimoAcesso);
    }   
     
    public static boolean definirVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf){
        Visitante visitante = validarVisitante(cpfMorador, tipo, nome, cpf, true, null);
        if(visitante != null){
            /*VisitanteDAO.cadastrar(visitante);
            JOptionPane.showMessageDialog(null, "Visitante cadastrado")
            return true;*/
        }
        return false;
    }
    
    public static Visitante pesquisarVisitante(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        /*Visitante visitante = VisitanteDAO.consultar(cpf);
        if(visitante == null){
            JOptionPane.showMessageDialog(null, "Visitante não encontrado");
            return null;
        }*/
        return null;
    }
    
    public static boolean alterarVisitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf, String ultimoAcesso){ 
        Visitante visitante = validarVisitante(cpfMorador, tipo, nome, cpf, false, ultimoAcesso);
        if(visitante != null){
            /*boolean alterado = VisitanteDAO.alterar(morador);
            if(alterado){
                JOptionPane.showMessageDialog(null, "Visitante alterado");
                return true;
            }*/       
        }
        JOptionPane.showMessageDialog(null, "Visitante não encontrado");
        return false;
    }
    
    public static boolean excluirVisitante(String cpf){
        if (cpf.equals("") || cpf.length() != 11) {
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
        }
        /*boolean excluido = VisitanteDAO.excluir(morador);
        if(excluido){
            JOptionPane.showMessageDialog(null, "Visitante excluyido");
            return true;
        }*/
        JOptionPane.showMessageDialog(null, "Visitante não encontrado");
        return false;
    }
}
