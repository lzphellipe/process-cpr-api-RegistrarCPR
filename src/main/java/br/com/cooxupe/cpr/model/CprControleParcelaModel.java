package br.com.cooxupe.cpr.model;

import java.math.BigDecimal;
import java.time.LocalDate;


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
@Table(name="XCXP_CPR_CONTROLE_PARCELA_INT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprControleParcelaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XCXP_CPR_CONTROL_PARCELA_INT_S")
    @SequenceGenerator(sequenceName = "XCXP_CPR_CONTROL_PARCELA_INT_S", allocationSize = 1, name = "XCXP_CPR_CONTROL_PARCELA_INT_S")
	private BigDecimal idControleParcelaInt;
	private BigDecimal idControleCabInt;
	@Column(name="nr_revisao")
	private BigDecimal numeroRevisao;
	@Column(name="nr_linha")
	private BigDecimal numeroLinha;
	private BigDecimal idParcela;
	@Column(name="nr_parcela")
	private BigDecimal numeroParcela;
	@Column(name="dt_vencimento_parcela")
	private LocalDate dataVencimentoParcela;
	@Column(name="vl_preco_cessao_parcela")
	private BigDecimal precoCessaoParcela;
	@Column(name="cd_status")
	private String status;


}
