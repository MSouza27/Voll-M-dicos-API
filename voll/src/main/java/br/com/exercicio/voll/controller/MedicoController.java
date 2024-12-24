package br.com.exercicio.voll.controller;

import br.com.exercicio.voll.medico.DadosAtualizacoMedico;
import br.com.exercicio.voll.medico.DadosCadastroMedico;
import br.com.exercicio.voll.medico.DadosListagemMedico;
import br.com.exercicio.voll.medico.Medico;
import br.com.exercicio.voll.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsável pelas operações relacionadas a médicos.
 * Define endpoints para cadastro, listagem, atualização e exclusão.
 */
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    /**
     * Endpoint para cadastrar um novo médico.
     * Recebe os dados via JSON, valida, e salva no banco de dados.
     */
    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    /**
     * Endpoint para listar médicos ativos com paginação.
     * Retorna apenas médicos cuja propriedade 'ativo' é verdadeira.
     */
    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    /**
     * Endpoint para atualizar informações de um médico existente.
     * Recebe os dados a serem atualizados e aplica as mudanças no banco de dados.
     */
    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosAtualizacoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    /**
     * Endpoint para excluir (desativar) um médico.
     * Marca o médico como inativo no banco de dados.
     */
    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
