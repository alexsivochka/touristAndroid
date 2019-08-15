package at.pages;

import at.listeners.AllureOnFailListener;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TouristStartPage {

    private SelenideElement inputPhone = $(By.id("editPhone"));
    private SelenideElement buttonEnter = $(By.id("buttonEnterEmbeddedLogin"));
    private SelenideElement buttonSkip = $(By.id("button"));

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
