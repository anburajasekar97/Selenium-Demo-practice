package Com_DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addresses_page {
public Addresses_page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}	

@FindBy(xpath="//input[@value='Delete']")
private WebElement deletebutton;

@FindBy(xpath="//input[@value='Add new']")
private WebElement addnewbutton;

public WebElement getDeletebutton() {
	return deletebutton;
}

public WebElement getAddnewbutton() {
	return addnewbutton;
}

}
