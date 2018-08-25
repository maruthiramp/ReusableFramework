/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO TECHASPECT
 *							
 * *****************************************************************************
 */

package com.techaspect.framework.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.techaspect.framework.setup.TestSetUp;
import com.techaspect.framework.testutils.Constants;
import com.techaspect.framework.testutils.DriverManager;

public class HomePage extends BasePage{

		
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(By.className(Constants.OR_FOOTER_DIV)));
	}
	
	public String getHomePageTitle() {
		appLogs.debug("Executing getHomePageTitle");
		return DriverManager.getDriver().getTitle();
	}
	
	public HomePage open() {
		return (HomePage) openPage(HomePage.class);
	}
	public String getSocialShareTitle(String social){
		WebElement footerDiv= DriverManager.getDriver().findElement(By.id(Constants.OR_FOOTER_DIV)); 
		switch (social) {
		case "Facebook":
			footerDiv.findElement(By.xpath(Constants.OR_ICON_FACEBOOK)).click();
			appLogs.debug("Clicked on Facebook icon");
			switchHandle();
			socialPageloadWait(40);
			break;
		case "Twitter":
			footerDiv.findElement(By.xpath(Constants.OR_ICON_TWITTER)).click();
			appLogs.debug("Clicked on Twitter icon");
			switchHandle();
			socialPageloadWait(40);
			break;
		case "LinkedIn":
			footerDiv.findElement(By.xpath(Constants.OR_ICON_LINKEDIN)).click();
			appLogs.debug("Clicked on LinkedIn icon");
			switchHandle();
			socialPageloadWait(40);
			break;
		default:
			break;
		}
		return DriverManager.getDriver().getTitle();
	}
	
	public void switchBack(){
		switchBackFromHandle();
	}
	
	public void socialPageloadWait(long secs) {
		pageloadWait(secs);
	}
	
	public String getLogoUrl(){
		//DriverManager.getDriver().findElement(By.xpath(Constants.OR_LOGO)).click();
		click(findElement(By.xpath(Constants.OR_LOGO2)), "LOGO");
		pageloadWait(20);
		return DriverManager.getDriver().getCurrentUrl();
	}
	
	/*In progress*/
	public void doRegistration(String firstName, String lastName, String email, String phoneNumber, String gender){
		type(findElement(By.xpath(Constants.OR_REGISTER_FIRSTNAME)), firstName, "First Name");	
		type(findElement(By.xpath(Constants.OR_REGISTER_LASTNAME)), lastName, "Last Name");
		type(findElement(By.xpath(Constants.OR_REGISTER_PHONENUMBER)), phoneNumber, "Phone Number");
		click(findElement(By.xpath(Constants.OR_REGISTER_MALE)), "Gender");
	}
	
}
