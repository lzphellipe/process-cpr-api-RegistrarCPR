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
public class AreaDto {

	
	@JsonProperty("area_total")
	private BigDecimal areaTotal;
	private String cartorio;
	private String cep;
	private String endereco;
	@JsonProperty("fracao_unitaria_imovel")
	private String fracaoUnitariaDoImovel;
	@JsonProperty("id_area")
	private Long idArea;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String matricula;
	@JsonProperty("nome_fazenda")
	private String nomeFazenda;
	private List<ProdutoDto> produtos;
	private String proprietario;
	@JsonProperty("reservaLegal")
	private BigDecimal reservaLegal;
	private boolean status;
}
