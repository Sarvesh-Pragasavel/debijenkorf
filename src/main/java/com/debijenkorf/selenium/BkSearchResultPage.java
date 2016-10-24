package com.debijenkorf.selenium;


import java.util.concurrent.TimeUnit;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import com.debijenkorf.util.ReportingUtil;
import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("/product-lister-page.html")
public class BkSearchResultPage extends FluentPage {

	@Page
	private BkProductDetailPage bkProductDetailPage;
	
	@FindBy(css = ".dbk-productlist--item")
	private FluentList<FluentWebElement> results;

	public void waitForResults() {
		await().atMost(10, TimeUnit.SECONDS).until(results).displayed();
		System.out.println(results.get(1).html());
	}

	public BkProductDetailPage selectSecondProduct() {
		assertThat(this.getDriver().getTitle()).contains("jeans");
		ReportingUtil.takeScreenShot(this, "Search results");
		FluentWebElement secondProduct = results.get(1);
		FluentList<FluentWebElement> anchors = secondProduct.$(By.tagName("div"));
		anchors.get(1).click();
		return bkProductDetailPage;
	}
	

}
