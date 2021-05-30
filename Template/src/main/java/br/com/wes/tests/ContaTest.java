package br.com.wes.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;

import br.com.wes.core.BaseTest;
import br.com.wes.pages.ContasPage;
import br.com.wes.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1InserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test2AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do teste");
		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemFalha());
	}
	
	@Test
	public void test4CriarMovimentacao() {
		menuPage.criarMovimentacao();
		
		contasPage.escrever( "data_transacao" , "22/05/2021");
		contasPage.escrever("data_pagamento", "23/05/2021");
		contasPage.escrever("descricao", "qualquer coisa");
		contasPage.escrever("interessado", "interessado qualquer");
		contasPage.escrever("interessado", "qualquer coisa");
		contasPage.escrever("valor", "15784");
		contasPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	

	
}
