package CadastroMetrica;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastrarMetricaNomeAceitoTest {

	@Test
	public void CadastrarMetricaValorAceito() throws InterruptedException {
		// Traz o driver do chrome
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		// Instancia o driver Chrome
		WebDriver driver = new ChromeDriver();

		// Pega o drive Chrome e inicia a Url desejada
		driver.get("http://192.168.0.128");

		// Instanciando um objeto e procurando o nome do elemento
		WebElement campoUsuario = driver.findElement(By.name("login"));
		WebElement campoSenha = driver.findElement(By.name("senha"));

		// Inserindo dados nos campos
		campoUsuario.sendKeys(new String[] { "hosana.sampaio" });
		campoSenha.sendKeys(new String[] { "12345" });

		// Submentendo o formulario
		campoSenha.submit();

		driver.findElement(By.xpath("//*[@id='sosti']/h4/div")).click();
		Thread.sleep(5000);

		driver.findElement(
				By.xpath("//*[@id='content-nav']/div/div[2]/ul/li[9]/a"))
				.click();

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='content-nav']/div/div[2]/ul/li[9]/ul/li[9]/a"))
				.click();

		Thread.sleep(1000);
		
		driver.findElement(By.id("id_default_button")).click();

		// encontrando elemento e inserindo dados no formulario
		WebElement campoCadastroMetrica = driver.findElement(By
				.name("str_nome_metrica"));
		
		Thread.sleep(1000);
		
		campoCadastroMetrica.sendKeys(new String[] { "Metrica mundo" });

		// clicando em salvar no formulario
		driver.findElement(By.name("btn_salvar")).click();

		// Stopando o teste por 1000ml
		Thread.sleep(10000);

		// Verificando se o obj foi cadastrado
		boolean achouMensagemSalvoComSucesso = driver.getPageSource().contains("Registro salvo com sucesso");
		boolean achouNome = driver.getPageSource().contains("Metrica mundo");

		// retornando uma flag para verificar se o nome foi encontrado
		assertTrue(achouNome);
		assertTrue(achouMensagemSalvoComSucesso);

		Thread.sleep(1000);
		driver.close();

	}

}
