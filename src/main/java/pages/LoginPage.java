package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static final String pageUrl = "https://www.saucedemo.com/";
    /*
    По заданию было необходимо использовать при поиске элементов на странице как минимум по одному селектору из
    перечисленных: css, xpath, id. Ниже выполняются все три условия =)
     */
    private SelenideElement loginInput = $(byId("user-name"));
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginButton = $("#login-button");
    private SelenideElement errorLabel =
            $x("//*[text()='Epic sadface: Username and password do not match any user in this service']");


    public LoginPage() {
    }

    @Step("Страница Авторизации: Заполнить поле Username значением {text}")
    public LoginPage sendLogin(String text) {
        loginInput.sendKeys(text);
        return this;
    }

    @Step("Страница Авторизации: Заполнить поле Password значением {text}")
    public LoginPage sendPassword(String text) {
        passwordInput.sendKeys(text);
        return this;
    }

    @Step("Страница Авторизации: Нажать на кнопку LOGIN")
    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    @Step("Страница Авторизации: Появляется сообщение:" +
            " “Epic sadface: Username and password do not match any user in this service”")
    public LoginPage checkError(){
        errorLabel.shouldBe(Condition.visible);
        return this;
    }
}
