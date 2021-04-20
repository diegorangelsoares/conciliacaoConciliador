package com.conciliacaocob.conciliacaoConciliador.cobransaas;

public class ResponseConsultaContratos {

    public static String STATUS_SUCESSO = "SUCESSO";
    public static String STATUS_ERRO = "ERRO";

    public String statusConsulta;
    public int quantidadeContratos;
    public String erro;

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public int getQuantidadeContratos() {
        return quantidadeContratos;
    }

    public void setQuantidadeContratos(int quantidadeContratos) {
        this.quantidadeContratos = quantidadeContratos;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
