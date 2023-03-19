package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class YourCartPage {
    private SelenideElement checkoutButton = $("#checkout");

    public YourCartPage() {}

    @Step("Страница Корзины: нажать кнопку CHECKOUT")
    public YourCartPage clickCheckout(){
        checkoutButton.shouldBe(Condition.visible).click();
        return this;
    }
}
