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

import br.com.solcode.outsourcing.models.estoque.computadores.custom.Desktop;
import br.com.solcode.outsourcing.repositories.computadores.custom.DesktopRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/desktops")
public class DesktopResource {

    @Autowired
    private DesktopRepository desktopRepository;

    @GetMapping(value = "")
    public List<Desktop> getAllPlacaMaes() {
        return desktopRepository.findAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Desktop insertDesktop(@Valid @RequestBody Desktop desktop) {        
        return desktopRepository.save(desktop);
    }
    
    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void alterById(@PathVariable("id") Long id, @RequestBody Desktop desktop) {
        desktopRepository.save(desktop);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        desktopRepository.deleteById(id);
    }
}
