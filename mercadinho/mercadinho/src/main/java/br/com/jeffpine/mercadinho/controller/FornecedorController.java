package br.com.jeffpine.mercadinho.controller;

import br.com.jeffpine.mercadinho.dto.FornecedorDto;
import br.com.jeffpine.mercadinho.model.Fornecedor;
import br.com.jeffpine.mercadinho.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorDto> listarFornecedores() {
        return fornecedorService.listarFornecedores().stream()
                .map(fornecedor -> {
                    FornecedorDto dto = new FornecedorDto();
                    dto.setId(fornecedor.getId());
                    dto.setNome(fornecedor.getNome());
                    dto.setCnpj(fornecedor.getCnpj());
                    dto.setEndereco(fornecedor.getEndereco());
                    return dto;
                }).collect(Collectors.toList());
    }

    @PostMapping
    public FornecedorDto salvarFornecedor(@RequestBody FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorDto.getNome());
        fornecedor.setCnpj(fornecedorDto.getCnpj());
        fornecedor.setEndereco(fornecedorDto.getEndereco());

        fornecedor = fornecedorService.salvarFornecedor(fornecedor);
        fornecedorDto.setId(fornecedor.getId());
        return fornecedorDto;
    }
}