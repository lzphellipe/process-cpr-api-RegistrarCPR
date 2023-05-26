package br.com.cooxupe.cpr.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.cooxupe.cpr.model.financeira.registro.AgentesCprDto;
import br.com.cooxupe.cpr.model.financeira.registro.AreaDto;
import br.com.cooxupe.cpr.model.financeira.registro.AreaProdutoDto;
import br.com.cooxupe.cpr.model.financeira.registro.ContratoValorCprDto;
import br.com.cooxupe.cpr.model.financeira.registro.CredorDto;
import br.com.cooxupe.cpr.model.financeira.registro.DevedorDto;
import br.com.cooxupe.cpr.model.financeira.registro.EmissaoCprDto;
import br.com.cooxupe.cpr.model.financeira.registro.GarantiaDto;
import br.com.cooxupe.cpr.model.financeira.registro.GarantidorDto;
import br.com.cooxupe.cpr.model.financeira.registro.ParcelaCprDto;
import br.com.cooxupe.cpr.model.financeira.registro.ProdutoAreaDto;
import br.com.cooxupe.cpr.model.financeira.registro.ProdutoDto;
import br.com.cooxupe.cpr.model.financeira.registro.SolicitacaoRegistroCprDto;

@Service
public class CarregarDadosDeTesteService {

	
	
