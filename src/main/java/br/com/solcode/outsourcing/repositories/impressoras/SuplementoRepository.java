package br.com.solcode.outsourcing.repositories.impressoras;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solcode.outsourcing.models.estoque.impressoras.Suplemento;

public interface SuplementoRepository extends JpaRepository<Suplemento, Long> {
    
}
