package model;

import java.sql.Date;

public class Prestador extends Pessoa {

    private String categoria;

    private String empresa;

    private String cpfMorador;

    public void cadastrar_prestador() {

    }

    public Prestador consultar(String cpf) {
        return null;
    }

    public Prestador(String categoria, String empresa, String cpfMorador, String nome, String cpf, String ultimoAcesso) {
        super(nome, cpf, ultimoAcesso);
        this.categoria = categoria;
        this.empresa = empresa;
        this.cpfMorador = cpfMorador;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCpfMorador() {
        return cpfMorador;
    }

    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }
}
