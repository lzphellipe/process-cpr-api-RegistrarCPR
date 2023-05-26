package br.com.cooxupe.cpr.model.financeira.registro;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredorDto {

	private String cep;
	@JsonProperty("credor_numero_documento")
	private String credorNumeroDocumento;
	@JsonProperty("credor_status")
	private boolean credorStatus;
	@JsonProperty("credor_tipo_pessoa")
	private Long credorTipoPessoa;
	@JsonProperty("data_endosso")
	private String dataEndosso;
	private String endossatario;
	private Long id;
}
