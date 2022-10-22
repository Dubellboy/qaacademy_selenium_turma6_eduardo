package google;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    WebDriver driver;
    @Test

    public void testGoogle() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Piano");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[2]/div/div[2]/div[1]/span")).click();
        driver.findElement(By.xpath("/html/body//li[2]/div/div[2]/div[1]/span")).click();
        String text = driver.findElement(By.xpath("//block-component/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div/h2/span")).getText();
        Assert.assertEquals("Texto inválido", "Ver resultados relacionados", text);


        }
    @After
    public void fecharBrowser(){

        driver.quit();
    }
}


