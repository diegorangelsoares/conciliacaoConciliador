package com.conciliacaocob.conciliacaoConciliador.cobransaas;

public class ResponseCobransaas {

    private ResponseBodyCobransaas responseBody;
    private ErroCobransaasResponse erro;

    public ResponseCobransaas() {
    }

    public ResponseCobransaas(ResponseBodyCobransaas responseBody, ErroCobransaasResponse erro) {
        this.responseBody = responseBody;
        this.erro = erro;
    }

    public ResponseCobransaas(ResponseBodyCobransaas responseBody) {
        this.responseBody = responseBody;
        this.erro = null;
    }

    public ResponseCobransaas(ErroCobransaasResponse erro) {
        responseBody = null;
        this.erro = erro;
    }

    public ResponseBodyCobransaas getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBodyCobransaas responseBody) {
        this.responseBody = responseBody;
    }

    public ErroCobransaasResponse getErro() {
        return erro;
    }

    public void setErro(ErroCobransaasResponse erro) {
        this.erro = erro;
    }

    public boolean isSucesso() {
        return this.erro == null;
    }

}
