package br.com.solcode.outsourcing.repositories.impressoras;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solcode.outsourcing.models.estoque.impressoras.Impressora;

public interface ImpressoraRepository extends JpaRepository<Impressora, Long> {
    
}