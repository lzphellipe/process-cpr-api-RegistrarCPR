package br.com.cooxupe.cpr.model.financeira.registro;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosRetornoRegistroCprDto {

	private String Status;
	@JsonProperty("id_registro")
	private Long idRegistro;
	private List<ParcelaDto> parcelas;
}
