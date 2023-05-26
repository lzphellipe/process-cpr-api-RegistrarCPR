package br.com.cooxupe.cpr.model.dto.controle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprControleErroDto {

	
	private BigDecimal idControleErroInt;
	private BigDecimal idControleCabInt;
	private BigDecimal numeroRevisao;
	private BigDecimal numeroLinha;
	private LocalDateTime dataRetorno;
	private String mensagemErro;
}
