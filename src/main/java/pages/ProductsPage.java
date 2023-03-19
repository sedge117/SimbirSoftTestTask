package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {
    /*Если предположить, что продукты в магазине не изменны и рюкзак будет всегда первым товаром на странице,
    то можно использовать id кнопки add, т.к. у каждой кнопки на этом сайте отдальный id.*/
    private SelenideElement addBackpackButton = $("#add-to-cart-sauce-labs-backpack");

    /*Если товары будут постоянно меняться и нам нужно просто выбрать любой товар, находящийся на первой позиции.
    Взять первый элемент коллекции карточек товаров:*/
    private SelenideElement addFirstProductButton = $$(".btn_inventory").get(0);

    private SelenideElement shoppingIcon = $(".shopping_cart_link");

    public ProductsPage() {}

    @Step("Страница Продуктов: Положить первый продукт в списке в корзину")
    public ProductsPage clickAdd(){
        addFirstProductButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Страница Продуктов: Нажать на иконку корзины.")
    public ProductsPage clickShop(){
        shoppingIcon.click();
        return this;
    }
}
