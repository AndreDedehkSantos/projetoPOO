package model;

import java.sql.Date;

public class Corretor extends Pessoa {

    private String creci;

    private String corretora;

    public void cadastrar_corretor() {

    }

    public Corretor consultar(String cpf) {
        return null;
    }

    public Corretor(String creci, String corretora, String nome, String cpf, String ultimoAcesso) {
        super(nome, cpf, ultimoAcesso);
        this.creci = creci;
        this.corretora = corretora;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

}
