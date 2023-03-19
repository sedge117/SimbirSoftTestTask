package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

@Test(testName = "Тесты страницы Авторизации")
public class LoginTests {

    @BeforeTest
    public void beforeTest(){
        open(LoginPage.pageUrl);
    }
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Проверка сообщения об ошибке при вводе логина несуществующего пользователя")
    public void checkWrongCredentials(){
        new LoginPage()
                .sendLogin("test")
                .sendPassword("test")
                .clickLogin()
                .checkError();
    }
}
