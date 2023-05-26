package br.com.cooxupe.cpr.model.dto.controle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CprControleCabDto {


	private String idControleCabInt;		
	private String numeroCpr;		
	private String nomeRegistradora;
	private BigDecimal idRegistro;		
	private String status;		
	private String descricaoStatus;		
	private LocalDateTime dataEnvio;
	private String organizacaoEmpresa;
}
