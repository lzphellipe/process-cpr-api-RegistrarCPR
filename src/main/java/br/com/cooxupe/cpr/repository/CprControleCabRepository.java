package br.com.cooxupe.cpr.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cooxupe.cpr.model.CprControleCabModel;

@Repository
public interface CprControleCabRepository  extends JpaRepository<CprControleCabModel, BigDecimal>{

	Optional<CprControleCabModel>  findByNumeroCprAndOrganizacaoEmpresa(String cpr, String unidadeOperacionalString);
	
	
	
}
