package hn.unah.lenguajes.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.models.Cliente;

public interface ClientesRepository extends CrudRepository<Cliente, Integer>{

}
