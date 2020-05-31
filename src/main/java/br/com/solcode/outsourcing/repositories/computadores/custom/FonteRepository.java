package br.com.solcode.outsourcing.repositories.computadores.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.solcode.outsourcing.models.estoque.computadores.custom.Fonte;

public interface FonteRepository extends JpaRepository<Fonte, Long>{
    
}