package br.cogna.SpringBootHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.cogna.SpringBootHibernate.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}

