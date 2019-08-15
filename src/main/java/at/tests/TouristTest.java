package at.tests;

import at.BaseTest;
import at.listeners.AllureOnFailListener;
import at.pages.TouristStartPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Listeners(AllureOnFailListener.class)
public class TouristTest  extends BaseTest {

    private TouristStartPage startPage;


    @Test
    public void testMethod() {
        startPage = new TouristStartPage();
        $(By.id("places_toolbar")).shouldBe(Condition.enabled).click();
        $(By.id("meta_string_input")).shouldBe(Condition.enabled).click();
        $(By.id("meta_string_input")).sendKeys("кафе");
        sleep(5000);
        $(By.xpath("//*[contains(@text,'Показать')]")).shouldBe(Condition.visible).click();
        sleep(3000);

//        startPage.enterWithPhone("+380112223344");
//        startPage.enterByClickingSkipButton();
//        Selenide.sleep(10000);
    }


}
