package br.com.solcode.outsourcing.resources.estoque.computadores.standard;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.computadores.standard.Computador;
import br.com.solcode.outsourcing.repositories.computadores.standard.ComputadorRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/computadores")
public class ComputadorResource {
    
    @Autowired
    private ComputadorRepository computadorRepository;

    @GetMapping(value = "/")
    public List<Computador> getAll() {
        return computadorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Computador> computador = computadorRepository.findById(id);
    
        if (computador.isPresent()) {
            return ResponseEntity
                .ok()
                .body(computador);
        }

        return computador.isPresent() ? ResponseEntity.ok(computador.get())
				: ResponseEntity.notFound().build();
    }
    
    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Computador insert(@Valid @RequestBody Computador computador) {
        return computadorRepository.save(computador);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void alterById(@PathVariable("id") Long id, @Valid @RequestBody Computador computador) {
        computador.setId(id);
        computadorRepository.save(computador);
    }
}