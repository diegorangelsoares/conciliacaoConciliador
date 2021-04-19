package com.conciliacaocob.conciliacaoConciliador.cobransaas;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

public class DadosAcessoCobransaasDTO {

    private String endereco;
    private String codigoApp;
    private String token;
    private String authorizationToken;

    public DadosAcessoCobransaasDTO(String endereco, String codigoApp, String token) {
        this.endereco = endereco;
        this.codigoApp = codigoApp;
        this.token = token;
        this.authorizationToken = gerarAuthorizationToken();
    }

    private String gerarAuthorizationToken() {
        String aux = this.codigoApp + ":" + this.token;

        try {
            byte[] message = aux.getBytes("UTF-8");
            return DatatypeConverter.printBase64Binary(message);

        } catch (UnsupportedEncodingException e) {
//            LoggerNeus.error(getClass(), e);
        }

        return null;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCodigoApp() {
        return codigoApp;
    }

    public void setCodigoApp(String codigoApp) {
        this.codigoApp = codigoApp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }
}
