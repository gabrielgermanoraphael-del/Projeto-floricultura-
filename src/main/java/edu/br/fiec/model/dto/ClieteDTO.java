package edu.br.fiec.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClieteDTO {

    private String nome;

    private Long cpf;

    private String email;

    private  String telefone;

    private String endereco;

}
