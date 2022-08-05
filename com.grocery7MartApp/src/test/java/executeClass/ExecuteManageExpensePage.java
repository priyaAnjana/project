package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;
import utility.GeneralUtilities;

public class ExecuteManageExpensePage extends BaseClass {
	LoginPage lp;
	ManageExpensePage mep;


	@Test(priority = 1)
	public void verifyExpenseCategoryIsVisibleWhileClickingOnExpenseCategoryUnderManageExpense() 
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mep = new ManageExpensePage(driver);
		mep.clickOnManageExpense();
		mep.clickOnExpenseCategory();
		boolean expenseCatogoryText = mep.getTextExpenseCatogory();
		Assert.assertTrue(expenseCatogoryText);

	}

	@Test(priority = 2)
	public void verifyAdminCanCreateANewExpenseCategory()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mep = new ManageExpensePage(driver);
		mep.clickOnManageExpense();
		mep.clickOnExpenseCategory();
		mep.clickOnNewButton();
		mep.sendKeysTitle(" Phone");
		mep.clickOnSaveButton();

		boolean alertText = mep.isAlerttextDisplayed();
		Assert.assertTrue(alertText);

	}
	@Test(priority = 3)
	public void verifyAdminCanSearchNewlyCreatedOne()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mep = new ManageExpensePage(driver);
		mep.clickOnManageExpense();
		mep.clickOnExpenseCategory();
		mep.clickOnSearchButton();
		mep.typeSearchTitle(" Phone");
		mep.clickOnNewSearchButton();

		String expectedText = " Phone";
		String actualText = mep.getTextMobilePhone();
		Assert.assertEquals(actualText,expectedText);
	}

	@Test(priority = 4)
	public void verifyAdminCanEditTheCreatedOnes()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mep =new ManageExpensePage(driver);
		mep.clickOnManageExpense();
		mep.clickOnExpenseCategory();
		mep.clickOnSearchButton();
		mep.typeSearchTitle(" Phone");
		mep.clickOnNewSearchButton();
		mep.ClickOnEditIcon();
		mep.clearEdittitle();
		mep.editTitle(" Mobile Phone");
		mep.clickOnUpdateButton();
		boolean alertMsg = mep.isUpdateAlertMsgDisplayed();
		Assert.assertTrue(alertMsg);
	}

	@Test(priority = 5)
	public void verifyAdminCanDeleteTheCreatedOne()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mep =new ManageExpensePage(driver);
		mep.clickOnManageExpense();
		mep.clickOnExpenseCategory();
		mep.clickOnSearchButton();
		mep.typeSearchTitle(" Mobile Phone");
		mep.clickOnNewSearchButton();
		mep.clickOnDeleteButton();
		mep.acceptAlertMsg();

		boolean deletAlertText = mep.isdeleteAlertMsgDisplayedOrNot();
		Assert.assertTrue(deletAlertText);
	}

}
