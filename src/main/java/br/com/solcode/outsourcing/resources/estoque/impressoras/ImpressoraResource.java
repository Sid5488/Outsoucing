package br.com.solcode.outsourcing.resources.estoque.impressoras;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.impressoras.Impressora;
import br.com.solcode.outsourcing.repositories.impressoras.ImpressoraRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/impressoras")
public class ImpressoraResource {

    @Autowired
    private ImpressoraRepository impressoraRepository;

    @GetMapping(value = "")
    public List<Impressora> getAllImpressoras() {
        return impressoraRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Impressora> impressora = impressoraRepository.findById(id);

        if (impressora.isPresent()) {
            return ResponseEntity
                .ok()
                .body(impressora);
        }

        return impressora.isPresent() ? ResponseEntity.ok(impressora.get())
				: ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Impressora insert(@Valid @RequestBody Impressora impressora) {
        return impressoraRepository.save(impressora);
    }
    
    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void alterById(@PathVariable("id") Long id, @Valid @RequestBody Impressora impressora) {
        impressora.setId(id);
        impressoraRepository.save(impressora);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        impressoraRepository.deleteById(id);
    }
}