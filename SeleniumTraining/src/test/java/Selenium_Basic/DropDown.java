package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown
{
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test@Ignore
    public void DropDownWhitClick() throws InterruptedException
    {
      //**** NO SE RECOMIENDA UTILIZAR DAR CLICKS EN LAS LISTAS DESPLEGABLES *********

        WebElement selectDay = driver.findElement(By.className("form-control"));
        selectDay.click();
        Thread.sleep(2000);
        String day = "Saturday";
        String opcionBuscar = String.format("//option[text()='%s']", day);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        option.click();
        Thread.sleep(3000);
    }


    @Test@Ignore
    public void DropDownWithSendKeys() throws InterruptedException
    {
      //Esta opcion es aceptable y de la mismma manera recomendable
      WebElement selectDay = driver.findElement(By.className("form-control"));
      String day = "Friday";
      selectDay.sendKeys(day);
      Thread.sleep(5000);

    }

    @Test
    public void DropDownWithClaseSelect() throws InterruptedException
    {
        String day = "Monday";
        WebElement selectDay = driver.findElement(By.className("form-control"));
        Select selectList = new Select(selectDay);
        //selectList.selectByVisibleText(day);
        //selectList.selectByValue("Tuesday");
        selectList.selectByIndex(5);
        Thread.sleep(2000);

    }

    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }


}
