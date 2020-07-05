package model;

public class Entregador extends Pessoa {

    private String empresa;

    private String conteudo;

    private String cpfMorador;

    public void cadastrar_corretor() {

    }

    public Entregador consultar(String cpf) {
        return null;
    }

    public Entregador(String empresa, String conteudo, String cpfMorador, String nome, String cpf, String ultimoAcesso) {
        super(nome, cpf, ultimoAcesso);
        this.empresa = empresa;
        this.conteudo = conteudo;
        this.cpfMorador = cpfMorador;
    }
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getCpfMorador() {
        return cpfMorador;
    }

    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

}
