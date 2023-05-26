package br.com.cooxupe.cpr.service.token;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

import br.com.cooxupe.cpr.config.WebClientConfig;
import br.com.cooxupe.cpr.exception.BadRequestException;
import br.com.cooxupe.cpr.exception.BusinessException;
import br.com.cooxupe.cpr.exception.ForbiddenException;
import br.com.cooxupe.cpr.exception.UnauthorizedException;
import br.com.cooxupe.cpr.model.dto.token.TokenDto;


@Service
public class GerarTokenService {

	
	@Value("${process-cpr-api.autenticacao.client.id}")
	private String clientId;
	@Value("${process-cpr-api.autenticacao.client.secret}")
	private String clientSecret;
	@Value("${process-cpr-api.autenticacao.url}")
	private String urlAutenticacao;
	@Value("${process-cpr-api.autenticacao.grant.type}")
	private String grantType;
	@Value("${process-cpr-api.autenticacao.client.credentials}")
	private String clientCredentials;
	
	@Autowired
	private WebClientConfig webClientConfig;	

	public TokenDto gerarToken() {

		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add(grantType,clientCredentials);
		
		return this.webClientConfig.createWebClient()
								   .post()
			   	                   .uri(urlAutenticacao)	
			   	                   .contentType(MediaType.MULTIPART_FORM_DATA)			   	                  
			   	                   .header(HttpHeaders.AUTHORIZATION, "Basic "+gerarHashBase64(clientId,clientSecret))
			                       .body(BodyInserters.fromFormData(formData))							    
			                       .retrieve()
			                       .onStatus(HttpStatus.UNAUTHORIZED::equals,response -> response.bodyToMono(UnauthorizedException.class))
			                       .onStatus(HttpStatus.BAD_REQUEST::equals,response -> response.bodyToMono(BadRequestException.class))
			                       .onStatus(HttpStatus.FORBIDDEN::equals,response -> response.bodyToMono(ForbiddenException.class))
			                       .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,response -> response.bodyToMono(BusinessException.class))
			                       .bodyToMono(TokenDto.class)										
				                   .block();

		
	}

	private String gerarHashBase64(String key, String secret) {

		String token = key + ":" + secret;

		return Base64.getEncoder().encodeToString(token.getBytes());
	}
	
	
	
	
	
	
	
	
}
