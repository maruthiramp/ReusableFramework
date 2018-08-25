package com.techaspect.framework.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.techaspect.framework.setup.TestSetUp;
import com.techaspect.framework.testutils.Constants;
import com.techaspect.framework.testutils.TestUtils;

public class rough extends TestSetUp {

	@Test(dataProviderClass=TestUtils.class, dataProvider="dpone")
	public void sample(Hashtable<String, String> data){
		testCaseLogger.get().assignAuthor(Constants.AUTHOR3);
		testCaseLogger.get().assignCategory(Constants.REGRESSION_CATEGORY);
		if(!data.get("Runmode").equalsIgnoreCase("Y")){
			appLogs.debug("RunMode is set to NO for testdata");
			throw new SkipException("RunMode is set to No for test data");
		}
		navigateToBaseURL();
		assertEquals(true, false);
		
	}
}
