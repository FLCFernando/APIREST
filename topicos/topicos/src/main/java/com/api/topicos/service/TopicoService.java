package com.api.topicos.service;

import com.api.topicos.model.Topico;
import com.api.topicos.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico crearTopico(Topico topico) {
        return repository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return repository.findAll();
    }

    public Optional<Topico> obtenerTopico(Long id) {
        return repository.findById(id);
    }

    public Topico actualizarTopico(Long id, Topico datos) {
        Topico topico = repository.findById(id).orElseThrow();

        topico.setTitulo(datos.getTitulo());
        topico.setMensaje(datos.getMensaje());
        topico.setAutor(datos.getAutor());
        topico.setCurso(datos.getCurso());

        return repository.save(topico);
    }

    public void eliminarTopico(Long id) {
        repository.deleteById(id);
    }
}