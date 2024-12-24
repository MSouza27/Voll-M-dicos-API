package br.com.exercicio.voll.medico;

// Importações necessárias para anotações e classes relacionadas
import br.com.exercicio.voll.endereco.Endereco; // Classe Endereco será usada como um atributo
import jakarta.persistence.*; // Anotações JPA para mapeamento de banco de dados
import jakarta.validation.Valid;
import lombok.*; // Lombok para reduzir código repetitivo

// Define o nome da tabela no banco de dados
@Table(name = "medicos")
// Declara que esta classe é uma entidade JPA que será mapeada no banco
@Entity(name = "Medico")
// Lombok: Gera equals e hashCode com base no campo "id"
@EqualsAndHashCode(of = {"id"})
public class Medico {

    // Declara que este campo é a chave primária
    @Id
    // Configura o identificador como auto incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos simples
    private String nome; // Nome do médico
    private String email; // Email do médico
    private String telefone;
    private String crm; // CRM do médico (registro profissional)

    // Enum que será armazenado como texto no banco
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    // Indica que a classe Endereco será embutida nesta entidade
    @Embedded
    private Endereco endereco;

    private boolean ativo;

    // Construtor que recebe um objeto DTO (DadosCadastroMedico) para inicializar os campos
    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome(); // Nome do médico
        this.email = dados.email(); // Email do médico
        this.telefone = dados.telefone();
        this.crm = dados.crm(); // CRM do médico
        this.endereco = new Endereco(dados.endereco()); // Inicializa um novo endereço com base nos dados
        this.especialidade = dados.especialidade(); // Especialidade médica
    }

    public Medico() {
    }

    public Medico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {
        this.ativo = true;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(DadosAtualizacoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

