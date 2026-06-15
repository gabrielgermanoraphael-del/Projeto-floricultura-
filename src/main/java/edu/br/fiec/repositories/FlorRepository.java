package edu.br.fiec.repositories;

import edu.br.fiec.models.entity.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface FlorRepository extends JpaRepository<Flores, Integer> { // Estende JpaRepository

    //o JPA automaticamente já adiciona a funcionalidade de FindByID

    List<Flores> findByEspecie(String especie);

    List<Flores> findByEstagioCrescimento(String estagioCrescimento);
}
