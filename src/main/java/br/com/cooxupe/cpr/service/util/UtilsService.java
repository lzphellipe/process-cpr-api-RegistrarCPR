package br.com.cooxupe.cpr.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.model.dto.erros.MensagemErroDto;

@Service
public class UtilsService {

	
	
	
	public String retornarLocalDateTimeNowString() {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return now.format(formatter);
	}

	
	public LocalDateTime convertStringToLocalDateTime(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(data, formatter);
	}
	
	public List<MensagemErroDto> carregarMensagemDeErro(String mensagem) {
		List<MensagemErroDto> errors = new ArrayList<>();
		MensagemErroDto mensagemErro = new MensagemErroDto();				
		mensagemErro.setDetalhe(mensagem);
		mensagemErro.setTimestamp(retornarLocalDateTimeNowString());
		errors.add(mensagemErro);
		
		return errors;
	}
	
	
	
	public LocalDate convertStringToLocalDate(String data) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(data, formatter);
	}
	
}
