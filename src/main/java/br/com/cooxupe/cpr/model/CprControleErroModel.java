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
@Table(name="XCXP_CPR_CONTROLE_ERRO_INT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprControleErroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XCXP_CPR_CONTROLE_ERRO_INT_S")
    @SequenceGenerator(sequenceName = "XCXP_CPR_CONTROLE_ERRO_INT_S", allocationSize = 1, name = "XCXP_CPR_CONTROLE_ERRO_INT_S")
	private BigDecimal idControleErroInt;
	private BigDecimal idControleCabInt;
	@Column(name="nr_revisao")
	private BigDecimal numeroRevisao;
	@Column(name="nr_linha")
	private BigDecimal numeroLinha;
	@Column(name="dt_retorno")
	private LocalDateTime dataRetorno;
	@Column(name="ds_mensagem")
	private String mensagemErro;
	
}
