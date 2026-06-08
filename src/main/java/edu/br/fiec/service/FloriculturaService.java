package edu.br.fiec.service;

import edu.br.fiec.model.entity.Flores;
import edu.br.fiec.repository.FloriculturaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FloriculturaService {

    private final FloriculturaRepo floriculturaRepo;

    public void create(Flores flores) {
        floriculturaRepo.save(flores);
    }

}
