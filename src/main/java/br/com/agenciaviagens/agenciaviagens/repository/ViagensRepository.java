package br.com.agenciaviagens.agenciaviagens.repository;

import br.com.agenciaviagens.agenciaviagens.model.Viagens;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViagensRepository extends CrudRepository<Viagens, Long> {
    List<Viagens> findByLocalContainingIgnoreCase(String local);
}
