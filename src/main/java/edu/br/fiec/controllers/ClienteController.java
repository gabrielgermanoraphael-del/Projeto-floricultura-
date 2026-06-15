package edu.br.fiec.controllers;

import edu.br.fiec.models.entity.Clientes;
import edu.br.fiec.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//  A anotação @RestController combina @Controller e @ResponseBody, indicando que
// os métodos deste controlador retornam diretamente os dados (JSON, XML, etc.)* em vez de nomes de view.

//  A anotação @AllArgsConstructor do Lombok gera um construtor com todos os campos,
//  facilitando a injeção de dependências (neste caso, ClienteService).

//  A anotação @RequestMapping define o caminho base para todos os endpoints
//  neste controlador. Por exemplo, "/cliente" será o prefixo para todas as URLs.

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cliente")
public class ClienteController {

    //instancia do ClienteService permitida pelo @AllargsConstructor
    private ClienteService clienteService;


     //Fluxo: Controller (recebe DTO) -> Service (converte DTO para Entidade, executa lógica)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.criarCliente(clienteDTO);
    }


     //Fluxo: Controller -> Service (busca dados) -> Controller (retorna lista de Entidades)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Clientes> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }


    //Fluxo: Controller (recebe ID) -> Service (busca por ID) -> Controller (retorna Entidade)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Clientes buscarClientePorId(@RequestParam Integer id) {
        return clienteService.buscarClientePorId(id);
    }


     //Fluxo: Controller (recebe ID e DTO) -> Service (atualiza cliente)
    @ResponseStatus(HttpStatus.OK) // Ou HttpStatus.NO_CONTENT (204) se não retornar nada
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void atualizarCliente(@RequestParam Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.atualizarCliente(id, clienteDTO);
    }

    //fluxo: controller (recebe ID) -> service (Deleta o cliente por ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deletarCliente(@RequestParam Integer id) {
        clienteService.deletarCliente(id);
    }

    // --- Buscas Adicionais (Requisito: Pelo menos 3 buscas diferentes por controller) ---

    //Busca por Cliente espeficico por ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/nome", produces = APPLICATION_JSON_VALUE)
    public List<Clientes> buscarClientesPorNome(@RequestParam String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    //Busca por Cliente espeficico por ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/email", produces = APPLICATION_JSON_VALUE)
    public List<Clientes> buscarClientesPorEmail(@RequestParam String email) {
        return clienteService.buscarClientesPorEmail(email);
    }

    //Busca por Cliente espeficico por ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/cpf", produces = APPLICATION_JSON_VALUE)
    public List<Clientes> buscarClientesPorNomeContendo(@RequestParam Long cpf) {
        return clienteService.buscarClientesPorCPF(cpf);
    }
}
