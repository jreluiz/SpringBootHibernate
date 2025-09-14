package br.cogna.SpringBootHibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

import br.cogna.SpringBootHibernate.model.Carro;
import br.cogna.SpringBootHibernate.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return carroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public List<Carro> buscarPorNome(@RequestParam String nome) {
        return carroService.buscarPorNome(nome);
    }
}
