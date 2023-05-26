package br.com.cooxupe.cpr.model.financeira.registro;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelaDto {
	
	@JsonProperty("data_vencimento_parcela")
	private String dataVencimentoParcela;
	@JsonProperty("id_parcela")
	private Long idParcela;
	@JsonProperty("numero_parcela")
	private Long numeroParcela;
	@JsonProperty("preco_cessao_parcela")
	private BigDecimal precoCessaoParcela;	
	private String status;

}
