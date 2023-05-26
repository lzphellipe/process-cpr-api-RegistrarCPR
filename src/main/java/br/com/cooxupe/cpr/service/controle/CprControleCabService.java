package br.com.cooxupe.cpr.service.controle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.exception.ResourceNotFoundException;
import br.com.cooxupe.cpr.model.CprControleCabModel;
import br.com.cooxupe.cpr.model.financeira.registro.RetornoSolicitacaoRegistroCprDto;
import br.com.cooxupe.cpr.repository.CprControleCabRepository;

@Service
public class CprControleCabService {

	@Autowired
	private CprControleCabRepository cprControleCabRepository;
	@Autowired
	private CprControleParcelaService cprControleParcelaService;
	
	
	public Optional<CprControleCabModel> retornarDadosCabecalhoPorCprOg(String cpr, String org) {

		return cprControleCabRepository.findByNumeroCprAndOrganizacaoEmpresa(cpr, org);
	}
	
	
	
	
	public void atualizarControleCabSucessoService(RetornoSolicitacaoRegistroCprDto response , BigDecimal idControleCab) {
		
			CprControleCabModel dadosControleCab = retornarControleCabModel(idControleCab);				
			
			dadosControleCab.setStatus("A");
			dadosControleCab.setDescricaoStatus(response.getData().getStatus());
			dadosControleCab.setIdRegistro(new BigDecimal(response.getData().getIdRegistro()));
			dadosControleCab.setDataEnvio(LocalDateTime.now());
	
			cprControleCabRepository.save(dadosControleCab);
			
			cprControleParcelaService.salvarParcelasService(response.getData().getParcelas(), idControleCab);
			
	}
	
	
	public void atualizarControleCabErroService(BigDecimal idControleCab) {
		
			CprControleCabModel dadosControleCab = retornarControleCabModel(idControleCab);	
			dadosControleCab.setStatus("E");
			dadosControleCab.setDescricaoStatus("Erro ao enviar os dados!");
			dadosControleCab.setDataEnvio(LocalDateTime.now());
			
			cprControleCabRepository.save(dadosControleCab);
	}
	
	
	
	private CprControleCabModel retornarControleCabModel(BigDecimal idControleCab) {
		
		return  cprControleCabRepository.findById(idControleCab).orElseThrow(() -> new ResourceNotFoundException("O ID "+idControleCab+" não foi encontrado na tabela xcxp_cpr_controle_cab_int!"));
			
		}


	public Object gerarToken() {
		return null;
	}
}
