package com.conciliacaocob.conciliacaoConciliador.repository;

import com.conciliacaocob.conciliacaoConciliador.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends JpaRepository<Base, Integer> {

    //Base findEmissor(long idEmissor);

    Base findById(long id);


}
