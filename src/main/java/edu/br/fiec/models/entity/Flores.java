package edu.br.fiec.models.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "flores")
public class Flores {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String especie;

    private String estagio_Crescimento;

    private Double preco_unitario;

    private Integer longevidade;

    private String descricao;
}
