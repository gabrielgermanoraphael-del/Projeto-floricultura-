package edu.br.fiec.controllers;

import edu.br.fiec.models.dto.PedidosDTO;
import edu.br.fiec.models.entity.Pedidos;
import edu.br.fiec.services.PedidosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/pedido")
public class PedidoController {

//    /**
//     * Injeção de dependência do PedidoService.
//     * O Spring injeta uma instância de PedidoService automaticamente no construtor
//     * gerado pelo @AllArgsConstructor.
//     * O Controller se comunica com a camada de Serviço para realizar a lógica de negócio.
//     */
    private PedidoService pedidoService;


//     * Fluxo: Controller (recebe DTO) -> Service (converte DTO para Entidade, executa lógica)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarPedido(@RequestBody PedidosDTO pedidoDTO) {
        pedidoService.criarPedido(pedidoDTO);
    }


//     * Fluxo: Controller -> Service (busca dados) -> Controller (retorna lista de Entidades)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Pedidos> buscarTodosPedidos() {
        return pedidoService.buscarTodosPedidos();
    }


//     * Fluxo: Controller (recebe ID da URL) -> Service (busca por ID) -> Controller (retorna Entidade)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Pedidos buscarPedidoPorId(@RequestParam Integer id) {
        return pedidoService.buscarPedidoPorId(id);
    }


//     * Fluxo: Controller (recebe ID e DTO) -> Service (atualiza pedido)
    @ResponseStatus(HttpStatus.OK) // Ou HttpStatus.NO_CONTENT (204) se não retornar nada
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void atualizarPedido(@RequestParam Integer id, @RequestBody PedidosDTO pedidosDTO) {
        pedidoService.atualizarPedido(id, pedidosDTO);
    }



//     * Fluxo: Controller (recebe ID) -> Service (deleta pedido)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deletarPedido(@RequestParam Integer id) {
        pedidoService.deletarPedido(id);
    }



    // --- Buscas Adicionais ---


//     * Fluxo: Controller (recebe clienteId) -> Service (busca por clienteId) -> Controller (retorna lista)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/cliente/{clienteId}", produces = APPLICATION_JSON_VALUE)
    public List<Pedidos> buscarPedidosPorClienteId(@RequestParam Integer clienteId) {
        return pedidoService.buscarPedidosPorClienteId(clienteId);
    }


//     * Fluxo: Controller (recebe status) -> Service (busca por status) -> Controller (retorna lista)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/status", produces = APPLICATION_JSON_VALUE)
    public List<Pedidos> buscarPedidosPorStatus(@RequestParam String status) {
        return pedidoService.buscarPedidosPorStatus(status);
    }

//     * Fluxo: Controller (recebe datas) -> Service (busca por período) -> Controller (retorna lista)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/data", produces = APPLICATION_JSON_VALUE)
    public List<Pedidos> buscarPedidosEntreDatas(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        return pedidoService.buscarPedidosEntreDatas(dataInicio, dataFim);
    }
}
