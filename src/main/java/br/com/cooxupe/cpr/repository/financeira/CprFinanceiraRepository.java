package br.com.cooxupe.cpr.repository.financeira;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cooxupe.cpr.model.financeira.CprFinanceiraModel;

@Repository
public interface CprFinanceiraRepository extends JpaRepository<CprFinanceiraModel, BigDecimal> {





}
