package edu.br.fiec.repository;

import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlorRepo {

    Optional<Id>findbyId(Integer Id);




}
