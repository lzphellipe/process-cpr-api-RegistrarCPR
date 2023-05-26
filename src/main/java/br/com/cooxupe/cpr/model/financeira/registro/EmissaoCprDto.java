package br.com.cooxupe.cpr.model.financeira.registro;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmissaoCprDto {
	
	@JsonProperty("data_entrega")
	private LocalDate dataEntrega;
	@JsonProperty("id_emissao")
	private Long idEmissao;
	@JsonProperty("local_emissao")
	private String localEmissao;
	@JsonProperty("razao_social_emissor")
	private String razaoSocialEmissor;
	@JsonProperty("tipo_cpr")
	private String tipoCpr;

}
