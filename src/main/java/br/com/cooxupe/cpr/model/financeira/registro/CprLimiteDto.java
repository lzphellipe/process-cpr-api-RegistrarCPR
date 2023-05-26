package br.com.cooxupe.cpr.model.financeira.registro;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprLimiteDto {
	@JsonProperty("id_ativo")
	private Long idAtivo;
	@JsonProperty("is_remocao")
	private boolean isRemocao;

}
