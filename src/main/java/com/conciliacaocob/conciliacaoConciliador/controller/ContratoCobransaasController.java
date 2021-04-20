package com.conciliacaocob.conciliacaoConciliador.controller;

import com.conciliacaocob.conciliacaoConciliador.model.ConciliacaoCobranca;
import com.conciliacaocob.conciliacaoConciliador.model.ContratoCobransaas;
import com.conciliacaocob.conciliacaoConciliador.services.ConciliacaoCobrancaService;
import com.conciliacaocob.conciliacaoConciliador.services.ContratoCobransaasService;
import com.conciliacaocob.conciliacaoConciliador.services.EmissorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor()
public class ContratoCobransaasController {

    private static final Logger logger = LoggerFactory.getLogger(ContratoCobransaasController.class);

    //@Autowired
    EmissorService emissorService;

    @Autowired
    ContratoCobransaasService contratoCobransaasService;

    //@Autowired
    ConciliacaoCobrancaService conciliacaoCobrancaService;

    @GetMapping(path = "ConsultaContratosCobransaasSalvos")
    public ResponseEntity<?> listaContratosSalvos(@RequestParam("page") int pageIndex,
                                                  @RequestParam("size") int pageSize,
                                                  @RequestParam("conciliacao") long conciliacao) {
        return new ResponseEntity<>(contratoCobransaasService.listaContratosSalvos(PageRequest.of(pageIndex, pageSize), conciliacao), HttpStatus.OK);
    }

    @PostMapping(path = "SalvarContratosCobransaas/")
    public ResponseEntity<?> SalvarContratosCobransaas(
            //@RequestParam("conciliacao") long conciliacao,
            @Validated @RequestBody List<ContratoCobransaas> contratos) throws Exception {
        //ConciliacaoCobranca conciliacaoCobranca = conciliacaoCobrancaService.buscarPorId(conciliacao);
        //Emissor emissor = emissorService.buscarPorId(dadosConciliacao.getIdEmissor());
        ConciliacaoCobranca conciliacaoCobranca = new ConciliacaoCobranca();
        logger.info("Chegou requisicao aqui...");
        //if (conciliacaoCobranca != null){
        return new ResponseEntity<>(contratoCobransaasService.salvarContratosCobransaas(conciliacaoCobranca, contratos), HttpStatus.OK);
        //}else{
        //    return new ResponseEntity<>("Conciliacao "+conciliacaoCobranca+" nao encontrato!",HttpStatus.BAD_REQUEST);
        //}

    }

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
