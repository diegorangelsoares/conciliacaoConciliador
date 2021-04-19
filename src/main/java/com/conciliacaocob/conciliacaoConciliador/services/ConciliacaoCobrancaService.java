package com.conciliacaocob.conciliacaoConciliador.services;

import com.conciliacaocob.conciliacaoConciliador.model.ConciliacaoCobranca;
import com.conciliacaocob.conciliacaoConciliador.repository.ConciliacaoCobrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConciliacaoCobrancaService {

    @Autowired
    ConciliacaoCobrancaRepository conciliacaoCobrancaRepository;

    public ConciliacaoCobranca buscarPorId(long id){
        return conciliacaoCobrancaRepository.findById(id);
    }
}