	public  SolicitacaoRegistroCprDto carregarSolicitacaoRegistroCprDto() {
		
		
		SolicitacaoRegistroCprDto solicitacaoRegistroCpr = new SolicitacaoRegistroCprDto();
		
		//solicitacaoRegistroCpr.setAditivo("1348686");
		solicitacaoRegistroCpr.setAgentes(carregarAgentes());
		solicitacaoRegistroCpr.setAreas(carregarAreas());
		solicitacaoRegistroCpr.setContratoValores(carregarContratoValorCpr());		
		//solicitacaoRegistroCpr.setCprLimite(carregarCprLimite());
		
		solicitacaoRegistroCpr.setEmissaoCpr(carregarEmissaoCpr());
		solicitacaoRegistroCpr.setGarantias(carregarGarantia());
		//solicitacaoRegistroCpr.setId(11L);
		solicitacaoRegistroCpr.setObservacao("Observacao CERC");
		solicitacaoRegistroCpr.setParcelas(carregarParcelaCpr());
		solicitacaoRegistroCpr.setProdutos(carregarProdutoArea());
		solicitacaoRegistroCpr.setStatus("1 - ACEITO, 2 - LIQUIDADO, 3 - RECUSADO, 4 - CANCELADO");
		solicitacaoRegistroCpr.setStatusAvalia("OK");
		
		
	
		
		return solicitacaoRegistroCpr ;
		
	}
	
private AgentesCprDto carregarAgentes() {
	
	AgentesCprDto agentes = new AgentesCprDto();
	agentes.setCelularEmissor("35999990001");
	agentes.setCepEmissor("38760000");
	agentes.setCredores(carregarCredores());
	agentes.setDetentorCarteira("555");	
	agentes.setDetentorCnpj("20770566000100");
	agentes.setDevedores(carregarDevedores());
	agentes.setEmailEmissor("welinton@cooxupe.com.br");
	agentes.setEmissorAgenciaCredito(null);
	agentes.setEmissorBancoCredito(null);
	agentes.setGarantidores(carregarGarantidores());
	agentes.setNumeroDocumentoEmissor("03383713628");
	agentes.setTipoPessoaEmissor(1L);
	return agentes;
}



private List<CredorDto> carregarCredores() {
	
	List<CredorDto> credores = new ArrayList<>();
	
	CredorDto credor = new CredorDto();
	
	credor.setCep("37800000");
	credor.setCredorNumeroDocumento("93113209000142");
	credor.setCredorStatus(true);
	credor.setCredorTipoPessoa(2L);
	credor.setDataEndosso(formatarDataLocalDateTime());
	credor.setEndossatario(null);
	//credor.setId(11L);


	credores.add(credor);
	
	
	
	return credores;
	
}




private List<DevedorDto> carregarDevedores(){
	
	 List<DevedorDto> devedores = new ArrayList<>();
	 
	 DevedorDto devedor = new DevedorDto();
	 
	 devedor.setDevedorCep("38760000");
	 devedor.setDevedorEmail("welinton@cooxupe.com.br");
	 devedor.setDevedorEndereco("Rua Martimar, 795");
	 devedor.setDevedorNomeRazaoSocial("Guilherme Moreira Borges");
	 devedor.setDevedorNumeroCelular("35992726208");
	 devedor.setDevedorNumeroDocumento("04091003664");
	 devedor.setDevedorStatus(true);
	 devedor.setDevedorTipoPessoa(1L);
	 //devedor.setId(11L);
	 
	 DevedorDto devedor2 = new DevedorDto();
	 
	 devedor2.setDevedorCep("12456000");
	 devedor2.setDevedorEmail("devedor22@mail.com");
	 devedor2.setDevedorEndereco("Rua Begônia, 610");
	 devedor2.setDevedorNomeRazaoSocial("Luciene de Souza Borges");
	 devedor2.setDevedorNumeroCelular("35992726208");
	 devedor2.setDevedorNumeroDocumento("00420065628");
	 devedor2.setDevedorStatus(true);
	 devedor2.setDevedorTipoPessoa(1L);
	 //devedor2.setId(11L);
	 
	 devedores.add(devedor);
	 devedores.add(devedor2);
	 return devedores;
	
}



private List<GarantidorDto> carregarGarantidores(){
	
	 List<GarantidorDto> garantidores = new ArrayList<>();
	 
	 GarantidorDto garantidor = new GarantidorDto();
	 
	 garantidor.setCelularGarantidor("35999994421");
	 garantidor.setEmailGarantidor("welinton@cooxupe.com.br");
	 garantidor.setGarantidorCep("38760000");
	 garantidor.setGarantidorNumeroDocumento("09463054634");
	 garantidor.setGarantidorStatus(true);
	 garantidor.setGarantidorTipoPessoa(1L);
	 //garantidor.setId(11L);
	 garantidor.setNome("Edson Mariano Borges");
	 garantidor.setTipoGarantidor(2L);
	 
	 
	 GarantidorDto garantidor2 = new GarantidorDto();
	 
	 garantidor2.setCelularGarantidor("11111111111");
	 garantidor2.setEmailGarantidor("garantidor2@email.com.br");
	 garantidor2.setGarantidorCep("12456000");
	 garantidor2.setGarantidorNumeroDocumento("93113209000142");
	 garantidor2.setGarantidorStatus(true);
	 //garantidor2.setId(11L);
	 garantidor2.setTipoGarantidor(1L);
	 garantidor2.setNome("Inês Moreira Borges");	
	 garantidor2.setGarantidorTipoPessoa(1L);
	
	 garantidores.add(garantidor);
	 garantidores.add(garantidor2);
	 
	 
	 
	return garantidores;
}



private List<AreaDto> carregarAreas(){
	
List<AreaDto> areas = new ArrayList<>();
	
	AreaDto area = new AreaDto();
	 area.setAreaTotal(new BigDecimal("56.2").setScale(2));
	 area.setCartorio(null);
	 area.setCep("38760000");
	 area.setEndereco(null);
	 area.setFracaoUnitariaDoImovel(null);
	 //area.setIdArea(11L);
	 area.setLatitude(new BigDecimal("-19.091583"));
	 area.setLongitude(new BigDecimal("-46.745514"));
	 area.setMatricula("M8370");
	 area.setNomeFazenda("Fazenda Pasto dos Bois");
	 area.setProdutos(carregarProdutos());
	 area.setProprietario("Geraldo Wesley Moreira Borges|Luciene de Souza Borges");
	 area.setReservaLegal(new BigDecimal(0));
	 area.setStatus(true);
	
	
	
	areas.add(area);
	
	return areas;
	
	
	
	
}


private List<ProdutoDto> carregarProdutos(){
	
	
List<ProdutoDto> produtos = new ArrayList<>();
	
	ProdutoDto produto = new ProdutoDto();
	produto.setAreaNecessariaCpr(new BigDecimal(0));
	produto.setAreaProdutivaTotal(new BigDecimal("215.2"));
	produto.setClasseTipoPh(null);
	produto.setCultura("CAFE");	
	produto.setDescricao("Café especial 90pts");
	produto.setEspecificidadeCultura("Sc de 60kg de Café beneficiado Tipo 6, 86 def. Duro p/ Melhor");
	produto.setFormaAcondicionamento("GRANEL");
	//produto.setIdProduto(11L);
	produto.setIndiceAputracaoProduto(null);
	produto.setInstituicaoResponsavelIndice(null);
	produto.setLocalEntregaCidade("GUAXUPE");
	produto.setLocalEntregaRegional("L01 - LOJA MATRIZ");
	produto.setLocalEntregaUf("MG");
	produto.setPrecoVolume(new BigDecimal("949.29"));
	produto.setProducao(null);
	produto.setProdutividade(null);
	produto.setSafra("2023/2024");
	produto.setStatus(true);
	produto.setUnidadeMedidaVolume("SACA (60KG)");
	produto.setValorRegistro(new BigDecimal("0"));
	produto.setVolumeQuantidade("2127");
	
	
	
	
	produtos.add(produto);
	
	return produtos;
	
}


private ContratoValorCprDto carregarContratoValorCpr() {
	
	ContratoValorCprDto contrato = new ContratoValorCprDto();
	String sequenciaCPR = gerarSequenciaCpr();
	contrato.setAutorizaoRegistroEdeclaroQueFoiDadoBaixaNoRegistroEmQuaisquerOutrasIf(false);
	contrato.setCodigoContratoOperacaoCredito(sequenciaCPR); //XXXX000087
	contrato.setCodigoContratoScr(null);
	contrato.setCodigoMoeda("R$");
	contrato.setDataBaixaOutraIf(formatarDataLocalDateTime());
	contrato.setDataTransacao(LocalDate.now());
	contrato.setIdRegistroOriginalImf("101020303");
	contrato.setIdentificacaoPadronizadaOperacaoCredito(null);
	contrato.setIndexacao("1");
	contrato.setNaturezaOperacao(null);
	contrato.setPercentualIndexador(new BigDecimal("0"));
	contrato.setQuantidadeParcelaContratada(1L);
	contrato.setReferenciaExterna(sequenciaCPR); //XXXX000087
	contrato.setTaxaJurosOperacao(new BigDecimal("0"));
	contrato.setTipoAtivo("CPR");
	contrato.setValorFinanciadoContrato(new BigDecimal("0"));
	contrato.setValorLiquidoCredito(new BigDecimal("0"));
	contrato.setValorTotalCredito(new BigDecimal("9000000"));
	
	return contrato;
}


