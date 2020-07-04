
package model;

import entidades.enums.TipoVisitante;
import java.sql.Date;


public class Visitante extends Pessoa {

    private String cpfMorador;
    private TipoVisitante tipo;


    public void cadastrar_visitante() {

    }

    public Visitante consultar(String cpf) {
        return null;
    }

    public Visitante(String cpfMorador, TipoVisitante tipo, String nome, String cpf, String ultimoAcesso) {
        super(nome, cpf, ultimoAcesso);
        this.cpfMorador = cpfMorador;
        this.tipo = tipo;
    }

    public String getMorador() {
        return this.cpfMorador;
    }

    public void setMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

    public TipoVisitante getTipo() {
        return tipo;
    }

    public void setTipo(TipoVisitante tipo) {
        this.tipo = tipo;
    }
        

}
