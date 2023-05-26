package br.com.cooxupe.cpr.model.financeira.registro;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarantiaDto {

	@JsonProperty("garantia_status")
	private boolean garantiaStatus;
	@JsonProperty("id_garantia")
	private Long idGarantia;
	@JsonProperty("tipo_garantia")
	private String tipoGarantia;
}
