package br.com.solcode.outsourcing.repositories.notebooks;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solcode.outsourcing.models.estoque.notebooks.Notebook;

public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    
}