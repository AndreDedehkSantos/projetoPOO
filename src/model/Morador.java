package model;

import java.sql.Date;

public class Morador extends Pessoa {

    private int torre;
    private int apartamento;
    private String telefone;

    public void cadastrar_morador() {

    }

    public Morador consultar(String cpf) {
        return null;
    }
    
    public Morador(){
        
    }
    
    public Morador(int torre, int apartamento, String telefone, String nome, String cpf, String ultimoAcesso) {
        super(nome, cpf, ultimoAcesso);
        this.torre = torre;
        this.apartamento = apartamento;
        this.telefone = telefone;
    }
    
    public void cadastrar(Morador morador){
        //Apos implementar DAO
    }
    
    public Morador consultarMorador(String cpf){
        //Apos DAO
        return null;
    }
    
    
    public int getTorre() {
        return torre;
    }

    public void setTorre(int torre) {
        this.torre = torre;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
