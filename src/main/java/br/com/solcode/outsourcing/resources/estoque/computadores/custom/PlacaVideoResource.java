package br.com.solcode.outsourcing.resources.estoque.computadores.custom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.models.estoque.computadores.custom.PlacaVideo;
import br.com.solcode.outsourcing.repositories.computadores.custom.PlacaVideoRepositories;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/placasvideo")
public class PlacaVideoResource {

    @Autowired
    private PlacaVideoRepositories placaVideoRepositories;

    @GetMapping(value = "")
    public List<PlacaVideo> getAllPlacaVideos() {
        return placaVideoRepositories.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PlacaVideo insertPlacaVideo(@Valid @RequestBody PlacaVideo placaVideo) {
        return placaVideoRepositories.save(placaVideo);
    }

    @PutMapping(value = "/{id}")
    public void alterById(@PathVariable("id") Long id, @RequestBody PlacaVideo placaVideo) {
        placaVideoRepositories.save(placaVideo);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        placaVideoRepositories.deleteById(id);
    }
}