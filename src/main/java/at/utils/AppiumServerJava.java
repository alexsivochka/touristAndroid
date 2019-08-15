package at.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;

@Log4j
public class AppiumServerJava {

    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities cap;

    public void startServer() {
        //Set Capabilities
//        cap = new DesiredCapabilities();
//        cap.setCapability("noReset", "false");
//
//        //Build the Appium service
//        builder = new AppiumServiceBuilder();
//        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(4723);
//        builder.withCapabilities(cap);
//        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        try {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
            log.info("Appium server was started successfully........");
        }catch (Exception ex){
            log.error("There are some problems with starting Appium server");
            log.info(ex.getMessage());
        }
    }


    public void stopServer() {
            service.stop();
            log.info("Appium server was stopping........");
    }


    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    public static void main(String[] args) {
        AppiumServerJava appiumServer = new AppiumServerJava();

        int port = 4723;
        if(appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer();
            appiumServer.stopServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
    }

}


