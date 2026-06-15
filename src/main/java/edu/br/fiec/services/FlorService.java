package edu.br.fiec.services;

import edu.br.fiec.repositories.FlorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class FlorService {

    private final FlorRepository florRepo;


}
