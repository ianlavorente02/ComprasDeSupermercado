package com.ianlavorente.comprasdesupermercado;

import com.ianlavorente.comprasdesupermercado.util.DriverFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class UnitTest {
	private AndroidDriver driver;

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver();
	}

	@Test
	public void name() {
		MobileElement el1 = (MobileElement) driver.findElementById("com.ianlavorente.comprasdesupermercado:id/checkBoxCarne");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ianlavorente.comprasdesupermercado:id/buttonTotal");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ianlavorente.comprasdesupermercado:id/radioButtonNenhum");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ianlavorente.comprasdesupermercado:id/editTextPagar");
		el4.sendKeys("40");
		MobileElement el5 = (MobileElement) driver.findElementById("com.ianlavorente.comprasdesupermercado:id/buttonPagar");
		el5.click();
	}

	@After
	public void tearDown() {
		DriverFactory.finalizarDriver();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
