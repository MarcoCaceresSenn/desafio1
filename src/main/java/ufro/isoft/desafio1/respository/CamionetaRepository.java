package ufro.isoft.desafio1.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ufro.isoft.desafio1.model.Camioneta;

import java.util.List;

@Repository
public interface CamionetaRepository extends CrudRepository<Camioneta, Integer> {
    List<Camioneta> findAll();

    List<Camioneta> findAllByColor(String color);

    List<Camioneta> findAllByPrecio(String precio);

    List<Camioneta> findAllByTipoAndColorAndPrecio(String tipo,String color, String precio);

    List<Camioneta> findAllByTipoAndColor(String tipo,String color);

    List<Camioneta> findAllByTipoAndPrecio(String tipo,String precio);

    
}