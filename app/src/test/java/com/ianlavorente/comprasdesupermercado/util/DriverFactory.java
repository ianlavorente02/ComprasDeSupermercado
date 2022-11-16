package com.ianlavorente.comprasdesupermercado.util;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			criarDriver();
		}
		return driver;
	}

	private static void criarDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "0035980732");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.ianlavorente.comprasdesupermercado");
		desiredCapabilities.setCapability("appPackage", "com.ianlavorente.comprasdesupermercado.MainActivity");

		URL remoteUrl = null;
		try {
			remoteUrl = new URL("https://localhost:4723/wd/hub");	
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void finalizarDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
