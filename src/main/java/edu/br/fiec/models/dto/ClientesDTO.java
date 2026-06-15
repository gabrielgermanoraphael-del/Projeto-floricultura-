package edu.br.fiec.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesDTO {

    private String nome;

    private Long cpf;

    private String email;

    private  String telefone;

    private String endereco;

}
