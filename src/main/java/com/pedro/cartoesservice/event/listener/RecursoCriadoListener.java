package com.pedro.cartoesservice.event.listener;

import com.pedro.cartoesservice.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        String numero = recursoCriadoEvent.getNumero();

        adicionarHeaderLocation(response, numero);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, String numero) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{numero}")
                .buildAndExpand(numero).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }

}
