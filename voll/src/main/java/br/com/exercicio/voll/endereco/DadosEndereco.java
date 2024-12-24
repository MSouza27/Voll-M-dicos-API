package br.com.exercicio.voll.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Record que representa os dados de um endereço.
 * Usado como DTO para transferir informações entre as camadas.
 */
public record DadosEndereco(
        @NotBlank String logadouro,
        @NotBlank String bairro,
        @NotBlank @Pattern(regexp = "\\d{8}") String cep,
        @NotBlank String cidade,
        @NotBlank String uf,
        String numero,
        String complemento
) {}
