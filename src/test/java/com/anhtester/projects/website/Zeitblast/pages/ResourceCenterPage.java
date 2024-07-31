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

public class ResourceCenterPage {

	
	
	public void resourcecenternotexist() {
		WebUI.mouseHover(By.xpath(FrameworkConstants.PAGE_ICON));
	
		 boolean isSettingsVisible = isElementPresent(By.xpath(FrameworkConstants.RESOURCE_PAGE));
	        Assert.assertFalse(isSettingsVisible, "Resource center page should not be visible for agent.");
	}
	private boolean isElementPresent(By locator) {
		 try {  
			 return  WebUI.getWebElement(locator).isDisplayed();       
	        } catch (NoSuchElementException e) {
	            return false;
	        }
		 }
	
}