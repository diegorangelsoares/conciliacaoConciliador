package com.conciliacaocob.conciliacaoConciliador.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Classe do objeto ConciliacaoCobranca
 *
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Entity
@Table(name = "T_CONCILIACAOCOBRANCA")
public class ConciliacaoCobranca {

    public static final String TIPO_CONCILIACAO_MANUAL = "M";
    public static final String TIPO_CONCILIACAO_AUTOMATICA = "A";

    public static final String STATUS_BASES_CONSISTENTE = "C";
    public static final String STATUS_BASES_INCONSISTENTE = "I";

    public static final String STATUS_CONCILIACAO_INICIADA = "I";
    public static final String STATUS_CONCILIACAO_CONSULTANDO_COBRANSAAS = "T";
    public static final String STATUS_CONCILIACAO_CONSULTANDO_CARDS = "C";
    public static final String STATUS_CONCILIACAO_CONCILIANDO = "X";
    public static final String STATUS_CONCILIACAO_FINALIZADA = "F";
    public static final String STATUS_CONCILIACAO_FINALIZADA_COM_ERRO = "E";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String nome;

    @ManyToOne
    @JoinColumn
    public Emissor emissor;
    private Date data;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;
    private String tipo;
    private String status_bases;
    private String status_conciliacao;
    private int quantidade_contratos_cards;
    private int quantidade_contratos_cobransaas;
    private int quantidade_contratos_cards_n_cobransaas;
    private int quantidade_contratos_cobransaas_n_cards;
    private String Observacao;
    private Date dataFinalizacao;

//    private List<ContratoCardsNaoCobransaas> contratosCardsNaoCobransaas;
//    private List<ContratoCobransaasNaoCards> contratosCobransaasNaoCards;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus_bases() {
        return status_bases;
    }

    public void setStatus_bases(String status_bases) {
        this.status_bases = status_bases;
    }

    public String getStatus_conciliacao() {
        return status_conciliacao;
    }

    public void setStatus_conciliacao(String status_conciliacao) {
        this.status_conciliacao = status_conciliacao;
    }

    public int getQuantidade_contratos_cards() {
        return quantidade_contratos_cards;
    }

    public void setQuantidade_contratos_cards(int quantidade_contratos_cards) {
        this.quantidade_contratos_cards = quantidade_contratos_cards;
    }

    public int getQuantidade_contratos_cobransaas() {
        return quantidade_contratos_cobransaas;
    }

    public void setQuantidade_contratos_cobransaas(int quantidade_contratos_cobransaas) {
        this.quantidade_contratos_cobransaas = quantidade_contratos_cobransaas;
    }

    public int getQuantidade_contratos_cards_n_cobransaas() {
        return quantidade_contratos_cards_n_cobransaas;
    }

    public void setQuantidade_contratos_cards_n_cobransaas(int quantidade_contratos_cards_n_cobransaas) {
        this.quantidade_contratos_cards_n_cobransaas = quantidade_contratos_cards_n_cobransaas;
    }

    public int getQuantidade_contratos_cobransaas_n_cards() {
        return quantidade_contratos_cobransaas_n_cards;
    }

    public void setQuantidade_contratos_cobransaas_n_cards(int quantidade_contratos_cobransaas_n_cards) {
        this.quantidade_contratos_cobransaas_n_cards = quantidade_contratos_cobransaas_n_cards;
    }

//    public List<ContratoCardsNaoCobransaas> getContratosCardsNaoCobransaas() {
//        return contratosCardsNaoCobransaas;
//    }
//
//    public void setContratosCardsNaoCobransaas(List<ContratoCardsNaoCobransaas> contratosCardsNaoCobransaas) {
//        this.contratosCardsNaoCobransaas = contratosCardsNaoCobransaas;
//    }
//
//    public List<ContratoCobransaasNaoCards> getContratosCobransaasNaoCards() {
//        return contratosCobransaasNaoCards;
//    }
//
//    public void setContratosCobransaasNaoCards(List<ContratoCobransaasNaoCards> contratosCobransaasNaoCards) {
//        this.contratosCobransaasNaoCards = contratosCobransaasNaoCards;
//    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}

