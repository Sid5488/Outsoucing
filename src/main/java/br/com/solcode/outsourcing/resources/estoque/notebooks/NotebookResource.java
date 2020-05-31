package br.com.solcode.outsourcing.resources.estoque.notebooks;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.repositories.notebooks.NotebookRepository;
import br.com.solcode.outsourcing.models.estoque.notebooks.Notebook;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/notebooks")
public class NotebookResource {

    @Autowired
    private NotebookRepository notebookRepository;

    @GetMapping(value = "")
    public List<Notebook> getAllNotebooks() {
        return notebookRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Notebook> notebook = notebookRepository.findById(id);

        if (notebook.isPresent()) {
            return ResponseEntity
                .ok()
                .body(notebook);
        }

        return notebook.isPresent() ? ResponseEntity.ok(notebook.get())
				: ResponseEntity.notFound().build();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Notebook insert(@Valid @RequestBody Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    @PutMapping(value = "/{id}")
    public void alterById(@Valid @PathVariable("id") Long id, @RequestBody Notebook notebook) {
        notebook.setId(id);
        notebookRepository.save(notebook);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        notebookRepository.deleteById(id);
    }
}