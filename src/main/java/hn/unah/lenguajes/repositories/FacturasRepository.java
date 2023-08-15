package hn.unah.lenguajes.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.models.Factura;

public interface FacturasRepository extends CrudRepository<Factura, Integer>{

}
