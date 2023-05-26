package br.com.cooxupe.cpr.repository.financeira;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cooxupe.cpr.model.financeira.EmissorModel;

@Repository
public interface EmissorRepository  extends JpaRepository<EmissorModel, BigDecimal>{

}
