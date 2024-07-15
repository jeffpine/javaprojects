package br.com.jeffpine.mercadinho.controller;

import br.com.jeffpine.mercadinho.dto.VendaDto;
import br.com.jeffpine.mercadinho.model.Venda;
import br.com.jeffpine.mercadinho.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<VendaDto> listarVendas() {
        return vendaService.listarVendas().stream()
                .map(venda -> {
                    VendaDto dto = new VendaDto();
                    dto.setId(venda.getId());
                    dto.setDataVenda(venda.getDataVenda().toString());
                    dto.setValorTotal(venda.getValorTotal());
                    dto.setUsuarioId(venda.getUsuario().getId());
                    return dto;
                }).collect(Collectors.toList());
    }

    @PostMapping
    public VendaDto salvarVenda(@RequestBody VendaDto vendaDto) {
        Venda venda = new Venda();
        venda.setDataVenda(new Date(vendaDto.getDataVenda()));
        venda.setValorTotal(vendaDto.getValorTotal());
        // Set the user by fetching from the database using the provided ID
        // venda.setUsuario(usuarioService.findById(vendaDto.getUsuarioId()));

        venda = vendaService.salvarVenda(venda);
        vendaDto.setId(venda.getId());
        return vendaDto;
    }
}