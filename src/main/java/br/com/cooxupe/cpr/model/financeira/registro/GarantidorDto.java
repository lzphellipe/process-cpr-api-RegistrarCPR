package br.com.cooxupe.cpr.model.financeira.registro;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarantidorDto {

	@JsonProperty("celular_garantidor")
	private String celularGarantidor;
	@JsonProperty("email_garantidor")
	private String emailGarantidor;
	@JsonProperty("garantidor_cep")
	private String garantidorCep;
	@JsonProperty("garantidor_numero_documento")
	private String garantidorNumeroDocumento;
	@JsonProperty("garantidor_status")
	private boolean garantidorStatus;
	@JsonProperty("garantidor_tipo_pessoa")
	private Long garantidorTipoPessoa;
	private Long id;
	private String nome;
	private Long tipoGarantidor;

}
