package com.conciliacaocob.conciliacaoConciliador.services;

import com.conciliacaocob.conciliacaoParcExt.controller.EmissorResponse;
import com.conciliacaocob.conciliacaoParcExt.model.Emissor;
import com.conciliacaocob.conciliacaoParcExt.repository.EmissorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmissorService {

    @Autowired
    EmissorRepository emissorRepository;

    public Emissor buscarPorId(long id){
        return emissorRepository.findById(id);
    }

    public List<EmissorResponse> buscarTodos(){
        List<Emissor> emissores = emissorRepository.findAll();
        List<EmissorResponse> emissoresResponse = new ArrayList<>();

        emissores.stream().forEach(emissor ->
            emissoresResponse.add(new EmissorResponse(emissor.getId(), emissor.getNome()))
        );

        return emissoresResponse;
    }

}
