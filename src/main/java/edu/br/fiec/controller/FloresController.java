package edu.br.fiec.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/flor")

public class FloresController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "Flor", consumes = APPLICATION_JSON_VALUE)
    public void criarFlor(@ResponseBody ){}





}
