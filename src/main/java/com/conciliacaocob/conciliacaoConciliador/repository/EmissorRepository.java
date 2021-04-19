package com.conciliacaocob.conciliacaoConciliador.repository;

import com.conciliacaocob.conciliacaoConciliador.model.Emissor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmissorRepository  extends JpaRepository<Emissor, Integer> {

    Emissor findById(long idEmissor);


}
