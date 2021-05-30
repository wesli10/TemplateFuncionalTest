package br.com.wes.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.wes.core.BaseTest;
import br.com.wes.pages.HomePage;

public class SaldoTest extends BaseTest {
	
	HomePage page = new HomePage();
	
	
	@Test
	public void testSaldoConta() {
		
		Assert.assertEquals("1024.00", page.ObterSaldoConta("Outra conta"));
		
	}

}
