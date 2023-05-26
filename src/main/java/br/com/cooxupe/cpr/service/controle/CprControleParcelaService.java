package br.com.cooxupe.cpr.service.controle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.model.CprControleParcelaModel;
import br.com.cooxupe.cpr.model.financeira.registro.ParcelaDto;
import br.com.cooxupe.cpr.repository.CprControleParcelaRepository;
import br.com.cooxupe.cpr.service.util.UtilsService;

@Service
public class CprControleParcelaService {


	@Autowired
	private CprControleParcelaRepository controleParcelaRepository;
	@Autowired
	private UtilsService utilsService;
	private int linha;
	
	
	
	public void salvarParcelasService(List<ParcelaDto> parcelas , BigDecimal idControleCab) {
		
		BigDecimal revisao = retornarRevisao(idControleCab);
		linha = 0;
		parcelas.stream().forEach(p -> {
			linha++;
			CprControleParcelaModel parcela = new CprControleParcelaModel();
			
			parcela.setIdControleCabInt(idControleCab);
			parcela.setNumeroRevisao(revisao);
			parcela.setNumeroLinha(new BigDecimal(linha));
			parcela.setIdParcela(new BigDecimal(p.getIdParcela()));
			parcela.setNumeroParcela(new BigDecimal(p.getNumeroParcela()));
			parcela.setDataVencimentoParcela(utilsService.convertStringToLocalDate(p.getDataVencimentoParcela()));
			parcela.setPrecoCessaoParcela(p.getPrecoCessaoParcela());
			parcela.setStatus(p.getStatus());
						
			controleParcelaRepository.save(parcela);
			
		});
		
	}
	
	
	
	public boolean existeParcela(BigDecimal idControleCab) {
		
		return controleParcelaRepository.existsParcelaByIdControleCabInt(idControleCab);
	}
	
	
	
	
	
	
	private BigDecimal retornarRevisao(BigDecimal idControleCab) {

		Optional<BigDecimal> optRevisao = controleParcelaRepository.pesquisarUltimaRevisao(idControleCab);
		BigDecimal revisao = new BigDecimal(0);

		if (optRevisao.isPresent()) {
			revisao = optRevisao.get();
		}

		return revisao.add(new BigDecimal("1"));

	}



}
