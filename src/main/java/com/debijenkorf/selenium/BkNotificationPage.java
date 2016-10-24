package com.debijenkorf.selenium;

import java.util.concurrent.TimeUnit;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/")
public class BkNotificationPage extends FluentPage {

	@FindBy(xpath = "//html/body/div[5]/div/div/button")
	private FluentWebElement bekijkButton;

	@Page
	private BkProductDetailPage bkProductDetailPage;

	public void waitForResults() {
		await().atMost(10, TimeUnit.SECONDS).until(bekijkButton).clickable();
	}

	public BkProductDetailPage acceptNotification() {
		bekijkButton.click();
		return bkProductDetailPage;
	}

}
