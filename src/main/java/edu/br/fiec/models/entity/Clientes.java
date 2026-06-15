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


@Table(name = "cliente")
public class Clientes {


    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private Long cpf;

    private String email;

    private  String telefone;

    private String endereco;


}
