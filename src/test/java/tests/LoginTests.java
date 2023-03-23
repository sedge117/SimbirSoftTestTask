package tests;

import enums.ErrorLabelEnum;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/*public class Credentials {

}*/
@Test(testName = "Тесты страницы Авторизации")
public class LoginTests {

    @BeforeMethod
    public void beforeTest(){
        open(LoginPage.pageUrl);
    }

    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"test", "test", ErrorLabelEnum.NONE},
                {"test", "", ErrorLabelEnum.CORRECT_LOGIN_ERROR_PASS},
                {"", "test"},
                {"", ""},
                {"1234#", ""},
                {"1234#", "secret_sauce"},
                {"standard_user", "1234#"}
        };
    }

    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "credentials",
            description = "Проверка сообщения об ошибке при вводе логина несуществующего пользователя")
    public void checkWrongCredentials(String login, String password, ErrorLabelEnum label){
        new LoginPage()
                .sendLogin(login)
                .sendPassword(password)
                .clickLogin()
                .checkError2(label);
    }

    @AfterMethod
    public void afterTest(){
        getWebDriver().close();
    }
}
