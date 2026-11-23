package com.loja.empadas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.loja.empadas.model.Cliente;
import com.loja.empadas.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Cliente> atualizar(Long id, Cliente dados) {
        return repository.findById(id).map(existente -> {
            existente.setNome(dados.getNome());
            existente.setEmail(dados.getEmail());
            existente.setTelefone(dados.getTelefone());
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