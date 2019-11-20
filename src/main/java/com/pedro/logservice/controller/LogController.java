package com.pedro.logservice.controller;

import com.pedro.logservice.event.RecursoCriadoEvent;
import com.pedro.logservice.model.Log;
import com.pedro.logservice.repository.CartaoUsuarioRepository;
import com.pedro.logservice.repository.PagamentoRepository;
import com.pedro.logservice.repository.UsuarioRepository;
import com.pedro.logservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private CartaoUsuarioRepository cartaoUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Log> save(@RequestParam("idCartaoUsuario") Integer idCartaoUsuario,
                                    @RequestParam("idRequisicao") Integer idRequisicao,
                                    @RequestParam("idUser") Integer idUser,
                                    @RequestParam("acao") String acao,
                                    HttpServletResponse response) {
        Log save = new Log();
        save.setCartaoUsuario(cartaoUsuarioRepository.findById(idCartaoUsuario).orElse(null));
        save.setPagamento(pagamentoRepository.findById(idRequisicao).orElse(null));
        save.setUser(usuarioRepository.findById(idUser).orElse(null));
        save.setAcao(acao);
        logService.save(save);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

}