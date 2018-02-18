package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PassportPage;
import settings.ChromeSettings;

public class LoginTest extends ChromeSettings {

    @Test(priority = 1, description = "Проверка наличия формы авторизации")
    public void checkForm()throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.checkFormPresent();
    }

    @Test(priority = 2, description = "Проверка на отсуствие пароля")
    public void noLoginMainPage()throws InterruptedException {
       MainPage mainPage = new MainPage(driver);
       mainPage.clickLoginButton();
       mainPage.checkNologinAlert();
    }

    @Test(priority = 3, description = "Проверка на отсуствие логина")
    public void noPassMainPage()throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.typeLogin(wrongLoginEmail);
        mainPage.clickLoginButton();
        mainPage.checkNoPassAlert();
    }

    @Test(priority = 4, description = "Проверка на очистку полей полей ввода")
    public void clearLoginPassFields()throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.typeLogin(sucsessLoginEmail);
        mainPage.clickClearButton();
        mainPage.checkClearedLogin();
        mainPage.typePass(wrongLoginPass);
        mainPage.clickClearButton();
        mainPage.checkClearedPassword();
    }

    @Test(priority = 5, description = "Проверка на неверный пароль")
    public void wrongPassMainPage()throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginField();
        mainPage.typeLogin(sucsessLoginEmail);
        mainPage.typePass(wrongLoginPass);
        mainPage.clickLoginButton();
        mainPage.checkWrongPass();
    }

    @Test(priority = 6, description = "Проверка не верный аккаунт")
    public void wrongAccount() throws InterruptedException {
        PassportPage passportPage = new PassportPage(driver);
        passportPage.clickLoginField();
        passportPage.typeLogin(wrongLoginEmail);
        passportPage.typePass(wrongLoginPass);
        passportPage.clickLoginButton();
        passportPage.checkAccountNotExist();

    }

    @Test(priority = 7, description = "Проверка на отсуствие пароля")
    public void noPassPassportPage() throws InterruptedException {
        PassportPage passportPage = new PassportPage(driver);
        passportPage.clickLoginField();
        passportPage.typeLogin(wrongLoginEmail);
        passportPage.clickLoginButton();
        passportPage.noPassExist();
    }

    @Test(priority = 8, description = "Проверка на отсуствие логина")
    public void noLoginPassportPage() throws InterruptedException {
        PassportPage passportPage = new PassportPage(driver);
        passportPage.clickLoginField();
        passportPage.typePass(wrongLoginPass);
        passportPage.clickLoginButton();
        passportPage.noLoginExist();
    }


    @Test(priority = 9, description = "Проверка на успешный вход")
    public void LoginSuccess() throws InterruptedException {
        PassportPage passportPage = new PassportPage(driver);
        passportPage.clickLoginField();
        passportPage.typeLogin(sucsessLoginEmail);
        passportPage.typePass(sucsessLoginPass);
        passportPage.clickLoginButton();
        passportPage.checkLoginSuccess();
        passportPage.clickAvatarButton();
        passportPage.clickLogOutButton();
        passportPage.checkFormPresent();
    }

    @Test(priority = 10, description = "Проверка кнопки Вспомнить пароль")
    public void lostPassword() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLostPassButton();
        mainPage.checkLostPassForm();
        mainPage.clickGotoPassPage();
    }

}
