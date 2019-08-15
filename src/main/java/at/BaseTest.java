package at;

import at.utils.AppiumServerJava;
import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

@Log4j
public class BaseTest {

    private AppiumServerJava appiumServer = new AppiumServerJava();

    @BeforeSuite
    public void startAppium() {
        int port = 4723;
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer();
        } else {
            log.info("Appium Server already running on Port - " + port);
        }
    }

    @BeforeClass
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 15000;
        Configuration.browser = TouristDriver.class.getName();
        open();
    }

    @AfterClass
    public void tearDown() {
        close();
    }

    @AfterSuite
    public void stopAppium() {
        int port = 4723;
        if(appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.stopServer();
        } else {
            log.info("Appium Server has already stopped on Port - " + port);
        }
    }
}
