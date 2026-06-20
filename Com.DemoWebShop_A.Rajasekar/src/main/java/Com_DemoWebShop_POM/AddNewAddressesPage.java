package Com_DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressesPage {
	public AddNewAddressesPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(id="Address_FirstName")
private WebElement firstnametextfield;

@FindBy(id="Address_LastName")
private WebElement lastnametextfield;

@FindBy(id="Address_Email")
private WebElement emailtextfield;

@FindBy(id="Address_CountryId")
private WebElement countrydropdown;

@FindBy(id="Address_City")
private WebElement citytextfield;

@FindBy(id="Address_Address1")
private WebElement addresstextfield;

@FindBy(id="Address_ZipPostalCode")
private WebElement postaltextfield;

@FindBy(id="Address_PhoneNumber")
private WebElement phonenumbertextfield;

@FindBy(xpath="//input[@value='Save']")
private WebElement savebutton;

public WebElement getFirstnametextfield() {
	return firstnametextfield;
}

public WebElement getLastnametextfield() {
	return lastnametextfield;
}

public WebElement getEmailtextfield() {
	return emailtextfield;
}

public WebElement getCountrydropdown() {
	return countrydropdown;
}

public WebElement getCitytextfield() {
	return citytextfield;
}

public WebElement getAddresstextfield() {
	return addresstextfield;
}

public WebElement getPostaltextfield() {
	return postaltextfield;
}

public WebElement getPhonenumbertextfield() {
	return phonenumbertextfield;
}

public WebElement getSavebutton() {
	return savebutton;
}

}
