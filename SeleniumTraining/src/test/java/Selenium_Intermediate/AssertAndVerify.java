package Selenium_Intermediate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AssertAndVerify
{



    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(5));
    }

    @Test
    public void VerifyTextPresent()
    {
        // Tanto assert como verify, en selenium se utilizan para averigiar si la entrada dada en la pagina existe o no.
        if(driver.getPageSource().contains("seleniumeasy"))
        {
            System.out.println("Name is present");
        }
        else
        {
            System.out.println("Name is not present");
        }

        String pageSource = driver.getPageSource();
        System.out.println( "Page source is: " + pageSource);


        // Si requerimos que el script se detenga podemos usar asserts
        Assert.assertTrue(driver.getPageSource().contains("Tontin"));

    }

    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }






}
