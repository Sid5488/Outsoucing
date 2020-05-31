package br.com.solcode.outsourcing.resources.estoque.computadores.custom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.computadores.custom.Periferico;
import br.com.solcode.outsourcing.repositories.computadores.custom.PerifericoRepository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/perifericos")
public class PerifericoResource {

    @Autowired
    private PerifericoRepository perifericoRepository;

    @GetMapping(value = "")
    public List<Periferico> getAllPerifericos() {
        return perifericoRepository.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Periferico postPeriferico(@Valid @RequestBody Periferico periferico) {
        return perifericoRepository.save(periferico);
    }

    @PutMapping(value = "/{id}")
    public void alterById(@PathVariable("id") Long id, @RequestBody Periferico periferico) {
        perifericoRepository.save(periferico);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        perifericoRepository.deleteById(id);
    }
}