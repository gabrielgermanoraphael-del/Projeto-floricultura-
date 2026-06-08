package edu.br.fiec.service;

import edu.br.fiec.model.dto.FlorDTO;
import edu.br.fiec.repository.FloriculturaRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service

public class FloriculturaService {

    private final FloriculturaRepo floriculturaRepo;

    public FloriculturaService(FloriculturaRepo floriculturaRepo) {
        this.floriculturaRepo = floriculturaRepo;
    }

    public List<FlorDTO> listarTodos() {
        return floriculturaRepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collector.toList());
    }

}
