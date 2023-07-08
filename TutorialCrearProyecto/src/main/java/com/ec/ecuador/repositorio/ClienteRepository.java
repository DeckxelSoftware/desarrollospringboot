package com.ec.ecuador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.ecuador.entidad.Cliente;



@SuppressWarnings("unused")
@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Integer> {

}
