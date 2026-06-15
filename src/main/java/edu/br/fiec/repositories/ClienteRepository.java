package edu.br.fiec.repositories;

import edu.br.fiec.models.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

    List<Clientes> findByNome(String nome);

    List<Clientes> findByEmail(String email);

    List<Clientes> findByCPF (Long cpf);

}
