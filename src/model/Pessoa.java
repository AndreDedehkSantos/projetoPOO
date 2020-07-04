package model;

import java.sql.Date;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String ultimoAcesso;

    public Date registrarEntrada(Pessoa pessoa) {
        return null;
    }

    public Pessoa(){
        
    }

    public Pessoa(String nome, String cpf, String ultimoAcesso) {
        this.nome = nome;
        this.cpf = cpf;
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
}
