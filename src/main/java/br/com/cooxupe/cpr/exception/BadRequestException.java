package br.com.cooxupe.cpr.exception;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cooxupe.cpr.model.dto.erros.MensagemErroDto;
import lombok.Getter;
import lombok.Setter;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class BadRequestException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	private List<MensagemErroDto> erros;
	private BigDecimal idControleCabInt;
	
	public BadRequestException(String msg,List<MensagemErroDto> erroMensagem, BigDecimal idCabInt) {
		super(msg);
		this.erros = erroMensagem;
		this.idControleCabInt = idCabInt;
	}

	
	public BadRequestException(String msg) {
		super(msg);
		
	}


	
	
}
