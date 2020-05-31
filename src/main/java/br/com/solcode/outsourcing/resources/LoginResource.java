package br.com.solcode.outsourcing.resources;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solcode.outsourcing.DTO.FuncionarioDTO;
import br.com.solcode.outsourcing.models.Funcionario;
import br.com.solcode.outsourcing.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private FuncionarioDTO dto = new FuncionarioDTO();

    @PostMapping
	private ResponseEntity<Object> login(@RequestBody Funcionario funcionario) {
		Optional<Funcionario> f = funcionarioRepository.findByemail(funcionario.getEmail());
		if (f.isPresent()) {
			if (funcionario.getSenha().equals(f.get().getSenha())) {

				// DTO para não retornar senha
				FuncionarioDTO dto2 = dto.toFuncionarioDTO(f.get());

				return ResponseEntity.ok()
						.body(new JSONObject()
						.put("message", "Logado como: " + dto2.getNome())
						.toString());
			} else {
				return ResponseEntity.badRequest()
						.body(new JSONObject()
						.put("message", "Login ou senha incorreta")
						.toString());
			}
		} else {
			ResponseEntity.notFound().build();
			return ResponseEntity.badRequest()
					.body(new JSONObject()
					.put("message", "E-mail não cadastrado")
					.toString());
		}
	}    
}