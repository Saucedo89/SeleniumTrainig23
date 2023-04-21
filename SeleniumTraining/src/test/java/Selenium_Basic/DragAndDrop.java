package Selenium_Basic;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DragAndDrop
{
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  ***** URL DRAG AND DROP SIN IFRAME ******
        //driver.get("http://demo.seleniumeasy.com/drag-and-drop-demo.html");

        // **** URL DRAG AND DROP CON FRAME *****
        driver.get("https://jqueryui.com/droppable/");

        Thread.sleep(3000);
    }

    @Test@Ignore
    public void DragAndDropActions() throws InterruptedException
    {

        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//span[contains(text(), 'Draggable 1')]"));
        WebElement drop = driver.findElement(By.xpath("//div[@dropzone]"));
        //Primer funcion para realizar drag and drop
        /*actions.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(3000);*/
        //Segunda funcion para realizar drag and drop
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .build()
                .perform();
        Thread.sleep(3000);

    }

    @Test
    public void DragAndDropIframe() throws InterruptedException
    {

        // driver.switchTo().frame(0);  --->> Se utiliza unicamnete cuando tenemos en el dom un tag "iframe"

        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(drag, drop)
                .build()
                .perform();
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
