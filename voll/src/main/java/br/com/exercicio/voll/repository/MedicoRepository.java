package br.com.exercicio.voll.repository;

import br.com.exercicio.voll.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    // Busca médicos pelo nome
    //List<Medico> findByNome(String nome);

    // Busca médicos pelo nome e especialidade
    //List<Medico> findByNomeAndEspecialidade(String nome, String especialidade);

    // Busca médicos por parte do nome (ignora maiúsculas/minúsculas)
    //List<Medico> findByNomeContainingIgnoreCase(String nome);

    // Busca médicos ordenados pelo nome (ascendente)
    //List<Medico> findAllByOrderByNomeAsc();

    // Busca médicos com CRM maior que um valor
    //List<Medico> findByCrmGreaterThan(String crm);

    // Busca médicos com especialidade na lista fornecida
    //List<Medico> findByEspecialidadeIn(List<String> especialidades);

    // Conta médicos por especialidade
    //long countByEspecialidade(String especialidade);

    // Verifica se existe um médico com um CRM específico
    //boolean existsByCrm(String crm);

    // Deleta médicos por nome
    //void deleteByNome(String nome);

    // Deleta médicos por especialidade
    //void deleteByEspecialidade(String especialidade);

    // Busca médicos com endereço em uma cidade específica
    //List<Medico> findByEnderecoCidade(String cidade);
}

