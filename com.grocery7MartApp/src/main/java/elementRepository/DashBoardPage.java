package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class DashBoardPage  {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement dashBoard;

	@FindBy(xpath = "(//div[@class='small-box bg-info'])[1]")
	WebElement managePagesTile;

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[9]")
	WebElement manageUsersMoreInfo;

	@FindBy(xpath = "//h1[text()='List Users']")
	WebElement listUsersText;


	public String getTextDashBoard()
	{
		return gl.getTextMethod(dashBoard);
	}

	public boolean getManagePageTile()
	{
		return gl.isDisplayedMethod(managePagesTile);
	}

	public void clickOnMoreInfo()
	{
		gl.clickElement(manageUsersMoreInfo);
	}
	public String getListUsersText()
	{
		return gl.getTextMethod(listUsersText);
	}


}
