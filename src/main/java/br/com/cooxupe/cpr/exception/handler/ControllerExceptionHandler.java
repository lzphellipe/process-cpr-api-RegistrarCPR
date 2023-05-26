package br.com.cooxupe.cpr.exception.handler;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.cooxupe.cpr.exception.BadRequestException;
import br.com.cooxupe.cpr.exception.BusinessException;
import br.com.cooxupe.cpr.exception.ResourceNotFoundException;
import br.com.cooxupe.cpr.exception.ForbiddenException;
import br.com.cooxupe.cpr.exception.UnauthorizedException;
import br.com.cooxupe.cpr.model.dto.erros.ErrorMessageSolicitacaoRegistroDto;
import br.com.cooxupe.cpr.model.dto.erros.MensagemErroResponseDto;
import br.com.cooxupe.cpr.service.controle.CprControleCabService;
import br.com.cooxupe.cpr.service.controle.CprControleErroService;
import br.com.cooxupe.cpr.service.util.UtilsService;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

	
	@Autowired
	private CprControleCabService cprControleCabService;
	@Autowired
	private CprControleErroService cprControleErroService;
	@Autowired
	private UtilsService utilsService;
	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public MensagemErroResponseDto badRequestException(BadRequestException ex, WebRequest request) {
		
		MensagemErroResponseDto  mensagemErroResponseDto = new MensagemErroResponseDto();	
		mensagemErroResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		if (!ex.getErros().isEmpty()) {
		
		mensagemErroResponseDto.setErrors(ex.getErros());
		
		cprControleCabService.atualizarControleCabErroService(ex.getIdControleCabInt());
		cprControleErroService.salvarMensagemDeErrosService(ex.getErros(),ex.getIdControleCabInt(),HttpStatus.BAD_REQUEST.value());	
		
		log.error("######## => Erro em badRequestException: " + ex.getErros().stream().map(e-> e.getDetalhe()).collect(Collectors.toList()));
			return mensagemErroResponseDto;
		}
		
		mensagemErroResponseDto.setErrors(utilsService.carregarMensagemDeErro(ex.getMessage()));	
		log.error("######## => Erro em badRequestException: " +ex.getMessage());
		return mensagemErroResponseDto;
	}
	
	
	
  @ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public ErrorMessageSolicitacaoRegistroDto unauthorizedException(UnauthorizedException ex, WebRequest request) {
		
		ErrorMessageSolicitacaoRegistroDto erro = new ErrorMessageSolicitacaoRegistroDto(utilsService.retornarLocalDateTimeNowString()
																						,HttpStatus.UNAUTHORIZED.value()
																						,ex.getMessage()
																						,ex.getLocalizedMessage()
																						,request.getDescription(false)
																						,HttpStatus.UNAUTHORIZED.value());																					
																					
		cprControleCabService.atualizarControleCabErroService(ex.getIdControleCabInt());	
		cprControleErroService.salvarMensagemErroTratadoService(erro, ex.getIdControleCabInt());
		
		log.error("######## => Erro em UnauthorizedException: " + String.valueOf(erro.getStatus()+" - "+erro.getMessage()));
		
		return erro;
	}
	
	
    @ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessageSolicitacaoRegistroDto resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		ErrorMessageSolicitacaoRegistroDto erro = new ErrorMessageSolicitacaoRegistroDto(utilsService.retornarLocalDateTimeNowString()
																						,HttpStatus.NOT_FOUND.value()
																						,ex.getMessage()
																						,ex.getLocalizedMessage()
																						,request.getDescription(false)
																						,HttpStatus.NOT_FOUND.value());																					
																						
																							
		
		log.error("######## => Erro em ResourceNotFoundException: " + String.valueOf(erro.getStatus()+" - "+erro.getMessage()));
		
		return erro;
	}
	
  
  
  
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public MensagemErroResponseDto businessException(BusinessException ex, WebRequest request) {
		
																				
			MensagemErroResponseDto  mensagemErroResponseDto = new MensagemErroResponseDto();	
			
			mensagemErroResponseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			
			if (!ex.getErros().isEmpty()) {
			mensagemErroResponseDto.setErrors(ex.getErros());
						
			cprControleCabService.atualizarControleCabErroService(ex.getIdControleCabInt());
			cprControleErroService.salvarMensagemDeErrosService(ex.getErros(),ex.getIdControleCabInt(),HttpStatus.INTERNAL_SERVER_ERROR.value());
			
			log.error("######## => Erro em BusinessException: " + ex.getErros().stream().map(e-> e.getDetalhe()).collect(Collectors.toList()));		
			return mensagemErroResponseDto;
			}
			
			mensagemErroResponseDto.setErrors(utilsService.carregarMensagemDeErro(ex.getMessage()));	
			
			log.error("######## => Erro em BusinessException: "+ex.getMessage());
			
		return mensagemErroResponseDto;
	}
	
	
	
	
	
	@ExceptionHandler(ForbiddenException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public ErrorMessageSolicitacaoRegistroDto forbiddenException(ForbiddenException ex, WebRequest request) {
		
		ErrorMessageSolicitacaoRegistroDto erro = new ErrorMessageSolicitacaoRegistroDto(utilsService.retornarLocalDateTimeNowString()
																						,HttpStatus.FORBIDDEN.value()
																						,ex.getMessage()
																						,ex.getLocalizedMessage().stripTrailing()
																						,request.getDescription(false)
																						,HttpStatus.FORBIDDEN.value());																					
																						
		cprControleCabService.atualizarControleCabErroService(ex.getIdControleCabInt());	
		cprControleErroService.salvarMensagemErroTratadoService(erro, ex.getIdControleCabInt());																					
		
		log.error("######## => Erro em ForbiddenException: " + String.valueOf(erro.getStatus()+" - "+erro.getMessage()));
		
		return erro;
	}

	
	
	
	
}
