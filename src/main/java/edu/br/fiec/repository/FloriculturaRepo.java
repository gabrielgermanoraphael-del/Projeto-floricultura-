package edu.br.fiec.repository;

import jakarta.persistence.Id;

import java.util.Optional;

public interface FloriculturaRepo {

    Optional<Id>findbyId(Integer Id);




}
