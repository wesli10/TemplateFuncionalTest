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
	public void test4CriarMovimentação() {
		menuPage.criarMovimentacao();
		
		movPage.setDataMovimentacao("24/05/2021");
		movPage.setDataPagamento("25/05/2021");
		movPage.setDescricao("Movimentação de Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("1024");
		movPage.setConta("Outra conta");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
		
		
	}
	
	@Test
	public void test5ValidarCamposObrigatóriosMovimentação() {
		menuPage.criarMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	
	}
	
	@Test
	public void test6ValidarMovimentaçãoFutura() {
		menuPage.criarMovimentacao();
		
		movPage.setDataMovimentacao("01/06/2021");
		movPage.setDataPagamento("30/05/2021");
		movPage.setDescricao("Movimentação Futura");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("2035");
		movPage.setConta("Outra conta");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movPage.obterMensagemFalha());
	}
	
	@Test
	public void test7RemoverMovimentação () {
		menuPage.resumoMensal();
		
		movPage.clicarExcluirMov();
		
		Assert.assertEquals("Movimentação removida com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test8RemoverContacomMov() {
		menuPage.acessarTelaListarConta();
		movPage.clicarRemoverConta();
		
		Assert.assertEquals("Conta em uso na movimentações", movPage.obterMensagemFalha());
		
	}

}