	private EmissaoCprDto carregarEmissaoCpr() {

	EmissaoCprDto emissao = new EmissaoCprDto();


	emissao.setDataEntrega(LocalDate.now());
 	//emissao.setIdEmissao(11L);
	emissao.setLocalEmissao("GUAXUPE");
	emissao.setRazaoSocialEmissor("COOPERATIVA REGIONAL DE CAFEICULTORES EM GUAXUPE");
	emissao.setTipoCpr("financeiro");

	return emissao;

}


private List<GarantiaDto> carregarGarantia() {


	

	List<GarantiaDto> garantias = new ArrayList<>();
	
	GarantiaDto garantia = new GarantiaDto();
	garantia.setGarantiaStatus(true);
	//garantia.setIdGarantia(11L);
	garantia.setTipoGarantia("penhor");
	
	GarantiaDto garantia2 = new GarantiaDto();
	garantia2.setGarantiaStatus(true);
	//garantia2.setIdGarantia(11L);
	garantia2.setTipoGarantia("imovel");
	
	garantias.add(garantia);
	garantias.add(garantia2);	
	return garantias;
}


private List<ParcelaCprDto> carregarParcelaCpr() {

	List<ParcelaCprDto> parcelas = new ArrayList<>();

	ParcelaCprDto parcela = new ParcelaCprDto();
	parcela.setCodigoControleParcelaContratoIf("12345667");
	parcela.setDataVencimentoParcela(LocalDate.now());
	//parcela.setIdRegistroParcela(2752672L);
	parcela.setNumeroParcela(1L);
	parcela.setPrecoCessaoParcela(new BigDecimal("757.90"));
	parcela.setStatus(3L);
	parcela.setValorParcela(new BigDecimal("757.90"));
	parcela.setValorPrincipalParcela(new BigDecimal("757.90"));

	ParcelaCprDto parcela2 = new ParcelaCprDto();
	parcela2.setCodigoControleParcelaContratoIf("12345668");
	parcela2.setDataVencimentoParcela(LocalDate.now());
	//parcela2.setIdRegistroParcela(2752672L);
	parcela2.setNumeroParcela(2L);
	parcela2.setPrecoCessaoParcela(new BigDecimal("757.90"));
	parcela2.setStatus(4L);
	parcela2.setValorParcela(new BigDecimal("757.90"));
	parcela2.setValorPrincipalParcela(new BigDecimal("757.90"));
	
	ParcelaCprDto parcela3 = new ParcelaCprDto();
	
	parcela3.setCodigoControleParcelaContratoIf("12345669");
	parcela3.setDataVencimentoParcela(LocalDate.now());
	//parcela3.setIdRegistroParcela(2752672L);
	parcela3.setNumeroParcela(3L);
	parcela3.setPrecoCessaoParcela(new BigDecimal("900.99"));
	parcela3.setStatus(1L);
	parcela3.setValorParcela(new BigDecimal("900.99"));
	parcela3.setValorPrincipalParcela(new BigDecimal("900.99"));
	

	parcelas.add(parcela);
	parcelas.add(parcela2);
	parcelas.add(parcela3);

	return parcelas;
}


private List<AreaProdutoDto> carregarAreaProduto() {

	List<AreaProdutoDto> areas = new ArrayList<>();

	AreaProdutoDto area = new AreaProdutoDto();
	area.setAreaTotal(new BigDecimal("9999"));
	area.setCartorio("cartorio");
	area.setCep("12456000");
	area.setEndereco("endereco area");
	area.setFracaoUnitariaDoImovel("fracao unitaria");
	//area.setIdArea(11L);
	area.setLatitude(new BigDecimal("12.5"));
	area.setLongitude(new BigDecimal("11.6"));
	area.setMatricula("456789");
	area.setNomeFazenda("fazenda xyzxpto");
	area.setProprietario("proprietario r2d2");
	area.setReservaLegal(new BigDecimal("100"));
	area.setStatus(true);

	areas.add(area);

	return areas;
}

private List<ProdutoAreaDto> carregarProdutoArea(){
	
	 List<ProdutoAreaDto> produtos = new ArrayList<>();

	 ProdutoAreaDto produto  = new ProdutoAreaDto();
	 
	 produto.setAreaNecessariaCpr(new BigDecimal("105.66"));
	 produto.setAreaProdutivaTotal(new BigDecimal("104.66"));
	 produto.setAreas(carregarAreaProduto());
	 produto.setClasseTipoPh("1234546");
	 produto.setCultura("CAFE");	 
	 produto.setDescricao("Cafe");
	 produto.setEspecificidadeCultura("cafe");
	 produto.setFormaAcondicionamento("SACA");
	 //produto.setIdProduto(11L);
	 produto.setIndiceAputracaoProduto("indice apauracao");
	 produto.setInstituicaoResponsavelIndice("EMATER");
	 produto.setLocalEntregaCidade("Cidade");
	 produto.setLocalEntregaRegional("Regional");
	 produto.setLocalEntregaUf("MG");
	 produto.setPrecoVolume(new BigDecimal("1024.50"));
	 produto.setProducao("producao");
	 produto.setProdutividade("produtividade");
	 produto.setSafra("2023/2024");
	 produto.setSituacao("Situacao");
	 produto.setStatus(false);
	 produto.setUnidadeMedidaVolume("QUILO");
	 produto.setValorRegistro(new BigDecimal("1024.50"));
	 produto.setVolumeQuantidade("15");
 
	 
	 produtos.add(produto);		 
	 

	 return produtos;
	 
}



private String formatarDataLocalDateTime() {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	return LocalDateTime.now().format(formatter);
}

	
	

public String gerarSequenciaCpr() {
	
	
	int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();


	return random.ints(leftLimit, rightLimit + 1)
	  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	  .limit(targetStringLength)
	  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	  .toString();
	
}
	
}
