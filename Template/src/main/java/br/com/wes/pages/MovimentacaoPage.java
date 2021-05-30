package br.com.wes.pages;

import static br.com.wes.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.wes.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setTipo (String tipo) {
		selecionarCombo("tipo", tipo);
	}
	
	public void setDataMovimentacao (String datamov) {
		escrever("data_transacao", datamov);
	}
	
	public void setDataPagamento(String datapag) {
		escrever("data_pagamento", datapag);
	}
	
	public void setDescricao (String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	
	public void setStatusPendente() {
		clicarRadio("status_pendente");
	}
	public void clicarExcluirMov() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	public void clicarRemoverConta() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemFalha() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
}
