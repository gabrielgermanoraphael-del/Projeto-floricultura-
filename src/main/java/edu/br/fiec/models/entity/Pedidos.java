package edu.br.fiec.models.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "pedidos")
public class Pedidos {

    @id
    @GeneratedValue
    private Integer id;

    private Double preco_total;

    private Integer quantidade;

    private Integer cliente_id;

    private String observacao;

    private String status;


}
