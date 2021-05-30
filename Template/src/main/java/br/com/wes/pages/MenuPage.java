package br.com.wes.pages;

import br.com.wes.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void criarMovimentacao() {
		clicarLink("Criar Movimentação");
		
	}
	
	public void resumoMensal() {
		clicarLink("Resumo Mensal");
	}

}
