package br.com.cooxupe.cpr.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cooxupe.cpr.model.CprControleParcelaModel;

@Repository
public interface CprControleParcelaRepository extends JpaRepository<CprControleParcelaModel, BigDecimal>{


    @Query(value="SELECT MAX(p.nr_revisao) "
			+ " FROM xcxp_cpr_controle_parcela_int p "
			+ " WHERE p.id_controle_cab_int = ?1",nativeQuery = true)
	Optional<BigDecimal> pesquisarUltimaRevisao(BigDecimal idControleCab);
	
	
	boolean existsParcelaByIdControleCabInt(BigDecimal idcontroleCab);

}
