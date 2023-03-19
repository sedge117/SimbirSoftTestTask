package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class CompletePage {
    private SelenideElement thanksText = $x("//h2[contains(text(), 'Thank you for your order!')]");

    public static final String pageUrl = "https://www.saucedemo.com/checkout-complete.html";

    public CompletePage (){}


    @Step("Произошел редирект на страницу завершения покупки: {text}")
    public CompletePage checkUrl(String text){
        webdriver().shouldHave(url(text));
        return this;
    }
    @Step("Страница Завершения Покупки: Отображается сообщение: “THANK YOU FOR YOUR ORDER”")
    public CompletePage checkText(){
        thanksText.shouldBe(Condition.visible);
        return this;
    }
}
