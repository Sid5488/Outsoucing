package br.com.solcode.outsourcing.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.solcode.outsourcing.models.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncionarioDTO {

    private Long id;

    
    private String cpf;
    private String nome;

    public FuncionarioDTO() {}

    public FuncionarioDTO toFuncionarioDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();

        dto.setId(funcionario.getId());
        dto.setCpf(funcionario.getCpf());
        dto.setNome(funcionario.getNome());

        return dto;
    }


    public List<FuncionarioDTO> toFuncionariosDTO(List<Funcionario> funcionarios) {
        FuncionarioDTO dto = new FuncionarioDTO();
        
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();

        for (Funcionario funcionario: funcionarios) {
            funcionariosDTO.add(dto.toFuncionarioDTO(funcionario));
        }

        return funcionariosDTO;

    }
}