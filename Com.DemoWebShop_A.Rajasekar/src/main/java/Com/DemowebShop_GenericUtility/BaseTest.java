package Com.DemowebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com_DemoWebShop_POM.HomePage;
import Com_DemoWebShop_POM.LoginPage;
import Com_DemoWebShop_POM.Welcome_Page;


public class BaseTest {
	
	public WebDriver driver;
	
	public static WebDriver sdriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileutility = new FileUtility();
	public Welcome_Page welcomepage;
	public LoginPage loginpage;
	public HomePage homepage;
	
	public WebdriverUtility webdriverutility = new WebdriverUtility();
	public WebDriverWait wait;

	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before suite-----Database connection");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("Before test----Report generation");
		
		spark = new ExtentSparkReporter(FrameWorksConstants.extentreports);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("DemoWebShop Addresss Module");
	}
	@BeforeClass
	public void Beforeclass() throws IOException {
		System.out.println("Before class-----Browser setup");
		
	    String browser = fileutility.readDataFromPropertyFile("browser");
		String url = fileutility.readDataFromPropertyFile("url");
		
	//	String browser = System.getProperty("browsername");
	//	String url = System.getProperty("baseurl");
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("chrome browser");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.out.println("edge browser");
			driver = new EdgeDriver();
		}
		else {
		System.out.println("invalid browser");
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	@BeforeMethod
	public void Beforemethod() throws IOException {
		System.out.println("Before method----Login application");
		
		welcomepage = new Welcome_Page(driver);
		welcomepage.getLoginlink().click();
		
		loginpage = new LoginPage(driver);
		loginpage.getEmailtextfield().sendKeys(fileutility.readDataFromPropertyFile("username"));
		loginpage.getPasswordtextfield().sendKeys(fileutility.readDataFromPropertyFile("password"));
		loginpage.getLoginbutton().click();
		
		homepage = new HomePage(driver);
		
	}
	@AfterMethod
	public void Aftermethod() throws InterruptedException {
		System.out.println("After method-----Logout Application");
		Thread.sleep(3000);
		homepage.getLogout().click();
	}
	@AfterClass
	public void Afterclass() throws InterruptedException {
		System.out.println("After class----close browser");
		Thread.sleep(3000);
		driver.quit();
	}

@AfterTest
public void Aftertest() {
	System.out.println("After test---Genrate test report");
	reports.flush();
}
@AfterSuite
public void Aftersuite() {
	System.out.println("After suite----Database disconnected");
}
	

}
