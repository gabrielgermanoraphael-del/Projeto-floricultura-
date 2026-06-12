package edu.br.fiec.repository;

import edu.br.fiec.model.entity.Pedido; // Assumindo a existência da entidade Pedido
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface de repositório para a entidade Pedido.
 * Estende JpaRepository para fornecer operações CRUD básicas e funcionalidades de paginação e ordenação.
 *
 * A anotação @Repository indica que esta interface é um componente de repositório
 * do Spring, permitindo que o Spring a detecte e gerencie como um bean.
 *
 * JpaRepository<Pedido, Integer>:
 * - Pedido: A entidade com a qual este repositório irá trabalhar.
 * - Integer: O tipo do ID da entidade Pedido.
 *
 * Métodos de busca personalizados são adicionados aqui, seguindo as convenções
 * de nomenclatura do Spring Data JPA, que automaticamente gera a implementação
 * da consulta SQL com base no nome do método.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    /**
     * Busca pedidos associados a um cliente específico.
     * Assume que a entidade Pedido tem um relacionamento com Cliente e que o ID do cliente
     * pode ser acessado diretamente ou através de um campo como 'cliente.id'.
     * @param clienteId O ID do cliente.
     * @return Uma lista de pedidos feitos por aquele cliente.
     */
    List<Pedido> findByClienteId(Integer clienteId);

    /**
     * Busca pedidos por um determinado status.
     * Assume que a entidade Pedido tem um campo 'status' (ex: String ou Enum).
     * @param status O status do pedido (ex: "PENDENTE", "CONCLUIDO").
     * @return Uma lista de pedidos com o status especificado.
     */
    List<Pedido> findByStatus(String status);

    /**
     * Busca pedidos feitos dentro de um período de datas.
     * Assume que a entidade Pedido tem um campo 'dataPedido' do tipo LocalDate ou LocalDateTime.
     * @param dataInicio A data de início do período (inclusive).
     * @param dataFim A data de fim do período (inclusive).
     * @return Uma lista de pedidos feitos entre as datas especificadas.
     */
    List<Pedido> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);

    // Você pode adicionar mais métodos de busca aqui conforme a necessidade,
    // por exemplo: findByValorTotalGreaterThan(BigDecimal valor), etc.
}
