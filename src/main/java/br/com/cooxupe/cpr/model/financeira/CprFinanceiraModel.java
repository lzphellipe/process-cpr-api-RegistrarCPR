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
@Table(name = "xcxp_cpr_financeira_v")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprFinanceiraModel {
	
	@Id
	private BigDecimal idCpr;
	@Column(name="nr_cpr")
	private String numeroCpr;
	private BigDecimal idEmpresa;
	@Column(name="nm_empresa")
	private String nomeEmpresa;
	@Column(name="tp_cedula")
	private String tipoCedula;
	@Column(name="nm_tp_cedula")
	private String nomeCedula;
	@Column(name="cd_contrato_operacao_credito")
	private String codigoContratoOperacaoCredito;
	@Column(name="cd_contrato_scr")
	private String codigoContratoScr;
	@Column(name="cd_moeda")
	private String codigoMoeda;
	@Column(name="dt_baixa")
	private String dataBaixaOutraIf;
	@Column(name="dt_contrato")
	private String dataContratoSistemaIf;
	@Column(name="dt_registro")
	private String dataRegistroOriginal;
	@Column(name="dt_transacao")
	private String dataTransacao;
	@Column(name="id_registro_imf")
	private String idRegistroOriginalImf;
	@Column(name="id_padrao_operacao_credito")
	private String identificacaoPadronizadaOperacaoCredito;
	@Column(name="cd_indexador")
	private String indexacao;
	@Column(name="ds_natureza_operacao")
	private String naturezaOperacao;
	@Column(name="pc_indexador")
	private BigDecimal percentualIndexador;
	@Column(name="qt_parcela_contrato")
	private BigDecimal quantidadeParcelaContratada;
	@Column(name="cd_referencia_externa")
	private String referenciaExterna;
	@Column(name="vl_taxa_juros")
	private String taxaJurosOperacao;
	@Column(name="cd_tipo_ativo")
	private String tipoAtivo;
	@Column(name="vl_financiado")
	private BigDecimal valorFinanciadoContrato;
	@Column(name="vl_liquido_credito")
	private BigDecimal valorLiquidoCredito;
	@Column(name="vl_total_credito")
	private BigDecimal valorTotalCredito;
	@Column(name="dt_entrega")
	private String dataEntrega;
	@Column(name="id_emissao")
	private String idEmissao;
	@Column(name="nm_cidade_forum")
	private String localEmissao;
	@Column(name="nm_emissor")
	private String razaoSocialEmissor;
	@Column(name="cd_tipo_cpr")
	private String tipoCpr;
	@Column(name ="nr_ativo")
	private String aditivo;
	@Column(name ="id_ativo_registradora")
	private String idAtivoRegistradora;
	@Column(name ="ds_observacao_cpr")
	private String observacaoCpr;
	private String cdStatusRetorno;
	private String dsMensagemRetorno;
	
	
	
	
	

}
