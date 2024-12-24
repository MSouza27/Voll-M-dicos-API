package br.com.exercicio.voll.medico;

import br.com.exercicio.voll.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

/**
 * DTO usado para atualizar os dados de um médico.
 * Contém apenas os campos que podem ser alterados.
 */
public record DadosAtualizacoMedico(
        @NotNull Long id, // ID do médico a ser atualizado
        String telefone,
        String nome,
        DadosEndereco endereco
) {}

