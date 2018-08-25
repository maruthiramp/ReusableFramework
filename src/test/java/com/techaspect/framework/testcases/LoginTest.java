package com.techaspect.framework.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.techaspect.framework.pageobjects.HomePage;
import com.techaspect.framework.pageobjects.LandingPage;
import com.techaspect.framework.setup.TestSetUp;
import com.techaspect.framework.testutils.Constants;
import com.techaspect.framework.testutils.TestUtils;

public class LoginTest extends TestSetUp{
	
	@Test(dataProviderClass=TestUtils.class, dataProvider="dpone")
	public void testLoginWithValidCreds(Hashtable<String, String> data){
		testCaseLogger.get().assignAuthor(Constants.AUTHOR1);
		testCaseLogger.get().assignCategory(Constants.ACCEPTANCE_CATEGORY);
		if(!data.get("Runmode").equalsIgnoreCase("Y")){
			appLogs.debug("RunMode is set to NO for testdata");
			throw new SkipException("RunMode is set to No for test data");
		}
		navigateToBaseURL();
		LandingPage landingPage = new LandingPage().open();
		HomePage homePage = landingPage.doLoginWithValidCredientials(data.get("email"), data.get("password"));
		appLogs.debug("Entered email and password");
		Assert.assertTrue(homePage.getHomePageTitle().equals(data.get("expected title")));
	}
	
	@Test(dataProviderClass=TestUtils.class, dataProvider="dpone")
	public void testLoginWithInvalidCreds(Hashtable<String, String> data){
		testCaseLogger.get().assignAuthor(Constants.AUTHOR1);
		testCaseLogger.get().assignCategory(Constants.REGRESSION_CATEGORY);
		if(!data.get("Runmode").equalsIgnoreCase("Y")){
			appLogs.debug("RunMode is set to NO for testdata");
			throw new SkipException("RunMode is set to No for test data");
		}
		navigateToBaseURL();
		LandingPage landingPage = new LandingPage().open();
		landingPage.doLoginWithInvalidCredientials(data.get("email"), data.get("password"));	
		appLogs.debug("Entered email and password");
		Assert.assertTrue(landingPage.getLandingPageTitle().equals(data.get("expected title")));
	
	}
}
