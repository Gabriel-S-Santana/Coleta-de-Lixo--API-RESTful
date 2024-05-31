package br.com.fiap.residuos.dto;

import br.com.fiap.residuos.model.Agendamento;
import br.com.fiap.residuos.model.Usuario;
import br.com.fiap.residuos.model.UsuarioRole;


public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email) {
    public UsuarioExibicaoDTO(Usuario usuario) {
        this(usuario.getUsuarioId(), usuario.getNome(), usuario.getEmail());}
}
