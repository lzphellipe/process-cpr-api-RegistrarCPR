package br.com.cooxupe.cpr.exception;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cooxupe.cpr.model.dto.erros.MensagemErroDto;
import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@Setter
public class BusinessException  extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	private List<MensagemErroDto> erros = new ArrayList<>();
	private BigDecimal idControleCabInt;
	
	public BusinessException(String msg) {
		super(msg);
	}
	
	public BusinessException(String msg,List<MensagemErroDto> erroMensagem, BigDecimal idCabInt) {
		super(msg);
		this.erros = erroMensagem;
		this.idControleCabInt = idCabInt;
	}
	
	
	
}
