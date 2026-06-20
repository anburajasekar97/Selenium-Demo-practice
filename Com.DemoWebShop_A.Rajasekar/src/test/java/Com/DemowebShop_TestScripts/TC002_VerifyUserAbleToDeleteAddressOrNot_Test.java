package Com.DemowebShop_TestScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Com.DemowebShop_GenericUtility.BaseTest;

import Com_DemoWebShop_POM.Addresses_page;


public class TC002_VerifyUserAbleToDeleteAddressOrNot_Test extends BaseTest {
	@Test
	
	public void deleteAddress() throws InterruptedException, IOException {
		webdriverutility.javaScriptScrollTillElement(driver, homepage.getAdrresses());
		homepage.getAdrresses().click();
		
		Addresses_page addresspage = new Addresses_page(driver);
		addresspage.getDeletebutton().click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		webdriverutility.switchToAlertAccept(driver);
		
		Thread.sleep(3000);
		webdriverutility.WebPageScreenShot(driver);
		
	}

}
