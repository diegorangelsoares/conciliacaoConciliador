package com.conciliacaocob.conciliacaoConciliador.controller;

import com.conciliacaocob.conciliacaoConciliador.services.ConciliacaoCobrancaService;
import com.conciliacaocob.conciliacaoConciliador.services.EmissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class ConciliacaoCobrancaController {

    @Autowired
    EmissorService emissorService;

    @Autowired
    ConciliacaoCobrancaService conciliacaoCobrancaService;

    @GetMapping(path="listaConciliacao")
    public ResponseEntity<?> listaConciliacao(@RequestParam("conciliacao") long conciliacao){
        return new ResponseEntity<>(conciliacaoCobrancaService.buscarPorId(conciliacao), HttpStatus.OK);
    }

//
//    @DeleteMapping (path="RemoveContratosCobransaas/{idEmissor}")
//    public ResponseEntity<?> removeContratosCobransaas(@PathVariable("idEmissor") long idEmissor) throws Exception {
//        Emissor emissor = emissorService.buscarPorId(idEmissor);
//        if (emissor != null){
//            return new ResponseEntity<>(contratoCobransaasService.removeContratosBaseLocal(emissor), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("Emissor "+idEmissor+" nao encontrato!",HttpStatus.BAD_REQUEST);
//        }
//
//    }




}
