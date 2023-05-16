package ufro.isoft.desafio1.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.isoft.desafio1.model.Camioneta;

import java.util.List;

@Repository
public interface CamionetaRepository extends CrudRepository<Camioneta, Integer> {
    List<Camioneta> findAll();
}