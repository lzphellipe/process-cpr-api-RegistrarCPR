package br.com.cooxupe.cpr.exception;

import java.math.BigDecimal;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
@Getter
@Setter
public class UnauthorizedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private BigDecimal idControleCabInt;
	
	public UnauthorizedException(String msg,BigDecimal idCabInt) {
		super(msg);
		this.idControleCabInt = idCabInt;
	}
	
	public UnauthorizedException(String msg) {
		super(msg);

	}
}
