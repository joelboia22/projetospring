package com.p2lp2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2lp2.dominio.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Integer> {

}
