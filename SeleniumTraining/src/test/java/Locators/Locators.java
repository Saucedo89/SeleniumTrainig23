package Locators;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators
{

    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
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
    public void Locators() throws InterruptedException
    {
        //***********Localizador por "ID"*****************
        /*WebElement demoSite = driver.findElement(By.id("site-name"));
        demoSite.click();
        Thread.sleep(3000);*/

        //************Localizador por "name"****************
        /*WebElement userName = driver.findElement(By.name("userName"));
        userName.sendKeys("Automation23");
        Thread.sleep(3000);*/

        //******************Localizador por "ClassName"********************
        /*WebElement logo = driver.findElement(By.className("logo"));
        logo.click();
        Thread.sleep(3000);*/

        //****************Localizador por "Link Text"********************
        /*WebElement demoSite = driver.findElement(By.linkText("Demo Site"));
        demoSite.click();
        Thread.sleep(3000);*/

        //*******************Localizador por "Partial Link Text"*********************
        /*WebElement demoSite = driver.findElement(By.partialLinkText("Demo"));
        demoSite.click();
        Thread.sleep(3000);*/

        //*********************Localizador por "cssSelector"************************
        //WebElement userName = driver.findElement(By.cssSelector("input[name='userName']"));
        //WebElement demoSite = driver.findElement(By.cssSelector("div#site-name"));
        //WebElement demoSite = driver.findElement(By.cssSelector("#site-name"));
        //demoSite.click();
        //WebElement userName = driver.findElement(By.cssSelector("input[type='text'][name='userName']"));
        //userName.sendKeys("Automation");
        //Thread.sleep(3000);

        //************************* X P H A T S ************************
        //Existen dos tipos de xpaths; que son: absoluto y relativo
        //El xphat absoluto por buenas practicas NO se debe utilizar o bien no abusar de el
        //Diferencias
        //El xphat absoluto es toda la ruta del elemento, es decir la ubicacion del mismo y su sintaxis inicia con una diagonal

        //***************** Xphat Absoluto
        /*WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
        userName.sendKeys("Locura");
        */

        //****************Xpath Relativo *********************************
        //El uso de xpath relativo inician con doble // (diagonal)
        // El uso de xpath relativo se realiza por medio de los tags y atributos, entiendase que tags, son: span, img, button, input, etc...

        //1. Un atributo
        /*WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys("REGISTRO");*/

        //2. Dos atributos
        /*WebElement demoSite = driver.findElement(By.xpath("//a[@title='Home' and @style='font-size:32px;']"));
        demoSite.click();*/

        //3. Uso de xpath usando contains, con: "*" o "tag", cabe mencionar que se puede utilizar uno u otro
        WebElement demoSite = driver.findElement(By.xpath("//*[contains(text(), 'Demo Site')]"));
        demoSite.click();
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
