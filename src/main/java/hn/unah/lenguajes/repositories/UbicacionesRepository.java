package hn.unah.lenguajes.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.models.Direccion;
import hn.unah.lenguajes.models.Ubicacion;

public interface UbicacionesRepository extends CrudRepository<Ubicacion, Integer>{

}
