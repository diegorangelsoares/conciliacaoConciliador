package com.conciliacaocob.conciliacaoConciliador.model;

import com.conciliacaocob.conciliacaoConciliador.cobransaas.ClienteContratoCobransaas;
import com.conciliacaocob.conciliacaoConciliador.cobransaas.DTO.ContratoCobransaasDTO;
import com.conciliacaocob.conciliacaoConciliador.util.FuncoesData;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Classe do objeto ContratoCobransaasNaoCards
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Entity
@Table(name="T_CONTRATOCOBRANSAAS")
public class ContratoCobransaas {

    protected static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SerializedName("id")
    private long id;

    @SerializedName("idExterno")
    private String idExterno;

    @SerializedName("numeroContrato")
    private String numeroContrato;

    @SerializedName("numeroParcelas")
    private Integer numeroParcelas;

    @SerializedName("dataEmissao")
    private String dataEmissao;

    @SerializedName("dataOperacao")
    private Date dataOperacao;

    @SerializedName("situacao")
    private String situacao;

    @SerializedName("tipo")
    private String tipo;

    @SerializedName("taxaOperacao")
    private Double taxaOperacao;

    @SerializedName("valorDevolucao")
    private Double valorDevolucao;

    @SerializedName("valorIof")
    private Double valorIof;

    @SerializedName("valorLiquido")
    private Double valorLiquido;

    @SerializedName("valorTarifa")
    private Double valorTarifa;


    @SerializedName("valorTotal")
    private Double valorTotal;

    @SerializedName("saldoAtual")
    private Double saldoAtual;

    @SerializedName("saldoTotal")
    private Double saldoTotal;

    @SerializedName("saldoAtraso")
    private Double saldoAtraso;

    @SerializedName("diasAtraso")
    private Integer diasAtraso;

    @SerializedName("dataVencimento")
    private Date dataVencimento;

    @SerializedName("dataHoraModificacao")
    private Date dataHoraModificacao;

    @SerializedName("lp")
    private Boolean lp;

    @SerializedName("dataLp")
    private Date dataLp;

    @SerializedName("siglaAtraso")
    private String siglaAtraso;

    @SerializedName("cliente")
    private String idcliente;

    @SerializedName("conciliacao")
    private long conciliacao;

    public ContratoCobransaas() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getTaxaOperacao() {
        return taxaOperacao;
    }

    public void setTaxaOperacao(Double taxaOperacao) {
        this.taxaOperacao = taxaOperacao;
    }

    public Double getValorDevolucao() {
        return valorDevolucao;
    }

    public void setValorDevolucao(Double valorDevolucao) {
        this.valorDevolucao = valorDevolucao;
    }

    public Double getValorIof() {
        return valorIof;
    }

