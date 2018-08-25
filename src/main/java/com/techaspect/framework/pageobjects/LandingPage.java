/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO TECHASPECT
 *							
 * *****************************************************************************
 */

package com.techaspect.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.techaspect.framework.testutils.Constants;
import com.techaspect.framework.testutils.DriverManager;

public class LandingPage extends BasePage {

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginInButton);
	}

	@FindBy(id = Constants.OR_EMAIL)
	public WebElement email;

	@FindBy(id = Constants.OR_PASS)
	public WebElement password;

	@FindBy(xpath = Constants.OR_LOGIN)
	public WebElement loginInButton;

	@FindBy(how = How.NAME, using = Constants.OR_FIRSTNAME)
	public WebElement firstName;

	@FindBy(how = How.NAME, using = Constants.OR_LASTNAME)
	public WebElement surName;

	@FindBy(how = How.NAME, using = Constants.OR_REG_EMAIL)
	public WebElement regEmail;

	@FindBy(how = How.NAME, using = Constants.OR_REG_PASS)
	public WebElement regPassword;
	
	public LandingPage open() {
		return (LandingPage) openPage(LandingPage.class);
	}

	public HomePage doLoginWithValidCredientials(String emailtxt, String passwordtxt) {
		type(email, emailtxt, "email");
		type(password, passwordtxt, "Password");
		click(loginInButton, "Log In Button");
		return (HomePage) openPage(HomePage.class);
	}

	public LandingPage doRegistration(String firstNametxt, String surNametxt, String regEmailtxt,
			String regPasswordtxt) {
		type(firstName, firstNametxt, "First Name");
		type(surName, surNametxt, "Sur Name");
		type(regEmail, regEmailtxt, "Registation Email");
		type(regPassword, regPasswordtxt, "Registation Password");
		return this;
	}

	public LandingPage doLoginWithInvalidCredientials(String emailtxt, String passwordtxt) {
		type(email, emailtxt, "email");
		type(password, passwordtxt, "password");
		click(loginInButton, "Log In Button");
		return this;
	}

	public String getLandingPageTitle() {
		appLogs.debug("Executing getLandingPageTitle");
		return DriverManager.getDriver().getTitle();
	}



}
