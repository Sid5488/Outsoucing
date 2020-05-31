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

import br.com.solcode.outsourcing.models.estoque.computadores.custom.Fonte;
import br.com.solcode.outsourcing.repositories.computadores.custom.FonteRepository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/fontes")
public class FonteResource {

    @Autowired
    private FonteRepository fonteRepository;

    @GetMapping(value = "")
    public List<Fonte> getAlFontes() {
        return fonteRepository.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Fonte insertFonte(@Valid @RequestBody Fonte fonte) {
        return fonteRepository.save(fonte);
    }

    @PutMapping(value = "/{id}")
    public void alterById(@Valid @PathVariable("id") Long id, @RequestBody Fonte fonte) {
        fonteRepository.save(fonte);
    }
    
    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        fonteRepository.deleteById(id);
    }

}