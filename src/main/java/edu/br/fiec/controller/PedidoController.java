package edu.br.fiec.controller;

import edu.br.fiec.model.dto.PedidoDTO; // Assumindo a existência de PedidoDTO
import edu.br.fiec.model.entity.Pedido; // Assumindo a existência da entidade Pedido
import edu.br.fiec.service.PedidoService; // Assumindo a existência de PedidoService
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate; // Para buscas por data
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controlador REST para gerenciar operações relacionadas a Pedidos.
 * Este controlador expõe endpoints para criar, ler, atualizar e deletar (CRUD) pedidos,
 * além de buscas específicas.
 *
 * A anotação @RestController combina @Controller e @ResponseBody, indicando que
 * os métodos deste controlador retornam diretamente os dados (JSON, XML, etc.)
 * em vez de nomes de view.
 *
 * A anotação @AllArgsConstructor do Lombok gera um construtor com todos os campos,
 * facilitando a injeção de dependências (neste caso, PedidoService).
 *
 * A anotação @RequestMapping define o caminho base para todos os endpoints
 * neste controlador. Por exemplo, "/pedido" será o prefixo para todas as URLs.
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/pedido")
public class PedidoController {

    /**
     * Injeção de dependência do PedidoService.
     * O Spring injeta uma instância de PedidoService automaticamente no construtor
     * gerado pelo @AllArgsConstructor.
     * O Controller se comunica com a camada de Serviço para realizar a lógica de negócio.
     */
    private PedidoService pedidoService;

    /**
     * Endpoint para criar um novo pedido.
     *
     * @PostMapping mapeia requisições HTTP POST para o caminho "/pedido".
     * O 'consumes = APPLICATION_JSON_VALUE' indica que este endpoint espera
     * um corpo de requisição no formato JSON.
     *
     * @ResponseStatus(HttpStatus.CREATED) define o código de status HTTP 201 (Created)
     * para a resposta em caso de sucesso.
     *
     * @RequestBody PedidoDTO pedidoDTO: O Spring converte o corpo da requisição JSON
     * para um objeto PedidoDTO. Este DTO (Data Transfer Object) é usado para
     * receber os dados de entrada do pedido, evitando expor a entidade Pedido diretamente.
     *
     * Fluxo: Controller (recebe DTO) -> Service (converte DTO para Entidade, executa lógica)
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoService.criarPedido(pedidoDTO);
    }

    /**
     * Endpoint para buscar todos os pedidos.
     *
     * @GetMapping mapeia requisições HTTP GET para o caminho "/pedido".
     * O 'produces = APPLICATION_JSON_VALUE' indica que este endpoint retorna
     * um corpo de resposta no formato JSON.
     *
     * @ResponseStatus(HttpStatus.OK) define o código de status HTTP 200 (OK)
     * para a resposta em caso de sucesso.
     *
     * Retorna uma lista de objetos Pedido.
     *
     * Fluxo: Controller -> Service (busca dados) -> Controller (retorna lista de Entidades)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Pedido> buscarTodosPedidos() {
        return pedidoService.buscarTodosPedidos();
    }

    /**
     * Endpoint para buscar um pedido por ID.
     *
     * @GetMapping(value = "/{id}") mapeia requisições HTTP GET para o caminho "/pedido/{id}".
     * O '{id}' é uma variável de caminho.
     *
     * @PathVariable Integer id: Extrai o valor do 'id' da URL e o injeta no parâmetro do método.
     *
     * Retorna um objeto Pedido.
     *
     * Fluxo: Controller (recebe ID da URL) -> Service (busca por ID) -> Controller (retorna Entidade)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Pedido buscarPedidoPorId(@PathVariable Integer id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    /**
     * Endpoint para atualizar um pedido existente.
     *
     * @PutMapping(value = "/{id}") mapeia requisições HTTP PUT para o caminho "/pedido/{id}".
     *
     * @PathVariable Integer id: O ID do pedido a ser atualizado.
     * @RequestBody PedidoDTO pedidoDTO: Os novos dados do pedido.
     *
     * Fluxo: Controller (recebe ID e DTO) -> Service (atualiza pedido)
     */
    @ResponseStatus(HttpStatus.OK) // Ou HttpStatus.NO_CONTENT (204) se não retornar nada
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void atualizarPedido(@PathVariable Integer id, @RequestBody PedidoDTO pedidoDTO) {
        pedidoService.atualizarPedido(id, pedidoDTO);
    }

    /**
     * Endpoint para deletar um pedido por ID.
     *
     * @DeleteMapping(value = "/{id}") mapeia requisições HTTP DELETE para o caminho "/pedido/{id}".
     *
     * @ResponseStatus(HttpStatus.NO_CONTENT) define o código de status HTTP 204 (No Content)
     * para a resposta em caso de sucesso, indicando que a requisição foi processada
     * com sucesso, mas não há conteúdo para retornar.
     *
     * Fluxo: Controller (recebe ID) -> Service (deleta pedido)
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deletarPedido(@PathVariable Integer id) {
        pedidoService.deletarPedido(id);
    }

    // --- Buscas Adicionais (Requisito: Pelo menos 3 buscas diferentes por controller) ---

    /**
     * Endpoint para buscar pedidos por ID do cliente.
     *
     * @GetMapping(value = "/cliente/{clienteId}") mapeia requisições HTTP GET para o caminho "/pedido/cliente/{clienteId}".
     *
     * @PathVariable Integer clienteId: O ID do cliente para buscar seus pedidos.
     * Ex: /pedido/cliente/1
     *
     * Retorna uma lista de objetos Pedido associados ao cliente.
     *
     * Fluxo: Controller (recebe clienteId) -> Service (busca por clienteId) -> Controller (retorna lista)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/cliente/{clienteId}", produces = APPLICATION_JSON_VALUE)
    public List<Pedido> buscarPedidosPorClienteId(@PathVariable Integer clienteId) {
        return pedidoService.buscarPedidosPorClienteId(clienteId);
    }

    /**
     * Endpoint para buscar pedidos por status.
     *
     * @GetMapping(value = "/status") mapeia requisições HTTP GET para o caminho "/pedido/status".
     *
     * @RequestParam String status: O status do pedido a ser buscado (ex: "PENDENTE", "CONCLUIDO").
     * Ex: /pedido/status?status=PENDENTE
     *
     * Retorna uma lista de objetos Pedido que correspondem ao status.
     *
     * Fluxo: Controller (recebe status) -> Service (busca por status) -> Controller (retorna lista)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/status", produces = APPLICATION_JSON_VALUE)
    public List<Pedido> buscarPedidosPorStatus(@RequestParam String status) {
        return pedidoService.buscarPedidosPorStatus(status);
    }

    /**
     * Endpoint para buscar pedidos feitos entre duas datas.
     *
     * @GetMapping(value = "/data") mapeia requisições HTTP GET para o caminho "/pedido/data".
     *
     * @RequestParam LocalDate dataInicio: A data de início do período.
     * @RequestParam LocalDate dataFim: A data de fim do período.
     * Ex: /pedido/data?dataInicio=2023-01-01&dataFim=2023-12-31
     *
     * Retorna uma lista de objetos Pedido.
     *
     * Fluxo: Controller (recebe datas) -> Service (busca por período) -> Controller (retorna lista)
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/data", produces = APPLICATION_JSON_VALUE)
    public List<Pedido> buscarPedidosEntreDatas(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        return pedidoService.buscarPedidosEntreDatas(dataInicio, dataFim);
    }
}
