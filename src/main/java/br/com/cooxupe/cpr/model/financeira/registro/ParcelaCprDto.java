package br.com.cooxupe.cpr.model.financeira.registro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelaCprDto {

	@JsonProperty("codigo_controle_parcela_contrato_if")
	private String codigoControleParcelaContratoIf;
	@JsonProperty("data_vencimento_parcela")
	private LocalDate dataVencimentoParcela;
	@JsonProperty("id_registro_parcela")
	private Long idRegistroParcela;
	@JsonProperty("numero_parcela")
	private Long numeroParcela;
	@JsonProperty("preco_cessao_parcela")
	private BigDecimal precoCessaoParcela;
	private Long status;
	@JsonProperty("valor_parcela")
	private BigDecimal valorParcela;
	@JsonProperty("valor_principal_parcela")
	private BigDecimal valorPrincipalParcela;
	

}
