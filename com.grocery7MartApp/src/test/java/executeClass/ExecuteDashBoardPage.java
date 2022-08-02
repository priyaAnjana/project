package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashBoardPage;
import elementRepository.LoginPage;

public class ExecuteDashBoardPage extends BaseClass {
	
	DashBoardPage db;
	LoginPage lp;
	
  @Test
  public void dashBoardIsVisibleAfterSuccessfulLogin() 
  {
	 lp= new LoginPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickOnLogin();
	  db = new DashBoardPage(driver);
	  String actualDashBoardText = "Dashboard";
	  String expectedDashBoardText = db.getTextDashBoard();
	  Assert.assertEquals(actualDashBoardText, expectedDashBoardText);
  }
  @Test
  public void isManagePageTileVisibleOrNot()
  {
	  lp= new LoginPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickOnLogin();
	  db = new DashBoardPage(driver);
	  boolean tile = db.getManagePageTile();
	  Assert.assertTrue(tile);
  }
  @Test
  public void manageUsersMoreInfoArrowClicableOrNot()
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickOnLogin();
	  db = new DashBoardPage(driver);
	  db.clickOnMoreInfo();
	  
	  String expectedText = "List Users";
	  String actualText = db.getListUsersText();
	  Assert.assertEquals(actualText, expectedText);
  }
}
