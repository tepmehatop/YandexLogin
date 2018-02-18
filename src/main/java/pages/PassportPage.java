package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import settings.ChromeSettings;

public class PassportPage extends ChromeSettings {
    public PassportPage (WebDriver driver) {this.driver = driver;}


    By loginFieldLocator = By.xpath("//input[contains(@name,'login')]");    // Локатор поля логин
    By passFieldLocator = By.xpath("//input[contains(@name,'passwd')]");    // Локатор поля пароль
    By loginButtonLocator = By.xpath("//button[contains(@type,'submit')]"); // Локатор кнопки Войти
    By loginStatus = By.xpath("//div[contains(@class,'passport-Domik-Form-Error passport-Domik-Form-Error_active')]"); // Локатор алерта\сообщения
    By loggedInField = By.xpath("//div[contains(@class,'mail-User-Name')]"); // Локатор имени залогиненого юзера
    By avatarButton = By.xpath("//span[contains(@id,'recipient-1')]");       // Локатор аватарки
    By logOutButton = By.xpath("//a[contains(@data-metric,'Выход')]");       // Локатор кнопки Выйти
    By loginForm = By.xpath("//h1[contains(@class,'a11y-hidden')]");         // Локатор формы логина
    By capchaExist = By.xpath("//img[contains(@class,'captcha__image')]");   // Локатор капчи
    By passportSubmitButton = By.xpath("//span[contains(@class,'passport-Button-Text')]");  // Локатор кнопки Войти

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
    public void clickPassportSubmitButton()
    {
        driver.findElement(passportSubmitButton).click();
    }

    public void clickAvatarButton()
    {
        driver.findElement(avatarButton).click();
    }

    public void clickLogOutButton()
    {
        driver.findElement(logOutButton).click();
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

    public void noLoginExist()
    {
        Assert.assertEquals("Логин не указан", driver.findElement(loginStatus).getText());
        System.out.println("Логин не указан");
    }

    public void noPassExist()
    {
        Assert.assertEquals("Пароль не указан", driver.findElement(loginStatus).getText());
        System.out.println("Пароль не указан");
    }

    public void checkAccountNotExist()
    {
        Assert.assertEquals("Такого аккаунта нет", driver.findElement(loginStatus).getText());
        System.out.println("Такого аккаунта нет");
    }

    public void checkLoginSuccess()
    {
        Assert.assertEquals("supertest00932", driver.findElement(loggedInField).getText());
        System.out.println("Мы зашли");
    }

    public void checkFormPresent()
    {
        Assert.assertEquals("Авторизация", driver.findElement(loginForm).getText(), "Form not Exist");
        System.out.println("Форма авторизации присутсвует");
    }

    public void checkCapchaAppears()
    {
        Assert.assertTrue(driver.findElement(capchaExist).isDisplayed());
    }



}
