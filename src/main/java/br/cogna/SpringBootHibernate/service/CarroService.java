package br.cogna.SpringBootHibernate.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;
import br.cogna.SpringBootHibernate.model.Carro;

@Service
public class CarroService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Carro> listarTodos() {
        String hql = "FROM Carro";
        return entityManager.createQuery(hql, Carro.class).getResultList();
    }
}

