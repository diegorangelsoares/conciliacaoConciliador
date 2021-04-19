package com.conciliacaocob.conciliacaoConciliador.repository;

import com.conciliacaocob.conciliacaoParcExt.model.ContratoCobransaas;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratoCobransaasRepository  extends PagingAndSortingRepository<ContratoCobransaas, Integer> {

    ContratoCobransaas findById(long idEmissor);

    @Override
    Optional<ContratoCobransaas> findById(Integer integer);

    @Query (value = "select c from ContratoCobransaas c where c.conciliacao = :conciliacao")
    List<ContratoCobransaas> findContratoCobransaasByConciliacaoPageable(long conciliacao, Pageable pageable);

    List<ContratoCobransaas> findAllByConciliacao(long conciliacao, Pageable pageable);

    void deleteByConciliacao(long conciliacao);

}
