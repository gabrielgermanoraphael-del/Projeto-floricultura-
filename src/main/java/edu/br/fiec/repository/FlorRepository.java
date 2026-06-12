package edu.br.fiec.repository;

import edu.br.fiec.model.entity.Flores; // Importa a entidade Flores
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Para retornar listas de flores
import java.util.Optional;

/**
 * Interface de repositório para a entidade Flores.
 * Estende JpaRepository para fornecer operações CRUD básicas e funcionalidades de paginação e ordenação.
 *
 * A anotação @Repository indica que esta interface é um componente de repositório
 * do Spring, permitindo que o Spring a detecte e gerencie como um bean.
 *
 * JpaRepository<Flores, Integer>:
 * - Flores: A entidade com a qual este repositório irá trabalhar.
 * - Integer: O tipo do ID da entidade Flores.
 *
 * Métodos de busca personalizados são adicionados aqui, seguindo as convenções
 * de nomenclatura do Spring Data JPA, que automaticamente gera a implementação
 * da consulta SQL com base no nome do método.
 */
@Repository
public interface FlorRepository extends JpaRepository<Flores, Integer> { // Estende JpaRepository

    // O método findById(Integer id) já é fornecido pelo JpaRepository,
    // então não precisamos declará-lo explicitamente aqui, a menos que
    // queiramos sobrescrever seu comportamento ou adicionar uma query específica.

    /**
     * Busca flores por uma espécie específica.
     * Corresponde ao método buscarFloresPorEspecie no FloresController.
     * @param especie A espécie da flor.
     * @return Uma lista de flores que correspondem à espécie.
     */
    List<Flores> findByEspecie(String especie);

    /**
     * Busca flores por um estágio de crescimento específico.
     * Corresponde ao método buscarFloresPorEstagio no FloresController.
     * @param estagioCrescimento O estágio de crescimento da flor.
     * @return Uma lista de flores que correspondem ao estágio de crescimento.
     */
    List<Flores> findByEstagioCrescimento(String estagioCrescimento);

    // Você pode adicionar mais métodos de busca aqui conforme a necessidade,
    // por exemplo: findByCor(String cor), findByPrecoLessThan(BigDecimal preco), etc.
}
