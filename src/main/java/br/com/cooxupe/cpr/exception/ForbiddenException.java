package br.com.cooxupe.cpr.exception;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
@Getter
@Setter
public class ForbiddenException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	private BigDecimal idControleCabInt;
	
	
	public ForbiddenException(String msg,BigDecimal idCabInt) {
		super(msg);
		this.idControleCabInt = idCabInt;
	}
	
	public ForbiddenException(String msg) {
		super(msg);
	}
}
