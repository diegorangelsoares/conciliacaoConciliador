package com.conciliacaocob.conciliacaoConciliador.services;

import com.conciliacaocob.conciliacaoConciliador.controller.EmissorResponse;
import com.conciliacaocob.conciliacaoConciliador.model.Emissor;
import com.conciliacaocob.conciliacaoConciliador.repository.EmissorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmissorService {

    @Autowired
    private EmissorRepository emissorRepository;

    public Emissor buscarPorId(long id) {
        return emissorRepository.findById(id);
    }

    public List<EmissorResponse> buscarTodos() {
        List<Emissor> emissores = emissorRepository.findAll();
        List<EmissorResponse> emissoresResponse = new ArrayList<>();

        emissores.stream().forEach(emissor ->
                emissoresResponse.add(new EmissorResponse(emissor.getId(), emissor.getNome()))
        );

        return emissoresResponse;
    }

}
