package br.com.cooxupe.cpr.model.financeira.registro;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoRegistroCprDto {
	
	private String aditivo;
	private AgentesCprDto agentes;
	private List<AreaDto> areas;
	@JsonProperty("contrato_valores")
	private ContratoValorCprDto contratoValores;
	@JsonProperty("cpr_limite")
	private CprLimiteDto cprLimite;
	@JsonProperty("emissao_cpr")
	private EmissaoCprDto emissaoCpr;
	private List<GarantiaDto> garantias;
	private Long id;
	private String observacao;
	private List<ParcelaCprDto> parcelas;
	private List<ProdutoAreaDto> produtos;
	private String status;
	@JsonProperty("status_avalia")
	private String statusAvalia;
	private BigDecimal idControleCabInt;


}
