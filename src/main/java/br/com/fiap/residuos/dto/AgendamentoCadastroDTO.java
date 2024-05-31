package br.com.fiap.residuos.dto;

import br.com.fiap.residuos.model.Agendamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AgendamentoCadastroDTO (
        Long id,
        @NotNull(message = "O dia da coleta é obrigatório!")
        LocalDate diaColeta,
        @NotBlank(message = "O endereço é obrigatório!")
        String endereco,
        @NotNull(message = "O numero da residência é obrigatório!")
        Long numero,
        @NotNull(message = "O token é obrigatório")
        Long token
) {
    public AgendamentoCadastroDTO(Agendamento agendamento) {
        this(agendamento.getId(), agendamento.getDiaColeta(), agendamento.getEndereco(), agendamento.getNumero(), agendamento.getToken());
    }
}

