package br.com.jeffpine.mercadinho.dto;

import lombok.Data;

@Data
public class NotaEntradaDto {
    private Long id;
    private String dataEntrada;
    private Double valorTotal;
    private Long fornecedorId;
}