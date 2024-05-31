package br.com.fiap.residuos.dto;

import br.com.fiap.residuos.model.Agendamento;

import java.time.LocalDate;

public record AgendamentoExibicaoDTO(
        Long id,
        LocalDate diaColeta,
        String endereco,
        Long numero
)
{
    public AgendamentoExibicaoDTO (Agendamento agendamento) {
        this(agendamento.getId(), agendamento.getDiaColeta(), agendamento.getEndereco(), agendamento.getNumero());
    }
}

