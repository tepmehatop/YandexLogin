package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class ChromeSettings {

    protected WebDriver driver;
    protected String wrongLoginEmail ="test@yandex.ru";
    protected String wrongLoginPass ="12345";
    protected String sucsessLoginEmail ="supertest00932";
    protected String sucsessLoginPass ="Qwer4321";


    @BeforeTest
    public void setUP ()
    {
        String workingDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", workingDir + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru/");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
