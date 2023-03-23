package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;


import static com.codeborne.selenide.Selenide.open;


@Test(testName = "Тесты совершения покупки")
public class BuyTests {
    @BeforeTest(description = "Открыть страницу Логина и произвести Вход в систему")
    public void beforeTest() {
        open(LoginPage.pageUrl);
        new LoginPage()
                .sendLogin("standard_user")
                .sendPassword("secret_sauce")
                .clickLogin();
    }
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка успешной покупки")
    public void checkAccessBuy() {
        new ProductsPage()
                .clickAdd()
                .clickShop();

        new YourCartPage()
                .clickCheckout();

        new YourInformationPage()
                .sendFirstName("test")
                .sendLastName("test")
                .sendZipCode("test")
                .clickContinue();

        new OverviewPage()
                .clickFinish();

        new CompletePage()
                .checkUrl(CompletePage.pageUrl)
                .checkText();
    }
}
