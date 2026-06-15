package edu.br.fiec.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlorDTO {

    private Integer id;

    private String nome;

    private String especie;

    private Double preco_unitario;

    private Integer longevidade;

    private String descricao;

}
