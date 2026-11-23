package com.loja.empadas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.loja.empadas.model.Produto;
import com.loja.empadas.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Produto> atualizar(Long id, Produto dados) {
        return repository.findById(id).map(existente -> {
            existente.setNome(dados.getNome());
            existente.setPreco(dados.getPreco());
            existente.setQuantidadeEstoque(dados.getQuantidadeEstoque());
            return repository.save(existente);
        });
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}