package edu.br.fiec.controller;

import edu.br.fiec.model.dto.ClienteDTO; // Assumindo a existência de ClienteDTO
import edu.br.fiec.model.entity.Cliente; // Assumindo a existência da entidade Cliente
import edu.br.fiec.service.ClienteService; // Assumindo a existência de ClienteService
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controlador REST para gerenciar operações relacionadas a Clientes.
 * Este controlador expõe endpoints para criar, ler, atualizar e deletar (CRUD) clientes,
 * além de buscas específicas.
 *
 * A anotação @RestController combina @Controller e @ResponseBody, indicando que
 * os métodos deste controlador retornam diretamente os dados (JSON, XML, etc.)
 * em vez de nomes de view.
 *
 * A anotação @AllArgsConstructor do Lombok gera um construtor com todos os campos,
 * facilitando a injeção de dependências (neste caso, ClienteService).
 *
 * A anotação @RequestMapping define o caminho base para todos os endpoints
 * neste controlador. Por exemplo, "/cliente" será o prefixo para todas as URLs.
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/cliente")
public class ClienteController {

    /**
     * Injeção de dependência do ClienteService.
     * O Spring injeta uma instância de ClienteService automaticamente no construtor
     * gerado pelo @AllArgsConstructor.
     * O Controller se comunica com a camada de Serviço para realizar a lógica de negócio.
     */
    private ClienteService clienteService;

    /**
     * Endpoint para criar um novo cliente.
     *
     * @PostMapping mapeia requisições HTTP POST para o caminho "/cliente".
     * O 'consumes = APPLICATION_JSON_VALUE' indica que este endpoint espera
     * um corpo de requisição no formato JSON.
     *
     * @ResponseStatus(HttpStatus.CREATED) define o código de status HTTP 201 (Created)
     * para a resposta em caso de sucesso.
     *
     * @RequestBody ClienteDTO clienteDTO: O Spring converte o corpo da requisição JSON
     * para um objeto ClienteDTO. Este DTO (Data Transfer Object) é usado para
     * receber os dados de entrada do cliente, evitando expor a entidade Cliente diretamente.
     *
     * Fluxo: Controller (recebe DTO) -> Service (converte DTO para Entidade, executa lógica)
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.criarCliente(clienteDTO);
    }

    /**
     * Endpoint para buscar todos os clientes.
     *
     * @GetMapping mapeia requisições HTTP GET para o caminho "/cliente".
     * O 'produces = APPLICATION_JSON_VALUE' indica que este endpoint retorna
     * um corpo de resposta no formato JSON.
     *
     * @ResponseStatus(HttpStatus.OK) define o código de status HTTP 200 (OK)
     * para a resposta em caso de sucesso.
     *
     * Retorna uma lista de objetos Cliente.
     *
     * Fluxo: Controller -> Service (busca dados) -> Controller (retorna lista de Entidades)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Cliente> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    /**
     * Endpoint para buscar um cliente por ID.
     *
     * @GetMapping(value = "/{id}") mapeia requisições HTTP GET para o caminho "/cliente/{id}".
     * O '{id}' é uma variável de caminho.
     *
     * @PathVariable Integer id: Extrai o valor do 'id' da URL e o injeta no parâmetro do método.
     *
     * Retorna um objeto Cliente.
     *
     * Fluxo: Controller (recebe ID da URL) -> Service (busca por ID) -> Controller (retorna Entidade)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Cliente buscarClientePorId(@PathVariable Integer id) {
        return clienteService.buscarClientePorId(id);
    }

    /**
     * Endpoint para atualizar um cliente existente.
     *
     * @PutMapping(value = "/{id}") mapeia requisições HTTP PUT para o caminho "/cliente/{id}".
     *
     * @PathVariable Integer id: O ID do cliente a ser atualizado.
     * @RequestBody ClienteDTO clienteDTO: Os novos dados do cliente.
     *
     * Fluxo: Controller (recebe ID e DTO) -> Service (atualiza cliente)
     */
    @ResponseStatus(HttpStatus.OK) // Ou HttpStatus.NO_CONTENT (204) se não retornar nada
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void atualizarCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.atualizarCliente(id, clienteDTO);
    }

    /**
     * Endpoint para deletar um cliente por ID.
     *
     * @DeleteMapping(value = "/{id}") mapeia requisições HTTP DELETE para o caminho "/cliente/{id}".
     *
     * @ResponseStatus(HttpStatus.NO_CONTENT) define o código de status HTTP 204 (No Content)
     * para a resposta em caso de sucesso, indicando que a requisição foi processada
     * com sucesso, mas não há conteúdo para retornar.
     *
     * Fluxo: Controller (recebe ID) -> Service (deleta cliente)
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
    }

    // --- Buscas Adicionais (Requisito: Pelo menos 3 buscas diferentes por controller) ---

    /**
     * Endpoint para buscar clientes por nome.
     *
     * @GetMapping(value = "/nome") mapeia requisições HTTP GET para o caminho "/cliente/nome".
     *
     * @RequestParam String nome: O nome do cliente a ser buscado, passado como parâmetro de query.
     * Ex: /cliente/nome?nome=Joao
     *
     * Retorna uma lista de objetos Cliente que correspondem ao nome.
     *
     * Fluxo: Controller (recebe nome) -> Service (busca por nome) -> Controller (retorna lista)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/nome", produces = APPLICATION_JSON_VALUE)
    public List<Cliente> buscarClientesPorNome(@RequestParam String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    /**
     * Endpoint para buscar clientes por email.
     *
     * @GetMapping(value = "/email") mapeia requisições HTTP GET para o caminho "/cliente/email".
     *
     * @RequestParam String email: O email do cliente a ser buscado.
     * Ex: /cliente/email?email=joao@example.com
     *
     * Retorna uma lista de objetos Cliente que correspondem ao email.
     *
     * Fluxo: Controller (recebe email) -> Service (busca por email) -> Controller (retorna lista)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/email", produces = APPLICATION_JSON_VALUE)
    public List<Cliente> buscarClientesPorEmail(@RequestParam String email) {
        return clienteService.buscarClientesPorEmail(email);
    }

    /**
     * Endpoint para buscar clientes que contenham um determinado termo no nome (busca parcial).
     *
     * @GetMapping(value = "/search") mapeia requisições HTTP GET para o caminho "/cliente/search".
     *
     * @RequestParam String termo: O termo a ser buscado no nome do cliente.
     * Ex: /cliente/search?termo=silva
     *
     * Retorna uma lista de objetos Cliente.
     *
     * Fluxo: Controller (recebe termo) -> Service (busca por termo no nome) -> Controller (retorna lista)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/search", produces = APPLICATION_JSON_VALUE)
    public List<Cliente> buscarClientesPorNomeContendo(@RequestParam String termo) {
        return clienteService.buscarClientesPorNomeContendo(termo);
    }
}
