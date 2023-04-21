package Selenium_Intermediate;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AlertAndPopup
{

    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        Thread.sleep(3000);
    }
    @Test
    @Ignore
    public void AcceptAlert() throws InterruptedException
    {
        WebElement clickMe = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        clickMe.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @Test
    public void DismissAlert () throws InterruptedException
    {
         //Instancia de Java Script
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Con este codigo podemos crear alertas
        js.executeScript("alert('Esta es mi alerta, cochinota');");
        Thread.sleep(3000);
        String alerta = driver.switchTo().alert().getText();
        System.out.println("Texto en alerta : " + alerta);
        driver.switchTo().alert().dismiss();

    }


    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }







}
