package br.com.cooxupe.cpr.model.dto.erros;

import java.util.ArrayList;
import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErroResponseDto {
	
	private int statusCode;
	private List<MensagemErroDto> errors = new ArrayList<>();

	
}
