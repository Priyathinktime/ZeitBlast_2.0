package com.anhtester.projects.website.Zeitblast.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;

public class SkipTracePage {

	
	
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	public void verifytitle() {
		
		wait.until(ExpectedConditions.titleContains(FrameworkConstants.SKIP_TRACE_PAGE_TITLE));
		Assert.assertEquals(WebUI.getPageTitle(),FrameworkConstants.SKIP_TRACE_PAGE_TITLE);
	}

	
	public void clickSkipTracePage() {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
		WebUI.clickElementWithJs(By.xpath(FrameworkConstants.SKIP_TRACE_PAGE));
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_HEADER));
	}

}