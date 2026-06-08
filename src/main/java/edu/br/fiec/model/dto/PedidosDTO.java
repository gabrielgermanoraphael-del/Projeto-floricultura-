package edu.br.fiec.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidosDTO {

    private Double preco_total;

    private Integer quantidade;

    private Integer cliente_id;

    private String observacao;

}
