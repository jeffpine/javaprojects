package br.com.jeffpine.mercadinho.dto;

import lombok.Data;

@Data
public class VendaDto {
    private Long id;
    private String dataVenda;
    private Double valorTotal;
    private Long usuarioId;
}
