package br.com.solcode.outsourcing.resources.estoque.computadores.custom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.computadores.custom.PlacaMae;
import br.com.solcode.outsourcing.repositories.computadores.custom.PlacaMaeRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/placamaes")
public class PlacaMaeResource {

    @Autowired
    private PlacaMaeRepository placaMaeRepository;

    @GetMapping(value = "")
    public List<PlacaMae> getAllPlacaMaes() {
        return placaMaeRepository.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PlacaMae insertPlacaMae(@Valid @RequestBody PlacaMae placaMae) {        
        return placaMaeRepository.save(placaMae);
    }
    
    @PutMapping(value = "/{id}")
    public void alterById(@PathVariable("id") Long id, @RequestBody PlacaMae placaMae) {
        placaMaeRepository.save(placaMae);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        placaMaeRepository.deleteById(id);
    }
}
