package br.com.cooxupe.cpr.model.financeira.registro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoValorCprDto {

	@JsonProperty("autorizo_registro_e_declaro_que_foi_dado_baixa_no_registro_em_quaisquer_outras_if")
	private boolean autorizaoRegistroEdeclaroQueFoiDadoBaixaNoRegistroEmQuaisquerOutrasIf;
	@JsonProperty("codigo_contrato_operacao_credito")
	private String codigoContratoOperacaoCredito;
	@JsonProperty("codigo_contrato_scr")
	private String codigoContratoScr;
	@JsonProperty("codigo_moeda")
	private String codigoMoeda;
	@JsonProperty("data_baixa_outra_if")
	private String dataBaixaOutraIf;
	@JsonProperty("data_contrato_sistema_IF")
	private String dataContratoSistemaIf;
	@JsonProperty("data_registro_original")
	private String dataRegistroOriginal;
	@JsonProperty("data_transacao")
	private LocalDate dataTransacao;
	@JsonProperty("id_registro_original_imf")
	private String idRegistroOriginalImf;
	@JsonProperty("identificacao_padronizada_operacao_credito")
	private String identificacaoPadronizadaOperacaoCredito;
	private String indexacao;
	@JsonProperty("natureza_operacao")
	private String naturezaOperacao;
	@JsonProperty("percentual_indexador")
	private BigDecimal percentualIndexador;
	@JsonProperty("quantidade_parcela_contratada")
	private Long quantidadeParcelaContratada;
	@JsonProperty("referencia_externa")
	private String referenciaExterna;
	@JsonProperty("taxa_juros_operacao")
	private BigDecimal taxaJurosOperacao;
	@JsonProperty("tipo_ativo")
	private String tipoAtivo;
	@JsonProperty("valor_financiado_contrato")
	private BigDecimal valorFinanciadoContrato;
	@JsonProperty("valor_liquido_credito")
	private BigDecimal valorLiquidoCredito;
	@JsonProperty("valor_total_credito")
	private BigDecimal valorTotalCredito;
	
}
