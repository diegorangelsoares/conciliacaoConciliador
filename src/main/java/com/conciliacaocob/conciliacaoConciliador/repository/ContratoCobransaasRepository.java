package com.conciliacaocob.conciliacaoConciliador.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratoCobransaasRepository extends PagingAndSortingRepository<com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas, Integer> {

    com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas findById(long idEmissor);

    @Override
    Optional<com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas> findById(Integer integer);

    @Query(value = "select c from ContratoCobransaas c where c.conciliacao = :conciliacao")
    List<com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas> findContratoCobransaasByConciliacaoPageable(long conciliacao, Pageable pageable);

    List<com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas> findAllByConciliacao(long conciliacao, Pageable pageable);

    List<com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas> findAll();

    void deleteByConciliacao(long conciliacao);

}
