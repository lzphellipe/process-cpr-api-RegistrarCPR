package br.com.cooxupe.cpr.model.financeira.registro;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoAreaDto {

	@JsonProperty("area_necessaria_cpr")
	private BigDecimal areaNecessariaCpr;
	@JsonProperty("area_produtiva_total")
	private BigDecimal areaProdutivaTotal;
	private List<AreaProdutoDto> areas;
	@JsonProperty("classe_tipo_ph")
	private String classeTipoPh;
	private String cultura;
	private String descricao;
	@JsonProperty("especificidade_cultura")
	private String especificidadeCultura;
	@JsonProperty("forma_acondicionamento")
	private String formaAcondicionamento;
	@JsonProperty("id_produto")
	private Long idProduto;
	@JsonProperty("indice_apuracao_produto")
	private String indiceAputracaoProduto;
	@JsonProperty("instituicao_responsavel_indice")
	private String instituicaoResponsavelIndice;
	@JsonProperty("local_entrega_cidade")
	private String localEntregaCidade;
	@JsonProperty("local_entrega_regional")
	private String localEntregaRegional;
	@JsonProperty("local_entrega_uf")
	private String localEntregaUf;
	@JsonProperty("preco_volume")
	private BigDecimal precoVolume;
	private String producao;
	private String produtividade;
	private String safra;
	private String situacao;
	private boolean status;
	@JsonProperty("unidade_medida_volume")
	private String unidadeMedidaVolume;
	@JsonProperty("valor_registro")
	private BigDecimal valorRegistro;
	@JsonProperty("volume_quantidade")
	private String volumeQuantidade;
}
