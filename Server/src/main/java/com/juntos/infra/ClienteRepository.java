package com.juntos.infra;

import com.juntos.domain.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	@Query(value = "SELECT * FROM CLIENTES  limit 0,500;", countQuery = "select count(*) from Clientes", nativeQuery = true)
	List<Cliente> getAll();
	
	@Query(value = "SELECT * FROM CLIENTES cliente WHERE cliente.id = :id", countQuery="SELECT count(*) FROM CLIENTES cliente WHERE cliente.id = :id" ,nativeQuery = true)
	Cliente getById(@Param("id")long id);	
}