    public void setValorIof(Double valorIof) {
        this.valorIof = valorIof;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Double getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(Double valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Double getSaldoAtraso() {
        return saldoAtraso;
    }

    public void setSaldoAtraso(Double saldoAtraso) {
        this.saldoAtraso = saldoAtraso;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataHoraModificacao() {
        return dataHoraModificacao;
    }

    public void setDataHoraModificacao(Date dataHoraModificacao) {
        this.dataHoraModificacao = dataHoraModificacao;
    }

    public Boolean getLp() {
        return lp;
    }

    public void setLp(Boolean lp) {
        this.lp = lp;
    }

    public Date getDataLp() {
        return dataLp;
    }

    public void setDataLp(Date dataLp) {
        this.dataLp = dataLp;
    }

    public String getSiglaAtraso() {
        return siglaAtraso;
    }

    public void setSiglaAtraso(String siglaAtraso) {
        this.siglaAtraso = siglaAtraso;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public long getConciliacao() {
        return conciliacao;
    }

    public void setConciliacao(long conciliacao) {
        this.conciliacao = conciliacao;
    }

    public static ArrayList<ContratoCobransaasDTO> parseObjetoToListContratoCobransaasDTO(ArrayList<ContratoCobransaasDTO> contratos) throws ParseException {

        ArrayList<ContratoCobransaasDTO> contratos2 = new ArrayList<>();

        for(int i = 0; i < contratos.size(); i++) {

            ContratoCobransaasDTO contrato = new ContratoCobransaasDTO();
            Object getrow = contratos.get(i);
            LinkedTreeMap<Object, Object> t = (LinkedTreeMap) getrow;
            contrato.setId(Long.parseLong(t.get("id").toString()));
            contrato.setNumeroContrato((t.get("numeroContrato") == null) ? "" : t.get("numeroContrato").toString());
            contrato.setNumeroParcelas((t.get("numeroParcelas") == null) ? null : Integer.parseInt(t.get("numeroParcelas").toString()));
            contrato.setDataEmissao((t.get("dataEmissao") == null) ? null : t.get("dataEmissao").toString());
            //contrato.setDataEmissao((t.get("dataEmissao") == null) ? null : FuncoesData.getCalendar(sdf.parse(t.get("dataEmissao").toString())));
            contrato.setDataOperacao((t.get("dataOperacao") == null) ? null : FuncoesData.getData(t.get("dataOperacao").toString()));
            contrato.setSituacao((t.get("situacao") == null) ? "" : t.get("situacao").toString());
            contrato.setTipo((t.get("tipo") == null) ? "" : t.get("tipo").toString());
            contrato.setTaxaOperacao((t.get("taxaOperacao") == null) ? null : Double.parseDouble(t.get("taxaOperacao").toString()));
            contrato.setValorDevolucao((t.get("valorDevoluca") == null) ? null : Double.parseDouble(t.get("valorDevoluca").toString()));
            contrato.setValorIof((t.get("valorIof") == null) ? null : Double.parseDouble(t.get("valorIof").toString()));
            contrato.setValorLiquido((t.get("valorLiquido") == null) ? null : Double.parseDouble(t.get("valorLiquido").toString()));
            contrato.setValorTarifa((t.get("valorTarifa") == null) ? null : Double.parseDouble(t.get("valorTarifa").toString()));
            contrato.setValorTotal((t.get("valorTotal") == null) ? null : Double.parseDouble(t.get("valorTotal").toString()));
            contrato.setSaldoAtual((t.get("saldoAtual") == null) ? null : Double.parseDouble(t.get("saldoAtual").toString()));
            contrato.setSaldoTotal((t.get("saldoTotal") == null) ? null : Double.parseDouble(t.get("saldoTotal").toString()));
            contrato.setSaldoAtraso((t.get("saldoAtraso") == null) ? null : Double.parseDouble(t.get("saldoAtraso").toString()));
            contrato.setDiasAtraso((t.get("diasAtraso") == null) ? null : Integer.parseInt(t.get("diasAtraso").toString()));
            contrato.setDataVencimento((t.get("dataVencimento") == null) ? null : FuncoesData.getData(t.get("dataVencimento").toString()));
            //contrato.setDataHoraModificacao((t.get("dataHoraModificacao") == null) ? null : FuncoesData.getCalendar(sdf.parse(t.get("dataHoraModificacao").toString())));
            contrato.setLp((t.get("lp") == null) ? null : Boolean.parseBoolean(t.get("lp").toString()));
            contrato.setDataLp((t.get("dataLp") == null) ? null : FuncoesData.getData(t.get("dataLp").toString()));
            contrato.setSiglaAtraso((t.get("siglaAtraso") == null) ? "" : t.get("siglaAtraso").toString());
            ClienteContratoCobransaas cliente = new ClienteContratoCobransaas();
            Object objetcCliente = ((t.get("cliente") == null) ? null : (Object) t.get("cliente"));
            cliente = parseObjectToClienteContratoCobransaas(objetcCliente);
            contrato.setCliente(cliente);

            contratos2.add(contrato);
        }

        return contratos2;
    }

    public static ClienteContratoCobransaas parseObjectToClienteContratoCobransaas(Object object) throws ParseException {

        ClienteContratoCobransaas cliente = new ClienteContratoCobransaas();

        LinkedTreeMap<Object, Object> t = (LinkedTreeMap) object;
        cliente.setId((t.get("id") == null) ? null : Long.parseLong(t.get("id").toString()));
        cliente.setIdExterno((t.get("idExterno") == null) ? "" : t.get("idExterno").toString());
        cliente.setTipoPessoa((t.get("tipoPessoa") == null) ? "" : t.get("tipoPessoa").toString());
        cliente.setSituacao((t.get("situacao") == null) ? "" : t.get("situacao").toString());
        cliente.setNome((t.get("nome") == null) ? "" : t.get("nome").toString());
        cliente.setCic((t.get("cic") == null) ? "" : t.get("cic").toString());
        cliente.setCodigo((t.get("codigo") == null) ? "" : t.get("codigo").toString());
        cliente.setSexo((t.get("sexo") == null) ? "" : t.get("sexo").toString());
        cliente.setDataNascimento((t.get("dataNascimento") == null) ? null : FuncoesData.getCalendar(sdf.parse(t.get("dataNascimento").toString())));
        cliente.setDataConta((t.get("dataConta") == null) ? null : FuncoesData.getCalendar(sdf.parse(t.get("dataConta").toString())));
        cliente.setNaturalidade((t.get("naturalidade") == null) ? "" : t.get("naturalidade").toString());
        cliente.setEstadoCivil((t.get("estadoCivil") == null) ? "" : t.get("estadoCivil").toString());
        cliente.setRg((t.get("rg") == null) ? "" : t.get("rg").toString());
        cliente.setRating((t.get("rating") == null) ? "" : t.get("rating").toString());
        cliente.setLp((t.get("lp") == null) ? "" : t.get("lp").toString());
        cliente.setPropensaoPagamento((t.get("propensaoPagamento") == null) ? "" : t.get("propensaoPagamento").toString());
        cliente.setHistoricoPagamento((t.get("historicoPagamento") == null) ? "" : t.get("historicoPagamento").toString());
        cliente.setNumeroDiasMaiorAtraso((t.get("numeroDiasMaiorAtraso") == null) ? 0 : Integer.parseInt(t.get("numeroDiasMaiorAtraso").toString()));
        cliente.setDataMaiorAtraso((t.get("dataMaiorAtraso") == null) ? null : FuncoesData.getCalendar(sdf.parse(t.get("dataMaiorAtraso").toString())));
        cliente.setRendaTitular((t.get("rendaTitular") == null) ? 0 : Double.parseDouble(t.get("rendaTitular").toString()));
        cliente.setRendaConjuge((t.get("rendaConjuge") == null) ? 0 : Double.parseDouble(t.get("rendaConjuge").toString()));
        cliente.setOutrasRendas((t.get("outrasRendas") == null) ? 0 : Double.parseDouble(t.get("outrasRendas").toString()));
        cliente.setProfissao((t.get("profissao") == null) ? "" : t.get("profissao").toString());
        cliente.setCategoriaProfissao((t.get("categoriaProfissao") == null) ? "" : t.get("categoriaProfissao").toString());
        cliente.setTipoResidencia((t.get("tipoResidencia") == null) ? "" : t.get("tipoResidencia").toString());
        cliente.setSaldoAtraso((t.get("saldoAtraso") == null) ? 0 : Double.parseDouble(t.get("saldoAtraso").toString()));
        cliente.setSaldoAtual((t.get("saldoAtual") == null) ? 0 : Double.parseDouble(t.get("saldoAtual").toString()));
        cliente.setSaldoContabil((t.get("saldoContabil") == null) ? 0 : Double.parseDouble(t.get("saldoContabil").toString()));
        cliente.setSaldoProvisao((t.get("saldoProvisao") == null) ? 0 : Double.parseDouble(t.get("saldoProvisao").toString()));
        cliente.setDiasAtraso((t.get("diasAtraso") == null) ? 0 : Integer.parseInt(t.get("diasAtraso").toString()));
        //cliente.setDataHoraModificacao((t.get("numeroContrato") == null) ? "" : t.get("numeroContrato").toString());

        return cliente;
    }

    public static ArrayList<ContratoCobransaas> parseObjetoToListContratoCobransaasDTOtoContratoCobransaas (List<ContratoCobransaasDTO> contratos, long conciliacao) {
        ArrayList<ContratoCobransaas> contratos2 = new ArrayList<>();

        for(int i = 0; i < contratos.size(); i++) {

            ContratoCobransaas contrato = new ContratoCobransaas();
            contrato.setId(contratos.get(i).getId());
            //contrato.setConciliacaoCobranca(contratos.get(i).getC());
            contrato.setIdExterno(contratos.get(i).getIdExterno());
            contrato.setNumeroContrato(contratos.get(i).getNumeroContrato());
            contrato.setNumeroParcelas(contratos.get(i).getNumeroParcelas());
            contrato.setDataEmissao(contratos.get(i).getDataEmissao());
            contrato.setDataOperacao(contratos.get(i).getDataOperacao());
            contrato.setSituacao(contratos.get(i).getSituacao());
            contrato.setTipo(contratos.get(i).getTipo());
            contrato.setTaxaOperacao(contratos.get(i).getTaxaOperacao());
            contrato.setValorDevolucao(contratos.get(i).getValorDevolucao());
            contrato.setValorIof(contratos.get(i).getValorIof());
            contrato.setValorLiquido(contratos.get(i).getValorLiquido());
            contrato.setValorTarifa(contratos.get(i).getValorTarifa());
            contrato.setValorTotal(contratos.get(i).getValorTotal());
            contrato.setSaldoAtual(contratos.get(i).getSaldoAtual());
            contrato.setSaldoTotal(contratos.get(i).getSaldoTotal());
            contrato.setSaldoAtraso(contratos.get(i).getSaldoAtraso());
            contrato.setDiasAtraso(contratos.get(i).getDiasAtraso());
            contrato.setDataVencimento(contratos.get(i).getDataVencimento());
            contrato.setDataHoraModificacao(contratos.get(i).getDataHoraModificacao());
            contrato.setLp(contratos.get(i).getLp());
            contrato.setDataLp(contratos.get(i).getDataLp());
            contrato.setSiglaAtraso(contratos.get(i).getSiglaAtraso());
            contrato.setIdcliente(contratos.get(i).getCliente().getIdExterno());
            contrato.setConciliacao(conciliacao);
            contratos2.add(contrato);
        }
        return contratos2;

    }



}
