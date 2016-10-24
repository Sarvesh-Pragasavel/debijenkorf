package com.debijenkorf.selenium;

import java.util.concurrent.TimeUnit;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;


@PageUrl("/")
public class BkShoppingCartPage extends FluentPage {

	@FindBy(css = ".dbk-off-canvas-pane-toggle_on")
	private FluentWebElement shoppingCart;

	public void waitForResults() {
		await().atMost(10, TimeUnit.SECONDS).until(shoppingCart).displayed();
	}

}
