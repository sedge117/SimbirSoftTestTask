package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage {
    private SelenideElement firstNameInput = $("#first-name");
    private SelenideElement lastNameInput = $("#last-name");
    private SelenideElement zipCodeInput =$("#postal-code");
    private SelenideElement continueButton = $("#continue");

    public YourInformationPage(){}

    @Step("Страница Информации: Заполнить поле First Name значением {text}")
    public YourInformationPage sendFirstName(String text){
        firstNameInput.sendKeys(text);
        return this;
    }
    @Step("Страница Информации: Заполнить поле Last Name значением {text}")
    public YourInformationPage sendLastName(String text){
        lastNameInput.sendKeys(text);
        return this;
    }
    @Step("Страница Информации: Заполнить поле Zip Code значением {text}")
    public YourInformationPage sendZipCode(String text){
        zipCodeInput.sendKeys(text);
        return this;
    }
    @Step ("Страница Информации: Нажать на кнопку CONTINUE")
    public YourInformationPage clickContinue(){
        continueButton.click();
        return this;
    }
}
