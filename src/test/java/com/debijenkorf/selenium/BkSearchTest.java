package com.debijenkorf.selenium;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Wait
public class BkSearchTest extends FluentTest {

	@Page
	private BkHomePage bkMainPage;

	@Test
	public void visitHomePage() {
		BkSearchResultPage bkSearchResultPage = goTo(bkMainPage).typeTextIn().startSearch();
		bkSearchResultPage.waitForResults();
		BkProductDetailPage bkProductDetailPage = bkSearchResultPage.selectSecondProduct();
		bkProductDetailPage.waitForResults();
		BkNotificationPage bkNotificationPage = bkProductDetailPage.selectProductVariant().addToShoppingCart();
		bkNotificationPage.waitForResults();
		bkProductDetailPage = bkNotificationPage.acceptNotification();
		bkProductDetailPage.waitForShoppingCartButton();
		bkProductDetailPage.showShoppingCart();		
		
	}

	@Override
	public WebDriver newWebDriver() {
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Jar\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver =new FirefoxDriver();	
		return driver;
	}

	@Override
	public String getBaseUrl() {
		return "https://m.debijenkorf.nl/";
	}

	@Override
	public String getWebDriver() {
		return "firefox";
	}

}
