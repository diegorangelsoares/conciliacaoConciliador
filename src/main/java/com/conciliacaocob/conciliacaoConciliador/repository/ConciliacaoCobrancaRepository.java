package com.conciliacaocob.conciliacaoConciliador.repository;

import com.conciliacaocob.conciliacaoConciliador.model.ConciliacaoCobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConciliacaoCobrancaRepository extends JpaRepository<ConciliacaoCobranca, Integer> {

    ConciliacaoCobranca findById(long id);


}