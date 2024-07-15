package br.com.jeffpine.mercadinho.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class NotaEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEntrada;
    private Double valorTotal;

    @ManyToOne
    private Fornecedor fornecedor;
}
