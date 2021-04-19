package com.conciliacaocob.conciliacaoConciliador.model;

import javax.persistence.*;

/**
 * Classe do objeto Base
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Entity
@Table(name="T_BASE")
public class Base {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String ipCards;
    private String portaCards;
    private String sidCards;
    private String usuarioCards;
    private String senhaCards;

    private String enderecoCobransaas;
    private String aplicativoCobransaas;
    private String senhaCobransaas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIpCards() {
        return ipCards;
    }

    public void setIpCards(String ipCards) {
        this.ipCards = ipCards;
    }

    public String getPortaCards() {
        return portaCards;
    }

    public void setPortaCards(String portaCards) {
        this.portaCards = portaCards;
    }

    public String getSidCards() {
        return sidCards;
    }

    public void setSidCards(String sidCards) {
        this.sidCards = sidCards;
    }

    public String getUsuarioCards() {
        return usuarioCards;
    }

    public void setUsuarioCards(String usuarioCards) {
        this.usuarioCards = usuarioCards;
    }

    public String getSenhaCards() {
        return senhaCards;
    }

    public void setSenhaCards(String senhaCards) {
        this.senhaCards = senhaCards;
    }

    public String getEnderecoCobransaas() {
        return enderecoCobransaas;
    }

    public void setEnderecoCobransaas(String enderecoCobransaas) {
        this.enderecoCobransaas = enderecoCobransaas;
    }

    public String getAplicativoCobransaas() {
        return aplicativoCobransaas;
    }

    public void setAplicativoCobransaas(String aplicativoCobransaas) {
        this.aplicativoCobransaas = aplicativoCobransaas;
    }

    public String getSenhaCobransaas() {
        return senhaCobransaas;
    }

    public void setSenhaCobransaas(String senhaCobransaas) {
        this.senhaCobransaas = senhaCobransaas;
    }
}
