package edu.br.fiec.controller;


import edu.br.fiec.model.dto.FlorDTO;
import edu.br.fiec.model.entity.Flores;
import edu.br.fiec.service.FlorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/flor")
public class FloresController {

    private FlorService florService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "Flor", consumes = APPLICATION_JSON_VALUE)
    public void criarFlor(@ResponseBody FlorDTO florDTO){
        florService.criarFlor(florDTO);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Flores", produces = APPLICATION_JSON_VALUE)
    public List<Flores> buscarTodasFlores(){
        return florService.buscarTodasFlores();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public Flores buscarFloresPorId(@RequestParam Integer id){
        return florService.buscarFloresPorId(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Especie", produces = APPLICATION_JSON_VALUE)
    public List<Flores> buscarFloresPorEspecie(@RequestParam String especie){
        return florService.buscarFloresPorespecie(especie);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "estagio_crescimento", produces = APPLICATION_JSON_VALUE)
    public List<Flores> buscarFloresPorEstagio(RequestParam String estagio_Crescimento){
        return florService.buscarFloresporEstagio(estagio)
    }





}
