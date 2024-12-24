package br.com.exercicio.voll.medico;

// Importa o registro DadosEndereco para compor os dados do médico
import br.com.exercicio.voll.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Registro usado como DTO para transferir dados ao cadastrar um médico
public record DadosCadastroMedico(

        @NotBlank
        String nome, // Nome do médico

        @NotBlank
        @Email
        String email, // Email do médico

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm, // CRM do médico

        @NotNull
        Especialidade especialidade, // Enum representando a especialidade

        @NotNull @Valid DadosEndereco endereco // Dados do endereço do médico
) {
    // A classe record já possui métodos como equals, hashCode e toString gerados automaticamente
}

