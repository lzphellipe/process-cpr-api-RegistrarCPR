package br.com.cooxupe.cpr.model.financeira.registro;

import java.util.List;

import br.com.cooxupe.cpr.model.dto.erros.MensagemErroDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("Lombok")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoSolicitacaoRegistroCprDto extends SolicitacaoRegistroCprDto {
	
	
	private DadosRetornoRegistroCprDto data;
	private int statusCode;
	private List<MensagemErroDto> errors;
	

}
