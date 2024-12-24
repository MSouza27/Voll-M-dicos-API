package br.com.exercicio.voll.medico;

/**
 * DTO usado para exibir informações básicas de médicos na listagem.
 */
public record DadosListagemMedico(Long id, String nome, String telefone, String crm, Especialidade especialidade) {

    /**
     * Construtor que inicializa o record a partir de uma entidade Medico.
     */
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade());
    }
}
