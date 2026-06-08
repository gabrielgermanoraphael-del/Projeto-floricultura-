package edu.br.fiec.controller;

import edu.br.fiec.service.FloriculturaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Data
@Controller
@NoArgsConstructor
@AllArgsConstructor


public class FloriculturaController {

    private final FloriculturaService floriculturaService;



}