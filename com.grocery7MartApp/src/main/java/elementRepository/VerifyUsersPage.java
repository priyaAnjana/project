package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class VerifyUsersPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public VerifyUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

}
