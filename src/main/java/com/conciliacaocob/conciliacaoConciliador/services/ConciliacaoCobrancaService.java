package com.conciliacaocob.conciliacaoConciliador.services;

import com.conciliacaocob.conciliacaoConciliador.model.ConciliacaoCobranca;
import com.conciliacaocob.conciliacaoConciliador.repository.ConciliacaoCobrancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConciliacaoCobrancaService {

    //@Autowired
    ConciliacaoCobrancaRepository conciliacaoCobrancaRepository;

    public ConciliacaoCobranca buscarPorId(long id) {
        return conciliacaoCobrancaRepository.findById(id);
    }


}
