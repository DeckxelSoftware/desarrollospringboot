package com.ec.ecuador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.ecuador.entidad.Cliente;
import com.ec.ecuador.entidad.Seguimiento;



@SuppressWarnings("unused")
@Repository
public interface  SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {

}
