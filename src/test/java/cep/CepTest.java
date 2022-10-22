package cep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CepTest {
    WebDriver driver;

    @Test
    public void buscaCep() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(40)));
        driver.findElement(By.id("endereco")).sendKeys("05877160");
        driver.findElement(By.id("btn_pesquisar")).click();
        String endereco = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
        Assert.assertEquals("Texto inválido", "Rua Aurelia de Sousa", endereco );
        driver.findElement(By.xpath("//*[@id=\"btn_nbusca\"]")).click();
        Select optionSkill = new Select(driver.findElement(By.id("tipoCEP")));
        optionSkill.selectByVisibleText("Localidade/Logradouro");
    }
//        @After
//        public void fechaBrowser(){
//        driver.quit();
//   }
}
