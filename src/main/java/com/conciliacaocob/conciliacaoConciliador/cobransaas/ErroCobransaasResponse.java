package com.conciliacaocob.conciliacaoConciliador.cobransaas;

//import org.apache.commons.lang3.StringUtils;

import com.conciliacaocob.conciliacaoConciliador.util.FuncoesData;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ErroCobransaasResponse {


    private static final Map<Integer, String> errorMessageMap = new HashMap<>();
    static {
        errorMessageMap.put(HttpStatus.SC_BAD_REQUEST, "Regra de negócio");
        errorMessageMap.put(HttpStatus.SC_UNAUTHORIZED, "Acesso não autorizado, falta de autenticação");
        errorMessageMap.put(HttpStatus.SC_FORBIDDEN, "Acesso proibido, falta de permissão de acesso");
        errorMessageMap.put(HttpStatus.SC_NOT_FOUND, "Recurso não encontrado ou inexistente");
        errorMessageMap.put(HttpStatus.SC_METHOD_NOT_ALLOWED, "Método não permitido");
        errorMessageMap.put(HttpStatus.SC_UNPROCESSABLE_ENTITY, "Campos inválidos ou fora das regras estabelecidas");
        errorMessageMap.put(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Erro interno no servidor");
    }

    @SerializedName("timestamp")
    private Calendar data;
    private String status;
    private String error;
    private String message;
    private String path;

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageByCode(int errorCode) {
        if (errorMessageMap.containsKey(errorCode)) {
            message = errorMessageMap.get(errorCode);

        } else {
            message = "Código de erro não mapeado";
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        if (data != null) {
            msg.append("[")
                    .append(FuncoesData.formatarDataComHora(data.getTime()))
                    .append("] ");
        }

        msg.append("Erro ")
                .append(status);

        if (StringUtils.isNotBlank(error)) {
            msg.append(" - ")
                    .append(error);
        }

        msg.append(": ")
                .append(message);

        if (StringUtils.isNotBlank(path)) {
            msg.append(" (")
                    .append(path)
                    .append(")");
        }

        return msg.toString();
    }



}
