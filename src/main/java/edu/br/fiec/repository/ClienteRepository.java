package edu.br.fiec.repository;

import edu.br.fiec.model.entity.Cliente; // Assumindo a existência da entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface de repositório para a entidade Cliente.
 * Estende JpaRepository para fornecer operações CRUD básicas e funcionalidades de paginação e ordenação.
 *
 * A anotação @Repository indica que esta interface é um componente de repositório
 * do Spring, permitindo que o Spring a detecte e gerencie como um bean.
 *
 * JpaRepository<Cliente, Integer>:
 * - Cliente: A entidade com a qual este repositório irá trabalhar.
 * - Integer: O tipo do ID da entidade Cliente.
 *
 * Métodos de busca personalizados são adicionados aqui, seguindo as convenções
 * de nomenclatura do Spring Data JPA, que automaticamente gera a implementação
 * da consulta SQL com base no nome do método.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    /**
     * Busca um cliente pelo nome exato.
     * @param nome O nome do cliente.
     * @return Uma lista de clientes que correspondem ao nome.
     */
    List<Cliente> findByNome(String nome);

    /**
     * Busca um cliente pelo email exato.
     * O Optional é usado para indicar que o cliente pode ou não ser encontrado.
     * @param email O email do cliente.
     * @return Um Optional contendo o cliente, se encontrado.
     */
    Optional<Cliente> findByEmail(String email);

    /**
     * Busca clientes cujo nome contenha o termo especificado (ignorando maiúsculas/minúsculas).
     * Útil para buscas parciais.
     * @param nome O termo a ser buscado no nome do cliente.
     * @return Uma lista de clientes que contêm o termo no nome.
     */
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    // Você pode adicionar mais métodos de busca aqui conforme a necessidade,
    // por exemplo: findByCpf(String cpf), findByTelefone(String telefone), etc.
}
