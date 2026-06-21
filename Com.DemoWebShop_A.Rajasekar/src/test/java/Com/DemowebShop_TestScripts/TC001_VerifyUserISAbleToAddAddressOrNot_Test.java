package Com.DemowebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemowebShop_GenericUtility.BaseTest;
import Com_DemoWebShop_POM.AddNewAddressesPage;
import Com_DemoWebShop_POM.Addresses_page;

public class TC001_VerifyUserISAbleToAddAddressOrNot_Test extends BaseTest{
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		
		webdriverutility.javaScriptScrollTillElement(driver, homepage.getAdrresses());
		homepage.getAdrresses().click();
		
		 Addresses_page addressespage = new Addresses_page(driver);
		 webdriverutility.javaScriptScrollTillElement(driver, addressespage.getAddnewbutton());
		 addressespage.getAddnewbutton().click();
		 
		 AddNewAddressesPage newaddressespage = new AddNewAddressesPage(driver);
		 newaddressespage.getFirstnametextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 0));
		 newaddressespage.getLastnametextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 1));
		 newaddressespage.getEmailtextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 2));
		 
		 webdriverutility.selectByVisibleText(newaddressespage.getCountrydropdown(),  fileutility.readDataFromExcelFile("Sheet1", 1, 3));
		
		 newaddressespage.getCitytextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 4));
		 newaddressespage.getAddresstextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 5));
		 newaddressespage.getPostaltextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 6));
		 newaddressespage.getPhonenumbertextfield().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 7));
		 newaddressespage.getSavebutton().click();
		 System.out.println("add address is successful");
		 Thread.sleep(3000);
		 webdriverutility.WebPageScreenShot(driver);
		 
	}

}
