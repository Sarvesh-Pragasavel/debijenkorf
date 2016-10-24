package com.debijenkorf.selenium;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import com.debijenkorf.util.ReportingUtil;
import static org.assertj.core.api.Assertions.*;


@PageUrl("/")
public class BkHomePage extends FluentPage {

	@FindBy(xpath = "//input[@type='search']")
	private FluentWebElement searchInputBorder;
	@FindBy(css = ".gsfi")
	private FluentWebElement searchInput;
	@FindBy(css = ".dbk-form--submit")
	private FluentWebElement searchButton;

	@Page
	private BkSearchResultPage bkSearchResultPage;

	public BkHomePage typeTextIn() {
		assertThat(this.getDriver().getTitle()).contains("De Bijenkorf");
		ReportingUtil.takeScreenShot(this, "Homepage");
		searchInputBorder.click();
		searchInputBorder.write("jeans");
		return this;
	}

	public BkSearchResultPage startSearch() {
		searchButton.click();
		return bkSearchResultPage;
	}

}
