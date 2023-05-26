package br.com.cooxupe.cpr.service.controle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.model.CprControleErroModel;
import br.com.cooxupe.cpr.model.dto.erros.ErrorMessageSolicitacaoRegistroDto;
import br.com.cooxupe.cpr.model.dto.erros.MensagemErroDto;
import br.com.cooxupe.cpr.repository.CprControleErroRepository;
import br.com.cooxupe.cpr.service.util.UtilsService;

@Service
public class CprControleErroService {
	
	@Autowired
	private CprControleErroRepository cprErroRepository;
	@Autowired
	private UtilsService utilsService;
	private int linha;
	
	
	public void salvarMensagemDeErrosService(List<MensagemErroDto> erros ,BigDecimal idControleCab, int codigoHttp) {
		
		BigDecimal revisao = retornarRevisao(idControleCab);
		
		linha = 0;
		erros.stream().forEach(a -> {
			linha++;
			CprControleErroModel controleErroModel = new CprControleErroModel();
			
			controleErroModel.setIdControleCabInt(idControleCab);
			controleErroModel.setNumeroRevisao(revisao);
			controleErroModel.setNumeroLinha(new BigDecimal(linha));	
			controleErroModel.setMensagemErro(codigoHttp+" - "+a.getDetalhe());
			
			if((a.getTimestamp().isEmpty())||(a.getTimestamp() == null)) {
				
				controleErroModel.setDataRetorno(LocalDateTime.now());
			}else {
				
		
				controleErroModel.setDataRetorno(utilsService.convertStringToLocalDateTime(a.getTimestamp()));
			}
			
			cprErroRepository.save(controleErroModel);
		});
		
		
		
	}
	
	public void salvarMensagemErroTratadoService(ErrorMessageSolicitacaoRegistroDto erro,BigDecimal idControleCab) {
		BigDecimal revisao = retornarRevisao(idControleCab);
		CprControleErroModel controleErroModel = new CprControleErroModel();
		
		controleErroModel.setIdControleCabInt(idControleCab);
		controleErroModel.setNumeroRevisao(revisao);
		controleErroModel.setNumeroLinha(new BigDecimal(1));		
		controleErroModel.setDataRetorno(LocalDateTime.now());
		controleErroModel.setMensagemErro(erro.getStatus()+" - "+erro.getMessage());
		cprErroRepository.save(controleErroModel);
	}
	
	private BigDecimal retornarRevisao(BigDecimal idControleCab) {

		Optional<BigDecimal> optRevisao = cprErroRepository.pesquisarUltimaRevisao(idControleCab);
		BigDecimal revisao = new BigDecimal(0);

		if (optRevisao.isPresent()) {
			revisao = optRevisao.get();
		}

		BigDecimal revisaoTotal = revisao.add(new BigDecimal("1"));

		return revisaoTotal;

	}
	
	
	

}
