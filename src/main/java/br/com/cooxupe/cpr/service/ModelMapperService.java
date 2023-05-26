package br.com.cooxupe.cpr.service;

import br.com.cooxupe.cpr.model.CprControleParcelaModel;
import br.com.cooxupe.cpr.model.dto.atualizacao.SolicitacaoAtualizacaoParcelaCPRDto;
import br.com.cooxupe.cpr.model.dto.controle.CprControleParcelaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.model.CprControleCabModel;
import br.com.cooxupe.cpr.model.dto.controle.CprControleCabDto;

@Service
public class ModelMapperService {

	public SolicitacaoAtualizacaoParcelaCPRDto toCprControleParcelaDto;
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	public CprControleCabDto toControleCabDto(CprControleCabModel cabModel) {
		
		return modelMapper.map(cabModel, CprControleCabDto.class);
	}
    public CprControleParcelaDto toCprControleParcelaDto(CprControleParcelaModel parcelaModel) {
		return modelMapper.map(parcelaModel, CprControleParcelaDto.class);
	}

}
