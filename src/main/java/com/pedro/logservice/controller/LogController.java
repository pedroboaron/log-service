package com.pedro.logservice.controller;

import com.pedro.logservice.event.RecursoCriadoEvent;
import com.pedro.logservice.model.Log;
import com.pedro.logservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private ApplicationEventPublisher publisher;


    @PostMapping
    public ResponseEntity<Log> save(@Valid @RequestBody Log log, HttpServletResponse response) {
        Log save = logService.save(log);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}