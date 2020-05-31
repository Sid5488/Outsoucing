package br.com.solcode.outsourcing.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solcode.outsourcing.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional <Funcionario> findByemail(String email);
	Boolean existsByEmail(String email);
}