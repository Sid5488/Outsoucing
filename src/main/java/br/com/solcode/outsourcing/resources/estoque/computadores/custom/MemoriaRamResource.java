package br.com.solcode.outsourcing.resources.estoque.computadores.custom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.computadores.custom.MemoriaRam;
import br.com.solcode.outsourcing.repositories.computadores.custom.MemoriaRamRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/memoriasram")
public class MemoriaRamResource {

    @Autowired
    private MemoriaRamRepository memoriaRamRepository;

    @GetMapping(value = "")
    public List<MemoriaRam> getAllMemoriasRam() {
        return memoriaRamRepository.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MemoriaRam insertMemoriaRam(@Valid @RequestBody MemoriaRam memoriaRam) {
        return memoriaRamRepository.save(memoriaRam);
    }

    @PutMapping(value = "/{id}")
    public void alterById(@PathVariable("id") Long id, @RequestBody MemoriaRam memoriaRam) {
        memoriaRamRepository.save(memoriaRam);
    }
    
    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        memoriaRamRepository.deleteById(id);
    }
}