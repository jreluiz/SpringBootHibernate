package br.cogna.SpringBootHibernate.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;
import br.cogna.SpringBootHibernate.model.Carro;
import br.cogna.SpringBootHibernate.repository.CarroRepository;
import java.util.Optional;

@Service
public class CarroService {
    @PersistenceContext
    private EntityManager entityManager;
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarTodos() {
        String hql = "FROM Carro";
        return entityManager.createQuery(hql, Carro.class).getResultList();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> buscarPorNome(String nome) {
        return carroRepository.findByNome(nome);
    }
}
