package br.com.jeffpine.mercadinho.controller;

import br.com.jeffpine.mercadinho.dto.NotaEntradaDto;
import br.com.jeffpine.mercadinho.model.NotaEntrada;
import br.com.jeffpine.mercadinho.service.NotaEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notas-entrada")
public class NotaEntradaController {
    @Autowired
    private NotaEntradaService notaEntradaService;

    @GetMapping
    public List<NotaEntradaDto> listarNotasEntrada() {
        return notaEntradaService.listarNotasEntrada().stream()
                .map(notaEntrada -> {
                    NotaEntradaDto dto = new NotaEntradaDto();
                    dto.setId(notaEntrada.getId());
                    dto.setDataEntrada(notaEntrada.getDataEntrada().toString());
                    dto.setValorTotal(notaEntrada.getValorTotal());
                    dto.setFornecedorId(notaEntrada.getFornecedor().getId());
                    return dto;
                }).collect(Collectors.toList());
    }

    @PostMapping
    public NotaEntradaDto salvarNotaEntrada(@RequestBody NotaEntradaDto notaEntradaDto) {
        NotaEntrada notaEntrada = new NotaEntrada();
        notaEntrada.setDataEntrada(new Date(notaEntradaDto.getDataEntrada()));
        notaEntrada.setValorTotal(notaEntradaDto.getValorTotal());
        // Set the supplier by fetching from the database using the provided ID
        // notaEntrada.setFornecedor(fornecedorService.findById(notaEntradaDto.getFornecedorId()));

        notaEntrada = notaEntradaService.salvarNotaEntrada(notaEntrada);
        notaEntradaDto.setId(notaEntrada.getId());
        return notaEntradaDto;
    }
}