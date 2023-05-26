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
@Table(name = "xcxp_cpr_financ_garantidor_v")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarantidorModel {

	@Id
	@Column(name="nr_inscricao_documento")
	private String garantidorNumeroDocumento;	
	private BigDecimal idCpr;
	@Column(name="nr_cpr")
	private String numeroCpr;
	private BigDecimal idEmpresa;
	@Column(name="nm_empresa")
	private String nomeEmpresa;
	@Column(name="cd_categoria_garantidor")
	private String codigoCategoriaGarantidor;
	@Column(name="nm_categoria_garantidor")
	private String nomeCategoriaGarantidor;
	@Column(name="cd_cep")
	private String garantidorCep;
	@Column(name="ds_email")
	private String emailGarantidor;
	@Column(name="ds_endereco_residencial_emissor")
	private String enderecoResidencialEmissor;
	@Column(name="cd_matricula_garantidor")
	private String codigoMatriculaGarantidor;
	@Column(name="nm_garantidor")
	private String nome;
	@Column(name="nr_celular")
	private String celularGarantidor;
	@Column(name="tp_inscricao_documento")
	private String garantidorTipoPessoa;	
	@Column(name="tp_garantia")
	private String tipoGarantidor;
}
