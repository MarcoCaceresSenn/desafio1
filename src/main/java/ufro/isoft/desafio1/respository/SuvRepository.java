package ufro.isoft.desafio1.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.isoft.desafio1.model.Suv;

import java.util.List;

@Repository
public interface SuvRepository extends CrudRepository<Suv, Integer> {
    List<Suv> findAll();
}

