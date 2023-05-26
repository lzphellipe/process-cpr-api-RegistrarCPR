package br.com.cooxupe.cpr.controller;

import br.com.cooxupe.cpr.exception.ResourceNotFoundException;
import br.com.cooxupe.cpr.model.financeira.registro.SolicitacaoRegistroCprDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cooxupe.cpr.model.financeira.registro.RetornoSolicitacaoRegistroCprDto;
import br.com.cooxupe.cpr.service.CprRegistroService;

@RequestMapping("/cpr/cerc")
@RestController
public class CprController {

	@Autowired
	private CprRegistroService cprRegistroService;

	private SolicitacaoRegistroCprDto solicitacaoRegistroCprDto;
	@Autowired
	private CprRegistroService getCprRegistroService;


	@GetMapping("/{id}")
	public ResponseEntity<SolicitacaoRegistroCprDto> solicitacaoRegistroCprDto( Long id)
			throws ResourceNotFoundException {
		SolicitacaoRegistroCprDto cprDto = getCprRegistroService.getCorpoSolicitacaoCpr(id);
		return ResponseEntity.ok(cprDto);
	}


	@PostMapping("/registro/{cpr}/{org}")
	public ResponseEntity<RetornoSolicitacaoRegistroCprDto> registrarCpr(@PathVariable String cpr, @PathVariable String org) {

		RetornoSolicitacaoRegistroCprDto retorno = cprRegistroService.pesquisarCprParaRegistro(cpr, org);

		return ResponseEntity.ok(retorno);
	}


}




