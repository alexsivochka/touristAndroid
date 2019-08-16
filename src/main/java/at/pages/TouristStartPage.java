package at.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TouristStartPage {

    private SelenideElement tourPageSwitcher = $(By.id("tour_page_switcher"));


    private SelenideElement inputPhone = $(By.id("editPhone"));
    private SelenideElement buttonEnter = $(By.id("buttonEnterEmbeddedLogin"));
    private SelenideElement buttonSkip = $(By.id("button"));

//    $(By.id("places_toolbar")).shouldBe(Condition.enabled).click();
//    $(By.id("meta_string_input")).shouldBe(Condition.enabled).click();
//    $(By.id("meta_string_input")).sendKeys("кафе");
//    $(By.xpath("//*[contains(@text,'Показать')]")).shouldBe(Condition.visible).click();


    @Step("Пропустить демо инфо и перейти к авторизации")
    public void goToAutorizationPage() {
        while(true) {
            if (tourPageSwitcher.isDisplayed()) tourPageSwitcher.click();
            if (inputPhone.isDisplayed()) break;
        }
    }

    @Step("Вход через ввод номера телефона {0}")
    public void enterWithPhone(String phoneNumber) {
        inputPhone.shouldBe(enabled).sendKeys(phoneNumber);
        buttonEnter.shouldBe(enabled).click();
    }

    @Step("Войти нажав на кнопку \"SKIP\"")
    public void enterByClickingSkipButton() {
        buttonSkip.shouldBe(enabled).click();
    }



}
