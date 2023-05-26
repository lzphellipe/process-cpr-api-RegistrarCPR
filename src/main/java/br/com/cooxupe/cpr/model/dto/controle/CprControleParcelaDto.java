package br.com.cooxupe.cpr.model.dto.controle;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprControleParcelaDto {
	
	private BigDecimal idControleParcelaInt;
	private BigDecimal idControleCabInt;
	private BigDecimal numeroRevisao;
	private BigDecimal numeroLinha;
	private BigDecimal idParcela;
	private BigDecimal numeroParcela;
	private LocalDate dataVencimentoParcela;
	private String status;

}
