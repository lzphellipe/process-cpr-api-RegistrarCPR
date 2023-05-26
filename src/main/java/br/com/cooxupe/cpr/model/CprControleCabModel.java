package br.com.cooxupe.cpr.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="XCXP_CPR_CONTROLE_CAB_INT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprControleCabModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XCXP_CPR_CONTROLE_CAB_INT_S")
    @SequenceGenerator(sequenceName = "XCXP_CPR_CONTROLE_CAB_INT_S", allocationSize = 1, name = "XCXP_CPR_CONTROLE_CAB_INT_S")
	private BigDecimal idControleCabInt;
	@Column(name="nr_cpr")
	private String numeroCpr;
	@Column(name="nm_Registradora")
	private String nomeRegistradora;
	private BigDecimal idRegistro;
	@Column(name="cd_Status")
	private String status;
	@Column(name="ds_Status")
	private String descricaoStatus;
	@Column(name="dt_envio")
	private LocalDateTime dataEnvio;
	@Column(name="cd_organizacao_empresa")
	private String organizacaoEmpresa;


}
