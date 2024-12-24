package br.com.exercicio.voll.endereco;

import jakarta.persistence.Embeddable;
import lombok.Getter;

/**
 * Classe que representa o endereço no banco de dados.
 * É uma entidade embutida em outras classes, como Medico.
 */
@Embeddable
@Getter
public class Endereco {

    private String logadouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    // Construtor padrão necessário para o JPA
    public Endereco() {}

    // Construtor que recebe dados individuais
    public Endereco(String logadouro, String bairro, String cep, String cidade, String uf, String numero, String complemento) {
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Construtor que inicializa a partir de um DTO (DadosEndereco)
    public Endereco(DadosEndereco dados) {
        this.logadouro = dados.logadouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    /**
     * Atualiza as informações do endereço com os dados fornecidos.
     */
    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logadouro() != null) this.logadouro = dados.logadouro();
        if (dados.bairro() != null) this.bairro = dados.bairro();
        if (dados.cep() != null) this.cep = dados.cep();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.uf() != null) this.uf = dados.uf();
        if (dados.numero() != null) this.numero = dados.numero();
        if (dados.complemento() != null) this.complemento = dados.complemento();
    }
}



