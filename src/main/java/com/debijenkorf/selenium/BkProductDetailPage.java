package com.debijenkorf.selenium;

import java.util.concurrent.TimeUnit;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import com.debijenkorf.util.ReportingUtil;
import static org.fluentlenium.core.filter.FilterConstructor.*;


@PageUrl("/")
public class BkProductDetailPage extends FluentPage {
	
	@FindBy(css = ".detail-page-template")	
	private FluentWebElement productDetail;
	
	@FindBy(css = "select.dbk-form--input")	
	private FluentWebElement selectProductVariant;

	@FindBy(css = ".dbk-btn_primary")
	private FluentWebElement addToCartButton;

	@FindBy(css = ".dbk-icon-r_bag")
	private FluentWebElement showShoppingCart;

	@Page
	private BkProductDetailPage bkProductDetailPage;
	
	@Page
	private BkNotificationPage bkNotificationPage;

	@Page
	private BkShoppingCartPage bkShoppingCartPage;
	

	public void waitForResults() {
		await().atMost(10, TimeUnit.SECONDS).until(productDetail).displayed();
	}
	
	public BkProductDetailPage selectProductVariant() {
		ReportingUtil.takeScreenShot(this, "Product detail");
		selectProductVariant.click();
		selectProductVariant.$(By.tagName("option"),with("text").notContains("(Uitverkocht)")).click();
		ReportingUtil.takeScreenShot(this, "Product variant");
		return bkProductDetailPage;
	}

	public BkNotificationPage addToShoppingCart() {
		addToCartButton.click();
		return bkNotificationPage;
	}
	
	public void waitForShoppingCartButton() {
		await().atMost(10, TimeUnit.SECONDS).until(showShoppingCart).clickable();
		System.out.println(showShoppingCart.html());
	}

	public BkShoppingCartPage showShoppingCart() {
		showShoppingCart.click();
		ReportingUtil.takeScreenShot(this, "Product basket");
		return bkShoppingCartPage;
	}

}
