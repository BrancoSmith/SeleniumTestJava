package PesquisarMetrica;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PesquisarMetrica {

	@Test
	public void PesquisarMetricaValorAceito() throws InterruptedException {
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

		driver.findElement(
				By.xpath("//*[@id='container']/div/div[2]/div/div[2]/form/div[1]/div[2]/div/div/div[1]"))
				.click();

		Thread.sleep(1000);

		List<WebElement> metricas = driver.findElements(By
				.cssSelector("div[class='select-option']>span"));
		for (WebElement metricas : metrica) {
			if (((WebElement) metricas).getText().trim().equals("-*/-*/*-/*-"))
				((WebElement) metricas).click();
		}

	}
}
