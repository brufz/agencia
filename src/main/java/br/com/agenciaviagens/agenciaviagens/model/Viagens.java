package br.com.agenciaviagens.agenciaviagens.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_viagens")
public class Viagens extends AbstractEntity{

    @Column(name="local")
    @NotEmpty(message = "Local tem que ser preenchido")
    private String local;
    @NotEmpty(message = "Passageiro tem que ser preenchido")
    @Column(name="passageiro")
    private String passageiro;

    //@NotNull(message = "Valor tem que ser preenchido")
    @Column(name="valor")
    private double valor;

    public Viagens() {
    }

    public Viagens(String local, String passageiro, double valor) {
        this.local = local;
        this.passageiro = passageiro;
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
