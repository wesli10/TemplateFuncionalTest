package br.com.wes.tests;

import java.util.Arrays;
import java.util.List;

import br.com.wes.core.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.wes.pages.MenuPage;
import br.com.wes.pages.MovimentacaoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage(); 
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test4CriarMovimenta��o() {
		menuPage.criarMovimentacao();
		
		movPage.setDataMovimentacao("24/05/2021");
		movPage.setDataPagamento("25/05/2021");
		movPage.setDescricao("Movimenta��o de Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("1024");
		movPage.setConta("Outra conta");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
		
		
	}
	
	@Test
	public void test5ValidarCamposObrigat�riosMovimenta��o() {
		menuPage.criarMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio", "Data do pagamento � obrigat�rio", "Descri��o � obrigat�rio", "Interessado � obrigat�rio", "Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	
	}
	
	@Test
	public void test6ValidarMovimenta��oFutura() {
		menuPage.criarMovimentacao();
		
		movPage.setDataMovimentacao("01/06/2021");
		movPage.setDataPagamento("30/05/2021");
		movPage.setDescricao("Movimenta��o Futura");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("2035");
		movPage.setConta("Outra conta");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", movPage.obterMensagemFalha());
	}
	
	@Test
	public void test7RemoverMovimenta��o () {
		menuPage.resumoMensal();
		
		movPage.clicarExcluirMov();
		
		Assert.assertEquals("Movimenta��o removida com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test8RemoverContacomMov() {
		menuPage.acessarTelaListarConta();
		movPage.clicarRemoverConta();
		
		Assert.assertEquals("Conta em uso na movimenta��es", movPage.obterMensagemFalha());
		
	}

}
