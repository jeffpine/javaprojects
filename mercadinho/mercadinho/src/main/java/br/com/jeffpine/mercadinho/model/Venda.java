package br.com.jeffpine.mercadinho.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataVenda;
    private Double valorTotal;

    @ManyToOne
    private Usuario usuario;
}
