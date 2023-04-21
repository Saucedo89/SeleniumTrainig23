package Selenium_Basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Scroll
{
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Thread.sleep(3000);
    }

    @Test
    public void Scroll() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,380)", "");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(380,420)", "");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(3000);

    }

    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }




}
