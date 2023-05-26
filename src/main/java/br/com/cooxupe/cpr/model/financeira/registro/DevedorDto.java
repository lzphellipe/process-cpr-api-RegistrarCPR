package br.com.cooxupe.cpr.model.financeira.registro;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevedorDto {
	
	@JsonProperty("devedor_cep")
	private String devedorCep;	
	@JsonProperty("devedor_email")
	private String devedorEmail;
	@JsonProperty("devedor_endereco")
	private String devedorEndereco;
	@JsonProperty("devedor_nome_razao_social")
	private String devedorNomeRazaoSocial;
	@JsonProperty("devedor_numero_celular")
	private String devedorNumeroCelular;
	@JsonProperty("devedor_numero_documento")
	private String devedorNumeroDocumento;
	@JsonProperty("devedor_status")
	private boolean devedorStatus;
	@JsonProperty("devedor_tipo_pessoa")
	private Long devedorTipoPessoa;
	private Long id;

}
