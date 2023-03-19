package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private SelenideElement finishButton = $("#finish");

    public OverviewPage(){}

    @Step("Страница Обзора Заказа: Нажать кнопку FINISH")
    public OverviewPage clickFinish(){
        finishButton.shouldBe(Condition.visible).click();
        return this;
    }
}
