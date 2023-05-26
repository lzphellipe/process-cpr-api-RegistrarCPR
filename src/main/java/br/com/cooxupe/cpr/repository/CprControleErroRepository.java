package br.com.cooxupe.cpr.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cooxupe.cpr.model.CprControleErroModel;

@Repository
public interface CprControleErroRepository extends JpaRepository<CprControleErroModel, BigDecimal>{

	@Query(value = "SELECT MAX(e.nr_revisao) "
			+ " FROM xcxp_cpr_controle_erro_int e "
			+ " WHERE e.id_controle_cab_int = ?1",nativeQuery = true)
	Optional<BigDecimal> pesquisarUltimaRevisao(BigDecimal idControleCab);
	
	
}
