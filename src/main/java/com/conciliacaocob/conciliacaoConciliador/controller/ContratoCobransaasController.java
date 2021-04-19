package com.conciliacaocob.conciliacaoConciliador.controller;

import com.conciliacaocob.conciliacaoParcExt.model.DadosConciliacao;
import com.conciliacaocob.conciliacaoParcExt.model.Emissor;
import com.conciliacaocob.conciliacaoParcExt.services.ContratoCobransaasService;
import com.conciliacaocob.conciliacaoParcExt.services.EmissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class ContratoCobransaasController {

    @Autowired
    EmissorService emissorService;

    @Autowired
    ContratoCobransaasService contratoCobransaasService;

    @GetMapping(path="ConsultaContratosCobransaasSalvos")
    public ResponseEntity<?> listaContratosSalvos(@RequestParam("page") int pageIndex,
                                                  @RequestParam("size") int pageSize,
                                                  @RequestParam("conciliacao") long conciliacao){
        return new ResponseEntity<>(contratoCobransaasService.listaContratosSalvos(PageRequest.of(pageIndex, pageSize), conciliacao),HttpStatus.OK);
    }

    @PostMapping(path="ConsultaContratosCobransaas/")
    public ResponseEntity<?> consultaContratosCobransaas(@Validated @RequestBody DadosConciliacao dadosConciliacao) throws Exception {
        Emissor emissor = emissorService.buscarPorId(dadosConciliacao.getIdEmissor());
        if (emissor != null){
            return new ResponseEntity<>(contratoCobransaasService.buscarContratosCobransaas(emissor, dadosConciliacao.getConciliacao()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Emissor "+dadosConciliacao.getIdEmissor()+" nao encontrato!",HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping (path="RemoveContratosCobransaas/{idEmissor}")
    public ResponseEntity<?> removeContratosCobransaas(@PathVariable("idEmissor") long idEmissor) throws Exception {
        Emissor emissor = emissorService.buscarPorId(idEmissor);
        if (emissor != null){
            return new ResponseEntity<>(contratoCobransaasService.removeContratosBaseLocal(emissor), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Emissor "+idEmissor+" nao encontrato!",HttpStatus.BAD_REQUEST);
        }

    }




}
