package com.conciliacaocob.conciliacaoConciliador.repository;

import com.conciliacaocob.conciliacaoConciliador.model.ConciliacaoCobranca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConciliacaoCobrancaRepository extends JpaRepository<ConciliacaoCobranca, Integer> {

    ConciliacaoCobranca findById(long id);


}