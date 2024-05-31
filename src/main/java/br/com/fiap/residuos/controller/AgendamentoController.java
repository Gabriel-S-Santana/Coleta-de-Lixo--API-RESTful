package br.com.fiap.residuos.controller;

import br.com.fiap.residuos.dto.AgendamentoCadastroDTO;
import br.com.fiap.residuos.dto.AgendamentoExibicaoDTO;
import br.com.fiap.residuos.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agService;

    @PostMapping("/agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    private AgendamentoExibicaoDTO agendar( @RequestBody @Valid AgendamentoCadastroDTO agendamento){
        return agService.agendar(agendamento);
    }

    @PutMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    private AgendamentoExibicaoDTO atualizar( @RequestBody @Valid AgendamentoCadastroDTO agendamento){
        return agService.atualizarAgendamento(agendamento);
    }

    @GetMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public Page<AgendamentoExibicaoDTO> listarTodosOsAgendamentos(Pageable pagina) {
        return agService.listarTodosAgendamentos(pagina);
    }

    @GetMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibicaoDTO buscarAgendamentoPorId (@PathVariable Long id) {
        return agService.buscarAgendamentoPorId(id);
    }

    @RequestMapping(value = "/agendamentos", params = "diaColeta")
    @ResponseStatus(HttpStatus.OK)
    public List<AgendamentoExibicaoDTO> buscarAgendamentoPorData(@RequestParam LocalDate diaColeta) {
        return agService.buscarAgendamentoPorData(diaColeta);
    }

    @DeleteMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id) {
        agService.removerAgendamento(id);
    }

}
