package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import settings.ChromeSettings;

public class MainPage extends ChromeSettings {

    public MainPage(WebDriver driver) {this.driver = driver;}


    By loginFieldLocator = By.xpath("//input[contains(@placeholder,'Логин')]");  // Локатор поля логин
    By passFieldLocator = By.xpath("//input[contains(@placeholder,'Пароль')]");  // Локатор поля пароль
    By loginButtonLocator = By.xpath("//button[contains(@type,'submit')]");      // Локатор кнопки Войти
    By loginForm = By.xpath("//h1[contains(@class,'a11y-hidden')]");             // Локатор формы входа в систему
    By loginStatus = By.xpath("//div[contains(@class,'passport-Domik-Form-Error passport-Domik-Form-Error_active')]");  // Локатор алерта\сообщения
    By popUpAlert = By.xpath("//div[contains(@class,'popup__content auth__error')]");     // Локатор алерта полей
    By clearButton= By.xpath("//span[contains(@class,'input__clear input__clear_visibility_visible')]");   // Локатор кнокпи очистить
    By lostPassButton= By.xpath("//a[contains(@title,'вспомнить пароль')]");     // Локатор кнокпи сброса пароля
    By lostHeader= By.xpath("//h1[contains(@class,'p-title')]");                 // Локатор заголовка Сбросить пароль
    By passportButton= By.xpath("//a[contains(@class,'passport-header-header_service')]");   // Локатор кнокпи войти на странице паспорта


    public void clickLoginField()
    {
        driver.findElement(loginFieldLocator).click();
    }

    public void clickPasswordField()
    {
        driver.findElement(passFieldLocator).click();
    }

    public void clickLoginButton()
    {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickClearButton()
    {
        driver.findElement(clearButton).click();
    }
    public void clickLostPassButton()
    {
        driver.findElement(lostPassButton).click();
    }

    public void clickGotoPassPage()
    {
        driver.findElement(passportButton).click();
    }


    public void typeLogin(String email)
    {
        WebElement login = driver.findElement(loginFieldLocator);
        {
         login.click();
         login.clear();
         login.sendKeys(email);
        }
    }

    public void typePass(String password)
    {
        WebElement login = driver.findElement(passFieldLocator);
        {
         login.click();
         login.clear();
         login.sendKeys(password);
        }
    }

    public void logIn (String email, String password)
    {
        typeLogin(sucsessLoginEmail);
        typePass(sucsessLoginPass);
        clickLoginButton();
        System.out.println("Залогинились");
    }

    public void checkNologinAlert()
    {
        Assert.assertEquals("Заполните это поле", driver.findElement(popUpAlert).getText());
        System.out.println("Заполните это поле");
    }
    public void checkNoPassAlert()
    {
        Assert.assertEquals("Заполните это поле", driver.findElement(popUpAlert).getText());
        System.out.println("Заполните это поле");
    }


    public void checkFormPresent()
    {
        Assert.assertEquals("Авторизация", driver.findElement(loginForm).getText(), "Form not Exist");
        System.out.println("Форма авторизации присутсвует");
    }

    public void checkWrongPass()
    {
        Assert.assertEquals("Неверный пароль", driver.findElement(loginStatus).getText());
        System.out.println("Неверный пароль");
    }

    public void checkClearedLogin()
    {
        Assert.assertEquals("", driver.findElement(loginFieldLocator).getText());
    }
    public void checkClearedPassword()
    {
        Assert.assertEquals("", driver.findElement(passFieldLocator).getText());
    }

    public void checkLostPassForm()
    {
        Assert.assertEquals("Восстановление доступа", driver.findElement(lostHeader).getText());
    }




}
