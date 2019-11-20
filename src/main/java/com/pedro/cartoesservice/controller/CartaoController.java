package com.pedro.cartoesservice.controller;

import com.pedro.cartoesservice.event.RecursoCriadoEvent;
import com.pedro.cartoesservice.model.Cartao;
import com.pedro.cartoesservice.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

//    @Autowired
//    private CartaoUsuarioService cartaoUsuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<List<Cartao>> findByUser(@RequestParam("idUser") Integer idUser) {
    return ResponseEntity.ok(cartaoService.findByUser(idUser));
    }

    @PostMapping
    public ResponseEntity<Cartao> save(@RequestParam("idUser") Integer idUser,
                                       @Valid @RequestBody Cartao cartao,
                                       HttpServletResponse response) {
        Cartao save = cartaoService.save(cartao, idUser);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getNumero()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping
    public ResponseEntity<Cartao> alterarCartao(@RequestParam("idCartao") Integer idCartao,
                                                @RequestParam("idUser") Integer idUser,
                                                @Valid @RequestBody Cartao cartao,
                                                HttpServletResponse response) throws Exception {

        Cartao save = this.cartaoService.update(idCartao, idUser, cartao);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getNumero()));
        return ResponseEntity.ok(save);
    }

    @PatchMapping
    public ResponseEntity<Cartao> alterarStatus(@RequestParam("idCartao") Integer idCartao,
                                                @RequestParam("idUser") Integer idUser,
                                                @RequestParam("ativo") Boolean ativo,
                                                 HttpServletResponse response) throws Exception {

        Cartao cartao = this.cartaoService.findByIdCartaoAndIdUser(idCartao, idUser);
        cartao.setAtivo(ativo);
        Cartao save = this.cartaoService.update(idCartao, idUser, cartao);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getNumero()));
        return ResponseEntity.ok(save);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByNumero(@RequestParam("idCartao") Integer idCartao,
                                               @RequestParam("idUser") Integer idUser) throws Exception{

        this.cartaoService.deleteByNumero(idUser,this.cartaoService.findByIdCartaoAndIdUser(idCartao, idUser).getId());
        return ResponseEntity.noContent().build();
    }

}