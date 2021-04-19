package com.conciliacaocob.conciliacaoConciliador.cobransaas;

import com.conciliacaocob.conciliacaoParcExt.cobransaas.DTO.ContratoCobransaasDTO;

import java.util.ArrayList;

public class ListagemContratosCobransaasResponse  implements ResponseBodyCobransaas {

    private ArrayList<ContratoCobransaasDTO> contratos;

    public ListagemContratosCobransaasResponse(ArrayList<ContratoCobransaasDTO> contratos) {
        this.contratos = contratos;
    }

    public ArrayList<ContratoCobransaasDTO> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<ContratoCobransaasDTO> contratos) {
        this.contratos = contratos;
    }

}