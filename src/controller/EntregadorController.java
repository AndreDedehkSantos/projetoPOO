package controller;

import DAO.EntregadorDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Entregador;
import model.Morador;

public class EntregadorController {
    static EntregadorDAO eDao = new EntregadorDAO();
    public static Entregador validarEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf){
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
      if(cpf.equals("") || cpf.length() != 11 || cpf.matches("[A-Z]") || cpf.matches("[a - z]")){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
       Entregador existe = eDao.pesquisar(cpf);
       if(existe != null){
           JOptionPane.showMessageDialog(null, "Entregador já cadstrado");
           return null;
       }
       Date agora = new Date();
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       String data = formato.format(agora);

       return new Entregador(empresa, conteudo, cpfMorador, nome, cpf, data);
   }

    public static Entregador validarEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf, String ultimoAcesso){
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
       
       return new Entregador(empresa, conteudo, cpfMorador, nome, cpf, ultimoAcesso);
    }
    
    public static void definirEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf){     
        Entregador entregador = validarEntregador(cpfMorador, empresa, conteudo, nome, cpf);
        if(entregador != null){
            eDao.salvar(entregador);
            JOptionPane.showMessageDialog(null, "Entregador cadastrado");
        }
    }
    
    public static Entregador pesquisarEntregador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
            return null;
        }
        Entregador entregador = eDao.pesquisar(cpf);
        if(entregador == null){
            JOptionPane.showMessageDialog(null, "'Entregador não encontrado'");
            return null;
        }else{
            return entregador;
        }
    }
    
    public static void alterarEntregador(String cpfMorador, String empresa, String conteudo, String nome, String cpf, String ultimoAcesso){ 
        Entregador entregador = validarEntregador(cpfMorador, empresa, conteudo, nome, cpf, ultimoAcesso);
        if(entregador != null){
            eDao.alterar(entregador);
            JOptionPane.showMessageDialog(null, "Entregador alterado");
        }
    }
 
    public static void excluirEntregador(String cpf){
        if(cpf.equals("") || cpf.length() != 11){
            JOptionPane.showMessageDialog(null, "Rever 'CPF'");
        }else{
            eDao.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Entregador excluido");
        }
    }
}
