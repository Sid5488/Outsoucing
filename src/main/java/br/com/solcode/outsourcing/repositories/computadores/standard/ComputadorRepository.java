package br.com.solcode.outsourcing.repositories.computadores.standard;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solcode.outsourcing.models.estoque.computadores.standard.Computador;

public interface ComputadorRepository extends JpaRepository<Computador, Long> {
    
}