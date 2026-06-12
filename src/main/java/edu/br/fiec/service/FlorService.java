package edu.br.fiec.service;

import edu.br.fiec.model.dto.FlorDTO;
import edu.br.fiec.repository.FlorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;

@Service
@AllArgsConstructor

public class FlorService {

    private final FlorRepository florRepo;

    public List<FlorDTO> listarTodos() {
        return florRepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collector.toList());
    }

}
