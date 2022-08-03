package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;

public class ExecuteManageUsersPage extends BaseClass {
	LoginPage lp;
	ManageUsersPage mup;

	@Test(priority = 1)
	public void verifyTheListUsersPageIsDispalyedWhileClickingOnManageUsers() throws IOException 

	{
		lp =new LoginPage(driver);
		mup = new ManageUsersPage(driver);
		lp.enterUserName(mup.readUserName(0, 1));
		lp.enterPassword(mup.readPassword(1, 1));
		lp.clickOnLogin();
		mup.clickOnManageUsers();

		boolean text = mup.IsListUserstextIsdispalyed();
		Assert.assertTrue(text);
	}

	@Test(priority = 2)
	public void verifyUsercnaSearchAUserByUsingName() throws IOException
	{

		lp =new LoginPage(driver);
		mup = new ManageUsersPage(driver);
		lp.enterUserName(mup.readUserName(0, 1));
		lp.enterPassword(mup.readPassword(1, 1));
		lp.clickOnLogin();
		mup.clickOnManageUsers();
		mup.clickOnSearchButton();
		mup.typeName("Alen jk");
		mup.clickOnNewSearchButton();
		mup.scrollToAllenName();

		String expetedName = "Alen jk";
		String actualName = mup.alenNameText();
		Assert.assertEquals(actualName, expetedName);
	}

	@Test(priority = 3)
	public void verifyTheUserCanSearchAUserByUsingEmailId() throws IOException
	{
		lp =new LoginPage(driver);
		mup = new ManageUsersPage(driver);
		lp.enterUserName(mup.readUserName(0, 1));
		lp.enterPassword(mup.readPassword(1, 1));
		lp.clickOnLogin();
		mup.clickOnManageUsers();
		mup.clickOnSearchButton();
		mup.typeEmailId("harshachachi@gmail.com");
		mup.clickOnNewSearchButton();
		mup.scrollToAllenName();

		String expectedUser = "Alen jk";
		String actualUser = mup.alenNameText();
		Assert.assertEquals(actualUser, expectedUser );


	}

	@Test(priority = 4)
	public void verifyTheAdminCanChangeTheStatusOfSoftWareTesterUser() throws IOException
	{
		lp =new LoginPage(driver);
		mup = new ManageUsersPage(driver);
		lp.enterUserName(mup.readUserName(0, 1));
		lp.enterPassword(mup.readPassword(1, 1));
		lp.clickOnLogin();
		mup.clickOnManageUsers();
		mup.scrolltoPaginationTwo();
		mup.clickOnPaginationTwo();
		mup.scrollInToSoftWareTesterStatus();
		mup.clickOnSofteWareTesterStatus();

		boolean statusAlert = mup.IsStatusChangeAlertDispalyed();
		Assert.assertTrue(statusAlert);


	}

}
