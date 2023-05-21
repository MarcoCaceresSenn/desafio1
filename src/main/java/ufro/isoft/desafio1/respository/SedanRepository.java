package ufro.isoft.desafio1.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.isoft.desafio1.model.Sedan;

import java.util.List;

@Repository
public interface SedanRepository extends CrudRepository<Sedan, Integer> {
    List<Sedan> findAll();

    List<Sedan> findAllByColor(String color);

    List<Sedan> findAllByPrecio(String precio);

    List<Sedan> findAllByTipoAndColorAndPrecio(String tipo,String color, String precio);

    List<Sedan> findAllByTipoAndColor(String tipo,String color);

    List<Sedan> findAllByTipoAndPrecio(String tipo,String precio);

}
