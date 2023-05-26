package br.com.cooxupe.cpr.model.dto.atualizacao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class SolicitacaoAtualizacaoParcelaCPRDto {


        @JsonProperty("data_vencimento_parcela")
        private LocalDate dataVencimentoParcela;

        @JsonProperty("id_registro_contrato")
        private Long idRegistroContrato;

        @JsonProperty("id_parcela")
        private BigDecimal IdParcela;

        @JsonProperty("id_registro_parcela")
        private Long IdRegistroParcela;

        @JsonProperty("motivo_movimentacao")
        private Long motivoMovimentacao;

        @JsonProperty("valor_parcela_atualizado")
        private Double valorParcelaAtualizado;

        private Long status;

        private String menssagem;

        @JsonProperty("valor_principal_parcela")
        private BigDecimal valorPrincipalParcela;

        private BigDecimal numeroParcela;

        private BigDecimal precoCessaoParcela;



}
