package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageOrderPage;

public class ExecuteManageOrderPage extends BaseClass {

	LoginPage lp;
	ManageOrderPage mop;
	@Test
	public void  verifyTheAdminCanSearchAnOrderByUsingOrderId() 
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin();

		mop = new ManageOrderPage(driver);
		mop.clickOnManageOrder();
		mop.clickOnsearchbutton();
		mop.typeOrderId("639");
		mop.clickONewSeacrchButton();
		String expectedResult = "639";
		String actualResult = mop.getTextOfOrderIdsearchresult();
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void vrifyTheAdminCanViewTgeOrderDetailsOfSearchOrder()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickOnLogin(); 

		mop = new ManageOrderPage(driver);
		mop.clickOnManageOrder();
		mop.clickOnsearchbutton();
		mop.typeOrderId("639");
		mop.clickONewSeacrchButton();
		mop.scrollIntoViewElement();
		mop.elementTOBeClick();
		mop.clickOnViewButton();
		boolean text = mop.isOrderDeatilsDisplayed();
		Assert.assertTrue(text);

	}
}
