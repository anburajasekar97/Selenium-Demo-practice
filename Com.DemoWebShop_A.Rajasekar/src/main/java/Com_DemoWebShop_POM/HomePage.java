package Com_DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText = "Log out")
	private WebElement logoutlink;
	
	@FindBy(partialLinkText = "Addresses")
	private WebElement addresseslink;

	public WebElement getLogout() {
		return logoutlink;
	}

	public WebElement getAdrresses() {
		return addresseslink;
	}

}
