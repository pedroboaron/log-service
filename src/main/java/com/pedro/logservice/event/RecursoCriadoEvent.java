package com.pedro.logservice.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private transient HttpServletResponse response;
    private Integer id;

    public HttpServletResponse getResponse() {
        return response;
    }

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Integer id) {
        super(source);
        this.response = response;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}