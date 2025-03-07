package com.generation.smartRh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.generation.smartRh.model.Funcionarios;


public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long>{
	
	 public List<Funcionarios> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	 

	 }
