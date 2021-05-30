package br.com.wes.core;

import static br.com.wes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.wes.pages.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		page.acessarTelaInicial();
		
		page.setEmail("testetestando@test.com");
		page.setSenha("testtest123");
		page.entrar();
		
	}
	
	@After
	public void finaliza(){
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
