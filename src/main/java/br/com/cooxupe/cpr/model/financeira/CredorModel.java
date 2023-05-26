package br.com.cooxupe.cpr.model.financeira;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="xcxp_cpr_credor_v")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredorModel {
	
	@Id
	@Column(name="nr_inscricao_documento")
	private String  credorNumeroDocumento;
	@Column(name="cd_cep")
	private String cep;
	@Column(name="tp_inscricao_documento")
	private String credorTipoPessoa;
	@Column(name="dt_endosso")
	private LocalDateTime dataEndosso;
	private String dsEndereco;
	private String dsEndossatario;
	private String cdDetentorCarteira;
	private String nrInscricaoDocumentoDetentor;

}
