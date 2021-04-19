package com.conciliacaocob.conciliacaoConciliador.repository;

import com.conciliacaocob.conciliacaoParcExt.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository  extends JpaRepository<Base, Integer> {

    //Base findEmissor(long idEmissor);

    Base findById(long id);


}
