package br.com.tiago.calculaimposto;

import br.com.tiago.calculaimposto.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }
