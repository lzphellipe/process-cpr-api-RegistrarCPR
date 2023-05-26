package br.com.cooxupe.cpr.service;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.cooxupe.cpr.service.controle.CprControleCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.config.WebClientConfig;
import br.com.cooxupe.cpr.exception.BadRequestException;
import br.com.cooxupe.cpr.exception.BusinessException;
import br.com.cooxupe.cpr.exception.ForbiddenException;
import br.com.cooxupe.cpr.exception.ResourceNotFoundException;
import br.com.cooxupe.cpr.exception.UnauthorizedException;
import br.com.cooxupe.cpr.model.CprControleCabModel;
import br.com.cooxupe.cpr.model.dto.atualizacao.SolicitacaoAtualizacaoParcelaCPRDto;
import br.com.cooxupe.cpr.model.dto.controle.CprControleCabDto;
import br.com.cooxupe.cpr.model.dto.erros.ErrorMessageSolicitacaoRegistroDto;
import br.com.cooxupe.cpr.model.dto.erros.MensagemErroResponseDto;
import br.com.cooxupe.cpr.model.financeira.CprFinanceiraModel;
import br.com.cooxupe.cpr.model.financeira.registro.RetornoSolicitacaoRegistroCprDto;
import br.com.cooxupe.cpr.model.financeira.registro.SolicitacaoRegistroCprDto;
import br.com.cooxupe.cpr.repository.financeira.CprFinanceiraRepository;

@Service
public class CprRegistroService {

	@Autowired
	private WebClientConfig webClientConfig;

	@Value("${process-cpr-api.url.base}")
	private String baseUrl;

	@Autowired
	private CprControleCabService gerarTokenService ;

	@Autowired
	private ModelMapperService modelMapperService;

	@Autowired
	private CprControleCabService cprControleCabService;

	@Autowired
	private CarregarDadosDeTesteService carregarDadosDeTesteService;

	@Autowired
	private CprFinanceiraRepository cprFinanceiraRepository;

	public RetornoSolicitacaoRegistroCprDto pesquisarCprParaRegistro(String cpr, String organizacao) {
		String org;
		if (organizacao.equals("81")) {
			org = "COOXUPE UNIDADE OPERACIONAL";
		} else {
			org = "SMC UNIDADE OPERACIONAL";
		}

		Optional<CprControleCabModel> optCprControleCab = cprControleCabService.retornarDadosCabecalhoPorCprOg(cpr,
				org);

		if (optCprControleCab.isPresent()) {
			CprControleCabDto dto = modelMapperService.toControleCabDto(optCprControleCab.get());

			SolicitacaoRegistroCprDto solicitacaoRegistroCprDto = carregarDadosDeTesteService
					.carregarSolicitacaoRegistroCprDto();
			solicitacaoRegistroCprDto.setIdControleCabInt(new BigDecimal(dto.getIdControleCabInt()));

			RetornoSolicitacaoRegistroCprDto ret = registrarCprService(solicitacaoRegistroCprDto);

			return ret;
		} else {
			throw new ResourceNotFoundException("A CPR " + cpr + " não foi localizada!");
		}
	}

	public SolicitacaoAtualizacaoParcelaCPRDto getSolicitacaoCPR(BigDecimal id) throws ResourceNotFoundException {
		CprFinanceiraModel parcelaModel = cprFinanceiraRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parcela da CPR não encontrada: " + id));

		return new SolicitacaoAtualizacaoParcelaCPRDto();
	}

	public SolicitacaoRegistroCprDto getCorpoSolicitacaoCpr(Long id) {
		String uri = baseUrl + "/cerc/registros/" + id;

		return webClientConfig.createWebClient()
				.get()
				.uri(uri)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.AUTHORIZATION,(String) recuperarToken())
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(SolicitacaoRegistroCprDto.class)
				.block();

	}

	public RetornoSolicitacaoRegistroCprDto registrarCprService(SolicitacaoRegistroCprDto registroCpr) {
		String uri = baseUrl + "/cerc/registros/cpr";

		RetornoSolicitacaoRegistroCprDto retornoSolicitacaoRegistroCprDto = webClientConfig.createWebClient()
				.post()
				.uri(uri)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.AUTHORIZATION,(String) recuperarToken())
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue(registroCpr)
				.retrieve()
				.onStatus(HttpStatus.BAD_REQUEST::equals, e -> e.bodyToMono(MensagemErroResponseDto.class).handle(
						(body, handler) -> handler.error(new BadRequestException("erro", body.getErrors(),
								registroCpr.getIdControleCabInt()))
				))
				.onStatus(HttpStatus.UNAUTHORIZED::equals, e -> e.bodyToMono(ErrorMessageSolicitacaoRegistroDto.class)
						.handle((body, handler) -> handler.error(
								new UnauthorizedException(body.getMessage(), registroCpr.getIdControleCabInt()))
						))
				.onStatus(HttpStatus.FORBIDDEN::equals, response -> response.bodyToMono(ForbiddenException.class))
				.onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals, e -> e.bodyToMono(MensagemErroResponseDto.class)
						.handle((body, handler) -> handler.error(new BusinessException("erro", body.getErrors(),
								registroCpr.getIdControleCabInt()))
						))
				.bodyToMono(RetornoSolicitacaoRegistroCprDto.class)
				.block();

		assert retornoSolicitacaoRegistroCprDto != null;
		cprControleCabService.atualizarControleCabSucessoService(retornoSolicitacaoRegistroCprDto,
				registroCpr.getIdControleCabInt());
		retornoSolicitacaoRegistroCprDto.setStatusCode(HttpStatus.OK.value());

		return retornoSolicitacaoRegistroCprDto;
	}

	private Object recuperarToken() {

		return gerarTokenService.gerarToken();

	}
}
