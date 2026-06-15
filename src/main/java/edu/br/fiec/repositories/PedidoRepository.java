package edu.br.fiec.repositories;

import edu.br.fiec.models.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {


    List<Pedidos> findByClienteId(Integer clienteId);


    List<Pedidos> findByStatus(String status);


    List<Pedidos> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);

}
