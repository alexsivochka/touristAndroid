package at;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class TouristDriver implements WebDriverProvider {

    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        File file = new File("src/main/resources/tourist.apk");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("app", file.getAbsolutePath());
        capabilities.setCapability("appPackage", "ua.privatbank.tourist");
        capabilities.setCapability("appActivity", "ua.privatbank.tourist.ui.authorization.Authorization");
        capabilities.setCapability("language", "ru");
        capabilities.setCapability("locale", "UK");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");


        try {
            return new AndroidDriver(capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}