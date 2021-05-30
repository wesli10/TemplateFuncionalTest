package br.com.wes.pages;

import br.com.wes.core.BasePage;

public class HomePage extends BasePage {
	
	public String ObterSaldoConta(String nome) {
			return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}

}
