package br.com.jeffpine.mercadinho.dto;

import lombok.Data;

@Data
public class FornecedorDto {
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
}
