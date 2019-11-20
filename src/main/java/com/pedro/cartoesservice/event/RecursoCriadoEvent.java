package com.pedro.cartoesservice.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private transient HttpServletResponse response;
    private String numero;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, String numero) {
        super(source);
        this.response = response;
        this.numero = numero;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public String getNumero() {
        return numero;
    }
}