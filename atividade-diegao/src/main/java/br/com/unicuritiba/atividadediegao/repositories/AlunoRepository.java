package br.com.unicuritiba.atividadediegao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.atividadediegao.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}