package br.com.cooxupe.cpr.model.dto.erros;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageSolicitacaoRegistroDto {

	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	private int statusCode;

}
