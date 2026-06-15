package edu.br.fiec.controllers;


import edu.br.fiec.models.dto.FlorDTO;
import edu.br.fiec.models.entity.Flores;
import edu.br.fiec.services.FlorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/flor")
public class FloresController {

    private FlorService florService;


    //cria uma nova flor
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "Flores", consumes = APPLICATION_JSON_VALUE)
    public void criarFlor(@RequestBody FlorDTO florDTO){
        florService.criarFlor(florDTO);
    }


    //retorna todas as entidades
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Flores", produces = APPLICATION_JSON_VALUE)
    public List<Flores> buscarTodasFlores(){
        return florService.buscarTodasFlores();

    }

    //atualiza uma entidade por ID
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void atualizarFlores(@RequestParam Integer id, @RequestBody FlorDTO florDTO){
        florService.atualizarFlor(id, florDTO);
    }


    //deleta uma entidade por ID

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deletarFlor(@RequestParam Integer id){
        florService.deletarFlor(id);
    }



    //Buscas adicionais:

    //retorna uma entidade especifica por id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public Flores buscarFloresPorId(@RequestParam Integer id){ // Corrigido para @PathVariable
        return florService.buscarFloresPorId(id);
    }

    //retorna uma entidade especifica por especie
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Especie", produces = APPLICATION_JSON_VALUE)
    public List<Flores> buscarFloresPorEspecie(@RequestParam String especie){
        return florService.buscarFloresPorespecie(especie);
    }

    //fluxo: retorna uma entidade especifica por estagio
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "estagio_crescimento", produces = APPLICATION_JSON_VALUE)
    public List<Flores> buscarFloresPorEstagio(@RequestParam String estagio_Crescimento){ //

        return florService.buscarFloresPorEstagio(estagio_Crescimento);
    }

}
