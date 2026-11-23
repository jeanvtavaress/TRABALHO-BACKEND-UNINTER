package com.loja.empadas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.loja.empadas.model.Empada;
import com.loja.empadas.repository.EmpadaRepository;

@Service
public class EmpadaService {

    private final EmpadaRepository repository;

    public EmpadaService(EmpadaRepository repository) {
        this.repository = repository;
    }

    public Empada criar(Empada empada) {
        empada.setId(null);
        if (empada.getDisponivel() == null) {
            empada.setDisponivel(true);
        }
        return repository.save(empada);
    }

    public List<Empada> listarTodas() {
        return repository.findAll();
    }

    public Optional<Empada> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Empada> atualizar(Long id, Empada dados) {
        return repository.findById(id).map(existente -> {
            existente.setSabor(dados.getSabor());
            existente.setPreco(dados.getPreco());
            existente.setQuantidadeEstoque(dados.getQuantidadeEstoque());
            if (dados.getDisponivel() != null) {
                existente.setDisponivel(dados.getDisponivel());
            }
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