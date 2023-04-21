package Navegadores;


//import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MiPrimerTest
{
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException {
        //Se coloca la direccion del driver, segun corresponda, (chrome, mozilla, edge...)
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

        //Se crea la instancia u onjeto del Navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);



        //Maximiza el navegador
        driver.manage().window().maximize();

        //Enviamos la URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);

    }

    @Test
    public void MiPrimerTest() throws InterruptedException
    {
        WebElement signOn = driver.findElement(By.className("mouseOut"));
        Thread.sleep(3000);
        signOn.click();
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
