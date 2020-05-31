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
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.impressoras.Suplemento;
import br.com.solcode.outsourcing.repositories.impressoras.SuplementoRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/impressoras/suplementos")
public class SuplementosResource {

    @Autowired
    private SuplementoRepository suplementosRepository;

    @GetMapping(value = "")
    public List<Suplemento> getAll(@RequestParam String param) {
        return suplementosRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Suplemento> suplemento = suplementosRepository.findById(id);

        if (suplemento.isPresent()) {
            return ResponseEntity
                .ok()
                .body(suplemento);
        }

        return suplemento.isPresent() ? ResponseEntity.ok(suplemento.get())
				: ResponseEntity.notFound().build();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Suplemento insert(@Valid @RequestBody Suplemento suplemento) {        
        return suplementosRepository.save(suplemento);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void alterById(@Valid @PathVariable("id") Long id, @RequestBody Suplemento suplemento) {
        suplemento.setId(id);
        suplementosRepository.save(suplemento);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        suplementosRepository.deleteById(id);
    }
    
    
}