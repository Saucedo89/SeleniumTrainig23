package Interacciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Interacciones
{
    private WebDriver driver;
    @BeforeTest
    public void Setup() throws InterruptedException {
        //Se coloca la direccion del driver, segun corresponda, (chrome, mozilla, edge...)
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

        //Se crea la instancia u onjeto del Navegador
        driver = new ChromeDriver();

        //Maximiza el navegador
        driver.manage().window().maximize();

        //Enviamos la URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/");

        Thread.sleep(3000);
        driver.manage().deleteAllCookies();

    }

    @Test
    public void Interaciones () throws InterruptedException
    {
        WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.clear();
        userName.sendKeys("REGISTRO");
        Thread.sleep(3000);
        userName.clear();
        Thread.sleep(3000);
        userName.sendKeys("Username");
        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
    }

    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }


}
