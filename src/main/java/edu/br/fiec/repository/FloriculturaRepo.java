package edu.br.fiec.repository;


import edu.br.fiec.model.entity.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloriculturaRepo extends JpaRepository<Flores, Integer> {
}
