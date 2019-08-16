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
        startPage.goToAutorizationPage();
        startPage.enterByClickingSkipButton();
        Selenide.sleep(10000);
    }


}
