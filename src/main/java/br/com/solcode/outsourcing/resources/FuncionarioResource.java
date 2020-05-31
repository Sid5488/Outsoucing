package br.com.solcode.outsourcing.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.DTO.FuncionarioDTO;
import br.com.solcode.outsourcing.exceptions.ValidationFormat;
import br.com.solcode.outsourcing.models.Funcionario;
import br.com.solcode.outsourcing.repositories.FuncionarioRepository;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private FuncionarioDTO dto = new FuncionarioDTO();

    @GetMapping(value = "")
    public List<FuncionarioDTO> getAll() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();

		return dto.toFuncionariosDTO(funcionarios);
    }

    @GetMapping("/{id}")
	public ResponseEntity<?> getEmpresa(@PathVariable Long id) {
		Optional<Funcionario> funcionarioProcurado = funcionarioRepository.findById(id);
		if(funcionarioProcurado.isPresent()) {
			FuncionarioDTO dtoProcurada = dto.toFuncionarioDTO(funcionarioProcurado.get());
			return ResponseEntity.ok().body(dtoProcurada);
		}
		
		return funcionarioProcurado.isPresent() ? ResponseEntity.ok(funcionarioProcurado.get())
				: ResponseEntity.notFound().build();
	}

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> insert(@Valid @RequestBody Funcionario funcionario, BindingResult bindingResult) {
		if (funcionarioRepository.existsByEmail(funcionario.getEmail())) {
			return ResponseEntity.badRequest().body(new JSONObject().put("message", "Email já em uso").toString());
			
		} else if(bindingResult.hasErrors()){
			return ResponseEntity.badRequest().body(ValidationFormat.formatarErros(bindingResult));
		} 
		else {
            funcionarioRepository.save(funcionario);
            
			return ResponseEntity.ok().body(new JSONObject()
					.put("message", "Funcionário cadastrado com sucesso!").toString());
		}
	}

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void alterById(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) {
		funcionario.setId(id);
        funcionarioRepository.save(funcionario);
    }
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        funcionarioRepository.deleteById(id);
    }
    
}