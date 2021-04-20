package com.conciliacaocob.conciliacaoConciliador.controller;

import com.conciliacaocob.conciliacaoConciliador.services.EmissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class EmissorController {

    @Autowired
    EmissorService emissorService;

    @GetMapping(path = "listarEmissores")
    public ResponseEntity<?> listarEmissores() {
        return new ResponseEntity<>(emissorService.buscarTodos(), HttpStatus.OK);
    }


}
