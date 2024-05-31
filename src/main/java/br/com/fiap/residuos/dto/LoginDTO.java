package br.com.fiap.residuos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(
        @NotBlank(message = "O email do usuário é obrigatório")
        @Email(message = "O email do usuário não está em um formato válido!")
        String email,

        @NotBlank(message = "O campo de senha é obrigatório")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres")
        String senha
) {

}
