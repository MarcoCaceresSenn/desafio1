package ufro.isoft.desafio1.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.isoft.desafio1.model.Suv;

import java.util.List;

@Repository
public interface SuvRepository extends CrudRepository<Suv, Integer> {
    List<Suv> findAll();

    List<Suv> findAllByColor(String color);

    List<Suv> findAllByPrecio(String precio);

    List<Suv> findAllByTipoAndColorAndPrecio(String tipo,String color, String precio);

    List<Suv> findAllByTipoAndColor(String tipo,String color);

    List<Suv> findAllByTipoAndPrecio(String tipo,String precio);
}

