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

import br.com.solcode.outsourcing.models.estoque.computadores.custom.PlacaRede;
import br.com.solcode.outsourcing.repositories.computadores.custom.PlacaRedeRepository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/placasrede")
public class PlacaRedeResource {

    @Autowired
    private PlacaRedeRepository placaRedeRepository;

    @GetMapping(value = "")
    public List<PlacaRede> getAllPlacasRede() {
        return placaRedeRepository.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PlacaRede insertPlacaRede(@Valid @RequestBody PlacaRede placaRede) {        
        return placaRedeRepository.save(placaRede);
    }

    @PutMapping(value="/{id}")
    public void alterById(@PathVariable("id") Long id, @RequestBody PlacaRede placaRede) {
        placaRedeRepository.save(placaRede);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        placaRedeRepository.deleteById(id);
    }
}