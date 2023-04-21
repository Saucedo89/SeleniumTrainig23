package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick
{
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        Thread.sleep(3000);
    }
    @Test
    public void DoubleClick() throws InterruptedException
    {
        Actions actions = new Actions(driver);

        WebElement doubleClick = driver.findElement(By.id("clickable"));
        actions.doubleClick(doubleClick).perform();
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
