package br.com.fiap.residuos.service;

import br.com.fiap.residuos.dto.AgendamentoCadastroDTO;
import br.com.fiap.residuos.dto.AgendamentoExibicaoDTO;
import br.com.fiap.residuos.exception.UsuarioNaoEncontradoException;
import br.com.fiap.residuos.model.Agendamento;
import br.com.fiap.residuos.repository.AgendamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    //POST
    public AgendamentoExibicaoDTO agendar(AgendamentoCadastroDTO agendamentoDTO) {
        Agendamento agendamento = new Agendamento();
        BeanUtils.copyProperties(agendamentoDTO, agendamento);

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return new AgendamentoExibicaoDTO(agendamentoSalvo);
    }
    //PUT
    public AgendamentoExibicaoDTO atualizarAgendamento(AgendamentoCadastroDTO agendamentoDTO) {
        Agendamento agendamento = new Agendamento();
        BeanUtils.copyProperties(agendamentoDTO, agendamento);
        Optional<Agendamento> agendamentoBuscado = agendamentoRepository.findById(agendamento.getId());

        if (agendamentoBuscado.isPresent()) {
            Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
            return new AgendamentoExibicaoDTO(agendamentoSalvo);
        } else {
            throw new UsuarioNaoEncontradoException("Agendamento não pôde ser encontrado");
        }
    }
    //GET
    public Page<AgendamentoExibicaoDTO> listarTodosAgendamentos(Pageable paginacao) {
        return agendamentoRepository
                .findAll(paginacao)
                .map(AgendamentoExibicaoDTO::new);

    }
    //GET
    public AgendamentoExibicaoDTO buscarAgendamentoPorId(Long id) {
        Optional<Agendamento> agendamentoBuscado = agendamentoRepository.findById(id);
        if (agendamentoBuscado.isPresent()) {
            return new AgendamentoExibicaoDTO(agendamentoBuscado.get());
        }
        else {
            throw new UsuarioNaoEncontradoException("Agendamento não pôde ser encontrado");
        }
    }

    //GET
    public List<AgendamentoExibicaoDTO> buscarAgendamentoPorData(LocalDate diaColeta) {
        return agendamentoRepository.buscarPeloDiaColeta(diaColeta)
                .stream()
                .map(AgendamentoExibicaoDTO::new)
                .toList();
    }

    //DELETE
    public void removerAgendamento(Long id) {
        Optional<Agendamento> agendamentoBuscado = agendamentoRepository.findById(id);
        if (agendamentoBuscado.isPresent()) {
            agendamentoRepository.delete(agendamentoBuscado.get());
        } else {
            throw new UsuarioNaoEncontradoException("Agendamento não pôde ser encontrado");
        }
    }
}
