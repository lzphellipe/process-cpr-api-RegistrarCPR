package br.com.cooxupe.cpr.model.financeira;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "xcxp_cpr_emissor_v")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmissorModel {
	
	@Id
	private BigDecimal idCpr;
	@Column(name="nr_cpr")
	private String numeroCpr;
	private BigDecimal idEmpresa;
	@Column(name="nm_empresa")
	private String nomeEmpresa;
	private BigDecimal idParte;
	private BigDecimal idMatricula;
	private String cdMatricula;
	private String nmEmissor;
	@Column(name="nr_celular")
	private String celularEmissor;
	@Column(name="cd_cep")
	private String cepEmissor;
	@Column(name="ds_email")
	private String emailEmissor;
	@Column(name ="nr_agencia")
	private String emissorAgenciaCredito;
	@Column(name ="nr_banco")
	private String emissorBancoCredito;
	@Column(name ="nr_conta_corrente")
	private String emissorContaCorrenteCredito;
	@Column(name ="nr_inscricao_documento")
	private String numeroDocumentoEmissor;
	@Column(name ="tp_inscricao_documento")
	private Long tipoPessoaEmissor;
	private String dsEnderecoResidencialEmissor;

}
