package br.com.cooxupe.cpr.model.dto.erros;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErroDto {

	private String timestamp;
	private String detalhe;
	
	
	
}
