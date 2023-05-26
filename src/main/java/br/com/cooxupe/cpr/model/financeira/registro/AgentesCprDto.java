package br.com.cooxupe.cpr.model.financeira.registro;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentesCprDto {
	
	@JsonProperty("celular_emissor")
	private String celularEmissor;
	@JsonProperty("cep_emissor")
	private String cepEmissor;
	private List<CredorDto> credores;
	@JsonProperty("detentor_carteira")
	private String detentorCarteira;
	@JsonProperty("detentor_cnpj")
	private String detentorCnpj;
	private List<DevedorDto> devedores;
	@JsonProperty("email_emissor")
	private String emailEmissor;
	@JsonProperty("emissor_agencia_credito")
	private String emissorAgenciaCredito;
	@JsonProperty("emissor_banco_credito")
	private String emissorBancoCredito;
	@JsonProperty("emissor_conta_corrente_credito")
	private String emissorContaCorrenteCredito;
	private List<GarantidorDto> garantidores;
	@JsonProperty("numero_documento_emissor")
	private String numeroDocumentoEmissor;
	@JsonProperty("tipo_pessoa_emissor")
	private Long tipoPessoaEmissor;
}
