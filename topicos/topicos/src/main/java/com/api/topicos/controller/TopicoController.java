package com.api.topicos.controller;

import com.api.topicos.model.Topico;
import com.api.topicos.service.TopicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    // Crear tópico
    @PostMapping
    public Topico crear(@RequestBody Topico topico) {
        return service.crearTopico(topico);
    }

    // Listar todos
    @GetMapping
    public List<Topico> listar() {
        return service.listarTopicos();
    }

    // Obtener uno
    @GetMapping("/{id}")
    public Optional<Topico> obtener(@PathVariable Long id) {
        return service.obtenerTopico(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Topico actualizar(@PathVariable Long id, @RequestBody Topico topico) {
        return service.actualizarTopico(id, topico);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarTopico(id);
    }
}