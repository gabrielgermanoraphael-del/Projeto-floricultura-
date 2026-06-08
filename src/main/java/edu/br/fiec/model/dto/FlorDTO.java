package edu.br.fiec.model.dto;

import edu.br.fiec.model.entity.Clientes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository

public class FlorDTO {

    private Integer id;

    private String nome;

    private String especie;

    private Double preco_unitario;

    private Integer longevidade;

    private String descricao;

}
